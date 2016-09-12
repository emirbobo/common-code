package com.google.common.io;

import java.io.IOException;

public abstract interface OutputSupplier<T>
{
  public abstract T getOutput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\OutputSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */