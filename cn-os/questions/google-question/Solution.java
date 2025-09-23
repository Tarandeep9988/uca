import java.util.HashMap;
class Solution
{
    static class Logger {
        HashMap<String, Integer> map = new HashMap<>();
        public Logger() {
            map = new HashMap<>();
        }
        
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!map.containsKey(message) || map.get(message) + 10 <= timestamp) {
                System.out.println(message);
                map.put(message, timestamp);
                return true;
            }
            return false;  
        }
        public boolean shouldPrintMessage2(int timestamp, String message) {
            if (!map.containsKey(message)) {
                map.put(message, timestamp);
                return false;
            }
            if (map.get(message) + 10 <= timestamp) {
                System.out.println(message);
                map.put(message, timestamp);
                return true;
            }
            map.put(message, timestamp);
            return true;
        }
    }
    
	public static void main (String[] args)  {
		Logger logger = new Logger();
		logger.shouldPrintMessage2(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        logger.shouldPrintMessage2(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        logger.shouldPrintMessage2(3, "foo");  // 3 < 11, return false
        logger.shouldPrintMessage2(8, "bar");  // 8 < 12, return false
        logger.shouldPrintMessage2(10, "foo"); // 10 < 11, return false
        logger.shouldPrintMessage2(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21

	}
}
