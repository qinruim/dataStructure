package practice.realQuestions.kuaishou;

/**
 * @Package： practice.realQuestions.kuaishou
 * @Title: SortArrays
 * @Author： qrpop
 * @Date： 2023-08-15 14:19
 * @description:
 */
public class SortArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0,0};
        int[] nums2 = {2, 5, 6};

        merge(nums1,3,nums2,3);
        for (int i : nums1) {
            System.out.println(i);
        }

        //这是对的

    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
       int i = m - 1;
       int j = n - 1;
       int k = m + n - 1;

       while(i >= 0 && j >= 0){


           if (nums1[i] >= nums2[j]){
               nums1[k] = nums1[i];
               k--;
               i--;
           }else {
               nums1[k] = nums2[j];
               k--;
               j--;
           }
       }

       //当有一个数组已经被遍历完 剩下数组的直接赋值给k就行
        if (i < 0){
            for (int l = 0; l < j; l++) {
                nums1[l] = nums2[l];
            }
        }
        //j<0 就不用管了
//        if (j < 0){
//            for (int l = 0; l < i; l++) {
//
//            }
//        }

    }
}
