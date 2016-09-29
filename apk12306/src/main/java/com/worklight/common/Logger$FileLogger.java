package com.worklight.common;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.json.JSONObject;

class Logger$FileLogger
  extends Logger
{
  private static String filePath;
  private static ClientLogFormatter formatter;
  private static FileLogger singleton;
  
  static
  {
    JniLib.a(FileLogger.class, 1253);
  }
  
  protected Logger$FileLogger(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public static native void log(JSONObject paramJSONObject)
    throws SecurityException, IOException;
  
  public native void log(LogRecord paramLogRecord);
  
  private static class ClientLogFormatter
    extends Formatter
  {
    static
    {
      JniLib.a(ClientLogFormatter.class, 1252);
    }
    
    public native String format(LogRecord paramLogRecord);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$FileLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */