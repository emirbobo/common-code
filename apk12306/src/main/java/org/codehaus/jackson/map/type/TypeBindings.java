package org.codehaus.jackson.map.type;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.type.JavaType;

public class TypeBindings
{
  private static final JavaType[] NO_TYPES = new JavaType[0];
  public static final JavaType UNBOUND = new SimpleType(Object.class);
  protected Map<String, JavaType> _bindings;
  protected final Class<?> _contextClass;
  protected final JavaType _contextType;
  private final TypeBindings _parentBindings;
  protected HashSet<String> _placeholders;
  protected final TypeFactory _typeFactory;
  
  public TypeBindings(TypeFactory paramTypeFactory, Class<?> paramClass)
  {
    this(paramTypeFactory, null, paramClass, null);
  }
  
  private TypeBindings(TypeFactory paramTypeFactory, TypeBindings paramTypeBindings, Class<?> paramClass, JavaType paramJavaType)
  {
    this._typeFactory = paramTypeFactory;
    this._parentBindings = paramTypeBindings;
    this._contextClass = paramClass;
    this._contextType = paramJavaType;
  }
  
  public TypeBindings(TypeFactory paramTypeFactory, JavaType paramJavaType)
  {
    this(paramTypeFactory, null, paramJavaType.getRawClass(), paramJavaType);
  }
  
  public void _addPlaceholder(String paramString)
  {
    if (this._placeholders == null) {
      this._placeholders = new HashSet();
    }
    this._placeholders.add(paramString);
  }
  
  protected void _resolve()
  {
    _resolveBindings(this._contextClass);
    if (this._contextType != null)
    {
      int j = this._contextType.containedTypeCount();
      if (j > 0)
      {
        if (this._bindings == null) {
          this._bindings = new LinkedHashMap();
        }
        for (int i = 0; i < j; i++)
        {
          String str = this._contextType.containedTypeName(i);
          JavaType localJavaType = this._contextType.containedType(i);
          this._bindings.put(str, localJavaType);
        }
      }
    }
    if (this._bindings == null) {
      this._bindings = Collections.emptyMap();
    }
  }
  
  protected void _resolveBindings(Type paramType)
  {
    if (paramType == null) {
      return;
    }
    Object localObject2;
    Object localObject1;
    int i;
    int j;
    if ((paramType instanceof ParameterizedType))
    {
      localObject2 = (ParameterizedType)paramType;
      paramType = ((ParameterizedType)localObject2).getActualTypeArguments();
      if ((paramType != null) && (paramType.length > 0))
      {
        localObject3 = (Class)((ParameterizedType)localObject2).getRawType();
        localObject1 = ((Class)localObject3).getTypeParameters();
        if (localObject1.length != paramType.length) {
          throw new IllegalArgumentException("Strange parametrized type (in class " + ((Class)localObject3).getName() + "): number of type arguments != number of type parameters (" + paramType.length + " vs " + localObject1.length + ")");
        }
        i = 0;
        j = paramType.length;
        if (i < j)
        {
          localObject3 = localObject1[i].getName();
          if (this._bindings == null)
          {
            this._bindings = new LinkedHashMap();
            label158:
            _addPlaceholder((String)localObject3);
            this._bindings.put(localObject3, this._typeFactory._constructType(paramType[i], this));
          }
          for (;;)
          {
            i++;
            break;
            if (!this._bindings.containsKey(localObject3)) {
              break label158;
            }
          }
        }
      }
      paramType = (Class)((ParameterizedType)localObject2).getRawType();
    }
    do
    {
      do
      {
        do
        {
          _resolveBindings(paramType.getGenericSuperclass());
          paramType = paramType.getGenericInterfaces();
          j = paramType.length;
          for (i = 0; i < j; i++) {
            _resolveBindings(paramType[i]);
          }
          break;
          if (!(paramType instanceof Class)) {
            break;
          }
          localObject1 = (Class)paramType;
          localObject2 = ((Class)localObject1).getTypeParameters();
          paramType = (Type)localObject1;
        } while (localObject2 == null);
        paramType = (Type)localObject1;
      } while (localObject2.length <= 0);
      j = localObject2.length;
      i = 0;
      paramType = (Type)localObject1;
    } while (i >= j);
    Object localObject3 = localObject2[i];
    paramType = ((TypeVariable)localObject3).getName();
    localObject3 = localObject3.getBounds()[0];
    if (localObject3 != null)
    {
      if (this._bindings != null) {
        break label388;
      }
      this._bindings = new LinkedHashMap();
      label356:
      _addPlaceholder(paramType);
      this._bindings.put(paramType, this._typeFactory._constructType((Type)localObject3, this));
    }
    for (;;)
    {
      i++;
      break;
      label388:
      if (!this._bindings.containsKey(paramType)) {
        break label356;
      }
    }
  }
  
  public void addBinding(String paramString, JavaType paramJavaType)
  {
    if ((this._bindings == null) || (this._bindings.size() == 0)) {
      this._bindings = new LinkedHashMap();
    }
    this._bindings.put(paramString, paramJavaType);
  }
  
  public TypeBindings childInstance()
  {
    return new TypeBindings(this._typeFactory, this, this._contextClass, this._contextType);
  }
  
  public JavaType findType(String paramString)
  {
    if (this._bindings == null) {
      _resolve();
    }
    Object localObject = (JavaType)this._bindings.get(paramString);
    if (localObject != null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      if ((this._placeholders != null) && (this._placeholders.contains(paramString)))
      {
        paramString = UNBOUND;
      }
      else if (this._parentBindings != null)
      {
        paramString = this._parentBindings.findType(paramString);
      }
      else
      {
        if ((this._contextClass == null) || (this._contextClass.getEnclosingClass() == null) || (Modifier.isStatic(this._contextClass.getModifiers()))) {
          break;
        }
        paramString = UNBOUND;
      }
    }
    if (this._contextClass != null) {
      localObject = this._contextClass.getName();
    }
    for (;;)
    {
      throw new IllegalArgumentException("Type variable '" + paramString + "' can not be resolved (with context of class " + (String)localObject + ")");
      if (this._contextType != null) {
        localObject = this._contextType.toString();
      } else {
        localObject = "UNKNOWN";
      }
    }
  }
  
  public int getBindingCount()
  {
    if (this._bindings == null) {
      _resolve();
    }
    return this._bindings.size();
  }
  
  public JavaType resolveType(Class<?> paramClass)
  {
    return this._typeFactory._constructType(paramClass, this);
  }
  
  public JavaType resolveType(Type paramType)
  {
    return this._typeFactory._constructType(paramType, this);
  }
  
  public String toString()
  {
    if (this._bindings == null) {
      _resolve();
    }
    StringBuilder localStringBuilder = new StringBuilder("[TypeBindings for ");
    if (this._contextType != null) {
      localStringBuilder.append(this._contextType.toString());
    }
    for (;;)
    {
      localStringBuilder.append(": ").append(this._bindings).append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(this._contextClass.getName());
    }
  }
  
  public JavaType[] typesAsArray()
  {
    if (this._bindings == null) {
      _resolve();
    }
    if (this._bindings.size() == 0) {}
    for (JavaType[] arrayOfJavaType = NO_TYPES;; arrayOfJavaType = (JavaType[])this._bindings.values().toArray(new JavaType[this._bindings.size()])) {
      return arrayOfJavaType;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\TypeBindings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */