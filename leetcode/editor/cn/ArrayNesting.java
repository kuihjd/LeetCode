package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ArrayNesting {
    public static void main(String[] args) {
        Solution solution = new ArrayNesting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrayNesting(int[] nums) {
            int len = nums.length;
            int[] cache = new int[len];
            int ans = 0;
//            Arrays.fill(cache, -1);
            LinkedList<Integer> list = new LinkedList<>();
            HashSet<Integer> set = new HashSet<>();
            // 每个点的进入方式都是唯一的, 可记录
            // 从某个点开始走
            for (int i = 0; i < len; ++i) {
                if (cache[i] != 0) continue;
                int v = nums[i];
                list.add(i);
                int base = 0;
                while (!set.contains(v)) {
                    set.add(v);
                    list.addLast(v);
                    v = nums[v];
                    if (cache[v] != 0) {
                        base = cache[v];
                        break;
                    }
                }
                ans = Math.max(list.size() + base, ans);
                while (!list.isEmpty()) {
                    int d = list.size() + base;
                    int n = list.pollFirst();
                    nums[n] = d;
                }
                set.clear();
            }
            return ans;
        }

        
    }


//leetcode submit region end(Prohibit modification and deletion)

}