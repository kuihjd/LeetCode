//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3866 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

//Java：最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babadada");
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        char[] c;
        int start = 0;
        int end = 0;
        int len;

        public String longestPalindrome(String s) {
            c = s.toCharArray();
            len = c.length;
            helper(len / 2, 0);
            return s.substring(start, end);
        }

        void helper(int index, int type) {
            int l = index - 1, r = index + 1;
            while (l >= 0 && c[l] == c[index]) l--;
            while (r < len && c[r] == c[index]) r++;
            int i = l, j = r;
            while (l >= 0 && r < len && c[l] == c[r]) {
                l--;
                r++;
            }

            if (r - l - 1 > end - start) {
                end = r;
                start = l + 1;
            }
            if (type <= 0 && i * 2 + 2 > r - l - 1) helper(i, -1);
            if (type >= 0 && (len - j) * 2 > r - l - 1) helper(j, 1);
        }
    }

    public class Solution2 {
        char[] c;
        int len;

        public String longestPalindrome(String s) {
            String ans = "";
            int l = 0, r = s.length();
            c = s.toCharArray();
            len = s.length();
            HashSet<Integer> set = new HashSet<>();
            ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.get(7);
            set.add(7);
            out:
            while (l < r) {
                int m = l + r / 2;
                // [l,m) [m,r]
                System.out.println(m);
                for (int i = 0; i + m < len; ++i) {
                    if (check(i, i + m)) {
                        ans = s.substring(i, i + m);
                        r = m;
                        continue out;
                    }
                }
                l = m - 1;
            }
            return ans;
        }

        boolean check(int start, int end) {
//            if (end >= c.length) return false;
            while (start < end) if (c[++start] != c[--end]) return false;
            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}