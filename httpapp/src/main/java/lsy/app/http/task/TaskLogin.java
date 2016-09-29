package lsy.app.http.task;

import lsy.app.http.pack.PackQuery;

/**
 * Created by Administrator on 2016/9/12.
 */
public class TaskLogin extends Task
{
	public TaskLogin() {
		appendPack(new PackQuery());
//		appendPack(new PackLogin());
	}
}
