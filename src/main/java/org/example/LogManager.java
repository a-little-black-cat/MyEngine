package org.example;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.SimpleFormatter;

public class LogManager extends Manager{

    Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;

    private static LogManager instance;

    private LogManager(){
        super(); //calls the protected constructor of Manager
        this.managerType = "LogManager";
        try {
            // 1. Initialize the file handler ONCE
            // The 'true' argument means "append" to the file instead of overwriting
            fh = new FileHandler("debugLog.log", true);
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());

            // Turn off parent handlers so logs don't just clutter the console twice
            logger.setUseParentHandlers(false);

        } catch (IOException e) {
            System.err.println("Could not initialize LogManager: " + e.getMessage());
        }

        this.startUp();
        writeLog("LogManager is started.");
    }

    public static LogManager getInstance(){
        if (instance==null){
            instance = new LogManager();
        }
        return instance;
    }

    public void writeLog(String logLine){
        logger.info(logLine);
    }






}
