package cn.dbox.core.d;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import java.util.Hashtable;

public class d
  extends Activity
{
  public static final String a = "ActivityType";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final String h = "msg";
  public static final String i = "webview_url";
  private static cn.dbox.core.h.d j = new cn.dbox.core.h.d(d.class.getSimpleName());
  private Context k = this;
  private String l = "";
  
  private void a()
  {
    if (getIntent().getExtras() != null)
    {
      Object localObject = getIntent();
      String str = ((Intent)localObject).getStringExtra("appName");
      this.l = ((Intent)localObject).getStringExtra("appId");
      localObject = ((Intent)localObject).getStringExtra("actType");
      if ((localObject != null) && (((String)localObject).equals("typeCancel"))) {
        new AlertDialog.Builder(this.k).setTitle("取消").setMessage(str + "正在下载是否取消?").setNegativeButton("取消下载", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface = (b)b.a.get(d.a(d.this));
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.b();
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.a();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.b();
              }
            }
            d.this.finish();
          }
        }).setPositiveButton("继续下载", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            d.this.finish();
          }
        }).show();
      }
    }
  }
  
  private void b()
  {
    if (getIntent().getExtras() != null)
    {
      String str = getIntent().getStringExtra("msg");
      new AlertDialog.Builder(this.k).setMessage(str).setNegativeButton("确定", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          d.this.finish();
        }
      }).show();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle)
  {
    int m = getIntent().getIntExtra("ActivityType", 0);
    j.b("intent activity type " + m);
    switch (m)
    {
    default: 
      finish();
    }
    for (;;)
    {
      return;
      super.onCreate(paramBundle);
      a();
      continue;
      setTheme(16973835);
      super.onCreate(paramBundle);
      continue;
      super.onCreate(paramBundle);
      b();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */