package leetcode.editor.cn;
import java.util.*;
public class BaZiFuChuanZhuanHuanChengZhengShuLcof{
    public static void main(String[] args) {
        Solution solution = new BaZiFuChuanZhuanHuanChengZhengShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strToInt(String str) {
        int p = 0;

        char[] c = str.toCharArray();
        int len = c.length;
        int sign = 1;
        long res = 0;
        while(p < len && c[p] == ' ') p++;
        if(p == len) return 0;
        if(c[p] == '-') sign = -1;
        else if(c[p] == '+') sign = 1;
        else if(isNum(c[p])) res = c[p] - '0';
        else return 0;
        while(p < len && isNum(c[p])){
            res = res * 10 + c[p] - '0';
            if(!(Integer.MIN_VALUE <= res * sign && res * sign <= Integer.MAX_VALUE)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

        }
        return (int)res;
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}