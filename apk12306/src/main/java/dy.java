import android.content.Context;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;
import com.arrownock.push.IAnPushRegisterAnIdCallback;
import com.arrownock.push.IAnPushRegistrationCallback;
import com.arrownock.push.IAnPushSettingsCallback;
import org.json.JSONArray;

public abstract interface dy
{
  public abstract cp<String, Integer> a(String paramString)
    throws ArrownockException;
  
  public abstract String a(Context paramContext)
    throws ArrownockException;
  
  public abstract String a(Context paramContext, String paramString);
  
  public abstract String a(String paramString);
  
  public abstract JSONArray a(String paramString)
    throws ArrownockException;
  
  public abstract void a()
    throws ArrownockException;
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, IAnPushRegisterAnIdCallback paramIAnPushRegisterAnIdCallback);
  
  public abstract void a(String paramString1, String paramString2);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, IAnPushCallback paramIAnPushCallback);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, IAnPushCallback paramIAnPushCallback);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2, int paramInt, IAnPushCallback paramIAnPushCallback);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2, IAnPushCallback paramIAnPushCallback);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2, IAnPushCallback paramIAnPushCallback, boolean paramBoolean, String paramString3, String paramString4);
  
  public abstract void a(String paramString1, String paramString2, IAnPushRegistrationCallback paramIAnPushRegistrationCallback, boolean paramBoolean, String paramString3, String paramString4);
  
  public abstract void a(String paramString1, String paramString2, IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2, String paramString3, IAnPushCallback paramIAnPushCallback, boolean paramBoolean, String paramString4);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, IAnPushRegistrationCallback paramIAnPushRegistrationCallback, boolean paramBoolean, String paramString4);
  
  public abstract JSONArray b(String paramString)
    throws ArrownockException;
  
  @Deprecated
  public abstract void b(String paramString1, String paramString2, IAnPushCallback paramIAnPushCallback);
  
  public abstract void b(String paramString1, String paramString2, IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  @Deprecated
  public abstract void c(String paramString1, String paramString2, IAnPushCallback paramIAnPushCallback);
  
  public abstract void c(String paramString1, String paramString2, IAnPushSettingsCallback paramIAnPushSettingsCallback);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */