package android.support.v4.app;

import android.graphics.Bitmap;

public class NotificationCompat$BigPictureStyle
  extends NotificationCompat.Style
{
  Bitmap mBigLargeIcon;
  boolean mBigLargeIconSet;
  Bitmap mPicture;
  
  public NotificationCompat$BigPictureStyle() {}
  
  public NotificationCompat$BigPictureStyle(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
  {
    this.mBigLargeIcon = paramBitmap;
    this.mBigLargeIconSet = true;
    return this;
  }
  
  public BigPictureStyle bigPicture(Bitmap paramBitmap)
  {
    this.mPicture = paramBitmap;
    return this;
  }
  
  public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
  {
    this.mBigContentTitle = paramCharSequence;
    return this;
  }
  
  public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
  {
    this.mSummaryText = paramCharSequence;
    this.mSummaryTextSet = true;
    return this;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\NotificationCompat$BigPictureStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */