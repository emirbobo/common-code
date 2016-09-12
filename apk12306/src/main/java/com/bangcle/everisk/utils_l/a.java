package com.bangcle.everisk.utils_l;

import com.bangcle.everisk.shell.LibProc;

final class a
{
  public int T = 0;
  byte[] U = null;
  
  public final a b(Exception paramException)
  {
    if ((paramException != null) && (LibProc.z)) {
      LibProc.a(paramException);
    }
    this.T = 2;
    return this;
  }
  
  public final a c(Exception paramException)
  {
    if ((paramException != null) && (LibProc.z)) {
      LibProc.a(paramException);
    }
    this.T = 0;
    return this;
  }
  
  public final boolean z()
  {
    if (this.T == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\utils_l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */