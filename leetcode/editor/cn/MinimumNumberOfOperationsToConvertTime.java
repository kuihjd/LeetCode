package leetcode.editor.cn;

public class MinimumNumberOfOperationsToConvertTime {
    public static void main(String[] args) {

        Solution solution = new MinimumNumberOfOperationsToConvertTime().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertTime(String current, String correct) {
            int t1 = getTime(current), t2 = getTime(correct);
            int res = 0;
            if (t2 < t1) {
                t2 += 24 * 60;
            }
            int v = t2 - t1;
            for (int i : new int[]{60, 15, 5, 1}) {
                res += v / i;
                v %= i;
            }
            return res;
        }

        int getTime(String time) {
//            String[] times = time.split(":");
//            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            return time.charAt(0) * 600 + time.charAt(1) * 60 + time.charAt(3) * 10 + time.charAt(4);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}