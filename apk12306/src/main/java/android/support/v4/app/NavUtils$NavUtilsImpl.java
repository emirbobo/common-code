package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

abstract interface NavUtils$NavUtilsImpl
{
  public abstract Intent getParentActivityIntent(Activity paramActivity);
  
  public abstract String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo);
  
  public abstract void navigateUpTo(Activity paramActivity, Intent paramIntent);
  
  public abstract boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\NavUtils$NavUtilsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */