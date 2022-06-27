package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        solution.nextPermutation(new int[]{2, 1, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 1;
            int[] s = new int[10];
            int[] cnt = new int[10];
            while (i >= 0) {
                for (int j = nums[i] + 1; j < 10; ++j) {
                    if (s[j] != 0) {
                        nums[i] = nums[i] ^ nums[s[j]];
                        nums[s[j]] = nums[i] ^ nums[s[j]];
                        nums[i] = nums[i] ^ nums[s[j]];
                        cnt[nums[i]]--;
                        cnt[nums[s[j]]]++;
                        int loc = i + 1;
                        int p = 0;
                        while(loc < nums.length){
                            while(cnt[p] == 0) p++;
                            nums[loc] = p;
                            loc++;
                            cnt[p]--;
                        }
                        return;
                    }
                }
                s[nums[i]] = Math.max(s[nums[i]], i);
                cnt[nums[i]]++;
                i--;
            }
            int l = 0, r = nums.length - 1;
            while (l < r) {
                nums[l] = nums[l] ^ nums[r];
                nums[r] = nums[l] ^ nums[r];
                nums[l] = nums[l] ^ nums[r];
                l++;
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}