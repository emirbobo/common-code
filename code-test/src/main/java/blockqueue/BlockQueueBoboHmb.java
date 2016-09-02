package blockqueue;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xijingbo on 2016-09-02.
 */
public class BlockQueueBoboHmb {

    static ConcurrentLinkedQueue<Integer> block = new ConcurrentLinkedQueue<Integer>();
    String lock = new String();

    static BlockQueueBoboHmb b = new BlockQueueBoboHmb();
    final int full_size = 10;

    public static void main(String [] args){
        consumer c = b.new consumer();
        producer p = b.new producer();
        Thread tc = new Thread(c);
        Thread tp = new Thread(p);
        tc.start();
        tp.start();
        try {
            tc.join();
            tp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void put(){
        int nextPut = new Random().nextInt(1000);
        block.add(nextPut);
        log("Put "+nextPut+"  Size:"+block.size());

    }
    private static void take(){

        Integer poll = block.poll();
        log("Take "+poll +"  Size:"+block.size());
    }
    private class consumer implements Runnable{
        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    while (block.size() == 0) {
                        try {
                            log(block.size()+" Empty , Wait for put");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    take();
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class producer implements Runnable{

        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    while (block.size() >= full_size) {
                        try {
                            log(block.size()+" Full , Wait for take");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    put();
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void log(String v){
        System.out.println(v);
        System.out.flush();
    }
}
