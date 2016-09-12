package cn.dbox.ui.common;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import cn.dbox.ui.d.g;

class j$4
  implements View.OnClickListener
{
  j$4(j paramj) {}
  
  public void onClick(View paramView)
  {
    if (j.a(this.a) != null) {
      j.a(this.a).a(j.b(this.a).getText().toString().trim(), j.c(this.a).getText().toString().trim());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\j$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */