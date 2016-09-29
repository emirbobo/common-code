package cn.dbox.ui.common;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import cn.dbox.core.h.d;

class b$2
  implements AdapterView.OnItemSelectedListener
{
  b$2(b paramb) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b.b().b("onItemSelected:" + paramInt);
    paramAdapterView = this.a;
    if (b.c(this.a) > paramInt % b.d(this.a) + 1) {}
    for (paramInt = b.c(this.a);; paramInt = paramInt % b.d(this.a) + 1)
    {
      b.a(paramAdapterView, paramInt);
      return;
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    b.b().b("onNothingSelected");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\b$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */