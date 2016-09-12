package com.phonegap.plugins.childBrowser;

import android.webkit.DownloadListener;
import com.bangcle.andjni.JniLib;

class ChildBrowser$MyWebViewDownLoadListener
  implements DownloadListener
{
  static
  {
    JniLib.a(MyWebViewDownLoadListener.class, 1056);
  }
  
  private ChildBrowser$MyWebViewDownLoadListener(ChildBrowser paramChildBrowser) {}
  
  public native void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$MyWebViewDownLoadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */