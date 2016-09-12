package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.FileNotFoundException;

public final class PrintHelper
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext)
  {
    if (systemSupportsPrint()) {}
    for (this.mImpl = new PrintHelperKitkatImpl(paramContext);; this.mImpl = new PrintHelperStubImpl(null)) {
      return;
    }
  }
  
  public static boolean systemSupportsPrint()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getColorMode()
  {
    return this.mImpl.getColorMode();
  }
  
  public int getScaleMode()
  {
    return this.mImpl.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    this.mImpl.printBitmap(paramString, paramBitmap);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    this.mImpl.printBitmap(paramString, paramUri);
  }
  
  public void setColorMode(int paramInt)
  {
    this.mImpl.setColorMode(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mImpl.setScaleMode(paramInt);
  }
  
  private static final class PrintHelperKitkatImpl
    implements PrintHelper.PrintHelperVersionImpl
  {
    private final PrintHelperKitkat printHelper;
    
    PrintHelperKitkatImpl(Context paramContext)
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
  
  private static final class PrintHelperStubImpl
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
  
  static abstract interface PrintHelperVersionImpl
  {
    public abstract int getColorMode();
    
    public abstract int getScaleMode();
    
    public abstract void printBitmap(String paramString, Bitmap paramBitmap);
    
    public abstract void printBitmap(String paramString, Uri paramUri)
      throws FileNotFoundException;
    
    public abstract void setColorMode(int paramInt);
    
    public abstract void setScaleMode(int paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\print\PrintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */