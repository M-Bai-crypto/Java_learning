package com.learn.arraytwo;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 7.15日志：目前可以实现上下左右查找，对终止循环条件的条件无法给出，
 * 怀疑和m与n的大小有关，具体需要debug来看指针的移动情况
 *
 * 7.16 7:28日志记录：经过思考后这种撞针的方法存在问题，问题点有2：
 *
 * 1.不能保证每个数组都能做完整个循环后再进行判断，有可能这个数组打印一两次就结束，
 * 所以必须要在程序执行一次打印就要判断一次
 *
 * 2.{{1, 2}, {6, 7}, {11,12}, {16, 17}, {21, 22}, {26, 27}, {31, 32}};
 * 拿这个来举例，前后的初始针在打印第一行结束后就相等，上下的初始针还没有打印就相等
 * 对于越扁平化的数组需要考虑的特殊情况太多
 *
 * 综上，代码写到现在已经冗余过多，考虑重构，写代码前的考虑不谨慎导致
 * J.M.Bai
 * 2020/7/15
 */
public class Demo03 {
    // 定义角标
    private static int I = 0;
    private static int J = 0;

    public static void main(String[] args) {
        // 给定一个矩阵(以下均为测试用数组)
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4,5, 6}, {7, 8,9, 10, 11, 12}, {13,14,15,16,17,18}};
//        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}, {26, 27, 28, 29, 30}};
        int[][] matrix = {{1, 2}, {6, 7}, {11,12}, {16, 17}, {21, 22}, {26, 27}, {31, 32}};
        // 指定向前,后，上，下的指针
        int advance = matrix[0].length - 1;
        int back = 0;
        int up = 1;
        int down = matrix.length - 1;

//        System.out.print("[");
        while (true) {
            advanceMethod(advance, matrix);
            advance--;
//            System.out.println(I + " " + J);
            downMethod(down, matrix);
            down--;
//            System.out.println(I + " " + J);
            backMethod(back, matrix);
            back++;
            upMethod(up, matrix);
            up++;
            if (advance == back || down == (up - 1)) {
                if (matrix.length == matrix[0].length) {
                    System.out.print(matrix[advance][down]);
                    break;
                } else {
                    if (advance > back) {
                        System.out.print(matrix[I][J] + " ");
                        System.out.print(matrix[I][J + 1]);
                        break;
                    } else {
                        System.out.print(matrix[I][J] + " ");
                        System.out.print(matrix[I + 1][J]);
                        break;
                    }
                }
//                System.out.println("这是最后结束时各个参数的值");
//                System.out.print(" I: " + I);
//                System.out.print(" J: " + J);
//                System.out.print(" advence: " + advance);
//                System.out.print(" back: " + back);
//                System.out.print(" down: " + down);
//                System.out.print(" up " + up);
            }
        }
//        System.out.print("]");

    }

    // 上升打印，列不变，行递减
    private static void upMethod(int up, int[][] matrix) {
        for (int i1 = I; i1 >= 0; i1--) {
            System.out.print(matrix[i1][J] + " ");
            if (i1 == up) {
                // 记录下次开始位置并返回
                I = i1;
                J++;
                break;
            }
        }
    }

    // 回退打印，行不变，列递减，结束后行向上移动一位
    private static void backMethod(int back, int[][] matrix) {
        for (int j1 = J; j1 >= 0; j1--) {
            System.out.print(matrix[I][j1] + " ");
            if (j1 == back) {
                // 记录下次开始位置并返回
                I--;
                J = j1;
                break;
            }
        }
    }

    // 定义下降方法，列不变，行递增，结束后该列结束
    private static void downMethod(int down, int[][] matrix) {
        for (int i1 = I; i1 < matrix.length; i1++) {
            System.out.print(matrix[i1][J] + " ");
            if (i1 == down) {
                // 记录下次开始位置并返回
                I = i1;
                J--;
                break;
            }
        }
    }

    // 定义前进方法，行不变，列前进
    private static void advanceMethod(int advance, int[][] matrix) {
        for (int j1 = J; j1 < matrix[I].length; j1++) {
            System.out.print(matrix[I][j1] + " ");
            if (j1 == advance) {
                // 记录下次开始位置并返回
                I++;
                J = j1;
                break;
            }
        }
    }
}
