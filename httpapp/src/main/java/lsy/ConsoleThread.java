package lsy;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-15
 * Time: 下午8:32
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleThread extends Thread
{
    App app;
    public ConsoleThread(App app) {
        super();
        this.app = app;
    }

    @Override
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.print("\nType Exit to Exit\n");
            String cmd = scanner.next();
            if("exit".equalsIgnoreCase(cmd))
            {
//                app.shutdown();
                break;
            }
        }
    }
}
