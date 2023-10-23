package leetcode.editor.cn;

/**
 * 根据规则将箱子分类
 * categorize-box-according-to-criteria
 * @author mqinrui
 * @date 2023-10-20 15:02:25
 */
class P2525_CategorizeBoxAccordingToCriteria{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2525_CategorizeBoxAccordingToCriteria().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
		boolean bulky = false;
		boolean heavy = false;
		int div = 10000;
		long v1 = (long) Math.pow(10,9) / height;
		long v2 = length * width;
		System.out.println(v1);
		System.out.println(v2);
		if (length >= div || width >= div || height >= div || v2 >= v1){
			bulky = true;
		}
		if (mass >= 100){
			heavy = true;
		}

		String res;
		if (bulky){
			if (heavy){
				res = "Both";
			}else {
				res = "Bulky";
			}
		}else {
			if (heavy){
				res = "Heavy";
			}else {
				res = "Neither";
			}
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
