package com.tl.uic.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.andjni.JniLib;
import com.tl.uic.model.ReachabilityType;

public class ConnectionReceiver
  extends BroadcastReceiver
{
  private Boolean _isOnline = Boolean.valueOf(false);
  private String connectionType;
  private ReachabilityType networkReachability = ReachabilityType.Unknown;
  
  static
  {
    JniLib.a(ConnectionReceiver.class, 1114);
  }
  
  public final native String getConnectionType();
  
  public final native ReachabilityType getNetworkReachability();
  
  public final native Boolean isOnline();
  
  public final native void onReceive(Context paramContext, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ConnectionReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */