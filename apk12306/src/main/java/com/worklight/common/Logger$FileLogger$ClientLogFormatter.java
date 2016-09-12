package com.worklight.common;

import com.bangcle.andjni.JniLib;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class Logger$FileLogger$ClientLogFormatter
  extends Formatter
{
  static
  {
    JniLib.a(ClientLogFormatter.class, 1252);
  }
  
  public native String format(LogRecord paramLogRecord);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$FileLogger$ClientLogFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */