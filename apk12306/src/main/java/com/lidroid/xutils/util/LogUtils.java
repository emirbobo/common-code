package com.lidroid.xutils.util;

import com.bangcle.andjni.JniLib;

public class LogUtils
{
  public static boolean allowD = true;
  public static boolean allowE = true;
  public static boolean allowI = true;
  public static boolean allowV = true;
  public static boolean allowW = true;
  public static boolean allowWtf = true;
  public static CustomLogger customLogger;
  public static String customTagPrefix;
  
  static
  {
    JniLib.a(LogUtils.class, 1023);
    customTagPrefix = "";
  }
  
  public static native void d(String paramString);
  
  public static native void d(String paramString, Throwable paramThrowable);
  
  public static native void e(String paramString);
  
  public static native void e(String paramString, Throwable paramThrowable);
  
  private static native String generateTag(StackTraceElement paramStackTraceElement);
  
  public static native void i(String paramString);
  
  public static native void i(String paramString, Throwable paramThrowable);
  
  public static native void v(String paramString);
  
  public static native void v(String paramString, Throwable paramThrowable);
  
  public static native void w(String paramString);
  
  public static native void w(String paramString, Throwable paramThrowable);
  
  public static native void w(Throwable paramThrowable);
  
  public static native void wtf(String paramString);
  
  public static native void wtf(String paramString, Throwable paramThrowable);
  
  public static native void wtf(Throwable paramThrowable);
  
  public static abstract interface CustomLogger
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void w(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void w(String paramString, Throwable paramThrowable);
    
    public abstract void wtf(String paramString1, String paramString2);
    
    public abstract void wtf(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void wtf(String paramString, Throwable paramThrowable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\LogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */