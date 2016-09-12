package com.MobileTicket;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bangcle.andjni.JniLib;
import java.io.File;

public class MobileTicketShare
  extends Activity
{
  static
  {
    JniLib.a(MobileTicketShare.class, 12);
  }
  
  public native void checkStat(File paramFile);
  
  public native void onCreate(Bundle paramBundle);
  
  public native void shareMsg(Context paramContext, String paramString1, String paramString2, String paramString3, File paramFile);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\MobileTicketShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */