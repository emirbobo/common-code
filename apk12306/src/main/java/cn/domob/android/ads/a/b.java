package cn.domob.android.ads.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import cn.domob.android.ads.a.a;
import cn.domob.android.ads.c.c;
import cn.domob.android.i.d;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.io.File;
import java.util.HashMap;

public class b
{
  private static final String a = "cb";
  private static final String b = "cb";
  private static final String c = "picture";
  private static final String d = "submit";
  private static final String e = "local";
  private static final String f = "url";
  private static final String g = "name";
  private static final int h = 0;
  private static final int i = 1;
  private static final String j = "src";
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private static f n = new f(b.class.getSimpleName());
  private static final int p = 2345;
  private static final int q = 2346;
  private static String r = Environment.getExternalStorageDirectory() + "/DCIM/camera/";
  private static final String s = "activity_view_id";
  private Activity o = null;
  private e t = null;
  private String u = "";
  private String v = "";
  private final int w = 60;
  private final int x = 60;
  private Handler y = null;
  private Uri z;
  
  public b(Activity paramActivity)
  {
    this.o = paramActivity;
    this.t = a(this.o);
  }
  
  private RelativeLayout a(e parame)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.o);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    parame = new ImageButton(this.o);
    parame.setBackgroundDrawable(d.b(this.o, "domob_close.png"));
    parame.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        b.e(b.this).finish();
      }
    });
    float f1 = cn.domob.android.b.a.t(this.o);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(60.0F * f1), (int)(f1 * 60.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    parame.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(this.t);
    localRelativeLayout.addView(parame);
    return localRelativeLayout;
  }
  
  private e a(Activity paramActivity)
  {
    paramActivity = new e(paramActivity, "activity_view_id", -1);
    paramActivity.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    return paramActivity;
  }
  
  private String a(Uri paramUri)
  {
    for (;;)
    {
      try
      {
        localObject = n;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        ((f)localObject).b("select uri is " + paramUri.toString());
        localObject = this.o.managedQuery(paramUri, new String[] { "_data" }, null, null, null);
        if (localObject != null) {
          continue;
        }
        paramUri = paramUri.toString();
        if ((paramUri == null) || (!paramUri.startsWith("file://")) || ((!paramUri.endsWith(".jpg")) && (!paramUri.toString().endsWith(".JPG")))) {
          continue;
        }
        paramUri = paramUri.replaceFirst("file://", "");
      }
      catch (Exception paramUri)
      {
        Object localObject;
        int i1;
        paramUri = paramUri;
        n.a(paramUri);
        paramUri = "";
        continue;
      }
      finally {}
      return paramUri;
      paramUri = "";
      continue;
      i1 = ((Cursor)localObject).getColumnIndexOrThrow("_data");
      ((Cursor)localObject).moveToFirst();
      paramUri = ((Cursor)localObject).getString(i1);
    }
  }
  
  private void a(Uri paramUri, int paramInt)
  {
    if (this.o.getIntent().getExtras() != null) {
      this.u = ((String)h.a(paramUri.getEncodedQuery()).get("cb"));
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      new AlertDialog.Builder(this.o).setTitle("选择方式").setMessage("选择上传图片的方式").setNegativeButton("从已有相册中选择", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          b.c(b.this);
        }
      }).setPositiveButton("照相获得图片", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          b.b(b.this);
        }
      }).show();
      continue;
      c();
      continue;
      e();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new b(paramString1, paramString2, paramString3, paramString4);
    this.y = new c(this.o, paramString4);
    paramString1.start();
  }
  
  private boolean c()
  {
    PackageManager localPackageManager = this.o.getPackageManager();
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = new File(r);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    this.v = d();
    localIntent.putExtra("output", Uri.fromFile(new File(this.v)));
    if (localPackageManager.resolveActivity(localIntent, 65536) != null) {
      this.o.startActivityForResult(localIntent, 2345);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static String d()
  {
    return r + "up" + h.a() + ".jpg";
  }
  
  private boolean e()
  {
    PackageManager localPackageManager = this.o.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType("image/*");
    if (localPackageManager.resolveActivity(localIntent, 65536) != null) {
      this.o.startActivityForResult(localIntent, 2346);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a()
  {
    Bundle localBundle = this.o.getIntent().getExtras();
    Object localObject = "";
    if (localBundle != null) {
      localObject = this.o.getIntent().getStringExtra("webview_url");
    }
    this.t.loadUrl((String)localObject);
    this.t.a(new a());
    localObject = a(this.t);
    this.o.setContentView((View)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      n.b("update the pic taken");
      n.a("photo saving path=" + this.v);
      if (new File(this.v).exists())
      {
        paramIntent = "javascript:" + this.u + "(true,'file://" + this.v + "')";
        n.a("excute js " + paramIntent);
        this.t.loadUrl(paramIntent);
        continue;
        n.b("update the pic selected");
        if (paramIntent == null)
        {
          n.b("album select url is null");
        }
        else
        {
          this.z = paramIntent.getData();
          paramIntent = a(this.z);
          if ((paramIntent == null) || (paramIntent.equals("")))
          {
            Toast.makeText(this.o, "上传格式有误,请尝试重新选择上传图片", 1).show();
          }
          else if (new File(paramIntent).length() >= 3145728L)
          {
            n.d("the size of upload pic is larger than 3M");
            Toast.makeText(this.o, "上传图片尺寸不能大于3M,请尝试重新选择上传图片", 1).show();
          }
          else
          {
            paramIntent = "javascript:" + this.u + "(true,'file://" + paramIntent + "')";
            n.a("excute js " + paramIntent);
            this.t.loadUrl(paramIntent);
          }
        }
      }
    }
  }
  
  class a
    implements a.a
  {
    a() {}
    
    public void a(cn.domob.android.ads.a parama, String paramString)
    {
      b.b().b("Activity WebView 拦截到 URL：" + paramString);
      parama = Uri.parse(paramString);
      paramString = parama.getHost();
      if (paramString.equals("picture"))
      {
        int i = Integer.parseInt((String)h.a(parama.getEncodedQuery()).get("src"));
        b.a(b.this, parama, i);
      }
      for (;;)
      {
        return;
        if (paramString.equals("submit"))
        {
          Object localObject = h.a(parama.getEncodedQuery());
          paramString = (String)((HashMap)localObject).get("name");
          String str = (String)((HashMap)localObject).get("local");
          parama = (String)((HashMap)localObject).get("url");
          localObject = (String)((HashMap)localObject).get("cb");
          b.a(b.this, paramString, str, parama, (String)localObject);
        }
        else
        {
          b.b().e("Handle unknown action : " + paramString + " in activity");
        }
      }
    }
  }
  
  class b
    extends Thread
  {
    private String b;
    private String c;
    
    b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.b = paramString2;
      this.c = paramString3;
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          if ((this.b == null) || (this.b.length() == 0))
          {
            b.b().a("local path is null");
            return;
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          Bitmap localBitmap;
          Object localObject1;
          long l;
          if (b.a(b.this) == null) {
            continue;
          }
          b.a(b.this).sendEmptyMessage(1);
          b.b().a(localException);
          continue;
          b.a(b.this).sendEmptyMessage(1);
          continue;
        }
        catch (Error localError)
        {
          if (b.a(b.this) == null) {
            continue;
          }
          b.a(b.this).sendEmptyMessage(1);
          b.b().a(localError);
          continue;
        }
        localObject2 = this.b;
        localBitmap = BitmapFactory.decodeFile((String)localObject2);
        localObject1 = new java/io/File;
        ((File)localObject1).<init>((String)localObject2);
        l = ((File)localObject1).length();
        localObject2 = b.b();
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((f)localObject2).a("The size of pic taken =" + l);
        if (!c.a(localBitmap, l, this.c)) {
          continue;
        }
        b.a(b.this).sendEmptyMessage(0);
      }
    }
  }
  
  class c
    extends Handler
  {
    private String b = "";
    
    c(Context paramContext, String paramString)
    {
      this.b = paramString;
    }
    
    private void a(String paramString, boolean paramBoolean)
    {
      paramString = "javascript:" + paramString + "('" + paramBoolean + "')";
      b.b().a("excute js " + paramString);
      if (b.d(b.this) != null) {
        b.d(b.this).loadUrl(paramString);
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        a(this.b, false);
        b.b().b("upload picture failed");
        continue;
        a(this.b, true);
        b.b().b("upload picture successful");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */