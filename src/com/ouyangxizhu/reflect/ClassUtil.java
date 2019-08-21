package com.ouyangxizhu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数、成员变量
     * @param object
     */
    public static void printClassMessage(Object object) {
        //获取类的信息，要获取类的类类型。
        Class<?> aClass = object.getClass();//传递的是哪个子类对象，创建的就是该子类的对象本地方法，通过JNI实现的
        //获取类的信息
        System.out.println("类的全名是：" + aClass.getName());
        System.out.println("类的类名是：" + aClass.getSimpleName());

        Method[] methods = aClass.getMethods();//method方法是java.lang.reflect.Method对象
        System.out.println("类的所有的public方法有(包括父类继承而来的)" + methods);

        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("所有类自己声明的方法（不包括父类的，不问访问权限）" + declaredMethods);

        for (int i = 0; i < methods.length; i++) {
            System.out.println("方法名：" + methods[i].getName());

            Class<?> returnType = methods[i].getReturnType();
            System.out.println("方法返回值的类类型为：" + returnType);

            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            System.out.println("方法参数列表的类的类类型数组：" + parameterTypes);
        }
        //成员变量也是对象,是java.lang.reflect.Field对象，封装了关于成员变量的操作。
        //获取所有类的public成员变量，包括父类的
        Field[] fields = aClass.getFields();
        //获取所有的自己声明的变量，不问访问权限
        Field[] declaredFields = aClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            //获取成员变量的类型的类类型
            Class<?> type = fields[i].getType();
            //得到成员变量的名称
            String name = fields[i].getName();
        }


        //所有的public构造方法，包括父类的不推荐使用，因为构造方法要就获取自己的
        //构造方法是java.lang.reflect.Constructor类型
        Constructor<?>[] constructors = aClass.getConstructors();
        //获取自己声明的所有构造方法，不问访问权限
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            //获取构造方法的参数类的类类型
            Class[] parameterTypes = constructor.getParameterTypes();

            for (Class param : parameterTypes) {
                //获取参数名称
                System.out.println(param.getName());
            }
        }


    }
}
