package leetcode.editor.cn.weekly;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Weekly20220814 {
    static class Answer1 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            public int[][] largestLocal(int[][] grid) {
                int n = grid.length;
                int[][] ans = new int[n - 2][n - 2];
                for (int i = 1; i < n - 1; ++i) {
                    for (int j = 1; j < n - 1; ++j) {
                        int max = Integer.MIN_VALUE;
                        for (int k = i - 1; k < i + 2; k++) {
                            for (int l = j - 1; l < j + 2; l++) {
                                max = Math.max(max, grid[k][l]);
                            }
                        }
                        ans[i - 1][j - 1] = max;
                    }
                }
                return ans;
            }
        }
    }

    static class Answer2 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.edgeScore(new int[]{2, 0, 0, 2});
        }

        static class Solution {
            public int edgeScore(int[] edges) {
                int n = edges.length;
                int ans = -1;
                long anv = 0;
                long[] scope = new long[n];
                for (int i = 0; i < n; ++i) {
                    scope[edges[i]] += i;
                }
                for (int i = 0; i < n; i++) {
                    if (scope[i] > anv) {
                        ans = i;
                        anv = scope[i];
                    }
                }
                return ans;
            }
        }
    }

    static class Answer3 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.smallestNumber("DDD");
        }

        static class Solution {
            public String smallestNumber(String pattern) {
//                for (int i = 1; i < 10; ++i) {
//                    String s = check(pattern.toCharArray(), i);
//                    if (s.equals("")) {
//                        continue;
//                    }
//                    return s;
//                }
                return dfs(new StringBuilder(), 1, 9, pattern.toCharArray(), new boolean[10], 0);
            }

            String dfs(StringBuilder sb, int l, int r, char[] c, boolean[] visited, int p) {
                for (int i = l; i <= r; ++i) {
                    if (!visited[i]) {
                        visited[i] = true;
                        sb.append(i);
                        if (p == c.length) {
                            return sb.toString();
                        }
                        int nl = 1, nr = 9;
                        if (c[p] == 'I') {
                            nl = i + 1;
                        } else {
                            nr = i - 1;
                        }
                        String v = dfs(sb, nl, nr, c, visited, p + 1);
                        if (!"".equals(v)) {
                            return v;
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        visited[i] = false;
                    }
                }
                return "";
            }

            String check(char[] pattern, int n) {
                TreeSet<Integer> treeSet = new TreeSet<>();
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < 10; ++i) {
                    treeSet.add(i);
                }
                sb.append(n);
                treeSet.remove(n);
                for (char i : pattern) {
                    Integer v = null;
                    if (i == 'I') {
                        v = treeSet.higher(n);
                    } else {
                        v = treeSet.lower(n);
                    }
                    if (v == null) {
                        return "";
                    }
                    n = v;
                    sb.append(n);
                    treeSet.remove(n);
                }
                return sb.toString();
            }
        }
    }

    static class Answer4 {
        public static void main(String[] args) {
            Solution solution = new Solution();
        }

        static class Solution {
            // f[l][r] 代表 i * (i + 1) * ... * (j - 1) * j
            static int[][] f = new int[10][10];
            static {
                for (int i = 1; i < 10; i++) {
                    for (int j = i; j < 10; j++) {
                        int cur = 1;
                        for (int k = i; k <= j; k++) {
                            cur *= k;
                        }
                        f[i][j] = cur;
                    }
                }
            }
            int dp(int x) {
                int t = x;
                List<Integer> nums = new ArrayList<>();
                while (t != 0) {
                    nums.add(t % 10);
                    t /= 10;
                }
                int n = nums.size();
                if (n <= 1) {
                    return x + 1; // [0, 9]
                }
                // 位数和 x 相同（res1 + res2）
                int ans = 0;
                for (int i = n - 1, p = 1, s = 0; i >= 0; i--, p++) {
                    int cur = nums.get(i), cnt = 0;
                    for (int j = cur - 1; j >= 0; j--) {
                        if (i == n - 1 && j == 0) {
                            continue;
                        }
                        if (((s >> j) & 1) == 0) {
                            cnt++;
                        }
                    }
                    int a = 10 - p, b = a - (n - p) + 1;
                    ans += b <= a ? cnt * f[b][a] : cnt;
                    if (((s >> cur) & 1) == 1) {
                        break;
                    }
                    s |= (1 << cur);
                    if (i == 0) {
                        ans++;
                    }
                }
                // 位数比 x 少（res3）
                ans += 10;
                for (int i = 2, last = 9; i < n; i++) {
                    int cur = last * (10 - i + 1);
                    ans += cur; last = cur;
                }
                return ans;
            }
            public int numDupDigitsAtMostN(int n) {
                return (n + 1) - dp(n);
            }
        }
        class Solution1 {
            /**
             * 求[x, y]区间中，表示为b进制时，所含有的幂次的系数全部为1或者0的数的个数。
             * 如，1011（十进制）= 1 * 10^3 + 0 * 10^2 + 1 * 10^1 + 1 * 10^0
             * 实际上，求得是一类x，当将x表示为b进制时，和为x的所有b幂次的系数`全为1`
             */
            public int solve(int x, int y, int k, int b) {
                return dp(y, b, k) - dp(x - 1, b, k);
            }

            // f[i][j]:求i位b进制数中，数字只有0和1的情况下，1的个数为j的数的个数。
            static final int N = 32;
            static int[][] f = new int[N + 1][N + 1]; // 从数位最多为二进制考虑，即最大为32位，也就最多有32个1
            static {

                //习惯性的不考虑任何i=0的情况

                for (int i = 1; i <= N; i++) {
                    // 从i位数中选取0个1，当前只有全为为0这种解了。
                    f[i][0] = 1;
                }
                f[1][1] = 1; //f[1][i] = 0, (i > 1)

                for (int i = 2; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        // 求i位中1的个数位j的情况，就是求1的排列数
                        // 从动态规划角度考虑：i位数j个1，对于任何一个数位，只有两种情况:
                        // 1)为0，则就需要在剩下的i-1个数中得到j个1；
                        // 2)为1，就需要在剩下i-1个数中得到j-1个1.
                        f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                    }
                }
            }

            // 将区间问题，统一转化为[0, n]的问题，这样区间问题就变成了dp(y) - dp(x - 1)问题。
            public int dp(int n, int b, int k) {

                if (n == 0) {
                    // 看题意，必须处理0防止bits为空。
                    return 1;
                }

                // 1. 获取数位
                // 1)预估数位个数：32位整数位数最多的进制为2进制，即32位，剩下所有进制都没有32个，故开辟32位作为数位数组是足够的
                int[] bits = new int[32];

                // 2) 得到每个数位，高位在最后一位
                int len = 0;
                while (n != 0) {
                    bits[len++] = n % b;
                    n /= b;
                }

                // 2. 模板部分
                int res = 0; // 结果变量，根据实际情况可能是一个数组
                int last = 0; // 保存dp树右边界的上一个状态，这里记录有边界上已经取得的1的数量【这个设置初始值比较有讲究，需要满足不能干扰第一次遍历的特点，本题中，我们想要的是n表示为b进制时，1的数量，所以0不会干扰求解】。

                for (int i = len - 1; i >= 0; i--) { // 习惯上都是从高位向着低位探索
                    int x = bits[i];
                    if (x >= 1) { // 若当前位为0，那么为了保证右边界的数能够小于等于原数【之前每一位全部都相等】，只能填0，因此这一位可以直接跳过，被固定死了
                        // 只要当前位大于0，那么结果集里面，当前位为0的全部答案都能被覆盖，这就让这个穷举的问题变成了一个可以直接求解的问题
                        // (PS:这个`通过结果集覆盖某个分支而直接求解这个分支`的思想是数位DP的核心，而`直接求解`这件事本身是数位DP另一个要点，就是上面的预处理数组f)
                        res += f[i + 1][k - last]; // 将当前位置固定为0后，后面无论怎么取都能满足`? < n`, 所以可以通过预处理直接求解[?指通过排列0，1得到的目标数]
                        if (x > 1) {
                            // 同理，若当前位置大于1，则可以取得当前数位为1的全部解【无论后面怎么排列，都必定满足? < n】，故可以直接求解
                            if (k - last - 1 >= 0) {
                                res += f[i + 1][k - last - 1]; // 可以取1的另一个条件是，右边界上全部的1的数量last仍然小于k
                            }

                            // 因为右子树的含义是：`？的第i位取当前数位值x的情况下`，接下来的情况数; 而这题要求的是只能取1或者0，而此时的x>1，不符合条件，右子树被直接剪枝
                            break;
                        } else {
                            // 由于当前位置刚好为1，解集合没能完全覆盖这个分支，所以只能继续`递归`求解
                            last++;
                            if (last > k) {
                                // 但是，若是右子树取了这个1以后，导致右边界1的数量已经超过了k，那么右子树下的任何解都必定不满足要求，直接剪枝
                                break;
                            }
                        }
                    }
                    if (i == 0 && last == k) {
                        // 右边界本身【即n本身】就是一个可行解，而我们即将退出循环，导致这个可行解没有考虑到，在这里补上
                        res++;
                    }
                }

                return res;
            }
        }

    }
}
