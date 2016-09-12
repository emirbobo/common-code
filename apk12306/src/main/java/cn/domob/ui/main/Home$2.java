package cn.domob.ui.main;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

class Home$2
  implements Runnable
{
  Home$2(Home paramHome, String paramString) {}
  
  public void run()
  {
    Home.access$000(this.b).setVisibility(0);
    Home.access$100(this.b).setVisibility(8);
    Home.access$200(this.b).setText(this.a);
    Home.access$200(this.b).setVisibility(0);
    Home.access$200(this.b).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Home.access$300(Home.2.this.b) != null) {
          Home.access$300(Home.2.this.b).onRefreshButtonClicked();
        }
      }
    });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\Home$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */