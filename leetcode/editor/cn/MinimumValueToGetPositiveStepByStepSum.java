package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MinimumValueToGetPositiveStepByStepSum {
    public static void main(String[] args) {
        Solution solution = new MinimumValueToGetPositiveStepByStepSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStartValue(int[] nums) {
            int min = Integer.MAX_VALUE, cur = 0;
            for (int i : nums) {
                min = Math.min(min, cur += i);
            }
            return Math.max(-min, 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}