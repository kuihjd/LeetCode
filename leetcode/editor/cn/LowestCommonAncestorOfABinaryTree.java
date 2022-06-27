package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    LinkedList<TreeNode> pa = new LinkedList<>();
    LinkedList<TreeNode> qa = new LinkedList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q, new LinkedList<>());
        TreeNode res = root;
        while(!pa.isEmpty() && !qa.isEmpty() && pa.peekFirst() == qa.peekFirst()){
            pa.pollFirst();
            res = qa.pollFirst();
        }
        return res;
    }

    void dfs(TreeNode root, TreeNode p, TreeNode q, LinkedList<TreeNode> arr){
        if(root == null) return;
        arr.offerLast(root);
        if(root == p) {
            arr.forEach(v -> pa.offerLast(v));
            return;
        }
        if(root == q) {
            arr.forEach(v -> qa.offerLast(v));
            return;
        }
        dfs(root.left, p, q, arr);
        dfs(root.right, p, q, arr);
        arr.pollLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}