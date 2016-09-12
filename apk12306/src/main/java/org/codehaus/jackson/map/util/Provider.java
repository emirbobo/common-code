package org.codehaus.jackson.map.util;

import java.util.Collection;

public abstract interface Provider<T>
{
  public abstract Collection<T> provide();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\Provider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */