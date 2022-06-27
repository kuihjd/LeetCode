package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;
            int l = 0;
            LinkedList<TreeNode> cur = new LinkedList<>();
            cur.add(root);
            while (!cur.isEmpty()) {
                LinkedList<TreeNode> t = new LinkedList<>();
                LinkedList<Integer> tval = new LinkedList<>();
                while (!cur.isEmpty()) {
                    if (l % 2 == 0) {
                        TreeNode v = cur.pollFirst();
                        if (v.left != null) t.offerLast(v.left);
                        if (v.right != null) t.offerLast(v.right);
                        tval.offerLast(v.val);
                    } else {
                        TreeNode v = cur.pollLast();
                        if (v.right != null) t.offerFirst(v.right);
                        if (v.left != null) t.offerFirst(v.left);
                        tval.offerFirst(v.val);
                    }
                }
                l++;
                cur = t;
                ans.add(tval);
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}