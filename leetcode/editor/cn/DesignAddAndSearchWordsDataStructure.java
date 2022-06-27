package leetcode.editor.cn;

public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary solution = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
        solution.addWord("a");
        solution.addWord("ab");
        solution.search("a.");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class WordDictionary {
        WordDictionary[] next = null;
        boolean end = false;

        public WordDictionary() {
            next = new WordDictionary[26];
        }

        public void addWord(String word) {
            addWord(word.toCharArray(), 0);
        }

        public void addWord(char[] c, int index) {
            int tar = c[index] - 'a';
            if (next[tar] == null) next[tar] = new WordDictionary();
            if (index != c.length - 1) {
                next[tar].addWord(c, index + 1);
            } else {
                next[tar].end = true;
            }
        }

        public boolean search(String word) {
            return search(word.toCharArray(), 0);
        }

        public boolean search(char[] c, int index) {
            if (index == c.length ) return end;
            if (c[index] != '.') {
                int tar = c[index] - 'a';
                if (next[tar] == null) return false;
                return next[tar].search(c, index + 1);
            }
            for (WordDictionary i : next) {
                if (i != null && i.search(c, index + 1)) return true;
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}