package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

public class UncommonWordsFromTwoSentences{
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String i : s1.split(" ")){
             map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(String i : s2.split(" ")){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<String> ans = new ArrayList<>();
        map.forEach((k, v)->{
            if(v == 1) ans.add(k);
        });
        return ans.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}