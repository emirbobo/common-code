package lsy.app.http.task;

import lsy.app.http.pack.PackQuery;

/**
 * Created by Administrator on 2016/9/12.
 */
public class TaskWebLogin extends Task
{
	public TaskWebLogin() {
		appendPack(new PackQuery());
//		appendPack(new PackLogin());
	}
}
