package cn.domob.ui.item;

import android.graphics.Bitmap;
import android.widget.ImageView;
import cn.domob.ui.main.Logger;
import cn.domob.wall.core.DService.OnImageDownload;

class SearchListItem$1
  implements DService.OnImageDownload
{
  SearchListItem$1(SearchListItem paramSearchListItem) {}
  
  public void onDownloadFail(String paramString, ImageView paramImageView)
  {
    SearchListItem.access$000().errorLog("Get img fails:" + paramString);
  }
  
  public void onDownloadSuc(Bitmap paramBitmap, String paramString, ImageView paramImageView)
  {
    if ((paramImageView.getTag().equals(paramString)) && (paramBitmap != null)) {
      paramImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\item\SearchListItem$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */