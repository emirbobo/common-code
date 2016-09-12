package org.apache.cordova;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.EditText;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Notification
  extends CordovaPlugin
{
  public int confirmResult = -1;
  public ProgressDialog progressDialog = null;
  public ProgressDialog spinnerDialog = null;
  
  public void activityStart(String paramString1, String paramString2)
  {
    try
    {
      if (this.spinnerDialog != null)
      {
        this.spinnerDialog.dismiss();
        this.spinnerDialog = null;
      }
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local4 = new org/apache/cordova/Notification$4;
      local4.<init>(this, localCordovaInterface, paramString1, paramString2);
      this.cordova.getActivity().runOnUiThread(local4);
      return;
    }
    finally {}
  }
  
  public void activityStop()
  {
    try
    {
      if (this.spinnerDialog != null)
      {
        this.spinnerDialog.dismiss();
        this.spinnerDialog = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void alert(String paramString1, String paramString2, String paramString3, CallbackContext paramCallbackContext)
  {
    try
    {
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local1 = new org/apache/cordova/Notification$1;
      local1.<init>(this, localCordovaInterface, paramString1, paramString2, paramString3, paramCallbackContext);
      this.cordova.getActivity().runOnUiThread(local1);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void beep(long paramLong)
  {
    Uri localUri = RingtoneManager.getDefaultUri(2);
    Ringtone localRingtone = RingtoneManager.getRingtone(this.cordova.getActivity().getBaseContext(), localUri);
    if (localRingtone != null) {
      for (long l1 = 0L; l1 < paramLong; l1 += 1L)
      {
        localRingtone.play();
        long l2 = 5000L;
        while ((localRingtone.isPlaying()) && (l2 > 0L))
        {
          l2 -= 100L;
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
    }
  }
  
  public void confirm(String paramString1, String paramString2, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    try
    {
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local2 = new org/apache/cordova/Notification$2;
      local2.<init>(this, localCordovaInterface, paramString1, paramString2, paramJSONArray, paramCallbackContext);
      this.cordova.getActivity().runOnUiThread(local2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    if (paramString.equals("beep"))
    {
      beep(paramJSONArray.getLong(0));
      paramCallbackContext.success();
    }
    for (;;)
    {
      return bool;
      if (paramString.equals("vibrate"))
      {
        vibrate(paramJSONArray.getLong(0));
        break;
      }
      if (paramString.equals("alert"))
      {
        alert(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getString(2), paramCallbackContext);
      }
      else if (paramString.equals("confirm"))
      {
        confirm(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getJSONArray(2), paramCallbackContext);
      }
      else if (paramString.equals("prompt"))
      {
        prompt(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getJSONArray(2), paramCallbackContext);
      }
      else
      {
        if (paramString.equals("activityStart"))
        {
          activityStart(paramJSONArray.getString(0), paramJSONArray.getString(1));
          break;
        }
        if (paramString.equals("activityStop"))
        {
          activityStop();
          break;
        }
        if (paramString.equals("progressStart"))
        {
          progressStart(paramJSONArray.getString(0), paramJSONArray.getString(1));
          break;
        }
        if (paramString.equals("progressValue"))
        {
          progressValue(paramJSONArray.getInt(0));
          break;
        }
        if (paramString.equals("progressStop"))
        {
          progressStop();
          break;
        }
        bool = false;
      }
    }
  }
  
  public void progressStart(String paramString1, String paramString2)
  {
    try
    {
      if (this.progressDialog != null)
      {
        this.progressDialog.dismiss();
        this.progressDialog = null;
      }
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local5 = new org/apache/cordova/Notification$5;
      local5.<init>(this, this, localCordovaInterface, paramString1, paramString2);
      this.cordova.getActivity().runOnUiThread(local5);
      return;
    }
    finally {}
  }
  
  public void progressStop()
  {
    try
    {
      if (this.progressDialog != null)
      {
        this.progressDialog.dismiss();
        this.progressDialog = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void progressValue(int paramInt)
  {
    try
    {
      if (this.progressDialog != null) {
        this.progressDialog.setProgress(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void prompt(String paramString1, String paramString2, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    try
    {
      CordovaInterface localCordovaInterface = this.cordova;
      EditText localEditText = new android/widget/EditText;
      localEditText.<init>(localCordovaInterface.getActivity());
      Runnable local3 = new org/apache/cordova/Notification$3;
      local3.<init>(this, localCordovaInterface, paramString1, paramString2, localEditText, paramJSONArray, paramCallbackContext);
      this.cordova.getActivity().runOnUiThread(local3);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void vibrate(long paramLong)
  {
    long l = paramLong;
    if (paramLong == 0L) {
      l = 500L;
    }
    ((Vibrator)this.cordova.getActivity().getSystemService("vibrator")).vibrate(l);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Notification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */