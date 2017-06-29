package util;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jingbo.xi on 2017/3/3.
 */
public class DelayObject<T> implements Delayed {

    private static final long NANO_ORIGIN = System.nanoTime();

    final static long now() {
        return System.nanoTime() - NANO_ORIGIN;
    }

//    private static final AtomicLong sequencer = new AtomicLong(0);

//    private final long sequenceNumber;

    private final long time;

    private final T item;

    public DelayObject(T submit, long timeout) {
        this.time = now() + timeout;
        this.item = submit;
//        this.sequenceNumber = sequencer.getAndIncrement();
    }

    public T getItem() {
        return this.item;
    }

    public long getDelay(TimeUnit unit) {
        long d = unit.convert(time - now(), TimeUnit.NANOSECONDS);
        return d;
    }

    public int compareTo(Delayed other) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) -other.getDelay(TimeUnit.MILLISECONDS));
    }
}
