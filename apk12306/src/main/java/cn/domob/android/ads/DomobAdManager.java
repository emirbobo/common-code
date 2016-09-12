package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.ads.c.e;
import cn.domob.android.f.d;
import java.util.GregorianCalendar;

public class DomobAdManager
{
  public static final String ACTION_AUDIO = "audio";
  public static final String ACTION_CALL = "call";
  public static final String ACTION_IN_APP = "inapp";
  public static final String ACTION_LAUNCH_APP = "la";
  public static final String ACTION_MAIL = "mail";
  public static final String ACTION_MAP = "map";
  public static final String ACTION_MARKET = "market";
  public static final String ACTION_SMS = "sms";
  public static final String ACTION_URL = "url";
  public static final String ACTION_VIDEO = "video";
  public static final String GENDER_FEMALE = "f";
  public static final String GENDER_MALE = "m";
  public static final String SDK_VER = "20141125";
  public static final String TEST_EMULATOR = "emulator";
  
  @Deprecated
  public static GregorianCalendar getBirthday()
  {
    return null;
  }
  
  public static String getEndpoint()
  {
    return h.a().b();
  }
  
  @Deprecated
  public static String getGender()
  {
    return "";
  }
  
  @Deprecated
  public static String getPostalCode()
  {
    return "";
  }
  
  public static String getPublisherId(Context paramContext)
  {
    return h.a().a(paramContext);
  }
  
  public static String getSDKVersion()
  {
    return e.a();
  }
  
  @Deprecated
  public static void setAllowUseOfLocation(boolean paramBoolean) {}
  
  @Deprecated
  public static void setBirthday(int paramInt1, int paramInt2, int paramInt3)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    setBirthday(localGregorianCalendar);
  }
  
  @Deprecated
  public static void setBirthday(GregorianCalendar paramGregorianCalendar) {}
  
  public static void setEndpoint(String paramString)
  {
    h.a().a(paramString);
    d.a(paramString);
  }
  
  @Deprecated
  public static void setGender(String paramString) {}
  
  @Deprecated
  public static void setIsTestMode(boolean paramBoolean) {}
  
  @Deprecated
  public static void setPostalCode(String paramString) {}
  
  @Deprecated
  public static void setPublisherId(String paramString)
  {
    h.a().b(paramString);
  }
  
  public static enum ErrorCode
  {
    private ErrorCode() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobAdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */