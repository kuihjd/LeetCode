package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class Ipo {
    public static void main(String[] args) {
        Solution solution = new Ipo().new Solution();

        solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Helper {
        int profits, capital;

        Helper(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }

        @Override
        public String toString() {
            return "Helper{" +
                    "profits=" + profits +
                    ", capital=" + capital +
                    '}';
        }


    }

    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int len = profits.length;
            LinkedList<Helper> helpers = new LinkedList<>();
            for (int i = 0; i < len; ++i) {
                helpers.add(new Helper(profits[i], capital[i]));
            }
            helpers.sort((Helper h1, Helper h2) -> h1.capital != h2.capital ? h1.capital - h2.capital : h2.profits - h1.profits);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
            ListIterator<Helper> it = helpers.listIterator();
            Helper t = null;
            while (k > 0) {
                while (it.hasNext()) {
                    t = it.next();
                    if (t.capital <= w) {
                        q.add(t.profits);
                    }
                    else {
                        it.previous();
                        break;
                    }
                }
                if (q.isEmpty()) break;
                w+=q.poll();
                k--;
            }
            return w;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}