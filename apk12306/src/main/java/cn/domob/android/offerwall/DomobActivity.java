package cn.domob.android.offerwall;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import cn.domob.android.a.a;
import cn.domob.android.a.c;
import java.util.Hashtable;

public class DomobActivity
  extends Activity
{
  public static final String ACTIVITY_TYPE = "DomobActivityType";
  public static final String EXPAND_BASE_URL = "ex_base_url";
  public static final String EXPAND_CONTENT = "ex_content";
  public static final String EXPAND_URL = "ex_url";
  public static final String NOTICE_MESSAGE = "msg";
  public static final int TYPE_DOWNLOADER = 2;
  public static final int TYPE_EXPAND = 4;
  public static final int TYPE_INSTALL_RECEIVER = 1;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_NOTICE = 3;
  public static final int TYPE_UPLOAD_PIC = 5;
  private static m a = new m(DomobActivity.class.getSimpleName());
  private Context b = this;
  private String c = "";
  
  private void a()
  {
    if (getIntent().getExtras() != null)
    {
      Object localObject = getIntent();
      String str = ((Intent)localObject).getStringExtra("appName");
      this.c = ((Intent)localObject).getStringExtra("appId");
      localObject = ((Intent)localObject).getStringExtra("actType");
      if ((localObject != null) && (((String)localObject).equals("typeCancel"))) {
        new AlertDialog.Builder(this.b).setTitle("取消").setMessage(str + "正在下载是否取消?").setNegativeButton("取消下载", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface = (a)a.a.get(DomobActivity.a(DomobActivity.this));
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.b();
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.a();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.b();
              }
            }
            DomobActivity.this.finish();
          }
        }).setPositiveButton("继续下载", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            DomobActivity.this.finish();
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
      new AlertDialog.Builder(this.b).setMessage(str).setNegativeButton("确定", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          DomobActivity.this.finish();
        }
      }).show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = getIntent().getIntExtra("DomobActivityType", 0);
    a.a("Activity type: " + i);
    switch (i)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\DomobActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */