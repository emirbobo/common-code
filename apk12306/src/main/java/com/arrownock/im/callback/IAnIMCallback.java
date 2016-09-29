package com.arrownock.im.callback;

public abstract interface IAnIMCallback
{
  @Deprecated
  public abstract void addClientsToTopic(AnIMAddClientsCallbackData paramAnIMAddClientsCallbackData);
  
  @Deprecated
  public abstract void bindAnPushService(AnIMBindAnPushServiceCallbackData paramAnIMBindAnPushServiceCallbackData);
  
  @Deprecated
  public abstract void createTopic(AnIMCreateTopicCallbackData paramAnIMCreateTopicCallbackData);
  
  @Deprecated
  public abstract void getClientId(AnIMGetClientIdCallbackData paramAnIMGetClientIdCallbackData);
  
  @Deprecated
  public abstract void getClientsStatus(AnIMGetClientsStatusCallbackData paramAnIMGetClientsStatusCallbackData);
  
  public abstract void getSessionInfo(AnIMGetSessionInfoCallbackData paramAnIMGetSessionInfoCallbackData);
  
  @Deprecated
  public abstract void getTopicInfo(AnIMGetTopicInfoCallbackData paramAnIMGetTopicInfoCallbackData);
  
  @Deprecated
  public abstract void getTopicList(AnIMGetTopicListCallbackData paramAnIMGetTopicListCallbackData);
  
  public abstract void messageSent(AnIMMessageSentCallbackData paramAnIMMessageSentCallbackData);
  
  public abstract void receivedBinary(AnIMBinaryCallbackData paramAnIMBinaryCallbackData);
  
  public abstract void receivedMessage(AnIMMessageCallbackData paramAnIMMessageCallbackData);
  
  public abstract void receivedNotice(AnIMNoticeCallbackData paramAnIMNoticeCallbackData);
  
  public abstract void receivedReadACK(AnIMReadACKCallbackData paramAnIMReadACKCallbackData);
  
  public abstract void receivedReceiveACK(AnIMReceiveACKCallbackData paramAnIMReceiveACKCallbackData);
  
  public abstract void receivedTopicBinary(AnIMTopicBinaryCallbackData paramAnIMTopicBinaryCallbackData);
  
  public abstract void receivedTopicMessage(AnIMTopicMessageCallbackData paramAnIMTopicMessageCallbackData);
  
  @Deprecated
  public abstract void removeClientsFromTopic(AnIMRemoveClientsCallbackData paramAnIMRemoveClientsCallbackData);
  
  @Deprecated
  public abstract void removeTopic(AnIMRemoveTopicCallbackData paramAnIMRemoveTopicCallbackData);
  
  public abstract void statusUpdate(AnIMStatusUpdateCallbackData paramAnIMStatusUpdateCallbackData);
  
  @Deprecated
  public abstract void unbindAnPushService(AnIMUnbindAnPushServiceCallbackData paramAnIMUnbindAnPushServiceCallbackData);
  
  @Deprecated
  public abstract void updateTopic(AnIMUpdateTopicCallbackData paramAnIMUpdateTopicCallbackData);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\IAnIMCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */