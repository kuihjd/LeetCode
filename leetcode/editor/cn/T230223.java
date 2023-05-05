package leetcode.editor.cn;

import java.util.*;

public class T230223 {
    public static void main(String[] args) {
        String s = "fjhgnbfhgj给v会持续jmhngdfbdfxhgjchfikuo;iluyoyitujngw4rtutgqwqrweretyuri;lkjkhjghfgbvfxcvmb,bmbnASCXZBNNVMCRTm";
        HashMap<Character, Integer> count = new HashMap<>();
//        new StringBuilder("45656").deleteCharAt();
        for (char i : s.toCharArray()) {
            if (!count.containsKey(i)) {
                count.put(i, 0);
            }
            count.put(i, count.get(i) + 1);
        }
        HashSet<Integer> set = new HashSet<>(count.values());
        Integer[] array = set.toArray(new Integer[0]);
        Arrays.sort(array);
        ArrayList<Character> ans = new ArrayList<>();
        for (Map.Entry<Character, Integer> i : count.entrySet()) {
            if (i.getValue().equals(array[7])) {
                ans.add(i.getKey());
            }
        }

        ans.forEach(System.out::println);
    }
}
