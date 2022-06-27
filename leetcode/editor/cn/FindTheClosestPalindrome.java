package leetcode.editor.cn;

import java.util.*;

public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        Solution solution = new FindTheClosestPalindrome().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String nearestPalindromic(String n) {
            long num = Long.parseLong(n);
            if(num <= 10) return String.valueOf(num - 1);
            int len = n.length() / 2;
            long save = num;
            PriorityQueue<Long> que = new PriorityQueue<>((Long v1 ,Long v2) ->{
                long d1 = Math.abs(v1 - save), d2 = Math.abs(v2 - save);
                if (d1 == d2) return v1 > v2 ? 1 : -1;
                return d1 > d2 ? 1 : -1;
            });
            long l = (long) (num / Math.pow(10, len));
            for(int i:new int[]{-1, 0, 1}){
                long t = convert((long) ((l + i + 1) * Math.pow(10, len)) - 1);
                if(t != num) que.add(t);
            }
            return String.valueOf(que.peek());
        }

        long convert(long num) {
            // System.out.println(num);
            String n = String.valueOf(num);
            int len = (n.length()) / 2;
            num /= (long)Math.pow(10, len);
            // System.out.println(num);
            long t = num;
            if (n.length() % 2 == 1) t /= 10;
            while (t > 0) {
                num = num * 10 + t % 10;
                t /= 10;
            }
            // System.out.println(num);
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}