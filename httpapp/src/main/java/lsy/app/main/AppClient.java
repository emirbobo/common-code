package lsy.app.main;

import lsy.app.http.SSLHttpClient;
import lsy.app.http.SSLHttpClientBuilder;
import lsy.app.http.pack.Pack;
import lsy.app.http.task.Task;
import lsy.util.UtilConsole;

/**
 * Created by Administrator on 2016/9/11.
 */
public class AppClient
{
	SSLHttpClient httpClient;
	boolean init = false;
	private Task curTask;
	private Pack curPack;

	public AppClient() {
		try {
			init();

			init = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
		initHttpClient();
	}

	private void initHttpClient() {
		httpClient = SSLHttpClientBuilder.newBuilder()
				.setHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.2.2; zh-cn; 2014011 Build/HM2014011) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1")
				.setHeader("Connection", "keep-alive")
				.setHeader("Accept-Language", "zh_CN")

				.setHeader("X-Requested-With", "XMLHttpRequest")


				.setHeader("x-wl-platform-version","6.0.0")
				.setHeader("x-wl-app-version","2.4")
//				.setHeader("WL-Instance-Id","fngm3nks6tndg0eakadni50clt")


				.setHeader("Accept", "text/javascript, text/html, application/xml, text/xml, */*")
				.setHeader("Accept-Encoding","gzip,deflate")
				.setHeader("Accept-Charset","utf-8, utf-16, *;q=0.7")
				.build();
	}

	public boolean isInit() {
		return init;
	}

	public synchronized void executeTask(Task task)
	{
		if(this.curTask != null && ! this.curTask.isFinish())
		{
			UtilConsole.error("Current Task Not Finished");
			return;
		}
		this.curTask = task;
		this.taskStep();
	}

	private void taskStep()
	{
		this.curPack = this.curTask.nextPack();
		if(this.curPack == null)
			return;
		httpClient.execute(this);
		taskStep();
	}

	public Pack getCurPack() {
		return curPack;
	}

	public Task getCurTask() {
		return curTask;
	}

	public void addFixHeader(String name, String value) {
		httpClient.addFixHeader(name,value);
	}
}
