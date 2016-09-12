package com.worklight.utils;

import android.content.res.AssetManager;
import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

public class MultifileAssetStream
  extends SequenceInputStream
{
  static
  {
    JniLib.a(MultifileAssetStream.class, 1274);
  }
  
  public MultifileAssetStream(String paramString, AssetManager paramAssetManager)
    throws IOException
  {
    super(getAssetFileStreams(paramString, paramAssetManager).elements());
  }
  
  private static native String getAssetFileName(String paramString, int paramInt);
  
  private static native Vector<InputStream> getAssetFileStreams(String paramString, AssetManager paramAssetManager)
    throws IOException;
  
  private static native InputStream getFileInputStream(String paramString, AssetManager paramAssetManager);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\utils\MultifileAssetStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */