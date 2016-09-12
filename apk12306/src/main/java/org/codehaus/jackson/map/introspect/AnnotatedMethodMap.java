package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class AnnotatedMethodMap
  implements Iterable<AnnotatedMethod>
{
  LinkedHashMap<MemberKey, AnnotatedMethod> _methods;
  
  public void add(AnnotatedMethod paramAnnotatedMethod)
  {
    if (this._methods == null) {
      this._methods = new LinkedHashMap();
    }
    this._methods.put(new MemberKey(paramAnnotatedMethod.getAnnotated()), paramAnnotatedMethod);
  }
  
  public AnnotatedMethod find(String paramString, Class<?>[] paramArrayOfClass)
  {
    if (this._methods == null) {}
    for (paramString = null;; paramString = (AnnotatedMethod)this._methods.get(new MemberKey(paramString, paramArrayOfClass))) {
      return paramString;
    }
  }
  
  public AnnotatedMethod find(Method paramMethod)
  {
    if (this._methods == null) {}
    for (paramMethod = null;; paramMethod = (AnnotatedMethod)this._methods.get(new MemberKey(paramMethod))) {
      return paramMethod;
    }
  }
  
  public boolean isEmpty()
  {
    if ((this._methods == null) || (this._methods.size() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<AnnotatedMethod> iterator()
  {
    if (this._methods != null) {}
    for (Iterator localIterator = this._methods.values().iterator();; localIterator = Collections.emptyList().iterator()) {
      return localIterator;
    }
  }
  
  public AnnotatedMethod remove(Method paramMethod)
  {
    if (this._methods != null) {}
    for (paramMethod = (AnnotatedMethod)this._methods.remove(new MemberKey(paramMethod));; paramMethod = null) {
      return paramMethod;
    }
  }
  
  public AnnotatedMethod remove(AnnotatedMethod paramAnnotatedMethod)
  {
    return remove(paramAnnotatedMethod.getAnnotated());
  }
  
  public int size()
  {
    if (this._methods == null) {}
    for (int i = 0;; i = this._methods.size()) {
      return i;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\AnnotatedMethodMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */