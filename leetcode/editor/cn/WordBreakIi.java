package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        ArrayList p = new ArrayList<>();
        p.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        solution.wordBreak("catsanddog", p);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        char[] c;
        StringBuilder sb = new StringBuilder();
        int len;

        public List<String> wordBreak(String s, List<String> wordDict) {

            len = s.length();
            for (String i : wordDict) trie.put(i);
            c = s.toCharArray();
            dfs(0, trie);
            return ans;
        }

        void dfs(int idx, Trie tre) {
            if (tre == null) return;
            if (idx == len && tre.isEnd) {
//                sb.deleteCharAt(sb.length() - 1);
                ans.add(sb.toString());
//                sb.append(' ');
                return;
            }

            Trie next = tre.next[c[idx] - 'a'];
            if (tre.isEnd) {
                sb.append(' ');
                sb.append(c[idx]);
                dfs(idx + 1, trie.next[c[idx] - 'a']);
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c[idx]);
            dfs(idx + 1, next);
            sb.deleteCharAt(sb.length() - 1);
        }

        private class Trie {
            public Trie[] next = new Trie[26];
            public boolean isEnd;

            private void put(int index, char[] c) {
                if (index != c.length) {
                    if (next[c[index] - 97] == null) next[c[index] - 97] = new Trie(index + 1, c);
                    else next[c[index] - 97].put(index + 1, c);
                } else {
                    isEnd = true;
                }
            }

            public void put(String s) {
                put(0, s.toCharArray());
            }

            public Trie(int index, char[] c) {
                put(index, c);
            }

            public Trie(String s) {
                put(0, s.toCharArray());
            }

            public Trie() {
            }

            private boolean get(int index, char[] c) {
                if (index == c.length) {
                    return isEnd;
                }
                Trie now = next[c[index] - 97];
                if (now != null) {
                    return now.get(index + 1, c);
                } else {
                    return false;
                }
            }

            public boolean get(String s) {
                return get(0, s.toCharArray());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}