package com.ouyangxizhu.reflect;

public class ClassDemo1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //第一种表达方式，这表明任何一个类都有一个隐含的静态成员变量class
        Class<Foo> foo1 = Foo.class;

        //第二种表达方式，通过对象的getClass()方法
        Foo foo = new Foo();
        Class<? extends Foo> foo2 = foo.getClass();
        //foo1和foo2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象。
        System.out.println(foo1 == foo2);//true

        //第三种表达方式
        Class<?> foo3 = null;//在try catch块里面的是局部变量，要是在里面声明只能里面使用
        try {
            foo3 = Class.forName("com.ouyangxizhu.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(foo2 == foo3);//true

        //我们可以通过该类的类类型创建该类的对象实例
        Foo foo4 = foo2.newInstance();//需要有无参的构造方法
        System.out.println(foo == foo4);//false


    }
}