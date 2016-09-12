package lsy.app.main;

<<<<<<< HEAD:httpapp/src/main/java/lsy/app12306/Testor.java
import lsy.app12306.http.pack.Pack;
import lsy.app12306.http.task.Task;
import lsy.app12306.http.task.TaskReady;
import lsy.app12306.http.task.TaskLogin;
=======
import lsy.app.http.task.Task;
import lsy.app.http.task.TaskReady;
import lsy.app.http.task.TaskLogin;
>>>>>>> ef0dc8290826d8fc932ddb71b112d8b710c25e32:httpapp/src/main/java/lsy/app/main/Testor.java
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
						Pack.createCommonTask("https://wwwwwwwwwwwwwww")
						,Pack.createCommonTask("https://wwwwwwwwwwwwwww",true)
		));
	}
}
