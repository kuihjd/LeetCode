package leetcode.editor.cn;
import java.util.*;
import java.io.*;
// 438
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 988 👎 0


// 2022-08-30 14:50:35
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] cnt = new int[26];
        int[] cur = new int[26];
        for (char i : p.toCharArray()) {
            cnt[i - 'a']++;
        }
        char[] c = s.toCharArray();
        int n = p.length();
        for (int i = 0; i < n; ++i) {
            cur[c[i] - 'a']++;
        }
        for (int i = n; i < c.length; ++i) {
            if (Arrays.equals(cnt, cur)) {
                ans.add(i - n);
            }
            cur[c[i] - 'a']++;
            cur[c[i - n] - 'a']--;
        }
        if (Arrays.equals(cnt, cur)) {
            ans.add(c.length - n);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}