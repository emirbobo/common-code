package thread.notifyall;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2016/9/2.
 */
public class Testor
{
	static Object lock = new Object();

	boolean waitFlag = true;
	boolean printFlag = true;

	public static void main(String[] args) {
		Testor testor = new Testor();
		testor.execute();
	}

	private void execute() {
		ExecutorService service = Executors.newFixedThreadPool(30);
		ThreadMaster threadMaster = new ThreadMaster();
		for(int i=0;i<50;i++)
		{
			service.execute(new ThreadWait());
		}
		threadMaster.start();
		service.shutdown();
		try {
			threadMaster.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class ThreadMaster extends Thread
	{
		@Override
		public void run() {
			synchronized (lock)
			{
				try {
					Thread.sleep(5000);
					waitFlag = false;
					lock.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class ThreadWait extends Thread
	{
		@Override
		public void run() {
			synchronized (lock)
			{
				boolean localPrintFlag = true;
				while (waitFlag)
				{
					try {
						log("Wait-Thread["+this.getName()+"] Start wait ");
						lock.wait();
						localPrintFlag = printFlag;//先把标志存起来
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(localPrintFlag)
						log("Wait-Thread["+this.getName()+"] Print After wait");
					printFlag = false;
				}
			}
			log("Wait-Thread["+this.getName()+"] exit!");
		}
	}
	static void log(String info)
	{
		System.out.println(info);
	}
}
