package practice.techPractice.sort;

import java.util.Arrays;

/**
 * shell排序的时间复杂度无法用数学手段确切证明
 * 最坏时间负责度跟插入排序一样 O(n^2)
 * 当n在某个范围，可达O(n^1.3)
 *
 * 稳定性： 不稳定
 */
public class  ShellSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,41};
        shell(a);
        System.out.println(Arrays.toString(a));

    }

    private static void shell(int[] a) {
        int n = a.length;
        //初始gap为例n/2
        //在每一次gap循环里面都是一次插入排序  只不过插入排序的1 这里是gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            //在间隙序列内插入排序 因此是从 0+gap 开始
            for (int i = gap; i < n; i++) {
                int temp = a[i]; //待插入元素值
                int indexOfSorted = i - gap; //已排序区域最后一个元素索引 i-gap （从i开始排序）
                while (indexOfSorted >= gap){
                    if (temp < a[indexOfSorted]){
                        //若待插入元素小于已排序区域最后一个元素，需要将已排序区域后移
                        a[indexOfSorted + gap] = a[indexOfSorted];
                    }
                    else {
                        // 当待插入元素进行比较时，遇到比自己小（或等）的元素，代表找到了插入位置，无需进行后续比较
                        break;
                    }
                    indexOfSorted -= gap;
                }
                //indexOfSorted-- 之后 indexOfSorted+1 即为空出来的位置
                a[indexOfSorted + gap] = temp;
            }


        }
    }
}
