package leetcode.editor.cn;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {

        Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subtractProductAndSum(int n) {
            return product(n) - sum(n);
        }

        int product(int n) {
            if (n == 0) {
                return 1;
            }
            return n % 10 * product(n / 10);
        }

        int sum(int n) {
            if (n == 0) {
                return 0;
            }
            return n % 10 + sum(n / 10);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}