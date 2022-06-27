package leetcode.editor.cn;

import java.util.*;

public class PushDominoes{
    public static void main(String[] args) {
        Solution solution = new PushDominoes().new Solution();
        System.out.printf(solution.pushDominoes(".L.R...LR..L.."));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
//        List<Integer> arr = new PriorityQueue<>();


        Queue<Integer> que = new LinkedList<>();
        char[] c = dominoes.toCharArray();
        int len = c.length;
        for(int i = 0; i < len; ++i){
            if(c[i] != '.') que.add(i);
        }
        while(!que.isEmpty()){
            int n = que.size();
            while(n > 0){
                n--;
                int l = que.poll();
                if(c[l] == '.') continue;
                if(c[l] == 'A') c[l] = 'L';
                if(c[l] == 'B') c[l] = 'R';
                if(c[l] == 'L'){
                    if(l == 0) continue;
                    if(c[l - 1] == '.') {
                        c[l - 1] = 'A';
                        que.add(l - 1);
                    }
                    if(c[l - 1] == 'B') {
                        c[l - 1] = '.';
                    }
                }
                if(c[l] == 'R'){
                    if(l == len - 1) continue;
                    if(c[l + 1] == '.') {
                        c[l + 1] = 'B';
                        que.add(l + 1);
                    }
                }
            }
        }
        return String.valueOf(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}