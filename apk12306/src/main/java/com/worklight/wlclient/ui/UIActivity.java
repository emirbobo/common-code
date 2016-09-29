package com.worklight.wlclient.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.bangcle.andjni.JniLib;

public class UIActivity
  extends Activity
{
  static
  {
    JniLib.a(UIActivity.class, 1323);
  }
  
  private native void createAndShowDialogue(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2);
  
  private native void exitApplication();
  
  private native void handleDialogue(String paramString);
  
  private native void handleExitDialogue(Intent paramIntent);
  
  private native void handleNotifyDialogue(Intent paramIntent);
  
  private native void handleRemoteDisableDialogue(Intent paramIntent);
  
  private native void openURL(String paramString);
  
  public native void onCreate(Bundle paramBundle);
  
  public native boolean onCreateOptionsMenu(Menu paramMenu);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\ui\UIActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */