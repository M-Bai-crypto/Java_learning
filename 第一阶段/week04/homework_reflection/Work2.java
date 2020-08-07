package com.learn.homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 完成如下方法，要求该方法能调用，指定配置文件中，指定类中指定的普通成员方法(无参方法)
 * 假设指定类中一定有默认构造方法
 * @author J.M.Bai
 * @version 1.0
 * 2020/8/7
 */
public class Work2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Work2 work2 = new Work2();
        work2.callTargetMethod("config.properties");
    }

    public void callTargetMethod(String configFilePath) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 解析配置文件，得到类的Class对象及方法名
        FileInputStream fis = new FileInputStream(configFilePath);
        Properties configFile = new Properties();
        configFile.load(fis);
        String className = configFile.getProperty("className");
        String methodName = configFile.getProperty("methodName");
        Class targetClass = Class.forName(className);

        // 通过类的Class对象，反射构造无参对象,得到Class对象中的无参成员方法
        Constructor con = targetClass.getDeclaredConstructor();
        con.setAccessible(true);
        Object object = con.newInstance();
        Method declaredMethod = targetClass.getDeclaredMethod(methodName);

        // 使用invoke调用方法
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(object);
        // close
        fis.close();
    }
}

class ReflectionTest{
    public ReflectionTest (){}
    private static void methodTest(){
        System.out.println("类中私有静态方法被访问");
    }
}