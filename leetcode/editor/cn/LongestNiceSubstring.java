package leetcode.editor.cn;

import java.util.*;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestNiceSubstring().new Solution();
        solution.longestNiceSubstring("YazaAay");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int l, r;
        public String longestNiceSubstring(String s) {
            char[] c = s.toCharArray();
            l = 0;
            r = 0;
            check(c, 0, s.length());
            return s.substring(l, r);
        }

        void check(char[] c, int l, int r) {
            if(r - l <= this.r - this.l) return;;
            boolean[] cnt = new boolean[128];
            for(int i = l; i < r; ++i){
                cnt[c[i]] = true;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = 'a'; i <= 'z'; ++i){
                if(cnt[i] && !cnt[i - 32]) set.add((char)i);
                if(!cnt[i] && cnt[i - 32]) set.add((char)(i - 32));
            }
            if(set.isEmpty()){
                this.l = l;
                this.r = r;
                return;
            }
            for(int i = l; i < r; ++i){
                if(set.contains(c[i])) {
                    check(c, l, i);
                    l = i + 1;
                }
            }
            check(c, l, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}