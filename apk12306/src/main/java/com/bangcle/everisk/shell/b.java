package com.bangcle.everisk.shell;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.json.JSONObject;

public final class b
{
  private static DexClassLoader F = null;
  private static boolean G = false;
  private static LinkedList H = new LinkedList();
  
  public static boolean RiskSDK(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("receive RiskSDK=");
        LibProc.a("RiskStub.Final", paramString);
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        if ((!G) || (F == null)) {
          continue;
        }
        a((JSONObject)localObject);
        bool = true;
      }
      catch (Exception paramString)
      {
        LibProc.a(paramString);
        boolean bool = false;
        continue;
      }
      return bool;
      H.push(paramString);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = true;
    Object localObject2 = paramContext.getDir("RiskStub", 0);
    LibProc.a("RiskStubShell.CallRiskStubInit", "dexOutputDir: " + ((File)localObject2).getPath());
    try
    {
      Object localObject1 = new dalvik/system/DexClassLoader;
      ((DexClassLoader)localObject1).<init>(paramString1, ((File)localObject2).getPath(), null, paramContext.getClass().getClassLoader());
      F = (DexClassLoader)localObject1;
      localObject1 = ((DexClassLoader)localObject1).loadClass("com.bangcle.everisk.infs.LibProc");
      paramString1 = ((Class)localObject1).newInstance();
      localObject1 = ((Class)localObject1).getMethod("load_out", new Class[] { Context.class, JSONObject.class });
      LibProc.a("RiskStubShell.CallRiskStubInit", "getMethod: LibProc<load_out> OK!");
      localObject2 = new org/json/JSONObject;
      ((JSONObject)localObject2).<init>();
      ((JSONObject)localObject2).put("agent_id", Conf.f);
      ((JSONObject)localObject2).put("libpath", paramString2);
      paramString2 = new java/lang/StringBuilder;
      paramString2.<init>("HostMgr: SrvHost = ");
      LibProc.a("RiskStub.loader", Conf.d);
      ((JSONObject)localObject2).put("url_root", Conf.d);
      paramString2 = new java/lang/StringBuilder;
      paramString2.<init>("begin Call LibProc<load_out>:\n");
      LibProc.a("RiskStubShell.CallRiskStubInit", ((JSONObject)localObject2).toString(4));
      ((Method)localObject1).invoke(paramString1, new Object[] { paramContext, localObject2 });
      LibProc.a("RiskStubShell.CallRiskStubInit", "Call LibProc<load_out> OK");
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LibProc.a("RiskStubShell.CallRiskStubInit", "Call LibProc<load_out> ERROR, RESET!");
        LibProc.a(paramContext);
        bool = false;
      }
    }
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    try
    {
      Object localObject2 = F.loadClass("com.bangcle.everisk.infs.LibProc");
      Object localObject1 = ((Class)localObject2).newInstance();
      localObject2 = ((Class)localObject2).getMethod("risk_sdk", new Class[] { JSONObject.class });
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("Call com.bangcle.everisk.infs.LibProc.risk_sdk() : ");
      LibProc.a("RiskStub.CallRiskSdk", paramJSONObject.toString(4));
      ((Method)localObject2).invoke(localObject1, new Object[] { paramJSONObject });
      return bool;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        LibProc.a(paramJSONObject);
        bool = false;
      }
    }
  }
  
  private static String t()
  {
    StackTraceElement localStackTraceElement = Thread.currentThread().getStackTrace()[2];
    return localStackTraceElement.getClassName() + "." + localStackTraceElement.getMethodName() + ":" + localStackTraceElement.getLineNumber();
  }
  
  public static void u()
  {
    if (F == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject2 = F.loadClass("com.bangcle.everisk.stub.Action");
        Object localObject1 = ((Class)localObject2).getMethod("Ins", new Class[0]).invoke(null, new Object[0]);
        localObject2 = ((Class)localObject2).getMethod("AfterMsg", new Class[0]);
        LibProc.a("RiskStub.afterMsg", "Call com.bangcle.everisk.stub.Action.AfterMsg() : ");
        ((Method)localObject2).invoke(localObject1, new Object[0]);
      }
      catch (Exception localException)
      {
        LibProc.a(t(), localException.getMessage());
        LibProc.a(localException);
      }
    }
  }
  
  public static String v()
  {
    Object localObject1;
    if (F == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return (String)localObject1;
      try
      {
        Object localObject3 = F.loadClass("com.bangcle.everisk.stub.Action");
        localObject1 = ((Class)localObject3).getMethod("Ins", new Class[0]).invoke(null, new Object[0]);
        localObject3 = ((Class)localObject3).getMethod("GetMsg", new Class[0]);
        LibProc.a("RiskStub.getMsg", "Call com.bangcle.everisk.stub.Action.GetMsg() : ");
        localObject1 = (String)((Method)localObject3).invoke(localObject1, new Object[0]);
      }
      catch (Exception localException)
      {
        LibProc.a(t(), localException.getMessage());
        LibProc.a(localException);
        Object localObject2 = null;
      }
    }
  }
  
  public static void w()
  {
    while (!H.isEmpty())
    {
      String str = (String)H.poll();
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(str);
        a(localJSONObject);
      }
      catch (Exception localException)
      {
        LibProc.a("RiskStubShell.UpdateAndLoad", "new JSONObject ERROR, String x: <" + str + ">");
        LibProc.a(localException);
      }
    }
    G = true;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\shell\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */