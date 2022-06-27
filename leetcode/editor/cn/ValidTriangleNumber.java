package leetcode.editor.cn;
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 255 👎 0

import java.util.ArrayList;
import java.util.Arrays;

//Java：有效三角形的个数
public class ValidTriangleNumber{
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        solution.triangleNumber(new int[]{0,1,1,1});
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static long[] p;
        public int triangleNumber(int[] nums) {
            init();
            ArrayList<Integer> list=new ArrayList<Integer>();
            int[] cnt=new int[1001];
            for(int i:nums){
                if(++cnt[i]==1) list.add(i);
            }
            int[] sum=cnt.clone();
            for(int i=1;i<1001;++i){
                sum[i]+=sum[i-1];
            }
            Integer[] q= list.toArray(new Integer[0]);
            Arrays.sort(q);
            int res=0;
            for(int i=0;i<q.length;++i){
                for(int j=i+1;j<q.length;++j){
                    res+=getNum(q[i], q[j],sum,cnt);
                }
                res+=self(q[i],cnt);

            }
            return res;
        }
        int self(int n,int[] cnt){
            if(n==0) return 0;
            int num3=0;
            if(cnt[n]>=3)num3+=p[cnt[n]]/((p[cnt[n]-3])*6);
            return num3;
        }
        int getNum(int n1,int n2,int[] sum,int[] cnt){
            if(n1*n2==0)return 0;
            int l=n2;
            int r=n1+n2-1;
            int num=cnt[n1]*cnt[n2]*(sum[r]-sum[l]);
            //int n=cnt[n1]+cnt[n2];
            int num2=0;
            if(n1*2>n2) num+=cnt[n1]*(cnt[n1]-1)/2*cnt[n2];
            num+=cnt[n2]*(cnt[n2]-1)/2*cnt[n1];
            return num+num2;
        }
        void init(){
            if(p!=null) return;
            p=new long[1001];
            p[0]=1;
            p[1]=1;
            for(int i=2;i<1001;++i){
                p[i]=i*p[i-1];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}