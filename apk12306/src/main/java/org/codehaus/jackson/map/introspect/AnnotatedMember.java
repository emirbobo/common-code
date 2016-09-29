package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Member;
import org.codehaus.jackson.map.util.ClassUtil;

public abstract class AnnotatedMember
  extends Annotated
{
  public final void fixAccess()
  {
    ClassUtil.checkAndFixAccess(getMember());
  }
  
  public abstract Class<?> getDeclaringClass();
  
  public abstract Member getMember();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\AnnotatedMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */