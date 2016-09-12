package cn.dbox.ui.common;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.dbox.core.b.d;
import java.util.ArrayList;

class b$1
  implements AdapterView.OnItemClickListener
{
  b$1(b paramb) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.b != null) {
      this.a.b.a((cn.dbox.core.bean.a)this.a.a.get(paramInt % this.a.a.size()), b.d.c, b.a(this.a), b.b(this.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */