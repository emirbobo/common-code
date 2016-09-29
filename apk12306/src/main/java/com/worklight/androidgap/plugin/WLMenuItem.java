package com.worklight.androidgap.plugin;

import android.graphics.drawable.Drawable;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.WLDroidGap;

public class WLMenuItem
{
  private String callback;
  private boolean hasChanged;
  private int id;
  private String imagePath;
  private boolean isEnabled;
  private String javascriptId;
  private String title;
  
  static
  {
    JniLib.a(WLMenuItem.class, 1202);
  }
  
  public WLMenuItem(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.id = paramInt;
    this.javascriptId = paramString1;
    this.callback = paramString2;
    this.title = paramString3;
    this.isEnabled = paramBoolean;
    setImagePath(paramString4);
    this.hasChanged = true;
  }
  
  private native void setChanged();
  
  public native String getCallback();
  
  public native int getId();
  
  public native Drawable getImage(WLDroidGap paramWLDroidGap);
  
  public native String getImagePath();
  
  public native String getJavaScriptId();
  
  public native String getTitle();
  
  public native boolean hasChanged();
  
  public native boolean isEnabled();
  
  public native void setEnabled(boolean paramBoolean);
  
  public native void setImagePath(String paramString);
  
  public native void setTitle(String paramString);
  
  public native void unsetChanged();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */