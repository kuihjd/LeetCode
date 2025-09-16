package leetcode.editor.cn;

import java.util.*;

public class FindKClosestElements{
    public static void main(String[] args) {
    	
        Solution solution = new FindKClosestElements().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int d1 = Math.abs(a - x) , d2 = Math.abs(b - x);
            if (d1 == d2) {
                return a - b;
            }
            return d1 <= d2 ? -1 : 1;
        });
        for (int i : arr) {
            queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while (k -- > 0) {
            res.add(queue.poll());
        }
//        System.out.println(res.size());
//        for (int i : arr) {
//            System.out.println(i);
//        }
        res.sort((a, b) -> a - b);
        return res;
    }
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int n = arr.length;
        int l = findX(arr, x), r = l;
        // 可能出现[1, 2, 10] 1 1这种样例, find会找到2
        System.out.println("l1 = " + l);
        if (l < n - 1 && Math.abs(arr[l + 1] - x) < Math.abs(arr[l] - x)) {
            r = l = l + 1;
        }
        System.out.println("l2 = " + l);
        while (--k > 0) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else if (Math.abs(x - arr[l - 1]) <= Math.abs(arr[r + 1] - x)) {
                l--;
            } else {
                r++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; ++i) {
            res.add(arr[i]);
        }
        return res;
    }
    // 二分查找X在哪, 找不到X也能找到最靠近X的位置
    // [0,0,1,2,3,3,4,7,7,8]
    int findX(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            System.out.println(l + " " + r);
            int mid = (l + r + 1) / 2;
            if (arr[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}