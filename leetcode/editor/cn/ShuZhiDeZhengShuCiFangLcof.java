package leetcode.editor.cn;
import java.util.*;
public class ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        solution.myPow(2,2147483647);
        System.out.println(solution.cnt);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int cnt = 0;
    public double myPow(double x, int n) {
        cnt++;
        if(n == 1) return x;
        if(n == 0) return 1;
        if(n < 0) return 1 / myPow(x, -n);
        double t = myPow(x, n / 2);
        return t * t * myPow(x, n % 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}