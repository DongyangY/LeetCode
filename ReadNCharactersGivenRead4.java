/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 4) {
            return read4(buf);
        } else if (n < 4){
            int num = read4(buf);
            return Math.min(num, n);
        } else {
            char[] buffer = new char[4];
            int nByte = 0;
            while (nByte < n) {
                int num = read4(buffer);
                System.arraycopy(buffer, 0, buf, nByte, num);
                nByte += num;
                if (num < 4) break;
            }
            return Math.min(nByte, n);
        }
    }
}