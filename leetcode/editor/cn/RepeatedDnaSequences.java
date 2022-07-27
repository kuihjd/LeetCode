package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RepeatedDnaSequences {
    static private int a() {
//        Stack<Integer> stack = new LinkedList<>();
        HashMap<Object, Integer> map = new HashMap<>();
        Hashtable<Integer, Integer> tab = new Hashtable<>();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Integer v = 1;
        map.put("o",1);
        concurrentHashMap.put(v , v);
        concurrentHashMap.get(v);
        map.put(v, v);
        map.remove(v);
        int i = 0;
        try {
            System.out.println(i++);
            return i; //会把return 1;压入栈中,出栈返回return 1，得到结果就是1
        } catch (Exception e) {
            i++;
        } finally {
            i++; //i=2
            return i;//方法会直接return 2结束
        }
//        return -1;
    }

    public static void main(String[] args) {
        while (Integer.parseInt("1") == 1)
            System.out.println(a());
        Solution solution = new RepeatedDnaSequences().new Solution();
        solution.findRepeatedDnaSequences("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            ArrayList<String> res = new ArrayList<>();
            if (s.length() < 10) return res;
            char[] c = s.toCharArray();
            int n = 0;
            for (int i = 0; i < 10; ++i) {
                n <<= 2;
                n |= mapping(c[i]);
            }
            byte[] f = new byte[1048577];
            f[n] = 1;
            for (int i = 10; i < s.length(); ++i) {
                n = (n << 2) & (0xfffff) | mapping(c[i]);
                f[n]++;
                if (f[n] == 2) {
                    res.add(s.substring(i - 9, i + 1));
                }
                if (f[n] == 3) {
                    f[n] = 2;
                }
            }
            return res;
        }

        int mapping(char c) {
            return switch (c) {
                case 'A' -> 0;
                case 'C' -> 1;
                case 'G' -> 2;
                case 'T' -> 3;
                default -> -1;
            };
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}