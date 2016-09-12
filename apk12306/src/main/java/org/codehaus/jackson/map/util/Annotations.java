package org.codehaus.jackson.map.util;

import java.lang.annotation.Annotation;

public abstract interface Annotations
{
  public abstract <A extends Annotation> A get(Class<A> paramClass);
  
  public abstract int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\Annotations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */