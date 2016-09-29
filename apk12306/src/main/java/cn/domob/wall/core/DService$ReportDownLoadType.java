package cn.domob.wall.core;

public enum DService$ReportDownLoadType
{
  static
  {
    DL_START = new ReportDownLoadType("DL_START", 1);
    DL_REPEAT = new ReportDownLoadType("DL_REPEAT", 2);
    DL_FINISH = new ReportDownLoadType("DL_FINISH", 3);
    DL_FAILED = new ReportDownLoadType("DL_FAILED", 4);
    DL_CANCEL = new ReportDownLoadType("DL_CANCEL", 5);
    INSTALL_SUCCESS = new ReportDownLoadType("INSTALL_SUCCESS", 6);
  }
  
  private DService$ReportDownLoadType() {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\DService$ReportDownLoadType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */