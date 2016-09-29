package date;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xijingbo on 2016-09-28.
 */
public class DateThreadFactory implements ThreadFactory {

    AtomicInteger threadCount = new AtomicInteger(1);

    private String tName;


    DateThreadFactory(String tName){
        super();
        this.tName = tName;
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"dateThread-"+tName +"-"+threadCount.getAndIncrement());
        t.setDaemon(true);
        return t;
    }

}
