package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PeekingIterator{
    public static void main(String[] args) {
        Solution solution = new PeekingIterator().new Solution(Arrays.stream(new Integer[]{657567}).iterator());
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class Solution implements Iterator<Integer> {
	Iterator<Integer> it;
	public Solution(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it=iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		Iterator<Integer> t=it;
		return t.next();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return it.next();
	}
	
	@Override
	public boolean hasNext() {
		return it.hasNext();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}