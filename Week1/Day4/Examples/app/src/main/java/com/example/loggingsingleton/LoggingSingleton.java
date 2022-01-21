package com.example.loggingsingleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggingSingleton {

    //We want different levels of logging, example DEBUG, INFO, WARN
    //We want to be able to setup writing to a file, and printing to the console

    //Things we need to write text to a file/make our lives easier
    private static final String FILE = "log.txt";
    private static StringBuffer sb;
    //To write to a file we can use a couple of options, but we will use the BufferedWriter, because it allows to write
    //Entire lines of data to a text file
    private BufferedWriter fileWriter;

    //Let the user decide whether they want to write their output to a file or to the console or neither
    private boolean writeToFile = false;
    private boolean writeToConsole = true;

    /*
        How to make a Single Eager
        //Call the constructor right away
        private static SingletonLogger logger = new SingletonLogger();

        //The public static getInstance method would simpy return the created object
        public static SingletonLogger getInstance(){
            return logger;
        }

     */

    //To create a lazy singleton you can just declare a private static instance of the object
    private static LoggingSingleton logger;

    private LoggingSingleton(){
        try{
            this.fileWriter = new BufferedWriter(new FileWriter(FILE, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Then you create the single object instance when you make a call to getInstance()
    public static LoggingSingleton getLogger(){
        //if the object has not yet been created create one, otherwise return the variable from above
        if(logger == null) logger = new LoggingSingleton();
        return logger;
    }

    //Debug would typically be used for fine grained debugging instead of System outing everywhere
    public void debug(String message){
        sb = new StringBuffer();
        sb.append("DEBUG - ");
        sb.append(LocalDateTime.now());
        sb.append(" - ");
        sb.append(message);
        if(writeToFile){
            try{
                fileWriter.write(sb.toString());
                fileWriter.newLine();
                fileWriter.flush();
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        if(writeToConsole){
            System.out.println(sb.toString());
        }
    }

    //Info would be used to log things like when users successfuly log in
    public void info(String message){
        sb = new StringBuffer();
        sb.append("INFO - ");
        sb.append(LocalDateTime.now());
        sb.append(" - ");
        sb.append(message);
        if(writeToFile){
            try{
                fileWriter.write(sb.toString());
                fileWriter.newLine();
                fileWriter.flush();
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        if(writeToConsole){
            System.out.println(sb.toString());
        }
    }

    //Warn is used when something goes wrong, like an exception
    public void warn(String message){
        sb = new StringBuffer();
        sb.append("WARN - ");
        sb.append(LocalDateTime.now());
        sb.append(" - ");
        sb.append(message);
        if(writeToFile){
            try{
                fileWriter.write(sb.toString());
                fileWriter.newLine();
                fileWriter.flush();
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        if(writeToConsole){
            System.out.println(sb.toString());
        }
    }

    public void setWriteToFile(boolean val){
        this.writeToFile = val;
    }

    public void setWriteToConsole(boolean val){
        this.writeToConsole = val;
    }

}
