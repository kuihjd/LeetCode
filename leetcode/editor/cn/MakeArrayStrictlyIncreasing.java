package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class MakeArrayStrictlyIncreasing {
    public static void main(String[] args) {
        Solution solution = new MakeArrayStrictlyIncreasing().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            int n = arr1.length;
            TreeSet<Integer> treeSet = new TreeSet<>();
            LinkedList<Integer> nc = new LinkedList<>(); // 记录哪些坐标并没有发生置换
            HashMap<Integer, Integer> map = new HashMap<>();// 在sa2中，值到坐标的映射
//            int[] cs = new int[n];// 记录已发生交换的坐标,
            for (int i : arr2) {
                treeSet.add(i);
            }
            int[] sa2 = Arrays.stream(treeSet.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();// 排序完成的a2
            for (int i = 0; i < arr2.length; ++i) {
                map.put(sa2[i], i);
            }
            nc.add(0);
            for (int i = 1; i < n; ++i) {
                if (arr1[i] > arr1[i - 1]) {
                    nc.add(i);
                    continue;
                }
                if (nc.isEmpty()) return -1;// 没有可以继续移动的，那就是不存在
                int pre = nc.pollLast();
                if (pre == 0) {
                    arr1[0] = sa2[0];
                } else {
                    arr1[pre] = treeSet.higher(arr1[pre - 1]);
                }

            }

            return n - nc.size();
        }

        /**
         * 计算出arr去重后排序的结果，res[i][0]为值，res[i][1]为
         *
         * @param arr
         * @return
         */
        int[][] calArr(int[] arr) {
            int n = arr.length;
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}