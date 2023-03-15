package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        Solution solution = new GroupThePeopleGivenTheGroupSizeTheyBelongTo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static List<Integer>[] arr = new ArrayList[500];

        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            int n;
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < groupSizes.length; i++) {
                n = groupSizes[i];
                if (arr[n] == null) {
                    arr[n] = new ArrayList<>();
                }
                arr[n].add(i);
                if (arr[n].size() == n) {
                    ans.add(arr[n]);
                    arr[n] = null;
                }
            }
            return ans;
        }
    }
}
