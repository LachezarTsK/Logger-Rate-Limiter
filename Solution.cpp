
#include <string>
#include <unordered_map>
using namespace std;

class Logger {

    static const int MIN_WAIT_TIME_BETWEEN_PRINTING = 10;
    unordered_map<string, int> messageToLastPrintingTime;

public:
    bool shouldPrintMessage(int timestamp, const string& message) {
        if (!messageToLastPrintingTime.contains(message)||
            messageToLastPrintingTime[message]  + MIN_WAIT_TIME_BETWEEN_PRINTING <= timestamp) {
            messageToLastPrintingTime[message] = timestamp;
            return true;
        }
        return false;
    }
};
