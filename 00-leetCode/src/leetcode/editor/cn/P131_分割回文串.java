package leetcode.editor.cn;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 * @author qr
 * @date 2023-08-06 10:34:23
 */
class P131_PalindromePartitioning{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P131_PalindromePartitioning().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<String>> result = new ArrayList<>();
	LinkedList<String> path = new LinkedList<>();
	/**
	 * 思路：  回溯找出所有分割方法  对每一个子串判断其是否回文串
	 * @param s
	 * @return
	 */
    public List<List<String>> partition(String s) {
		backTracking(s,0);
		return result;
    }

	private void backTracking(String s, int startIndex) {
		//找到一种分割方法 （走到叶子节点，即起始位置来到最后一个元素后）
		if (s.length() == startIndex){
			result.add(new LinkedList<>(path));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			//startIndex 到 i（startIndex至s.length）之间的字符串是否为回文串，是则继续递归，否则终止
			if (!isPalindrome(s,startIndex,i)){
				// s[start..i] 不是回文串，不能分割 进入下一个i
				continue;
			}
			//s[start..i] 是一个回文串，可以进行分割,继续递归
			path.add(s.substring(startIndex, i + 1));  //substring()方法左闭右开
			//起始位置后移，保证不重复
			backTracking(s, i + 1);
			path.removeLast();



		}



	}


	private boolean isPalindrome(String s, int startIndex, int i) {
		int left = startIndex;
		int right = i;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}
