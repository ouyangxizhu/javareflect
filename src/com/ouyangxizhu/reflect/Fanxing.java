package com.ouyangxizhu.reflect;

import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Fanxing {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList<>();

        Class<? extends ArrayList> c1 = list1.getClass();
        Class<? extends ArrayList> c2 = list2.getClass();
        //反射的操作都是运行时的操作，说明编译之后是去泛型化的。
        //java中的泛型只是防止错误输入的，只在编译阶段有效，编译之后就没有了。绕过编译就绕过了泛型
        System.out.println(c1 == c2);//true

        //泛型声明是String，但是也能加入整数
        Method addMethod = c2.getMethod("add", Object.class);
        addMethod.invoke(list2, 20);
        System.out.println(list2.size());//1
        System.out.println(list2);//[20]
        /*
        不可以int直接转换为String
        Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
	at com.ouyangxizhu.reflect.Fanxing.main(Fanxing.java:24)
         */
        for (String string : list2) {
            System.out.println(string);//
        }
    }
}
