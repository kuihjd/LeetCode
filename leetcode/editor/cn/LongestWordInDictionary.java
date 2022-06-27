package leetcode.editor.cn;

import java.util.*;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionary().new Solution();
        solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int max = 0;
        String ans = "";

        public String longestWord(String[] words) {
            Helper dict = new Helper();
            for (String i : words) dict.put(i.toCharArray(), 0);
            dict.isEnd = true;
            dfs(dict, 0, new StringBuilder());
            return ans;
        }

        void dfs(Helper cur, int len, StringBuilder sb) {
            if (!cur.isEnd) return;
            if (len > max) {
                max = len;
                ans = sb.toString();
            }
            len++;
            for (int i = 0; i < 26; ++i) {
                if (cur.next[i] != null) {
                    sb.append((char) (i + 'a'));
                    dfs(cur.next[i], len, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        class Helper {
            Helper[] next = new Helper[26];
            boolean isEnd;

            void put(char[] word, int loc) {
                if (loc == word.length) {
                    this.isEnd = true;
                    return;
                }
                if (next[word[loc] - 'a'] == null) next[word[loc] - 'a'] = new Helper();
                next[word[loc] - 'a'].put(word, loc + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}