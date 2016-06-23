/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int nBytes = 0, readBytes = Integer.MAX_VALUE;
        while (nBytes < n && (readBytes = read4(buffer)) > 0) {
            readBytes = Math.min(readBytes, n - nBytes);
            System.arraycopy(buffer, 0, buf, nBytes, readBytes);
            nBytes += readBytes;
        }
        return nBytes;
    }
}