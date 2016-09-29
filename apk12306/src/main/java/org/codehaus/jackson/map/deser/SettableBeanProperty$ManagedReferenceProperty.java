package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.Annotations;

public final class SettableBeanProperty$ManagedReferenceProperty
  extends SettableBeanProperty
{
  protected final SettableBeanProperty _backProperty;
  protected final boolean _isContainer;
  protected final SettableBeanProperty _managedProperty;
  protected final String _referenceName;
  
  public SettableBeanProperty$ManagedReferenceProperty(String paramString, SettableBeanProperty paramSettableBeanProperty1, SettableBeanProperty paramSettableBeanProperty2, Annotations paramAnnotations, boolean paramBoolean)
  {
    super(paramSettableBeanProperty1.getName(), paramSettableBeanProperty1.getType(), paramSettableBeanProperty1._valueTypeDeserializer, paramAnnotations);
    this._referenceName = paramString;
    this._managedProperty = paramSettableBeanProperty1;
    this._backProperty = paramSettableBeanProperty2;
    this._isContainer = paramBoolean;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    set(paramObject, this._managedProperty.deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this._managedProperty.getAnnotation(paramClass);
  }
  
  public AnnotatedMember getMember()
  {
    return this._managedProperty.getMember();
  }
  
  public final void set(Object paramObject1, Object paramObject2)
    throws IOException
  {
    this._managedProperty.set(paramObject1, paramObject2);
    if (paramObject2 != null)
    {
      if (this._isContainer)
      {
        Object localObject;
        if ((paramObject2 instanceof Object[])) {
          for (localObject : (Object[])paramObject2) {
            if (localObject != null) {
              this._backProperty.set(localObject, paramObject1);
            }
          }
        }
        if ((paramObject2 instanceof Collection))
        {
          localObject = ((Collection)paramObject2).iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramObject2 = ((Iterator)localObject).next();
            if (paramObject2 != null) {
              this._backProperty.set(paramObject2, paramObject1);
            }
          }
        }
        if ((paramObject2 instanceof Map))
        {
          paramObject2 = ((Map)paramObject2).values().iterator();
          while (((Iterator)paramObject2).hasNext())
          {
            localObject = ((Iterator)paramObject2).next();
            if (localObject != null) {
              this._backProperty.set(localObject, paramObject1);
            }
          }
        }
        throw new IllegalStateException("Unsupported container type (" + paramObject2.getClass().getName() + ") when resolving reference '" + this._referenceName + "'");
      }
      this._backProperty.set(paramObject2, paramObject1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\SettableBeanProperty$ManagedReferenceProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */