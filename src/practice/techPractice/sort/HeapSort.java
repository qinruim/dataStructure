package practice.techPractice.sort;


import javafx.util.Builder;

import java.util.Arrays;

import static practice.techPractice.sort.Utils.swap;
import static practice.techPractice.sort.Utils.swapInt;

/**
 * 堆排序：利用堆的特点，将无序数组堆化，最顶部就是最大/最小元素  取出来，剩下的继续堆化 迭代值最后一个元素
 * 步骤： 1.建堆：建堆的过程就是一个对所有非叶节点（最后一个节点的父节点及之前的节点 1~n/2）的自顶向下堆化过程
 *       2.排序：堆顶元素是所有元素中最大的，所以我们重复取出堆顶元素，将这个最大的堆顶元素放至数组末尾，并对剩下的元素进行堆化即可。
 *
 *       具体实施：将初始待排序列 (R1, R2, ……, Rn) 构建成大顶堆，此堆为初始的无序区；
 *               将堆顶元素 R[1] 与最后一个元素 R[n] 交换，此时得到新的无序区 (R1, R2, ……, Rn-1) 和新的有序区 (Rn), 且满足 R[1, 2, ……, n-1]<=R[n]；
 *               由于交换后新的堆顶 R[1] 可能违反堆的性质，因此需要对当前无序区 (R1, R2, ……, Rn-1) 调整为新堆，
 *               然后再次将 R [1] 与无序区最后一个元素交换，得到新的无序区 (R1, R2, ……, Rn-2) 和新的有序区 (Rn-1, Rn)。
 *               不断重复此过程直到有序区的元素个数为 n-1，则整个排序过程完成
 *
 *
 * 稳定性：不稳定
 * 时间复杂度：最佳：O(nlogn)， 最差：O(nlogn)， 平均：O(nlogn)
 * 空间复杂度：O(1)
 */
public class HeapSort {
    static int heapLength ;
    public static void main(String[] args) {
        int arr[] = {20,4,6,12,8,9,99,43,41};

        //1.堆化前n个元素，即将非叶子节点（第 1~n/2 个节点）沉底即可
        //需要堆化前n个，n-1个。。。至2个为止
        heapLength = arr.length;
        //初始堆化
        buildheap(arr);
//        System.out.println(Arrays.toString(arr));

        //不断取堆顶元素与尾部元素交换，将新堆顶元素下沉
        for (int i = heapLength - 1; i > 0; i--) {
            swap(arr,0,i);
            heapLength--;
            bottom(arr,0);
        }

        System.out.println(Arrays.toString(arr));


    }

    /**
     * 初始沉底 1-n/2 的元素
     * @param a
     */
    private static void buildheap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            //沉底第i个元素
            bottom(a,i);
        }
    }

    /**
     * 将第i个元素沉底
     * @param a
     * @param i
     */
    private static void bottom(int[] a, int i) {
        //第i个元素（i-1）在heapLength个元素中沉底，即不断与两个孩子比较跟大的交换
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        //将第i个元素在heapLength个元素中递归沉底
        int max = i;
        if (rightChild < heapLength && a[rightChild] > a[max]){
            max = rightChild;
        }
        if (rightChild < heapLength && a[leftChild] > a[max]){
            max = leftChild;
        }

        if (max != i){
            swap(a,i,max);
            //递归到heapLength位置
            bottom(a,max);
        }

    }
}
