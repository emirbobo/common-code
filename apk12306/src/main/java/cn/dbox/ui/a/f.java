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
import cn.dbox.core.bean.a;
import cn.dbox.ui.e.c;
import cn.dbox.ui.e.d;
import java.util.ArrayList;

public class f
  extends BaseAdapter
{
  private Context a;
  private ArrayList<a> b;
  private cn.dbox.core.b c;
  
  public f(Context paramContext, ArrayList<a> paramArrayList, cn.dbox.core.b paramb)
  {
    this.a = paramContext;
    this.b = paramArrayList;
    this.c = paramb;
  }
  
  public int getCount()
  {
    return this.b.size();
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
      paramView = LayoutInflater.from(this.a).inflate(d.a(this.a, "dbox_list_container_item"), null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(c.a(this.a, "lsit_logo")));
      paramViewGroup.b = ((ImageView)paramView.findViewById(c.a(this.a, "lsit_logo_tag")));
      paramViewGroup.c = ((TextView)paramView.findViewById(c.a(this.a, "list_name")));
      paramViewGroup.d = ((TextView)paramView.findViewById(c.a(this.a, "list_describe")));
      paramView.setTag(paramViewGroup);
      localObject = ((a)this.b.get(paramInt)).g();
      if ((localObject == null) || (((ArrayList)localObject).size() < 1)) {
        break label362;
      }
      localObject = (String)((ArrayList)localObject).get(0);
      paramViewGroup.b.setVisibility(0);
      if (!"recommend".equals(localObject)) {
        break label304;
      }
      paramViewGroup.b.setBackgroundResource(cn.dbox.ui.e.b.a(this.a, "dbox_card_tag_tj"));
    }
    for (;;)
    {
      paramViewGroup.c.setText(((a)this.b.get(paramInt)).e());
      paramViewGroup.d.setText(((a)this.b.get(paramInt)).j());
      paramViewGroup.a.setTag(((a)this.b.get(paramInt)).k());
      this.c.a(((a)this.b.get(paramInt)).k(), paramViewGroup.a, new b.k()
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
      break;
      label304:
      if ("hot".equals(localObject))
      {
        paramViewGroup.b.setBackgroundResource(cn.dbox.ui.e.b.a(this.a, "dbox_card_tag_rm"));
      }
      else if ("choiceness".equals(localObject))
      {
        paramViewGroup.b.setBackgroundResource(cn.dbox.ui.e.b.a(this.a, "dbox_card_tag_jx"));
        continue;
        label362:
        paramViewGroup.b.setVisibility(4);
      }
    }
  }
  
  private class a
  {
    ImageView a;
    ImageView b;
    TextView c;
    TextView d;
    
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */