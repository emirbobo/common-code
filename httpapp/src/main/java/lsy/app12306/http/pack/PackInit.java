package lsy.app12306.http.pack;

import lsy.app12306.AppClient;
import org.apache.http.StatusLine;

/**
 * Created by Administrator on 2016/9/12.
 */
public class PackInit extends Pack {
	protected PackInit() {
		super("/otsmobile/apps/services/api/MobileTicket/android/init");
	}

	@Override
	public void handleResult(AppClient appClient, StatusLine statusLine, String response) {

	}
}
