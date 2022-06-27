//存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。 
//
// 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui
// 和 vi 在 nums 中相邻。 
//
// 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i]
//, nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。 
//
// 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：adjacentPairs = [[2,1],[3,4],[3,2]]
//输出：[1,2,3,4]
//解释：数组的所有相邻元素对都在 adjacentPairs 中。
//特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
// 
//
// 示例 2： 
//
// 
//输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
//输出：[-2,4,1,-3]
//解释：数组中可能存在负数。
//另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
// 
//
// 示例 3： 
//
// 
//输入：adjacentPairs = [[100000,-100000]]
//输出：[100000,-100000]
// 
//
// 
//
// 提示： 
//
// 
// nums.length == n 
// adjacentPairs.length == n - 1 
// adjacentPairs[i].length == 2 
// 2 <= n <= 105 
// -105 <= nums[i], ui, vi <= 105 
// 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums 
// 
// Related Topics 数组 哈希表 
// 👍 30 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：从相邻元素对还原数组
public class RestoreTheArrayFromAdjacentPairs{
    public static void main(String[] args) {
        Solution solution = new RestoreTheArrayFromAdjacentPairs().new Solution();
        // TO TEST
        solution.restoreArray(new int[][]{{4,-10},{-1,3},{4,-3},{-3,3}});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            int len=adjacentPairs.length;
            HashMap<Integer,Integer> only=new HashMap<>();
            int[] fast=new int[200002];
            int[] last=new int[200002];
            int[] res=new int[len+1];
            only.keySet();
            for(int[] i:adjacentPairs){
                if(only.containsKey(i[0])){
                    only.remove(i[0]);
                    last[i[0]+100000]=i[1];
                }
                else{
                    only.put(i[0],i[1]);
                    fast[i[0]+100000]=i[1];
                }
                if(only.containsKey(i[1])){
                    only.remove(i[1]);
                    last[i[1]+100000]=i[0];
                }
                else{
                    only.put(i[1],i[0]);
                    fast[i[1]+100000]=i[0];
                }
            }
            for(int i:only.keySet()){
                res[0]=i;
            }
            int i=2;
            res[1]=fast[res[0]+100000];
            while(i<len){
                res[i]=last[res[i-1]+100000];
                if(res[i-2]==res[i])
                    res[i]=fast[res[i-1]+100000];
                i++;
                res[i]=fast[res[i-1]+100000];
                if(res[i-2]==res[i])
                    res[i]=last[res[i-1]+100000];
                i++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}