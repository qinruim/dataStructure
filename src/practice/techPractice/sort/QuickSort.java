package practice.techPractice.sort;

import java.lang.reflect.WildcardType;
import java.util.Arrays;

/**
 * 快速排序使用分治法open in new window（Divide and conquer）策略来把一个序列分为较小和较大的 2 个子序列，
 * 然后递回地排序两个子序列。
 * 具体算法描述如下：
 * 从序列中随机挑出一个元素，做为 “基准”(pivot)；
 * 重新排列序列，将所有比基准值小的元素摆放在基准前面，所有比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个操作结束之后，该基准就处于数列的中间位置。
 * 这个称为分区（partition）操作；
 * 递归地把小于基准值元素的子序列和大于基准值元素的子序列进行快速排序
 *
 * 稳定性：不稳定
 * 时间复杂度：最佳：O(nlogn)， 最差：O(nlogn)，平均：O(nlogn)
 * 空间复杂度：O(logn)
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
     * 划分左右子表  将所有比基准值小的元素摆放在基准前面，所有比基准值大的摆在基准的后面（相同的数可以到任一边）
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int part(int[] a, int low, int high) {
        //双向扫描分区
        //① 与单向扫描分区法大体类似,区别在于：双向扫描分区法的左指针与右指针同时扫描
        //② 左指针往右扫描,直到遇到第一个大于主元的元素停下；右指针往左扫描,知道遇到第一个小于等于主元的元素停下
        //③ 将两指针所指元素交换位置后,两指针继续扫描,重复②
        int pivot = a[low]; //第一个元素作为轴
        int left = low + 1;
        int right = high;
        while (left < right){
            //左指针指向元素小于轴元素，一直右移
            while (a[left] <= pivot && left < right){
                left++;
            }
            //当左指针指向元素大于轴元素，交换
            Utils.swap(a,left,right);
            //开始遍历右指针
            while (a[right] >= pivot && left < right){
                right--;
            }
            Utils.swap(a,left,right);
        }

        Utils.swap(a,low,left);

        return left;


//        while (low < high){ //双指针向中间搜索，确定轴最后位置
//            while (a[high] >= pivot && low < high){high--;}
//            a[low] = a[high];
//            while (a[low] <= pivot && low < high){low++;}
//            a[high] = a[low];
//        }
//
//        a[low] = pivot;  //轴元素最终存放位置（此时low = high）
//
//        return low;
    }



}
