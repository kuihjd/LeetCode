//给你一个字符串 num ，该字符串表示一个大整数。另给你一个长度为 10 且 下标从 0 开始 的整数数组 change ，该数组将 0-9 中的每个数字映
//射到另一个数字。更规范的说法是，数字 d 映射为数字 change[d] 。 
//
// 你可以选择 突变 num 的任一子字符串。突变 子字符串意味着将每位数字 num[i] 替换为该数字在 change 中的映射（也就是说，将 num[i]
// 替换为 change[num[i]]）。 
//
// 请你找出在对 num 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 最大整数 ，并用字符串表示返回。 
//
// 子字符串 是字符串中的一个连续序列。 
//
// 
//
// 示例 1： 
//
// 输入：num = "132", change = [9,8,5,0,3,6,4,2,6,8]
//输出："832"
//解释：替换子字符串 "1"：
//- 1 映射为 change[1] = 8 。
//因此 "132" 变为 "832" 。
//"832" 是可以构造的最大整数，所以返回它的字符串表示。
// 
//
// 示例 2： 
//
// 输入：num = "021", change = [9,4,3,5,7,2,1,9,0,6]
//输出："934"
//解释：替换子字符串 "021"：
//- 0 映射为 change[0] = 9 。
//- 2 映射为 change[2] = 3 。
//- 1 映射为 change[1] = 4 。
//因此，"021" 变为 "934" 。
//"934" 是可以构造的最大整数，所以返回它的字符串表示。 
// 
//
// 示例 3： 
//
// 输入：num = "5", change = [1,4,7,5,3,2,5,6,9,4]
//输出："5"
//解释："5" 已经是可以构造的最大整数，所以返回它的字符串表示。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 105 
// num 仅由数字 0-9 组成 
// change.length == 10 
// 0 <= change[d] <= 9 
// 
// 👍 0 👎 0

package leetcode.editor.cn;
//Java：子字符串突变后可能得到的最大整数
public class LargestNumberAfterMutatingSubstring{
    public static void main(String[] args) {
        Solution solution = new LargestNumberAfterMutatingSubstring().new Solution();
        solution.maximumNumber("132",new int[]{9,8,5,0,3,6,4,2,6,8});
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumNumber(String num, int[] change) {
            char[] c=num.toCharArray();
            for(int i=0;i<c.length;++i){
                if(c[i]-'0'<change[c[i]-'0']){
                    while(i<c.length&&c[i]-'0'<change[c[i]-'0']){
                        c[i]= (char) (change[c[i]-'0']+'0');
                        ++i;
                    }
                    return new String(c);
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}