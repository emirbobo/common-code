package lsy.app.main;


import lsy.app.http.pack.Pack;
import lsy.app.http.task.Task;
import lsy.app.http.task.TaskReady;
import lsy.app.http.task.TaskLogin;
import lsy.util.UtilConsole;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Testor {
	AppClient appClient = new AppClient();
	public static void main(String[] args) {
		Testor testor = new Testor();
		testor.execute();
	}

	private void execute() {
		if(! appClient.isInit())
		{
			UtilConsole.log("AppClient exit");
			return;
		}

		UtilConsole.log("AppClient 启动");

//		Task task = new TaskReady();
//		appClient.executeTask(task);
//
//		task = new TaskLogin();
//		appClient.executeTask(task);

		appClient.executeTask(
				Task.createCommonTask(
						Pack.createCommonTask("https://wwwwwwwwwwwwwww").addHeader("ddddd","dddd")
						,Pack.createCommonTask("https://wwwwwwwwwwwwwww",true)
		));
	}
}
