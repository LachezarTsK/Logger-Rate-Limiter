
import java.util.HashMap;
import java.util.Map;

public class Logger {

    private static final int MIN_WAIT_TIME_BETWEEN_PRINTING = 10;
    private final Map<String, Integer> messageToLastPrintingTime = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageToLastPrintingTime.getOrDefault(message, -MIN_WAIT_TIME_BETWEEN_PRINTING)
                + MIN_WAIT_TIME_BETWEEN_PRINTING <= timestamp) {
            messageToLastPrintingTime.put(message, timestamp);
            return true;
        }
        return false;
    }
}
