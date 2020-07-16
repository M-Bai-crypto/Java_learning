package com.learn.recursion;

/**
 * 汉诺塔搬送问题
 * J.M.Bai
 * 2020/7/16
 */
public class Hanoi {
    private static long CONUNT = 1;
    public static void main(String[] args) {
        int n = 50;
        hanoi(n,'A','B','C');
        System.out.println("搬运了"+ (CONUNT-1) + "次");
//        long count = count(n);
//        System.out.println("搬运了"+ count + "次");
    }

    // 求搬送次数，等比数列
    private static long count(int n) {
        if (n==1)
            return 1;
        return 2*count(n-1)+1;
    }

    private static void hanoi(int n ,char start,char middle,char end) {
        if (n == 1){
            System.out.println(start + "->" + end + " " + CONUNT);
            CONUNT++;
            return;
        }
        // 把n-1个盘从开始盘借助目标盘搬到辅助盘
        hanoi(n-1,start,end,middle);
        // 把1个直接从开始搬到目标
        System.out.println(start + "->" + end + " " +  CONUNT);
        CONUNT++;
        // 剩余的n-1从辅助盘借助开始盘搬送到目标盘
        hanoi(n-1,middle,start,end);
    }
}
