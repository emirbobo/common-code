package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import org.codehaus.jackson.map.util.Annotations;

public final class AnnotationMap
  implements Annotations
{
  protected HashMap<Class<? extends Annotation>, Annotation> _annotations;
  
  protected final void _add(Annotation paramAnnotation)
  {
    if (this._annotations == null) {
      this._annotations = new HashMap();
    }
    this._annotations.put(paramAnnotation.annotationType(), paramAnnotation);
  }
  
  public void add(Annotation paramAnnotation)
  {
    _add(paramAnnotation);
  }
  
  public void addIfNotPresent(Annotation paramAnnotation)
  {
    if ((this._annotations == null) || (!this._annotations.containsKey(paramAnnotation.annotationType()))) {
      _add(paramAnnotation);
    }
  }
  
  public <A extends Annotation> A get(Class<A> paramClass)
  {
    if (this._annotations == null) {}
    for (paramClass = null;; paramClass = (Annotation)this._annotations.get(paramClass)) {
      return paramClass;
    }
  }
  
  public int size()
  {
    if (this._annotations == null) {}
    for (int i = 0;; i = this._annotations.size()) {
      return i;
    }
  }
  
  public String toString()
  {
    if (this._annotations == null) {}
    for (String str = "[null]";; str = this._annotations.toString()) {
      return str;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\AnnotationMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */