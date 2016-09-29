package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

public enum ActionType
{
  private String j;
  private String k;
  private String l;
  private JSONObject m;
  private String n;
  private String o;
  private String p;
  private boolean q;
  private boolean r;
  private boolean s;
  private String t;
  private String u;
  private String v;
  private JSONObject w;
  
  private ActionType(String paramString1)
  {
    this.j = paramString1;
  }
  
  public static ActionType[] a(ElementAction paramElementAction)
  {
    ActionType[] arrayOfActionType1;
    int i2;
    int i1;
    label48:
    String str;
    ActionType localActionType2;
    int i3;
    label77:
    ActionType localActionType1;
    if (paramElementAction != null)
    {
      String[] arrayOfString = a(paramElementAction.e());
      if (arrayOfString == null)
      {
        paramElementAction = new ActionType[1];
        paramElementAction[0] = d;
        return paramElementAction;
      }
      arrayOfActionType1 = new ActionType[arrayOfString.length];
      int i4 = arrayOfString.length;
      i2 = 0;
      i1 = 0;
      if (i2 < i4)
      {
        str = arrayOfString[i2];
        localActionType2 = d;
        ActionType[] arrayOfActionType2 = values();
        int i5 = arrayOfActionType2.length;
        i3 = 0;
        if (i3 >= i5) {
          break label258;
        }
        localActionType1 = arrayOfActionType2[i3];
        if (!str.startsWith(localActionType1.j)) {}
      }
    }
    for (;;)
    {
      localActionType1.k = str;
      localActionType1.l = paramElementAction.f();
      localActionType1.m = paramElementAction.h();
      localActionType1.n = paramElementAction.g();
      localActionType1.o = paramElementAction.i();
      localActionType1.p = paramElementAction.j();
      localActionType1.q = paramElementAction.k();
      localActionType1.r = paramElementAction.l();
      localActionType1.s = paramElementAction.m();
      localActionType1.t = paramElementAction.c();
      localActionType1.u = paramElementAction.d();
      localActionType1.v = paramElementAction.b();
      localActionType1.w = paramElementAction.a();
      arrayOfActionType1[i1] = localActionType1;
      i2++;
      i1++;
      break label48;
      i3++;
      break label77;
      paramElementAction = arrayOfActionType1;
      break;
      paramElementAction = new ActionType[1];
      paramElementAction[0] = d;
      break;
      label258:
      localActionType1 = localActionType2;
    }
  }
  
  private static String[] a(String paramString)
  {
    String[] arrayOfString = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfString = paramString.split(";");
    }
    return arrayOfString;
  }
  
  public JSONObject a()
  {
    return this.w;
  }
  
  public String b()
  {
    return this.v;
  }
  
  public String c()
  {
    return this.t;
  }
  
  public String d()
  {
    return this.u;
  }
  
  public String e()
  {
    return this.k;
  }
  
  public String f()
  {
    return this.l;
  }
  
  public JSONObject g()
  {
    return this.m;
  }
  
  public String h()
  {
    return this.o;
  }
  
  public String i()
  {
    return this.p;
  }
  
  public boolean j()
  {
    return this.q;
  }
  
  public boolean k()
  {
    return this.r;
  }
  
  public boolean l()
  {
    return this.s;
  }
  
  public String m()
  {
    return this.n;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\ActionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */