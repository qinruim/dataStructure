package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author qr
 * @date 2023-08-14 12:29:49
 */
class P46_Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permute(int[] nums) {
            //used数组是给同一条树枝上的重复元素去重
            used = new boolean[nums.length];
            backTrack(nums);
            return res;
        }

        private void backTrack(int[] nums) {
            //排列 有序 不要startIndex控制元素相对位置来去重
            if (track.size() == nums.length){
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]){
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                backTrack(nums);
                used[i] = false;
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
