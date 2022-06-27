package leetcode.editor.cn;
public class ReconstructOriginalDigitsFromEnglish{
    public static void main(String[] args) {
        Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static char[][] group = new char[][]{"zero".toCharArray(),"one".toCharArray(),"two".toCharArray(),"three".toCharArray(),"four".toCharArray(),"five".toCharArray(),"six".toCharArray(),"seven".toCharArray(),"eight".toCharArray(),"nine".toCharArray()};
    public String originalDigits(String s) {
        StringBuilder res = new StringBuilder();
        int[] cnt =new int[26];
        for(char i:s.toCharArray()){
            cnt[i-'a']++;
        }
        boolean flag=false;
        int min=0;
        int idx=0;
        for(char[] str:group){
            min=Integer.MAX_VALUE;;
            for(char i:str){
                min=Math.min(min,cnt[i-'a']);
            }
            for(char i:str){
                cnt[i-'a']-=min;
            }
            res.append(String.valueOf(idx).repeat(Math.max(0, min)));
            idx++;
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}