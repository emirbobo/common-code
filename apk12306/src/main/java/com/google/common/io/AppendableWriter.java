package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.Writer;

class AppendableWriter
  extends Writer
{
  private boolean closed;
  private final Appendable target;
  
  static
  {
    JniLib.a(AppendableWriter.class, 816);
  }
  
  AppendableWriter(Appendable paramAppendable)
  {
    this.target = paramAppendable;
  }
  
  private native void checkNotClosed()
    throws IOException;
  
  public native Writer append(char paramChar)
    throws IOException;
  
  public native Writer append(CharSequence paramCharSequence)
    throws IOException;
  
  public native Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws IOException;
  
  public native void close()
    throws IOException;
  
  public native void flush()
    throws IOException;
  
  public native void write(int paramInt)
    throws IOException;
  
  public native void write(String paramString)
    throws IOException;
  
  public native void write(String paramString, int paramInt1, int paramInt2)
    throws IOException;
  
  public native void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\AppendableWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */