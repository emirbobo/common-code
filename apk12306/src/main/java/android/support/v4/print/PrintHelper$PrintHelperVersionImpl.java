package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.FileNotFoundException;

abstract interface PrintHelper$PrintHelperVersionImpl
{
  public abstract int getColorMode();
  
  public abstract int getScaleMode();
  
  public abstract void printBitmap(String paramString, Bitmap paramBitmap);
  
  public abstract void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException;
  
  public abstract void setColorMode(int paramInt);
  
  public abstract void setScaleMode(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\print\PrintHelper$PrintHelperVersionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */