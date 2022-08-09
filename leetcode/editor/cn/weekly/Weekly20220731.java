package leetcode.editor.cn.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Weekly20220731 {
    static class Answer1 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            public int minimumOperations(int[] nums) {
                HashSet<Integer> set = new HashSet<>();
                for (int i : nums) if (i != 0) set.add(i);
                return set.size();
            }
        }
    }

    static class Answer2 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            public int maximumGroups(int[] grades) {
                int len = grades.length;
//                Arrays.sort(grades);
                int n = 1;
                int cur = 0;
                while (true) {
                    cur += n;
                    n++;
                    if (cur >= len) return n - 1;
                }
//                return 1;
            }
        }
    }

    static class Answer3 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.closestMeetingNode(new int[]{4, 4, 4, 5, 1, 2, 2}, 1, 1);
        }

        static class Solution {
            public int closestMeetingNode(int[] edges, int node1, int node2) {
                int ans = -1;
                int anv = Integer.MAX_VALUE;
                boolean flag = false;
                int cn1 = node1, cn2 = node2;
                int len = edges.length;
                ;
                int[] cal1 = new int[len], cal2 = new int[len];
                Arrays.fill(cal1, -1);
                Arrays.fill(cal2, -1);
                int cur = 0;
                while (edges[node1] != -1 && cal1[node1] == -1) {
                    cal1[node1] = cur;
                    cur++;
                    node1 = edges[node1];
                }
                if (cal1[node1] == -1) cal1[node1] = cur;
                cur = 0;
                while (edges[node2] != -1 && cal2[node2] == -1) {
                    cal2[node2] = cur;
                    cur++;
                    node2 = edges[node2];
                }
                if (cal2[node2] == -1) cal2[node2] = cur;
//                cal1[cn1] = 0;
//                cal2[cn2] = 0;
                for (int i = 0; i < len; ++i) {
                    int v = Math.max(cal1[i], cal2[i]);
                    if (cal1[i] != -1 && cal2[i] != -1 && anv > v) {
                        ans = i;
                        anv = v;
                        flag = true;
                    }
                }
                if (!flag) return -1;
                return ans;
            }
        }
    }

    static class Answer4 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.longestCycle(new int[]{3, 3, 4, 2, 3});
        }

        static class Solution {
            public int longestCycle(int[] edges) {
                int ans = -1;
                int len = edges.length;
                ArrayList<HashSet<Integer>> in = new ArrayList<>();
//                ArrayList<HashSet<Integer>> out = new ArrayList<>();
                LinkedList<Integer> remove = new LinkedList<>();
                HashSet<Integer> survivor = new HashSet<>();
                for (int i = 0; i < len; ++i) {
                    in.add(new HashSet<>());
//                    out.add(new HashSet<>());
                    survivor.add(i);
                }
                for (int i = 0; i < len; ++i) {
                    if (edges[i] != -1) in.get(edges[i]).add(i);
                }
                do {
                    for (int i : remove) survivor.remove(i);
                    remove.clear();
                    for (int i : survivor) {
                        if (in.get(i).size() == 0) {
                            remove.add(i);
                            if (edges[i] != -1) in.get(edges[i]).remove(i);
                        }
                    }
                } while (!remove.isEmpty());
                boolean[] flag = new boolean[len];
                for (int i : survivor) {
                    int cur = 0;
                    int v = i;
                    while (!flag[v]) {
                        flag[v] = true;
                        v = edges[v];
                        cur++;
                    }
                    ans = Math.max(ans, cur);
                }
                return ans;
            }

        }


    }
}
