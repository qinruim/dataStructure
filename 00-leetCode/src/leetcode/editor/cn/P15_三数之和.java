package leetcode.editor.cn;

import java.util.*;

/**
 * 三数之和
 * 3sum
 * @author mqinrui
 * @date 2023-09-06 17:22:20
 */
class P15_ThreeSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P15_ThreeSum().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		//第一个可能是数组中的任意元素   剩下两个就成了两数和问题
		Arrays.sort(nums);
		int n = nums.length;

		List<List<Integer>> res = new ArrayList<>();

		//穷举第一个数
		for (int i = 0; i < n; i++) {
			// 跳过第一个数字重复的情况，否则会出现重复结果 写在后面也行
			if (i > 0 && nums[i] == nums[i - 1]){
				continue;
			}

			//找是否存在剩下两个数
			List<List<Integer>> twos = twoSum(nums,i + 1,0 - nums[i]);

			//如果存在二元组 那加上nums[i]即可
			for (List<Integer> aTwoList : twos) {
				aTwoList.add(nums[i]);
				res.add(aTwoList);
			}

//			// 跳过第一个数字重复的情况，否则会出现重复结果
//			while (i < n - 1 && nums[i] == nums[i + 1]){
//				i++;
//			}

		}
		return res;
    }

	private List<List<Integer>> twoSum(int[] nums, int start, int target) {
		//在nums数组start开始的元素中找和为target的两个数
		List<List<Integer>> twos = new ArrayList<>();
		int left = start;
		int right = nums.length - 1;

		while (left < right){
			int leftVal = nums[left];
			int rightVal = nums[right];
			int sum = leftVal + rightVal;
			if (sum == target){
				List<Integer> aTwoList = new ArrayList<>();
				aTwoList.add(nums[left]);
				aTwoList.add(nums[right]);
				twos.add(aTwoList);
				while (left < right && nums[left] == leftVal){
					left++;
				}
				while (left < right && nums[right] == rightVal){
					right--;
				}
			}else if (sum < target){
				while (left < right && nums[left] == leftVal){
					left++;
				}
			}else if (sum > target){
				while (left < right && nums[right] == rightVal){
					right--;
				}
			}
		}

		return twos;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
