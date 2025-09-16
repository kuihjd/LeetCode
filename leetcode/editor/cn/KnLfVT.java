package leetcode.editor.cn;

public class KnLfVT {
    public static void main(String[] args) {

        Solution solution = new KnLfVT().new Solution();

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
        public TreeNode expandBinaryTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                root.left = new TreeNode(-1, root.left, null);
                expandBinaryTree(root.left.left);
            }
            if (root.right != null) {
                root.right = new TreeNode(-1, null, root.right);
                expandBinaryTree(root.right.right);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}