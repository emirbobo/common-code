package cn.dm.download.util;

public class Constants
{
  public static String DefaultStorageFile = "DMDownload";
  public static final int DownloadErrorFlag_NoSDCard = 1;
  public static final int DownloadStatus_CanUpdate = 6;
  public static final int DownloadStatus_Failed = 8;
  public static final int DownloadStatus_Finished = 4;
  public static final int DownloadStatus_Installed = 5;
  public static final int DownloadStatus_NotStart = 0;
  public static final int DownloadStatus_NotWaiting = 7;
  public static final int DownloadStatus_Paused = 3;
  public static final int DownloadStatus_Started = 2;
  public static final int DownloadStatus_Uninstalled = 9;
  public static final int DownloadStatus_WaitingStart = 1;
  public static int DownloadUrlWrong = 0;
  public static final int Download_IsThirdInstalled = 1;
  public static int MaxDownloadThread = 2;
  public static String Unfinished_Sign;
  
  static
  {
    DownloadUrlWrong = -1;
    Unfinished_Sign = ".temp";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\util\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */