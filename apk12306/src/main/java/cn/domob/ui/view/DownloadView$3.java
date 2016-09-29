package cn.domob.ui.view;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.RelativeLayout;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DId;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class DownloadView$3
  implements ExpandableListView.OnChildClickListener
{
  private RelativeLayout b;
  private RelativeLayout c;
  
  DownloadView$3(DownloadView paramDownloadView) {}
  
  public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    DownloadView.access$100().debugLog("onChildClick: " + paramInt1 + "," + paramInt2);
    this.a.viewStub = null;
    this.a.vsOperations = paramView.findViewById(DId.getIdInt(DownloadView.access$200(this.a), "ll_sliding_menu"));
    paramView = new int[2];
    paramView[0] = paramInt1;
    paramView[1] = paramInt2;
    paramExpandableListView = new int[2];
    paramExpandableListView[0] = paramInt1;
    paramExpandableListView[1] = paramInt2;
    DownloadView.a locala = new DownloadView.a(this.a, paramInt1, paramInt2);
    if (DownloadView.access$300(this.a).size() == 0) {
      if (this.a.vsOperations.getVisibility() == 8)
      {
        this.a.vsOperations.setVisibility(0);
        this.b = ((RelativeLayout)this.a.vsOperations.findViewById(DId.getIdInt(DownloadView.access$200(this.a), "rl_menu_delete")));
        this.c = ((RelativeLayout)this.a.vsOperations.findViewById(DId.getIdInt(DownloadView.access$200(this.a), "rl_menu_detail")));
        this.b.setOnClickListener(locala);
        this.c.setOnClickListener(locala);
        DownloadView.access$300(this.a).put(paramView, this.a.vsOperations);
      }
    }
    for (;;)
    {
      return false;
      this.a.vsOperations.setVisibility(8);
      continue;
      Iterator localIterator = DownloadView.access$300(this.a).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramExpandableListView = (int[])localEntry.getKey();
        this.a.viewStub = ((View)localEntry.getValue());
      }
      if (DownloadView.access$400(this.a, paramExpandableListView, paramView))
      {
        if (this.a.viewStub.getVisibility() == 8) {
          this.a.viewStub.setVisibility(0);
        } else {
          this.a.viewStub.setVisibility(8);
        }
      }
      else
      {
        this.a.viewStub.setVisibility(8);
        DownloadView.access$300(this.a).clear();
        if (this.a.vsOperations.getVisibility() == 8)
        {
          this.a.vsOperations.setVisibility(0);
          this.b = ((RelativeLayout)this.a.vsOperations.findViewById(DId.getIdInt(DownloadView.access$200(this.a), "rl_menu_delete")));
          this.b.setOnClickListener(locala);
          this.c = ((RelativeLayout)this.a.vsOperations.findViewById(DId.getIdInt(DownloadView.access$200(this.a), "rl_menu_detail")));
          this.c.setOnClickListener(locala);
          DownloadView.access$300(this.a).put(paramView, this.a.vsOperations);
        }
        else
        {
          this.a.vsOperations.setVisibility(8);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\DownloadView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */