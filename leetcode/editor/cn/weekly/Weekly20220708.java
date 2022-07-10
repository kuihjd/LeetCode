package leetcode.editor.cn.weekly;

import leetcode.editor.cn.LeetCodeDataStruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Weekly20220708 {
    static class Answer1 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            public boolean canReceiveAllSignals(int[][] intervals) {
                Arrays.sort(intervals, (v1, v2) -> {
                    if (v1[0] != v2[0]) return v1[0] - v2[0];
                    return v1[1] - v2[1];
                });
                int pre = -1;
                for (int[] i : intervals) {
                    if (pre >= i[0]) return false;
                    pre = i[1];
                }
                return true;
            }
        }
    }

    static class Answer2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int u = 1;
            while (u == 1) {
                int v = scanner.nextInt(), n = scanner.nextInt();
                t(v, n);
            }
            System.out.println(7 << 31);
            System.out.println(Integer.toBinaryString(7 << 31));
            System.out.println(-1 << 32);
            System.out.println(1 << 33);
            System.out.println(Integer.toBinaryString(-32));
            System.out.println(-32 >>> 3);
            System.out.println(Integer.toBinaryString(-32 >>> 3));
            System.out.println(Integer.toBinaryString(32 >>> 3));
            System.out.println(-32 >> 3);
            System.out.println(Integer.toBinaryString(-32 >> 3));
            System.out.println(Integer.toBinaryString(32 >>> 3));
            System.out.println(-32 << 3);
            System.out.println(Integer.toBinaryString(-32 << 3));
            System.out.println(Integer.toBinaryString(32 << 3));
            Solution solution = new Solution();
            solution.minSwaps(new int[]{1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1});
        }

        static void t(int v, int n) {
            System.out.println(v >> n);
            System.out.println(Integer.toBinaryString(v >> n));
            System.out.println(v >>> n);
            System.out.println(Integer.toBinaryString(v >>> n));
            System.out.println(v << n);
            System.out.println(Integer.toBinaryString(v << n));
        }

        static int b(String v) {
            return Integer.parseInt(v, 2);
        }

        static class Solution {
            public int minSwaps(int[] chess) {
                int cnt = 0;
                int len = chess.length;
                int cur = 0;
                for (int i : chess) cnt += i;
                for (int i = 0; i < cnt; ++i) {
//                    chess[i] = chess[i] == 1 ? 0 : 1;
                    cur += chess[i];
                }
                int res = cnt - cur;
                for (int i = cnt; i < len; ++i) {
                    cur -= chess[i - cnt];
                    cur += chess[i];
                    res = Math.min(res, cnt - cur);
                }
                return res;
            }
        }
    }

    static class Answer3 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.buildTransferStation(LeetCodeDataStruct.parserTwoIntArray("[[0,1,0,0,0],[0,0,0,0,1],[0,0,1,0,0]]"));
        }

        static class Solution {
            public int buildTransferStation(int[][] area) {
                ArrayList<int[]> have = new ArrayList<>();
                int res = Integer.MAX_VALUE;
                int m = area.length, n = area[0].length;
                int hc = 0, wc = 0;
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (area[i][j] == 1) {
                            have.add(new int[]{i, j});
                            hc += i;
                            wc += j;
                        }
                    }
                }
                hc /= have.size();
                wc /= have.size();
                int[][] all = have.toArray(new int[0][0]);
                for (int i = Math.max(hc - 50, 0); i < Math.min(hc + 50, m); ++i) {
                    for (int j = Math.max(wc - 50, 0); j < Math.min(wc + 50, n); j++) {
                        res = Math.min(res, cal(all, i, j));
                    }
                }
                return res;
            }

            int cal(int[][] all, int x, int y) {
                int res = 0;
                for (int[] i : all) {
                    res += Math.abs(x - i[0]) + Math.abs(y - i[1]);
                }
                return res;
            }
        }
    }

    static class Answer4 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {

        }
    }
}
