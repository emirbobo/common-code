package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

class DisplayManagerCompat$LegacyImpl
  extends DisplayManagerCompat
{
  private final WindowManager mWindowManager;
  
  public DisplayManagerCompat$LegacyImpl(Context paramContext)
  {
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public Display getDisplay(int paramInt)
  {
    Display localDisplay = this.mWindowManager.getDefaultDisplay();
    if (localDisplay.getDisplayId() == paramInt) {}
    for (;;)
    {
      return localDisplay;
      localDisplay = null;
    }
  }
  
  public Display[] getDisplays()
  {
    return new Display[] { this.mWindowManager.getDefaultDisplay() };
  }
  
  public Display[] getDisplays(String paramString)
  {
    if (paramString == null) {}
    for (paramString = getDisplays();; paramString = new Display[0]) {
      return paramString;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\hardware\display\DisplayManagerCompat$LegacyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */