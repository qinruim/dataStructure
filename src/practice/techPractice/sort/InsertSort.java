package practice.techPractice.sort;

import java.util.Arrays;

/**
 * 跟扑克牌排序的原理一样：
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；重复步骤 2~5。
 *
 *
 * 最好情况 原本就有序 每一躺只需要比较一次  不用移动元素 时间复杂度O(n)
 * 最坏情况，逆序；第i趟，对比i+1次，移动元素i+2次  时间复杂度O(n^2)
 * 平均时间复杂度 O(n^2)
 * 算法稳定性：稳定
 */
public class InsertSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,41};
//        inset(a);
        insertSort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void insertSort(int[] a) {
       int i,j,temp;
       //遍历数组  将各元素插入已经排好序的序列中
        for (i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]){
                temp = a[i];
                //在排好序的序列中，大于当前待处理元素  就要右移
                for (j = i - 1; j >= 0 && a[j] > temp ; j--) {
                    a[j + 1] = a[j];
                }
                //找到插入位置后， 插入
                a[j + 1] = temp;
            }
        }
    }



    private static void inset(int[] a) {
         //i 待插入元素的索引 从第二个元素开始
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];  //待插入元素值
            int indexOfSorted = i - 1;  //已排序区域元素索引 从i-1开始
            while (indexOfSorted >= 0){ //需要一直比较到第一个元素
                if (temp < a[indexOfSorted]){
                    //优化1 插入时直接移动元素 不交换
                    //若待插入元素小于已排序区域最后一个元素，则需要插入，将已排序区域后移
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
//            System.out.println(Arrays.toString(a));
        }
    }
}
