package org.codehaus.jackson.map.util;

import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class RootNameLookup
{
  protected LRUMap<ClassKey, SerializedString> _rootNames;
  
  /* Error */
  public SerializedString findRootName(Class<?> paramClass, MapperConfig<?> paramMapperConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 16	org/codehaus/jackson/map/type/ClassKey
    //   5: astore 4
    //   7: aload 4
    //   9: aload_1
    //   10: invokespecial 19	org/codehaus/jackson/map/type/ClassKey:<init>	(Ljava/lang/Class;)V
    //   13: aload_0
    //   14: getfield 21	org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lorg/codehaus/jackson/map/util/LRUMap;
    //   17: ifnonnull +77 -> 94
    //   20: new 23	org/codehaus/jackson/map/util/LRUMap
    //   23: astore_3
    //   24: aload_3
    //   25: bipush 20
    //   27: sipush 200
    //   30: invokespecial 26	org/codehaus/jackson/map/util/LRUMap:<init>	(II)V
    //   33: aload_0
    //   34: aload_3
    //   35: putfield 21	org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lorg/codehaus/jackson/map/util/LRUMap;
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 32	org/codehaus/jackson/map/MapperConfig:introspectClassAnnotations	(Ljava/lang/Class;)Lorg/codehaus/jackson/map/BeanDescription;
    //   43: checkcast 34	org/codehaus/jackson/map/introspect/BasicBeanDescription
    //   46: astore_3
    //   47: aload_2
    //   48: invokevirtual 38	org/codehaus/jackson/map/MapperConfig:getAnnotationIntrospector	()Lorg/codehaus/jackson/map/AnnotationIntrospector;
    //   51: aload_3
    //   52: invokevirtual 42	org/codehaus/jackson/map/introspect/BasicBeanDescription:getClassInfo	()Lorg/codehaus/jackson/map/introspect/AnnotatedClass;
    //   55: invokevirtual 47	org/codehaus/jackson/map/AnnotationIntrospector:findRootName	(Lorg/codehaus/jackson/map/introspect/AnnotatedClass;)Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: ifnonnull +8 -> 70
    //   65: aload_1
    //   66: invokevirtual 53	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   69: astore_2
    //   70: new 55	org/codehaus/jackson/io/SerializedString
    //   73: astore_1
    //   74: aload_1
    //   75: aload_2
    //   76: invokespecial 58	org/codehaus/jackson/io/SerializedString:<init>	(Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 21	org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lorg/codehaus/jackson/map/util/LRUMap;
    //   83: aload 4
    //   85: aload_1
    //   86: invokevirtual 62	org/codehaus/jackson/map/util/LRUMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: areturn
    //   94: aload_0
    //   95: getfield 21	org/codehaus/jackson/map/util/RootNameLookup:_rootNames	Lorg/codehaus/jackson/map/util/LRUMap;
    //   98: aload 4
    //   100: invokevirtual 66	org/codehaus/jackson/map/util/LRUMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast 55	org/codehaus/jackson/io/SerializedString
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull -70 -> 38
    //   111: aload_3
    //   112: astore_1
    //   113: goto -23 -> 90
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	RootNameLookup
    //   0	121	1	paramClass	Class<?>
    //   0	121	2	paramMapperConfig	MapperConfig<?>
    //   23	89	3	localObject	Object
    //   5	94	4	localClassKey	ClassKey
    // Exception table:
    //   from	to	target	type
    //   2	38	116	finally
    //   38	59	116	finally
    //   65	70	116	finally
    //   70	90	116	finally
    //   94	107	116	finally
  }
  
  public SerializedString findRootName(JavaType paramJavaType, MapperConfig<?> paramMapperConfig)
  {
    return findRootName(paramJavaType.getRawClass(), paramMapperConfig);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\RootNameLookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */