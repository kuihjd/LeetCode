package leetcode.editor.cn;

import java.util.*;
import java.io.*;
// 567
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 749 👎 0


// 2022-08-30 14:42:54
public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }
            int[] cnt = new int[26];
            int[] cur = new int[26];
            for (char i : s1.toCharArray()) {
                cnt[i - 'a']++;
            }
            char[] c = s2.toCharArray();
            int n = s1.length();
            for (int i = 0; i < n; ++i) {
                cur[c[i] - 'a']++;
            }
            for (int i = n; i < c.length; ++i) {
                if (Arrays.equals(cnt, cur)) {
                    return true;
                }
                cur[c[i] - 'a']++;
                cur[c[i - n] - 'a']--;
            }
            return Arrays.equals(cnt, cur);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}