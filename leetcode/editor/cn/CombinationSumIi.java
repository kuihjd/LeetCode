package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(LeetCodeDataStruct.parserIntArray("[10,1,2,7,6,1,5]"), 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        HashSet<Integer> set = new HashSet<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            ArrayList<ArrayList<List<Integer>>> dp = new ArrayList<>();
            Arrays.sort(candidates);
            for(int i = 0; i <= target; ++i) dp.add(new ArrayList<>());
            for(int i : candidates) if(i <= target) dp.get(i).add(new ArrayList<>());
            for (int i = 0; i < candidates.length; ++i) {
            }
            return dp.get(target);
        }

        ArrayList<ArrayList<Integer>> dfs(int p, int[] candidates, int target, ArrayList<Integer> list) {
            list.add(candidates[p]);
            target -= candidates[p];
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            if (target < 0) {
            } else if (target == 0) {
                int hash = Arrays.hashCode(list.toArray());
                if(!set.contains(hash)) res.add((ArrayList<Integer>) list.clone());
                set.add(hash);
            } else {
                for (int i = p + 1; i < candidates.length; ++i) {
                    res.addAll(dfs(i, candidates, target, list));
                }
            }
            list.remove(list.size() - 1);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}