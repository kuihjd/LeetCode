package leetcode.editor.cn;

import java.util.Scanner;

public class Test23022402 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = 200, r = -200, b = 200, t = -200;
        // 左右上下初始化
        for (int i = 0; i < n; ++i) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            l = Math.min(l, x);
            r = Math.max(r, x);
            b = Math.min(b, y);
            t = Math.max(t, y);
        }
        System.out.println((r - l) * (t - b));
    }
}
