package com.arrownock.im.callback;

import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;
import java.util.List;
import org.json.JSONObject;

public class AnIMGetTopicListCallbackData
  extends AnIMBaseRequestCallbackData
{
  String clientId = null;
  List<JSONObject> topicList = null;
  
  static
  {
    JniLib.a(AnIMGetTopicListCallbackData.class, 160);
  }
  
  public AnIMGetTopicListCallbackData(boolean paramBoolean, ArrownockException paramArrownockException, List<JSONObject> paramList, String paramString)
  {
    super(paramBoolean, paramArrownockException);
    this.topicList = paramList;
    this.clientId = paramString;
  }
  
  public native String getClientId();
  
  public native List<JSONObject> getTopicList();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMGetTopicListCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */