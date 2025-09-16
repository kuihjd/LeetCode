package leetcode.editor.cn;

import java.util.HashSet;

public class SZ59z6 {
    public static void main(String[] args) {

        Solution solution = new SZ59z6().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        HashSet<Integer> set = new HashSet<>();

        public int numColor(TreeNode root) {
            dfs(root);
            set.remove(null);
            return set.size();
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            set.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}