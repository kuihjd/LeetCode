package leetcode.editor.cn.weekly;

import leetcode.editor.cn.LeetCodeDataStruct;

import java.util.*;

public class Weekly20220717 {
    static class Answer1 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            public int[] numberOfPairs(int[] nums) {
                HashMap<Integer, Integer> map = new HashMap<>();
                HashSet<Integer> set = new HashSet<>();
                int a1 = 0, a2 = nums.length;
                for (int i : nums) {
                    if (set.contains(i)) {
                        a1++;
                        a2 -= 2;
                        set.remove(i);
                    } else {
                        set.add(i);
                    }
                }
                return new int[]{a1, a2};
            }
        }
    }

    static class Answer2 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            public int maximumSum(int[] nums) {
                HashMap<Integer, Integer> map = new HashMap<>();
                int ans = 0;
                for (int i : nums) {
                    int c = cal(i);
                    System.out.printf("%d-%d", i, c);
                    int pre = map.getOrDefault(c, 0);
                    if (pre != 0) ans = Math.max(ans, i + pre);
                    map.put(c, Math.max(pre, i));
                }
                return ans;
            }

            int cal(int v) {
                if (v == 0) return v;
                return cal(v / 10) + v % 10;
            }
        }
    }

    static class Answer3 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.smallestTrimmedNumbers(new String[]{"102", "473", "251", "814"}, LeetCodeDataStruct.parserTwoIntArray("[[1,1],[2,3],[4,2],[1,2]]"));

        }

        static class Solution {
            public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
                int len = nums.length;
                int nl = nums[0].length();
                Integer[][][] cache = new Integer[100][len][2];
                ArrayList<ArrayList<Help>> list = new ArrayList<>();
                for (int i = 0; i < 101; ++i) list.add(new ArrayList<>());
                boolean[] v = new boolean[101];
                int[] ans = new int[queries.length];
                int idx = 0;
                for (int[] i : queries) {
                    int d = i[1];
                    int l = nl - d;
                    if (!v[d]) {
                        v[d] = true;
//                        cache[d] = new Integer[len][2];
                        for (int j = 0; j < len; ++j) {
                            list.get(d).add(new Help(nums[j].substring(l, nl), j));
//                            cache[d][j] = new Integer[2];
//                            cache[d][j][0] = Integer.parseInt(nums[j].substring(l, nl));
//                            cache[d][j][1] = j;
                        }
//                        Arrays.sort(cache[d], (v1, v2) -> v1[0] != v2[0] ? v1[0] - v2[0] : v1[1] - v2[1] );
                        list.get(d).sort((v1, v2) -> {
                            int t = v1.s.compareTo(v2.s);
                            if (t != 0) return t;
                            return v1.idx - v2.idx;
                        });
                    }
                    ans[idx] = list.get(d).get(i[0] - 1).idx;
                    idx++;
                }
                return ans;
            }

            class Help {
                String s;
                int idx;

                Help(String s, int idx) {
                    this.s = s;
                    this.idx = idx;
                }
            }
        }


    }

    static class Answer4 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            public int minOperations(int[] nums, int[] numsDivide) {
                int ans = 0;
                int g = numsDivide[0];
                for (int i : numsDivide) g = gcd(g, i);
                Arrays.sort(nums);
                for (int i : nums) {
                    if (g % i == 0) break;
                    if (g % i != 0 && i <= g) ans++;
                    if (i > g && ans == 0) return -1;
                }
                return ans;
            }

            int gcd(int a, int b) {
                if (b == 0) return a;
                return gcd(b, a % b);
            }
        }
    }
}
