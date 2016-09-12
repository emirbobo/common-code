package lsy.app12306.http.pack;

import lsy.app12306.AppClient;
import lsy.util.UtilConsole;
import org.apache.http.StatusLine;

/**
 * Created by Administrator on 2016/9/12.
 */
public class PackReach extends Pack
{
	public PackReach() {
		super("/otsmobile/apps/services/reach",false);
		addHeader("X-Requested-With","com.MobileTicket");
	}

	@Override
	public void handleResult(AppClient appClient, StatusLine statusLine, String response)
	{
	}
}
