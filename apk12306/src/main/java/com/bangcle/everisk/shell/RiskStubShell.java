package com.bangcle.everisk.shell;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.util.Log;
import com.bangcle.everisk.utils_l.e;
import com.bangcle.everisk.utils_l.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONObject;

public class RiskStubShell
{
  public static SharedPreferences B = null;
  private static boolean I = false;
  private static Context J = null;
  private static int K = 0;
  static String L = null;
  static String M = "";
  private static a N = null;
  private static a O = null;
  private static a P = null;
  private static a Q = null;
  private static a R = null;
  
  public static String GetRiskSDKParam()
  {
    Object localObject = null;
    try
    {
      String str = B.getString("risk_sdk_param", Conf.j);
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return (String)localObject;
  }
  
  public static boolean RiskSDK(String paramString)
  {
    try
    {
      bool = b.RiskSDK(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  private static boolean c(a parama)
  {
    bool = false;
    try
    {
      Object localObject = J.getAssets().open("RiskStub");
      byte[] arrayOfByte = new byte[((InputStream)localObject).available()];
      ((InputStream)localObject).read(arrayOfByte);
      localObject = new java/io/FileOutputStream;
      File localFile = new java/io/File;
      localFile.<init>(parama.i());
      ((FileOutputStream)localObject).<init>(localFile);
      ((OutputStream)localObject).write(arrayOfByte);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      if (e.c(M + "/lib/libRiskStub.so", parama.j())) {
        break label155;
      }
      LibProc.a("RiskStubShell.InitFirstTime", "ERROR: COPY inside cFile Failed:" + parama.j());
    }
    catch (FileNotFoundException parama)
    {
      for (;;)
      {
        LibProc.a("RiskStubShell.ExtractDexFromResToStoragePath", parama.getMessage());
        LibProc.a(parama);
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        LibProc.a("RiskStubShell.ExtractDexFromResToStoragePath", parama.getMessage());
        LibProc.a(parama);
        continue;
        bool = true;
      }
    }
    return bool;
  }
  
  public static void x()
  {
    LibProc.y = J;
    Object localObject1 = new LibProc();
    B = J.getSharedPreferences("RiskStubLoader", 0);
    int i;
    if (Conf.f == Conf.g + 4096)
    {
      LibProc.a("RiskStubShell.CheckEnv", "ERROR: AgentID INVALID!" + Conf.f);
      i = 0;
      if (i != 0) {
        break label349;
      }
    }
    for (;;)
    {
      return;
      if (B == null)
      {
        LibProc.a("RiskStubShell.CheckEnv", "ERROR: prefs is NULL!");
        i = 0;
        break;
      }
      i = Build.VERSION.SDK_INT;
      K = i;
      if (i < 14)
      {
        LibProc.a("RiskStub.CheckEnv", "sdkVersion: {" + K + "} < {14" + "}");
        i = 0;
        break;
      }
      Object localObject3 = e.c(J);
      if (((String)localObject3).equals(""))
      {
        LibProc.a("RiskStub.CheckEnv", "StoragePath error, is \"\"");
        i = 0;
        break;
      }
      localObject3 = ((String)localObject3).substring(0, ((String)localObject3).length() - 6);
      M = (String)localObject3;
      localObject3 = e.f((String)localObject3);
      L = (String)localObject3;
      if ((!((String)localObject3).equals("armeabi")) && (!L.equals("armeabi-v7a")) && (!L.equals("x86")))
      {
        LibProc.a("RiskStub.CheckEnv", "abi error, is " + L);
        i = 0;
        break;
      }
      LibProc.a("RiskStubShell.CheckEnv", "StorageRoot: <" + M + ">, sdkVer:" + K + ", abi:" + L);
      localObject3 = new f("start", 60L, 900L, 3600L);
      while (!a.b(J)) {
        ((f)localObject3).G();
      }
      i = 1;
      break;
      label349:
      LibProc.a("RiskStub.Final", "start by version: 23");
      ((LibProc)localObject1).r();
      localObject1 = M + "/RiskStub";
      label539:
      f localf;
      int j;
      if (new File((String)localObject1).exists())
      {
        N = new a(B.getString("ver_a", ""));
        O = new a(B.getString("ver_b", ""));
        if ((!N.h()) && (!O.h()))
        {
          e.c((String)localObject1);
          if (!B.getBoolean("inside_ver", false))
          {
            B.edit().putBoolean("inside_ver", true).commit();
            localObject1 = y();
            N = (a)localObject1;
            if ((((a)localObject1).h()) && (N.a(true))) {
              break label836;
            }
            LibProc.a("RiskStubShell.InitFirstTime", "ERROR: ReadConfigFromRes Failed!");
          }
          N.b(false);
          N.a(L, false, false);
          if ((!LibProc.z) && ((!N.w) || (!N.v))) {
            N.l();
          }
          O.b(false);
          O.a(L, false, false);
          if ((!O.w) || (!O.v)) {
            O.l();
          }
          localf = new f("loader", 1800L, 86400L, 86400L);
          j = 5;
          label656:
          if (j <= 0) {
            break label1739;
          }
          i = j;
        }
      }
      for (;;)
      {
        try
        {
          if (!a.c()) {
            continue;
          }
          if (!Conf.b()) {
            continue;
          }
          R = N;
          bool = true;
          i = j;
          if (!bool) {
            continue;
          }
          N.a("VerA");
          O.a("VerB");
          if (!R.a(N)) {
            continue;
          }
          Q = N;
          P = O;
        }
        catch (Exception localException)
        {
          boolean bool;
          label836:
          LibProc.a(localException);
          i = j - 1;
          continue;
          if (!N.m()) {
            continue;
          }
          P = N;
          R.a(false);
          Q = R;
          continue;
          P = O;
          R.a(true);
          continue;
          if ((!LibProc.A) || (Conf.b()) || (!R.n())) {
            continue;
          }
          Q.a("before update");
          Q.q();
          Object localObject2 = Q;
          ((a)localObject2).a("ToUpdateVerion");
          localObject3 = a.f();
          Object localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          localObject4 = (String)localObject3 + "/plugin/c/" + ((a)localObject2).m + "/" + L + "/RiskStub";
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localObject3 = (String)localObject3 + "/plugin/java/" + ((a)localObject2).n + "/RiskStub";
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("CLibUrl: <");
          LibProc.a("RiskStubShell.UpdateLib", (String)localObject4);
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("JLibUrl: <");
          LibProc.a("RiskStubShell.UpdateLib", (String)localObject3);
          if (!((a)localObject2).v) {
            continue;
          }
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>("has Update C Lib to ");
          LibProc.a("RiskStub.Final", ((a)localObject2).m);
          if (!((a)localObject2).w) {
            continue;
          }
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>("has Update J Lib to ");
          LibProc.a("RiskStub.Final", ((a)localObject2).n);
          i = 1;
          if (i != 0) {
            continue;
          }
          P = null;
          continue;
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("Begin update C Lib to ");
          LibProc.a("RiskStub.Final", ((a)localObject2).m);
          if (e.a((String)localObject4, ((a)localObject2).k(), -1) != null) {
            continue;
          }
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>("ERROR: Download <");
          LibProc.a("RiskStubShell.UpdateLib", ((a)localObject2).k() + "> Failed!");
          i = 0;
          continue;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>("Update Java Lib ");
          LibProc.a("RiskStub.Final", ((a)localObject2).n);
          if (e.a((String)localObject3, ((a)localObject2).i(), -1) != null) {
            continue;
          }
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("ERROR: Download <");
          LibProc.a("RiskStubShell.UpdateLib", (String)localObject3 + "> Failed!");
          i = 0;
          continue;
          Q.b(true);
          Q.a(L, true, true);
          if ((Q.w) && (Q.v) && (Q.p())) {
            continue;
          }
          Q.l();
          continue;
          Q.c(true);
          P.c(false);
          P = Q;
          continue;
          if (R.o()) {
            continue;
          }
          P = null;
          continue;
          if (b.a(J, P.i(), P.j())) {
            break label1739;
          }
          P.l();
          i = j;
          continue;
        }
        Q.b(R);
        if (!Q.g()) {
          continue;
        }
        P = Q;
        if ((P != null) && (P.g())) {
          continue;
        }
        LibProc.a("RiskStubShell.Loader", "no available plugin to start, wait");
        i = j;
        localf.G();
        j = i;
        break label656;
        N.a(true);
        O.a(false);
        break;
        N = new a("");
        O = new a("");
        break;
        if (!c(N)) {
          break label539;
        }
        N.c(true);
        break label539;
        localObject4 = a.f();
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localObject1 = (String)localObject4 + "/plugin/" + Conf.f + "/version";
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("VersionURL: <");
        LibProc.a("RiskStubShell.UpdateLib", (String)localObject1 + ">");
        localObject3 = e.a((String)localObject1, -1);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          LibProc.a("RiskStubShell.UpdateLib", "try getRemoteVersions by default");
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject3 = e.a((String)localObject4 + "/plugin/version", -1);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            LibProc.a("RiskStubShell.UpdateLib", "ERROR: getRemoteVersions Failed!");
            bool = false;
            continue;
          }
        }
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("VersionsString from network: <");
        LibProc.a("RiskStubShell.UpdateLib", (String)localObject1 + ">");
        localObject3 = new com/bangcle/everisk/shell/a;
        ((a)localObject3).<init>((String)localObject1);
        R = (a)localObject3;
        bool = ((a)localObject3).h();
        continue;
        if (!R.a(O)) {
          continue;
        }
        Q = O;
        P = N;
      }
      label1739:
      b.w();
    }
  }
  
  /* Error */
  private static a y()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 26	com/bangcle/everisk/shell/RiskStubShell:J	Landroid/content/Context;
    //   5: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: ldc_w 444
    //   11: invokevirtual 91	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 97	java/io/InputStream:available	()I
    //   19: newarray <illegal type>
    //   21: astore_1
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 101	java/io/InputStream:read	([B)I
    //   27: pop
    //   28: new 107	com/bangcle/everisk/shell/a
    //   31: astore_0
    //   32: new 211	java/lang/String
    //   35: astore 4
    //   37: aload 4
    //   39: aload_1
    //   40: invokespecial 446	java/lang/String:<init>	([B)V
    //   43: aload_0
    //   44: aload 4
    //   46: invokespecial 277	com/bangcle/everisk/shell/a:<init>	(Ljava/lang/String;)V
    //   49: aload_3
    //   50: invokevirtual 447	java/io/InputStream:close	()V
    //   53: aload_0
    //   54: astore_1
    //   55: aload_0
    //   56: ifnonnull +13 -> 69
    //   59: new 107	com/bangcle/everisk/shell/a
    //   62: dup
    //   63: ldc 32
    //   65: invokespecial 277	com/bangcle/everisk/shell/a:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: aload_2
    //   73: astore_0
    //   74: aload_1
    //   75: invokestatic 166	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   78: goto -25 -> 53
    //   81: astore_1
    //   82: goto -8 -> 74
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_0
    //   88: goto -35 -> 53
    //   91: astore_1
    //   92: goto -39 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	43	0	localObject1	Object
    //   85	1	0	localFileNotFoundException1	FileNotFoundException
    //   87	1	0	localObject2	Object
    //   21	49	1	localObject3	Object
    //   71	4	1	localException1	Exception
    //   81	1	1	localException2	Exception
    //   91	1	1	localFileNotFoundException2	FileNotFoundException
    //   1	72	2	localObject4	Object
    //   14	36	3	localInputStream	InputStream
    //   35	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	49	71	java/lang/Exception
    //   49	53	81	java/lang/Exception
    //   2	49	85	java/io/FileNotFoundException
    //   49	53	91	java/io/FileNotFoundException
  }
  
  public void InitIAPSDK(Context paramContext)
  {
    Log.d("RiskStubShell.SDKFee", "RiskStubShell called");
    Conf.a();
  }
  
  public void InitIAPSDKFee(Context paramContext)
  {
    Log.d("RiskStubShell.SDKFee", "InitIAPSDKFee  called");
    load_in(paramContext);
  }
  
  public void SetKeyIAPSDK(String paramString)
  {
    LibProc.a("RiskStubShell.SDKFee", " SetKeyIAPSDK called, key:" + paramString);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "user_data");
      localJSONObject.put("data", paramString);
      b.RiskSDK(localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LibProc.a(paramString);
      }
    }
  }
  
  /* Error */
  public void load_in(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 24	com/bangcle/everisk/shell/RiskStubShell:I	Z
    //   6: ifeq +7 -> 13
    //   9: ldc 2
    //   11: monitorexit
    //   12: return
    //   13: iconst_1
    //   14: putstatic 24	com/bangcle/everisk/shell/RiskStubShell:I	Z
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_1
    //   21: invokevirtual 488	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: putstatic 26	com/bangcle/everisk/shell/RiskStubShell:J	Landroid/content/Context;
    //   27: new 490	java/lang/Thread
    //   30: astore_2
    //   31: new 492	com/bangcle/everisk/shell/c
    //   34: astore_1
    //   35: aload_1
    //   36: aload_0
    //   37: invokespecial 495	com/bangcle/everisk/shell/c:<init>	(Lcom/bangcle/everisk/shell/RiskStubShell;)V
    //   40: aload_2
    //   41: aload_1
    //   42: invokespecial 498	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   45: aload_2
    //   46: invokevirtual 500	java/lang/Thread:start	()V
    //   49: goto -37 -> 12
    //   52: astore_1
    //   53: goto -41 -> 12
    //   56: astore_1
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	RiskStubShell
    //   0	62	1	paramContext	Context
    //   30	16	2	localThread	Thread
    // Exception table:
    //   from	to	target	type
    //   0	3	52	java/lang/Exception
    //   20	49	52	java/lang/Exception
    //   57	62	52	java/lang/Exception
    //   3	12	56	finally
    //   13	20	56	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\shell\RiskStubShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */