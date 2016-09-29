package com.tl.uic.model;

import com.bangcle.andjni.JniLib;
import java.io.Serializable;

public class TLFCacheFile
  implements ModelBase, Serializable
{
  private static final long serialVersionUID = 6949011040915615537L;
  private Boolean _isImage = Boolean.valueOf(false);
  private Object data;
  private String directory;
  private String fileName;
  private String sessionId;
  
  static
  {
    JniLib.a(TLFCacheFile.class, 1110);
  }
  
  public TLFCacheFile() {}
  
  public TLFCacheFile(Object paramObject, String paramString)
  {
    this.data = paramObject;
    this.sessionId = paramString;
  }
  
  public final native Boolean clean();
  
  public final native Object getData();
  
  public final native String getDirectory();
  
  public final native String getFileName();
  
  public final native String getSessionId();
  
  public final native Boolean isImage();
  
  public final native void isImage(Boolean paramBoolean);
  
  public final native void setData(Object paramObject);
  
  public final native void setDirectory(String paramString);
  
  public final native void setFileName(String paramString);
  
  public final native void setSessionId(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\model\TLFCacheFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */