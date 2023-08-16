package practice.techPractice.sort;

import java.util.Arrays;

/**
 * 希尔排序也是一种插入排序
 * 基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录 “基本有序” 时，再对全体记录进行依次直接插入排序。
 *
 * 选择一个增量序列 {t1, t2, …, tk}，其中 (ti>tj, i<j, tk=1)；
 * 按增量序列个数 k，对序列进行 k 趟排序；
 * 每趟排序，根据对应的增量 t，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 *
 * shell排序的时间复杂度无法用数学手段确切证明
 * 最佳：O(nlogn)， 最差：O(n^2) 平均：O(nlogn)
 * 当n在某个范围，可达O(n^1.3)
 *
 * 空间复杂度：O(1)
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
        //初始gap为n/2，一直到gap为1做一次排序 即完成了

        //在每一次gap循环里面都是一次插入排序  只不过插入排序的1 这里是gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            //在间隙序列内插入排序,第一个元素索引是0，第二个是gap 从第二个开始
            for (int i = gap; i < n; i++) {
                int current = a[i];  //待插入元素
                //在已排序序列里 倒序遍历 移动 插入
                // 已排序区域最后一个元素索引： i - gap
                int preIndex = i - gap;
                while (preIndex >= 0 && a[preIndex] > current){
                    a[preIndex + gap] = a[preIndex];
                    preIndex -= gap;
                }
                //找到插入位置后插入
                a[preIndex + gap] = current;
            }
        }
    }
}
