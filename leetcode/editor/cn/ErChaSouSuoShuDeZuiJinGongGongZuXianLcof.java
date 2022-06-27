package leetcode.editor.cn;
import java.util.*;
public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
        
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> parr = new ArrayList<>();
        ArrayList<TreeNode> qarr = new ArrayList<>();
        dfs(root, parr, p);
        dfs(root, qarr, q);
        return null;
    }

    void dfs(TreeNode root, ArrayList<TreeNode> arr, TreeNode tar){
        if(root == null) return;
        if(!arr.isEmpty() && arr.get(arr.size() - 1) == tar) return;
        arr.add(root);
        dfs(root.left, arr, tar);
        dfs(root.right, arr, tar);
        arr.remove(arr.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}