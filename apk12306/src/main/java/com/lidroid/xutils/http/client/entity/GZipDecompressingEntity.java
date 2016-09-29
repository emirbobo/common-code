package com.lidroid.xutils.http.client.entity;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class GZipDecompressingEntity
  extends DecompressingEntity
{
  static
  {
    JniLib.a(GZipDecompressingEntity.class, 997);
  }
  
  public GZipDecompressingEntity(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }
  
  native InputStream decorate(InputStream paramInputStream)
    throws IOException;
  
  public native Header getContentEncoding();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\entity\GZipDecompressingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */