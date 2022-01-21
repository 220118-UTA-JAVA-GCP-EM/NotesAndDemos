package com.example.loggingsingleton;

public class LoggingDriver {

    public static void main(String[] args){
        LoggingSingleton logger = LoggingSingleton.getLogger();

        logger.setWriteToFile(true);

        logger.debug("This is a test message");

        logger.setWriteToFile(false);

        logger.info("This should only write to the console");

        logger.setWriteToConsole(false);
        logger.setWriteToFile(true);

        logger.warn("This should only write to the file");

    }

}
