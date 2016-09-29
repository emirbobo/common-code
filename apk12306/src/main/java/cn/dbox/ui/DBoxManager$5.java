package cn.dbox.ui;

import cn.dbox.core.bean.Entrance.EntryReportType;

class DBoxManager$5
  implements Runnable
{
  DBoxManager$5(DBoxManager paramDBoxManager) {}
  
  public void run()
  {
    this.a.doEntryReports(Entrance.EntryReportType.PRESENTED);
    DBoxManager.c(this.a).a(DBoxManager.g(this.a), DBoxManager.h(this.a), DBoxManager.i(this.a), DBoxManager.j(this.a), DBoxManager.k(this.a));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\DBoxManager$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */