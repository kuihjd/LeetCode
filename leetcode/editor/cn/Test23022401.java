package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Scanner;

public class Test23022401 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.next();
        }
        // 50随便遍历
        boolean[] map = new boolean[n];
        int[][] count = new int[n][256];
        for (int i = 0; i < arr.length; i++) {
            for (char j : arr[i].toCharArray()) {
                count[i][j]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (map[i]) continue;
            map[i] = true;
            ans++;
            for (int j = i + 1; j < n; ++j) {
                if (check(count[i], count[j])) {
                    map[j] = true;
                }
            }
        }
        System.out.println(ans);
    }

    static boolean check(int[] c1, int[] c2) {
        for (int i = 0; i < 256; ++i) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}
