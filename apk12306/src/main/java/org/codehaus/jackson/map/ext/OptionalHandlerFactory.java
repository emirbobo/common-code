package org.codehaus.jackson.map.ext;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.util.Provider;
import org.codehaus.jackson.type.JavaType;

public class OptionalHandlerFactory
{
  private static final String CLASS_NAME_DOM_DOCUMENT = "org.w3c.dom.Node";
  private static final String CLASS_NAME_DOM_NODE = "org.w3c.dom.Node";
  private static final String DESERIALIZERS_FOR_JAVAX_XML = "org.codehaus.jackson.map.ext.CoreXMLDeserializers";
  private static final String DESERIALIZERS_FOR_JODA_DATETIME = "org.codehaus.jackson.map.ext.JodaDeserializers";
  private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer";
  private static final String DESERIALIZER_FOR_DOM_NODE = "org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer";
  private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
  private static final String PACKAGE_PREFIX_JODA_DATETIME = "org.joda.time.";
  private static final String SERIALIZERS_FOR_JAVAX_XML = "org.codehaus.jackson.map.ext.CoreXMLSerializers";
  private static final String SERIALIZERS_FOR_JODA_DATETIME = "org.codehaus.jackson.map.ext.JodaSerializers";
  private static final String SERIALIZER_FOR_DOM_NODE = "org.codehaus.jackson.map.ext.DOMSerializer";
  public static final OptionalHandlerFactory instance = new OptionalHandlerFactory();
  
  private boolean doesImplement(Class<?> paramClass, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramClass != null) {
      if (paramClass.getName().equals(paramString)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!hasInterface(paramClass, paramString))
      {
        paramClass = paramClass.getSuperclass();
        break;
        bool1 = false;
      }
    }
  }
  
  private boolean hasInterface(Class<?> paramClass, String paramString)
  {
    boolean bool2 = true;
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    boolean bool1;
    if (i < j) {
      if (paramClass[i].getName().equals(paramString)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      i++;
      break;
      j = paramClass.length;
      for (i = 0;; i++)
      {
        if (i >= j) {
          break label79;
        }
        bool1 = bool2;
        if (hasInterface(paramClass[i], paramString)) {
          break;
        }
      }
      label79:
      bool1 = false;
    }
  }
  
  private boolean hasInterfaceStartingWith(Class<?> paramClass, String paramString)
  {
    boolean bool2 = true;
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    boolean bool1;
    if (i < j) {
      if (paramClass[i].getName().startsWith(paramString)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      i++;
      break;
      j = paramClass.length;
      for (i = 0;; i++)
      {
        if (i >= j) {
          break label79;
        }
        bool1 = bool2;
        if (hasInterfaceStartingWith(paramClass[i], paramString)) {
          break;
        }
      }
      label79:
      bool1 = false;
    }
  }
  
  private boolean hasSupertypeStartingWith(Class<?> paramClass, String paramString)
  {
    boolean bool2 = true;
    Class localClass = paramClass.getSuperclass();
    boolean bool1;
    if (localClass != null) {
      if (localClass.getName().startsWith(paramString)) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      localClass = localClass.getSuperclass();
      break;
      for (;;)
      {
        if (paramClass == null) {
          break label65;
        }
        bool1 = bool2;
        if (hasInterfaceStartingWith(paramClass, paramString)) {
          break;
        }
        paramClass = paramClass.getSuperclass();
      }
      label65:
      bool1 = false;
    }
  }
  
  private Object instantiate(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    catch (LinkageError paramString)
    {
      for (;;) {}
    }
  }
  
  public JsonDeserializer<?> findDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
  {
    paramDeserializationConfig = null;
    paramDeserializerProvider = paramJavaType.getRawClass();
    paramJavaType = paramDeserializerProvider.getName();
    if (paramJavaType.startsWith("org.joda.time."))
    {
      paramJavaType = "org.codehaus.jackson.map.ext.JodaDeserializers";
      paramJavaType = instantiate(paramJavaType);
      if (paramJavaType != null) {
        break label111;
      }
      paramJavaType = paramDeserializationConfig;
    }
    for (;;)
    {
      return paramJavaType;
      if ((paramJavaType.startsWith("javax.xml.")) || (hasSupertypeStartingWith(paramDeserializerProvider, "javax.xml.")))
      {
        paramJavaType = "org.codehaus.jackson.map.ext.CoreXMLDeserializers";
        break;
      }
      if (doesImplement(paramDeserializerProvider, "org.w3c.dom.Node"))
      {
        paramJavaType = (JsonDeserializer)instantiate("org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer");
      }
      else
      {
        paramJavaType = paramDeserializationConfig;
        if (doesImplement(paramDeserializerProvider, "org.w3c.dom.Node"))
        {
          paramJavaType = (JsonDeserializer)instantiate("org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer");
          continue;
          label111:
          Collection localCollection = ((Provider)paramJavaType).provide();
          Iterator localIterator = localCollection.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              paramJavaType = (StdDeserializer)localIterator.next();
              if (paramDeserializerProvider == paramJavaType.getValueClass()) {
                break;
              }
            }
          }
          localIterator = localCollection.iterator();
          do
          {
            paramJavaType = paramDeserializationConfig;
            if (!localIterator.hasNext()) {
              break;
            }
            paramJavaType = (StdDeserializer)localIterator.next();
          } while (!paramJavaType.getValueClass().isAssignableFrom(paramDeserializerProvider));
        }
      }
    }
  }
  
  public JsonSerializer<?> findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    paramJavaType = paramJavaType.getRawClass();
    paramSerializationConfig = paramJavaType.getName();
    if (paramSerializationConfig.startsWith("org.joda.time."))
    {
      paramSerializationConfig = "org.codehaus.jackson.map.ext.JodaSerializers";
      paramSerializationConfig = instantiate(paramSerializationConfig);
      if (paramSerializationConfig != null) {
        break label89;
      }
      paramSerializationConfig = null;
    }
    for (;;)
    {
      return paramSerializationConfig;
      if ((paramSerializationConfig.startsWith("javax.xml.")) || (hasSupertypeStartingWith(paramJavaType, "javax.xml.")))
      {
        paramSerializationConfig = "org.codehaus.jackson.map.ext.CoreXMLSerializers";
        break;
      }
      if (doesImplement(paramJavaType, "org.w3c.dom.Node"))
      {
        paramSerializationConfig = (JsonSerializer)instantiate("org.codehaus.jackson.map.ext.DOMSerializer");
      }
      else
      {
        paramSerializationConfig = null;
        continue;
        label89:
        Object localObject = ((Provider)paramSerializationConfig).provide();
        paramSerializationConfig = ((Collection)localObject).iterator();
        for (;;)
        {
          if (paramSerializationConfig.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramSerializationConfig.next();
            if (paramJavaType == localEntry.getKey())
            {
              paramSerializationConfig = (JsonSerializer)localEntry.getValue();
              break;
            }
          }
        }
        localObject = ((Collection)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramSerializationConfig = (Map.Entry)((Iterator)localObject).next();
            if (((Class)paramSerializationConfig.getKey()).isAssignableFrom(paramJavaType))
            {
              paramSerializationConfig = (JsonSerializer)paramSerializationConfig.getValue();
              break;
            }
          }
        }
        paramSerializationConfig = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\OptionalHandlerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */