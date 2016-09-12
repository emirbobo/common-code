package org.apache.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

class NetworkManager$1
  extends BroadcastReceiver
{
  NetworkManager$1(NetworkManager paramNetworkManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.webView != null) {
      NetworkManager.access$000(this.this$0, this.this$0.sockMan.getActiveNetworkInfo());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NetworkManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */