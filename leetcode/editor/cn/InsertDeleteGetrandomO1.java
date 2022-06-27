package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
//        RandomizedSet solution = new InsertDeleteGetrandomO1().new RandomizedSet();
//        solution.insert(0);
//        solution.insert(1);
//        solution.remove(0);
//        solution.insert(2);
//        solution.remove(1);
        new InsertDeleteGetrandomO1().new Solution3().getNumber(TreeNode.deserialize("4,2,7,1,null,5,null,null,null,null,6"), new int[][]{{0, 2, 2}, {1, 1, 5}, {0, 4, 5}, {1, 5, 7}});


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        HashMap<Integer, Integer> numToIdx = new HashMap<>();
        HashMap<Integer, Integer> idxToNum = new HashMap<>();
        int count = 0;
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (numToIdx.containsKey(val)) return false;
            idxToNum.put(count, val);
            numToIdx.put(val, count);
            count++;
            return true;
        }

        public boolean remove(int val) {
            if (!numToIdx.containsKey(val)) return false;
            count--;
            int idx = numToIdx.get(val);
            int newVal = idxToNum.get(count);
            idxToNum.put(idx, newVal);
            numToIdx.put(newVal, idx);
            numToIdx.remove(val);
            idxToNum.remove(count);
            return true;
        }

        public int getRandom() {
            return idxToNum.get(random.nextInt(count));
        }
    }

    class Solution3 {
        int max = (int) (1e9 + 5);
        int res = 0;
        BitSet bitSet = new BitSet(max);

        public int getNumber(TreeNode root, int[][] ops) {
            bitSet.set(0, max, false);
            for (int[] i : ops) {
                bitSet.set(i[1], i[2] + 1, i[0] == 1);
            }
            getVal(root);
            return res;
        }

        void getVal(TreeNode root) {
            if (root == null) return;
            if (bitSet.get(root.val)) res++;
            getVal(root.left);
            getVal(root.right);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}