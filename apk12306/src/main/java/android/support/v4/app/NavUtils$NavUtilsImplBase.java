package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.util.Log;

class NavUtils$NavUtilsImplBase
  implements NavUtils.NavUtilsImpl
{
  public Intent getParentActivityIntent(Activity paramActivity)
  {
    Object localObject = null;
    String str = NavUtils.getParentActivityName(paramActivity);
    if (str == null) {
      paramActivity = (Activity)localObject;
    }
    for (;;)
    {
      return paramActivity;
      ComponentName localComponentName = new ComponentName(paramActivity, str);
      try
      {
        if (NavUtils.getParentActivityName(paramActivity, localComponentName) == null) {}
        for (paramActivity = IntentCompat.makeMainActivity(localComponentName);; paramActivity = paramActivity.setComponent(localComponentName))
        {
          break;
          paramActivity = new android/content/Intent;
          paramActivity.<init>();
        }
      }
      catch (PackageManager.NameNotFoundException paramActivity)
      {
        Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + str + "' in manifest");
        paramActivity = (Activity)localObject;
      }
    }
  }
  
  public String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
  {
    if (paramActivityInfo.metaData == null) {
      paramActivityInfo = null;
    }
    for (;;)
    {
      return paramActivityInfo;
      String str = paramActivityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
      if (str == null)
      {
        paramActivityInfo = null;
      }
      else
      {
        paramActivityInfo = str;
        if (str.charAt(0) == '.') {
          paramActivityInfo = paramContext.getPackageName() + str;
        }
      }
    }
  }
  
  public void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.addFlags(67108864);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    paramActivity = paramActivity.getIntent().getAction();
    if ((paramActivity != null) && (!paramActivity.equals("android.intent.action.MAIN"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\NavUtils$NavUtilsImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */