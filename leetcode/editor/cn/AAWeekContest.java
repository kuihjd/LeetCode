package leetcode.editor.cn;

import java.math.BigInteger;
import java.util.*;

public class AAWeekContest {
    public static void main(String[] args) {
//        new SolutionSpring().main();
        BookMyShow show = new BookMyShow(4, 5);
        show.scatter(6, 2);
        show.gather(6, 3);
        show.scatter(9, 1);
    }

    static class BookMyShow {
        private int[] loc;
        private int m;
        // 0: 行  1: 剩下位置
        private PriorityQueue<int[]> pq1 = new PriorityQueue<>((v1, v2) -> v1[0] != v2[0] ? v1[0] - v2[0] : v1[1] - v2[1]);// 以剩余数量排列
        private PriorityQueue<int[]> pq2 = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);// 以存在空位排列

        public BookMyShow(int n, int m) {
            loc = new int[n];
            this.m = m;
//            Arrays.fill(loc, m);
            for (int i = 0; i < n; ++i) {
                pq1.add(new int[]{i, m});
                pq2.add(new int[]{i, m});
            }
        }

        // 连续k个
        public int[] gather(int k, int maxRow) {
            LinkedList<int[]> t = new LinkedList<>();
            update(pq1);
            while (!pq1.isEmpty() && pq1.peek()[1] < k) {
                int[] ta = pq1.poll();
                if (ta[1] != 0) t.add(ta);
                update(pq1);
            }
            if (pq1.isEmpty() || pq1.peek()[0] > maxRow) {
                pq1.addAll(t);
                return new int[0];
            }
            int[] ta = pq1.poll();
            pq1.addAll(t);
            ta[1] -= k;
            loc[ta[0]] += k;
            if (ta[1] != 0) pq1.add(ta);
            return new int[]{ta[0], loc[ta[0]] - k};
        }

        // 非连续k个但是需要前row排
        public boolean scatter(int k, int maxRow) {
            int sum = 0;
            LinkedList<int[]> t = new LinkedList<>();
            while (sum < k && !pq2.isEmpty() && pq2.peek()[0] <= maxRow) {
                update(pq2);
                int[] ta = pq2.poll();
                if (ta[1] != 0) t.add(ta);
                sum += ta[1];
            }
            if (sum < k) {
                pq2.addAll(t);
                return false;
            }
            sum = k;
            for (int[] i : t) {
                int d = Math.min(i[1], sum);
                sum -= d;
                i[1] -= d;
                loc[i[0]] += d;
                if (i[1] > 0) pq2.add(i);
            }
            return true;
        }

        void update(PriorityQueue<int[]> pq) {
            if (!pq.isEmpty() && pq.peek()[1] != m - loc[pq.peek()[0]]) {
                int[] t = pq.poll();
                t[1] = m - loc[t[0]];
                pq.add(t);
            }
        }
    }



    class Solution {
        public long maximumImportance(int n, int[][] roads) {
            int[] cnt = new int[n];
            for (int[] i : roads) {
                cnt[i[0]]++;
                cnt[i[1]]++;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int i : cnt) pq.add(i);
            long v = n;
            long res = 0;
            while (!pq.isEmpty()) {
                System.out.println(pq.peek() + " " + v);
                res += pq.poll() * v--;
            }
            return res;
        }
    }

    class Solution2 {
        public String largestWordCount(String[] messages, String[] senders) {
            int n = messages.length;
            TreeMap<String, Integer> map = new TreeMap<>((v1, v2) -> v2.compareTo(v1));
            int max = 0;
            for (int i = 0; i < n; ++i) {
                if (!map.containsKey(senders[i])) map.put(senders[i], 0);
                map.put(senders[i],
                        map.get(senders[i]) + messages[i].split(" ").length);
                max = Math.max(max, map.get(senders[i]));
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) return entry.getKey();
            }
            return null;
        }
    }

    class Solution1 {
        public boolean digitCount(String num) {
            int[] cnt = new int[100];
            for (int i : num.toCharArray()) cnt[i - '0']++;
            for (int i = 0; i < num.length(); ++i) {
                int n = num.charAt(i) - '0';
                if (cnt[i] != n) return false;
            }
            return true;
        }
    }

    static public class Solution220522 {
        class Solution {
            public int minimumLines(int[][] stockPrices) {
                // 先排序
                // 后一个减前一个的坐标差值
                // 前一个减去更前一个的差值
                // 这两个差值能否形成表示成对方的整数倍
                // 如果可以, 那就在一条线上
                // 为了方便计算, 直接gcd约到最简, 这样子可以简单的判断相等即可
                Arrays.sort(stockPrices, (v1, v2) -> v1[0] - v2[0]);
                int n = stockPrices.length;
                int preXd = 0, preYd = 0;
                int ans = 0;
                for (int i = 1; i < n; ++i) {
                    int curXd = stockPrices[i][0] - stockPrices[i - 1][0];
                    int curYd = stockPrices[i][1] - stockPrices[i - 1][1];
                    int g = gcd(curXd, curYd);
                    curYd /= g;
                    curXd /= g;
                    if (curYd != preYd || curXd != preXd) {
                        preYd = curYd;
                        preXd = curXd;
                        ans++;
                    }
                }
                return ans;
            }

            int gcd(int a, int b) {
                if (b == 0) return a;
                return gcd(b, a % b);
            }
        }

        class Solution2 {
            public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
                int n = capacity.length;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int i = 0; i < n; ++i) {
                    pq.add(capacity[i] - rocks[i]);
                }
                int ans = 0;
                while (!pq.isEmpty() && pq.peek() <= additionalRocks) {

                    additionalRocks -= pq.poll();
                    ans++;
                }
                return ans;
            }
        }
    }

    static public class Solution220515 {
        public static void main(String[] args) {
            CountIntervals countIntervals = new CountIntervals();
            countIntervals.add(1, 1);
            countIntervals.add(1, 1);

            System.out.println(countIntervals.count());
        }

        static class CountIntervals {
            TreeSet<int[]> set = new TreeSet<>((v1, v2) -> v1[0] - v2[0]);
            int cnt = 0;

            public CountIntervals() {

            }

            public void add(int left, int right) {
                int[] pre = set.floor(new int[]{left});
                if (pre != null && pre[1] >= left) left = pre[0];// 前面的末尾能不能越过此时的头, 如果能, 那把头拉长
                int[] next = set.floor(new int[]{right});
                if (next != null) right = Math.max(next[1], right);// 这个肯定是和要添加的集合有交集, 把尾巴拉到最长
                while (true) {
                    int[] del = set.ceiling(new int[]{left});
                    if (del != null && del[0] <= right) {// 是新集合子集就删除
                        set.remove(del);
                        cnt -= del[1] - del[0] + 1;
                    } else break;
                }
                set.add(new int[]{left, right});
                cnt += right - left + 1;
            }

            public int count() {
                return cnt;
            }
        }

    }


    static public class Solution501 {
        static void main(String[] args) {

        }

        class Solution4 {
            public long appealSum(String s) {
                long res = 0;
                char[] c = s.toCharArray();
                return res;
            }
        }

        class Solution3 {


            public int countDistinct(int[] nums, int k, int p) {
                int len = nums.length;
                int[] cnt = new int[len + 1];
//                int idx = 0 ;
                int ans = 0;
                for (int i = 1; i <= len; ++i) {
                    cnt[i] = cnt[i - 1];
                    if (nums[i - 1] % p == 0) cnt[i] += 1;
                }
                HashSet<String> set = new HashSet<>();
                for (int i = 0; i < len; ++i) {
                    for (int j = i; j < len; ++j) {
                        if (i == 0 && j == len - 1) continue;
                        if (cnt[j + 1] - cnt[i] > k) break;
                        int[] m = Arrays.copyOfRange(nums, i, j + 1);
                        Arrays.sort(m);
                        String tnum = Arrays.toString(m);
                        if (set.contains(tnum)) continue;
                        set.add(tnum);
                        ans++;
                    }
                }
                // 有cnt个元素可以被整除
//                for(String i : set) System.out.println(i);
                return ans;
            }

        }

        static class Solution2 {
            public int minimumCardPickup(int[] cards) {
                HashMap<Integer, Integer> map = new HashMap<>();
                int res = Integer.MAX_VALUE;
                for (int i = 0; i < cards.length; ++i) {
                    if (map.containsKey(cards[i])) {
                        res = Math.min(res, i - map.get(cards[i] + 1));
                    }
                    map.put(cards[i], i);
                }
                if (res == Integer.MAX_VALUE) return -1;
                return res;
            }
        }

        class Solution1 {
            PriorityQueue<BigInteger> pq = new PriorityQueue<>();

            public String removeDigit(String number, char digit) {
                char[] c = number.toCharArray();
                for (int i = 0; i < c.length; ++i) {
                    if (c[i] == digit) pq.add(new BigInteger(number.substring(0, i) + number.substring(i + 1)));
                }
                return pq.poll().toString();
            }
        }

    }

    static public class Solution430 {
        public static void main(String[] args) {
            new Solution2().minimumAverageDifference(LeetCodeDataStruct.parserIntArray("[0,0,3]"));
        }

        class Solution1 {
            public int countPrefixes(String[] words, String s) {
                int cnt = 0;
                for (String i : words) {
                    if (i.length() <= s.length() && s.substring(0, i.length()).equals(i)) cnt++;
                }
                return cnt;
            }
        }


        static class Solution2 {
            public int minimumAverageDifference(int[] nums) {
//                int[] sum = nums.clone();
//                for (int i = 1; i < sum.length; ++i) sum[i] += sum[i - 1];
//                int res = 0, min = Integer.MAX_VALUE;
//                for (int i = 0; i < sum.length - 1; ++i) {
//                    int preVal = sum[i];
//                    int neVal = sum[sum.length - 1] - sum[i];
//                    int pren = (i + 1);
//                    int v = Math.abs(preVal / pren - neVal / (sum.length - pren));
//                    if (v < min) {
//                        min = v;
//                        res = i;
//                    }
//                }
//                if (Math.abs(sum[sum.length - 1] / sum.length) < min) res = sum.length - 1;
//                return res;
                long sum = 0;
                long pv = 0;
                for (int i : nums) sum += i;
                int p = 0, n = nums.length;
                long min = Integer.MAX_VALUE;
                int res = -1;
                for (int i = 0; i < nums.length - 1; ++i) {
                    pv += nums[i];
                    p++;
                    n--;
                    long v = Math.abs(pv / p - (sum - pv) / n);
                    if (v < min) {
                        min = v;
                        res = i;
                    }
                }
                pv += nums[nums.length - 1];
                if (Math.abs(pv / nums.length) < min) {
                    res = nums.length - 1;
                }
                return res;
            }
        }

        class Solution3 {
            public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
                int[][] map = new int[m][n];
                for (int[] i : guards) map[i[0]][i[1]] = 1;
                for (int[] i : walls) map[i[0]][i[1]] = 2;
                int ans = 0;
                for (int[] i : guards) {
                    change(map, i[0], i[1], 0, 1);
                    change(map, i[0], i[1], 0, -1);
                    change(map, i[0], i[1], 1, 0);
                    change(map, i[0], i[1], -1, 0);
                }
                for (int[] i : map) {
                    for (int j : i) {
                        if (j == 0) ans++;
                        System.out.printf("%d ", j);
                    }
                    System.out.println();
                }
                return ans;
            }

            void change(int[][] map, int x, int y, int xo, int yo) {
                x += xo;
                y += yo;
                while (check(map, x, y)) {
                    if (map[x][y] == 1 || map[x][y] == 2) return;
                    map[x][y] = 4;
                    x += xo;
                    y += yo;
                }
            }

            boolean check(int[][] map, int x, int y) {
                if (map.length <= x || x < 0) return false;
                if (map[0].length <= y || y < 0) return false;
                return true;
            }
        }

        class Solution4 {
            Helper[][] m;
            int[] d = new int[]{0, 1, 0, -1, 0};

            public int maximumMinutes(int[][] grid) {
                m = new Helper[grid.length][grid[0].length];
                for (int i = 0; i < grid.length; ++i) {
                    for (int j = 0; j < grid[0].length; ++j) {
                        m[i][j] = new Helper(grid[i][j], i, j);
                    }
                }
                if (!bfs1(grid)) return -1;
                // 人可以到右下角
                clear();
                if (!bfs2(grid)) return 1000000000;
                // 火也可以
                clear();
                return -1;
            }

            HashSet<Helper> fire(int[][] grid, HashSet<Helper> set) {
                // 让火烧一轮
                HashSet<Helper> res = new HashSet<>();
                for (Helper i : set) {
                    int x = i.x, y = i.y;
                    for (int j = 0; j < 4; ++j) {
                        int nx = x + d[j], ny = y + d[j + 1];
                        if (check(grid, nx, ny)) {
                            if (m[nx][ny].stat == 1) continue;
                            if (!(m[nx][ny].v && m[nx][ny].stat == 2)) {
                                res.add(m[nx][ny]);
                                m[nx][ny].v = true;
                                m[nx][ny].stat = 2;
                            }
                        }
                    }
                }
                return res;
            }

            HashSet<Helper> people(int[][] grid, HashSet<Helper> set) {
                // 让人走一轮
                HashSet<Helper> res = new HashSet<>();
                for (Helper i : set) {
                    int x = i.x, y = i.y;
                    for (int j = 0; j < 4; ++j) {
                        int nx = x + d[j], ny = y + d[j + 1];
                        if (check(grid, nx, ny)) {
                            if (m[nx][ny].stat == 1) continue;
                            if (m[nx][ny].stat == 2) continue;
                            if (!m[nx][ny].v) {
                                res.add(m[nx][ny]);
                                m[nx][ny].v = true;
                            }
                        }
                    }
                }
                return res;
            }

            void reInti(int[][] grid) {
                for (int i = 0; i < grid.length; ++i) {
                    for (int j = 0; j < grid[0].length; ++j) {
                        m[i][j].stat = grid[i][j];
                    }
                }
            }

            boolean bfs1(int[][] grid) {
                HashSet<Helper> set = new HashSet<>();
                set.add(m[0][0]);
                m[0][0].v = true;
                return bfs(grid, set);
            }

            boolean bfs2(int[][] grid) {
                HashSet<Helper> set = new HashSet<>();
                for (int i = 0; i < grid.length; ++i) {
                    for (int j = 0; j < grid[0].length; ++j) {
                        if (m[i][j].stat == 1) {
                            set.add(m[i][j]);
                            m[i][j].v = true;
                        }
                    }
                }
                return bfs(grid, set);
            }

            private boolean bfs(int[][] grid, HashSet<Helper> set) {
                while (!set.isEmpty()) {
                    HashSet<Helper> t = new HashSet<>();
                    for (Helper i : set) {
                        int x = i.x, y = i.y;
                        for (int j = 0; j < 4; ++j) {
                            int nx = x + d[j], ny = y + d[j + 1];
                            if (check(grid, nx, ny)) {
                                if (m[nx][ny].stat == 1) continue;
                                if (!m[nx][ny].v) {
                                    if (nx == grid.length - 1 && ny == grid[0].length - 1) return true;
                                    t.add(m[nx][ny]);
                                    m[nx][ny].v = true;
                                }
                            }
                        }
                    }
                    set = t;
                }
                return false;
            }

            void clear() {
                for (Helper[] i : m) for (Helper j : i) j.v = false;
            }

            boolean check(int[][] map, int x, int y) {
                if (map.length <= x || x < 0) return false;
                if (map[0].length <= y || y < 0) return false;
                return true;
            }

            int[][] clone(int[][] grid) {
                int[][] res = new int[grid.length][0];
                for (int i = 0; i < grid.length; ++i) res[i] = grid[i].clone();
                return res;
            }

            class Helper {
                int stat, x, y;
                boolean v = false;

                Helper(int stat, int x, int y) {
                    this.stat = stat;
                    this.x = x;
                    this.y = y;
                }
            }
        }
    }

    static public class SolutionSpring {
        public static void main(String[] args) {
//            SolutionSpring_2 SolutionSpring_2 = new SolutionSpring_2();
//            SolutionSpring_2.conveyorBelt(new String[]{
//                    ">^^>", "<^v>", "^v^<"
//            }, new int[]{0, 0}, new int[]{1, 3});
            fullBloomFlowers(
                    LeetCodeDataStruct.parserTwoIntArray("[[1,6],[3,7],[9,12],[4,13]]"),
                    LeetCodeDataStruct.parserIntArray("[2,3,7,11]"));
            SolutionSpring_3 solutionSpring_3 = new SolutionSpring_3();
            solutionSpring_3.getMaximumNumber(LeetCodeDataStruct.parserTwoIntArray("[[0,0,0],[1,1,0],[0,2,0],[1,0,1],[1,2,1]]"));

        }

        public static int[] fullBloomFlowers(int[][] flowers, int[] persons) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int[] i : flowers) {
                map.put(i[0], map.getOrDefault(i[0], 0) + 1);
                map.put(i[1] + 1, map.getOrDefault(i[1] + 1, 0) - 1);
            }
            for (int i : persons) map.put(i, 0);
            int[] res = new int[persons.length];
            TreeMap<Integer, Integer> ansMap = new TreeMap<>();
            int cur = 0;
            for (Map.Entry<Integer, Integer> i : map.entrySet()) {
                cur += i.getValue();
                ansMap.put(i.getKey(), cur);
            }
            for (int i = 0; i < persons.length; ++i) res[i] = ansMap.floorEntry(persons[i]).getValue();
            return res;
        }

        static class SolutionSpring_3 {
            static int[][][] dir = new int[4][][];

            // 几步 第几个坐标 坐标值 --
            static {
                LinkedList<int[]> t = new LinkedList<>();
                int[] d = new int[]{0, 1, 0, -1, 0};
                t.add(new int[]{0, 0});
                for (int i = 1; i <= 3; ++i) {
                    LinkedList<int[]> next = new LinkedList<>();
                    while (!t.isEmpty()) {
                        int[] cur = t.poll();
                        for (int j = 0; j < 4; ++j) {
                            next.add(new int[]{cur[0] + d[j], cur[1] + d[j + 1]});
                        }
                    }

                    t = next;
                    dir[i] = t.toArray(new int[0][0]);
                }
            }

            public int getMaximumNumber(int[][] moles) {
                int ans = 0;
                Arrays.sort(moles, (v1, v2) -> v1[0] - v2[0]);
                Helper head = new Helper(-1, null);
                Helper cur = head;
                for (int[] i : moles) {
                    if (cur.t != i[0]) {
                        Helper t = new Helper(i[0], cur);
                        cur.next = t;
                        cur = t;
                    }
                    cur.m[i[1]][i[2]] = true;
                }
                head.next.pre = null;
                /*
                以上为初始化 head仅为了方便纪录, 不参与运算
                接下来思路:
                每个点向前索取最大值
                如果当前时间 >= 前点+4 --即可以随便跑
                直接取出max
                 */

                cur = head.next;
                while (cur != null) {
                    convert(cur, new Helper(-1000, null));
                    Helper pre = cur.pre;
                    while (pre != null) {
                        convert(cur, pre);
                        if (cur.t - pre.t >= 4) break;
                        pre = pre.pre;
                    }
                    ans = Math.max(ans, cur.max);
                    cur = cur.next;
                }
                return ans;
            }

            private class Helper {
                Helper pre, next = null;
                int t;
                int max = 0;
                boolean[][] m = new boolean[3][3];
                int[][] dp = new int[3][3];

                Helper(int t, Helper pre) {
                    this.pre = pre;
                    this.t = t;
                }
            }

            boolean init1 = true, init0 = true;

            void convert(Helper cur, Helper pre) {
                if (cur.t == 0 && init0) {
                    init0 = false;
                    if (cur.m[1][1]) {
                        cur.dp[1][1] = 1;
                        cur.max = 1;
                    }
                    return;
                }
                if (cur.t == 1 && init1) {
                    init1 = false;
                    for (int i = 0; i < 3; ++i) {
                        if (cur.pre != null && cur.pre.max == 1)
                            cur.dp[i][1]++;
                        if (cur.m[i][1]) {
                            cur.dp[i][1]++;
                        }
                        cur.max = Math.max(cur.max, cur.dp[i][1]);
                        if (i == 1) continue;
                        if (cur.pre != null && cur.pre.max == 1)
                            cur.dp[1][i]++;
                        if (cur.m[1][i]) {
                            cur.dp[1][i]++;
                        }
                        cur.max = Math.max(cur.max, cur.dp[1][i]);
                    }
                    return;
                }
                int g = cur.t - pre.t;
                if (g >= 4) {
                    for (int i = 0; i < 3; ++i) {
                        for (int j = 0; j < 3; ++j) {
                            cur.dp[i][j] = Math.max(cur.dp[i][j], pre.max + (cur.m[i][j] ? 1 : 0));
                            cur.max = Math.max(cur.max, cur.dp[i][j]);
                        }
                    }
                    return;
                }
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        int c = 0;
                        while (c < g) {
                            c++;
                            for (int[] d : dir[c]) {
                                int x = i + d[0], y = j + d[1];
                                if (!check(x, y)) continue;
                                cur.dp[i][j] = Math.max(cur.dp[i][j], pre.dp[x][y] + (cur.m[i][j] ? 1 : 0));
                            }
                        }
                        cur.max = Math.max(cur.max, cur.dp[i][j]);
                    }
                }
            }

            boolean check(int x, int y) {
                if (x < 0 || x >= 3) return false;
                if (y < 0 || y >= 3) return false;
                return true;
            }

            Helper[] toArr(Helper head) {
                head = head.next;
                ArrayList<Helper> arrayList = new ArrayList<>();
                while (head != null) {
                    arrayList.add(head);
                    head = head.next;
                }
                return arrayList.toArray(new Helper[0]);
            }
        }

        static class SolutionSpring_2 {
            public int conveyorBelt(String[] matrix, int[] start, int[] end) {
                // bfs?
//                int ans = Integer.MAX_VALUE;
                int[] dtoi = new int[128];
                dtoi['<'] = 2;
                dtoi['>'] = 0;
                dtoi['^'] = 3;
                dtoi['v'] = 1;
                int[] itod = new int[]{0, 1, 0, -1, 0};
                int lenX = matrix.length, lenY = matrix[0].length();
                char[][] c = new char[lenX][0];
                Helper[][] v = new Helper[lenX][lenY];
                // 代表几次转换 不关心到达次数
                for (int i = 0; i < lenX; ++i) {
                    c[i] = matrix[i].toCharArray();
                    for (int j = 0; j < lenY; ++j) {
                        v[i][j] = new Helper(i, j, 1000);
                    }
                }
                // 0: x, 1: y, 2:转换次数-废弃
                LinkedList<Helper> list = new LinkedList<>();
                list.add(v[start[0]][start[1]]);
                v[start[0]][start[1]].n = 0;
                while (!list.isEmpty()) {
                    HashSet<Helper> next = new HashSet<>();
                    while (!list.isEmpty()) {
                        Helper cur = list.poll();
                        int x = cur.x;
                        int y = cur.y;
                        int n = cur.n;
                        for (int i = 0; i < 4; ++i) {
                            int nx = x + itod[i];
                            int ny = y + itod[i + 1];
                            if (!check(nx, ny, lenX, lenY)) continue;
                            int nn = n + (dtoi[c[x][y]] == i ? 0 : 1);
                            if (nn >= v[nx][ny].n) continue;
                            v[nx][ny].n = nn;
                            next.add(v[nx][ny]);
                        }
                    }
                    list = new LinkedList<>(next);
                }
                return v[end[0]][end[1]].n;
            }

            boolean check(int x, int y, int ex, int ey) {
                if (x < 0 || x >= ex) return false;
                if (y < 0 || y >= ey) return false;
                return true;
            }

            private class Helper {
                int x, y, n;

                Helper(int x, int y, int n) {
                    this.x = x;
                    this.y = y;
                    this.n = n;
                }
            }
        }
    }

    static public class Solution_22_3_27 {
        public void main(String[] args) {
            this.kthPalindrome(new int[]{16017953, 16, 223505660, 78, 123699557, 346244579, 2}, 8);
        }

        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
            for (int i : nums1) set1.add(i);
            for (int i : nums2) set2.add(i);
            List<List<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> ans1 = new ArrayList<>();
            ArrayList<Integer> ans2 = new ArrayList<>();
            HashSet<Integer> set3 = new HashSet<>(), set4 = new HashSet<>();
            for (int i : nums1) {
                if (!set2.contains(i) && !set3.contains(i)) {
                    ans1.add(i);
                    set3.add(i);
                }
            }
            for (int i : nums2) {
                if (!set1.contains(i) && !set4.contains(i)) {
                    ans2.add(i);
                    set4.add(i);
                }
            }
            ans.add(ans1);
            ans.add(ans2);
            return ans;
        }

        public long[] kthPalindrome(int[] queries, int intLength) {
            int len = queries.length;
            ;
            long[] res = new long[len];
            for (int i = 0; i < len; ++i) {
                res[i] = struct(intLength, queries[i]);
            }
            return res;
        }

        long struct(int base, int lever) {
            String s = String.valueOf(lever);
            int[] ans = new int[base];
            int b1 = (int) Math.pow(10, (base + 1) / 2 - 1);

            int b = b1 + lever - 1;
            if (String.valueOf(b).length() > base) return -1;
            long res = b * (long) Math.pow(10, (base) / 2);
            if (base % 2 == 1) b = b / 10;

            long t = 0;
            while (b > 0) {
                t = t * 10 + b % 10;
                b /= 10;
            }
            res += t;
            if (String.valueOf(res).length() > base) res = -1;
            return res;
        }

        public int minDeletion(int[] nums) {
            LinkedList<Integer> list1 = new LinkedList<>();
            LinkedList<Integer> list2 = new LinkedList<>();
            int len = nums.length;
            int l = 0, r = 1;
            int res = 0;
            while (r < len) {
                if (nums[l] == nums[r]) {
                    r++;
                    res++;
                } else {
                    l = r + 1;
                    r += 2;
                }
            }
            if (l <= len - 1) res++;
            return res;
        }

    }

    class Solution_22_3_13 {
        public static void main() {
            Soulution_22_3_13_4 soulution_22_3_13_4 = new Soulution_22_3_13_4();
            soulution_22_3_13_4.minimumWeight(6, new int[][]{{0, 2, 2}, {0, 5, 6}, {1, 0, 3}, {1, 4, 5}, {2, 1, 1}, {2, 3, 3}, {2, 3, 4}, {3, 4, 2}, {4, 5, 1}}, 0, 1, 5);
        }

        class Soulution_22_3_13_1 {
            public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
                TreeSet<Integer> set = new TreeSet<>();
                int len = nums.length;
                for (int i = 0; i < len; ++i) {
                    if (nums[i] == key) {
                        for (int j = Math.max(0, i - k); j <= Math.min(len, i + k); ++j) set.add(j);
                    }
                }
                return new ArrayList<>(set);
            }
        }

        class Soulution_22_3_13_2 {
            public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
                int[][] map = new int[n][n];
                for (int[] i : dig) {
                    map[i[0]][i[1]] = 1;
                }
                int res = 0;
                for (int[] i : artifacts) {
                    if (check(map, i[0], i[1], i[2], i[3])) res++;
                }
                return res;
            }

            boolean check(int[][] map, int l, int t, int r, int b) {

                for (int i = l; i <= r; ++i) {
                    for (int j = t; j <= b; ++j) {
                        if (map[i][j] == 0) return false;
                    }
                }
                return true;


            }
        }

        static class Soulution_22_3_13_3 {
            public int maximumTop(int[] nums, int k) {
                if (k == 0) return nums[0];
                int len = nums.length;
                if (len == 1) {
                    if (k % 2 == 1) return -1;
                    else return nums[0];
                }

                int max = nums[0];
                int maxidx = 0;


                int[] maxs = new int[len];
//                Arrays.fill(maxs, Integer.MIN_VALUE);
                PriorityQueue<Integer> que = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
                maxs[0] = nums[0];
                que.add(nums[0]);
                for (int i = 1; i < Math.min(len, k); ++i) {
                    maxs[i] = Math.max(maxs[i - 1], nums[i]);
                    que.add(nums[i]);
                    if (maxs[i] > max) {
                        max = maxs[i];
                        maxidx = i;
                    }
                }
                if (maxidx == k - 1) {
                    que.poll();
                    if (k < len) que.add(nums[k]);
                    return que.poll();
                }
                if (k < len && nums[k] > max) return nums[k];
                if (k == 1) return nums[1];
                if (k == 2) {
                    if (len == 2) return Math.max(nums[0], nums[1]);
                    else return Math.max(nums[2], nums[0]);
                }
                if (k >= 3) return max;

                if ((k - maxidx) % 2 == 1) {
                    que.poll();
                    if (que.isEmpty()) return nums[k];
                }
                return que.poll();

            }
        }

        static class Soulution_22_3_13_4 {
            boolean[] v;
            boolean f = false;
            HashMap<Integer, Integer>[] map;
            long[] res = new long[]{Long.MAX_VALUE, Long.MAX_VALUE};
            long[] vals;

            public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
                v = new boolean[n];
                map = new HashMap[n];
                for (int[] i : edges) {
                    if (i[0] == i[1]) continue;
                    if (map[i[0]] == null) map[i[0]] = new HashMap<>();
                    int now = map[i[0]].getOrDefault(i[1], Integer.MAX_VALUE);
                    map[i[0]].put(i[1], Math.min(now, i[2]));
                }
                vals = new long[n];
                Arrays.fill(vals, Long.MAX_VALUE);
                out("in: ", src1, '\n');
                dfs(src1, 0, dest, 0);
                Arrays.fill(vals, Long.MAX_VALUE);
                dfs(src2, 0, dest, 0);
                if (res[0] == Long.MAX_VALUE || res[1] == Long.MAX_VALUE) return -1;
                return res[0] + res[1];
            }

            void dfs(int node, int val, int tar, int mod) {
                if (v[node]) return;
                if (res[mod] <= val) return;
                if (vals[node] <= val) return;
                if (node == tar) {
                    res[mod] = val;
                    return;
                }
                vals[node] = val;
                v[node] = true;
                for (Map.Entry<Integer, Integer> i : map[node].entrySet()) {
                    out("in: ", i.getKey(), '\n');
                    dfs(i.getKey(), val + i.getValue(), tar, mod);
                    out("out: ", i.getKey(), '\n');
                }
                v[node] = false;
            }

            void out(Object... msg) {
                for (Object i : msg) System.out.print(i.toString());
            }
        }
    }
}

