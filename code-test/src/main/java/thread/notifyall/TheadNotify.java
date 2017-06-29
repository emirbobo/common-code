package thread.notifyall;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mtime on 2017/6/2.
 */
public class TheadNotify {

    Lock lock = new ReentrantLock();

    public static int count = 0;

    Condition printASignal = lock.newCondition();

    Condition printBSignal = lock.newCondition();

    Condition printCSignal = lock.newCondition();



    public static void main(String[] args) throws InterruptedException {
        TheadNotify notify = new TheadNotify();
        Thread a = new Thread(notify.new ASignal());
        Thread b = new Thread(notify.new BSignal());
        Thread c = new Thread(notify.new CSignal());
        a.start();
        b.start();
        c.start();
    }
    public class ASignal implements Runnable{

        @Override
        public void run() {
            try {
                lock.lock();
                while (count < 100) {
                    printA();
                    try {
                        printBSignal.signal();
                        printASignal.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public class BSignal implements Runnable{

        @Override
        public void run() {
            try {
                lock.lock();
                while(count < 100){
                    printB();
                    try {
                        printCSignal.signal();
                        printBSignal.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public class CSignal implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (count < 100) {
                    printC();
                    try {
                        printASignal.signal();
                        printCSignal.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void printA(){
        System.out.println("A");
        count++;
    }

    public void printB(){
        System.out.println("B");
        count++;
    }

    public void printC(){
        System.out.println("C");
        count++;
    }


}
