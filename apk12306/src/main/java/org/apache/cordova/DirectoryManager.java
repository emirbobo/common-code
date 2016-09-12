package org.apache.cordova;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class DirectoryManager
{
  private static final String LOG_TAG = "DirectoryManager";
  
  private static File constructFilePaths(String paramString1, String paramString2)
  {
    if (paramString2.startsWith(paramString1)) {}
    for (paramString1 = new File(paramString2);; paramString1 = new File(paramString1 + "/" + paramString2)) {
      return paramString1;
    }
  }
  
  private static long freeSpaceCalculation(String paramString)
  {
    paramString = new StatFs(paramString);
    long l = paramString.getBlockSize();
    return paramString.getAvailableBlocks() * l / 1024L;
  }
  
  protected static long getFreeDiskSpace(boolean paramBoolean)
  {
    long l;
    if (Environment.getExternalStorageState().equals("mounted")) {
      l = freeSpaceCalculation(Environment.getExternalStorageDirectory().getPath());
    }
    for (;;)
    {
      return l;
      if (paramBoolean) {
        l = freeSpaceCalculation("/");
      } else {
        l = -1L;
      }
    }
  }
  
  protected static String getTempDirectoryPath(Context paramContext)
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (paramContext = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + paramContext.getPackageName() + "/cache/");; paramContext = paramContext.getCacheDir())
    {
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
  }
  
  protected static boolean testFileExists(String paramString)
  {
    if ((testSaveLocationExists()) && (!paramString.equals(""))) {}
    for (boolean bool = constructFilePaths(Environment.getExternalStorageDirectory().toString(), paramString).exists();; bool = false) {
      return bool;
    }
  }
  
  protected static boolean testSaveLocationExists()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\DirectoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */