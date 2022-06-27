package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(LeetCodeDataStruct.parserIntArray("[10,9,2,5,3,7,101,18]"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            return ans1(nums);
        }

        int ans1(int[] data) {
            // 最多拦截, lis变种
            TreeSet<Integer> set = new TreeSet<>();
            set.add(data[0]);
            for (int i : data) {
                if (set.last() < i) {
                    set.add(i);
                } else {
                    set.remove(set.ceiling(i));
                    set.add(i);
                }
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}