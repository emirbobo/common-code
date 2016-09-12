package lsy;

import lsy.proxy.StationHttpProxyServer;
import lsy.station.StationHttpClientManager;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-16
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
public class Manager
{
    final StationHttpProxyServer proxyServer = new StationHttpProxyServer();
    StationHttpClientManager httpClientManager = new StationHttpClientManager();

    public void shutdown()
    {
        proxyServer.shutdown();
    }
    public void start()
    {
        new Thread(new Runnable() {
            public void run() {
                try {
                    proxyServer.start(httpClientManager);
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }).start();

//        ConsoleThread consoleThread = new ConsoleThread(this);
//        consoleThread.start();
//        System.out.println( "Hello World!" );
    }
}
