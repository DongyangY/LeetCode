/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    
    char[] buffer = new char[4];
    
    int bufsize;
    
    int offset;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int nBytes = 0;
        boolean eof = false;
        
        while (nBytes < n && !eof) {
            if (bufsize == 0) {
                bufsize = read4(buffer);
                eof = bufsize < 4;
            }
            int readBytes = Math.min(bufsize, n - nBytes);
            System.arraycopy(buffer, offset, buf, nBytes, readBytes);
            nBytes += readBytes;
            offset = (offset + readBytes) % 4;
            bufsize -= readBytes;
        }
        return nBytes;
    }
}