package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1, ans = Math.min(height[l], height[r]) * (r - l);
            while (l < r) {
                if (height[l] > height[r]) {
                    r--;
                } else {
                    l++;
                }
                ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}