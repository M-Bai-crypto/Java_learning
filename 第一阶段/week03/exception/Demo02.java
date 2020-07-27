package com.learn.exception;

/**
 * 2.  定义三种新类型的异常。
 * 写一个类，在该类的三个方法中抛出三种不同的异常。
 * 然后在mian方法中调用这个类的不同方法，尝试用try catch捕获你写的异常。
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/27
 */
public class Demo02 {
    public static void main(String[] args) throws CustomException3 {
        // 调用这个类中定义的方法，使用try catch捕获异常
        ThrowException throwex = new ThrowException();
        try {
            throwex.method1();
        } catch (CustomException1 e) {
            e.printStackTrace();
        }

        try {
            throwex.method2();
        } catch (CustomException2 e) {
            System.out.println(e.getMessage());
        }

        try {
            throwex.method3();
        } catch (CustomException3 e) {
            System.out.println(e.toString());
        }
    }
}

// 定义一个类去抛出三种不同类型的异常
class ThrowException {
    // 抛出自定义异常1
    public void method1() throws CustomException1 {
        throw new CustomException1("自定义编译时异常1");
    }

    // 抛出自定义异常2
    public void method2() throws CustomException2 {
        throw new CustomException2("自定义运行时异常2");
    }

    // 抛出自定义异常3
    public void method3() throws CustomException3 {
        throw new CustomException3("自定义编译时异常3");
    }
}

// 自定义编译时异常
class CustomException1 extends Exception {
    public CustomException1(String str) {
        super(str);
    }
}

// 自定义运行时异常
class CustomException2 extends RuntimeException {
    public CustomException2(String str) {
        super(str);
    }
}

// 自定义编译时异常
class CustomException3 extends Exception {
    public CustomException3(String str) {
        super(str);
    }
}
