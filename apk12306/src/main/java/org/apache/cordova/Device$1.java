package org.apache.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import org.apache.cordova.api.LOG;

class Device$1
  extends BroadcastReceiver
{
  Device$1(Device paramDevice) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equals("android.intent.action.PHONE_STATE")) && (paramIntent.hasExtra("state")))
    {
      paramContext = paramIntent.getStringExtra("state");
      if (!paramContext.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
        break label64;
      }
      LOG.i("Device", "Telephone RINGING");
      this.this$0.webView.postMessage("telephone", "ringing");
    }
    for (;;)
    {
      return;
      label64:
      if (paramContext.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
      {
        LOG.i("Device", "Telephone OFFHOOK");
        this.this$0.webView.postMessage("telephone", "offhook");
      }
      else if (paramContext.equals(TelephonyManager.EXTRA_STATE_IDLE))
      {
        LOG.i("Device", "Telephone IDLE");
        this.this$0.webView.postMessage("telephone", "idle");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Device$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */