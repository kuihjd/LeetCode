package leetcode.editor.cn;
import java.util.*;
public class RemoveKDigits{
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        ListNode[] t = new ListNode[8];
        ArrayList<ListNode> ta = new ArrayList<>(Arrays.asList(t));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        /*int[] cnt = new int[10];
        char[] c = num.toCharArray();
        for(char i : c){
            cnt[i - '0']++;
        }
        int ts = -cnt[0];
        for(int i : cnt) ts += i;
        if(ts <= k) return " ";
        int tu = 0;
        for(int )*/
        LinkedList<Character> que = new LinkedList<>();

        LinkedList<Character> ans = new LinkedList<>();
        for(char i : num.toCharArray()) que.offerLast(i);
        while(!que.isEmpty()){
            char n = que.pollFirst();
            while(!ans.isEmpty() && ans.peekLast() > n && k-- > 0)ans.pollLast();
            if(ans.isEmpty() && n == '0') continue;//可以被前置的0直接省略
            ans.offerLast(n);
        }
        StringBuilder ansBuilder = new StringBuilder();
        while(k-- > 0) ans.pollLast();
        for(char i : ans) ansBuilder.append(i);
        return ansBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }