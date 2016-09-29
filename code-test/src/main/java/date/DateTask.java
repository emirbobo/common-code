package date;

/**
 * Created by xijingbo on 2016-09-28.
 */
public class DateTask implements Runnable {
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName()+" -- "+System.nanoTime());
    }
}
