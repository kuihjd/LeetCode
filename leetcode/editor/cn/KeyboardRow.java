package leetcode.editor.cn;

import java.util.ArrayList;

public class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] type;
        static {
            type = new int[128];
            for (char i : "qwertyuiop".toCharArray()) {
                type[i] = 1;
                type[i-32] = 1;
            }
            for (char i : "asdfghjkl".toCharArray()) {
                type[i] = 2;
                type[i-2] = 2;
            }
            for (char i : "zxcvbnm".toCharArray()) {
                type[i] = 3;
                type[i-32] = 3;
            }

        }
        public String[] findWords(String[] words) {
            ArrayList<String> res= new ArrayList<>();
            b:for(String i:words){
                char[] c=i.toCharArray();
                int t=type[c[0]];
                for(char j: c){
                    if(type[j]!=t) continue b;
                }
                res.add(i);
            }
            return res.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}