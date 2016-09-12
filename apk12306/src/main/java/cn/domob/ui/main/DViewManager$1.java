package cn.domob.ui.main;

import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import cn.domob.ui.view.HandleView;

class DViewManager$1
  implements Runnable
{
  DViewManager$1(DViewManager paramDViewManager) {}
  
  public void run()
  {
    if (DViewManager.access$000(this.a) == null)
    {
      String str = DViewManager.access$100(this.a).getString("mHandleUrl", "");
      DViewManager.access$200().debugLog("handlerUrl:" + str);
      DViewManager.access$002(this.a, new HandleView(DViewManager.access$300(this.a), DViewManager.access$400(this.a), str).initHandleView());
    }
    if ((DViewManager.access$500(this.a) != null) && (DViewManager.access$000(this.a).getParent() == null)) {
      DViewManager.access$500(this.a).addView(DViewManager.access$000(this.a));
    }
    for (;;)
    {
      DViewManager.access$000(this.a).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DViewManager.access$200().debugLog("点击把手");
          DViewManager.1.this.a.showWall();
        }
      });
      return;
      if ((DViewManager.access$600(this.a) != null) && (DViewManager.access$000(this.a).getParent() == null)) {
        DViewManager.access$600(this.a).addView(DViewManager.access$000(this.a), DViewManager.access$700(this.a, 0));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\DViewManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */