package com.tl.uic;

import android.os.Handler;
import com.bangcle.andjni.JniLib;
import com.tl.uic.model.ClientMessageHeader;
import com.tl.uic.model.JSONMessage;
import com.tl.uic.model.MessageFormat;
import com.tl.uic.model.Session;
import com.tl.uic.model.TLFCacheFile;
import com.tl.uic.util.PostTask;
import java.util.List;
import java.util.TimerTask;

public final class TLFCache
{
  private static final int PERCENT = 100;
  private static Session _currentSession;
  private static long _currentSessionStartedDate;
  private static int _messageVersion = 0;
  private static volatile TLFCache _myInstance;
  private static PostTask _postTask;
  private static TimerTask _postTimerTask;
  private static long currentBufferSize;
  private static String currentSessionId;
  private static EnvironmentalData environmentalData;
  private static int logLevel;
  
  static
  {
    JniLib.a(TLFCache.class, 1086);
    currentBufferSize = 0L;
  }
  
  private static native Boolean addJSONMessage(JSONMessage paramJSONMessage);
  
  public static native Boolean addMessage(ClientMessageHeader paramClientMessageHeader);
  
  public static native Boolean addMessage(String paramString);
  
  private static native void cleanByCacheLevel();
  
  public static native Boolean closePostTask();
  
  private static native MessageFormat createMessageFormat();
  
  private static native String createSessionId();
  
  private static native void flushPostTask();
  
  public static native int getBufferLimit();
  
  public static native int getBufferPercent();
  
  public static native int getCacheLevel();
  
  public static native long getCachedFileMaxBytesSize();
  
  public static native long getCurrentBufferSize();
  
  public static native String getCurrentSessionId();
  
  public static native EnvironmentalData getEnvironmentalData();
  
  public static native Boolean getHasToPersistLocalCache();
  
  public static native TLFCache getInstance();
  
  public static native int getLogLevel();
  
  public static native List<JSONMessage> getMessages();
  
  public static native long getPostMessageMaxBytesSize();
  
  public static native long getTLFCacheFileMaxBytesSize();
  
  public static native List<TLFCacheFile> messageFormats();
  
  public static native Boolean onPause();
  
  public static native Boolean onResume();
  
  public static native Boolean saveToCache(Boolean paramBoolean);
  
  public static native void setCurrentLogLevel(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3);
  
  private static native void setupPostTask();
  
  public static native long sizeOfObject(Object paramObject);
  
  public static native Boolean startSession(String paramString);
  
  public static native Boolean terminate();
  
  public static native long timestampFromSession();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\TLFCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */