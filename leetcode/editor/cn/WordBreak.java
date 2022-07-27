//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 
// 👍 1059 👎 0

package leetcode.editor.cn;

import java.util.List;

//Java：单词拆分
public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private class Trie {
        Trie[] next = new Trie[26];
        boolean isEnd;

        void put(int index, char[] c) {
            if (index != c.length) {
                Trie now = next[c[index] - 97];
                if (now == null) now = new Trie(index + 1, c);
                now.put(index + 1, c);
            } else {
                isEnd = true;
            }
        }

        Trie(int index, char[] c) {
            put(index, c);
        }

        Trie(String s) {
            put(0, s.toCharArray());
        }

        boolean get(int index, char[] c) {
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
    }
}
