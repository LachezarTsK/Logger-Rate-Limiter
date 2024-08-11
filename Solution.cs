
using System;
using System.Collections.Generic;

public class Logger
{
    private static readonly int MIN_WAIT_TIME_BETWEEN_PRINTING = 10;
    private readonly Dictionary<string, int> messageToLastPrintingTime = new Dictionary<string, int>();

    public bool ShouldPrintMessage(int timestamp, string message)
    {
        if (messageToLastPrintingTime.GetValueOrDefault(message, -MIN_WAIT_TIME_BETWEEN_PRINTING)
            + MIN_WAIT_TIME_BETWEEN_PRINTING <= timestamp)
        {
            messageToLastPrintingTime[message] = timestamp;
            return true;
        }
        return false;
    }
}
