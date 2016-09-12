package com.worklight.androidgap.plugin;

import android.webkit.JavascriptInterface;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.WLDroidGap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class WLOptionsMenu
{
  private WLDroidGap activity = null;
  private boolean hasChanged = false;
  private boolean isEnabled = false;
  private boolean isInit = false;
  private boolean isVisible = false;
  private int itemIndexer = 0;
  private Map<Integer, WLMenuItem> items = null;
  private String skinName = null;
  
  static
  {
    JniLib.a(WLOptionsMenu.class, 1205);
  }
  
  public WLOptionsMenu(WLDroidGap paramWLDroidGap)
  {
    this.activity = paramWLDroidGap;
  }
  
  @JavascriptInterface
  private native WLMenuItem getItemByJavaScriptId(String paramString);
  
  @JavascriptInterface
  private native void setChanged();
  
  @JavascriptInterface
  public native WLMenuItem addItem(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean);
  
  @JavascriptInterface
  public native WLMenuItem getItem(String paramString);
  
  public native WLMenuItem getItemById(int paramInt);
  
  public native List<WLMenuItem> getItems();
  
  @JavascriptInterface
  public native String getSkinName();
  
  @JavascriptInterface
  public native boolean hasChanged();
  
  @JavascriptInterface
  public native void init();
  
  @JavascriptInterface
  public native boolean isEnabled();
  
  @JavascriptInterface
  public native boolean isInit();
  
  @JavascriptInterface
  public native boolean isVisible();
  
  @JavascriptInterface
  public native void removeItem(String paramString);
  
  @JavascriptInterface
  public native void removeItems();
  
  @JavascriptInterface
  public native void setEnabled(boolean paramBoolean);
  
  @JavascriptInterface
  public native void setVisible(boolean paramBoolean);
  
  @JavascriptInterface
  public native void unsetChanged();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLOptionsMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */