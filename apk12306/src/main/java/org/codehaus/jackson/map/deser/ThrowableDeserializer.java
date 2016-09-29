package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.HashSet;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import org.codehaus.jackson.type.JavaType;

public class ThrowableDeserializer
  extends BeanDeserializer
{
  protected static final String PROP_NAME_MESSAGE = "message";
  
  public ThrowableDeserializer(BeanDeserializer paramBeanDeserializer)
  {
    super(paramBeanDeserializer);
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (this._propertyBasedCreator != null) {
      paramJsonParser = _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
    }
    Object localObject1;
    int i;
    do
    {
      Object localObject2;
      do
      {
        for (;;)
        {
          return paramJsonParser;
          if (this._delegatingCreator == null) {
            break;
          }
          paramJsonParser = this._delegatingCreator.deserialize(paramJsonParser, paramDeserializationContext);
        }
        if (this._beanType.isAbstract()) {
          throw JsonMappingException.from(paramJsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
        }
        if (this._stringCreator == null) {
          throw new JsonMappingException("Can not deserialize Throwable of type " + this._beanType + " without having either single-String-arg constructor; or explicit @JsonCreator");
        }
        localObject2 = null;
        localObject1 = null;
        i = 0;
        if (paramJsonParser.getCurrentToken() != JsonToken.END_OBJECT)
        {
          Object localObject3 = paramJsonParser.getCurrentName();
          Object localObject4 = this._beanProperties.find((String)localObject3);
          paramJsonParser.nextToken();
          if (localObject4 != null) {
            if (localObject2 != null)
            {
              ((SettableBeanProperty)localObject4).deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
              j = i;
              localObject3 = localObject1;
            }
          }
          for (;;)
          {
            paramJsonParser.nextToken();
            localObject1 = localObject3;
            i = j;
            break;
            localObject3 = localObject1;
            if (localObject1 == null)
            {
              j = this._beanProperties.size();
              localObject3 = new Object[j + j];
            }
            int k = i + 1;
            localObject3[i] = localObject4;
            j = k + 1;
            localObject3[k] = ((SettableBeanProperty)localObject4).deserialize(paramJsonParser, paramDeserializationContext);
            continue;
            if ("message".equals(localObject3))
            {
              localObject4 = this._stringCreator.construct(paramJsonParser.getText());
              localObject3 = localObject1;
              j = i;
              localObject2 = localObject4;
              if (localObject1 != null)
              {
                for (j = 0; j < i; j += 2) {
                  ((SettableBeanProperty)localObject1[j]).set(localObject4, localObject1[(j + 1)]);
                }
                localObject3 = null;
                j = i;
                localObject2 = localObject4;
              }
            }
            else if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject3)))
            {
              paramJsonParser.skipChildren();
              localObject3 = localObject1;
              j = i;
            }
            else if (this._anySetter != null)
            {
              this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject3);
              localObject3 = localObject1;
              j = i;
            }
            else
            {
              handleUnknownProperty(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject3);
              localObject3 = localObject1;
              j = i;
            }
          }
        }
        paramJsonParser = (JsonParser)localObject2;
      } while (localObject2 != null);
      paramDeserializationContext = this._stringCreator.construct(null);
      paramJsonParser = paramDeserializationContext;
    } while (localObject1 == null);
    for (int j = 0;; j += 2)
    {
      paramJsonParser = paramDeserializationContext;
      if (j >= i) {
        break;
      }
      ((SettableBeanProperty)localObject1[j]).set(paramDeserializationContext, localObject1[(j + 1)]);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ThrowableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */