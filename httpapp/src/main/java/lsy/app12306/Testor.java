package lsy.app12306;

import lsy.app12306.http.pack.Pack;
import lsy.app12306.http.task.Task;
import lsy.app12306.http.task.TaskReady;
import lsy.app12306.http.task.TaskLogin;
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
			UtilConsole.log("AppClient ��ʼ��ʧ��");
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
						Pack.createCommonTask("https://wwwwwwwwwwwwwww")
						,Pack.createCommonTask("https://wwwwwwwwwwwwwww",true)
		));
	}
}
