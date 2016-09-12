package com.worklight.androidgap.jsonstore.util;

import com.bangcle.andjni.JniLib;
import java.util.HashMap;

public class Logger
{
  private static final HashMap<String, Logger> instances = new HashMap();
  private String tag;
  
  static
  {
    JniLib.a(Logger.class, 1163);
  }
  
  private Logger(String paramString)
  {
    this.tag = paramString;
  }
  
  public static native Logger getLogger(String paramString);
  
  public native boolean isLoggable(int paramInt);
  
  public native void logDebug(String paramString);
  
  public native void logDebug(String paramString, Throwable paramThrowable);
  
  public native void logError(String paramString);
  
  public native void logError(String paramString, Throwable paramThrowable);
  
  public native void logInfo(String paramString);
  
  public native void logInfo(String paramString, Throwable paramThrowable);
  
  public native void logWarning(String paramString);
  
  public native void logWarning(String paramString, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\util\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */