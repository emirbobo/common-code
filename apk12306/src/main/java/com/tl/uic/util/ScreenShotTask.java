package com.tl.uic.util;

import android.os.AsyncTask;
import android.view.View;
import com.tl.uic.Tealeaf;

public class ScreenShotTask
  extends AsyncTask<View, Void, Boolean>
{
  protected final Boolean doInBackground(View... paramVarArgs)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    try
    {
      paramVarArgs = Tealeaf.takeScreenShot(paramVarArgs[0], paramVarArgs[0].getClass().getName());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        LogInternal.logException(paramVarArgs);
        paramVarArgs = localBoolean;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ScreenShotTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */