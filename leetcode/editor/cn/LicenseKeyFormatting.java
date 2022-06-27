package leetcode.editor.cn;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        Solution solution = new LicenseKeyFormatting().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String licenseKeyFormatting(String s, int k) {
            char[] c = s.toCharArray();
            int cnt = 0;
            int p = 0;
            for (char i : c) if (i != '-') cnt++;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < cnt % k; ++i) {
                while (c[p] == '-') p++;
                res.append(uCase(c[p++]));
            }
            for (int i = 0; i < cnt / k; ++i) {
                res.append('-');
                for (int j = 0; j < k; j++) {
                    while (c[p] == '-') p++;
                    res.append(uCase(c[p++]));
                }
            }
            if (cnt % k == 0) res.deleteCharAt(0);
            return res.toString();
        }
        char uCase(char c) {
            if (c >= 'a' && c <= 'z') c -= 32;
            return c;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}