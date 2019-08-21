package com.ouyangxizhu.reflect;

import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A a = new A();
        Class<? extends A> aClass = a.getClass();
        //获取的方法由名称和参数类型决定
        Method print = aClass.getMethod("print", int.class, int.class);
        //将对象作为参数传入，正常是对象调用方法
        print.invoke(a, 10, 10);
        print.invoke(a, new Object[]{10, 20});


    }


}


