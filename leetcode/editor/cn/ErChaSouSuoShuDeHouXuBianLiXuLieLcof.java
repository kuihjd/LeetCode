package leetcode.editor.cn;
import java.util.*;
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        solution.verifyPostorder(new int[]{1,6,3,2,5});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(0, postorder.length - 1, postorder);
    }

    boolean dfs(int l, int r, int[] postorder){
        if(l == r) return true;
        int m = l;
        while(m < r && postorder[m] < postorder[r]) m++;
        for(int i = m; i <= r; ++i) {
            if(postorder[m] < postorder[r]) return false;
        }
        return dfs(l, m - 1, postorder) && dfs(m, r - 1, postorder);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}