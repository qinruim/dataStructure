package practice.techPractice.tree;

/**
 * 自定义二叉树节点（链式存储）
 * 就是链表节点，不过要两个指针执行左右儿子节点
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
