package com.tl.uic;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.tl.uic.model.Control;
import com.tl.uic.model.Position;
import com.tl.uic.model.Screenview;
import com.tl.uic.model.ScreenviewType;
import com.tl.uic.model.Target;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpResponse;

public class Logger
{
  private static final String textKeyName = "text";
  private Application _application;
  private Activity _currentActivity;
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Control>> _formActivities;
  private Date _previousFocusControlDate;
  private Target _previousFocusTarget;
  private Screenview currentScreenview;
  private Date loadDate;
  
  static
  {
    JniLib.a(Logger.class, 1082);
  }
  
  public Logger(Application paramApplication)
  {
    this._application = paramApplication;
    this._formActivities = new ConcurrentHashMap();
  }
  
  private native Control createControl(View paramView, String paramString, int paramInt);
  
  private native Target createTarget(View paramView);
  
  private native String getControlSubType(View paramView);
  
  private native String getControlType(View paramView);
  
  private native Position getPosition(View paramView);
  
  private native String getPropertyName(View paramView);
  
  private native Boolean getState(Target paramTarget, Object paramObject, String paramString);
  
  private native String getTlEvent(String paramString1, String paramString2);
  
  private native String getTlType(Object paramObject);
  
  private native void setVisitedCount(View paramView, Target paramTarget);
  
  private native Object trimAndMaskValueForControl(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3);
  
  protected final native Boolean enable(String paramString);
  
  protected final native long getApplicationScreenviewOffset();
  
  public final native Screenview getCurrentScreenview();
  
  protected final native Boolean logConnection(String paramString, HttpResponse paramHttpResponse, long paramLong1, long paramLong2, long paramLong3);
  
  protected final native Boolean logCustomEvent(String paramString, HashMap<String, String> paramHashMap, int paramInt);
  
  protected final native Boolean logEvent(View paramView, String paramString, int paramInt);
  
  protected final native Boolean logException(Throwable paramThrowable, String paramString);
  
  protected final native Boolean logException(Throwable paramThrowable, String paramString, HashMap<String, String> paramHashMap);
  
  protected final native Boolean logException(Throwable paramThrowable, HashMap<String, String> paramHashMap);
  
  protected final native Boolean logScreenview(Activity paramActivity, String paramString1, ScreenviewType paramScreenviewType, String paramString2);
  
  protected final native Boolean logTLLibErrorException(Throwable paramThrowable, String paramString);
  
  protected final native Boolean onDestroy(String paramString);
  
  protected final native Boolean onPause(Activity paramActivity, String paramString);
  
  protected final native Boolean onPauseNoActivityInForeground();
  
  protected final native Boolean onResume(String paramString, Activity paramActivity);
  
  protected final native Boolean registerFormField(View paramView, Activity paramActivity, int paramInt);
  
  protected final native Boolean startSession(String paramString);
  
  protected final native Boolean terminate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */