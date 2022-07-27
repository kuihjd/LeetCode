package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
        solution.asteroidCollision(new int[]{5, 10, -5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(-1);
            for (int i : asteroids) {
                while (!list.isEmpty()) {
                    int pre = list.peekLast();
                    // 撞不到
                    if ((pre < 0) || (pre > 0 && i > 0)) {
                        list.addLast(i);
                        break;
                    }
                    // 一样大
                    else if (-pre == i) {
                        list.pollLast();
                        break;
                    }
                    // 前一个大
                    else if (pre > -i) {
                        break;
                    }
                    // 这个大
                    else if (pre < -i) {
                        list.pollLast();
                        // 撞没了
                        if (list.isEmpty()) {
                            list.addLast(i);
                            break;
                        }
                    }
                }
            }
            return toAns(list);
        }

        int[] toAns(LinkedList<Integer> list) {
            list.pollFirst();
            int len = list.size();
            int[] res = new int[len];
            for (int i = 0; i < len; ++i) res[i] = list.pollFirst();
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}