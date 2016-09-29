package com.bangcle.everisk.shell;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class LibProc
{
  public static boolean A = true;
  private static SharedPreferences B = null;
  private static String C = "n_dl";
  private static String D = "n_dl0";
  private static String E = "n_dl1";
  public static Context y = null;
  public static boolean z = false;
  
  public LibProc()
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>("/data/local/tmp/riskd");
      if (localFile.exists()) {
        z = true;
      }
      localFile = new java/io/File;
      localFile.<init>("/data/local/tmp/riskd_notupdate");
      if (localFile.exists())
      {
        A = false;
        a("RiskStub.update", "not need update by /data/local/tmp/riskd_notupdate");
      }
      B = y.getSharedPreferences(C, 0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a(localException);
      }
    }
  }
  
  public static void a(Exception paramException)
  {
    try
    {
      if (y == null) {}
      for (;;)
      {
        return;
        if (z)
        {
          a("RiskStubShell.Debug", "begin debug");
          paramException.printStackTrace();
        }
        Object localObject2 = paramException.getMessage();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "_no_msg_";
        }
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>();
        ((JSONObject)localObject2).put("reason", localObject1);
        StringWriter localStringWriter = new java/io/StringWriter;
        localStringWriter.<init>();
        localObject1 = new java/io/PrintWriter;
        ((PrintWriter)localObject1).<init>(localStringWriter);
        paramException.printStackTrace((PrintWriter)localObject1);
        ((JSONObject)localObject2).put("stack", localStringWriter.toString());
        ((JSONObject)localObject2).put("loader_ver", "23");
        paramException = new java/lang/StringBuilder;
        paramException.<init>("from ");
        ((JSONObject)localObject2).put("extra", "risk");
        ((JSONObject)localObject2).put("time", System.currentTimeMillis());
        B.edit().putString(E, ((JSONObject)localObject2).toString()).commit();
        a("RiskStub.Crash", "save loader crash");
      }
    }
    catch (Exception paramException)
    {
      for (;;) {}
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (z) {
      Log.i(paramString1, paramString2);
    }
  }
  
  private static String s()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    File localFile = new File("/data/local/tmp/riskd_config");
    byte[] arrayOfByte = new byte['Ѐ'];
    String str2 = "";
    Object localObject = str2;
    String str1;
    if (localFile.exists())
    {
      a("RiskStub.Init", "read config from local files:" + "/data/local/tmp/riskd_config");
      try
      {
        localObject = new java/io/FileInputStream;
        ((FileInputStream)localObject).<init>(localFile);
        for (;;)
        {
          int i = ((InputStream)localObject).read(arrayOfByte, 0, 1024);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        return str1;
      }
      catch (Exception localException)
      {
        a(localException);
        str1 = str2;
      }
    }
    for (;;)
    {
      str1 = localByteArrayOutputStream.toString("utf-8");
    }
  }
  
  public void load_in(Context paramContext)
  {
    y = paramContext;
  }
  
  public final void r()
  {
    int j = 1;
    try
    {
      if (y == null) {
        return;
      }
      localObject1 = B.getString(D, "");
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("load from sharedp=");
      a("RiskStub.loader", (String)localObject1);
      localObject2 = s();
      if (!((String)localObject2).equals(""))
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("load from file=");
        a("RiskStub.loader", (String)localObject2);
        localObject1 = localObject2;
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new org/json/JSONObject;
          ((JSONObject)localObject2).<init>((String)localObject1);
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("load config ");
          a("RiskStub.loader", ((JSONObject)localObject2).toString(4));
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("delay before json t1=");
          a("RiskStub.loader", Conf.h + "\tt2=" + Conf.i);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          Object localObject2;
          Conf.h = ((JSONObject)localObject2).getInt("t1");
          Conf.i = ((JSONObject)localObject2).getInt("t2");
          Object localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("delay after json t1=");
          a("RiskStub.loader", Conf.h + "\tt2=" + Conf.i);
          localObject1 = new Random();
          int k = Conf.i - Conf.h;
          int i = k;
          if (k <= 0) {
            i = 1;
          }
          i = ((Random)localObject1).nextInt(i) + Conf.h;
          Log.i("RiskStub.Final", "delay sleep:" + i);
          if (z)
          {
            i = j;
            long l = i;
            try
            {
              Thread.sleep(l);
            }
            catch (InterruptedException localInterruptedException) {}
          }
        }
        catch (Exception localException1)
        {
          a(localException1);
          continue;
          localException2 = localException2;
          a(localException2);
        }
        catch (JSONException localJSONException)
        {
          continue;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\shell\LibProc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */