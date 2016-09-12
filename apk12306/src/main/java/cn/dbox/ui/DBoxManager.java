package cn.dbox.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.ViewGroup;
import cn.dbox.core.b;
import cn.dbox.core.b.b;
import cn.dbox.core.b.h;
import cn.dbox.core.b.j;
import cn.dbox.core.b.l;
import cn.dbox.core.bean.Entrance.EntryReportType;
import cn.dbox.core.bean.c;
import cn.dbox.core.bean.g;
import cn.dbox.core.bean.g.a;
import cn.dbox.ui.b.d.a;
import cn.dbox.ui.d.f;
import java.util.ArrayList;
import java.util.Iterator;

public class DBoxManager
{
  private static cn.dbox.core.h.d b = new cn.dbox.core.h.d(DBoxManager.class.getSimpleName());
  String a = "16:5";
  private b c;
  private Context d;
  private ArrayList<c> e;
  private ArrayList<cn.dbox.core.bean.a> f;
  private a g;
  private Dialog h;
  private String i;
  private String j;
  private String k;
  private DialogInterface.OnDismissListener l = new DialogInterface.OnDismissListener()
  {
    public void onDismiss(DialogInterface paramAnonymousDialogInterface)
    {
      if ((DBoxManager.h(DBoxManager.this) != null) && (DBoxManager.h(DBoxManager.this).equals("flat")) && (DBoxManager.c(DBoxManager.this) != null)) {
        DBoxManager.c(DBoxManager.this).c();
      }
      if (DBoxManager.a(DBoxManager.this) != null) {
        DBoxManager.a(DBoxManager.this).onDBoxViewClosed();
      }
    }
  };
  private cn.dbox.ui.d.e m = new cn.dbox.ui.d.e()
  {
    public void a() {}
    
    public void b()
    {
      if (DBoxManager.c(DBoxManager.this) != null) {
        DBoxManager.c(DBoxManager.this).b();
      }
    }
    
    public void c()
    {
      if (DBoxManager.l(DBoxManager.this) != null) {
        DBoxManager.l(DBoxManager.this).dismiss();
      }
    }
  };
  private DBoxViewListener n;
  private Dialog o;
  
  public DBoxManager(Context paramContext, String paramString1, String paramString2)
  {
    this.c = new b(paramContext, paramString1, paramString2);
    this.c.a(new b.j()
    {
      public void a()
      {
        if (DBoxManager.a(DBoxManager.this) != null) {
          DBoxManager.a(DBoxManager.this).onLeaveApplication();
        }
      }
    });
    this.d = paramContext;
    this.h = new Dialog(this.d, 16973840);
    this.h.setOnDismissListener(this.l);
    this.h.setOnShowListener(new DialogInterface.OnShowListener()
    {
      public void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        if (DBoxManager.a(DBoxManager.this) != null) {
          DBoxManager.a(DBoxManager.this).onDBoxViewPresent();
        }
      }
    });
  }
  
  private void b()
  {
    this.c.a(new b.l()
    {
      public void a(b.h paramAnonymoush, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        if (DBoxManager.c(DBoxManager.this) != null) {
          DBoxManager.f(DBoxManager.this);
        }
        if (DBoxManager.a(DBoxManager.this) != null) {
          DBoxManager.a(DBoxManager.this).onFailReceiveData("errorCode:" + paramAnonymoush + ",errorContent" + paramAnonymousString1);
        }
      }
      
      public void a(g paramAnonymousg, ArrayList<c> paramAnonymousArrayList, ArrayList<cn.dbox.core.bean.a> paramAnonymousArrayList1, String paramAnonymousString, int paramAnonymousInt)
      {
        DBoxManager.a(DBoxManager.this, paramAnonymousArrayList);
        DBoxManager.b(DBoxManager.this, paramAnonymousArrayList1);
        if (paramAnonymousg != null)
        {
          DBoxManager.a(DBoxManager.this, paramAnonymousg.a());
          paramAnonymousg = paramAnonymousg.b();
          if (paramAnonymousg != null) {
            DBoxManager.b(DBoxManager.this, paramAnonymousg.a());
          }
        }
        paramAnonymousg = paramAnonymousArrayList.iterator();
        if (paramAnonymousg.hasNext())
        {
          paramAnonymousArrayList = (c)paramAnonymousg.next();
          DBoxManager.a().b("Channel:id:" + paramAnonymousArrayList.a() + "name:" + paramAnonymousArrayList.b());
          paramAnonymousArrayList = paramAnonymousArrayList.d().iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            paramAnonymousArrayList1 = (cn.dbox.core.bean.d)paramAnonymousArrayList.next();
            DBoxManager.a().b("ContainerInfo:" + paramAnonymousArrayList1.toString());
            paramAnonymousArrayList1 = paramAnonymousArrayList1.l().iterator();
            while (paramAnonymousArrayList1.hasNext())
            {
              paramAnonymousString = (cn.dbox.core.bean.a)paramAnonymousArrayList1.next();
              DBoxManager.a().b("AdInfo:" + paramAnonymousString.toString());
            }
          }
        }
        if (DBoxManager.c(DBoxManager.this) != null) {
          DBoxManager.d(DBoxManager.this);
        }
        if (DBoxManager.a(DBoxManager.this) != null) {
          DBoxManager.a(DBoxManager.this).onSuccessReceiveData(DBoxManager.e(DBoxManager.this));
        }
      }
    });
    this.c.a();
  }
  
  private void c()
  {
    if (this.k != null) {
      this.j = this.k;
    }
    ((Activity)this.d).runOnUiThread(new Runnable()
    {
      public void run()
      {
        DBoxManager.this.doEntryReports(Entrance.EntryReportType.PRESENTED);
        DBoxManager.c(DBoxManager.this).a(DBoxManager.g(DBoxManager.this), DBoxManager.h(DBoxManager.this), DBoxManager.i(DBoxManager.this), DBoxManager.j(DBoxManager.this), DBoxManager.k(DBoxManager.this));
      }
    });
  }
  
  private void d()
  {
    ((Activity)this.d).runOnUiThread(new Runnable()
    {
      public void run()
      {
        DBoxManager.c(DBoxManager.this).a();
      }
    });
  }
  
  public static String getImei(Context paramContext)
  {
    return cn.dbox.core.h.e.h(paramContext);
  }
  
  public void doEntryReports(Entrance.EntryReportType paramEntryReportType)
  {
    this.c.a(paramEntryReportType);
  }
  
  public void doTicketStartReports()
  {
    this.c.b(null);
  }
  
  public void hideHeadView()
  {
    if (this.g != null) {
      this.g.d();
    }
  }
  
  public void preLoadData()
  {
    b();
  }
  
  public void preloadAdWall()
  {
    this.c.g();
  }
  
  public void presentWall()
  {
    this.k = null;
    presentWall(null, null);
  }
  
  public void presentWall(ViewGroup paramViewGroup)
  {
    this.k = null;
    presentWall(paramViewGroup, null);
  }
  
  public void presentWall(ViewGroup paramViewGroup, String paramString)
  {
    this.g = new a(this.d);
    this.g.a(this.m);
    this.g.a(new f()
    {
      public void a()
      {
        DBoxManager.b(DBoxManager.this);
      }
    });
    if (paramViewGroup == null)
    {
      this.h.setContentView(this.g);
      this.h.show();
      if (paramString != null) {
        this.k = paramString;
      }
      if (this.e != null) {
        break label99;
      }
      b();
    }
    for (;;)
    {
      return;
      hideHeadView();
      paramViewGroup.addView(this.g);
      break;
      label99:
      c();
    }
  }
  
  public void presentWall(String paramString)
  {
    presentWall(null, paramString);
  }
  
  public void sendLandingReport(String paramString1, b.b paramb, String paramString2)
  {
    this.c.a(paramString1, paramb, paramString2);
  }
  
  public void sendTicketInfo(String paramString)
  {
    this.c.b(paramString);
  }
  
  public void setAdWallId(String paramString1, String paramString2)
  {
    if (this.c != null) {
      this.c.a(paramString1, paramString2);
    }
  }
  
  public void setBannerRatio(BannerRatio paramBannerRatio)
  {
    if (paramBannerRatio != null)
    {
      if (BannerRatio.SIXTEENFIVE.ordinal() != paramBannerRatio.ordinal()) {
        break label35;
      }
      this.a = "16:5";
    }
    for (;;)
    {
      this.c.e(this.a);
      return;
      label35:
      if (BannerRatio.THIRTYTWOFIVE.ordinal() == paramBannerRatio.ordinal()) {
        this.a = "32:5";
      }
    }
  }
  
  public void setDBoxViewListener(DBoxViewListener paramDBoxViewListener)
  {
    this.n = paramDBoxViewListener;
  }
  
  public void setEndpoint(String paramString)
  {
    b.c(paramString);
  }
  
  public void showLandingPageAd(final String paramString)
  {
    ((Activity)this.d).runOnUiThread(new Runnable()
    {
      public void run()
      {
        DBoxManager.a(DBoxManager.this, new Dialog(DBoxManager.g(DBoxManager.this), 16973840));
        cn.dbox.ui.b.d locald = new cn.dbox.ui.b.d(DBoxManager.g(DBoxManager.this), paramString, DBoxManager.k(DBoxManager.this));
        locald.a(new d.a()
        {
          public void a()
          {
            if ((DBoxManager.m(DBoxManager.this) != null) && (DBoxManager.m(DBoxManager.this).isShowing())) {
              DBoxManager.m(DBoxManager.this).dismiss();
            }
          }
        });
        DBoxManager.m(DBoxManager.this).setCancelable(false);
        DBoxManager.m(DBoxManager.this).setContentView(locald);
        DBoxManager.m(DBoxManager.this).show();
      }
    });
  }
  
  public static enum BannerRatio
  {
    private BannerRatio() {}
  }
  
  public static abstract interface DBoxViewListener
  {
    public abstract void onDBoxViewClosed();
    
    public abstract void onDBoxViewPresent();
    
    public abstract void onFailReceiveData(String paramString);
    
    public abstract void onLeaveApplication();
    
    public abstract void onSuccessReceiveData(String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\DBoxManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */