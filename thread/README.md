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
 
 
 
 线程池
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
     
 （3）提交tasks中所有任务
 （4）提交tasks中所有任务，带超时时间
 （5）提交tasks中所有任务，那个任务先成功执行完毕，返回此任务的执行结果，其他任务取消
 （6）提交tasks中所有任务，那个任务先成功执行完毕，返回此任务的执行结果，其他任务取消，带超时时间
 
 sleep和yield的区别
 sleep
   
 
 
 




