package cn.dbox.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.dbox.core.b.k;
import cn.dbox.ui.e.c;
import cn.dbox.ui.e.d;
import java.util.ArrayList;

public class a
  extends g
{
  private ArrayList<cn.dbox.core.bean.a> a;
  private Context b;
  private cn.dbox.core.b c;
  
  public a(Context paramContext, ArrayList<cn.dbox.core.bean.a> paramArrayList, cn.dbox.core.b paramb)
  {
    super(paramContext);
    this.a = paramArrayList;
    this.b = paramContext;
    this.c = paramb;
  }
  
  public int a()
  {
    if (this.a != null) {}
    for (int i = this.a.size();; i = 0) {
      return i;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(d.a(this.b, "dbox_cardview_item"), null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(c.a(this.b, "card_logo")));
      paramViewGroup.b = ((TextView)paramView.findViewById(c.a(this.b, "card_name")));
      paramViewGroup.c = ((ImageView)paramView.findViewById(c.a(this.b, "card_tag")));
      paramView.setTag(paramViewGroup);
    }
    label432:
    for (;;)
    {
      Object localObject = ((cn.dbox.core.bean.a)this.a.get(paramInt)).g();
      if ((localObject != null) && (((ArrayList)localObject).size() >= 1))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        paramViewGroup.c.setVisibility(0);
        if ("recommend".equals(localObject)) {
          paramViewGroup.c.setBackgroundResource(cn.dbox.ui.e.b.a(this.b, "dbox_card_tag_tj"));
        }
      }
      for (;;)
      {
        paramViewGroup.b.setText(((cn.dbox.core.bean.a)this.a.get(paramInt)).e());
        paramViewGroup.a.setTag(((cn.dbox.core.bean.a)this.a.get(paramInt)).k());
        this.c.a(((cn.dbox.core.bean.a)this.a.get(paramInt)).k(), paramViewGroup.a, new b.k()
        {
          public void a(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
          {
            if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
              paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
            }
          }
          
          public void a(String paramAnonymousString, ImageView paramAnonymousImageView) {}
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        if (paramViewGroup != null) {
          break label432;
        }
        paramView = LayoutInflater.from(this.b).inflate(d.a(this.b, "dbox_cardview_item"), null);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((ImageView)paramView.findViewById(c.a(this.b, "card_logo")));
        paramViewGroup.b = ((TextView)paramView.findViewById(c.a(this.b, "card_name")));
        paramViewGroup.c = ((ImageView)paramView.findViewById(c.a(this.b, "card_tag")));
        paramView.setTag(paramViewGroup);
        break;
        if ("hot".equals(localObject))
        {
          paramViewGroup.c.setBackgroundResource(cn.dbox.ui.e.b.a(this.b, "dbox_card_tag_rm"));
        }
        else if ("choiceness".equals(localObject))
        {
          paramViewGroup.c.setBackgroundResource(cn.dbox.ui.e.b.a(this.b, "dbox_card_tag_jx"));
          continue;
          paramViewGroup.c.setVisibility(4);
        }
      }
    }
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  private class a
  {
    ImageView a;
    TextView b;
    ImageView c;
    
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */