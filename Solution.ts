
class Logger {

    private static MIN_WAIT_TIME_BETWEEN_PRINTING = 10;
    private messageToLastPrintingTime = new Map();

    shouldPrintMessage(timestamp: number, message: string): boolean {
        if (!this.messageToLastPrintingTime.has(message) ||
            this.messageToLastPrintingTime.get(message) + Logger.MIN_WAIT_TIME_BETWEEN_PRINTING <= timestamp) {
            this.messageToLastPrintingTime.set(message, timestamp);
            return true;
        }
        return false;
    }
}
