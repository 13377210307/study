1：抽象类应用
当父类的一些方法不能确定时，可以用abstract关键字来修饰该方法，这个方法就是抽象方法，用abstract来修饰该类就是抽象类；
一般来说抽象类会被继承，由其子类来实现抽象方法

2：使用
abstract class Animal {
   String name;
   int age;
   public abstract void cry();
}

3：注意事项
（1）由abstract修饰的方法称为抽象方法；抽象方法不能有方法体
（2）抽象类不能被实例化
（3）抽象类可以没有abstract方法
（4）一旦类包含了abstract方法，则这个类必须声明为抽象类
（5）abstract只能修饰类和方法
（6）抽象类可以有任意成员：抽象方法、构造器、静态属性等等（抽象类还是一个类）
（7）如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为抽象类
（8）抽象方法不能使用private、final和static来修饰，因为这些关键字都是和重写相违背的

4：通过抽象方法引申出模板设计模式
（1）需求：写一个方法计算某个任务的耗时；可能有多个任务都需要计算耗时
（2）分析：计算方法中就只是任务不同，我们可以把其他的代码抽出来作为模板，减少代码重复
