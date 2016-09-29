package lsy.app.http.pack;

import lsy.app.main.AppClient;
import lsy.util.UtilConsole;
import org.apache.http.StatusLine;

/**
 * Created by Administrator on 2016/9/12.
 * ����ò�Ƶ�¼ǰ���Ȳ�ѯ������״̬
 * Ŀǰ��������11����ʾ���ܵ�¼
 */
public class PackQuery extends Pack
{
	public PackQuery() {
		super("/otsmobile/apps/services/api/MobileTicket/android/query");
	}

	@Override
	public void handleResult(AppClient appClient, StatusLine statusLine, String response)
	{

		if(401 == statusLine.getStatusCode() )
		{
			UtilConsole.error("HTTP/1.1 401 Unauthorized , Check and update [WL-Instance-Id]");
			int start = response.indexOf("WL-Instance-Id");
			if(start > 0)
			{
				start += "WL-Instance-Id".length()+1;
				start = response.indexOf("\"",start);//As the follow example text , the double quote before jr5gnh64e9ks7gfn0fmb0b86vi
				if(start > 0)
				{
					start ++;
					int end = response.indexOf("\"",start);//As the follow example text , the double quote before jr5gnh64e9ks7gfn0fmb0b86vi
					if(end >= 0)
					{
						String WL_Instance_Id = response.substring(start,end);
						UtilConsole.info("Find New WL-Instance-Id : "+WL_Instance_Id);
						//����header
						appClient.addFixHeader("WL-Instance-Id",WL_Instance_Id);
						appClient.addFixHeader("x-wl-app-version", "2.4");
						//���һ��query��
						appClient.getCurTask().appendPack(new PackQuery().setInfo("Append updated fix-header [WL-Instance-Id] = ["+WL_Instance_Id+"]"));
					}
				}
			}
		}
//		HTTP/1.1 401 Unauthorized
//		Response content length: 249
/*-secure-
{"challenges":{"wl_antiXSRFRealm":{"WL-Instance-Id":"jr5gnh64e9ks7gfn0fmb0b86vi"},"morCustomRealm":{"WL-Challenge-Data":"922463N838416C880472N417420C998226X5B9393E5S484584C637647C409457N695389X384ABC1CS216699C801621C782957X2E3339D2S"}}}*/
	}
}
