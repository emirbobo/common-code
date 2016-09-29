package date;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xijingbo on 2016-09-18.
 */
public class DateTest {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("monitor");
        DateThreadFactory dateThreadFactory = new DateThreadFactory("dateThread");
        ExecutorService exec = Executors.newFixedThreadPool(10, dateThreadFactory);
        long start = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            exec.submit(new DateTask());
        }
        exec.shutdown();
        System.out.println("total " + (System.currentTimeMillis() - start));
    }
}
