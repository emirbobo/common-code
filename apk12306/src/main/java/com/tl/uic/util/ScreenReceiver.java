package com.tl.uic.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import com.bangcle.andjni.JniLib;

public class ScreenReceiver
  extends BroadcastReceiver
{
  private static final int ROTATION_18O = 180;
  private static final int ROTATION_9O = 90;
  private static final int ROTATION_NEGATIVE_9O = -90;
  private static final int ROTATION_O = 0;
  private int height;
  private int rotation = 0;
  private int width;
  
  static
  {
    JniLib.a(ScreenReceiver.class, 1125);
  }
  
  public ScreenReceiver()
  {
    screenUpdate();
  }
  
  private native Display screenUpdate();
  
  public final native int getHeight();
  
  public final native int getRotation();
  
  public final native int getWidth();
  
  public final native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ScreenReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */