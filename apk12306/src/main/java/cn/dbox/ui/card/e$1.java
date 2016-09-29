package cn.dbox.ui.card;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.dbox.core.b.e;
import cn.dbox.core.bean.d;
import cn.dbox.ui.d.b;
import java.util.ArrayList;

class e$1
  implements AdapterView.OnItemClickListener
{
  e$1(e parame) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((e.a(this.a) != null) && (paramInt < this.a.a.size())) {
      e.a(this.a).a((d)this.a.a.get(paramInt), b.e.c);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\e$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */