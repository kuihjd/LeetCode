package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MinimumNumberOfPeopleToTeach {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfPeopleToTeach().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
            ArrayList<int[]> needTeaFriends = new ArrayList<>();
            HashSet<Integer> needTeaPeople = new HashSet<>();
            for (int[] i : friendships) {
                if (checkFriend(i[0], i[1], languages, friendships)) {
                    needTeaFriends.add(i);
                    needTeaPeople.add(i[0]);
                    needTeaPeople.add(i[1]);
                }
            }// 这些人需要教
            int[] cnt = new int[n + 10];
            for (int i : needTeaPeople){}
                return 0;
        }

        boolean checkFriend(int u1, int u2, int[][] languages, int[][] friendships) {
            HashSet<Integer> set = new HashSet<>();
            for (int i : languages[u1]) set.add(i);
            for (int i : languages[u2]) if (set.contains(i)) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}