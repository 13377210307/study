package com.basic.classAndObject.innerClassStudy.basic.inner;

/**
 * @Author: w
 * @Date: 2021/7/24 22:03
 * 内部类
 */
public class OuterClass { // 外部类

    private String name = "外部类";

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();
    }

    public void outerMethod() {
        /**
         * 1：局部内部类是定义在外部类的局部位置，通常在方法
         * 2：不能添加访问修饰符，但是可以用final修饰
         * 3：作用域：仅仅在定义它的方法或代码块中
         * 4：局部内部类可以直接访问外部类的属性
         * 5：外部类可以在外部类方法中创建局部类对象，然后使用局部类属性或方法
         * 6：如果外部类和局部类的成员重名时，遵循就近原则，如果想访问外部类成员变量，可以使用（外部类名.this.成员）进行访问；为何要用this.成员，
         *   是因为由哪个对象调用内部类方法
         */
        final class InnerClass {  // 局部内部类
            private String name = "局部类";
            public void innerMethod() {
                System.out.println(OuterClass.this.name);
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.innerMethod();
    }
}
