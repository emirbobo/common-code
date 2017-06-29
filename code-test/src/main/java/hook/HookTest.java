package hook;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mtime on 2016/12/16.
 */
public class HookTest {

    public void startHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Hook invoked......")));
    }

    public static void main(String[] args)
    {
        new HookTest().startHook();

        System.out.println("The Application is doing something");

        try
        {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }



}
