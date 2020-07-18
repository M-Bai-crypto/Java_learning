package com.learn.object02.test;

import com.learn.object02.ArrayTool;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试工具类
 * J.M.Bai
 * 2020/7/18
 */
public class ArrayToolTest {
    // 初始化
    public int[] init() {
        int[] ints = {1, 2, 3, 4, 5};
        return ints;
    }

    // 测试遍历方法
    @org.junit.Test
    public void foreachTest() {
        // 遍历
        System.out.println("数组遍历");
        ArrayTool.foreach(init());
    }

    // 测试最大值
    @Test
    public void maxTest() {
        int max = ArrayTool.max(init());
        Assert.assertEquals(4, max);
    }

    // 测试最小值
    @Test
    public void minTest() {
        Assert.assertEquals(1, ArrayTool.min(init()));
    }

    // 测试逆置
    @Test
    public void reverseTest() {
        int[] reverse = ArrayTool.reverse(init());
        ArrayTool.foreach(reverse);
    }

    // 测试查表
    @Test
    public void findIndexTest(){
        Assert.assertEquals(0,ArrayTool.findIndex(1,init()));
    }

    // 测试查找最后一个索引
    @Test
    public void findLastIndexTest(){
        Assert.assertEquals(4,ArrayTool.findLastIndex(5,init()));
    }
}
