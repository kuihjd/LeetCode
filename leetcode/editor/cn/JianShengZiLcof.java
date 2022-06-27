package leetcode.editor.cn;
import java.util.*;
public class JianShengZiLcof{
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        int m = (int)Math.sqrt(n);
        int v = n / m;
        int res = 1;
        res *= Math.pow(v + 1, n % m);
        res *= Math.pow(v, m - n % m);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}