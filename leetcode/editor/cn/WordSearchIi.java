package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        solution.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},new String[]{"oath","pea","eat","rain"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char[][] board=null;
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res=new ArrayList<String>();
            this.board=board;
            ArrayList<Integer[]>[] head = new ArrayList[26];
            for(int i=0;i<26;++i) head[i]=new ArrayList<Integer[]>();
            int lenX=board.length;
            int lenY=board[0].length;
            boolean[][] visit=new boolean[lenX][lenY];
            for(int i=0;i<lenX;++i){
                visit[i]=new boolean[lenY];
                for(int j=0;j<lenY;++j){
                    head[board[i][j]-'a'].add(new Integer[]{i,j});
                }
            }
            for(String i:words){
                char[] c=i.toCharArray();
                for(Integer[] j:head[c[0]-'a']){
                    if(contain(visit,0,c,j[0],j[1])){
                        res.add(i);
                        break;
                    }
                }
            }

            return res;
        }
        boolean contain(boolean[][] visit,int index,char[] word,int x,int y){
            if(index== word.length) return true;
            if(x<0||x==visit.length)return false;
            if(y<0||y==visit[0].length)return false;
            if(board[x][y]!=word[index])return false;
            if(visit[x][y]) return false;
            visit[x][y]=true;
            for(int[] i:dirs){
                if(contain(visit,index+1,word,x+i[0],y+i[1])){
                    visit[x][y]=false;
                    return true;
                }
            }
            visit[x][y]=false;
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}