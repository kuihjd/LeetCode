package leetcode.editor.cn;

import java.util.*;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{2,4,3,5,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        int[] copy1;
        int[] copy2;
        //2 是辅助数组
        //2 排序 写入1
        //写完复制去2

        public int reversePairs(int[] nums) {
            if (nums.length < 2) return 0;
            copy1 = nums.clone();
            copy2 = nums.clone();
            sorted(0, nums.length - 1);
            return ans;
        }

        void sorted(int l, int r) {
            if (l >= r) return;
            int m = (l + r) / 2;
            sorted(l, m);
            sorted(m + 1, r);
            // 排序子部分
            int pl = l, pr = m + 1, pw = l;
            while (pl <= m && pr <= r) {
                if (copy2[pl] > copy2[pr]) {
                    ans += m - pl + 1;
                    copy1[pw] = copy2[pr];
                    pr++;
                } else {
                    copy1[pw] = copy2[pl];
                    pl++;
                }
                pw++;
            }
            while (pl <= m) {
                copy1[pw] = copy2[pl];
                pl++;
                pw++;
            }
            while (pr <= r) {
                copy1[pw] = copy2[pr];
                pr++;
                pw++;
            }
            for (int i = l; i <= r; ++i) {
                copy2[i] = copy1[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}