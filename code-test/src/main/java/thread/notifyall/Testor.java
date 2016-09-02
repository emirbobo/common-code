package thread.notifyall;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
		Set<Thread> set = new HashSet<>();
		ThreadMaster threadMaster = new ThreadMaster();
		set.add(threadMaster);
		for(int i=0;i<5;i++)
		{
			set.add(new ThreadWait());
		}
		for(Thread thread : set)
			thread.start();
		for(Thread thread : set)
			try {
				thread.join();
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
				while (waitFlag)
				{
					try {
						log("Wait-Thread["+this.getName()+"] Start wait ");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(printFlag)
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
