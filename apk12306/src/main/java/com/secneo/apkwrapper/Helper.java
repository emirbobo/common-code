package com.secneo.apkwrapper;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Helper
{
  public static String CPU_ABI = null;
  public static String PKGNAME;
  public static String PPATH = null;
  public static ClassLoader cl;
  
  static
  {
    PKGNAME = "com.MobileTicket";
  }
  
  public static native void attach(Application paramApplication, Context paramContext);
  
  public static String getCPUABI()
  {
    if (CPU_ABI == null) {}
    for (;;)
    {
      try
      {
        Object localObject2 = Runtime.getRuntime().exec("getprop ro.product.cpu.abi");
        Object localObject1 = new java/io/InputStreamReader;
        ((InputStreamReader)localObject1).<init>(((Process)localObject2).getInputStream());
        localObject2 = new java/io/BufferedReader;
        ((BufferedReader)localObject2).<init>((Reader)localObject1);
        if (((BufferedReader)localObject2).readLine().contains("x86"))
        {
          CPU_ABI = "x86";
          localObject1 = CPU_ABI;
          return (String)localObject1;
        }
        CPU_ABI = "arm";
        continue;
      }
      catch (Exception localException)
      {
        CPU_ABI = "arm";
        continue;
      }
      String str = CPU_ABI;
    }
  }
  
  public static String getRelease()
  {
    if (Build.VERSION.SDK_INT <= 10) {}
    for (String str = "2.2";; str = "4.0") {
      return str;
    }
  }
  
  public static void installApplicationEx(String paramString)
  {
    installApplicationEx(paramString, Helper.class);
  }
  
  public static native void installApplicationEx(String paramString, Class paramClass);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\secneo\apkwrapper\Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */