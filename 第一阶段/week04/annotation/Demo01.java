package com.learn.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1. 自定义注解，该注解用来描述，方法运行所需的时间上限(用long类型的数据表示时间，单位为ms)，
 * 然后，自定义注解处理器，运行加了运行时间上限注解的方法，判断方法的运行时间，
 * 是否超出了注解中规定的时间上限，如果超过，则返回true，未超过返回false
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/8
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        boolean result = annotationHandle("com.learn.annotation.Demo01", "testMethod",
                TimeLimitAnnotation.class);
        System.out.println(result);
    }

    // 注解处理器
    public static boolean annotationHandle(String className, String methodName, Class annotation) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 获取Class对象,并构造无参对象，获取Method对象
        Class targetClass = Class.forName(className);
        Constructor constructor = targetClass.getDeclaredConstructor();
        Demo01 targetObject = (Demo01) constructor.newInstance();
        Method targetMethod = targetClass.getDeclaredMethod(methodName);
        // 判断是否被注解注释
        if (targetMethod.isAnnotationPresent(annotation)) {
            // 得到注释实例，获取时间上限
            TimeLimitAnnotation note = (TimeLimitAnnotation) targetMethod.getAnnotation(annotation);
            int time = note.time();

            // 运行方法
            targetMethod.setAccessible(true);
            long before = System.currentTimeMillis();
            targetMethod.invoke(targetObject);
            long after = System.currentTimeMillis();

            // 判断时间
            System.out.println("设定上限：" + time);
            System.out.println("实际运行时间：" + (after - before));
            return (after - before) > time;
        }
        return false;
    }

    // 定义测试方法
    @TimeLimitAnnotation(time = 200)
    private void testMethod() throws InterruptedException {
        Thread.sleep(300);
    }

    // 无参构造用来反射构造对象
    public Demo01() {
    }
}

// 自定义注解,描述方法执行时间上限
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TimeLimitAnnotation {
    int time();
}
