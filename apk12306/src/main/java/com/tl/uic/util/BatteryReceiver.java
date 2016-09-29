package com.tl.uic.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;

public class BatteryReceiver
  extends BroadcastReceiver
{
  private int health = -1;
  private int plugged = -1;
  private boolean present = false;
  private int scale = -1;
  private int status = -1;
  private String technology;
  private int temperature = -1;
  private int value = -1;
  private int voltage = -1;
  
  static
  {
    JniLib.a(BatteryReceiver.class, 1112);
  }
  
  public final native int getHealth();
  
  public final native int getPlugged();
  
  public final native int getScale();
  
  public final native int getStatus();
  
  public final native String getTechnology();
  
  public final native int getTemperature();
  
  public final native int getValue();
  
  public final native int getVoltage();
  
  public final native boolean isPresent();
  
  public final native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\BatteryReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */