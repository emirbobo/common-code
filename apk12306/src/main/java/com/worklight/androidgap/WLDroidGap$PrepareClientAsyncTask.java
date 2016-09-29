package com.worklight.androidgap;

import android.os.AsyncTask;
import android.os.Bundle;
import com.bangcle.andjni.JniLib;

class WLDroidGap$PrepareClientAsyncTask
  extends AsyncTask<Bundle, Void, Bundle>
{
  static
  {
    JniLib.a(PrepareClientAsyncTask.class, 1147);
  }
  
  private WLDroidGap$PrepareClientAsyncTask(WLDroidGap paramWLDroidGap) {}
  
  protected Bundle doInBackground(Bundle... paramVarArgs)
  {
    WLDroidGap.access$500(this.this$0);
    return paramVarArgs[0];
  }
  
  protected native void onPostExecute(Bundle paramBundle);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\WLDroidGap$PrepareClientAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */