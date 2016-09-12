package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;
import org.json.JSONObject;

public class Screenview
  extends ClientMessageHeader
  implements JsonBase, Serializable
{
  private static final long serialVersionUID = -7422132544374507473L;
  private String logicalPageName;
  private String referringLogicalPageName;
  private ScreenviewType screenviewType;
  
  static
  {
    JniLib.a(Screenview.class, 1108);
  }
  
  public Screenview()
  {
    init();
  }
  
  public Screenview(String paramString1, ScreenviewType paramScreenviewType, String paramString2)
  {
    init();
    this.logicalPageName = paramString1;
    this.screenviewType = paramScreenviewType;
    this.referringLogicalPageName = paramString2;
  }
  
  private native void init();
  
  public final native Boolean clean();
  
  public final native JSONObject getJSON();
  
  public final native String getLogicalPageName();
  
  public final native String getReferringLogicalPageName();
  
  public final native ScreenviewType getScreenviewType();
  
  public final native void setLogicalPageName(String paramString);
  
  public final native void setReferringLogicalPageName(String paramString);
  
  public final native void setScreenviewType(ScreenviewType paramScreenviewType);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\Screenview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */