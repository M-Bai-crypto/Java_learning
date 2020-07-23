package com.learn.object;

/**
 * 2. 根据注释填写(1), (2),(3)处的代码
 * @author J.M.Bai
 * @version 1.0
 * 2020/7/23
 */
public class Test{
    public static void main(String[] args){
        // 初始化bean1,成员静态方法访问同类成员内部类
        Bean1 bean1 = new Test().new Bean1();
        bean1.i++;
        // 初始化bean2,成员静态方法访问同类静态成员内部类
        Bean2 bean2 = new Bean2();
        bean2.j++;
        //初始化bean3,其他类访问外部类的成员内部类
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;
    }
    class Bean1{
        public int i = 0;
    }

    static class Bean2{
        public int j = 0;
    }
}

class Bean{
    class Bean3{
        public int k = 0;
    }
}
