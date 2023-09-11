package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * 最接近的三数之和
 * 3sum-closest
 * @author mqinrui
 * @date 2023-09-08 15:31:24
 */
class P16_ThreeSumClosest{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P16_ThreeSumClosest().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3){
			return 0;
		}

		String s = "sss";
		s.toLowerCase();
		Arrays.sort(nums);
		//记录三数和与target的偏差
		int delta = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			int sum = nums[i] + twoSumClosest(nums,i + 1,target - nums[i]);
			if (Math.abs(delta) > Math.abs(target - sum)){
				//保留小的偏差
				delta = target - sum;
			}
		}
		return target - delta;
    }

	private int twoSumClosest(int[] nums, int start, int target) {
		int left = start;
		int right = nums.length - 1;

		int delta = Integer.MAX_VALUE;

		while (left < right){
			int sum = nums[left] + nums[right];

			if (Math.abs(delta) > Math.abs(target - sum)){
				delta = target - sum;
			}
			if (sum < target){
				left++;
			}if (sum >= target){
				right--;
			}
		}

		return target - delta;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
