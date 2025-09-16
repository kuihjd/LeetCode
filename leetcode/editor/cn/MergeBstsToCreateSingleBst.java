package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MergeBstsToCreateSingleBst {
    public static void main(String[] args) {

        Solution solution = new MergeBstsToCreateSingleBst().new Solution();

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
        int pre = 0;
        int cnt = 0;

        public TreeNode canMerge(List<TreeNode> trees) {
            HashMap<Integer, TreeNode> map = new HashMap<>();
            cnt = trees.size();
            for (TreeNode i : trees) {
                map.put(i.val, i);
            }
            for (TreeNode i : trees) {
                if (i.left != null) {
                    cnt++;
                    if (map.containsKey(i.left.val)) {
                        i.left = map.remove(i.left.val);
                        cnt--;
                    }
                }
                if (i.right != null) {
                    cnt++;
                    if (map.containsKey(i.right.val)) {
                        i.right = map.remove(i.right.val);
                        cnt--;
                    }
                }
            }
            if (map.size() == 1) {
                TreeNode res = map.get(map.keySet().toArray()[0]);
                if (tryBST(res) && cnt == 0) {
                    return res;
                }
            }
            System.out.println(cnt);
            return null;
        }

        boolean tryBST(TreeNode treeNode) {
            if (treeNode == null) {
                return true;
            }
            if (!tryBST(treeNode.left)) {
                return false;
            }
            if (pre >= treeNode.val) {
                return false;
            }
            pre = treeNode.val;
            cnt--;
            return tryBST(treeNode.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}