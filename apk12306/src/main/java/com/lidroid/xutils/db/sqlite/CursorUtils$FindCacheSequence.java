package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;

public class CursorUtils$FindCacheSequence
{
  private static final String FINDER_LAZY_LOADER_CLASS_NAME = FinderLazyLoader.class.getName();
  private static final String FOREIGN_LAZY_LOADER_CLASS_NAME;
  private static long seq;
  
  static
  {
    JniLib.a(FindCacheSequence.class, 961);
    seq = 0L;
    FOREIGN_LAZY_LOADER_CLASS_NAME = ForeignLazyLoader.class.getName();
  }
  
  public static native long getSeq();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\CursorUtils$FindCacheSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */