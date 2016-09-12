package lsy.app.http.pack;


import lsy.app.main.AppClient;
import org.apache.http.StatusLine;

/**
 * Created by Administrator on 2016/9/13.
 */
public class PackCommon extends Pack
{
	protected PackCommon(String url, boolean post) {
		super(url, post);
	}

	@Override
	public void handleResult(AppClient appClient, StatusLine statusLine, String response) {

	}
}
