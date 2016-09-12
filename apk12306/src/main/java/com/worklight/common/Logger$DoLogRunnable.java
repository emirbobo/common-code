package com.worklight.common;

import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

class Logger$DoLogRunnable
  implements Runnable
{
  private JSONObject additionalMetadata;
  private Logger.LEVEL calledLevel;
  private Logger logger;
  private String message;
  private Throwable t;
  private long timestamp;
  
  static
  {
    JniLib.a(DoLogRunnable.class, 1251);
  }
  
  public Logger$DoLogRunnable(Logger.LEVEL paramLEVEL, String paramString, long paramLong, JSONObject paramJSONObject, Throwable paramThrowable, Logger paramLogger)
  {
    this.calledLevel = paramLEVEL;
    this.message = paramString;
    this.timestamp = paramLong;
    this.additionalMetadata = paramJSONObject;
    this.t = paramThrowable;
    this.logger = paramLogger;
  }
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$DoLogRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */