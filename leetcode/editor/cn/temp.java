package leetcode.editor.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class StringUtils {
    public static boolean allIsNotNull(String... s) {
        if (s == null) return false;
        // TODO

        for (String i : s) {
            if (i == null) return false;
        }

        return true;
    }

    public static boolean allIsNotEmpty(String... s) {
        if (s == null) return false;
        // TODO
        for (String i : s) {
            if (i == null || i.equals("")) return false;
        }
        return true;
    }
}

public class temp {
    public static void main(String[] args) throws IOException {
//        Semaphore s1 = new Semaphore(1), s2 = new Semaphore(0);
//        Resource r = new temp().new Resource();
//        new temp().new Foo(s1, s2, r,"p1").start();
//        new temp().new Foo(s2, s1, r,"p2").start();
//        Solution_22_1_22_1 solution_22_1_22_1=new temp().new Solution_22_1_22_1();
//        solution_22_1_22_1.highestRankedKItems(new int[][]{{0},{2},{0}},new int[]{2,2},new int[]{1,0},1);
//        Solution_22_1_23_1 solution=new temp().new Solution_22_1_23_1();
//        Solution_22_1_23_2 solution=new temp().new Solution_22_1_23_1();
//        Solution_22_1_23_3 solution=new temp().new Solution_22_1_23_1();
//        Solution_1_30_3 solution=new temp().new Solution_1_30_3();
//        solution.subStrHash("xxterzixjqrghqyeketqeynekvqhc",15, 94, 4, 16);
        System.out.println(StringUtils.allIsNotEmpty());
        System.out.println(StringUtils.allIsNotNull(null));


    }

    class Solution_1_30_4 {
        public int[] groupStrings(String[] words) {
            Set<Integer> set = new HashSet<>();
            int now = 0;
            for (String i : words) {
                now = 0;
                for (char j : i.toCharArray()) {
                    now |= 1 << (j - 'a');
                }
                set.add(now);
            }
            Integer[] nums = set.toArray(new Integer[0]);
            int cnt = 0, max = 0;
            for (int i : nums) {
                now = 0;
                for (int j = 0; j < 26; ++j) {
                    if ((i & (1 << j)) > 0 && set.contains(i - (int) Math.pow(2, j))) now++;
                    else if ((i & (1 << j)) == 0 && set.contains(i + (int) Math.pow(2, j))) now++;
                }
                for (int j = 0; j < 26; ++j) {
                    if ((i & (1 << j)) > 0) {//j??????1
                        i -= Math.pow(2, j);
                        for (int k = 0; k < 26; ++k) {
                            if ((i & (1 << k)) == 0) {//k??????0
                                if (set.contains((i ^ (1 << j) ^ (1 << k)))) now++;
                            }
                        }
                        i += Math.pow(2, j);
                    }
                }

            }
            return new int[]{0};
        }


    }

    class Solution_1_30_3 {
        int helper(String s, int power, int modulo, int k, int hashValue) {
            int ans = 0;
            for (int i = 0; i < k; ++i) {
                ans += (Math.pow(power, i) * (s.charAt(i) - 'a' + 1)) % modulo;
                ans %= modulo;
            }
            return ans;
        }

        public String subStrHash(String s, int power, int modulo, int k, int hashValue) {

            long now = 0;
            char[] c = s.toCharArray();
            long p = 1;
            for (int i = 0; i < k; ++i) {
                now += (p * (c[i] - 'a' + 1)) % modulo;
                p *= power;
                p %= modulo;
                now %= modulo;
            }
            System.out.println("p=" + p);
            if (now == hashValue) return s.substring(0, k);
            for (int i = k; i < c.length; ++i) {
                now -= c[i - k] - 'a' + 1;
                if (now < 0) now += modulo;
                now /= power;
                now += (p * (c[i] - 'a' + 1)) % modulo;
                now %= modulo;
                System.out.println(now);
                if (now == hashValue) return s.substring(i - k, i);
            }
            return "";
        }
    }

    class lg_1_29 {
        public static void main(String[] args) throws IOException {
            a();
        }

        public static void a() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] sarr = in.readLine().split(" ");
            int n = Integer.parseInt(sarr[0]), m = Integer.parseInt(sarr[1]), a = Integer.parseInt(sarr[2]);
            sarr = in.readLine().split(" ");
            long cnt = a;
            long now = 0;
            long max = Integer.MIN_VALUE;
            //???????????????????????????
            //m - 1???a - ai????????????,a < ai ??? 0

            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = Integer.parseInt(sarr[i]);
                cnt += nums[i];
            }
            if (m <= 1) {
                System.out.print(cnt);
                return;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
            PriorityQueue<Integer> del = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
            sarr = null;
            for (int i = 0; i < m - 1; ++i) {
                queue.add(nums[i]);
            }
            for (int i = 0; i <= m - 1; ++i) {
                now += Math.max(queue.peek() - nums[i], 0);
            }
            max = now;
            for (int i = m - 1; i < n - m + 1; ++i) {
                now -= Math.max(a - queue.peek(), 0);
                now += Math.max(a - nums[i], 0);
                max = Math.max(max, now);
            }
            System.out.print(max + cnt);
        }

        void del(PriorityQueue<Integer> queue, PriorityQueue<Integer> del) {
            while (!queue.isEmpty() && !del.isEmpty() && queue.peek().equals(del.peek())) {
                queue.poll();
                del.poll();
            }
        }
    }


    class Solution_22_1_23_1 {
        public int countElements(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = -999999, min = 999999;
            for (int i : nums) {
                if (!map.containsKey(i)) map.put(i, 0);
                map.put(i, map.get(i) + 1);
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            return Math.max(0, nums.length - map.get(max) - map.get(min));
        }
    }

    class Solution_22_1_23_2 {
        public int[] rearrangeArray(int[] nums) {
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            for (int i : nums) {
                if (i > 0) q1.add(i);
                else q2.add(i);
            }
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                if (i % 2 == 0) ans[i] = q1.poll();
                else ans[i] = q2.poll();
            }
            return ans;
        }
    }

    class Solution_22_1_23_3 {
        public List<Integer> findLonely(int[] nums) {
            int[] map = new int[10000001];
            int max = -999999, min = 999999;
            for (int i : nums) {
                map[i]++;
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = min; i <= max; ++i) {
                if (map[i] != 1) continue;
                if (i - 1 >= 0 && map[i - 1] != 0) continue;
                if (i + 1 < 10000000 & map[i + 1] != 0) continue;
                ans.add(i);
            }
            return ans;
        }
    }

    class Solution_22_1_23_4 {
        public int maximumGood(int[][] statements) {
            int n = statements.length;
            int tar = (int) Math.pow(2, n) - 1;
            int ans = -1;
            for (int i = tar; i >= 0; --i) {
//                int[] v=new int[20];
//                for(int j=0;j<20;++j){
//                    v[j]=2;
//                }
                boolean flag = true;
                for (int j = 0; j < n; ++j) {
                    if ((1 << j & i) == 0) continue;//???0?????????,?????????
                    for (int k = 0; k < n; ++k) {
                        if (statements[j][k] == 2) continue;
                        if (statements[j][k] == 0 && (i & 1 << k) > 0) {
                            flag = false;
                            break;//??????????????????????????????
                        }
                        if (statements[j][k] == 1 && (i & 1 << k) == 0) {
                            flag = false;
                            break;//??????????????????????????????
                        }
                    }
                    if (!flag) break;
                }
                if (flag) ans = Math.max(ans, Integer.bitCount(i));
            }
            return ans;
        }
    }

    class Solution_22_1_22_1 {
        public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
            //0=??????,1=??????,2=x,3=y
            int[] rx = {0, 0, 1, -1};
            int[] ry = {1, -1, 0, 0};
            Set<Integer> set = new HashSet<>();
            PriorityQueue<Integer[]> que = new PriorityQueue<Integer[]>((v1, v2) -> {
                for (int i = 0; i < 4; ++i) {
                    if (!Objects.equals(v1[i], v2[i])) return v1[i] - v2[i];
                }
                return 0;
            });
            List<List<Integer>> ans = new ArrayList<>();
            Queue<Integer[]> bque = new LinkedList<>();
            bque.add(new Integer[]{start[0], start[1]});
            int len = 1;
            int r = 0;
            while (!bque.isEmpty()) {
                while (len > 0) {
                    len--;
                    Integer[] now = bque.poll();

                    int pric = grid[now[0]][now[1]];
                    for (int i = 0; i < 4; ++i) {
                        if (now[0] + rx[i] < 0 || now[0] + rx[i] >= grid.length) continue;
                        if (now[1] + ry[i] < 0 || now[1] + ry[i] >= grid[0].length) continue;
                        if (grid[now[0] + rx[i]][now[1] + ry[i]] == 0) continue;
                        if (set.add(Arrays.hashCode(new int[]{now[0] + rx[i], now[1] + ry[i]})))
                            bque.add(new Integer[]{now[0] + rx[i], now[1] + ry[i]});
                    }
                    grid[now[0]][now[1]] = 0;
                    if (pric < pricing[0] || pric > pricing[1]) continue;
                    que.add(new Integer[]{r, pric, now[0], now[1]});
                }
                r++;
                len = bque.size();
            }
            len = Math.min(que.size(), k);
            while (len > 0) {
                len--;
                Integer[] now = que.poll();
                List<Integer> t = new ArrayList<>();
                t.add(now[2]);
                t.add(now[3]);
                ans.add(t);
            }
            return ans;
        }
    }


    class Resource {
        int resource = 0;

        int get() {
            return resource;
        }

        void set(int num) {
            resource = num;
        }
    }

    class Foo extends Thread {
        Resource resource;
        Semaphore s1;
        Semaphore s2;

        public Foo(Semaphore s1, Semaphore s2, Resource resource, String name) {
            this.setName(name);
            this.s1 = s1;
            this.s2 = s2;
            this.resource = resource;
        }

        public void run() {
            for (int i = 0; i < 100; ++i) {
//                try {
//                    s1.acquire();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(this.getName() + ":\t" + resource.get());
                resource.set(i);
//                s2.release();
            }
        }
    }

    class Solution {
        int[][] map;
        int m, n;
        int[] homePos;
        int[] colCosts, rowCosts;

        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            this.homePos = homePos;
            this.rowCosts = rowCosts;
            this.colCosts = colCosts;
            m = rowCosts.length;
            n = colCosts.length;
            map = new int[rowCosts.length][colCosts.length];
            for (int[] i : map) Arrays.fill(i, Integer.MAX_VALUE);
            dfs(startPos[0], startPos[1], 5, 0);
            return map[homePos[0]][homePos[1]];
        }

        void dfs(int x, int y, int type, int cost) {
            if (x < 0 || x == m) return;
            if (y < 0 || y == n) return;
            int val = 0;
            if (type <= 2) {
                val = rowCosts[y];
            } else if (type <= 4) {
                val = colCosts[x];
            }
            cost += val;
            if (cost >= map[x][y]) return;
            map[x][y] = cost + val;
            if (x == homePos[0] && y == homePos[1]) return;
            dfs(x + 1, y, 4, cost);
            dfs(x - 1, y, 3, cost);
            dfs(x, y + 1, 2, cost);
            dfs(x, y - 1, 1, cost);
        }
    }

    //    class Solution {
//        char[] words=new char[]{}
//        public long kMirror(int k, int n) {
//
//        }
//
//    }
    class RangeFreqQuery {


        Map<Integer, Integer>[] maps;

        public RangeFreqQuery(int[] arr) {
            maps = new Map[arr.length];
            maps[0] = new HashMap<>();
            maps[0].put(arr[0], 1);
            for (int i = 1; i < arr.length; ++i) {
                maps[i] = new HashMap<>();
                maps[i].putAll(maps[i - 1]);
                maps[i].put(arr[i], maps[i].getOrDefault(arr[i], 0) + 1);
            }
        }

        public int query(int left, int right, int value) {
            return maps[right].getOrDefault(value, 0) - maps[left].getOrDefault(value, 0);
        }
    }

    public class SegmentTree {
        Node root;

        /*
         * ????????????
         * ?????????????????????
         * */
        SegmentTree(int left, int right) {
            root = new Node(left, right);
            build(root);
        }

        /*
         * ????????????
         * ?????????????????????
         * */
        private void build(Node root) {
            int left = root.left;
            int right = root.right;
            //root?????????????????????
            if (right - left > 1) {
                int mid = (left + right) >> 1;////?????????????????????
                Node leftNode = new Node(left, mid);
                Node rightNode = new Node(mid, right);
                root.leftChild = leftNode;
                root.rightChild = rightNode;
//        ???????????????????????????
                build(leftNode);
                build(rightNode);
            }
        }

        /*
         * ??????????????????[c,d]???????????????
         * c????????????
         * d????????????
         * root ???????????????????????????
         * */
        public void insert(int c, int d, int val) {
            insert(c, d, root, val);
        }

        /*
         * ??????????????????[c,d]???????????????
         * c????????????
         * d????????????
         * root ???????????????????????????
         * */
        private void insert(int c, int d, Node node, int val) {

            if (node == null || c < node.left || d > node.right) {
                System.out.println("????????????????????????!" + "c:" + c + " " + "d:" + d);

                System.out.println("root:" + node.left + " " + node.right);

                return;
            }
            if (node.left == c && node.right == d) {
                node.count++;
                node.cover = true;
                node.map.put(val, node.map.getOrDefault(val, 0) + 1);
                return;
            }
            int mid = (node.left + node.right) >> 1;
            if (d <= mid) {
                insert(c, d, node.leftChild, val);
            } else if (c >= mid)
                insert(c, d, node.rightChild, val);
            else {
                insert(c, mid, node.leftChild, val);
                insert(mid, d, node.rightChild, val);
            }
        }

        /*
         * ??????????????????[c,d]???????????????
         * c:????????????????????????
         *d:????????????????????????
         * root:???????????????????????????
         * */
        public void delete(int c, int d) {
            delete(c, d, root);
        }

        /*
         * ??????????????????[c,d]
         * c:????????????????????????
         *d:????????????????????????
         * root:???????????????????????????
         * */
        private void delete(int c, int d, Node node) {
            if (node == null || c < node.left || d > node.right) {
                System.out.println("????????????????????????!");
                return;
            }
            if (c == node.left && d == node.right) {
                node.count--;
                if (node.count == 0)
                    node.cover = false;
                return;
            }
            int mid = (node.left + node.right) >> 1;
            if (d <= mid)
                delete(c, d, node.leftChild);
            else if (c >= mid)
                delete(c, d, node.rightChild);
            else {
                delete(c, mid, node.leftChild);
                delete(mid, d, node.rightChild);//????????????mid+1??????????????????1,10?????????????????????????????????1,5?????????5,10???
            }
        }

        /*
         * ????????????
         * ????????????
         * */
        public void preOrder() {
            preOrder(root);
        }

        /*
         * ????????????
         * ????????????
         * */
        private void preOrder(Node root) {
//        ????????????
            if (root.right - root.left == 1) {
                System.out.println("[" + root.left + "," + root.right + "]:" + root.count);
            } else if (root.right - root.left > 1) {
                System.out.println("[" + root.left + "," + root.right + "]:" + root.count);
                preOrder(root.leftChild);
                preOrder(root.rightChild);
            }
        }

        /*
         * ????????????
         * ??????????????????cover???true?????????????????????
         * */
        public int Count() {
            return Count(root);
        }

        /*
         * ????????????
         * ??????????????????cover???true?????????????????????
         * */
        private int Count(Node node) {
            if (node.cover)//???????????????????????????????????????
                return node.right - node.left;
            else {
                if (node.right - node.left == 1)
                    return 0;
                else
                    return Count(node.leftChild) + Count(node.rightChild);
            }
        }


        //    ?????????????????????
        class Node {
            int left, right;//??????????????????
            boolean cover;//?????????????????????
            int count;//???????????????????????????????????????????????????????????????????????????????????????0
            Map<Integer, Integer> map = new HashMap<>();
            Node leftChild;
            Node rightChild;

            Node(int left, int right) {
                this.left = left;
                this.right = right;
                count = 0;
                cover = false;
            }
        }
    }

    /**
     * Your RangeFreqQuery object will be instantiated and called as such:
     * RangeFreqQuery obj = new RangeFreqQuery(arr);
     * int param_1 = obj.query(left,right,value);
     */
    class SegementTree {
        static final int N = 100005;
        int[] arr = new int[N];
        int[] tree = new int[N * 4 + 5];

        int query(int node, int l, int r, int x, int y) {
            if (r < x || l > y) {
                return 0;
            }
            if (l >= x && r <= y) {
                return tree[node];
            }
            int mid = (l + r) >> 1;
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            int left_max = query(left_node, l, mid, x, y);
            int right_max = query(right_node, mid + 1, r, x, y);
            return Math.max(left_max, right_max);
        }

        void build(int node, int l, int r) {
            if (l == r) {
                tree[node] = arr[l];
                return;
            }
            int mid = (l + r) >> 1;
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            build(left_node, l, mid);
            build(right_node, mid + 1, r);
            pushup(node);
        }

        void pushup(int node) {
            tree[node] = Math.max(tree[node * 2 + 1], tree[node * 2 + 2]);
        }
    }


}
