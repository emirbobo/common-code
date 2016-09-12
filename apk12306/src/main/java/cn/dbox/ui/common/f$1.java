package cn.dbox.ui.common;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class f$1
  implements AbsListView.OnScrollListener
{
  f$1(f paramf) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView.getLastVisiblePosition() > 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (paramInt == 0) && (this.a.a != null)) {
      this.a.a.a();
    }
    if ((paramAbsListView.getLastVisiblePosition() > 0) && (paramInt == 0))
    {
      int i = paramAbsListView.getLastVisiblePosition();
      paramAbsListView = this.a;
      paramInt = i;
      if (this.a.c > i) {
        paramInt = this.a.c;
      }
      paramAbsListView.c = paramInt;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\f$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */