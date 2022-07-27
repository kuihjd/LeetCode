package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class CustomSortString {
    public static void main(String[] args) {
        Solution solution = new CustomSortString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String order, String s) {
            int[] o = new int[128];
            for (int i = 0; i < 128; ++i) o[i] = i + 200;
            for (int i = 0; i < order.length(); ++i) {
                o[order.charAt(i)] = i;
            }

            Character[] c = new Character[s.length()];
            for (int i = 0; i < s.length(); i++) {
                c[i] = s.charAt(i);
            }
            StringBuilder sb = new StringBuilder();
            Arrays.sort(c, (v1, v2) -> o[v1] - o[v2]);
            for (char i : c) sb.append(i);
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}