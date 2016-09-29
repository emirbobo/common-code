package cn.dbox.ui.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.dbox.core.bean.d;
import cn.dbox.ui.common.k;
import cn.dbox.ui.e.b;
import java.util.ArrayList;

public class a
  extends HorizontalScrollView
{
  b a;
  private Context b;
  private ArrayList<TextView> c;
  private ArrayList<RelativeLayout> d;
  private int e = 0;
  private a f;
  
  public a(Context paramContext, ArrayList<d> paramArrayList)
  {
    super(paramContext);
    this.b = paramContext;
    a(paramContext, paramArrayList);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int a(View paramView)
  {
    int i = 0;
    int j = 0;
    while (i < this.c.size())
    {
      if (((TextView)this.c.get(i)).equals(paramView)) {
        j = i;
      }
      i++;
    }
    return j;
  }
  
  public LinearLayout a(ArrayList<d> paramArrayList, Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    Object localObject1 = new LinearLayout.LayoutParams(-1, k.a(paramContext, 70));
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, k.a(paramContext, 40));
    localLayoutParams.weight = 1.0F;
    this.d = new ArrayList();
    this.c = new ArrayList();
    int i = 0;
    if (i < paramArrayList.size())
    {
      localObject1 = new RelativeLayout(paramContext);
      Object localObject4 = new LinearLayout.LayoutParams(k.a(paramContext, 90), k.a(paramContext, 50));
      String str = ((d)paramArrayList.get(i)).d();
      Object localObject2 = ((d)paramArrayList.get(i)).f();
      Object localObject3 = new TextView(paramContext);
      ((TextView)localObject3).setLayoutParams(localLayoutParams);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() >= 1) && (str != null) && (str.length() >= 5))
      {
        ((TextView)localObject3).setGravity(19);
        label208:
        ((TextView)localObject3).setTag(((d)paramArrayList.get(i)).c());
        ((TextView)localObject3).setText(str);
        ((TextView)localObject3).setTextColor(-16777216);
        ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            int i = a.this.a(paramAnonymousView);
            if (a.a(a.this) != null) {
              a.a(a.this).a(i, paramAnonymousView, paramAnonymousView.getTag());
            }
            a.this.b(i);
          }
        });
        if (i == 0)
        {
          ((TextView)localObject3).setBackgroundResource(b.a(this.b, "dbox_flat_container_bg"));
          ((TextView)localObject3).setTextColor(-1);
        }
        ((RelativeLayout)localObject1).setPadding(k.a(paramContext, 5), k.a(paramContext, 10), k.a(paramContext, 5), k.a(paramContext, 10));
        this.c.add(localObject3);
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((RelativeLayout)localObject1).addView((View)localObject3);
        localObject4 = new ImageView(paramContext);
        localObject3 = new RelativeLayout.LayoutParams(k.a(paramContext, 15), k.a(paramContext, 15));
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((RelativeLayout.LayoutParams)localObject3).addRule(11);
        if ((localObject2 != null) && (((ArrayList)localObject2).size() >= 1))
        {
          localObject2 = (String)((ArrayList)localObject2).get(0);
          if (!"new".equals(localObject2)) {
            break label459;
          }
          ((ImageView)localObject4).setBackgroundResource(b.a(paramContext, "dbox_flat_tag_new"));
          ((RelativeLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
      }
      for (;;)
      {
        this.d.add(localObject1);
        localLinearLayout.addView((View)localObject1);
        i++;
        break;
        ((TextView)localObject3).setGravity(17);
        break label208;
        label459:
        if ("hot".equals(localObject2))
        {
          ((ImageView)localObject4).setBackgroundResource(b.a(paramContext, "dbox_flat_tag_hot"));
          ((RelativeLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
        else if ("red".equals(localObject2))
        {
          ((ImageView)localObject4).setBackgroundResource(b.a(paramContext, "dbox_flat_tag_red"));
          ((RelativeLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
        }
      }
    }
    return localLinearLayout;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Context paramContext, ArrayList<d> paramArrayList)
  {
    setLayoutParams(new RelativeLayout.LayoutParams(-1, k.a(paramContext, 50)));
    setHorizontalScrollBarEnabled(false);
    paramArrayList = a(paramArrayList, paramContext);
    paramArrayList.setLayoutParams(new LinearLayout.LayoutParams(-2, k.a(paramContext, 50)));
    addView(paramArrayList);
  }
  
  public void a(a parama)
  {
    this.f = parama;
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void b(int paramInt)
  {
    ((TextView)this.c.get(this.e)).setTextColor(-16777216);
    ((TextView)this.c.get(this.e)).setBackgroundColor(16777215);
    ((TextView)this.c.get(paramInt)).setBackgroundResource(b.a(this.b, "dbox_flat_container_bg"));
    ((TextView)this.c.get(paramInt)).setTextColor(-1);
    this.e = paramInt;
  }
  
  public int computeVerticalScrollRange()
  {
    return super.computeVerticalScrollRange();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(paramInt2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, View paramView, Object paramObject);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */