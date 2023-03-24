package sort;

import java.util.Arrays;

import static sort.Utils.swap;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,41};

        bubble(a);
    }

    private static void bubble(int[] a) {
        int n = a.length - 1;
        //冒泡次数
        while (true){
            //一轮冒泡
//            boolean swapped = false;
            //最后一次交换索引位置
            int lastSwapIndex = 0;
            for (int i = 0; i < n; i++) {
                System.out.println("比较次数" + i);
                if (a[i] > a[i +1]){
                    swap(a,i,i + 1);
//                    swapped = true;
                    lastSwapIndex = i;
                }
            }
            System.out.println("第轮冒泡" + Arrays.toString(a));
            //每轮冒泡时，最后一次交换索引可以作为下一轮冒泡的比较次数，
            //若为0，表示整个数组有序，直接结束
            n = lastSwapIndex;
            if (n == 0){
                break;
            }
        }

        System.out.println(Arrays.toString(a));
    }

}
