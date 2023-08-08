package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原 IP 地址
 *
 * @author qr
 * @date 2023-08-08 22:06:27
 */
class P93_RestoreIpAddresses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P93_RestoreIpAddresses().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();

        /**
         * 思路：类似分割回文串，找出所有分割组合，判断每个字串是否符合要求
         * @param s
         * @return
         */
        public List<String> restoreIpAddresses(String s) {

            backTracking(s,0);

            return result;

        }

        private void backTracking(String s, int startIndex) {
            //终止条件：分割成合法的四部分且走到了叶子节点（即起始位置来到最后一个元素后）
            if (startIndex >= s.length() && path.size() == 4){
                result.add(String.join(".",path));
//                result.add(path.toString());
            }

            //遍历 递归（回溯）
            for (int i = startIndex; i < s.length(); i++) {
                //分割的字串[startIndex,i]不符合要求，就跳出此次循环
                if (!isValid(s,startIndex,i)){
                    continue;
                }
                if (path.size() >= 4){
                    //已经分割成四部分，不能再分了
                    break;
                }
                //分割的字串[startIndex,i]符合要求，递归
                path.addLast(s.substring(startIndex,i + 1));
//                path.addLast(".");
                backTracking(s,i + 1);
//                path.removeLast();
                path.removeLast();

            }

        }

        private boolean isValid(String s, int start, int end) {
//            int length = end - start + 1;
//            int sNum = Integer.parseInt(s.substring(start,start + length));
            if (start > end) {
                return false;
            }
            if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
                return false;
            }
//
            int num = 0;
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                    return false;
                }
                num = num * 10 + (s.charAt(i) - '0');
                if (num > 255) { // 如果⼤于255了不合法
                    return false;
                }
            }

//            if ((end - start + 1) >=3 && sNum > 255){
//                return false;
//            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
