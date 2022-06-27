package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        solution.longestConsecutive(new int[]{1, 0, -1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums) map.put(i, i);
            int max = 0;
            for (int i : nums) {
                if (map.containsKey(i)) {
                    int r = map.get(i);
                    while (map.containsKey(r + 1)) {
                        int next = map.get(r + 1);
                        map.remove(r + 1);
                        r = next;
                    }
                    max = Math.max(max, r - i + 1);
                    map.put(i, r);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}