package leetcode.editor.cn;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequenceOfGivenDifference().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int[] cnt = new int[40001];
            int res = 1;
            for (int i : arr) {
                cnt[i + 20000] = cnt[i - difference + 20000] + 1;
                if (cnt[i + 20000] > res) res = cnt[i + 20000];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

interface PaymentMethod {
    public abstract void pay(int t);
}

abstract class Card implements PaymentMethod {
    private final String name, num;

    public Card(String name, String num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return String.format("%s card[name = %s, num = %s]", this.getType(), name, num);
    }

    @Override
    public void pay(int cents) {
        System.out.println("Payed " + cents + " cents using " + toString());
        this.executeTransaction(cents);
    }
    protected abstract String getType();
    protected abstract void executeTransaction(int cents);
}
