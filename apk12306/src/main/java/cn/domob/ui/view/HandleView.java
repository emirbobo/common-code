package cn.domob.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DDrawable;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.OnImageDownload;

public class HandleView
{
  private static Logger mLogger = new Logger(HandleView.class.getSimpleName());
  private Context mContext;
  private DService mDService;
  private String mHandlerUrl;
  
  public HandleView(Context paramContext, DService paramDService, String paramString)
  {
    this.mContext = paramContext;
    this.mDService = paramDService;
    this.mHandlerUrl = paramString;
  }
  
  public View initHandleView()
  {
    RelativeLayout localRelativeLayout2 = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_handle"), null);
    ImageView localImageView = (ImageView)localRelativeLayout2.findViewById(DId.getIdInt(this.mContext, "handle_background"));
    RelativeLayout localRelativeLayout1 = (RelativeLayout)localRelativeLayout2.findViewById(DId.getIdInt(this.mContext, "handle_num_background"));
    TextView localTextView = (TextView)localRelativeLayout2.findViewById(DId.getIdInt(this.mContext, "handle_num"));
    ((RelativeLayout)localRelativeLayout2.findViewById(DId.getIdInt(this.mContext, "handleRelativeLayout"))).setVisibility(0);
    if ((this.mHandlerUrl != null) && (this.mHandlerUrl != ""))
    {
      mLogger.debugLog("入口图片URL：" + this.mHandlerUrl);
      String str = this.mHandlerUrl;
      localImageView.setTag(str);
      this.mDService.requestImage(str, localImageView, new DService.OnImageDownload()
      {
        public void onDownloadFail(String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          HandleView.mLogger.debugLog("fetch handler fail");
          paramAnonymousImageView.setImageResource(DDrawable.getDrawableInt(HandleView.this.mContext, "u_handle_background"));
        }
        
        public void onDownloadSuc(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
        {
          if (paramAnonymousImageView.getTag().equals(paramAnonymousString))
          {
            HandleView.mLogger.debugLog("fetch handler success");
            if (paramAnonymousBitmap != null) {
              paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
            }
          }
        }
      });
    }
    for (;;)
    {
      localRelativeLayout1.setVisibility(4);
      localTextView.setVisibility(4);
      return localRelativeLayout2;
      localImageView.setImageResource(DDrawable.getDrawableInt(this.mContext, "u_handle_background"));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\HandleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */