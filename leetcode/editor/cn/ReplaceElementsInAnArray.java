package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ReplaceElementsInAnArray {
    public static void main(String[] args) {
        Solution solution = new ReplaceElementsInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] arrayChange(int[] nums, int[][] operations) {
            int[] map = new int[(int) 1e7 + 10];
            // 纪录每个数字的下标
            for (int i = 0; i < nums.length; ++i) {
                map[nums[i]] = i;
            }
            for (int[] i : operations) {
                int idx = map[i[0]];// 他的下标是
                nums[idx] = i[1];
                map[i[1]] = idx;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}