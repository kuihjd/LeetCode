package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
    	
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        
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
    Map<Integer, Integer> inIdxMap = new HashMap<>();
    Map<Integer, Integer> preIdxMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length - 1;
        for (int i = 0; i < n; i++) {
            inIdxMap.put(i, inorder[i]);
            preIdxMap.put(i, preorder[i]);
        }
        return struct(preorder, inorder, 0, 0, n);
    }

    TreeNode struct(int[] preorder, int[] inorder, int rootLocal, int left, int right) {
        if (left < right) {
            return null;
        }
        int preLocal = inIdxMap.get(rootLocal);
        TreeNode res = new TreeNode(preorder[rootLocal]);
        res.left = struct(preorder, inorder, rootLocal + 1, left, preLocal - 1);
        res.right = struct(preorder, inorder, rootLocal + 1, left, preLocal - 1);
//        return new TreeNode(preorder[rootLocal], struct(preorder, inorder, rootLocal));
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}