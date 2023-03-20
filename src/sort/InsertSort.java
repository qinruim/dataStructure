package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,41};
        inset(a);
    }

    private static void inset(int[] a) {
         //i 待插入元素的索引 从第二个元素开始
        for (int i = 1; i < a.length; i++) {
            int t = a[i];  //待插入元素值
            int j = i - 1;  //已排序区域元素索引 从i-1开始
            while (j >= 0){ //需要一直比较到第一个元素
                if (t < a[j]){
                    //优化1 插入时直接移动元素 不交换
                    //若待插入元素小于已排序区域最后一个元素，需要将已排序区域后移
                    a[j + 1] = a[j];
                }else {
                    //优化2
                    // 当待插入元素进行比较时，遇到比自己小（或等）的元素，代表找到了插入位置，无需进行后续比较
                    break;
                }
                j --;
            }
            //j-- 之后 j+1 即为空出来的位置
              a[j + 1] = t;
            System.out.println(Arrays.toString(a));
        }
    }
}
