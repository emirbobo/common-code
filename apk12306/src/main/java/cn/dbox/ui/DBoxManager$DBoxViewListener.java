package cn.dbox.ui;

public abstract interface DBoxManager$DBoxViewListener
{
  public abstract void onDBoxViewClosed();
  
  public abstract void onDBoxViewPresent();
  
  public abstract void onFailReceiveData(String paramString);
  
  public abstract void onLeaveApplication();
  
  public abstract void onSuccessReceiveData(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\DBoxManager$DBoxViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */