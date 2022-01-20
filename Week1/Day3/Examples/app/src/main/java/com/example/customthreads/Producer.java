package com.example.customthreads;

import java.util.LinkedList;

public class Producer extends Thread{

    private final LinkedList<Integer> buffer;
    private final int SIZE = 10;

    public Producer(LinkedList<Integer> buffer){
        this.buffer = buffer;
    }

    private void produce(int i) throws InterruptedException {
        //For the producer and consumer to both use the buffer, we must use the synchronized keyword
        synchronized (buffer){
            while(buffer.size() == SIZE){
                System.out.println("The buffer is full");
                buffer.wait();
            }
            buffer.add(i);
            buffer.notifyAll();
        }
    }

    @Override
    public void run(){
        for(int i=0; i<SIZE; i++){
            System.out.println("Produced: " + (i+1));
            try{
                this.produce(i+1);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
