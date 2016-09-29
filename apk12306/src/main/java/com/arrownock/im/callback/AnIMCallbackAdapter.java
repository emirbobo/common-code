package com.arrownock.im.callback;

import com.bangcle.andjni.JniLib;

public class AnIMCallbackAdapter
  implements IAnIMCallback
{
  static
  {
    JniLib.a(AnIMCallbackAdapter.class, 154);
  }
  
  @Deprecated
  public native void addClientsToTopic(AnIMAddClientsCallbackData paramAnIMAddClientsCallbackData);
  
  @Deprecated
  public native void bindAnPushService(AnIMBindAnPushServiceCallbackData paramAnIMBindAnPushServiceCallbackData);
  
  @Deprecated
  public native void createTopic(AnIMCreateTopicCallbackData paramAnIMCreateTopicCallbackData);
  
  @Deprecated
  public native void getClientId(AnIMGetClientIdCallbackData paramAnIMGetClientIdCallbackData);
  
  @Deprecated
  public native void getClientsStatus(AnIMGetClientsStatusCallbackData paramAnIMGetClientsStatusCallbackData);
  
  public native void getSessionInfo(AnIMGetSessionInfoCallbackData paramAnIMGetSessionInfoCallbackData);
  
  @Deprecated
  public native void getTopicInfo(AnIMGetTopicInfoCallbackData paramAnIMGetTopicInfoCallbackData);
  
  @Deprecated
  public native void getTopicList(AnIMGetTopicListCallbackData paramAnIMGetTopicListCallbackData);
  
  public native void messageSent(AnIMMessageSentCallbackData paramAnIMMessageSentCallbackData);
  
  public native void receivedBinary(AnIMBinaryCallbackData paramAnIMBinaryCallbackData);
  
  public native void receivedMessage(AnIMMessageCallbackData paramAnIMMessageCallbackData);
  
  public native void receivedNotice(AnIMNoticeCallbackData paramAnIMNoticeCallbackData);
  
  public native void receivedReadACK(AnIMReadACKCallbackData paramAnIMReadACKCallbackData);
  
  public native void receivedReceiveACK(AnIMReceiveACKCallbackData paramAnIMReceiveACKCallbackData);
  
  public native void receivedTopicBinary(AnIMTopicBinaryCallbackData paramAnIMTopicBinaryCallbackData);
  
  public native void receivedTopicMessage(AnIMTopicMessageCallbackData paramAnIMTopicMessageCallbackData);
  
  @Deprecated
  public native void removeClientsFromTopic(AnIMRemoveClientsCallbackData paramAnIMRemoveClientsCallbackData);
  
  @Deprecated
  public native void removeTopic(AnIMRemoveTopicCallbackData paramAnIMRemoveTopicCallbackData);
  
  public native void statusUpdate(AnIMStatusUpdateCallbackData paramAnIMStatusUpdateCallbackData);
  
  @Deprecated
  public native void unbindAnPushService(AnIMUnbindAnPushServiceCallbackData paramAnIMUnbindAnPushServiceCallbackData);
  
  @Deprecated
  public native void updateTopic(AnIMUpdateTopicCallbackData paramAnIMUpdateTopicCallbackData);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMCallbackAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */