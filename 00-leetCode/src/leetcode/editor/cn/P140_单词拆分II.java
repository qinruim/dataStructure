package leetcode.editor.cn;

import java.util.*;

/**
 * 单词拆分 II
 *
 * @author qr
 * @date 2023-08-27 17:12:52
 */
class P140_WordBreakIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P140_WordBreakIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> wordDict;
//        LinkedList<String> res;
        List<String>[] memo;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
//            this.res = new LinkedList<>();
            this.memo = new List[s.length()];
            return dp(s,0);

        }

        private List<String> dp(String s, int i) {
            LinkedList<String> res = new LinkedList<>();

            if (i == s.length()){
                res.add(" ");
                return res;
            }

            if (memo[i] != null){
                return memo[i];
            }

            //遍历s[i...]所有前缀
            for (int len = 1; len + i <= s.length() ; len++) {
                String prefix = s.substring(i,i + len);
                //字典包含 s[i,...i + len]
                if (wordDict.contains(prefix)){
                    List<String> subProblem = dp(s,i + len);
                    //构成s[i+len,...] 的组合 加上 prefix   就是构成s[i,...]的组合
                    for (String sub : subProblem) {
                        if(sub == null){
                            res.add(prefix);
                        }else {
                            res.add(prefix + " " + sub);
                        }

                    }
                }
            }

            memo[i] = res;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
