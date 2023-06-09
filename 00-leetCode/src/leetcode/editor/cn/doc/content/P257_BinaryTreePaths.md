<p>给你一个二叉树的根节点 <code>root</code> ，按 <strong>任意顺序</strong> ，返回所有从根节点到叶子节点的路径。</p>

<p><strong>叶子节点</strong> 是指没有子节点的节点。</p> &nbsp;

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/paths-tree.jpg" style="width: 207px; height: 293px;" /> 
<pre>
<strong>输入：</strong>root = [1,2,3,null,5]
<strong>输出：</strong>["1-&gt;2-&gt;5","1-&gt;3"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>["1"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点的数目在范围 <code>[1, 100]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 字符串 | 回溯 | 二叉树</details><br>

<div>👍 966, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
本题思路为《[手把手刷二叉树系列教程](https://aep.xet.tech/s/3YGcq3)》的专属内容，用 [手把手带你刷二叉树（纲领篇）](https://labuladong.gitee.io/article/fname.html?fname=二叉树总结) 中的两种思维模式秒杀所有二叉树的题目，并延伸到回溯算法和动态规划系列问题。如果你已经购买课程还无法查看，请点击 [这里](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_63956417e4b02685a425cc0d/1) 查看各个插件的解锁方法。如遇到问题，可以在 [bug 反馈页面](https://github.com/labuladong/fucking-algorithm/discussions/704) 反馈。</details>
</div>



