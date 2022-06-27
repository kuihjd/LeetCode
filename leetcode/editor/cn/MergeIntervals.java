package leetcode.editor.cn;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static void main(String[] args) {
        int max = (int) 1e3;
        int l = 2;
        double[] arr = new double[]{1, 1, 2};
        for (int i = 2; i < max; ++i) {
            arr[l % 3] = arr[(l + 2) % 3] + arr[(l + 1) % 3];
            System.out.printf("%d %.0f/%.0f =  %.8f\n", i, arr[(l + 2) % 3] , arr[l % 3], arr[(l + 2) % 3] / arr[l % 3]);
            l++;
        }
        Solution solution = new MergeIntervals().new Solution();
        solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }

    /**
     * 唯一神单例
     */


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) return new int[0][2];
            PriorityQueue<int[]> nums = new PriorityQueue<>((v1, v2) -> v1[0] != v2[0] ? v1[0] - v2[0] : v1[1] - v2[1]);
            ArrayList<int[]> ans = new ArrayList<>();
//            for(int[] i : intervals) nums.add(i);
            nums.addAll(Arrays.asList(intervals));
            while (!nums.isEmpty()) {
                int[] t1 = nums.poll();
                while (!nums.isEmpty()){
                    int[] t2 = nums.peek();
                    if (t2[0] <= t1[1]) {
                        t1[1] = Math.max(t1[1], t2[1]);
                        nums.poll();
                    }
                    else{
                        break;
                    }
                }
                ans.add(t1);
            }
            return ans.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class God extends Exception {
    //本类对象
    private static final God  INSTANCE = new God();
    //构造私有
    private God() {}
    //提供公有访问方式
    public static God getGod(){
        return INSTANCE;
    }

    public String toString(){
        return "God is the only one";
    }
    //请在此处编写代码完成任务
    public Object readResolve(){
        return getGod();
    }
}

class BuildAnotherGod{
    public static void main(String[] args){
        God newGod = deepCopy(God.getGod());
        System.out.println(newGod == God.getGod());
        System.out.println(newGod);
    }

    // 通过反序列化方式破坏单例。此方法不建议开发中使用。
    public static God deepCopy(God obj){
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            new ObjectOutputStream(bos).writeObject(obj);
            ByteArrayInputStream bin =new ByteArrayInputStream(bos.toByteArray());
            return (God)new ObjectInputStream(bin).readObject();
        } catch(Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}