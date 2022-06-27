package leetcode.editor.cn;

import java.util.HashMap;

public class MapSumPairs{
    public static void main(String[] args) {
        MapSum solution = new MapSumPairs().new MapSum();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
    MapSum[] next=new MapSum[26];
    HashMap<String,Integer> map=new HashMap<>();
    int val=0;
    public MapSum() {

    }

    public void insert(String key, int val) {
        map.put(key,val);
        MapSum temp=this;
        for(char i:key.toCharArray()){
            if(temp.next[i-'a']==null) temp.next[i-'a']=new MapSum();
            temp=temp.next[i-'a'];
        }
        temp.val=val;
    }

    public int sum(String prefix) {
        MapSum temp=this;
        for(char i:prefix.toCharArray()){
            if(temp.next[i-'a']==null)temp.next[i-'a']=new MapSum();
            temp=temp.next[i-'a'];
        }
        return temp.sum();
    }

    int sum(){
        int res=val;
        for(MapSum i:next){
            if(i!=null) res+=i.sum();
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}