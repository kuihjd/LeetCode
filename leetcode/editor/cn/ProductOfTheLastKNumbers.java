package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ProductOfTheLastKNumbers {
    public static void main(String[] args) {
        new HashMap<Integer, Integer>().remove(7);
        ProductOfNumbers solution = new ProductOfTheLastKNumbers().new ProductOfNumbers();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ProductOfNumbers {
        int[] data = new int[40005];
        int idx = 1;

        public ProductOfNumbers() {
            data[0] = 1;
        }

        public void add(int num) {
            if (num == 0) {
                idx = 1;
                return;
            }
            num = Math.max(1, num);
            data[idx] = data[idx - 1] * num;
            idx++;
        }

        public int getProduct(int k) {
            if (idx <= k) return 0;
            return data[idx - 1] / data[idx - 1 - k];
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
//leetcode submit region end(Prohibit modification and deletion)

}