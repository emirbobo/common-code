package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;

final class PrintHelper$PrintHelperStubImpl
  implements PrintHelper.PrintHelperVersionImpl
{
  int mColorMode = 2;
  int mScaleMode = 2;
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap) {}
  
  public void printBitmap(String paramString, Uri paramUri) {}
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\print\PrintHelper$PrintHelperStubImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */