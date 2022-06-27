package leetcode.editor.cn;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.*;
public class SearchInRotatedSortedArray{
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        solution.search(new int[]{4,5,6,7,0,1,2}, 0);
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        static StreamTokenizer ins = new StreamTokenizer(in);
        public int search(int[] nums, int target) {
            new PrintWriter(System.out).println("");
            int len = nums.length;
            if(len == 1) return nums[0] == target ? 0 : -1;
            int l = 0, r = len - 1;
            while(l < r){
                int m = (l + r) / 2;
                //分割为[l, m - 1] 和 [m + 1, r]
                if(nums[m] == target) return m;
                if(nums[l] < nums[m]){//左侧一定有序
                    if(nums[m] > target && target >= nums[l]){//左侧有序, 且target小于nums[m]代表答案在左侧, 排除右侧节点
                        r = m - 1;//缩小边界排除原有右侧节点
                    }
                    else{
                        l = m + 1;//缩小边界排除原有左侧节点
                    }
                }
                else{//右侧一定有序
                    if(nums[m] < target && target <= nums[r]){//有侧有序, 且target大于nums[m]代表答案在右侧, 排除左侧节点
                        l = m + 1;//缩小边界排除原有左侧节点
                    }
                    else{
                        r = m - 1;//缩小边界排除原有右侧节点
                    }
                }
            }
            if(nums[l] == target) return l;
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    }