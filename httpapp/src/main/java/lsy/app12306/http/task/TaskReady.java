package lsy.app12306.http.task;

import lsy.app12306.http.pack.PackLaunch;
import lsy.app12306.http.pack.PackReach;

/**
 * Created by Administrator on 2016/9/12.
 */
public class TaskReady extends Task
{
	public TaskReady() {
		appendPack(new PackLaunch(), new PackReach());
	}
}
