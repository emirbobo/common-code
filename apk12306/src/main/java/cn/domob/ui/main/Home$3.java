package cn.domob.ui.main;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.EWallReportType;

class Home$3
  implements RadioGroup.OnCheckedChangeListener
{
  Home$3(Home paramHome) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    paramInt = paramRadioGroup.getCheckedRadioButtonId();
    if (paramInt == Home.access$400(this.a).getId()) {
      Home.access$500(this.a).setVisibility(8);
    }
    for (;;)
    {
      return;
      if (paramInt == Home.access$600(this.a).getId())
      {
        Home.access$700().debugLog("Send report:E_ENTRY_CLICK");
        Home.access$800(this.a).doEWallReport(DService.EWallReportType.E_ENTRY_CLICK);
        if (Home.access$500(this.a).getChildCount() > 0)
        {
          Home.access$700().debugLog("Remove child view");
          Home.access$500(this.a).removeAllViews();
        }
        Home.access$500(this.a).addView(Home.access$800(this.a).getEView(Home.access$900(this.a)));
        Home.access$500(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\Home$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */