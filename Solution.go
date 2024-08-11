
package main

import "fmt"

const MIN_WAIT_TIME_BETWEEN_PRINTING = 10

type Logger struct {
    messageToLastPrintingTime map[string]int
}

func Constructor() Logger {
    logger := Logger{
        messageToLastPrintingTime: map[string]int{},
    }
    return logger
}

func (this *Logger) ShouldPrintMessage(timestamp int, message string) bool {
    if lastPrintingTime, hasMessage := this.messageToLastPrintingTime[message]; 
      !hasMessage || lastPrintingTime+MIN_WAIT_TIME_BETWEEN_PRINTING <= timestamp {
        this.messageToLastPrintingTime[message] = timestamp
        return true
    }
    return false
}
