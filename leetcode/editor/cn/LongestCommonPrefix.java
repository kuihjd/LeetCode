package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) return strs[0];
            int len = Integer.MAX_VALUE;
            for (String s : strs) len = Math.min(len, s.length());
            for (int i = 0; i < len; ++i) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; ++j) {
                    if (strs[j].charAt(i) != c) return strs[0].substring(0, i);
                }
            }
            return strs[0].substring(1, len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}