package leetcode.editor.cn;
public class FindTheStudentThatWillReplaceTheChalk{
    public static void main(String[] args) {
    	
        Solution solution = new FindTheStudentThatWillReplaceTheChalk().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] cnt = new long[n];
        cnt[0] = chalk[0];
        for (int i = 1; i < n; ++i) {
            cnt[i] = cnt[i - 1] + chalk[i];
        }
        k = (int) (k % cnt[n - 1]);
        return search(cnt, k);
    }

    // 大于k的第一个
    int search(long[] arr, int tar) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= tar) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}