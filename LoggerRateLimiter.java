public class Logger {
    
    Map<String, Integer> log;

    /** Initialize your data structure here. */
    public Logger() {
        log = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!log.containsKey(message)) {
            log.put(message, timestamp);
            return true;
        } else {
            Integer past = log.get(message);
            if (timestamp - past >= 10) {
                log.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */