package leetcode.editor.cn;
import java.util.*;
public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        int [] a = new int[]{3,9,20,15,7};
        int [] b = new int[]{9,3,15,20,7};
        solution.buildTree(a,b);
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
    HashMap<Integer, Integer> premap = new HashMap<>();
    HashMap<Integer, Integer> inmap = new HashMap<>();
    int preLen;
    int inLen;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preLen = preorder.length;
        inLen = inorder.length;
        TreeNode res = new TreeNode();
        int len = preorder.length;
        for(int i = 0; i < len; ++i){
            premap.put(preorder[i], i);
            inmap.put(inorder[i], i);
        }
        return builder(0, len - 1, 0, len - 1);
    }

    TreeNode builder(int preL, int preR,int inL, int inR){
        //先从前序遍历找到当前节点的:root = preorder[inL], midx
        //划分 inorder[preL, ridx - 1] 为左子节点
        //划分 inorder[ridx + 1, preR] 为右子节点

        if(preL > preR || inL > inR) return null;
        int midx = inmap.get(preorder[preL]);
        int lLen = midx - inL, rLen = inR - midx;
        TreeNode root = new TreeNode(preorder[preL]);
        root.left = builder(preL + 1, preL + lLen, inL, midx - 1);
        root.right = builder(preL + 1 + lLen, preR, midx + 1, inR);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}