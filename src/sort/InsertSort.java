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
            int temp = a[i];  //待插入元素值
            int indexOfSorted = i - 1;  //已排序区域元素索引 从i-1开始
            while (indexOfSorted >= 0){ //需要一直比较到第一个元素
                if (temp < a[indexOfSorted]){
                    //优化1 插入时直接移动元素 不交换
                    //若待插入元素小于已排序区域最后一个元素，需要将已排序区域后移
                    a[indexOfSorted + 1] = a[indexOfSorted];
                }else {
                    //优化2
                    // 当待插入元素进行比较时，遇到比自己小（或等）的元素，代表找到了插入位置，无需进行后续比较
                    break;
                }
                indexOfSorted --;
            }
            //indexOfSorted-- 之后 indexOfSorted+1 即为空出来的位置
              a[indexOfSorted + 1] = temp;
            System.out.println(Arrays.toString(a));
        }
    }
}
