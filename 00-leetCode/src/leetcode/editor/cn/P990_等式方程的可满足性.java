package leetcode.editor.cn;

import javax.crypto.spec.OAEPParameterSpec;

/**
 * 等式方程的可满足性
 * satisfiability-of-equality-equations
 * @author mqinrui
 * @date 2023-09-19 16:53:33
 */
class P990_SatisfiabilityOfEqualityEquations{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P990_SatisfiabilityOfEqualityEquations().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 核心思想是，将 equations 中的算式根据 == 和 != 分成两部分，
	 * 先处理 == 算式，使得他们通过相等关系各自勾结成门派（连通分量）；
	 * 然后处理 != 算式，检查不等关系是否破坏了相等关系的连通性。
	 * @param equations
	 * @return
	 */
	public boolean equationsPossible(String[] equations) {
		UF uf = new UF(26);//26个字母
		//让相等的连起来
		for (String eq : equations) {
			if (eq.substring(1,3).equals("==")){
				char x = eq.charAt(0);
				char y = eq.charAt(3);
				uf.union(x - 'a',y - 'a');
			}
		}

		//检查不相等的式子是否能打破连通性(即检查不该相连的是否相连了)
		for (String eq : equations) {
			if (eq.substring(1,3).equals("!=")){
				char x = eq.charAt(0);
				char y = eq.charAt(3);
				if (uf.connected(x - 'a',y - 'a')){
					return false;
				}
//				return !uf.connected(x - 'a',y - 'a');
			}
		}
		return true;
    }

	class UF{
		private int count;
		private int[] parent;
		public UF(int n){
			this.count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public boolean connected(int x,int y){
			//返回两个节点是否相连
			return findRoot(x) == findRoot(y);
		}
		public void union(int x,int y){
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			if (rootY == rootX)return;
			parent[rootX] = rootY;
			count--;
		}

		private int findRoot(int x) {
			if (parent[x] != x){
				parent[x] = findRoot(parent[x]);
			}
			return parent[x];
		}

		private int getCount(){
			return count;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
