/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    Queue<Character> queue = new LinkedList<>();
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (queue.size() >= n) {
            for (int i = 0; i < n; i++) {
                buf[i] = queue.remove();
            }
            return n;
        } else {
            while (queue.size() < n) {
                char[] buffer = new char[4];
                int num = read4(buffer);
                for (int i = 0; i < num; i++) {
                    queue.add(buffer[i]);
                }
                if (num < 4) {
                    int nByte = 0;
                    while (!queue.isEmpty() && nByte < n) {
                        buf[nByte++] = queue.remove();
                    }
                    return nByte;
                }
            }
            return read(buf, n);
        }
    }
}