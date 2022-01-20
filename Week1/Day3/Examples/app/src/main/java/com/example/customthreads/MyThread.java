package com.example.customthreads;

public class MyThread extends Thread{

    //If we want this thread to do some custom logic, we will need to override the run method
    @Override
    public void run(){
        //We will just create a loop so we can get a better look at how the scheduler does its thing
        for(int i=0; i<100;i++){
            System.out.println("\t" + Thread.currentThread().getName());
        }
    }

}
