package cn.domob.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.OnImageDownload;
import java.util.List;

public class DetailsGalleryAdapter
  extends BaseAdapter
{
  private static Logger mLogger = new Logger(DetailsGalleryAdapter.class.getSimpleName());
  private Context mContext;
  private DService mDService;
  private List<String> mImageUrls;
  
  public DetailsGalleryAdapter(List<String> paramList, Context paramContext, DService paramDService)
  {
    this.mImageUrls = paramList;
    this.mContext = paramContext;
    this.mDService = paramDService;
  }
  
  public int getCount()
  {
    return this.mImageUrls.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mImageUrls.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_details_gallery"), null);
      paramView.setLayoutParams(new Gallery.LayoutParams(-2, -2));
      paramViewGroup = new a(null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(DId.getIdInt(this.mContext, "gallery_image")));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      mLogger.debugLog("图片url:" + (String)this.mImageUrls.get(paramInt % this.mImageUrls.size()));
      paramViewGroup.a.setTag(this.mImageUrls.get(paramInt % this.mImageUrls.size()));
      this.mDService.requestImage((String)this.mImageUrls.get(paramInt % this.mImageUrls.size()), paramViewGroup.a, new DService.OnImageDownload()
      {
        public void onDownloadFail(String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          DetailsGalleryAdapter.mLogger.debugLog("Get img fails:" + paramAnonymousString);
        }
        
        public void onDownloadSuc(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
            paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
          }
        }
      });
      paramViewGroup.a.setScaleType(ImageView.ScaleType.FIT_XY);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private class a
  {
    ImageView a;
    
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\adapter\DetailsGalleryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */