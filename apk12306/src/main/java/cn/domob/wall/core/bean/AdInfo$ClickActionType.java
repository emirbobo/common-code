package cn.domob.wall.core.bean;

public enum AdInfo$ClickActionType
{
  static
  {
    DOWNLOAD = new ClickActionType("DOWNLOAD", 1);
    INTERNAL_BROWSER = new ClickActionType("INTERNAL_BROWSER", 2);
    EXTERNAL_BROWSER = new ClickActionType("EXTERNAL_BROWSER", 3);
    LAUNCH = new ClickActionType("LAUNCH", 4);
    UPDATE = new ClickActionType("UPDATE", 5);
  }
  
  private AdInfo$ClickActionType() {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\bean\AdInfo$ClickActionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */