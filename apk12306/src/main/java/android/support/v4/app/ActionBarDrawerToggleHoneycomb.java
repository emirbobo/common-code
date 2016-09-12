package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb
{
  private static final String TAG = "ActionBarDrawerToggleHoneycomb";
  private static final int[] THEME_ATTRS = { 16843531 };
  
  public static Drawable getThemeUpIndicator(Activity paramActivity)
  {
    TypedArray localTypedArray = paramActivity.obtainStyledAttributes(THEME_ATTRS);
    paramActivity = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return paramActivity;
  }
  
  public static Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = new SetIndicatorInfo(paramActivity);
    }
    paramObject = (SetIndicatorInfo)localObject;
    if (((SetIndicatorInfo)paramObject).setHomeAsUpIndicator != null) {}
    try
    {
      paramActivity = paramActivity.getActionBar();
      ((SetIndicatorInfo)paramObject).setHomeActionContentDescription.invoke(paramActivity, new Object[] { Integer.valueOf(paramInt) });
      return localObject;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", (Throwable)paramObject);
      }
    }
  }
  
  public static Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = new SetIndicatorInfo(paramActivity);
    }
    paramObject = (SetIndicatorInfo)localObject;
    if (((SetIndicatorInfo)paramObject).setHomeAsUpIndicator != null) {}
    for (;;)
    {
      try
      {
        paramActivity = paramActivity.getActionBar();
        ((SetIndicatorInfo)paramObject).setHomeAsUpIndicator.invoke(paramActivity, new Object[] { paramDrawable });
        ((SetIndicatorInfo)paramObject).setHomeActionContentDescription.invoke(paramActivity, new Object[] { Integer.valueOf(paramInt) });
        return localObject;
      }
      catch (Exception paramObject)
      {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", (Throwable)paramObject);
        continue;
      }
      if (((SetIndicatorInfo)paramObject).upIndicatorView != null) {
        ((SetIndicatorInfo)paramObject).upIndicatorView.setImageDrawable(paramDrawable);
      } else {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
      }
    }
  }
  
  private static class SetIndicatorInfo
  {
    public Method setHomeActionContentDescription;
    public Method setHomeAsUpIndicator;
    public ImageView upIndicatorView;
    
    SetIndicatorInfo(Activity paramActivity)
    {
      label115:
      label116:
      for (;;)
      {
        Object localObject;
        try
        {
          this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
          this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { Integer.TYPE });
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramActivity = paramActivity.findViewById(16908332);
          if (paramActivity == null) {
            continue;
          }
          localObject = (ViewGroup)paramActivity.getParent();
          if (((ViewGroup)localObject).getChildCount() != 2) {
            continue;
          }
          paramActivity = ((ViewGroup)localObject).getChildAt(0);
          localObject = ((ViewGroup)localObject).getChildAt(1);
          if (paramActivity.getId() != 16908332) {
            break label115;
          }
        }
        paramActivity = (Activity)localObject;
        for (;;)
        {
          if (!(paramActivity instanceof ImageView)) {
            break label116;
          }
          this.upIndicatorView = ((ImageView)paramActivity);
          break;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\ActionBarDrawerToggleHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */