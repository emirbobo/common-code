package com.tl.uic.util;

import android.os.AsyncTask;
import com.tl.uic.EnvironmentalData;
import com.tl.uic.TLFCache;
import com.tl.uic.Tealeaf;

public class ClientStateTask
  extends AsyncTask<Void, Void, Boolean>
{
  protected final Boolean doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = Boolean.valueOf(false);
    arrayOfVoid = paramVarArgs;
    for (;;)
    {
      try
      {
        if (TLFCache.getEnvironmentalData() != null) {
          continue;
        }
        arrayOfVoid = paramVarArgs;
        paramVarArgs = Boolean.valueOf(false);
        arrayOfVoid = paramVarArgs;
        localObject = new java/lang/StringBuilder;
        arrayOfVoid = paramVarArgs;
        ((StringBuilder)localObject).<init>("Did Client State change?: ");
        arrayOfVoid = paramVarArgs;
        LogInternal.log(paramVarArgs);
        localObject = paramVarArgs;
        arrayOfVoid = paramVarArgs;
        if (Tealeaf.isApplicationInBackground().booleanValue())
        {
          arrayOfVoid = paramVarArgs;
          Tealeaf.onPauseNoActivityInForeground();
          localObject = paramVarArgs;
        }
      }
      catch (Exception paramVarArgs)
      {
        LogInternal.logException(paramVarArgs);
        Object localObject = arrayOfVoid;
        continue;
      }
      return (Boolean)localObject;
      arrayOfVoid = paramVarArgs;
      TLFCache.getEnvironmentalData().onResume();
      arrayOfVoid = paramVarArgs;
      paramVarArgs = TLFCache.getEnvironmentalData().hasClientStateChanged();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ClientStateTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */