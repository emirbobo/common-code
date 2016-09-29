package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class IntentCompat$IntentCompatImplBase
  implements IntentCompat.IntentCompatImpl
{
  public Intent makeMainActivity(ComponentName paramComponentName)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(paramComponentName);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    return localIntent;
  }
  
  public Intent makeMainSelectorActivity(String paramString1, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addCategory(paramString2);
    return paramString1;
  }
  
  public Intent makeRestartActivityTask(ComponentName paramComponentName)
  {
    paramComponentName = makeMainActivity(paramComponentName);
    paramComponentName.addFlags(268468224);
    return paramComponentName;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\content\IntentCompat$IntentCompatImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */