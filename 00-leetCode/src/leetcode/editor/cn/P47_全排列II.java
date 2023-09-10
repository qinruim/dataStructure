package leetcode.editor.cn;

import java.util.*;

/**
 * 全排列 II
 * permutations-ii
 *
 * @author mqinrui
 * @date 2023-08-16 23:26:43
 */
class P47_PermutationsIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P47_PermutationsIi().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            backTracking(nums,used);
            return result;
        }

        private void backTracking(int[] nums, boolean[] used) {
            if (track.size() == nums.length){
                result.add(new ArrayList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                //树层去重 即used[i-1]回溯了，是false，且nums[i] == nums[i-1],剪枝
                //保证相同元素相对位置不变
                if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]){
                    continue;
                }
                //排列每个元素都是从0开始遍历，防止排列重复
                if (used[i]){
                    continue;
                }
                used[i] = true;
                track.add(nums[i]);
                backTracking(nums,used);
                track.removeLast();
                used[i] = false;


            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
