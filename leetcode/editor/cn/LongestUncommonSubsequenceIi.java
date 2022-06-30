package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi().new Solution();
        solution.findLUSlength(new String[]{"aabbcc", "aabbcc","c","e","aabbcd"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String i : strs) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int ans = -1;
            out:
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String k = entry.getKey();
                if (entry.getValue() == 1) {
                    for (String j : strs) {
                        if (!j.equals(k) && check(k, j)) continue out;
                    }
                    ans = Math.max(ans, k.length());
                }
            }
            return ans;
        }

        boolean check(String a, String b) {
            int l1 = a.length(), l2 = b.length();
            char[] c1 = a.toCharArray(), c2 = b.toCharArray();
            int[][] dp = new int[l1 + 1][l2 + 1];
            for (int i = 0; i < l1; ++i) {
                for (int j = 0; j < l2; ++j) {
                    dp[i + 1][j + 1] = dp[i][j];
                    if (c1[i] == c2[j]) dp[i + 1][j + 1]++;
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i + 1][j]);
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                }
            }
            return dp[l1][l2] == a.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}