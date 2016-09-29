package lsy.app.http.pack;

import lsy.app.main.AppClient;
import org.apache.http.StatusLine;

/**
 * Created by Administrator on 2016/9/12.
 */
public class PackLaunch extends Pack
{
	public PackLaunch() {
		super("https://mobile.12306.cn/otsmobile/track/alaunch");
	}

	@Override
	public void handleResult(AppClient appClient, StatusLine statusLine, String response) {

	}
}
