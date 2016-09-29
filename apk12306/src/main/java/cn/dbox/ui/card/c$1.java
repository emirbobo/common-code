package cn.dbox.ui.card;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class c$1
  implements AbsListView.OnScrollListener
{
  c$1(c paramc) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView.getLastVisiblePosition() > 0) && (paramInt == 0))
    {
      int j = paramAbsListView.getLastVisiblePosition();
      c localc = this.a;
      int i = j;
      if (c.access$000(this.a) > j) {
        i = c.access$000(this.a);
      }
      c.access$002(localc, i);
    }
    if ((paramAbsListView.getLastVisiblePosition() > 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (paramInt == 0) && (c.access$100(this.a) != null)) {
      c.access$100(this.a).a();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */