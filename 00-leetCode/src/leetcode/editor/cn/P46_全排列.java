package leetcode.editor.cn;

import java.util.ArrayList;
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
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            //used数组记录当前元素是否已经在path里面，防止重复(boole数组默认值是false)
            boolean[] used = new boolean[nums.length];
            backTracking(nums,used);

            return result;
        }

        private void backTracking(int[] nums,boolean[] used) {
            if (path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i] == true){
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums,used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
