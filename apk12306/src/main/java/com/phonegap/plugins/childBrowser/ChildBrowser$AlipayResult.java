package com.phonegap.plugins.childBrowser;

import com.bangcle.andjni.JniLib;

class ChildBrowser$AlipayResult
{
  String memo;
  String result;
  String resultStatus;
  
  static
  {
    JniLib.a(AlipayResult.class, 1051);
  }
  
  public ChildBrowser$AlipayResult(ChildBrowser paramChildBrowser, String paramString)
  {
    paramChildBrowser = paramString.split(";");
    int j = paramChildBrowser.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      paramString = paramChildBrowser[i];
      if (paramString.startsWith("resultStatus")) {
        this.resultStatus = gatValue(paramString, "resultStatus");
      }
      if (paramString.startsWith("result")) {
        this.result = gatValue(paramString, "result");
      }
      if (paramString.startsWith("memo")) {
        this.memo = gatValue(paramString, "memo");
      }
    }
  }
  
  public native String gatValue(String paramString1, String paramString2);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$AlipayResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */