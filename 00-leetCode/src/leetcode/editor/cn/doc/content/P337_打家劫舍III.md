<p>小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
 <meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;。</p>

<p>除了
 <meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 <strong>两个直接相连的房子在同一天晚上被打劫</strong> ，房屋将自动报警。</p>

<p>给定二叉树的&nbsp;<code>root</code>&nbsp;。返回&nbsp;<em><strong>在不触动警报的情况下</strong>&nbsp;，小偷能够盗取的最高金额</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob1-tree.jpg" /></p>

<pre>
<strong>输入: </strong>root = [3,2,3,null,3,null,1]
<strong>输出:</strong> 7 
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7</pre>

<p><strong>示例 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/03/10/rob2-tree.jpg" /></p>

<pre>
<strong>输入: </strong>root = [3,4,5,1,3,null,1]
<strong>输出:</strong> 9
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额 4 + 5 = 9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<p>
 <meta charset="UTF-8" /></p>

<ul> 
 <li>树的节点数在&nbsp;<code>[1, 10<sup>4</sup>]</code> 范围内</li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 动态规划 | 二叉树</details><br>

<div>👍 1759, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=house-robber-iii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 201 页。

这题 [打家劫舍 I](#198) 和 [打家劫舍 II](#213) 的思路完全一样，稍微改写一下就出来了。

**详细题解：[一个方法团灭 LeetCode 打家劫舍问题](https://labuladong.github.io/article/fname.html?fname=抢房子)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    unordered_map<TreeNode*, int> memo;

    int rob(TreeNode* root) {
        if (root == nullptr) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.count(root))
            return memo[root];
        // 抢，然后去下下家
        int do_it = root->val
                    + (root->left == nullptr ?
                       0 : rob(root->left->left) + rob(root->left->right))
                    + (root->right == nullptr ?
                       0 : rob(root->right->left) + rob(root->right->right));
        // 不抢，然后去下家
        int not_do = rob(root->left) + rob(root->right);

        int res = max(do_it, not_do);
        memo[root] = res;
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        self.memo = {}

    def rob(self, root: TreeNode) -> int:
        if not root:
            return 0

        # 利用备忘录消除重叠子问题
        if root in self.memo:
            return self.memo[root]

        # 抢，然后去下下家
        do_it = root.val
        if root.left:
            do_it += self.rob(root.left.left) + self.rob(root.left.right)
        if root.right:
            do_it += self.rob(root.right.left) + self.rob(root.right.right)

        # 不抢，然后去下家
        not_do = self.rob(root.left) + self.rob(root.right)

        res = max(do_it, not_do)
        self.memo[root] = res
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root))
            return memo.get(root);
        // 抢，然后去下下家
        int do_it = root.val
                + (root.left == null ?
                0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ?
                0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// Definition for a binary tree node.
// type TreeNode struct {
//     Val int
//     Left *TreeNode
//     Right *TreeNode
// }

func rob(root *TreeNode) int {
    memo := make(map[*TreeNode]int)
    var robSub func(*TreeNode) int
    robSub = func(node *TreeNode) int {
        if node == nil {
            return 0
        }
        if _, ok := memo[node]; ok {
            return memo[node]
        }
        //考虑偷取该节点
        doIt := node.Val
        if node.Left != nil {
            doIt += robSub(node.Left.Left) + robSub(node.Left.Right)
        }
        if node.Right != nil {
            doIt += robSub(node.Right.Left) + robSub(node.Right.Right)
        }
        //不偷取该节点
        notDo := robSub(node.Left) + robSub(node.Right)
        res := max(doIt, notDo)
        memo[node] = res
        return res
    }
    return robSub(root)
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var rob = function(root) {
    const memo = new Map();
    if (root === null) {
        return 0;
    }
    // 利用备忘录消除重叠子问题
    if (memo.has(root)) {
        return memo.get(root);
    }
    // 抢，然后去下下家
    let do_it = root.val +
        ((root.left === null) ?
            0 :
            rob(root.left.left) + rob(root.left.right)) +
        ((root.right === null) ?
            0 :
            rob(root.right.left) + rob(root.right.right));
    // 不抢，然后去下家
    let not_do = rob(root.left) + rob(root.right);
    let res = Math.max(do_it, not_do);
    memo.set(root, res);
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_house-robber-iii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_house-robber-iii"></div></div>
</details><hr /><br />

**类似题目**：
  - [198. 打家劫舍 🟠](/problems/house-robber)
  - [213. 打家劫舍 II 🟠](/problems/house-robber-ii)
  - [剑指 Offer II 089. 房屋偷盗 🟠](/problems/Gu0c2T)
  - [剑指 Offer II 090. 环形房屋偷盗 🟠](/problems/PzWKhm)

</details>
</div>

