package leetcode.editor.cn;
public class NumberOfWonderfulSubstrings{
    public static void main(String[] args) {
    	
        Solution solution = new NumberOfWonderfulSubstrings().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long wonderfulSubstrings(String word) {
        int[] cnt = new int[1024];
        long res = 0;
        int cur = 0;
        cnt[0] = 1;
        for (char i : word.toCharArray()) {
            cur ^= 1 << i - 'a';
            cnt[cur]++;
            res += cnt[cur];
            for (int j = 0; j < 10; ++j) {
                res += (1 << j) ^ (1 << i - 'a');
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}