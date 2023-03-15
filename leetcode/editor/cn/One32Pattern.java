package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int len = nums.length;
            if (len < 3) {
                return false;
            }
            int l = nums[0], m = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 2; i < len; ++i) {
                int v = nums[i];
                map.put(v, map.getOrDefault(v, 0) + 1);
            }

            for (int i = 1; i < len - 1; ++i) {
                m = nums[i];
                Integer r = map.lowerKey(m);
                if (r != null && l < m && l < r) {
                    return true;
                }
                l = Math.min(m, l);
                m = nums[i + 1];
                map.put(m, map.get(m) - 1);
                if (map.get(m) == 0) {
                    map.remove(m);
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}