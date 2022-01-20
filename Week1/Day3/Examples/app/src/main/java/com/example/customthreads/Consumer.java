package com.example.customthreads;

import java.util.LinkedList;

public class Consumer extends Thread{

    private final LinkedList<Integer> buffer;
    private final int SIZE = 10;

    public Consumer(LinkedList<Integer> buffer){
        this.buffer = buffer;
    }

    private int consume() throws InterruptedException {
        synchronized (buffer){
            while(buffer.isEmpty()){
                System.out.println("The buffer is empty, wait for the producer");
                buffer.wait();
            }
            buffer.notifyAll();
            return buffer.remove(0);
        }
    }

    @Override
    public void run(){
        for(int i=0; i<SIZE; i++){
            try{
                System.out.println("Consumed: " + this.consume());
                //Thread.sleep(50);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
