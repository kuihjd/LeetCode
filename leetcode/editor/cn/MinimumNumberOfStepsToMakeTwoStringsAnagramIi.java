package leetcode.editor.cn;

import java.util.*;

public class MinimumNumberOfStepsToMakeTwoStringsAnagramIi {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfStepsToMakeTwoStringsAnagramIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(String s, String t) {
            int[] cnt = new int[26];
            int res = 0;
            for(char i:s.toCharArray()) cnt[i - 'a']++;
            for(char i:t.toCharArray()) cnt[i - 'a']--;
            for (int i:cnt) res += Math.abs(i);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}