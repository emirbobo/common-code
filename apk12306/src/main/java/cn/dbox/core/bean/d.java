package cn.dbox.core.bean;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static cn.dbox.core.h.d a = new cn.dbox.core.h.d(d.class.getSimpleName());
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private ArrayList<String> h;
  private String i;
  private int j;
  private ArrayList<String> k;
  private a l;
  private ArrayList<a> m;
  
  public d(String paramString1, String paramString2)
  {
    this.d = paramString2;
    this.e = paramString1;
  }
  
  /* Error */
  public d(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: invokespecial 46	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 57	cn/dbox/core/bean/d:b	Ljava/lang/String;
    //   12: aload_0
    //   13: aload_2
    //   14: putfield 59	cn/dbox/core/bean/d:c	Ljava/lang/String;
    //   17: aload_0
    //   18: aload_3
    //   19: ldc 61
    //   21: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: putfield 48	cn/dbox/core/bean/d:d	Ljava/lang/String;
    //   27: aload_0
    //   28: aload_3
    //   29: ldc 69
    //   31: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: putfield 50	cn/dbox/core/bean/d:e	Ljava/lang/String;
    //   37: aload_0
    //   38: aload_3
    //   39: ldc 71
    //   41: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: putfield 73	cn/dbox/core/bean/d:f	Ljava/lang/String;
    //   47: aload_0
    //   48: aload_3
    //   49: ldc 75
    //   51: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: putfield 77	cn/dbox/core/bean/d:g	Ljava/lang/String;
    //   57: aload_0
    //   58: aload_3
    //   59: ldc 79
    //   61: invokevirtual 83	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   64: putfield 85	cn/dbox/core/bean/d:j	I
    //   67: aload_0
    //   68: aload_3
    //   69: ldc 87
    //   71: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield 89	cn/dbox/core/bean/d:i	Ljava/lang/String;
    //   77: new 6	cn/dbox/core/bean/d$a
    //   80: astore_1
    //   81: aload_1
    //   82: aload_0
    //   83: aload_3
    //   84: ldc 91
    //   86: invokevirtual 95	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   89: invokespecial 98	cn/dbox/core/bean/d$a:<init>	(Lcn/dbox/core/bean/d;Lorg/json/JSONObject;)V
    //   92: aload_0
    //   93: aload_1
    //   94: putfield 100	cn/dbox/core/bean/d:l	Lcn/dbox/core/bean/d$a;
    //   97: new 102	java/util/ArrayList
    //   100: astore_1
    //   101: aload_1
    //   102: invokespecial 103	java/util/ArrayList:<init>	()V
    //   105: aload_0
    //   106: aload_1
    //   107: putfield 105	cn/dbox/core/bean/d:h	Ljava/util/ArrayList;
    //   110: new 102	java/util/ArrayList
    //   113: astore_1
    //   114: aload_1
    //   115: invokespecial 103	java/util/ArrayList:<init>	()V
    //   118: aload_0
    //   119: aload_1
    //   120: putfield 107	cn/dbox/core/bean/d:k	Ljava/util/ArrayList;
    //   123: new 109	org/json/JSONArray
    //   126: astore_1
    //   127: aload_1
    //   128: aload_3
    //   129: ldc 111
    //   131: invokevirtual 114	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokespecial 115	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   137: iconst_0
    //   138: istore 4
    //   140: aload_1
    //   141: invokevirtual 119	org/json/JSONArray:length	()I
    //   144: istore 6
    //   146: iload 4
    //   148: iload 6
    //   150: if_icmpge +45 -> 195
    //   153: aload_0
    //   154: getfield 107	cn/dbox/core/bean/d:k	Ljava/util/ArrayList;
    //   157: aload_1
    //   158: iload 4
    //   160: invokevirtual 122	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   163: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: iinc 4 1
    //   170: goto -30 -> 140
    //   173: astore_2
    //   174: getstatic 42	cn/dbox/core/bean/d:a	Lcn/dbox/core/h/d;
    //   177: aload_2
    //   178: invokevirtual 129	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   181: goto -14 -> 167
    //   184: astore_1
    //   185: getstatic 42	cn/dbox/core/bean/d:a	Lcn/dbox/core/h/d;
    //   188: aload_1
    //   189: invokevirtual 132	org/json/JSONException:toString	()Ljava/lang/String;
    //   192: invokevirtual 134	cn/dbox/core/h/d:b	(Ljava/lang/String;)V
    //   195: new 109	org/json/JSONArray
    //   198: astore_1
    //   199: aload_1
    //   200: aload_3
    //   201: ldc -120
    //   203: invokevirtual 114	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokespecial 115	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   209: iload 5
    //   211: istore 4
    //   213: aload_1
    //   214: invokevirtual 119	org/json/JSONArray:length	()I
    //   217: istore 5
    //   219: iload 4
    //   221: iload 5
    //   223: if_icmpge +45 -> 268
    //   226: aload_0
    //   227: getfield 105	cn/dbox/core/bean/d:h	Ljava/util/ArrayList;
    //   230: aload_1
    //   231: iload 4
    //   233: invokevirtual 122	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   236: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: iinc 4 1
    //   243: goto -30 -> 213
    //   246: astore_2
    //   247: getstatic 42	cn/dbox/core/bean/d:a	Lcn/dbox/core/h/d;
    //   250: aload_2
    //   251: invokevirtual 129	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   254: goto -14 -> 240
    //   257: astore_1
    //   258: getstatic 42	cn/dbox/core/bean/d:a	Lcn/dbox/core/h/d;
    //   261: aload_1
    //   262: invokevirtual 132	org/json/JSONException:toString	()Ljava/lang/String;
    //   265: invokevirtual 134	cn/dbox/core/h/d:b	(Ljava/lang/String;)V
    //   268: return
    //   269: astore_1
    //   270: getstatic 42	cn/dbox/core/bean/d:a	Lcn/dbox/core/h/d;
    //   273: aload_1
    //   274: invokevirtual 129	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   277: goto -9 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	d
    //   0	280	1	paramString1	String
    //   0	280	2	paramString2	String
    //   0	280	3	paramJSONObject	JSONObject
    //   138	103	4	n	int
    //   1	223	5	i1	int
    //   144	7	6	i2	int
    // Exception table:
    //   from	to	target	type
    //   153	167	173	org/json/JSONException
    //   123	137	184	org/json/JSONException
    //   140	146	184	org/json/JSONException
    //   174	181	184	org/json/JSONException
    //   226	240	246	org/json/JSONException
    //   195	209	257	org/json/JSONException
    //   213	219	257	org/json/JSONException
    //   247	254	257	org/json/JSONException
    //   7	123	269	java/lang/Exception
    //   123	137	269	java/lang/Exception
    //   140	146	269	java/lang/Exception
    //   153	167	269	java/lang/Exception
    //   174	181	269	java/lang/Exception
    //   185	195	269	java/lang/Exception
    //   195	209	269	java/lang/Exception
    //   213	219	269	java/lang/Exception
    //   226	240	269	java/lang/Exception
    //   247	254	269	java/lang/Exception
    //   258	268	269	java/lang/Exception
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(ArrayList<a> paramArrayList)
  {
    this.m = paramArrayList;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public ArrayList<String> f()
  {
    return this.h;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public int h()
  {
    return this.j;
  }
  
  public ArrayList<String> i()
  {
    return this.k;
  }
  
  public String j()
  {
    return this.g;
  }
  
  public a k()
  {
    return this.l;
  }
  
  public ArrayList<a> l()
  {
    return this.m;
  }
  
  public String toString()
  {
    return "ContainerInfo [mContainerId=" + this.d + ", mContainerName=" + this.e + ", mContainerLogo=" + this.f + ", mContainerLayout=" + this.g + ", mContainerTags=" + this.h + ", mContainerUrl=" + this.i + ", mContainePageSize=" + this.j + ", mContainerAdids=" + this.k + ", mSEAdInfos=" + this.m + ", mContainerHeaderInfo=" + this.l + "]";
  }
  
  public class a
  {
    private int b;
    private ArrayList<String> c;
    private ArrayList<a> d;
    
    public a(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null)
      {
        this.b = paramJSONObject.optInt("interval");
        this.c = new ArrayList();
        try
        {
          this$1 = new org/json/JSONArray;
          d.this.<init>(paramJSONObject.getString("adids"));
          int i = 0;
          for (;;)
          {
            int j = d.this.length();
            if (i < j) {
              try
              {
                this.c.add(d.this.getString(i));
                i++;
              }
              catch (JSONException paramJSONObject)
              {
                for (;;)
                {
                  d.m().a(paramJSONObject);
                }
              }
            }
          }
          return;
        }
        catch (JSONException this$1)
        {
          d.m().b(d.this.toString());
        }
      }
    }
    
    public int a()
    {
      return this.b;
    }
    
    public void a(ArrayList<a> paramArrayList)
    {
      this.d = paramArrayList;
    }
    
    public ArrayList<String> b()
    {
      return this.c;
    }
    
    public ArrayList<a> c()
    {
      return this.d;
    }
    
    public String toString()
    {
      return "ContainerInfoHeader [mInterval=" + this.b + ", mContainerHeaderAdids=" + this.c + "]";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */