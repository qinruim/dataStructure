package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 被围绕的区域
 * surrounded-regions
 *
 * @author mqinrui
 * @date 2023-09-18 16:25:00
 */
class P130_SurroundedRegions {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P130_SurroundedRegions().new Solution();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }


        System.out.println("==========");


        solution.solve(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        LinkedList<int[]> isLand = new LinkedList<>();
        List<List<int[]>> isLands = new ArrayList<>();

        public void solve(char[][] board) {
            //dfs
            method1(board);
            //并查集
            method2(board);

        }

        private void method2(char[][] board) {
            //把那些不需要被替换的 O 看成一个拥有独门绝技的门派，
            // 它们有一个共同「祖师爷」叫 dummy，这些 O 和 dummy 互相连通，
            // 而那些需要被替换的 O 与 dummy 不连通。

            //二维坐标 (x,y) 可以转换成 x * n + y 这个数
            if (board.length == 0){
                return;
            }
            int m = board.length,n = board[0].length;
            //给dummy留一个位置 因此大小要+1
            UF uf = new UF(m * n + 1);
            int dummy = m * n;

            //将四个边的O与dummy相连
            for (int i = 0; i < m; i++) {
                //i,0 首列
                if (board[i][0] == 'O'){
                    uf.union(i * n,dummy);
                }
                //i，n-1 末列
                if (board[i][n - 1] == 'O'){
                    uf.union(i * n + n - 1,dummy);
                }
            }
            for (int j = 0; j < n; j++) {
                //首行 0，j
                if(board[0][j] == 'O'){
                    uf.union(j,dummy);
                }
                //末行 m - 1，j
                if(board[m - 1][j] == 'O'){
                    uf.union((m - 1) * n + j,dummy);
                }
            }

            //将所有相邻的O 相连
            int[][] d = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};//右上下左
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (board[i][j] == 'O'){
                        //将遍历到的O与上下左右的O相连
                        for (int k = 0; k < 4; k++) {
                            int x = d[k][0] + i;
                            int y = d[k][1] + j;
                            if (board[x][y] == 'O'){
                                uf.union(i * n + j,x * n + y);
                            }
                        }
                    }

                }
            }

            //将所有不和dummy相连的O替换掉即可
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                   if (board[i][j] =='O' && !uf.connected(i * n + j,dummy)){
                       board[i][j] = 'X';
                   }
                }
            }



        }

        private void method1(char[][] board) {
            int m = board.length, n = board[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && board[i][j] == 'O' && dfs(board, i, j)) {
//                        board[i][j] = 'X';
                        isLands.add(new LinkedList<>(isLand));
                    }
                    isLand.clear();
                }
            }

            for (List<int[]> land : isLands) {
                for (int[] pos : land) {
                    board[pos[0]][pos[1]] = 'X';
                }
            }

        }

        private boolean dfs(char[][] board, int i, int j) {
            int m = board.length, n = board[0].length;

            if (i < 0 || j < 0 || i >= m || j >= n) {
                return false;
            }
            if (visited[i][j] || board[i][j] == 'X') {
                return true;
            }

            visited[i][j] = true;

            int[] pos = new int[]{i, j};
            isLand.add(pos);

            boolean a = dfs(board, i, j - 1);
            boolean b = dfs(board, i, j + 1);
            boolean c = dfs(board, i - 1, j);
            boolean d = dfs(board, i + 1, j);
//            visited[i][j] = false;
            return a && b && c && d;
        }

        private class UF {
            private int count; //连通分量个数
            private int[] parent; //存储每个节点的父节点
            public UF(int n) {
                this.count = n;
                parent = new int[n];
                //初始化父节点指向自己
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public boolean connected(int x,int y){
                return findRoot(x) == findRoot(y);
            }
            public void union(int x,int y){
                //连通两个节点
                int rootX = findRoot(x);
                int rootY = findRoot(y);

                if (rootX == rootY)return;

                parent[rootX] = rootY;
                count--;
            }

            private int findRoot(int x) {
                //获取根节点
                //递归将当前节点接到根节点
                if (parent[x] != x){
                    //将当前节点 x 的父节点（parent[x]）更新为 x 所属集合的根节点。
                    //为了找到根节点，它会继续递归调用 findRoot 方法，直到找到根节点为止
                    parent[x] = findRoot(parent[x]);
                }
                return parent[x];
            }

            public int count(){
                return count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
