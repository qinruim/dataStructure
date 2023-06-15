package sort;

import java.util.Arrays;

/**
 * 相当于n个节点的二叉树  递归层数为 log2（n）+ 1
 * 时间复杂度 为 递归层数*n（每一层处理的元素不超过n）
 * 所以最好和平均时间复杂度O（nlogn），最坏时间复杂度O（n^2）
 *
 * 空间复杂度=O(递归层数)
 *
 * 稳定性不好
 *
 * 算法表现主要取决于递归深度，若每次划分均匀，递归深度就低（二叉树高度，logn至n）
 */
public class QuickSort {
    public static void main(String[] args) {
        int a[] = {5,3,7,2,9,8,1,4};

        quickSort(a,0,a.length - 1);

        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int low, int high) {
        //结束条件
        if (low < high) {
            //单层逻辑
            int pivotPosition = part(a, low, high); //划分左右子表  返回数轴最终位置
            //递归左右子表
            quickSort(a, low, pivotPosition - 1);
            quickSort(a, pivotPosition + 1, high);
        }
    }

    /**
     * 划分左右子表
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int part(int[] a, int low, int high) {
        int pivot = a[low]; //第一个元素作为轴
        while (low < high){ //双指针向中间搜索，确定轴最后位置
            while (a[high] >= pivot && low < high){high--;} //high指向元素比较大，元素不动，左移high
            a[low] = a[high];                               //high指向元素小于轴，移动
            while (a[low] <= pivot && low < high){low++;}
            a[high] = a[low];
        }

        a[low] = pivot;  //轴元素最终存放位置（此时low = high）

        return low;
    }



}
