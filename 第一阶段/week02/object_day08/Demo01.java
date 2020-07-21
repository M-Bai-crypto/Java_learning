package com.learn.object;

/**
 * 1.  结合多态发生的条件，及继承相关知识，自己总结并验证下，哪些方法无法实现多态效果。
 * 多态发生的条件：继承；子类重写父类方法；父类引用指向子类对象
 * 第一类考虑不能发生继承的方法，私有，静态，final，构造,均以失败告终
 * 第二种考虑子类是否完全重写父类方法：1.子类多写，子类特有父类引用无法访问；
 *                           2.子类少写，根据JVM搜索策略，只要父类有就可以执行
 * 第三种考虑父类是否指向子类对象，没有指向这种情况多态无法产生，编译报错，有指向回到上面两种情况
 *
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/21
 */
public class Demo01 {
    public static void main(String[] args) {
        Father father = new Son();

        // 父类private修饰的方法,不能在子类中重写,多态调用
//        father.privateMethod();

        // 重写父类static修饰的方法,可以被子类调用，但是不能重写,展现不出多态效果，只有多态调用
        father.staticMethod();

        // 重写父类final修饰的方法,可以被子类调用，但是不能重写,展现不出多态效果，只有多态调用
        father.finalMethod();

        // 父类没有被子类重写的方法可以实现多态效果
        father.fatherMethod();

        // 子类中特有的方法，父类引用不会实现，需要向下转型
//        father.SonMethod();

        // 通过向下转型实现
        Son son = (Son)father;
        son.SonMethod();
    }
}

// 父类
class Father{
    String name;

    // 构造方法
    public Father(){}
    public Father(String name){this.name = name;}

    // 私有方法
    private void privateMethod(){
        System.out.println("父类私有方法");
    }

    // 静态方法
    public static void staticMethod(){
        System.out.println("父类静态方法");
    }

    // final修饰的方法
    public final void finalMethod(){
        System.out.println("父类中final修饰的方法");
    }

    // 父类特有方法，子类没有覆盖重写
    public void fatherMethod(){
        System.out.println("父类特有方法");
    }
}

// 子类
class Son extends Father{

    // 重写父类构造方法,语法报错
//    public Father(){}

    // 重写父类私有方法失败
//    @Override
//    private void privateMethod(){
//        System.out.println("父类私有方法");
//    }

    // 重写父类静态方法,报错
//    @Override
//    public static void staticMethod(){
//        System.out.println("父类静态方法");
//    }

    // 重写父类final修饰的方法,报错
//    @Override
//    public final void finalMethod(){
//        System.out.println("父类中final修饰的方法");
//    }

    // 子类特有方法,父类中没有
    public void SonMethod(){
        System.out.println("子类特有方法");
    }
}