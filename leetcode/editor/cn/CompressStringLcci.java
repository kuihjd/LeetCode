package leetcode.editor.cn;

import java.util.*;

public class CompressStringLcci {
    public static void main(String[] args) {
        Solution solution = new CompressStringLcci().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String compressString(String S) {
            if (S.equals("")) return "";
            StringBuilder sb = new StringBuilder();
            char now = S.charAt(0);
            int cnt = 0;
            for (char i : S.toCharArray()) {
                if(i == now) {
                    cnt++;
                }
                else{
                    sb.append(now).append(cnt);
                    now = i;
                    cnt = 1;
                }
            }
            sb.append(now).append(cnt);
            return S.length() > sb.length() ? sb.toString() : S;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}