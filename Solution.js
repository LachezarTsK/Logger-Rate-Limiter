
class Logger {

    static #MIN_WAIT_TIME_BETWEEN_PRINTING = 10;
    #messageToLastPrintingTime = new Map();

    /** 
     * @param {number} timestamp 
     * @param {string} message
     * @return {boolean}
     */
    shouldPrintMessage(timestamp, message) {
        if (!this.#messageToLastPrintingTime.has(message) ||
             this.#messageToLastPrintingTime.get(message) + Logger.#MIN_WAIT_TIME_BETWEEN_PRINTING <= timestamp) {
             this.#messageToLastPrintingTime.set(message, timestamp);
            return true;
        }
        return false;
    }
}
