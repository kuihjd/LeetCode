package leetcode.editor.cn;
public class CountGoodNodesInBinaryTree{
    public static void main(String[] args) {
    	
        Solution solution = new CountGoodNodesInBinaryTree().new Solution();
        
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
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
//        System.out.println(root.val + " " + (root.val <= max ? 1 : 0));
        return (root.val >= max ? 1 : 0) + dfs(root.left, Math.max(root.val, max)) + dfs(root.right, Math.max(root.val, max));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}