package leetcode.editor.cn;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(0, 0, n, new StringBuilder(), 1);
            return ans;
        }

        void dfs(int l, int r, int max, StringBuilder sb, int m){
            if(r > l) return;
            if(l > max || r > max) return;
            if(m == 1){
                l++;
                sb.append('(');
            }
            else{
                r++;
                sb.append(')');
            }
            if(l == max && r == max) {
                sb.deleteCharAt(sb.length() - 1);
                return;
            }
            dfs(l, r, max, sb, 1);
            dfs(l, r, max, sb, 2);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}