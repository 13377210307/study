package com.basic.classAndObject.innerClassStudy.basic.anonymous;

/**
 * @Author: w
 * @Date: 2021/7/24 22:23
 * 匿名内部类
 */
public class AnonymousClass {

    public static void main(String[] args) {
        Outer1Class outerClass = new Outer1Class();
        outerClass.method();
    }
}

// 外部类
class Outer1Class {

    private String name = "外部类";

    public void method() {
        /**
         * 基于接口的匿名内部类
         * 需求：这个类只会被定义一次，后面不再使用，这里我们就可以使用匿名内部类来减少类的创建
         * 该类的编译类型就是IA接口；运行类型就是匿名内部类由系统分配，一般为：外部类名$1；可以通过对象名.getClass()获取运行类型
         *
         */
        IA AImpl = new IA() {
            @Override
            public void cry() {
                System.out.println("叫...");
            }
        };
        AImpl.cry();

        /**
         * 基于类的匿名内部类
         * 如果没加{}，就表示A这个类；加了{}，表示匿名内部类
         */
        new A() {
            @Override
            void method() {
                System.out.println("重写父类方法...");
            }
        };
    }
}

interface IA {
    void cry();
}

class A {

    void method() {
        System.out.println("父类方法...");
    }
}
