package leetcode.editor.cn;

import java.util.*;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashSet<String> ans = new HashSet<>();
        boolean[] f;
        public String[] permutation(String s) {
            int len = s.length();
            f = new boolean[len];
            char[] c = s.toCharArray();
            for(int i = 0; i < c.length; ++i){
                dfs(c, i, len, new StringBuilder());
            }
            return ans.toArray(new String[0]);
        }
        void dfs(char[] c, int now, int max, StringBuilder sb){
            if(f[now]) return;
            f[now] = true;
            sb.append(c[now]);

            if(sb.length() == max) {
                ans.add(sb.toString());
                f[now] = false;
                return;
            }
            for(int i = 0; i < max; ++i){
                dfs(c, i, max, sb);
            }
            sb.deleteCharAt(sb.length() - 1);
            f[now] = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}