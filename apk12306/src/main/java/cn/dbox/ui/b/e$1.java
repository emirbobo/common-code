package cn.dbox.ui.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.dbox.core.b.d;
import cn.dbox.core.bean.d;
import java.util.ArrayList;

class e$1
  implements AdapterView.OnItemClickListener
{
  e$1(e parame, d paramd) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.b.e != null) && (paramInt < this.b.s.size()))
    {
      paramAdapterView = (cn.dbox.core.bean.a)this.a.l().get(paramInt);
      paramAdapterView.a(paramInt);
      this.b.e.a(paramAdapterView, b.d.c, this.a.a(), this.a.c());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\e$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */