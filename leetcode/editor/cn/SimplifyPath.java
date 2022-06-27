package leetcode.editor.cn;
public class SimplifyPath{
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        System.out.print(solution.simplifyPath("/home//foo/"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
        StringBuilder res=new StringBuilder().append('/');
        StringBuilder temp=new StringBuilder();
        String ts;
        char[] c=path.toCharArray();
        int len=c.length,i=1;
        while(i<len){
            temp=new StringBuilder();
            while(i<len&&c[i]!='/'){
                temp.append(c[i]);
                i++;
            }
            ts=temp.toString();
            if(ts.equals(".")){
//                res=new StringBuilder().append('/');
            }
            else if(ts.equals("..")){
                while (res.charAt(res.length()-1)!='/'){
                    res.deleteCharAt(res.length()-1);
                }
                if(res.length()>1)res.deleteCharAt(res.length()-1);
            }
            else if(ts.length()>0){
                if(res.length()!=1){
                    res.append("/").append(ts);
                }
                else{
                    res.append(ts);
                }
            }
            i++;
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}