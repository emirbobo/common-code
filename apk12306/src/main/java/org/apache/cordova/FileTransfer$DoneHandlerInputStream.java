package org.apache.cordova;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class FileTransfer$DoneHandlerInputStream
  extends FilterInputStream
{
  private boolean done;
  
  public FileTransfer$DoneHandlerInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read()
    throws IOException
  {
    int i;
    if (this.done)
    {
      i = -1;
      if (i != -1) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      this.done = bool;
      return i;
      i = super.read();
      break;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    int i;
    if (this.done)
    {
      i = -1;
      if (i != -1) {
        break label32;
      }
    }
    label32:
    for (boolean bool = true;; bool = false)
    {
      this.done = bool;
      return i;
      i = super.read(paramArrayOfByte);
      break;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.done)
    {
      paramInt1 = -1;
      if (paramInt1 != -1) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.done = bool;
      return paramInt1;
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileTransfer$DoneHandlerInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */