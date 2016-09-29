package cn.domob.wall.core;

import android.graphics.Bitmap;
import android.widget.ImageView;

public abstract interface DService$OnImageDownload
{
  public abstract void onDownloadFail(String paramString, ImageView paramImageView);
  
  public abstract void onDownloadSuc(Bitmap paramBitmap, String paramString, ImageView paramImageView);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\DService$OnImageDownload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */