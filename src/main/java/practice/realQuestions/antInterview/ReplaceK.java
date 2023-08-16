package practice.realQuestions.antInterview;

public class ReplaceK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(solution(2, nums));
    }

    private static int solution(int k, int[] nums){
        int length = nums.length;

        int zeroCount = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < length; right++) {
           if(nums[right] == 0) {
               zeroCount++;
           }

           while(zeroCount > k){
               if(nums[left] == 0){
                   zeroCount--;
               }
               left++;
           }
           result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
