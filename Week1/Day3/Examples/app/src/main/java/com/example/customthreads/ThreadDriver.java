package com.example.customthreads;

import java.util.LinkedList;

public class ThreadDriver {

    public static void main(String[] args){

        //You can create a new thread like this
        Thread th = new Thread();

        //You can get the currently running thread
        Thread main = Thread.currentThread();
        System.out.println(main.getName());

        try {
            //We can make the thread pause with .sleep()
            main.sleep(3000);
            System.out.println(main.getPriority());
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        //Lets create and run an instance of our custom threads
        MyThread th1 = new MyThread();
        th1.setName("First Thread");
        th1.setPriority(5);

        MyRunnable r1 = new MyRunnable();
        Thread th2 = new Thread(r1);

        th2.setName("Second Thread");

        //To actually run the logic in the thread, we must call start
        //th1.start();
        //th2.start();

        LinkedList<Integer> buffer = new LinkedList<>();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);
        p.start();
        c.start();

        try{
            p.join();
            c.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }

}
