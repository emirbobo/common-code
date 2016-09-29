package cn.dbox.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import cn.dbox.core.b.k;
import cn.dbox.core.bean.a;
import cn.dbox.ui.common.k;
import cn.dbox.ui.e.c;
import cn.dbox.ui.e.d;
import java.util.ArrayList;

public class e
  extends BaseAdapter
{
  private Context a;
  private ArrayList<a> b;
  private cn.dbox.core.b c;
  private int d;
  private int e;
  
  public e(Context paramContext, ArrayList<a> paramArrayList, cn.dbox.core.b paramb)
  {
    this.a = paramContext;
    this.b = paramArrayList;
    this.c = paramb;
    this.d = k.g(paramContext);
    this.e = k.i(paramContext);
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
      paramView = LayoutInflater.from(this.a).inflate(d.a(this.a, "dbox_feeds_item"), null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(c.a(this.a, "list_thumbnail")));
      paramViewGroup.b = ((ImageView)paramView.findViewById(c.a(this.a, "list_title_tag")));
      paramViewGroup.c = ((TextView)paramView.findViewById(c.a(this.a, "list_title")));
      paramViewGroup.d = ((ImageView)paramView.findViewById(c.a(this.a, "list_large_image")));
      paramViewGroup.d.getLayoutParams().width = this.d;
      paramViewGroup.d.getLayoutParams().height = this.e;
      paramViewGroup.e = ((TextView)paramView.findViewById(c.a(this.a, "list_describe")));
      paramViewGroup.f = ((TextView)paramView.findViewById(c.a(this.a, "list_describe_btn")));
      paramView.setTag(paramViewGroup);
      localObject = ((a)this.b.get(paramInt)).g();
      if ((localObject == null) || (((ArrayList)localObject).size() < 1)) {
        break label543;
      }
      localObject = (String)((ArrayList)localObject).get(0);
      paramViewGroup.b.setVisibility(0);
      if (!"recommend".equals(localObject)) {
        break label485;
      }
      paramViewGroup.b.setBackgroundResource(cn.dbox.ui.e.b.a(this.a, "dbox_feeds_tag_jian"));
    }
    for (;;)
    {
      paramViewGroup.c.setFocusable(false);
      paramViewGroup.e.setFocusable(false);
      paramViewGroup.f.setFocusable(false);
      paramViewGroup.a.setFocusable(false);
      paramViewGroup.d.setFocusable(false);
      paramViewGroup.c.setText(((a)this.b.get(paramInt)).e());
      paramViewGroup.e.setText(((a)this.b.get(paramInt)).j());
      paramViewGroup.f.setText(">>");
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
      paramViewGroup.d.setScaleType(ImageView.ScaleType.FIT_XY);
      paramViewGroup.d.setTag(((a)this.b.get(paramInt)).f());
      this.c.a(((a)this.b.get(paramInt)).f(), paramViewGroup.d, new b.k()
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
      label485:
      if ("hot".equals(localObject))
      {
        paramViewGroup.b.setBackgroundResource(cn.dbox.ui.e.b.a(this.a, "dbox_feeds_tag_re"));
      }
      else if ("choiceness".equals(localObject))
      {
        paramViewGroup.b.setBackgroundResource(cn.dbox.ui.e.b.a(this.a, "dbox_feeds_tag_jing"));
        continue;
        label543:
        paramViewGroup.b.setVisibility(4);
      }
    }
  }
  
  private class a
  {
    ImageView a;
    ImageView b;
    TextView c;
    ImageView d;
    TextView e;
    TextView f;
    
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */