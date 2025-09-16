package leetcode.editor.cn;

public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        Solution solution = new FindKthBitInNthBinaryString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] ls = new int[30];
        static {
            ls[1] = 1;
            for (int i = 2; i < 22; ++i) {
                ls[i] = ls[i - 1] * 2 + 1;
            }
        }
        public char findKthBit(int n, int k) {
            return (char) dfs(n, k);
        }

        int dfs(int n, int k) {
            System.out.println(n + "--" + k);
            if (n == 1) {
                return 0;
            }
            int m = ls[n] / 2;
            if (m == k) {
                // 撞上分隔符，就是1
                return 1;
            } else if (m < k) {
                // 左边，那就在左边找，不修改
                return dfs(n - 1, k);
            } else {
                // 右边，也是在左边找，但是修改
                return dfs(n - 1, m - (k - m)) ^ 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}