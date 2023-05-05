package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
//        Solution solution = new GrayCode().new Solution();
//        solution.grayCode(8);
//        Solution_1_8_4 solution_1_8_4=new GrayCode().new Solution_1_8_4();
//        solution_1_8_4.possibleToStamp(new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}},3,4);
        Solution_1_9_3 solution_1_9_1=new GrayCode().new Solution_1_9_3();
        solution_1_9_1.wordCount(new String[]{"g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"},new String[]{"r","am","jg","umhjo","fov","lujy","b","uz","y"});
        new GrayCode().new Solution_1_9_2().minSwaps(new int[]{0,1,0,1,1,0,0});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> grayCode(int n) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            res.add(1);
            int val = 1;
            int cur = 0;
            int max = (int) Math.pow(2, 16);
            for (int i = 2; i < max; ++i) {
                //01 -> 11
                //11 -> 10
                if (i % 2 == 0) {
                    val |= (1 << (cur));
                } else {
                    val ^= (1 << (cur));
                    cur++;
                }
                res.add(cur);
            }
            return res.subList(0, (int) Math.pow(2, n));
        }
    }

    class Solution_1_8_1 {
        public String capitalizeTitle(String title) {
            int cur = 0;
            char[] c = title.toCharArray();
            char[] res = new char[c.length];
            for (int i = 0; i < c.length; ++i) {
                res[i] = c[i];
                if (res[i] < 'a' && res[i] != ' ') res[i] += 32;
                if (c[i] == ' ') {
                    if (i - cur > 2) {
                        res[cur] -= 32;
                    }
                    cur = i + 1;
                }
            }
            if (c.length - cur > 2) {
                res[cur] -= 32;
            }
            return new String(res);
        }
    }

    class Solution_1_8_2 {
        ArrayList<Integer> al;
        public int pairSum(ListNode head) {
            al=new ArrayList<>();
            dfs(head);
            int max=0;
            for(int i:al){
                max=Math.max(max,i+head.val);
                head=head.next;
            }
            return max;
        }
        void dfs(ListNode head){
            if(head==null) return;
            dfs(head.next);
            al.add(head.val);
        }
    }

    class Solution_1_8_3 {
        public int longestPalindrome(String[] words) {
            int[][] s=new int[26][26];
            int[] l=new int[26];
            int res = 0;
            for(String i:words){
                int a=i.charAt(1)-'a',b=i.charAt(0)-'a';
                if(a!=b){
                    s[i.charAt(1)-'a'][i.charAt(0)-'a']++;
                }
                else{
                    l[a]++;
                }

            }
            for(int i=0;i<26;++i){
                for(int j=0;j<26;++j){
                    if(i==j){
                        res+=l[j]/2;
                    }
                    else{
                        res+=Math.min(s[i][j],s[j][i]);
                    }
                }
            }
                for(int i:l){
                    if (i %2 == 1) {
                        res = 1;
                        break;
                    }
                }

            return res*2;
        }
    }

    class Solution_1_8_4{
        public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
            int m=grid.length,n=grid[0].length;
            int min=0;
            for(int i=0;i<m;++i){

            }
            return true;
        }
    }

    class Solution_1_9_3 {
        public int wordCount(String[] startWords, String[] targetWords) {
            HashSet<Integer> set=new HashSet<>();
            HashSet<Integer> tar=new HashSet<>();
            int res=0;
            for(String i:startWords){
                int t=0;
                for(char c:i.toCharArray()){
                    t|=1<<(c-'a');
                }
                set.add(t);
            }
            for(String i:targetWords){
                int t=0,tnum=0;
                for(char c:i.toCharArray()){
                    t|=1<<(c-'a');
                }
                for(int j=0;j<26;++j){
                    tnum=1<<j;
                    if((t&tnum)!=0){
                        if(set.contains(t-tnum)) {
                            res++;
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }

    class Solution_1_9_2 {
        public int minSwaps(int[] nums) {
            int cnt=0;
            int now=0;
            int res=0;
            for(int i:nums){
                if(i==1)cnt++;
            }
            int l=0,r=0;
            for(;r<nums.length-cnt;++r){
                now+=nums[r];
            }
            res=now;
            for(;r<nums.length;++r,++l){
                now+=nums[r];
                now-=nums[l];
                res=Math.min(res,now);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}