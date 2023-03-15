package leetcode.editor.cn.weekly;

public class Weekly20221002 {
    static class Answer1 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {

        }
    }

    static class Answer2 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {

        }
    }

    static class Answer3 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.minimizeXor(1, 12);
        }

        static class Solution {
            public int minimizeXor(int num1, int num2) {
                int n = Integer.bitCount(num2);
                int[] bit1 = new int[32];
                int i = 0;
                while (num1 > 0) {
                    if ((num1 & 1) > 0) {
                        bit1[i] = 1;
                    }
                    i++;
                    num1 /= 2;
                }
                int[] ans = new int[32];
                for (i = 31; i >= 0; --i) {
                    if (bit1[i] == 1 && n > 0) {
                        n--;
                        ans[i] = 1;
                    }
                }
                int v = 0;
                while (n > 0) {
                    if (ans[v] == 0) {
                        n--;
                        ans[v] = 1;
                    }
                    v++;
                }
                int res = 0;
                for (i = 31; i >= 0; --i) {
                    res *= 2;
                    res += ans[i];
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
