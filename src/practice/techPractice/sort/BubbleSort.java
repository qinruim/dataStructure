package practice.techPractice.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,100};

//        bubble(a);
        //简单方法 捋清思路
        bubbleSort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        //从第length - 1 个开始  一直到第一个
        for (int j = a.length - 1; j > 0; j--) {
            //每一轮找j及之前最大的数沉底
            findMax(a, j);

        }
    }

    private static void findMax(int[] a, int j) {
        //找到第n个位置应该放的元素,并放过去
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]){
                Utils.swap(a,i,i + 1);
            }
        }

    }

    private static void bubble(int[] a) {
        //每轮冒泡的比较次数n，初始为length-1
        int n = a.length - 1;

        while (true) {
            //记录最后一次交换的索引位置，可以作为下一轮冒泡的比较次数
            // (在这个索引之后的元素是已经沉底的，因此这个索引即下一轮比较次数)
            int lastSwapIndex = 0;


            //一轮冒泡
            for (int i = 0; i < n; i++) {
                //将大的沉底
                if (a[i] > a[i + 1]){
                    Utils.swap(a,i,i + 1);
                    lastSwapIndex = i;
                }
            }


            //每轮冒泡时，最后一次交换索引可以作为下一轮冒泡的比较次数
            n = lastSwapIndex;
            //到n为0  即索引为0后面的元素已将全部沉底，数组已经有序
            if(n == 0){
                break;
            }

        }


    }


}
