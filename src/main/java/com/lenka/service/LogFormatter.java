package com.lenka.service;

import java.util.logging.*;

public class LogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return "-----------------------------------------------------------------------------\n"
                +"["+record.getLevel()+"]:  " + record.getMessage()
                +"\n-----------------------------------------------------------------------------";
    }

    public static void setUpLogger(Logger log) {
        Handler handler = new ConsoleHandler();
        log.setUseParentHandlers(false);
        log.addHandler(handler);
        handler.setFormatter(new LogFormatter());
    }
}
