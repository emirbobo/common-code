package cn.domob.ui.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DDrawable;
import cn.domob.wall.core.DService.OnImageDownload;

class HandleView$1
  implements DService.OnImageDownload
{
  HandleView$1(HandleView paramHandleView) {}
  
  public void onDownloadFail(String paramString, ImageView paramImageView)
  {
    HandleView.access$000().debugLog("fetch handler fail");
    paramImageView.setImageResource(DDrawable.getDrawableInt(HandleView.access$100(this.a), "u_handle_background"));
  }
  
  public void onDownloadSuc(Bitmap paramBitmap, String paramString, ImageView paramImageView)
  {
    if (paramImageView.getTag().equals(paramString))
    {
      HandleView.access$000().debugLog("fetch handler success");
      if (paramBitmap != null) {
        paramImageView.setImageBitmap(paramBitmap);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\HandleView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */