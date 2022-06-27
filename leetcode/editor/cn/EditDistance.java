package leetcode.editor.cn;

import java.util.*;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            /*
             * dp[i][j] 为word前i个转word2前j个最少要几步
             * 初始化 空字符串转长度为n的字符串那么多一定要n步
             * */
            char[] c1 = word1.toCharArray();
            char[] c2 = word2.toCharArray();
            int len1 = c1.length, len2 = c2.length;
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 1; i <= len1; ++i) dp[i][0] = i;
            for (int i = 1; i <= len2; ++i) dp[0][i] = i;
            for(int i = 1; i <= len1; ++i){
                for(int j = 1; j <= len2; ++j){
                    /*
                    * 由左/上/左上转换得来
                    * 左和上都是 +1 因为必须要加\减一个字母
                    * 如果当前位相同 可以继承左上的操作次数,因为可以不变
                    * */
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    if(c1[i - 1] == c2[j - 1]) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
            return dp[len1][len2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}