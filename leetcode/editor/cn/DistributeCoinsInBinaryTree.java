package leetcode.editor.cn;

public class DistributeCoinsInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new DistributeCoinsInBinaryTree().new Solution();
        
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

    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if( root == null){
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        ans += Math.abs(l[0] - l[1]);
        ans += Math.abs(r[0] - r[1]);
        return new int[]{l[0] + r[0] + 1, l [1]+ r[1] + root.val };
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}