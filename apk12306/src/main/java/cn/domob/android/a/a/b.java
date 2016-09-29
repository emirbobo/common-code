package cn.domob.android.a.a;

import android.content.Context;
import android.widget.RelativeLayout;
import cn.domob.android.i.f;

public class b
  extends RelativeLayout
{
  private static final f a = new f(b.class.getSimpleName());
  private a b;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a.b(" DetachedFromWindow");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    a.b(" WindowFocusChanged:" + paramBoolean);
  }
  
  public void onWindowVisibilityChanged(int paramInt)
  {
    boolean bool2 = true;
    super.onWindowVisibilityChanged(paramInt);
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.b != null)
    {
      localObject = this.b;
      if (paramInt == 0)
      {
        bool1 = true;
        ((a)localObject).a(bool1);
      }
    }
    else
    {
      localObject = a;
      localStringBuilder = new StringBuilder().append(" WindowVisibilityChanged:");
      if (paramInt != 0) {
        break label79;
      }
    }
    label79:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).b(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */