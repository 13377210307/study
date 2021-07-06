一：如何理解进程与线程
1：进程：执行程序的一次执行过程，是系统资源分配的单位
2：线程：一个进程包含多个线程，一个进程至少有一个线程，线程是cpu调度和执行的单位

二：常见方法
1：start：启动一个新线程，在新的线程运行run方法中的代码：start方法只是让线程进入就绪，方法体中的代码并不一定立刻运行（需要等待cpu调度），每个线程对象的satrt方法只能调用一次，调用多次会出现异常
2：run：新线程启动后会调用的方法：如果在构造Thread对象时传递了Runnable参数，则线程启动后会调用Runnable中的run方法，否则默认不执行任何操作。但可以创建Thread的子类对象，来覆盖默认行为
3：join：等待线程运行结束
4：setPriority：设置线程优先级（1~10）；较大优先级能提高该线程被cpu调度的几率
5：getState：获取线程状态：6个状态通过enum表示：NEW、RUNNABLE、BLOCKED、WAITING、TIMED_WAITING、TERMINATED
6：isInterrupted：判断是否被打断：不会清除打断标记
7：isAlive：线程是否存活（是否运行完毕）
8：interrupt：打断线程：若打断线程正在sleep、wait、join会导致被打断线程抛出异常，并清除打断标记，如果线程正在运行，则会设置打断标记。
9：sleep：让当前执行的线程休眠n毫秒，休眠时让出cpu的时间片给其他线程
10：yield：让出当前线程对cpu的使用（主要为了测试和调试）

三：主线程和守护线程
默认情况下，java进程需要等待所有线程都运行结束，才会结束。有一种特殊的线程叫做守护线程，只要其他非守护线程运行结束了，即使守护线程的代码没有执行完，也会强制结束。
守护线程的应用：
1：垃圾回收器就是一种守护线程
2：tomcat中的acceptor和poller线程都是守护线程，所以tomcat接收到shutdown命令后，不会等待他们处理完当前请求。

四：线程状态
五种状态：
1：初始状态：即Thead thread = new Thead(); 
2：就绪状态：指该线程已经被创建，等待cpu给它分配时间片就可运行
3：运行状态：指线程获取了CPU时间片，正在运行，当CPU时间片用完，线程会转换至【可运行状态】，等待 CPU再次分配时间片，会导致我们前面讲到的上下文切换
4：阻塞状态
如果调用了阻塞API，如BIO读写文件，那么线程实际上不会用到CPU，不会分配CPU时间片，会导致上下文切换，进入【阻塞状态】
等待BIO操作完毕，会由操作系统唤醒阻塞的线程，转换至【可运行状态】
与【可运行状态】的区别是，只要操作系统一直不唤醒线程，调度器就一直不会考虑调度它们，CPU就一直不会分配时间片
5：终止状态：表示线程已经执行完毕，生命周期已经结束，不会再转换为其它状态
六种状态：
1：NEW 跟五种状态里的初始状态是一个意思
2：RUNNABLE 是当调用了 start() 方法之后的状态，注意，Java API 层面的 RUNNABLE 状态涵盖了操作系统层面的【可运行状态】、【运行状态】和【io阻塞状态】（由于 BIO 导致的线程阻塞，在 Java 里无法区分，仍然认为是可运行）
3：BLOCKED 
4：WAITING 
5：TIMED_WAITING 
6：TERMINATED

五：线程安全
1：临界区：
一个程序运行多个线程本身没有问题；
问题出现在多个线程共享资源的时候
多个线程同时对共享资源进行读操作本身也没有问题
问题出现在对对共享资源同时进行读写操作时就有问题了
先定义一个叫做临界区的概念：一段代码内如果存在对共享资源的多线程读写操作，那么称这段代码为临界区

2：竞态条件
多个线程在临界区执行，那么由于代码指令的执行不确定而导致的结果问题，称为竞态条件

3：变量的线程安全分析
1：成员变量和静态变量的线程安全分析
如果没有变量没有在线程间共享，那么变量是安全的
如果变量在线程间共享
如果只有读操作，则线程安全
如果有读写操作，则这段代码是临界区，需要考虑线程安全
2：局部变量线程安全分析
局部变量【局部变量被初始化为基本数据类型】是安全的
局部变量引用的对象未必是安全的
如果局部变量引用的对象没有引用线程共享的对象，那么是线程安全的
如果局部变量引用的对象引用了一个线程共享的对象，那么要考虑线程安全的

六：synchronized
1：synchronized 解决方案
为了避免临界区中的竞态条件发生，由多种手段可以达到
阻塞式解决方案：synchronized ，Lock
非阻塞式解决方案：原子变量
现在讨论使用synchronized来进行解决，即俗称的对象锁，它采用互斥的方式让同一时刻至多只有一个线程持有对象锁，其他线程如果想获取这个锁就会阻塞住，这样就能保证拥有锁的线程可以安全的执行临界区内的代码，
不用担心线程上下文切换
注意 虽然 java 中互斥和同步都可以采用 synchronized 关键字来完成，但它们还是有区别的： 互斥是保证临界区的竞态条件发生，同一时刻只能有一个线程执行临界区的代码 
同步是由于线程执行的先后，顺序不同但是需要一个线程等待其它线程运行到某个点。

2：synchronized语法
synchronized(对象) // 线程1获得锁， 那么线程2的状态是(blocked)
{
 临界区
}

3：synchronized用法
 class Test{
        public synchronized void test() {
        }
    }
    //等价于
    class Test{
        public void test() {
            synchronized(this) {
            }
        }
    }
//------------------------------------------------------------------------------------------------
    class Test{
        public synchronized static void test() {
        }
    }
   // 等价于
    class Test{
        public static void test() {
            synchronized(Test.class) {
            }
        }
    }
  
  
 六：线程通讯（wait...notify）
 
 1：wait与sleep的区别
 wait会释放锁，但sleep不会释放锁
 
 2：notify
 notify会随机唤醒一个等待的线程；哪个锁对象调用的notify就会随机唤醒持有该锁对象的线程
 使用notify的时候需要加synchronized
 
 3：wait...notify的使用
 synchronized(LOCK) {
   while(条件不成立) {
      LOCK.wait();
   }
   // 干活
 }
 
 // 另一个线程
  synchronized(LOCK) {
     LOCK.notifyAll();
  }
  
 4：异步模式之生产者/消费者
 要点
 （1）与前面的保护性暂停中的GuardObject不同，不需要产生结果和消费结果的线程一一对应
 （2）消费队列可以用来平衡生产和消费的线程资源
 （3）生产者仅负责生产结果数据，不关心数据如何处理，而消费者专心处理结果数据
 （4）消息队列是有容量限制的，满时不会再加入数据，空时不会再消耗数据
 （5）jdk中各种阻塞队列，采用的就是这种模式
 
 5：park与unPark
 (1) 与Object的wait和notify相比
   （1）wait，notify和notifyAll必须配合Object Monitor一起使用，而park和unPark不必
   （2）park和unPark是以线程为单位来阻塞和唤醒线程，而notify只能随机唤醒一个等待线程；对于notifyAll是唤醒所有等待线程
   （3）park和unPark可以先unPark，而wait和notify不能先notify
 (2) park unpark 原理
     每个线程都有自己的一个 Parker 对象，由三部分组成 _counter， _cond和 _mutex
     （1）打个比喻线程就像一个旅人，Parker 就像他随身携带的背包，条件变量 _ cond就好比背包中的帐篷。_counter 就好比背包中的备用干粮（0 为耗尽，1 为充足）
     （2）调用 park 就是要看需不需要停下来歇息
           如果备用干粮耗尽，那么钻进帐篷歇息
           如果备用干粮充足，那么不需停留，继续前进
     （3）调用 unpark，就好比令干粮充足
           如果这时线程还在帐篷，就唤醒让他继续前进
           如果这时线程还在运行，那么下次他调用 park 时，仅是消耗掉备用干粮，不需停留继续前进
             因为背包空间有限，多次调用 unpark 仅会补充一份备用干粮
 
 
 
 七：线程池
 1：线程池状态：ThreadPoolExecutor使用int的高3位来表示线程池状态，低29位表示线程数量
 
 状态名                 高3位                接收新任务           处理阻塞队列任务             说明
 RUNNING               111                  是                   是               
 SHUTDOWN              000                  否                   是           不会接收新任务，但会处理阻塞队列剩余任务
 STOP                  001                  否                   否           会中断正在执行的任务，并抛弃阻塞队列任务
 TIDYING               010                                                   任务全部执行完毕，活动线程为0即将进入终结
 TERMINATED            011                                                   终结状态
 
 2：构造方法
 （1）corePoolSize：核心线程数（最多保留的线程数）
 （2）maximumPoolSize：最大线程数目
 （3）keepAliveTime：生存时间-针对救急线程
 （4）unit：时间单位-针对救急线程
 （5）workQueue：阻塞队列
 （6）threadFactory：线程工厂-可以为线程创建时起个名字
 （7）handler：拒绝策略
 
 3：工作方式：
 救急线程与核心线程的最大区别就是救急线程有存活时间：最大线程数 = 核心线程 + 救急线程；救急线程执行完任务之后会销毁，而核心线程会保留在线程池中
 （1）线程池刚开始没有线程，当一个任务提交给线程池后，线程池会创建一个新线程来执行任务
 （2）当线程数达到corePoolSize并没有线程空闲的时候，这时再加入任务，新加的任务会被加入到阻塞队列中排队，直到有空闲线程
 （3）如果队列选择了有界队列，那么任务超过了队列大小时，会创建最大线程数 - 核心线程数的救急线程来救急
 （4）如果线程达到maximumPoolSize仍然有新任务这时会执行拒绝策略。拒绝策略有四种实现：
   （1）AbortPolicy让调用者抛出RejectedExecutionException异常，这时默认策略
   （2）CallerRunsPolicy让调用者运行任务
   （3）DiscardPolicy放弃本次任务
   （4）DiscardOldestPolicy放弃队列中最早的任务，当前任务取代
        Dubbo的实现：在抛出RejectedExecutionException异常之前记录日志，并dump线程栈信息，方便定位问题
        Netty的实现：创建一个新线程来执行任务
        ActiveMq的实现：带超时等待60s尝试放入队列，类似自定义的拒绝策略
 （5）当高峰过去之后，超过核心线程数的救急线程如果一段时间没有任务做，需要结束节省资源，这个时间由keepAliveTime和unit控制
 
4：线程池类型
（1）newFixedThreadPool
    特点：
     （1）核心线程数==最大线程数（没有救急线程被创建），因此无需超时时间
     （2）阻塞队列是无界的，可以放任意数量的任务
    评价：
     适用于任务量已知，相对耗时的任务
    默认构造方法：
   public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
           return new ThreadPoolExecutor(nThreads, nThreads,
                                         0L, TimeUnit.MILLISECONDS,
                                         new LinkedBlockingQueue<Runnable>(),
                                         threadFactory);
   }
   
（2）newCachedThreadPool
    特点：
      （1）核心线程数为0，最大线程数是Integer.MAX_VALUE，救急线程的空闲存活时间为60s，意味着
          （1）全部都是救急线程（60s后可以回收）
          （2）救急线程可以被无限创建
      （2）队列采用了synchronousQueue；实现特点是：没有容量，没有线程来取是放不进去的
    评价：
      整个线程池表现为线程数会根据任务量不断增长，没有上限，当任务执行完毕，空闲1分钟后释放线程
      适合任务比较密集，但每个任务执行时间较短得情况（若任务执行时间过长，来一个任务创建一个线程，导致线程数量不可控）
    默认构造方法：
    public static ExecutorService newCachedThreadPool() {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                          60L, TimeUnit.SECONDS,
                                          new SynchronousQueue<Runnable>());
    }
        
（3）newSingleThreadExecutor
    使用场景：希望多个任务排队执行。线程数固定为1（核心线程），任务数多于1时，会放入无界队列排队。任务执行完毕，这个唯一的线程也不会释放
    区别：
    （1）自己创建一个单线程串行执行任务，如果任务执行失败而终止那么没有任务补救措施，而线程池还会新建一个线程，保证池的正常工作
    （2）Executors.newSingleThreadExecutor()线程数始终为1，不能修改
        FinalizableDelegatedExecutorService应用的是装饰者模式，只对外暴露了ExecutorService接口，因此不能调用ThreadPoolExecutor中特有的方法
    （3）Executors.newFixedThreadPool(1)初始值为1，之后还可以修改
        对外暴露的是ThreadPoolExecutors对象，可以强转后调用setCorePoolSize等方法进行修改
    默认构造方法：    
     public static ExecutorService newSingleThreadExecutor() {
             return new FinalizableDelegatedExecutorService
                 (new ThreadPoolExecutor(1, 1,
                                         0L, TimeUnit.MILLISECONDS,
                                         new LinkedBlockingQueue<Runnable>()));
     }
  
 5：提交任务  
 （1）执行任务
     void execute(Runnable command);
 （2）提交任务task，用返回值Future获得任务执行结果
     <T> Future<T> submit(Callable<T> task);
 （3）提交tasks中所有任务
     <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
 （4）提交tasks中所有任务，带超时时间
     <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                       long timeout, TimeUnit unit)
 （5）提交tasks中所有任务，那个任务先成功执行完毕，返回此任务的执行结果，其他任务取消
     <T> T invokeAny(Collection<? extends Callable<T>> tasks)
 （6）提交tasks中所有任务，那个任务先成功执行完毕，返回此任务的执行结果，其他任务取消，带超时时间
     <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                         long timeout, TimeUnit unit)
                         
6：关闭线程池：
（1）shutdown：线程池状态变为SHUTDOWN：不会接收新任务，但已提交的任务会执行完，此方法不会阻塞调用线程的执行
（2）shutdownNow：线程池状态变为STOP：不会接收新任务，会将队列中的任务返回，并用interrupt的方式中断正在执行的任务
（3）isShutdown()：不在RUNNING状态的线程池，此方法就返回true
（4）isTerminated()：线程池状态是否是TERMINATED
（5）awaitTermination(long timeout,TimeUnit unit)：调用shutdown后，由于调用线程并不会等待所有任务运行结束，因此如果他想在线程池TERMINATED后做些事情可以利用此方法等待


 sleep和yield的区别
 sleep
 
 八：锁
 1：ReentrantLock
 （1）相对于synchronized它具备如下特点
    （1）可中断
    （2）可以设置超时时间
    （3）可以设置公平锁
    （4）支持多个条件变量
    与synchronized一样，都支持可重入
 （2）可重入
  可重入是指同一个线程如果首次获得了这把锁，那么因为他是这把锁的拥有者，因此有权利再次获取这把锁；如果是不可重入锁，那么第二次获得锁时，自己也会被锁住
 （3）基本语法
     // 获取锁
     reentrantLock.lock();
     try {
         // 临界区
     } finally {
        // 释放锁
        reentrantLock.unlock();
     }
 (4) ReentrantLock默认不公平：不会因为你进入阻塞队列的先后而优先获得锁；公平锁一般没有必要，会降低并发度；但公平锁可以用来解决线程饥饿问题，饥饿问题也可以通过tryLock实现
 (5) 条件变量
     synchronized中也有条件变量，就是之间的waitSet休息室，当条件不满足时进入waitSt等待；
     ReentrantLock的条件变量比Synchronized强大之处在于，他支持多个条件变量，这就好比：
       （1）synchronized是那些不满足条件的线程都在同一间休息室等消息
       （2）而ReentrantLock支持多间休息室，有专门等烟的休息室，专门等早餐的休息室、唤醒时也是按休息室来唤醒
     使用流程
       （1）await前需要获得锁
       （2）await执行后，会释放锁，进入conditionObject等待
       （3）await的线程被唤醒（或打断、或超时）去重新竞争lock锁
       （4）竞争lock锁成功后，从await后继续执行。
       
  
       


九：AQS
1：概述
全称是AbstractQueuedSynchronizer，是阻塞式锁和相关的同步器工具的框架
特点：
（1）用state属性表示资源的状态（分独占模式和共享模式），子类需要定义如何维护这个状态，控制如何获取锁和释放锁
   （1）getState：获取state状态
   （2）setState：设置state状态
   （3）compareAndSetState：乐观锁机制设置state状态
   （4）独占模式是只有一个线程能够访问资源，而共享模式可以允许多个线程访问资源】
（2）提供了基于FIFO的等待队列，类似Monitor的EntryList
（3）条件变量来实现等待、唤醒机制，支持多个条件变量，类似Monitor的WaitSet

2：获取锁的姿势
  // 如果获取锁失败
  if(!tryAcquire(arg)) {
     // 入队，可以选择阻塞当前线程   park  unpark
  }
  
3：释放锁的姿势
  // 如果释放锁成功
  if(tryRelease(arg)) {
     // 让阻塞线程恢复运行
  } 
  
  
4：reentrantLock
（1）非公平锁实现原理
    加锁解锁流程：从构造器看，默认为非公平锁
        public ReentrantLock() {
            sync = new NonfairSync();
        }
    NonfairSync继承自AQS；没有竞争时：
      
      NonfairSync
        state=1
         head
         tail
    exclusiveOwnerThread -----> Thread0
    
    第一个竞争出现
    
      NonfairSync
        state=1
        head                      Thread1尝试竞争锁对象
        tail
      exclusiveOwnerThread -----> Thread0
    
    1：CAS尝试将state由0改为1，结果失败
    2：进入tryAcquire逻辑，这时1state已经是1，结果任然失败
    3：接下来进入addWaiter逻辑，构造Node队列：Node是一个双向链表，第一个Node称为哨兵，用来占位，并不关联线程
    
    当前线程进入acquireQueued逻辑
    1：acquireQueued会在一个死循环中不断尝试获得锁，失败后进入park阻塞
    2：如果自己是紧邻着head（排第二位），那么再次tryAcquire尝试获取锁，当然这时state仍为1，失败
    3：进入shouldParkAfterFailedAcquire逻辑，将前驱node，即head的waitStatus改为-1（用于唤醒他下一个节点），这次返回false
    4：shouldParkAfterFailedAcquire执行完毕回到acquireQueued，再次tryAcquire尝试获取锁，这时state仍为1，失败
    5：当再次进入shouldParkAfterFailedAcquire时，由于前驱node的waitStatus已经是-1了，这次返回true
    6：进入parkAndCheckInterrupt，thread1 park
    
    
5：countdownLatch
用来进行线程同步协作，等待所有线程完成倒计时，其中构造参数用来初始化等待计数值，await()用来等待计数归零，countDown()用来计数减1


6：CyclicBarrier
循环栅栏，用来进行线程协作，等待线程满足某个计数。构造时设置计数个数，每个线程执行到某个需要同步的时刻调用await()方法进行等待，当等待的线程数满足计数个数时，继续执行
他跟countdownLatch的区别是：它可以被重用



十：线程安全集合类概述

      遗留的安全集合                                 修饰的安全集合                                                JUC安全集合
          |                                            |                                                         |
  ————————————————————                       ----------------------                                ------------------------------------
  |                  |                       |                    |                                |                 |                 |
 Hashtable        Vector           SynchronizedMap         SynchronizedList                   Blocking类         CopyOnWrite类     Concurrent类
                              （使用Collections的方法修饰）  （使用Collections的方法修饰） 

线程安全集合类可以分为三大类
（1）遗留的线程安全集合如：hashtable、vector
（2）使用Collections装饰的线程安全集合，如：
    （1）Collections.synchronizedCollection
    （2）Collections.synchronizeList
    （3）Collections.synchronizedMap
    （4）Collections.synchronizedSet
    （5）Collections.synchronizedNavigableMap
    （6）Collections.synchronizedNavigableSet
    （7）Collections.synchronizedSortedMap
    （8）Collections.synchronizedSortedSet
（3）java.util.concurrent.*
    （1）Blocking大部分实现基于锁，并提供用来阻塞的方法
    （2）CopyOnWrite之类的容器修改开销相对较重
    （3）Concurrent类型的容器
       （1）内部很多操作使用cas优化，一般可以提供较高吞吐量
       （2）弱一致性
          （1）遍历时弱一致性，例如，当利用迭代器遍历时，如果容器发生修改，迭代器仍然可以继续进行遍历，这时内容是旧的
          （2）求大小弱一致性，size操作未必是100%准确
          （3）读取弱一致性
          遍历时如果发生了修改，对于非安全容器来讲，使用fail-fast机制也就是让遍历立刻失败，抛出ConcurrentModificationException，不再继续遍历
 

      
 十一：JMM
 
 1：概念：
 JMM即java Memory Model，它定义了主存（所有线程都共享的数据：静态成员变量、静态变量）、工作内存（线程私有变量：私有变量）抽象概念，底层对应着cpu寄存器、缓存、硬件内存、cpu指令优化等
 
 2：JMM体现在以下几个方面  
 （1）原子性：保证指令不会受到线程上下文切换的影响
 （2）可见性：保证指令不会受cpu缓存的影响
 （3）有序性：保证指令不会受cpu指令并行优化的影响
 
3：可见性
（1）通过volatile修饰变量实现可见性；也可以通过synchronized来实现；但是synchronized需要创建monitor监视器，相对于volatile较重
（2）volatile：可以用来修饰成员变量和静态变量，它可以避免线程从工作内存中读取变量的值，强制让线程到主存中获取变量值，线程操作volatile变量都是直接操作主存
（3）可见性vs原子性
    （1）可见性保证的是在多个线程之间，一个线程对volatile变量的修改对另外一个线程可见，不能保证原子性，仅用在一个写线程，多个读线程的情况
    （2）对于两个线程一个i++，一个i--，只能保证看到最新值，不能解决指令交错：i++或i--是四条指令，可能i++的四条指令没执行完就被i--先执行完了，这样会产生指令交错，导致数据有误
    （3）注意：synchronized语句块既可以保证代码块的原子性，也同时可以保证代码块内存变量的可见性；但缺点就是synchronized属于重量级操作，性能相对较低
    （4）在死循环中加入 System.out.println();也可以退出循环；因为 System.out.println();底层使用synchronized修饰了
    
4：有序性
（1）JVM会在不影响正确性的前提下，可以调整语句的执行顺序，这种特性称为指令重排，多线程下指令重排会影响正确性

    

    
 
 
 
  
   
 
 
 




