package leetcode.editor.cn;

public class CousinsInBinaryTreeIi {
    public static void main(String[] args) {

        Solution solution = new CousinsInBinaryTreeIi().new Solution();

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
        int[] laySum = new int[100005];

        public TreeNode replaceValueInTree(TreeNode root) {
            bfs(root, 0);
            TreeNode res = new TreeNode();
            structRes(root, res, 0, 0);
            return res;
        }

        void bfs(TreeNode root, int lay) {
            if (root == null) {
                return;
            }
            laySum[lay] += root.val;
            bfs(root.left, lay + 1);
            bfs(root.right, lay + 1);
        }

        void structRes(TreeNode sourceNode, TreeNode resNode, int lay, int brotherVal) {
            resNode.val = laySum[lay] - sourceNode.val - brotherVal;
            if (sourceNode.left != null) {
                resNode.left = new TreeNode();
                structRes(sourceNode.left, resNode.left, lay + 1, sourceNode.right == null ? 0 : sourceNode.right.val);
            }
            if (sourceNode.right != null) {
                resNode.right = new TreeNode();
                structRes(sourceNode.right, resNode.right, lay + 1, sourceNode.left == null ? 0 : sourceNode.left.val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}