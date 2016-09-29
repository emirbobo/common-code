package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class RegularImmutableMap$TerminalEntry<K, V>
  extends ImmutableEntry<K, V>
  implements RegularImmutableMap.LinkedEntry<K, V>
{
  static
  {
    JniLib.a(TerminalEntry.class, 707);
  }
  
  RegularImmutableMap$TerminalEntry(K paramK, V paramV)
  {
    super(paramK, paramV);
  }
  
  @Nullable
  public native RegularImmutableMap.LinkedEntry<K, V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableMap$TerminalEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */