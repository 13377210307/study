枚举类

1：自定义枚举类
（1）构造器私有化
（2）本类内部创建一组对象
（3）对外暴露对象（通过为对象添加public final statis修饰符）
（4）提供get方法，但是不能有set方法（保持只读）

2：通过enum创建枚举对象
（1）创建构造器，若为无参构造器，则实参列表和小括号可以省略
（2）有多个枚举对象时，使用,间隔，最后一个有分号
（3）枚举对象必须放在枚举类的行首

3：注意
（1）使用enum关键字后，就不能继承其他类了，因为enum会隐式继承Enum；
（2）枚举类和普通类一样，可以实现接口
