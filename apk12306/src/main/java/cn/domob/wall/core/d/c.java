package cn.domob.wall.core.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.f;

class c
{
  static final int a = 45;
  private static d g = new d(c.class.getSimpleName());
  private static final String h = "e_close.png";
  private static final String i = "e_back.png";
  private static final String j = "e_forward.png";
  private static final String k = "e_back_c.png";
  private static final String l = "e_forward_c.png";
  private static final String m = "e_refresh.png";
  private static final int n = 24;
  private static final int o = 24;
  private static final int p = 24;
  private static final int q = -268435456;
  private static final int r = 20;
  private static final int s = -3026479;
  ImageButton b;
  ImageButton c;
  ProgressBar d;
  ImageView e;
  RotateAnimation f;
  private Context t;
  private a u;
  private String v;
  
  protected c(Context paramContext, String paramString, a parama)
  {
    this.t = paramContext;
    this.v = paramString;
    this.u = parama;
  }
  
  private Drawable a(Context paramContext, String paramString)
  {
    if (!f.a(paramString)) {}
    for (;;)
    {
      try
      {
        paramContext = new android/graphics/drawable/BitmapDrawable;
        ClassLoader localClassLoader = c.class.getClassLoader();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        paramContext.<init>(BitmapFactory.decodeStream(localClassLoader.getResourceAsStream("assets/" + paramString)));
        return paramContext;
      }
      catch (Exception paramContext)
      {
        g.a(paramContext);
      }
      paramContext = null;
    }
  }
  
  private void a(ImageButton paramImageButton, String paramString)
  {
    if ((paramImageButton != null) && (!f.a(paramString))) {
      paramImageButton.setBackgroundDrawable(a(this.t, paramString));
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView != null) && (paramRelativeLayout != null)) {
      paramRelativeLayout.addView(paramView);
    }
  }
  
  private RelativeLayout b(int paramInt)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.t);
    localRelativeLayout.setBackgroundColor(-268435456);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, c(paramInt)));
    localRelativeLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    return localRelativeLayout;
  }
  
  private int c(int paramInt)
  {
    return (int)(this.t.getResources().getDisplayMetrics().density * paramInt);
  }
  
  private void g()
  {
    this.f = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.f.setDuration(1000L);
    this.f.setInterpolator(new LinearInterpolator());
    this.f.setRepeatCount(-1);
  }
  
  private void h()
  {
    int i2 = 1;
    int i1;
    if (this.e != null)
    {
      i1 = 1;
      if (this.f == null) {
        break label49;
      }
    }
    for (;;)
    {
      if ((i1 & i2) != 0)
      {
        this.e.setVisibility(0);
        this.e.startAnimation(this.f);
      }
      return;
      i1 = 0;
      break;
      label49:
      i2 = 0;
    }
  }
  
  private void i()
  {
    int i2 = 1;
    int i1;
    if (this.e != null)
    {
      i1 = 1;
      if (this.f == null) {
        break label37;
      }
    }
    for (;;)
    {
      if ((i1 & i2) != 0) {
        this.e.clearAnimation();
      }
      return;
      i1 = 0;
      break;
      label37:
      i2 = 0;
    }
  }
  
  protected ImageButton a()
  {
    ImageButton localImageButton = new ImageButton(this.t);
    a(localImageButton, "e_close.png");
    localImageButton.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = a(this.t, 24, 24);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    localLayoutParams.rightMargin = c(10);
    localImageButton.setLayoutParams(localLayoutParams);
    localImageButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.a(c.this) != null) {
          c.a(c.this).a();
        }
      }
    });
    return localImageButton;
  }
  
  protected RelativeLayout.LayoutParams a(Context paramContext, int paramInt1, int paramInt2)
  {
    return b(paramContext, c(paramInt1), c(paramInt2));
  }
  
  protected TextView a(String paramString)
  {
    TextView localTextView = new TextView(this.t);
    localTextView.setTextSize(20.0F);
    localTextView.setTextColor(-3026479);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localTextView.setText(paramString);
    localTextView.setLayoutParams(localLayoutParams);
    return localTextView;
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == 100)
    {
      this.d.setVisibility(4);
      i();
    }
    for (;;)
    {
      return;
      this.d.setVisibility(0);
      this.d.setProgress(paramInt);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(this.b, "e_back.png");
      if (!paramBoolean2) {
        break label42;
      }
      a(this.c, "e_forward.png");
    }
    for (;;)
    {
      return;
      a(this.b, "e_back.png");
      break;
      label42:
      a(this.c, "e_forward_c.png");
    }
  }
  
  protected ImageButton b()
  {
    this.b = new ImageButton(this.t);
    a(this.b, "e_back.png");
    RelativeLayout.LayoutParams localLayoutParams = a(this.t, 24, 24);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = c(5);
    this.b.setLayoutParams(localLayoutParams);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.a(c.this) != null) {
          c.a(c.this).b();
        }
      }
    });
    this.b.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          c.a(c.this, c.this.b, "e_back_c.png");
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            c.a(c.this, c.this.b, "e_back.png");
          }
        }
      }
    });
    return this.b;
  }
  
  protected RelativeLayout.LayoutParams b(Context paramContext, int paramInt1, int paramInt2)
  {
    return new RelativeLayout.LayoutParams(paramInt1, paramInt2);
  }
  
  protected ImageButton c()
  {
    this.c = new ImageButton(this.t);
    a(this.c, "e_forward_c.png");
    RelativeLayout.LayoutParams localLayoutParams = a(this.t, 24, 24);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = c(50);
    this.c.setLayoutParams(localLayoutParams);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.a(c.this) != null) {
          c.a(c.this).c();
        }
      }
    });
    this.c.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          c.a(c.this, c.this.c, "e_forward_c.png");
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            c.a(c.this, c.this.c, "e_forward.png");
          }
        }
      }
    });
    return this.c;
  }
  
  protected ImageView d()
  {
    g();
    this.e = new ImageView(this.t);
    this.e.setBackgroundDrawable(a(this.t, "e_refresh.png"));
    RelativeLayout.LayoutParams localLayoutParams = a(this.t, 24, 24);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.leftMargin = c(95);
    this.e.setLayoutParams(localLayoutParams);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        c.b(c.this);
        if (c.a(c.this) != null) {
          c.a(c.this).d();
        }
      }
    });
    return this.e;
  }
  
  protected ProgressBar e()
  {
    this.d = new ProgressBar(this.t, null, 16842872);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, c(3));
    localLayoutParams.addRule(12);
    this.d.setLayoutParams(localLayoutParams);
    this.d.setProgress(30);
    return this.d;
  }
  
  protected RelativeLayout f()
  {
    RelativeLayout localRelativeLayout = b(45);
    ((RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams()).addRule(10);
    a(localRelativeLayout, b());
    a(localRelativeLayout, c());
    a(localRelativeLayout, d());
    a(localRelativeLayout, a(this.v));
    a(localRelativeLayout, a());
    a(localRelativeLayout, e());
    return localRelativeLayout;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */