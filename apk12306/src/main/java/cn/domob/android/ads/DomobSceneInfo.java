package cn.domob.android.ads;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import cn.domob.android.i.f;
import cn.domob.android.i.h;

public class DomobSceneInfo
{
  private static final int i = 32;
  protected int a;
  private Context b;
  private ViewGroup c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  protected String d()
  {
    return this.d;
  }
  
  protected Context e()
  {
    return this.b;
  }
  
  protected ViewGroup f()
  {
    return this.c;
  }
  
  protected int g()
  {
    return this.e;
  }
  
  protected int h()
  {
    return this.f;
  }
  
  protected int i()
  {
    return this.g;
  }
  
  protected int j()
  {
    return this.h;
  }
  
  protected int k()
  {
    return this.a;
  }
  
  public void setContext(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void setCoordinatesX(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setCoordinatesY(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setParentViewGroup(ViewGroup paramViewGroup)
  {
    this.c = paramViewGroup;
  }
  
  public void setSceneId(String paramString)
  {
    if ((!h.e(paramString)) && (paramString.getBytes().length > 32)) {
      Log.e(f.b(), String.format("scene id maximum length is limited to %d bytes", new Object[] { Integer.valueOf(32) }));
    }
    for (this.d = paramString.substring(0, 32);; this.d = paramString) {
      return;
    }
  }
  
  public void setSecureAreaHeight(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setSecureAreaWidth(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobSceneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */