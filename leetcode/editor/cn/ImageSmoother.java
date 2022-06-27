package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ImageSmoother {
    public static void main(String[] args) {
        Solution solution = new ImageSmoother().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            int[] d = new int[]{1, 0, -1, 0, 1, -1, -1, 1, 1};
            int[][] res = new int[img.length][img[0].length];
            for (int i = 0; i < img.length; ++i) {
                for (int j = 0; j < img[0].length; ++j) {
                    int n = 0;
                    int v = 0;
                    for(int k = 0; k < 8; ++k){
                        int r = get(img, i + d[k], j + d[k + 1]);
                        // System.out.printf("%d %d %d\n", i + d[k],  j + d[k + 1], r);
                        if(r >= 0){
                            n++;
                            v += r;
                        }
                    }
                    // System.out.printf("%d %d %d %d\n\n", i, j, n, v);

                    res[i][j] = (v + img[i][j]) / (n + 1);
                }
            }
            return res;
        }

        int get(int[][] img, int x, int y) {
            if (x < 0 || y < 0) return -1;
            if (x >= img.length || y >= img[0].length) return -1;
            return img[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}