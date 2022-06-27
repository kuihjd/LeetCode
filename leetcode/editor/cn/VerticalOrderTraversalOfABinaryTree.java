//给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。 
//
// 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的
//根结点位于 (0, 0) 。 
//
// 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则
//按结点的值从小到大进行排序。 
//
// 返回二叉树的 垂序遍历 序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
//解释：
//列 -1 ：只有结点 9 在此列中。
//列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
//列  1 ：只有结点 20 在此列中。
//列  2 ：只有结点 7 在此列中。 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[[4],[2],[1,5,6],[3],[7]]
//解释：
//列 -2 ：只有结点 4 在此列中。
//列 -1 ：只有结点 2 在此列中。
//列  0 ：结点 1 、5 和 6 都在此列中。
//          1 在上面，所以它出现在前面。
//          5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
//列  1 ：只有结点 3 在此列中。
//列  2 ：只有结点 7 在此列中。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2,3,4,6,5,7]
//输出：[[4],[2],[1,5,6],[3],[7]]
//解释：
//这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
//因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。 
//
// 
//
// 提示： 
//
// 
// 树中结点数目总数在范围 [1, 1000] 内 
// 0 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 
// 👍 112 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：二叉树的垂序遍历
public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        List<Info> map;

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (root == null) return res;
            map = new ArrayList<Info>();
            helper(root, 0, 0);
            map.sort(Info::comperTo);
            int curr = map.get(0).x;
            List<Integer> temp = new ArrayList<>();
            for (Info i : map) {
                if (i.x == curr) {
                    temp.add(i.val);
                } else {
                    res.add(temp);
                    temp = new ArrayList<>();
                    temp.add(i.val);
                    curr = i.x;
                }
            }
            return res;
        }

        void helper(TreeNode root, int x, int y) {
            if (root == null) return;
            map.add(new Info(x, y, root.val));
            helper(root.left, x - 1, y + 1);
            helper(root.right, x + 1, y + 1);
        }
    }

    class Info {
        int x;
        int y;
        int val;

        Info(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        int comperTo(Info o) {
            if (this.x != o.x) return this.x - o.x;
            if (this.y != o.y) return this.y - o.y;
            return this.val - o.val;
        }
    }
}








    /*
    class Solution {
        ArrayList<Info>[] map;
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res=new ArrayList<List<Integer>>();
            map=new ArrayList<?extends Info>[2001];
            helper(root,0,0);
            for(int i=0;i<=2000;++i){
                if(map[i]!=null){
                    Arrays.sort(map[i],(Info o1,Info o2)->o1.comperTo(o2));
                    res.add(to(map[i]));
                }
            }
            return res;
        }
        void helper(TreeNode root,int x,int y){
            if(root==null) return;
            if(map[x+1000]==null)map[x+1000]=new ArrayList<>();
            map[x+1000].add(new Info(y,root.val));
            helper(root.left,x-1,y+1);
            helper(root.right,x+1,y+1);
        }
        List<Integer> to(List<Info> info){
            List<Integer> res=new ArrayList<Info>;
            for(Info i:info){
                res.add(i.val);
            }
        }
    }
    }
    class Info{
        int index;
        int val;
        Info(int index,int val){
            this.index=index;
            this.val=val;
        }
        int comperTo(Info o){
            if(o.index!=this.index) return this.index-o.index;
            return this.val-o.val;
        }
    }
    */
//leetcode submit region end(Prohibit modification and deletion)

