package leetcode.editor.cn.weekly;

import leetcode.editor.cn.LeetCodeDataStruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Weekly20220807 {


    static class Answer3 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.validPartition(new int[]{4, 4, 4, 5, 6}));
        }

        static class Solution {
            boolean[] cache;

            public boolean validPartition(int[] nums) {
                int len = nums.length;
                cache = new boolean[len];
                System.out.printf("%s \n", Arrays.toString(cache));
                return false;
            }

            boolean dfs(int[] nums, int p) {
                System.out.printf("dfs cache %s %d \n", Arrays.toString(cache), p);
                System.out.printf("dfs %s %d \n", Arrays.toString(nums), p);
                if (cache[p]) return false;
                if (p == nums.length) return true;
                if (can1(nums, p)) if (dfs(nums, p + 2)) return true;
                if (can2(nums, p)) if (dfs(nums, p + 3)) return true;
                if (can3(nums, p)) if (dfs(nums, p + 3)) return true;
                cache[p] = true;
                return false;
            }

            boolean can1(int[] nums, int p) {
                if (p + 1 >= nums.length) return false;
                return nums[p] == nums[p + 1];
            }

            boolean can2(int[] nums, int p) {
                if (p + 2 >= nums.length) return false;
                return nums[p] == nums[p + 1] && nums[p] == nums[p + 2];
            }

            boolean can3(int[] nums, int p) {
                if (p + 2 >= nums.length) return false;
                return nums[p] == nums[p + 1] - 1 && nums[p] == nums[p + 2] - 2;
            }
        }
    }

    static class Answer4 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.longestIdealString("acfgbd",
                    2);
        }

        static class Solution {
            public int longestIdealString(String s, int k) {
                int len = s.length();
                int[][] dp = new int[len][26];
                char[] c = s.toCharArray();
                dp[0][c[0] - 'a']++;
                for (int i = 1; i < len; ++i) {
                    int v = c[i] - 'a';
                    dp[i] = dp[i - 1].clone();
                    for (int j = Math.max(0, v - k); j <= Math.min(v + k, 25); ++j) {
                        dp[i][v] = Math.max(dp[i][v], dp[i][j]);
                    }
                    dp[i][v]++;
                }
                int ans = 0;
                for (int i : dp[len - 1]) ans = Math.max(i, ans);
                return ans;
            }
        }


    }
}
