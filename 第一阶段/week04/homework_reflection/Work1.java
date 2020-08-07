package com.learn.homework;

import java.lang.reflect.Field;

/**
 * 1.设计一个方法如下，要求该方法能修改任意对象中，指定成员变量的值
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/7
 */
public class Work1 {
    private static int a;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Work1 work = new Work1();
        setAll(work,"a",20);
        System.out.println(work.a);
    }

    public static void setAll(Object targetObj, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        // 获取Class对象，找到指定变量
        Class targetClass = targetObj.getClass();
        Field declaredField = targetClass.getDeclaredField(fieldName);
        // 绕过权限检测并进行修改
        declaredField.setAccessible(true);
        declaredField.set(null,newValue);
    }
}
