package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        solution.countAndSay(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static List<String> res = null;
        static {
            char[] c = null;
            int last=0,cnt=0,index=0;
            StringBuilder sb=null;
            res = new ArrayList<>();
            res.add("1");
            res.add("11");
            res.add("21");
            res.add("1211");
            while (res.size() < 30) {
                c = res.get(res.size() - 1).toCharArray();
                sb=new StringBuilder();
                last=c[0];
                index=0;
                while(index<c.length){
                    cnt=0;
                    while(index<c.length&&c[index]==last){
                        index++;
                        cnt++;
                    }
                    sb.append(cnt);
                    sb.append(last-'0');
                    last=index<c.length?c[index]:0;

                }
                res.add(sb.toString());
            }
        }

        public String countAndSay(int n) {
            return res.get(n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}