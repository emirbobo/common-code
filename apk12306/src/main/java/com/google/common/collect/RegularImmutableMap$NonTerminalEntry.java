package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.concurrent.Immutable;

@Immutable
final class RegularImmutableMap$NonTerminalEntry<K, V>
  extends ImmutableEntry<K, V>
  implements RegularImmutableMap.LinkedEntry<K, V>
{
  final RegularImmutableMap.LinkedEntry<K, V> next;
  
  static
  {
    JniLib.a(NonTerminalEntry.class, 706);
  }
  
  RegularImmutableMap$NonTerminalEntry(K paramK, V paramV, RegularImmutableMap.LinkedEntry<K, V> paramLinkedEntry)
  {
    super(paramK, paramV);
    this.next = paramLinkedEntry;
  }
  
  public native RegularImmutableMap.LinkedEntry<K, V> next();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\RegularImmutableMap$NonTerminalEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */