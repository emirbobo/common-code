package cn.domob.ui.main;

import android.content.Context;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import cn.domob.ui.utility.DString;

class Home$4
  implements TabHost.OnTabChangeListener
{
  Home$4(Home paramHome, TextView paramTextView1, int paramInt1, TextView paramTextView2, TextView paramTextView3, int paramInt2, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6) {}
  
  public void onTabChanged(String paramString)
  {
    Home.access$700().debugLog("tabId:" + paramString);
    Home.access$1002(this.i, Home.access$900(this.i).getString(DString.getStringInt(Home.access$900(this.i), "tab_app")));
    Home.access$1102(this.i, Home.access$900(this.i).getString(DString.getStringInt(Home.access$900(this.i), "tab_game")));
    Home.access$1202(this.i, Home.access$900(this.i).getString(DString.getStringInt(Home.access$900(this.i), "tab_all")));
    if (Home.access$1000(this.i).equals(paramString))
    {
      Home.access$1600(this.i, Home.access$1300(this.i), Home.access$1400(this.i), Home.access$1500(this.i));
      this.a.setTextColor(this.b);
      this.c.setTextColor(this.b);
      this.d.setTextColor(this.e);
      this.f.setTextColor(this.e);
      this.g.setTextColor(this.e);
      this.h.setTextColor(this.e);
    }
    for (;;)
    {
      return;
      if (Home.access$1100(this.i).equals(paramString))
      {
        Home.access$1600(this.i, Home.access$1500(this.i), Home.access$1400(this.i), Home.access$1300(this.i));
        this.a.setTextColor(this.e);
        this.c.setTextColor(this.e);
        this.d.setTextColor(this.e);
        this.f.setTextColor(this.e);
        this.g.setTextColor(this.b);
        this.h.setTextColor(this.b);
      }
      else if (Home.access$1200(this.i).equals(paramString))
      {
        Home.access$1600(this.i, Home.access$1400(this.i), Home.access$1300(this.i), Home.access$1500(this.i));
        this.a.setTextColor(this.e);
        this.c.setTextColor(this.e);
        this.d.setTextColor(this.b);
        this.f.setTextColor(this.b);
        this.g.setTextColor(this.e);
        this.h.setTextColor(this.e);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\Home$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */