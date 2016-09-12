package cn.domob.android.g.a;

import android.content.Context;
import cn.domob.android.i.f;
import java.util.HashMap;

public class a
{
  private static final f a = new f(a.class.getSimpleName());
  private static final String b = "sdk";
  private static final String c = "ipb";
  private static final String d = "idv";
  private static final String e = "v";
  private static final String f = "sv";
  private static final String g = "dma";
  private static final String h = "ama";
  private static final String i = "an";
  private static final String j = "ppid";
  private c k = new c();
  
  public a(e parame)
  {
    a(parame);
    a.b("init " + a.class.getSimpleName());
  }
  
  private void a(e parame)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sdk", parame.a());
    localHashMap.put("v", parame.b());
    localHashMap.put("sv", parame.c());
    localHashMap.put("dma", parame.d());
    localHashMap.put("ama", parame.e());
    localHashMap.put("an", parame.f());
    localHashMap.put("idv", parame.g());
    localHashMap.put("ipb", parame.i());
    localHashMap.put("ppid", parame.h());
    this.k.a(localHashMap);
  }
  
  protected void a(int paramInt)
  {
    this.k.a(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.k.a(paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.k.a(paramBoolean);
  }
  
  public void a(String[] paramArrayOfString, Context paramContext, b paramb)
  {
    this.k.a(paramArrayOfString);
    this.k.a(paramContext);
    this.k.a(paramb);
    if (!b.a()) {
      new Thread(new b(this.k)).start();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.k.b(paramBoolean);
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama);
    
    public abstract void a(String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\g\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */