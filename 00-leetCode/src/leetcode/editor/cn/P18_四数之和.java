package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 4sum
 * @author mqinrui
 * @date 2023-09-08 14:33:02
 */
class P18_FourSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P18_FourSum().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return nSum(nums,4,0,target);
    }

	/**
	 * 求n数和 通用方法
	 * 四数和先找一个 就成了三数和 再找一个 成了两数和 。。类推  递归处理
	 * @param nums 数组
	 * @param n    n数和
	 * @param start  起始元素索引
	 * @param target 目标
	 * @return
	 */
	private List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
		List<List<Integer>> res = new ArrayList<>();
		int size = nums.length;
		//至少应该是2数和 这是base case 所有nSum的基础
		if (n < 2 || size < n){return res;}
		if (n == 2){
			//双指针求二数和即可
			int left = start;
			int right = size - 1;

			while (left < right){
				int leftVal = nums[left];
				int rightVal = nums[right];
				int sum = leftVal + rightVal;

				if (sum == target){
//					res.add(new ArrayList<>(Arrays.asList(leftVal,rightVal)));
					List<Integer> list = new ArrayList<>();
					list.add(leftVal);
					list.add(rightVal);
					res.add(list);
					while (left < right && nums[left] == leftVal)left++;
					while (left < right && nums[right] == rightVal)right--;
				}else if (sum < target){
					while (left < right && nums[left] == leftVal)left++;
				}else {
					while (left < right && nums[right] == rightVal)right--;
				}
			}

		}
		if (n > 2){
			//n > 2: 递归 就是先取一个 然后递归n-1
			for (int i = start; i < size; i++) {
				List<List<Integer>> sub
						= nSum(nums,n - 1,i + 1,target - nums[i]);
				//在 n-1 和的基础上加上 nums[i] 即可
				for (List<Integer> nMinus1SUm : sub) {
					nMinus1SUm.add(nums[i]);
					res.add(nMinus1SUm);
				}

				//保证nums[i] 不重复
				while (i < size - 1 && nums[i] == nums[i + 1])i++;
			}
		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
