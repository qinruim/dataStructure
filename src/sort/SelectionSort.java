package sort;

import java.util.Arrays;

import static sort.Utils.swap;

public class SelectionSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,41};
        selection(a);

    }

    private static void selection(int[] a) {
        //i代表每轮选择最小元素要交换到的目标索引（未排序部分的最前面）
        for (int i = 0; i < a.length - 1; i++) {
            //min为最小元素索引
            int min = i;
            for (int j = min + 1; j < a.length; j++) {
                if (a[j] < a[min]){
                    // j 元素比 min 元素还要小, 更新 min
                    min = j;
                }
            }
            //i=min不需要交换
            if (min != i){
                swap(a,min,i);
            }
            System.out.println(Arrays.toString(a));
        }

    }

}
