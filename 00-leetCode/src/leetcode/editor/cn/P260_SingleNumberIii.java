package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字 III
 * @author mqinrui
 * @date 2023-06-27 08:30:25
 */
public class P260_SingleNumberIii{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P260_SingleNumberIii().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
		Set<Integer> singleNbSet = new HashSet<>();
		for (int num : nums) {
			if (singleNbSet.contains(num)){
				singleNbSet.remove(num);
			}
			else {
				singleNbSet.add(num);
			}
		}
		int i = 0;
		int[] res = new int[singleNbSet.size()];
		for (Integer integer : singleNbSet) {
			res[i++] = integer;
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
