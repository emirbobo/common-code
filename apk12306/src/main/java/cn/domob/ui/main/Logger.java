package cn.domob.ui.main;

public class Logger
{
  public static final String LOG_TAG = "DrwUi";
  public static final int PT_LEVEL = -1;
  public static final String PT_LOG_TAG = "DrwUiPT";
  private static final boolean mIsLoggable = false;
  public static long newtime = 0L;
  public static long oldtime = 0L;
  private String mClassSimpleName;
  
  public Logger(String paramString)
  {
    this.mClassSimpleName = paramString;
  }
  
  private void log(String paramString, int paramInt) {}
  
  public void debugLog(Object paramObject, String paramString)
  {
    debugLog(paramString);
  }
  
  public void debugLog(String paramString)
  {
    log(paramString, 3);
  }
  
  public void errorLog(Object paramObject, String paramString)
  {
    errorLog(paramString);
  }
  
  public void errorLog(String paramString)
  {
    log(paramString, 6);
  }
  
  public void infoLog(Object paramObject, String paramString)
  {
    infoLog(paramString);
  }
  
  public void infoLog(String paramString)
  {
    log(paramString, 4);
  }
  
  public void printStackTrace(Throwable paramThrowable) {}
  
  public void ptLog(String paramString)
  {
    log(paramString, -1);
  }
  
  public void verboseLog(Object paramObject, String paramString)
  {
    verboseLog(paramString);
  }
  
  public void verboseLog(String paramString)
  {
    log(paramString, 2);
  }
  
  public void warnLog(Object paramObject, String paramString)
  {
    warnLog(paramString);
  }
  
  public void warnLog(String paramString)
  {
    log(paramString, 5);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */