package cn.dbox.ui.card;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.dbox.core.b.e;
import cn.dbox.core.bean.d;
import cn.dbox.ui.d.b;
import java.util.ArrayList;

class a$2
  implements AdapterView.OnItemClickListener
{
  a$2(a parama) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((a.a(this.a) != null) && (paramInt < this.a.a.size())) {
      a.a(this.a).a((d)this.a.a.get(paramInt), b.e.c);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */