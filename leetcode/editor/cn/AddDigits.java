package leetcode.editor.cn;

import java.util.*;

public class AddDigits {
    public static void main(String[] args) {
        Solution solution = new AddDigits().new Solution();
        //[]
        //10
        solution.maxInvestment(new int[]{43877,10848,10442,48132,83395,71523,60275,39527}, 345056);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Helper> map = new HashMap<>();
        public int maxInvestment(int[] product, int limit) {
            PriorityQueue<Helper> que = new PriorityQueue<>((v1, v2) -> Math.toIntExact(v2.val - v1.val));
            for(int i : product){
                if(!map.containsKey(i)) {
                    Helper t = new Helper();
                    t.val = i;
                    map.put(i, t);
                    que.add(t);
                }
                map.get(i).cnt++;
            }
            int MOD = (int)1e9 + 7;
            int mod = MOD;
            long res = 0;
            while(limit > 0 && !que.isEmpty()){
                Helper cur = que.poll();
                long next = 0;
                if(!que.isEmpty()) next = que.peek().val;
                if(cur.cnt * (cur.val - next) <= limit){
                    res += ((cur.val + next + 1) % MOD) * (cur.val - next) * cur.cnt / 2;
                    limit -= cur.cnt * (cur.val - next);
                }
                else{
                    long t = limit / cur.cnt;
                    limit -= t * cur.cnt;
                    res += t * (((cur.val + cur.val - t + 1) * cur.cnt) % MOD) / 2;
                    cur.val -= t;
                    res += (limit % MOD) * (cur.val % MOD);
                    limit = 0;
                }
                if(!que.isEmpty()) que.peek().cnt += cur.cnt;
                long res2 = res;
                res %= MOD;
            }
            return (int)res;
        }

        public int maxInvestment2(int[] product, int limit) {
            int res = 0;
            PriorityQueue<Integer> que = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
            for(int i : product){
                que.add(i);
            }
            int MOD = (int)1e9 + 7;
            boolean[] v = new boolean[8];
            int[] vi = new int[]{83395,71523,60275,48132,43877,39527,10848,10442};
            int idx = 0;
            while(limit > 0 && !que.isEmpty()){
                int t = que.poll();
                if(t == vi[idx]) {
                    idx++;
                    System.out.println(res);
                }

                res += t--;
                res %= MOD;

                if(t > 0) que.add(t);
            }

            return res;
        }

    }
    class Helper{
        long val, cnt;
    }

    class DiscountSystem {
        HashMap<Integer, User> users = new HashMap<>();
        HashMap<Integer, Act> getArt = new HashMap<>();
        TreeSet<Act> acts = new TreeSet<>((v1,v2) -> {
            if(v1.discount != v2.discount) return v2.discount - v1.discount;
            return v1.actid - v2.actid;
        });
        public DiscountSystem() {

        }

        public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
            Act act = new Act();
            act.actid = actId;
            act.priceLimit = priceLimit;
            act.discount = discount;
            act.userLimit = userLimit;
            act.number = number;
            acts.add(act);
            getArt.put(actId, act);
        }

        public void removeActivity(int actId) {
            acts.remove(getArt.get(actId));
        }

        public int consume(int userId, int cost) {
            if(!users.containsKey(userId)) users.put(userId, new User(userId));
            User user = users.get(userId);
            for(Act i : acts){
                if(!user.acts.containsKey(i.actid)) user.acts.put(i.actid, 0);
                int cur = user.acts.get(i.actid);
                if(cost > i.priceLimit && cur < i.userLimit && i.number > 0) {
                    i.number--;
                    cost -= i.discount;
                    user.acts.put(i.actid, cur + 1);
                    break;
                }
            }
            return cost;
        }
    }

    class User{
        int id;
        HashMap<Integer, Integer> acts = new HashMap<>();
        User(int id){
            this.id = id;
        }
    }

    class Act{
        int actid;
        int priceLimit;
        int userLimit;
        int number;
        int discount;
    }


//leetcode submit region end(Prohibit modification and deletion)

}