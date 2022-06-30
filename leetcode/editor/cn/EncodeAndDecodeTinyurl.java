package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class EncodeAndDecodeTinyurl {
    public static void main(String[] args) {
        Codec solution = new EncodeAndDecodeTinyurl().new Codec();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {

        // Encodes a URL to a shortened URL.
        HashMap<String, String> map = new HashMap<>();
        public String encode(String longUrl) {
            String hash = myHash(longUrl);
            map.put(hash, longUrl);
            return hash;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }

        String myHash(String s) {
            long v = 0;
            for (char i : s.toCharArray()) {
                v *= 333;
                v += i * 233;
            }
            return String.valueOf(v);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)

}