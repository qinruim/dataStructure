package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 * letter-combinations-of-a-phone-number
 * @author mqinrui
 * @date 2023-08-04 15:58:55
 */
class P17_LetterCombinationsOfAPhoneNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

		 ArrayList<String> result = new ArrayList<>();
		 StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
		//0-9数字跟字母的映射
		String[] numToLetterMap = {"abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};

//		HashMap<Integer,String> map = new HashMap<>();
//		map.put(2,"abc");

		if (digits == null || digits.length() == 0){
//			result.add("");
			return result;
		}

		//index记录遍历到digits中的第几个数字了
		backTracking(digits,numToLetterMap,0);

		return result;


	}

	private void backTracking(String digits, String[] numToLetterMap, int index) {
		if (path.length() == digits.length()){
			result.add(new String(path));
			return;
		}

		//当前index指向数字对应的字符串
		String str = numToLetterMap[digits.charAt(index) - '2'];
		for (int i = 0; i <str.length(); i++) {
			path.append(str.charAt(i));
			backTracking(digits,numToLetterMap, index + 1);
			path.deleteCharAt(path.length() - 1);
		}


	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
