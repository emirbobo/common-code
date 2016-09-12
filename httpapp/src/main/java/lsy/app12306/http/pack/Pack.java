package lsy.app12306.http.pack;

import lsy.app12306.AppClient;
import org.apache.http.StatusLine;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/12.
 */
abstract public class Pack
{
	private final String url;
	private final boolean post;
	private final HashMap<String,String> headers = new HashMap<>();
	private String info;

	protected Pack(String url,boolean post)
	{
		if( ! url.startsWith("http"))
		{
			this.url = "https://mobile.12306.cn" + url;
		}
		else
			this.url = url;
		this.post = post;
		addHeader("Connection", "keep-alive");
	}

	/***
	 * form post pack
	 * @param url
	 */
	protected Pack(String url)
	{
		this(url, true);
		addHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
	}
	protected void addHeader(String n,String v)
	{
		headers.put(n,v);
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public abstract void handleResult(AppClient appClient, StatusLine statusLine, String response);//回调处理结果

	public String getUrl() {
		return url;
	}

	public boolean isPost() {
		return post;
	}

	public Pack setInfo(String info) {
		this.info = info;
		return this;
	}

	public String getInfo() {
		return info;
	}
}
