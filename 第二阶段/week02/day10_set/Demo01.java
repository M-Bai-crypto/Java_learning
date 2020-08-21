package com.learn.day09.map.homework;


import java.util.LinkedHashSet;
import java.util.Random;

/**
 * 生成双色球号码
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/21
 */
public class Demo01 {

    public static void main(String[] args) {
        Random random = new Random();
        LinkedHashSet<Integer> randomNum = new LinkedHashSet<>();
        // 当set中的红色球数量不满足6个的时候循环生成
        while (randomNum.size() < 7) {
            int redNum = random.nextInt(33) + 1;
            randomNum.add(redNum);
        }
        // 随机生成一个蓝色球，加入set
        int blueNum = random.nextInt(16) + 1;
        randomNum.add(blueNum);
        // 打印结果
        System.out.println(randomNum);
    }
}
