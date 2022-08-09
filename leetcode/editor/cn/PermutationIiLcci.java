package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class PermutationIiLcci {
    public static void main(String[] args) {
        Solution solution = new PermutationIiLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static ArrayList<String> ans = new ArrayList<>();
        static int[] cnt = new int[128];
        StringBuilder sb = new StringBuilder();
        int len;
        public String[] permutation(String S) {
            len = S.length();
            Arrays.fill(cnt, 0);
            ans.clear();
            for (char i : S.toCharArray()) cnt[i]++;
            dfs(0);
            return ans.toArray(new String[0]);
        }

        void dfs(int idx) {
            if (idx == len) ans.add(sb.toString());
            for (char i = 'a'; i <= 'z'; ++i) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    sb.append(i);
                    dfs(idx + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    cnt[i]++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}