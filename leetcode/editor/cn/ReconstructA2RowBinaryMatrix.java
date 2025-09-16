package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReconstructA2RowBinaryMatrix{
    public static void main(String[] args) {
    	
        Solution solution = new ReconstructA2RowBinaryMatrix().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colSum) {
        int sum = 0, count2 = 0;
        for (int j : colSum) {
            sum += j;
            if (j == 2) {
                count2++;
            }
        }
        if (sum != upper + lower || upper < count2 || lower < count2) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> up = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
        res.add(up);
        res.add(low);
        upper -= count2;
        lower -= count2;
        for (int j : colSum) {
            if (j == 2) {
                up.add(1);
                low.add(1);
            } else if (j == 0) {
                up.add(0);
                low.add(0);
            } else {
                if (upper > 0) {
                    up.add(1);
                    low.add(0);
                    upper--;
                } else {
                    up.add(0);
                    low.add(1);
                    lower--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}