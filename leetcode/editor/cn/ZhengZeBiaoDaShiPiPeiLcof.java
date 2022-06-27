package leetcode.editor.cn;
import java.util.*;
public class ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        solution.isMatch("aa","a*");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {

            char[] sc = s.toCharArray(), pc = p.toCharArray();
            int slen = s.length(), plen = p.length();
            boolean[][] f = new boolean[slen + 1][plen + 1];
            f[0][0] = true;
            for(int j = 2; j <= plen; j += 2)
                f[0][j] = f[0][j - 2] && pc[j - 1] == '*';
            for(int i = 1; i <= slen; ++i){
                for(int j = 1; j <= plen; ++j){
                    if(pc[j - 1] == '*'){//当前位是*
                        f[i][j] = f[i][j - 2];//不对j - 1进行匹配
                        f[i][j] = f[i][j] || (f[i - 1][j] && compare(sc[i - 1], pc[j - 2]));//匹配j - 1位
                    }
                    else{
                        f[i][j] = f[i - 1][j - 1] && compare(sc[i - 1], pc[j - 1]);
                    }
                    j = j;
                }
                i = i;
            }
            return f[slen][plen];
        }

        boolean compare(char a, char b){
            if(b == '.') b = a;
            return b - a == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
/*    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length() + 1, n = p.length() + 1;
            boolean[][] dp = new boolean[m][n];
            dp[0][0] = true;
            // 初始化首行
            for(int j = 2; j < n; j += 2)
                dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
            // 状态转移
            for(int i = 1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    if(p.charAt(j - 1) == '*') {
                        if(dp[i][j - 2]) dp[i][j] = true;                                            // 1.
                        else if(dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                        else if(dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                    } else {
                        if(dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                        else if(dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }*/


    }