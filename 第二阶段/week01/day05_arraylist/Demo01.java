package com.learn.day05.arraylist;

import java.util.ArrayList;
import java.util.Random;

/**
 * 对集合中的元素比较，排序输出
 * @author J.M.Bai
 * @version 1.0
 * @Date 2020/8/15
 */
public class Demo01 {
    public static void main(String[] args) {
        // 定义Random生成成绩
        Random r = new Random();

        // 定义集合装入对象
        ArrayList<Student> students = new ArrayList<>();

        // 循环初始化50个学生对象并放入集合
        // 随机生成三门课程成绩，范围为0-100分
        Student student;
        int javaScore;
        int databaseScore;
        int springScore;
        for (int i = 1; i <= 50; i++) {
            javaScore = r.nextInt(100) + 1;
            databaseScore = r.nextInt(100) + 1;
            springScore = r.nextInt(100) + 1;

            student = new Student("stu" + i, i, javaScore, databaseScore, springScore);
            students.add(student);
        }

        // 使用toArray的有参方法(数组长度为0比较好)，无参强转类型时会抛出异常
        Student[] stu = students.toArray(new Student[0]);
        // 调用方法
        insertSort(stu);
    }

    /**
     * 插入排序
     * 将ArrayList里的学生按照总分从大到小进行排序。
     * 排序完成后遍历输出。
     *
     * @param deal 传入需要处理的数组
     */

    private static void insertSort(Student[] deal) {
        // 复制原数组
        Student[] arr = new Student[deal.length];
        System.arraycopy(deal, 0, arr, 0, deal.length);

        // 插入排序
        for (int i = 0; i < arr.length; i++) {
            // 获取当前元素
            Student temp = arr[i];

            // 当左边的总分大的时候进行交换
            // 每一次循环都会将本次元素的左边排序完成
            // 只需要比对这个元素和上一个元素即可
            int j = i;
            while (j > 0 && arr[j - 1].getSumScore() < temp.getSumScore()) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 循环结束后i和j不相等即为存在交换，插入该元素
            if (i != j) {
                arr[j] = temp;
            }
        }

        // 遍历输出
        for (Student student : arr) {
            System.out.println(student);
        }
    }

}

/**
 * 定义一个Student类, 用于存储学生的姓名 ，学号
 * 以及Java语言，数据库，Spring三门课程的成绩，以及总分
 */
class Student {
    private String name;
    private int num;
    private int javaScore;
    private int databaseScore;
    private int springScore;
    private int sumScore;

    public Student() {
    }

    public Student(String name, int num, int javaScore, int databaseScore, int springScore) {
        this.name = name;
        this.num = num;
        this.javaScore = javaScore;
        this.databaseScore = databaseScore;
        this.springScore = springScore;
        sumScore = javaScore + databaseScore + springScore;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", javaScore=" + javaScore +
                ", databaseScore=" + databaseScore +
                ", springScore=" + springScore +
                ", sumScore=" + sumScore +
                '}';
    }

    public int getSumScore() {
        return sumScore;
    }
}
