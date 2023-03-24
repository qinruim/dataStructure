package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int a[] = {5,3,7,2,9,8,1,4};
        quick(a,0,a.length - 1);
    }

    /**
     * 递归调用分区方法partition，完成排序
     */
    public static void quick(int[] a, int l, int h){
        if (l >= h){
            return;
        }
        //索引值
        int p = partition(a, l, h);
        //缩小分区
        //左边分区范围确定
        quick(a,l,p - 1);
        //右边分区范围确定
        quick(a,p + 1,h);
    }


    /**
     * 单边循环分区方法   让基准点元素移动到正确位置
     * @param a
     * @param l 下边界
     * @param h 上边界
     * @return
     */
    private static int partition(int[] a, int l, int h) {
        //以最右为基准点元素
        int pv = a[h];
        //i是待交换元素的目标索引
        int i = l;
        //寻找比基准点元素小的，与i交换
        for (int j = l; j < h; j++) {
            if (a[j] < pv){
                if (i != j) {
                    Utils.swap(a,i,j);
                }
                i++;
            }
        }
        System.out.println(Arrays.toString(a)+"i:"+i);
        //基准点与i交换
        if (i != h) {
            Utils.swap(a,h,i);
        }
        System.out.println(Arrays.toString(a)+"i:"+i);
        //返回值代表基准点位置的索引，用来确定下一轮分区的边界
        return i;
    }
}
