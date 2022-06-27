package leetcode.editor.cn;

import java.util.*;

public class SmallestRotationWithHighestScore {
    public static void main(String[] args) {
        Solution solution = new SmallestRotationWithHighestScore().new Solution();
        solution.bestRotation(new int[]{2, 3, 1, 4, 0});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestRotation(int[] nums) {
            int len = nums.length;
            int[] dif = new int[len];
            for (int i = 0; i < len; ++i) {
                //当前是i, 数字是n = nums[i]
                //移动到[n, len - 1]区间的可以得一分
                //处于[n, len - 1]内时
                //移动[0, len - i - 1]
                //或者[len - i, len - i + n - 1]
                //处于[n, len - 1]外时, [n - i, len - i - 1]
                int n = nums[i];
//                if (nums[i] <= i) {
//                    // nums[i] 一开始所在位置就可以得分
//                    move[0]++; // 不移动时 nums[i]就产生贡献
//                    move[(i - nums[i] + 1)%n]--; // 左移 i - nums[i] + 1 则差首次为正； 贡献取消； 继续左移也不会产生新贡献
//                    move[(i+1)%n]++; // 直到移动到坐标小于0的位置； 变成移动到最右边； 贡献产生
//                } else {
//                    // 一开始所在位置不可得分；左移是没有用的；只有移动到边界时，才会产生变化
//                    move[(i+1)%n]++;
//                    // 继续左移动；则会再次到达 值和下标相同的临界点； 继续左移一位则得分取消
//                    move[(n - (nums[i] - i) + 1)%n]--;
//                }
//                作者：wfnuser
//                链接：https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/solution/wei-rao-li-lun-xue-xi-liao-yi-xia-chai-f-kqh2/
//                来源：力扣（LeetCode）
//                著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
                if (i >= n) {
                    dif[0]++;//不动就能增加
//                    dif[len - i]--;//移动次数这么多时就不动
//                    dif[(len - i + n) % len]++;//这个时候他又能加了
                    dif[(i - n + 1) % len]--;
                    dif[(i + 1) % len]++;
//                    System.out.printf("%d移动范围: 0 ~ %d 和 %d ~ 结束\n", n, len - i, (len - i + n) % len);
                } else {
                    dif[(i + 1) % len]++;
//                    dif[(len - i) % len]--;
                    dif[(len - n + i + 1) % len]--;
//                    System.out.printf("%d移动范围: %d ~ %d\n", n, n - i, (len - i - 1) % len);
                }
            }
            int res = 0;
            int cur = 0;
            int max = 0;
            for (int i = 0; i < len; ++i) {
                cur += dif[i];
                if(cur > max){
                    res = i;
                    max = cur;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}