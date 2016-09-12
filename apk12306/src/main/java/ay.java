import android.content.Context;
import com.arrownock.im.AnIMStatus;
import com.arrownock.im.callback.IAnIMCallback;
import com.arrownock.im.callback.IAnIMGetClientIdCallback;
import com.arrownock.im.callback.IAnIMGetClientsStatusCallback;
import com.arrownock.im.callback.IAnIMGetTopicInfoCallback;
import com.arrownock.im.callback.IAnIMGetTopicListCallback;
import com.arrownock.im.callback.IAnIMHistoryCallback;
import com.arrownock.im.callback.IAnIMPushBindingCallback;
import com.arrownock.im.callback.IAnIMPushNotificationSettingsCallback;
import com.arrownock.im.callback.IAnIMTopicCallback;
import java.util.List;
import java.util.Set;

public abstract interface ay
{
  public abstract AnIMStatus a();
  
  public abstract String a();
  
  public abstract void a(Context paramContext);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2);
  
  public abstract void a(bi parambi);
  
  public abstract void a(IAnIMCallback paramIAnIMCallback);
  
  public abstract void a(String paramString);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, IAnIMGetClientIdCallback paramIAnIMGetClientIdCallback);
  
  public abstract void a(String paramString1, String paramString2, IAnIMGetClientsStatusCallback paramIAnIMGetClientsStatusCallback);
  
  public abstract void a(String paramString1, String paramString2, IAnIMGetTopicInfoCallback paramIAnIMGetTopicInfoCallback);
  
  public abstract void a(String paramString1, String paramString2, IAnIMGetTopicListCallback paramIAnIMGetTopicListCallback);
  
  public abstract void a(String paramString1, String paramString2, IAnIMPushBindingCallback paramIAnIMPushBindingCallback);
  
  public abstract void a(String paramString1, String paramString2, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, boolean paramBoolean, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  @Deprecated
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IAnIMPushBindingCallback paramIAnIMPushBindingCallback);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean);
  
  public abstract void a(String paramString1, String paramString2, List<String> paramList, String paramString3);
  
  public abstract void a(String paramString1, Set<String> paramSet, String paramString2, int paramInt, long paramLong, boolean paramBoolean, IAnIMHistoryCallback paramIAnIMHistoryCallback);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt, List<String> paramList, IAnIMPushNotificationSettingsCallback paramIAnIMPushNotificationSettingsCallback);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract String b();
  
  public abstract void b(String paramString);
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void b(String paramString1, String paramString2, IAnIMGetClientsStatusCallback paramIAnIMGetClientsStatusCallback);
  
  @Deprecated
  public abstract void b(String paramString1, String paramString2, String paramString3);
  
  public abstract void b(String paramString1, String paramString2, String paramString3, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  @Deprecated
  public abstract void b(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void b(String paramString1, String paramString2, String paramString3, String paramString4, IAnIMTopicCallback paramIAnIMTopicCallback);
  
  @Deprecated
  public abstract void c(String paramString1, String paramString2);
  
  @Deprecated
  public abstract void c(String paramString1, String paramString2, String paramString3, String paramString4);
  
  @Deprecated
  public abstract void d(String paramString1, String paramString2);
  
  @Deprecated
  public abstract void d(String paramString1, String paramString2, String paramString3);
  
  public abstract void e(String paramString1, String paramString2);
  
  @Deprecated
  public abstract void f(String paramString1, String paramString2);
  
  @Deprecated
  public abstract void g(String paramString1, String paramString2);
  
  @Deprecated
  public abstract void h(String paramString1, String paramString2);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void j(String paramString1, String paramString2);
  
  @Deprecated
  public abstract void k(String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */