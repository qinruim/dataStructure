package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int a[] = {2,4,6,12,8,6,99,43,41};
        shell(a);
    }

    private static void shell(int[] a) {
        int n = a.length;
        //初始gap为例n/2
        for (int gap = n / 2; gap > 0; gap /= 2) {
            //在间隙序列内插入排序 因此是从 0+gap 开始
            for (int i = gap; i < n; i++) {
                int t = a[i]; //待插入元素值
                int j = i - gap; //已排序区域最后一个元素索引 i-gap （从i开始排序）
                while (j >= gap){
                    if (t < a[j]){
                        //若待插入元素小于已排序区域最后一个元素，需要将已排序区域后移
                        a[j + gap] = a[j];
                    }
                    else {
                        // 当待插入元素进行比较时，遇到比自己小（或等）的元素，代表找到了插入位置，无需进行后续比较
                        break;
                    }
                    j -= gap;
                }
                //j-- 之后 j+1 即为空出来的位置
                a[j + gap] = t;
                System.out.println(Arrays.toString(a));
            }
        }
    }
}
