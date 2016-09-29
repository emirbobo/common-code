package com.arrownock.im;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import ay;
import bh;
import bi;
import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.IAnIMCallback;
import com.arrownock.im.callback.IAnIMGetClientIdCallback;
import com.arrownock.im.callback.IAnIMGetClientsStatusCallback;
import com.arrownock.im.callback.IAnIMGetTopicInfoCallback;
import com.arrownock.im.callback.IAnIMGetTopicListCallback;
import com.arrownock.im.callback.IAnIMHistoryCallback;
import com.arrownock.im.callback.IAnIMPushBindingCallback;
import com.arrownock.im.callback.IAnIMPushNotificationSettingsCallback;
import com.arrownock.im.callback.IAnIMTopicCallback;
import com.bangcle.andjni.JniLib;
import f;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnIM
  implements bh
{
  private final long jdField_a_of_type_Long = Long.parseLong("1048576");
  private Context jdField_a_of_type_AndroidContentContext;
  private ay jdField_a_of_type_Ay = null;
  private IAnIMCallback jdField_a_of_type_ComArrownockImCallbackIAnIMCallback = null;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    JniLib.a(AnIM.class, 151);
  }
  
  public AnIM(Context paramContext)
    throws ArrownockException
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ay = new f();
    this.jdField_a_of_type_Ay.a(paramContext);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null) {
        setAppKey(paramContext.getString("com.arrownock.APP_KEY"));
      }
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        throw new ArrownockException("Invalid value of com.arrownock.APP_KEY", 1101);
      }
    }
    catch (Exception paramContext)
    {
      throw new ArrownockException("Failed to initialize SDK.", paramContext, 2101);
    }
  }
  
  public AnIM(Context paramContext, String paramString)
    throws ArrownockException
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ay = new f();
    this.jdField_a_of_type_Ay.a(paramContext);
    try
    {
      this.jdField_a_of_type_Ay.a(this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        throw new ArrownockException("Invalid value of com.arrownock.APP_KEY", 1101);
      }
    }
    catch (Exception paramContext)
    {
      throw new ArrownockException("Failed to initialize SDK.", paramContext, 2101);
    }
  }
  
  private native void a(String paramString1, String paramString2, int paramInt1, Map<String, String> paramMap, int paramInt2);
  
  public native void addClientsToTopic(String paramString, Set<String> paramSet)
    throws ArrownockException;
  
  public native void addClientsToTopic(String paramString, Set<String> paramSet, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public native void bindAnPushService(String paramString1, String paramString2)
    throws ArrownockException;
  
  public native void bindAnPushService(String paramString1, String paramString2, AnPushType paramAnPushType)
    throws ArrownockException;
  
  public native void bindAnPushService(String paramString1, String paramString2, String paramString3)
    throws ArrownockException;
  
  public native void bindAnPushService(String paramString1, String paramString2, String paramString3, AnPushType paramAnPushType)
    throws ArrownockException;
  
  public native void bindAnPushService(String paramString1, String paramString2, String paramString3, IAnIMPushBindingCallback paramIAnIMPushBindingCallback);
  
  public native void connect(String paramString)
    throws ArrownockException;
  
  public native void createSession(List<String> paramList, String paramString);
  
  public native void createTopic(String paramString)
    throws ArrownockException;
  
  public native void createTopic(String paramString, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public native void createTopic(String paramString1, String paramString2, Set<String> paramSet)
    throws ArrownockException;
  
  public native void createTopic(String paramString1, String paramString2, Set<String> paramSet, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public native void createTopic(String paramString, Set<String> paramSet)
    throws ArrownockException;
  
  public native void createTopic(String paramString, Set<String> paramSet, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public native void disablePushNotificationForTopics(String paramString, List<String> paramList, IAnIMPushNotificationSettingsCallback paramIAnIMPushNotificationSettingsCallback);
  
  public native void disconnect()
    throws ArrownockException;
  
  public native void enablePushNotificationForTopics(String paramString, List<String> paramList, IAnIMPushNotificationSettingsCallback paramIAnIMPushNotificationSettingsCallback);
  
  public native void getClientId(String paramString)
    throws ArrownockException;
  
  public native void getClientId(String paramString, IAnIMGetClientIdCallback paramIAnIMGetClientIdCallback);
  
  public native void getClientsStatus(String paramString)
    throws ArrownockException;
  
  public native void getClientsStatus(String paramString, IAnIMGetClientsStatusCallback paramIAnIMGetClientsStatusCallback);
  
  public native void getClientsStatus(Set<String> paramSet)
    throws ArrownockException;
  
  public native void getClientsStatus(Set<String> paramSet, IAnIMGetClientsStatusCallback paramIAnIMGetClientsStatusCallback);
  
  public native AnIMStatus getCurrentStatus();
  
  public native void getFullTopicHistory(String paramString, int paramInt, long paramLong, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getFullTopicHistory(String paramString1, String paramString2, int paramInt, long paramLong, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getHistory(Set<String> paramSet, String paramString, int paramInt, long paramLong, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getMyTopicList()
    throws ArrownockException;
  
  public native void getOfflineHistory(String paramString, int paramInt, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getOfflineHistory(String paramString1, String paramString2, int paramInt, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getOfflineHistory(Set<String> paramSet, String paramString, int paramInt, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getOfflineTopicHistory(String paramString, int paramInt, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getOfflineTopicHistory(String paramString1, String paramString2, int paramInt, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native String getPartyId();
  
  public native String getRemoteClientId(String paramString);
  
  public native void getSessionInfo(String paramString)
    throws ArrownockException;
  
  public native void getTopicHistory(String paramString1, String paramString2, int paramInt, long paramLong, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public native void getTopicInfo(String paramString)
    throws ArrownockException;
  
  public native void getTopicInfo(String paramString, IAnIMGetTopicInfoCallback paramIAnIMGetTopicInfoCallback);
  
  public native void getTopicList()
    throws ArrownockException;
  
  public native void getTopicList(IAnIMGetTopicListCallback paramIAnIMGetTopicListCallback);
  
  public native void getTopicList(String paramString, IAnIMGetTopicListCallback paramIAnIMGetTopicListCallback);
  
  @Deprecated
  public native void getTopicLog(String paramString, Date paramDate1, Date paramDate2);
  
  public native boolean isOnline();
  
  public native boolean isSecureConnection();
  
  public native void removeClientsFromTopic(String paramString, Set<String> paramSet)
    throws ArrownockException;
  
  public native void removeClientsFromTopic(String paramString, Set<String> paramSet, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public native void removeTopic(String paramString)
    throws ArrownockException;
  
  public native void removeTopic(String paramString, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public native void sendAnswer(String paramString1, String paramString2, int paramInt);
  
  public native String sendBinary(String paramString1, byte[] paramArrayOfByte, String paramString2)
    throws ArrownockException;
  
  public native String sendBinary(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendBinary(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendBinary(String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendBinary(Set<String> paramSet, byte[] paramArrayOfByte, String paramString)
    throws ArrownockException;
  
  public native String sendBinary(Set<String> paramSet, byte[] paramArrayOfByte, String paramString, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendBinary(Set<String> paramSet, byte[] paramArrayOfByte, String paramString, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendBinary(Set<String> paramSet, byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendBinaryToTopic(String paramString1, byte[] paramArrayOfByte, String paramString2)
    throws ArrownockException;
  
  public native String sendBinaryToTopic(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendBinaryToTopic(String paramString1, byte[] paramArrayOfByte, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendBinaryToTopic(String paramString1, byte[] paramArrayOfByte, String paramString2, boolean paramBoolean)
    throws ArrownockException;
  
  public native void sendHangup(List<String> paramList);
  
  public native void sendICECandidate(String paramString1, String paramString2);
  
  public native void sendInvitations(String paramString1, List<String> paramList, String paramString2, Map<String, String> paramMap);
  
  public native String sendMessage(String paramString1, String paramString2)
    throws ArrownockException;
  
  public native String sendMessage(String paramString1, String paramString2, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendMessage(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendMessage(String paramString1, String paramString2, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendMessage(Set<String> paramSet, String paramString)
    throws ArrownockException;
  
  public native String sendMessage(Set<String> paramSet, String paramString, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendMessage(Set<String> paramSet, String paramString, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendMessage(Set<String> paramSet, String paramString, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2, List<String> paramList)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2, Map<String, String> paramMap, List<String> paramList)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean, List<String> paramList)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendMessageToTopic(String paramString1, String paramString2, boolean paramBoolean, List<String> paramList)
    throws ArrownockException;
  
  public native String sendNotice(Set<String> paramSet, String paramString)
    throws ArrownockException;
  
  public native String sendNotice(Set<String> paramSet, String paramString, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendNotice(Set<String> paramSet, String paramString, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendNotice(Set<String> paramSet, String paramString, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendNoticeToTopic(String paramString1, String paramString2)
    throws ArrownockException;
  
  public native String sendNoticeToTopic(String paramString1, String paramString2, Map<String, String> paramMap)
    throws ArrownockException;
  
  public native String sendNoticeToTopic(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean)
    throws ArrownockException;
  
  public native String sendNoticeToTopic(String paramString1, String paramString2, boolean paramBoolean)
    throws ArrownockException;
  
  public native void sendOffer(String paramString1, String paramString2, int paramInt);
  
  public native String sendReadACK(String paramString1, String paramString2)
    throws ArrownockException;
  
  public native String sendReadACK(Set<String> paramSet, String paramString)
    throws ArrownockException;
  
  public native void setAppKey(String paramString);
  
  public native void setCallback(IAnIMCallback paramIAnIMCallback);
  
  public native void setCallbacks(bi parambi);
  
  public native void setHosts(String paramString1, String paramString2);
  
  public native void setPushNotificationForChatSession(String paramString, boolean paramBoolean, IAnIMPushNotificationSettingsCallback paramIAnIMPushNotificationSettingsCallback);
  
  public native void setPushNotificationForMentioning(String paramString, boolean paramBoolean, IAnIMPushNotificationSettingsCallback paramIAnIMPushNotificationSettingsCallback);
  
  public native void setPushNotificationForNotice(String paramString, boolean paramBoolean, IAnIMPushNotificationSettingsCallback paramIAnIMPushNotificationSettingsCallback);
  
  public native void setPushNotificationForTopic(String paramString, boolean paramBoolean, IAnIMPushNotificationSettingsCallback paramIAnIMPushNotificationSettingsCallback);
  
  public native void setSecureConnection(boolean paramBoolean);
  
  public native void terminateSession(String paramString);
  
  public native void unbindAnPushService()
    throws ArrownockException;
  
  public native void unbindAnPushService(String paramString)
    throws ArrownockException;
  
  public native void unbindAnPushService(String paramString, IAnIMPushBindingCallback paramIAnIMPushBindingCallback);
  
  public native void updateTopic(String paramString1, String paramString2, String paramString3)
    throws ArrownockException;
  
  public native void updateTopic(String paramString1, String paramString2, String paramString3, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public native void validateSession(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\AnIM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */