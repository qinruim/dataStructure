package practice.techPractice.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 两两比较，前面的比后面大，就交换  从第一对比较到最后一对
 * 进行一次就将最大的沉底了
 *
 * 如此沉底n-1次，即可完成
 *
 * 两层for循环
 *
 *
 * 稳定性：稳定
 * 时间复杂度：最佳：O(n) ，最差：O(n2)， 平均：O(n2)
 * 空间复杂度：O(1)
 * 排序方式：In-place
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,100};

//        bubble(a);
        //简单方法 捋清思路
        bubbleSort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        //沉底 n-1 次
        for (int i = 1; i < a.length; i++) {
            //小优化 如果有一轮没有发生交换（flag没有变） 说明已经排序完成  后面就不用继续了
            boolean flag = true;

            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]){
                    Utils.swap(a,j,j + 1);
                    flag = false;
                }
            }

            if (flag){
                break;
            }


        }

    }






}
