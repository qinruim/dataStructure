package leetcode.editor.cn;

/**
 * 找出数组的串联值
 * find-the-array-concatenation-value
 * @author mqinrui
 * @date 2023-10-12 09:35:07
 */
class P2562_FindTheArrayConcatenationValue{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2562_FindTheArrayConcatenationValue().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long findTheArrayConcVal(int[] nums) {
		long res = 0;
		int left = 0;
		int right = nums.length - 1;

		while (left <= right){
			if (left == right){
				res += nums[left];
				left++;
				right--;
				continue;
			}
			int i = String.valueOf(nums[right]).length();
			res += nums[left] * Math.pow(10,i) + nums[right];
			left++;
			right--;
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
