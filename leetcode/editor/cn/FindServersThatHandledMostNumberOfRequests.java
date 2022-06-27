package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class FindServersThatHandledMostNumberOfRequests {
    public static void main(String[] args) {
        Solution solution = new FindServersThatHandledMostNumberOfRequests().new Solution();
        solution.busiestServers(2, new int[]{1,4,5,7}, new int[]{3,2,7,8});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> set = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);
        int max = 0;
        int[] cnt = new int[k];
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            while(!pq.isEmpty() && pq.peek()[0] <= arrival[i]) set.add(pq.poll()[1]);
            if(set.isEmpty()) continue;
            Integer loc = set.ceiling(i % k);
            if(loc == null) loc = set.first();
            set.remove(loc);
            pq.add(new int[]{i + load[i], loc});
            cnt[loc]++;
            max = Math.max(max, cnt[loc]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(cnt[i] == max) ans.add(i);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}