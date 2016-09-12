package cn.domob.ui.main;

import android.view.View;
import android.view.View.OnClickListener;

class Home$5
  implements View.OnClickListener
{
  Home$5(Home paramHome) {}
  
  public void onClick(View paramView)
  {
    Home.access$700().debugLog("backButton clicked");
    if (Home.access$300(this.a) != null) {
      Home.access$300(this.a).onBackButtonClicked();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\Home$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */