package lsy.app.main;

import lsy.app.http.task.Task;
import lsy.app.http.task.TaskLogin;
import lsy.app.http.task.TaskReady;
import lsy.util.UtilConsole;

/**
 * Created by Administrator on 2016/9/12.
 */
public class WebFetchTest {
	AppClient appClient = new AppClient();
	public static void main(String[] args) {
		WebFetchTest testor = new WebFetchTest();
		testor.execute();
	}

	private void execute() {
		if(! appClient.isInit())
		{
			UtilConsole.log("AppClient exit");
			return;
		}

		UtilConsole.log("AppClient 启动");

		Task task = new TaskReady();
		appClient.executeTask(task);

		task = new TaskLogin();
		appClient.executeTask(task);
	}
}
