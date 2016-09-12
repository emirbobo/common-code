package cn.dbox.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import cn.dbox.ui.common.f;

class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public void run()
  {
    this.a.p.setText("点击返回顶部");
    this.a.o.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        b.1.this.a.b.setSelection(0);
      }
    });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */