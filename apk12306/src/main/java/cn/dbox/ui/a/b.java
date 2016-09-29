package cn.dbox.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.dbox.core.b.k;
import cn.dbox.ui.e.c;
import java.util.ArrayList;

public class b
  extends BaseAdapter
{
  private ArrayList<cn.dbox.core.bean.d> a;
  private Context b;
  private cn.dbox.core.b c;
  
  public b(Context paramContext, ArrayList<cn.dbox.core.bean.d> paramArrayList, cn.dbox.core.b paramb)
  {
    this.a = paramArrayList;
    this.b = paramContext;
    this.c = paramb;
  }
  
  public int getCount()
  {
    if (this.a.size() % 3 == 0) {}
    for (int i = this.a.size();; i = this.a.size() + 3 - this.a.size() % 3) {
      return i;
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(cn.dbox.ui.e.d.a(this.b, "dbox_cardview_layout_item"), null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(c.a(this.b, "card_logo")));
      paramViewGroup.b = ((TextView)paramView.findViewById(c.a(this.b, "card_name")));
      paramViewGroup.c = ((ImageView)paramView.findViewById(c.a(this.b, "card_tag")));
      paramView.setTag(paramViewGroup);
      if (paramInt >= this.a.size()) {
        break label392;
      }
      localObject = ((cn.dbox.core.bean.d)this.a.get(paramInt)).f();
      if ((localObject == null) || (((ArrayList)localObject).size() < 1)) {
        break label357;
      }
      localObject = (String)((ArrayList)localObject).get(0);
      paramViewGroup.c.setVisibility(0);
      if (!"new".equals(localObject)) {
        break label315;
      }
      paramViewGroup.c.setBackgroundResource(cn.dbox.ui.e.b.a(this.b, "dbox_card_tag_new"));
      label186:
      localObject = ((cn.dbox.core.bean.d)this.a.get(paramInt)).d();
      if (localObject == null) {
        break label380;
      }
      if (((String)localObject).length() != 3) {
        break label368;
      }
      paramViewGroup.b.setText(" " + (String)localObject + " ");
      label248:
      paramViewGroup.a.setTag(((cn.dbox.core.bean.d)this.a.get(paramInt)).e());
      this.c.a(((cn.dbox.core.bean.d)this.a.get(paramInt)).e(), paramViewGroup.a, new b.k()
      {
        public void a(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
            paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
          }
        }
        
        public void a(String paramAnonymousString, ImageView paramAnonymousImageView) {}
      });
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label315:
      if ("hot".equals(localObject))
      {
        paramViewGroup.c.setBackgroundResource(cn.dbox.ui.e.b.a(this.b, "dbox_card_tag_hot"));
        break label186;
      }
      if (!"red".equals(localObject)) {
        break label186;
      }
      break label186;
      label357:
      paramViewGroup.c.setVisibility(4);
      break label186;
      label368:
      paramViewGroup.b.setText((CharSequence)localObject);
      break label248;
      label380:
      paramViewGroup.b.setText("");
      break label248;
      label392:
      paramViewGroup.a.setVisibility(4);
    }
  }
  
  private class a
  {
    ImageView a;
    TextView b;
    ImageView c;
    
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */