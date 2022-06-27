package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {

        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            HashMap<String, Integer> cnt = new HashMap<>();
            char[] c = s.toCharArray();
            int m = words[0].length();
            ArrayList<LinkedList<String>> subCnt = new ArrayList<>();
            if (m * words.length > s.length()) return res;
            for (int i = 0; i < m; ++i) {
                subCnt.add(new LinkedList<>());
            }
            for (String i : words) cnt.put(i, cnt.getOrDefault(i, 0) + 1);
            for (int i = 0; i < m; ++i) {
                LinkedList<String> t = subCnt.get(i);
                for (int j = 0; i + m * j + m <= s.length(); ++j) {
                    String sub = subChar(c, i + m * j, i + m * j + m);
                    t.addLast(sub);
                }
            }
            for (int i = 0; i < m; ++i) {
                HashMap<String, Integer> cur = new HashMap<>();
                LinkedList<String> tl = subCnt.get(i);
                LinkedList<String> cl = new LinkedList<>();
                for (int j = 0; j < words.length; ++j) {
                    String t = tl.pollFirst();
                    cl.addLast(t);
                    cur.put(t, cur.getOrDefault(t, 0) + 1);
                }
                int ans = i;
                if (check(cur, cnt)) res.add(ans);
                while (!tl.isEmpty()) {
                    ans += m;
                    String t = tl.pollFirst();
                    cur.put(t, cur.getOrDefault(t, 0) + 1);
                    cl.addLast(t);
                    t = cl.pollFirst();
                    if (cur.get(t).equals(1)) cur.remove(t);
                    else cur.put(t, cur.get(t) - 1);
                    if (check(cur, cnt)) res.add(ans);
                }
            }
            return res;
        }

        String subChar(char[] c, int l, int r) {
            StringBuilder ans = new StringBuilder();
            for (int i = l; i < r; ++i) {
                ans.append(c[i]);
            }
            return ans.toString();
        }

        boolean check(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
            if (map1.size() != map2.size()) return false;
            for (String i : map1.keySet()) if (!map1.get(i).equals(map2.get(i))) return false;
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
