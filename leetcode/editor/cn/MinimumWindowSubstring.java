package leetcode.editor.cn;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if(s.equals(t)) return s;
            if(t.length() >= s.length()) return "";
            char[] sc = s.toCharArray(), tc = t.toCharArray();
            int l = 0, r = 0;
            int[] cnt1 = new int[128], cnt2 = new int[128];
            for (char i : tc) cnt2[i]++;
            for (char i : sc) {
                cnt1[i]++;
                r++;
                if (check(cnt1, cnt2)) break;
            }
            if (r == s.length() && !check(cnt1, cnt2)) return "";
            int resl = l, resr = r;
            while (r < sc.length) {
                if(check(cnt1, cnt2)) {
                    while(cnt1[sc[l]] > cnt2[sc[l]]) cnt1[sc[l++]]--;
                    resl = l;
                    resr = r;
                }
                cnt1[sc[l++]]--;
                cnt1[sc[r++]]++;
            }
            return s.substring(resl, resr);
        }

        boolean check(int[] cnt1, int[] cnt2) {
            for (int i = 0; i < 128; i++) {
                if (cnt1[i] < cnt2[i]) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}