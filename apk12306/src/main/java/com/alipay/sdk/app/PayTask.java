package com.alipay.sdk.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.os.Handler;
import com.alipay.sdk.data.MspConfig;
import com.alipay.sdk.protocol.ActionType;
import com.alipay.sdk.sys.GlobalContext;
import com.alipay.sdk.util.FileDownloader;
import com.alipay.sdk.util.PayHelper;
import com.bangcle.andjni.JniLib;

public class PayTask
{
  static final Object a = PayHelper.class;
  private Activity b;
  private String c;
  private Dialog d;
  private FileDownloader e;
  private Handler f;
  private String g;
  private boolean h;
  private String i;
  private Runnable j = new PayTask.4(this);
  private BroadcastReceiver k = new PayTask.5(this);
  
  static
  {
    JniLib.a(PayTask.class, 72);
  }
  
  public PayTask(Activity paramActivity)
  {
    this.b = paramActivity;
    this.f = new Handler(this.b.getMainLooper());
    GlobalContext.a().a(this.b, MspConfig.b());
  }
  
  private native String a();
  
  private native String a(ActionType paramActionType);
  
  private native void a(String paramString1, String paramString2, String paramString3, ActionType[] paramArrayOfActionType1, String paramString4, ActionType[] paramArrayOfActionType2);
  
  private native void a(ActionType[] paramArrayOfActionType);
  
  private native String b();
  
  private native String b(ActionType paramActionType);
  
  private native void c();
  
  private native void d();
  
  public native boolean checkAccountIfExist();
  
  public native String getVersion();
  
  public native String pay(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\app\PayTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */