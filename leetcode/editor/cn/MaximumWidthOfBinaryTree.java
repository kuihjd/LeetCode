package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumWidthOfBinaryTree{
    public static void main(String[] args) {
    	
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        
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

    int[] layL = new int[3005];
    int[] layR = new int[3005];
    //    int res = 0;
    public int widthOfBinaryTree(TreeNode root) {
        Arrays.fill(layL, Integer.MAX_VALUE);
        dfs(root, 0, 1);
        int res = 0;
        for (int i = 0; i < 3005; ++i) {
            if (layL[i] != Integer.MAX_VALUE) {
                System.out.println(i + " " + layL[i] + " " + layR[i]);
                res = Math.max(res, (layR[i] - layL[i] + 1));
            }
        }
        return res;
    }

    void dfs(TreeNode root, int lay, int val) {
        if (root == null) {
            return;
        }
        layL[lay] = Math.min(layL[lay], val);
        layR[lay] = Math.max(layR[lay], val);
        dfs(root.left, lay + 1, val << 1);
        dfs(root.right, lay + 1, val << 1 + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}