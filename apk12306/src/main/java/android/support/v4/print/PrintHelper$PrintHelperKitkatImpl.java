package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.FileNotFoundException;

final class PrintHelper$PrintHelperKitkatImpl
  implements PrintHelper.PrintHelperVersionImpl
{
  private final PrintHelperKitkat printHelper;
  
  PrintHelper$PrintHelperKitkatImpl(Context paramContext)
  {
    this.printHelper = new PrintHelperKitkat(paramContext);
  }
  
  public int getColorMode()
  {
    return this.printHelper.getColorMode();
  }
  
  public int getScaleMode()
  {
    return this.printHelper.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    this.printHelper.printBitmap(paramString, paramBitmap);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    this.printHelper.printBitmap(paramString, paramUri);
  }
  
  public void setColorMode(int paramInt)
  {
    this.printHelper.setColorMode(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.printHelper.setScaleMode(paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\print\PrintHelper$PrintHelperKitkatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */