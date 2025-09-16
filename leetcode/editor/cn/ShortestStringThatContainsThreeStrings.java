package leetcode.editor.cn;

import java.util.PriorityQueue;

public class ShortestStringThatContainsThreeStrings {
    public static void main(String[] args) {

        Solution solution = new ShortestStringThatContainsThreeStrings().new Solution();
        solution.minimumString("aa", "ab", "a");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minimumString(String a, String b, String c) {
            PriorityQueue<String> pq = new PriorityQueue<>((v1, v2) -> v1.length() != v2.length() ? v1.length() - v2.length() : v1.compareTo(v2));
            pq.offer(merge(a, b, c));
            pq.offer(merge(a, c, b));
            pq.offer(merge(b, c, a));
            pq.offer(merge(b, a, c));
            pq.offer(merge(c, a, b));
            pq.offer(merge(c, b, a));
            return pq.peek();
        }

        String merge(String a, String b, String c) {
            int n1 = a.length(), n2 = b.length(), n3 = c.length();
            int p1 = 0, p2 = 0, p3 = 0;
            StringBuilder sb = new StringBuilder();
            while (p1 < n1) {
                sb.append(a.charAt(p1));
                if (p2 < n2) {
                    p2 = b.charAt(p2) == a.charAt(p1) ? p2 + 1 : 0;
                }
                if (p3 < n3) {
                    p3 = c.charAt(p3) == a.charAt(p1) ? p3 + 1 : 0;
                }
                p1++;
                System.out.println("1: p1=" + p1 + ",p2=" + p2 + ",p3=" + p3);
            }
            while (p2 < n2) {
                sb.append(b.charAt(p2));
                if (p3 < n3) {
                    p3 = c.charAt(p3) == b.charAt(p2) ? p3 + 1 : 0;
                }
                p2++;
                System.out.println("2: p1=" + p1 + ",p2=" + p2 + ",p3=" + p3);
            }
            while (p3 < n3) {
                sb.append(c.charAt(p3++));
                System.out.println("3: p1=" + p1 + ",p2=" + p2 + ",p3=" + p3);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}