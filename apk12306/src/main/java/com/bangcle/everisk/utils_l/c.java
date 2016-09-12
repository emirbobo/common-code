package com.bangcle.everisk.utils_l;

import java.io.File;
import java.io.IOException;

public final class c
{
  private b W;
  private d X;
  
  public c(File paramFile)
  {
    try
    {
      Object localObject = new com/bangcle/everisk/utils_l/b;
      ((b)localObject).<init>(paramFile, "r");
      this.W = ((b)localObject);
      localObject = new com/bangcle/everisk/utils_l/d;
      ((d)localObject).<init>(this.W);
      this.X = ((d)localObject);
      paramFile.getName();
      return;
    }
    finally
    {
      if (this.X == null) {
        D();
      }
    }
  }
  
  private void D()
  {
    try
    {
      if (this.W != null)
      {
        this.W.close();
        this.W = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  static long a(b paramb)
  {
    long l = paramb.B();
    if (l < 0L) {
      throw new IOException("Maximal file offset is " + Long.toHexString(Long.MAX_VALUE) + " given offset is " + Long.toHexString(l));
    }
    return l;
  }
  
  public final d E()
  {
    return this.X;
  }
  
  protected final void finalize()
  {
    try
    {
      D();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\utils_l\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */