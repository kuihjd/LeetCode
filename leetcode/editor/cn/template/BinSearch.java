package leetcode.editor.cn.template;

// 二分查找
public class BinSearch {
    int bSearch_1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) r = mid;    // check()判断mid是否满足性质
            else l = mid + 1;
        }
        return l;
    }

    // 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用：
    int bSearch_2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
    // 浮点数
    double bSearch_3(double l, double r)
    {
        final double eps = 1e-6;   // eps 表示精度，取决于题目对精度的要求
        while (r - l > eps)
        {
            double mid = (l + r) / 2;
            if (check(mid)) r = mid;
            else l = mid;
        }
        return l;
    }

    boolean check(Number n) {
        return true;
    }
}
