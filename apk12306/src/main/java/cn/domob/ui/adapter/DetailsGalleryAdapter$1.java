package cn.domob.ui.adapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.DService.OnImageDownload;

class DetailsGalleryAdapter$1
  implements DService.OnImageDownload
{
  DetailsGalleryAdapter$1(DetailsGalleryAdapter paramDetailsGalleryAdapter) {}
  
  public void onDownloadFail(String paramString, ImageView paramImageView)
  {
    DetailsGalleryAdapter.access$100().debugLog("Get img fails:" + paramString);
  }
  
  public void onDownloadSuc(Bitmap paramBitmap, String paramString, ImageView paramImageView)
  {
    if ((paramImageView.getTag().equals(paramString)) && (paramBitmap != null)) {
      paramImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\adapter\DetailsGalleryAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */