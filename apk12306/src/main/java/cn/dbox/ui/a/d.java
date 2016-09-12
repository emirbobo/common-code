package cn.dbox.ui.a;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import cn.dbox.ui.b.b;
import java.util.ArrayList;

public class d
  extends PagerAdapter
{
  private ArrayList<b> a;
  
  public d(ArrayList<b> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.a.get(paramInt));
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.a.get(paramInt), 0);
    return this.a.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    if (paramView == paramObject) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */