package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
//        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        Solution_2_13_3 s = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution_2_13_3();
        System.out.println(s.minimumRemoval(new int[]{4,1,6,5}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution_2_13_4 {
        public int maximumANDSum(int[] nums, int numSlots) {
            int len = nums.length;
            int[] m = new int[len];
            return 0;
        }
    }

    class Solution_2_13_3 {

        public long minimumRemoval(int[] beans) {
            Arrays.sort(beans);
            long a = 0;
            long b = 0;
            int len = beans.length;
            long all = 0;
//            long cnt = 0;
            long res = Long.MAX_VALUE;
            int last = 0;
            int[] cnt = new int[(int) 1e5];
            for(int i:beans) {
                cnt[i] ++;
                b += i;
                all += i;
            }
            for(int i = 0; i < (int) 1e5; ++i){
                if(cnt[i] > 0){
                    b -= (long) len * (i - last);
                    res = Math.min(res, a + b);
                    a += (long) cnt[i] * i;
                    len -= cnt[i];
//                    b -= (long) (i - last) * len;
                    last = i;
                    res = Math.min(res, a + b);

                }
            }
            return res;
        }
    }

    class Solution_2_13_2 {
        public int minimumOperations(int[] nums) {
            int len = nums.length;
            if(len < 2) return 0;
            HashMap<Integer, Integer> map1 = new  HashMap<Integer, Integer>();
            HashMap<Integer, Integer> map2 = new  HashMap<Integer, Integer>();
            PriorityQueue<int[]> que1 = new PriorityQueue<int[]>((v1, v2) -> v2[0] - v1[0]);
            PriorityQueue<int[]> que2 = new PriorityQueue<int[]>((v1, v2) -> v2[0] - v1[0]);
            for(int i = 0; i < len; ++i){
                if(i % 2 == 0){
                    map1.put(nums[i], map1.getOrDefault(nums[i] ,0) + 1);
                }
                else{
                    map2.put(nums[i], map2.getOrDefault(nums[i] ,0) + 1);
                }
            }
            map1.forEach((k,v) -> que1.offer(new int[]{v, k}));
            map2.forEach((k,v) -> que2.offer(new int[]{v, k}));
            int[] t1 = que1.poll(), t2 = que2.poll();
            if(t1[1] == t2[1]){
                if(que1.isEmpty() && que2.isEmpty()){
                    return Math.min(t1[0], t2[0]);
                }
                if(que1.isEmpty()){
                    t2 = que2.poll();

                }
                else if(que2.isEmpty()){
                    t1 = que1.poll();

                }
                else if(t1[0] - que1.peek()[0] < t2[0] - que2.peek()[0]){
                    t1 = que1.poll();
                }
                else{
                    t2 = que2.poll();
                }

            }
            return len - t1[0] - t2[0];
        }
    }

    class Solution {
        public int[] levelOrder(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            list.add(root);
            int len = 1;
            while(len > 0){
                while(len > 0){
                    len--;
                    TreeNode t = list.remove();
                    if(t != null){
                        ans.add(t.val);
                        list.add(root.left);
                        list.add(root.right);
                    }
                }
                len = list.size();
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}