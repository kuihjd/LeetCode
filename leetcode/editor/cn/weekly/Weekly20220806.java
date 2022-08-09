package leetcode.editor.cn.weekly;


import java.util.*;

public class Weekly20220806 {
    static class Answer1 {
        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
            Solution solution = new Solution();
            solution.mergeSimilarItems(null, null);
        }

        static class Solution {
            public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
                List<List<Integer>> ans = new ArrayList<>();
                TreeMap<Integer, Integer> map = new TreeMap<>();
                for (int[] i : items1) map.put(i[0], map.getOrDefault(i[0], 0) + i[1]);
                for (int[] i : items2) map.put(i[0], map.getOrDefault(i[0], 0) + i[1]);
                for (int i : map.keySet()) ans.add(List.of(new Integer[]{i, map.get(i)}));
                return ans;
            }
        }
    }

    static class Answer2 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.countBadPairs(new int[]{4, 1, 3, 3});
        }

        static class Solution {
            public long countBadPairs(int[] nums) {
                int len = nums.length;
//                boolean[] flag = new boolean[len];
                long ans = (long) len * ((long) len - 1) / 2;

                for (int i = 0; i < len; ++i) {
                    nums[i] -= i;
                }
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
                for (int i : map.keySet()) {
                    int v = map.get(i);
                    ans -= (long) v * (v - 1) / 2;
                }
                return ans;
            }
        }

        static class Answer3 {
            public static void main(String[] args) {
                Solution solution = new Solution();
//            solution.getArea(new Point(3, 3), new Point(0, 3), new Point(0, 0), new Point(3, 0));
                solution.taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3);
            }

            static class Solution {
                public long taskSchedulerII(int[] tasks, int space) {
                    long ans = 0;

                    HashMap<Integer, Long> pre = new HashMap<>();
                    int len = tasks.length;
                    for (int i = 0; i < len; ++i) {
                        Long p = pre.get(tasks[i]);
                        if (p != null) {
                            ans = Math.max(ans, p + space + 1);
                        }
                        pre.put(tasks[i], ans);
                        ans++;
                    }
                    return ans;
                }
            }

        }

        static class Answer4 {
            public static void main(String[] args) {
                Solution solution = new Solution();
//            solution.findIflytek("iflytekiflytek");
            }

            static class Solution {
                long ans = 0;
                public long minimumReplacement(int[] nums) {
                    int len = nums.length;
                    // [0]是数字, [1]是原坐标
                    PriorityQueue<int[]> pq = new PriorityQueue<>();
                    int pre = nums[len - 1];
                    for (int i = len - 2; i >= 0; --i) {
                        if (nums[i] > pre) pre = getN(nums[i], pre);
                        else pre = nums[i];
                    }
                    return ans;
                }

                int getN(int cur, int tar) {
                    // 先算切几份
                    int n = (cur + tar - 1) / tar;
                    if (n * tar < cur) n++;
                    ans += n - 1;
                    // 保证前一个数的下一个最大
                    return cur / n;
                }
            }
        }
    }
}



