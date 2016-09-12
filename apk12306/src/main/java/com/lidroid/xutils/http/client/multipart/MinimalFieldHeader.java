package com.lidroid.xutils.http.client.multipart;

import com.bangcle.andjni.JniLib;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MinimalFieldHeader
  implements Iterable<MinimalField>
{
  private final Map<String, List<MinimalField>> fieldMap = new HashMap();
  private final List<MinimalField> fields = new LinkedList();
  
  static
  {
    JniLib.a(MinimalFieldHeader.class, 1002);
  }
  
  public native void addField(MinimalField paramMinimalField);
  
  public native MinimalField getField(String paramString);
  
  public native List<MinimalField> getFields();
  
  public native List<MinimalField> getFields(String paramString);
  
  public native Iterator<MinimalField> iterator();
  
  public native int removeFields(String paramString);
  
  public native void setField(MinimalField paramMinimalField);
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\MinimalFieldHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */