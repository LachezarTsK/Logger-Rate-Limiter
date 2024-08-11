
class Logger() {

    private companion object {
        const val MIN_WAIT_TIME_BETWEEN_PRINTING = 10
    }

    private val messageToLastPrintingTime = HashMap<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (messageToLastPrintingTime.getOrDefault(message, -MIN_WAIT_TIME_BETWEEN_PRINTING)
            + MIN_WAIT_TIME_BETWEEN_PRINTING <= timestamp) {
            messageToLastPrintingTime[message] = timestamp
            return true
        }
        return false
    }
}
