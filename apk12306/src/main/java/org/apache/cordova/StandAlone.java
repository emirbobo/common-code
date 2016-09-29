package org.apache.cordova;

import android.os.Bundle;

public class StandAlone
  extends DroidGap
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.loadUrl("file:///android_asset/www/index.html");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\StandAlone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */