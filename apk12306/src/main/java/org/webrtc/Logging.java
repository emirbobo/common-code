package org.webrtc;

import java.util.EnumSet;
import java.util.Iterator;

public class Logging
{
  static
  {
    System.loadLibrary("Arrownock");
  }
  
  public static void enableTracing(String paramString, EnumSet<Logging.TraceLevel> paramEnumSet, Logging.Severity paramSeverity)
  {
    paramEnumSet = paramEnumSet.iterator();
    for (int i = 0; paramEnumSet.hasNext(); i = ((Logging.TraceLevel)paramEnumSet.next()).level | i) {}
    nativeEnableTracing(paramString, i, paramSeverity.ordinal());
  }
  
  private static native void nativeEnableTracing(String paramString, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */