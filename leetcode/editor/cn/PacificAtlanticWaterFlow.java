package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        solution.pacificAtlantic(LeetCodeDataStruct.parserTwoIntArray(
                "[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]"
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int offset = 1000;
        static int[] d= new int[]{0, -1, 0, 1, 0};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int lenX = heights.length;
            int lenY = heights[0].length;
            HashSet<Integer> arr = new HashSet<>();
            for (int i = 0; i < lenX; ++i) arr.add(i * offset);
            for (int i = 0; i < lenY; ++i) arr.add(i);
            HashSet<Integer> set1 = bfs(heights, arr);
            arr = new HashSet<>();
            for (int i = 0; i < lenX; ++i) arr.add(i * offset + lenY - 1);
            for (int i = 0; i < lenY; ++i) arr.add(i + (lenX - 1) * offset);
            HashSet<Integer> set2 = bfs(heights, arr);
            set1.retainAll(set2);
            List<List<Integer>> res = new ArrayList<>();
            for (int i : set1) {
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(i / offset);
                cur.add(i % offset);
                res.add(cur);
            }
            res.sort((v1,v2) -> v1.get(0).equals(v2.get(0)) ? v1.get(0) - v2.get(0) : v1.get(1) - v2.get(1));
            return res;
        }

        HashSet<Integer> bfs(int[][] heights, HashSet<Integer> arr) {
            HashSet<Integer> res = new HashSet<>();
            boolean[][] v= new boolean[heights.length][heights[0].length];
            for(int j : arr) {
                int x = j / offset;
                int y = j % offset;
                v[x][y] = true;
            }
            while (!arr.isEmpty()) {
                HashSet<Integer> t = new HashSet<>();
                for(int j : arr){
                    int x = j / offset;
                    int y = j % offset;
                    res.add(j);
                    for(int i = 0; i < 4; ++i){
                        int nx = x + d[i];
                        int ny = y + d[i + 1];
                        if(!check(nx, ny, heights)) continue;
                        if(v[nx][ny]) continue;
                        if(heights[nx][ny] < (heights[x][y])) continue;
                        v[nx][ny] = true;
                        t.add(nx * offset + ny);
                    }
                }
                arr = t;
            }
            return res;
        }

        boolean check(int x, int y, int[][] heights){
            if(x < 0 || x >= heights.length) return false;
            if(y < 0|| y >= heights[0].length) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}