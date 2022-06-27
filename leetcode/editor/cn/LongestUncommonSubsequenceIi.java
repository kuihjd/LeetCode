package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi().new Solution();
        solution.findLUSLength(new String[]{"aabbcc", "aabbcc","c"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSLength(String[] strs) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String i : strs) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    if ()
                }
            }

            return -1;
        }

        boolean check (String a, String b) {
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}