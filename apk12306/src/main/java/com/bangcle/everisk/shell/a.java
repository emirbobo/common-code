package com.bangcle.everisk.shell;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bangcle.everisk.utils_l.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

public class a
{
  private JSONObject k = null;
  private String l = "";
  public int m = 0;
  public int n = 0;
  public int o;
  public int p;
  private String q = null;
  private String r = null;
  private String s = null;
  private boolean t = false;
  private boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  
  a(String paramString)
  {
    try
    {
      if (paramString.equals("")) {}
      for (;;)
      {
        return;
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        this.k = localJSONObject;
        if (!this.k.has("update_pct_1000")) {
          break;
        }
        i = this.k.getInt("update_pct_1000");
        this.o = i;
        if (!this.k.has("must_newest")) {
          break label244;
        }
        i = this.k.getInt("must_newest");
        this.p = i;
        this.m = this.k.getInt("c_ver");
        this.n = this.k.getInt("java_ver");
        if (this.k.has("is_use")) {
          bool = this.k.getBoolean("is_use");
        }
        this.t = bool;
        if (!this.k.has("status")) {
          break label249;
        }
        paramString = this.k.getString("status");
        this.l = paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LibProc.a(paramString);
        continue;
        int i = 0;
        continue;
        label244:
        i = 1;
        continue;
        label249:
        paramString = "init";
      }
    }
  }
  
  private static int a(int paramInt)
  {
    int i = 0;
    try
    {
      Class localClass = Class.forName(TelephonyManager.class.getName());
      Method localMethod = localClass.getMethod("getNetworkClass", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      paramInt = Integer.parseInt(String.valueOf(localMethod.invoke(localClass, new Object[] { Integer.valueOf(paramInt) })));
      return paramInt;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramInt = i;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        paramInt = i;
      }
    }
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        break label40;
      }
      paramContext = new java/lang/SecurityException;
      paramContext.<init>("Shell ConnectivityManager is null");
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      LibProc.a("RiskStubShell.NWUtils", paramContext.getMessage());
    }
    paramContext = null;
    for (;;)
    {
      label38:
      return paramContext;
      label40:
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext == null)
      {
        paramContext = new java/lang/SecurityException;
        paramContext.<init>("Shell NetworkInfo infos[] is null");
        throw paramContext;
      }
      int j = paramContext.length;
      for (int i = 0; i < j; i++)
      {
        Object localObject = paramContext[i];
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          if (((NetworkInfo)localObject).getType() == 1)
          {
            paramContext = "wifi";
            break label38;
          }
          if (((NetworkInfo)localObject).getType() == 0) {
            switch (a(((NetworkInfo)localObject).getSubtype()))
            {
            }
          }
        }
      }
      paramContext = "3g";
      continue;
      paramContext = "4g";
    }
  }
  
  public static String b(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject1 = new java/io/FileInputStream;
      ((FileInputStream)localObject1).<init>(paramString);
      paramString = new byte['Ѐ'];
      Object localObject2 = MessageDigest.getInstance("MD5");
      int j;
      do
      {
        j = ((InputStream)localObject1).read(paramString);
        if (j > 0) {
          ((MessageDigest)localObject2).update(paramString, 0, j);
        }
      } while (j != -1);
      ((InputStream)localObject1).close();
      localObject2 = ((MessageDigest)localObject2).digest();
      paramString = "";
      for (;;)
      {
        localObject1 = paramString;
        if (i >= localObject2.length) {
          break;
        }
        paramString = paramString + Integer.toString((localObject2[i] & 0xFF) + 256, 16).substring(1);
        i++;
      }
      return (String)localObject1;
    }
    catch (Exception paramString)
    {
      localObject1 = "";
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = a(paramContext);
    boolean bool1 = bool2;
    if (paramContext != null) {
      if ((!paramContext.equals("wifi")) && (!paramContext.equals("3g")))
      {
        bool1 = bool2;
        if (!paramContext.equals("4g")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c()
  {
    boolean bool = true;
    if ((!Conf.d.equals("")) && (!Conf.e.equals(""))) {}
    for (;;)
    {
      return bool;
      if (!d()) {
        if (e()) {
          bool = d();
        } else {
          bool = false;
        }
      }
    }
  }
  
  private static boolean d()
  {
    Object localObject2 = RiskStubShell.B;
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    String str1 = ((SharedPreferences)localObject2).getString("ip1", Conf.b);
    Object localObject1 = ((SharedPreferences)localObject2).getString("ip2", Conf.c);
    long l2 = ((SharedPreferences)localObject2).getLong(str1 + "_last_available_tm", 0L);
    long l1 = ((SharedPreferences)localObject2).getLong((String)localObject1 + "_last_available_tm", 0L);
    localObject2 = new ArrayList();
    label148:
    String str2;
    if (l2 >= l1)
    {
      ((List)localObject2).add(str1);
      ((List)localObject2).add(localObject1);
      localObject1 = ((List)localObject2).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        str1 = (String)((Iterator)localObject1).next();
        LibProc.a("RiskStub.loader", "HostMgr:try_ips: host= " + str1);
        str2 = e.a(str1 + "/" + Conf.f + "/addr", 10);
      } while (str2 == null);
    }
    for (;;)
    {
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(str2);
        Conf.d = ((JSONObject)localObject2).getString("srv_addr");
        Conf.e = ((JSONObject)localObject2).getString("down_addr");
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("HostMgr: get srvHost = ");
        LibProc.a("RiskStub.loader", Conf.d);
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("HostMgr: get dldHost = ");
        LibProc.a("RiskStub.loader", Conf.e);
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localEditor.putLong(str1 + "_last_available_tm", System.currentTimeMillis()).commit();
        bool = true;
        return bool;
      }
      catch (Exception localException)
      {
        LibProc.a(localException);
      }
      ((List)localObject2).add(localObject1);
      ((List)localObject2).add(str1);
      break;
      break label148;
      boolean bool = false;
    }
  }
  
  private static boolean e()
  {
    Object localObject = e.a(Conf.a, 10);
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>((String)localObject);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("HostMgr: get standby ip = ");
      LibProc.a("RiskStub.loader", localJSONObject.toString());
      localObject = RiskStubShell.B.edit();
      ((SharedPreferences.Editor)localObject).putString("ip1", localJSONObject.getString("ip1"));
      ((SharedPreferences.Editor)localObject).putString("ip2", localJSONObject.getString("ip2"));
      ((SharedPreferences.Editor)localObject).commit();
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LibProc.a(localException);
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public static String f()
  {
    LibProc.a("RiskStub.loader", "HostMgr: DownloadHost = " + Conf.e);
    return Conf.e;
  }
  
  void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.k == null)
        {
          str = "null";
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          LibProc.a("RiskStub.Version", paramString + "\n" + str);
          return;
        }
      }
      catch (Exception paramString)
      {
        String str;
        continue;
      }
      str = this.k.toString(4);
    }
  }
  
  public boolean a(a parama)
  {
    boolean bool = true;
    if (parama == null) {}
    for (;;)
    {
      return bool;
      if ((this.m != parama.m) || (this.n != parama.n)) {
        bool = false;
      }
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    this.v = false;
    this.x = paramBoolean2;
    if (paramBoolean2) {}
    for (;;)
    {
      try
      {
        str1 = this.s;
        if (str1 != null) {
          continue;
        }
        bool1 = bool2;
      }
      catch (Exception paramString)
      {
        try
        {
          String str2 = b(str1);
          JSONObject localJSONObject = this.k;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("md5_");
          if (str2.equalsIgnoreCase(localJSONObject.getString(paramString)))
          {
            paramString = new java/lang/StringBuilder;
            paramString.<init>("MD5 Check: <");
            LibProc.a("RiskStubShell.CheckMd5", str1 + "> OK!");
            this.v = true;
            bool1 = true;
            continue;
          }
          paramString = new java/lang/StringBuilder;
          paramString.<init>("ERROR: MD5 Check: <");
          LibProc.a("RiskStubShell.CheckMd5", str1 + ">");
          bool1 = bool2;
          if (!paramBoolean1) {
            continue;
          }
          e.c(str1);
          if (!paramBoolean2) {
            break label238;
          }
          this.s = null;
          bool1 = bool2;
        }
        catch (Exception paramString)
        {
          String str1;
          boolean bool1;
          for (;;) {}
        }
        paramString = paramString;
        str1 = null;
      }
      return bool1;
      str1 = this.r;
      continue;
      LibProc.a("RiskStubShell.CheckMd5", "ERROR: get MD5, <" + str1 + ">");
      LibProc.a(paramString);
      continue;
      label238:
      this.r = null;
      bool1 = bool2;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    LibProc.a("RiskStubShell.Version", "status: " + this.l + ", isA:" + paramBoolean);
    if (this.l == "") {
      paramBoolean = false;
    }
    for (;;)
    {
      return paramBoolean;
      this.u = paramBoolean;
      if (paramBoolean) {}
      for (String str = "A";; str = "B")
      {
        this.q = (RiskStubShell.M + "/RiskStub/" + str + "/J/RiskStub.apk");
        if (e.e(new File(this.q).getParent())) {
          break label167;
        }
        LibProc.a("RiskStubShell.Version", "ERROR: MKDIR: <" + this.q + ">");
        this.q = null;
        paramBoolean = false;
        break;
      }
      label167:
      this.s = (RiskStubShell.M + "/RiskStub/" + str + "/C/RiskStub");
      this.r = (RiskStubShell.M + "/RiskStub/" + str + "/C/libRiskStub.so");
      if (!e.e(new File(this.r).getParent()))
      {
        LibProc.a("RiskStubShell.Version", "ERROR: MKDIR: <" + this.r + ">");
        this.r = null;
        paramBoolean = false;
      }
      else
      {
        paramBoolean = true;
      }
    }
  }
  
  public void b(a parama)
  {
    int i = 0;
    try
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "md5_armeabi-v7a";
      arrayOfString[1] = "md5_x86";
      arrayOfString[2] = "md5_armeabi";
      arrayOfString[3] = "md5_java";
      while (i < arrayOfString.length)
      {
        this.k.put(arrayOfString[i], parama.k.get(arrayOfString[i]));
        i++;
      }
      return;
    }
    catch (Exception parama) {}
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.w = false;
    for (;;)
    {
      try
      {
        if (this.q == null)
        {
          bool1 = bool2;
          return bool1;
        }
        if (b(this.q).equalsIgnoreCase(this.k.getString("md5_java")))
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("MD5 Check: <");
          LibProc.a("RiskStubShell.CheckMd5", this.q + "> OK!");
          this.w = true;
          bool1 = true;
          continue;
        }
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("ERROR: MD5 Check: <");
        LibProc.a("RiskStubShell.CheckMd5", this.q + ">");
      }
      catch (Exception localException)
      {
        boolean bool1;
        LibProc.a("RiskStubShell.CheckMd5", "ERROR: get MD5, <" + this.q + ">");
        LibProc.a(localException);
        continue;
      }
      bool1 = bool2;
      if (paramBoolean)
      {
        e.c(this.q);
        this.q = null;
        bool1 = bool2;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.l.equals(""))) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        this.l = "ok";
      }
      this.t = paramBoolean;
      q();
    }
  }
  
  boolean g()
  {
    return this.l.equals("ok");
  }
  
  public boolean h()
  {
    if (this.l.length() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String i()
  {
    return this.q;
  }
  
  public String j()
  {
    return this.r;
  }
  
  public String k()
  {
    return this.s;
  }
  
  public void l()
  {
    this.l = "init";
    q();
  }
  
  public boolean m()
  {
    return this.t;
  }
  
  public boolean n()
  {
    int i = new Random().nextInt(1000);
    LibProc.a("RiskStub.Shell", "update when" + i + " < " + this.o + ", must_newest: " + this.p);
    if (i < this.o) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean o()
  {
    if (this.p == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean p()
  {
    boolean bool;
    if ((!this.x) && (this.v)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      Object localObject = e.d(this.s, new File(this.r).getParent());
      e.c(this.s);
      this.s = null;
      if (((ArrayList)localObject).size() != 1)
      {
        this.r = null;
        bool = false;
        continue;
      }
      if (!((String)((ArrayList)localObject).get(0)).equals("libRiskStub.so"))
      {
        this.r = null;
        bool = false;
        continue;
      }
      String str = b(this.r);
      try
      {
        localObject = this.k;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("md5_");
        ((JSONObject)localObject).put(RiskStubShell.L, str);
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  void q()
  {
    for (;;)
    {
      try
      {
        this.k.put("status", this.l);
        this.k.put("is_use", this.t);
        if (this.u)
        {
          str = "ver_a";
          RiskStubShell.B.edit().putString(str, this.k.toString()).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        String str;
        continue;
      }
      str = "ver_b";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\shell\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */