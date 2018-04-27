// package com.sqli.nespresso.training.threading;
package design.practice.designEx.threading;

public class Logger {

    private Logger() {
    }

    public static Logger myInstance;

    public static class LoggerHolder {

        public static Logger logger = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.logger;
    }

    public void log(String s) {
        System.err.println(s);
    }
}

