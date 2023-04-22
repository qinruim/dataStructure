package netEase;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        //[2,3,5,4],2
        int k = 2;
        int[] price = new int[4];
        price[0] = 2;
        price[1] = 3;
        price[2] = 4;
        price[3] = 5;

        int res = putGenms(price, k);
        System.out.println(res);
    }

    private static int putGenms(int[] price, int k) {
        if (price.length <= k){
            return 0;
        }
        Arrays.stream(price).sorted();
        System.out.println(Arrays.toString(price));

        int maxLen = (price.length - k >> 1) + 1;
        System.out.println(maxLen);
        int minLen = 2;
        System.out.println(minLen);
        int[] min = new int[minLen];
        int[] max = new int[maxLen];
        int minSum = 0;
        int maxSum = 0;

        for (int i = 0; i < minLen; i++) {
            min[i] = price[i];
            minSum += min[i];
        }
        for (int i = 0; i < maxLen; i++) {
            max[i] = price[price.length - 1 - i];
            maxSum += max[i];
        }

        return maxSum - minSum;
    }


}
