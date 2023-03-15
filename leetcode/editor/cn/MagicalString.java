package leetcode.editor.cn;

import java.util.*;
import java.io.*;
// 481
//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
// Related Topics 双指针 字符串 👍 61 👎 0


// 2022-08-31 09:55:40
public class MagicalString {
    public static void main(String[] args) {
        Solution solution = new MagicalString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] ans = new int[(int) (1e5 + 5)];

        static {
            int[] arr = new int[(int) (1e5 + 10)];
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 2;
            int v = 1, l = 3;
            for (int i = 4; i < 1e5 + 5; ) {
                for (int j = 0; j < arr[l]; ++j, ++i) {
                    arr[i] = v;
                }
                v = v == 1 ? 2 : 1;
                l++;
            }
            int cnt = 0;
            for (int i = 1; i < 1e5 + 5; ++i) {
                if (arr[i] == 1) {
                    cnt++;
                }
                ans[i] = cnt;
            }
            System.out.println(Arrays.toString(arr));
        }

        public int magicalString(int n) {
            return ans[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}