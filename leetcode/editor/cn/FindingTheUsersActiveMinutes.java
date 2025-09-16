package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes{
    public static void main(String[] args) {
    	
        Solution solution = new FindingTheUsersActiveMinutes().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            Map<Integer, Set<Integer>> log = new HashMap<>();
            for (int[] i : logs) {
                if (!log.containsKey(i[1])) {
                    log.put(i[1], new HashSet<>());
                }
                log.get(i[1]).add(i[0]);
            }
            int[] res = new int[k];
            for (Map.Entry<Integer, Set<Integer>> i : log.entrySet()) {
                System.out.println(i.getKey() + " " + i.getValue().size());
                res[i.getValue().size() - 1]++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}