package leetcode.editor.cn;

/**
 * 两数之和 II - 输入有序数组
 * two-sum-ii-input-array-is-sorted
 * @author mqinrui
 * @date 2023-08-30 11:21:55
 */
class P167_TwoSumIiInputArrayIsSorted{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P167_TwoSumIiInputArrayIsSorted().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
		int left = 0,right = numbers.length - 1;
		int[] res = new int[2];
		while (left < right){
			int temp = numbers[left] + numbers[right];
			if (temp == target){
//				return new int[]{left + 1, right + 1};
				res[0] = left + 1;
				res[1] = right + 1;
				break;
			}else if (temp < target){
				left++;
			}else if (temp > target){
				right--;
			}
		}



//		return null;
		return res;
//		return new int[]{-1,-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
