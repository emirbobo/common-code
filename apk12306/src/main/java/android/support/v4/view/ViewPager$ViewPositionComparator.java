package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class ViewPager$ViewPositionComparator
  implements Comparator<View>
{
  public int compare(View paramView1, View paramView2)
  {
    paramView1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
    paramView2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
    int i;
    if (paramView1.isDecor != paramView2.isDecor) {
      if (paramView1.isDecor) {
        i = 1;
      }
    }
    for (;;)
    {
      return i;
      i = -1;
      continue;
      i = paramView1.position - paramView2.position;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\ViewPager$ViewPositionComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */