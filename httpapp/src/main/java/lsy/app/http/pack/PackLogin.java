package lsy.app.http.pack;

import lsy.app.main.AppClient;
import org.apache.http.StatusLine;

/**
 * Created by Administrator on 2016/9/12.
 */
public class PackLogin extends Pack
{
	public PackLogin(String url, boolean post)
	{
		super("", true);
	}

	public PackLogin() {
		super("");
	}

	@Override
	public void handleResult(AppClient appClient, StatusLine statusLine, String response) {

	}
}
