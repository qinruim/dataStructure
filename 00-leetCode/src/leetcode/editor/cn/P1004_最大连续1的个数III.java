package leetcode.editor.cn;

/**
 * 最大连续1的个数 III
 * @author qr
 * @date 2023-08-28 22:54:39
 */
class P1004_MaxConsecutiveOnesIii{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1004_MaxConsecutiveOnesIii().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
		int res = 0;
		int left = 0,right = 0;

		while (right < nums.length){
			//碰到1 以及k个以内0 扩
			//这里加while  如果k比较大 可能直接干到底 索引溢出
//			while (k > 0){
				if (nums[right] == 0){
					k--;
				}
				right++;
//			}



			//当k个0用完了 缩
			while (k < 0){
				if (nums[left] == 0){
					k++;
				}
				left++;
			}

			res = Math.max(res,right - left);
		}



		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
