package cn.dbox.ui.card;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import cn.dbox.core.bean.a;
import cn.dbox.core.bean.c;
import cn.dbox.ui.common.h;
import cn.dbox.ui.common.k;
import java.util.ArrayList;

public class b
  extends h
{
  private ScrollView n;
  
  public b(Context paramContext, ArrayList<c> paramArrayList, ArrayList<a> paramArrayList1, cn.dbox.core.b paramb)
  {
    super(paramContext, paramArrayList, paramArrayList1, paramb);
    setLayoutParams(this.m);
    setBackgroundColor(-789000);
    this.n = a(paramContext);
    addView(this.n);
  }
  
  public ScrollView a(Context paramContext)
  {
    ScrollView localScrollView = new ScrollView(paramContext);
    localScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localScrollView.setVerticalScrollBarEnabled(false);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    for (int i = 0; i < this.b.size(); i++)
    {
      e locale = new e(paramContext, (c)this.b.get(i), this.d);
      locale.a(this.g);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i != 0) {
        localLayoutParams.topMargin = k.a(paramContext, 25);
      }
      if (i == this.b.size() - 1) {
        localLayoutParams.bottomMargin = k.a(paramContext, 15);
      }
      localLinearLayout.addView(locale, localLayoutParams);
      this.f.add(locale);
    }
    localScrollView.addView(localLinearLayout);
    return localScrollView;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */