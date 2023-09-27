package practice.techPractice.sort;

import java.util.Arrays;

import static practice.techPractice.sort.Utils.swap;

/**
 * 首先在未排序序列中找到最小（大）元素，存放到待排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第 2 步，直到所有元素均排序完毕。
 *
 *
 *
 * 空间复杂度 O(1)
 * 无论有序、无序、逆序 都要n-1 趟处理
 * 总共需要对比 （n-1）+(n-2)+,,,+1 = n(n-1)/2 次
 * 元素交换次数 < n-1
 * 时间复杂度 O(n^2)
 * 稳定性：不稳定
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int a[] = {605,525,699,715,408};
        selection(a);

    }

    private static void selection(int[] a) {
        //i代表每轮选择最小元素要交换到的目标索引
        for (int i = 0; i < a.length - 1; i++) {
            //min为最小元素索引
            int min = i;
            for (int j = min + 1; j < a.length; j++) {
                if (a[j] < a[min]){
                    // j 元素比 min 元素还要小, 更新 min
                    min = j;
                }
            }
            //i=min，说明在这一轮选择中后面没有比目标搜索i更小的元素，min没有被更新，不需要交换
            if (min != i){
                swap(a,min,i);
            }
            System.out.println(Arrays.toString(a));
        }

    }

}
