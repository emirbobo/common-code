package cn.dbox.core.bean;

import java.util.ArrayList;

public class c
{
  private static cn.dbox.core.h.d a = new cn.dbox.core.h.d(c.class.getSimpleName());
  private String b;
  private String c;
  private String d;
  private ArrayList<d> e = new ArrayList();
  
  public c() {}
  
  public c(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  /* Error */
  public c(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 32	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 34	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 35	java/util/ArrayList:<init>	()V
    //   12: putfield 37	cn/dbox/core/bean/c:e	Ljava/util/ArrayList;
    //   15: aload_0
    //   16: aload_1
    //   17: ldc 49
    //   19: invokevirtual 55	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: putfield 40	cn/dbox/core/bean/c:b	Ljava/lang/String;
    //   25: aload_0
    //   26: aload_1
    //   27: ldc 57
    //   29: invokevirtual 55	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: putfield 42	cn/dbox/core/bean/c:c	Ljava/lang/String;
    //   35: aload_0
    //   36: aload_1
    //   37: ldc 59
    //   39: invokevirtual 55	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: putfield 61	cn/dbox/core/bean/c:d	Ljava/lang/String;
    //   45: new 63	org/json/JSONArray
    //   48: astore 4
    //   50: aload 4
    //   52: aload_1
    //   53: ldc 65
    //   55: invokevirtual 68	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 69	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   61: iconst_0
    //   62: istore_2
    //   63: aload 4
    //   65: invokevirtual 73	org/json/JSONArray:length	()I
    //   68: istore_3
    //   69: iload_2
    //   70: iload_3
    //   71: if_icmpge +67 -> 138
    //   74: aload_0
    //   75: getfield 37	cn/dbox/core/bean/c:e	Ljava/util/ArrayList;
    //   78: astore_1
    //   79: new 75	cn/dbox/core/bean/d
    //   82: astore 5
    //   84: aload 5
    //   86: aload_0
    //   87: getfield 40	cn/dbox/core/bean/c:b	Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 42	cn/dbox/core/bean/c:c	Ljava/lang/String;
    //   94: aload 4
    //   96: iload_2
    //   97: invokevirtual 79	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   100: invokespecial 82	cn/dbox/core/bean/d:<init>	(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   103: aload_1
    //   104: aload 5
    //   106: invokevirtual 86	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: iinc 2 1
    //   113: goto -50 -> 63
    //   116: astore_1
    //   117: getstatic 29	cn/dbox/core/bean/c:a	Lcn/dbox/core/h/d;
    //   120: aload_1
    //   121: invokevirtual 89	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   124: goto -14 -> 110
    //   127: astore_1
    //   128: getstatic 29	cn/dbox/core/bean/c:a	Lcn/dbox/core/h/d;
    //   131: aload_1
    //   132: invokevirtual 92	org/json/JSONException:toString	()Ljava/lang/String;
    //   135: invokevirtual 94	cn/dbox/core/h/d:b	(Ljava/lang/String;)V
    //   138: return
    //   139: astore_1
    //   140: getstatic 29	cn/dbox/core/bean/c:a	Lcn/dbox/core/h/d;
    //   143: aload_1
    //   144: invokevirtual 89	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   147: goto -9 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	c
    //   0	150	1	paramJSONObject	org.json.JSONObject
    //   62	49	2	i	int
    //   68	4	3	j	int
    //   48	47	4	localJSONArray	org.json.JSONArray
    //   82	23	5	locald	d
    // Exception table:
    //   from	to	target	type
    //   74	110	116	java/lang/Exception
    //   15	61	127	org/json/JSONException
    //   63	69	127	org/json/JSONException
    //   74	110	127	org/json/JSONException
    //   117	124	127	org/json/JSONException
    //   15	61	139	java/lang/Exception
    //   63	69	139	java/lang/Exception
    //   117	124	139	java/lang/Exception
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public ArrayList<d> d()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "ChannelInfo [mChannelId=" + this.b + ", mChannelName=" + this.c + ", mSEContainerInfos=" + this.e + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */