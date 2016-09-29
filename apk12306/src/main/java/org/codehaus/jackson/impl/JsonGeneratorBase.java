package org.codehaus.jackson.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonGenerator.Feature;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.VersionUtil;

public abstract class JsonGeneratorBase
  extends JsonGenerator
{
  protected boolean _cfgNumbersAsStrings;
  protected boolean _closed;
  protected int _features;
  protected ObjectCodec _objectCodec;
  protected JsonWriteContext _writeContext;
  
  protected JsonGeneratorBase(int paramInt, ObjectCodec paramObjectCodec)
  {
    this._features = paramInt;
    this._writeContext = JsonWriteContext.createRootContext();
    this._objectCodec = paramObjectCodec;
    this._cfgNumbersAsStrings = isEnabled(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
  }
  
  protected void _cantHappen()
  {
    throw new RuntimeException("Internal error: should never end up through this code path");
  }
  
  protected abstract void _releaseBuffers();
  
  protected void _reportError(String paramString)
    throws JsonGenerationException
  {
    throw new JsonGenerationException(paramString);
  }
  
  protected void _reportUnsupportedOperation()
  {
    throw new UnsupportedOperationException("Operation not supported by generator of type " + getClass().getName());
  }
  
  protected final void _throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  protected abstract void _verifyValueWrite(String paramString)
    throws IOException, JsonGenerationException;
  
  @Deprecated
  protected void _writeEndArray()
    throws IOException, JsonGenerationException
  {}
  
  @Deprecated
  protected void _writeEndObject()
    throws IOException, JsonGenerationException
  {}
  
  protected void _writeSimpleObject(Object paramObject)
    throws IOException, JsonGenerationException
  {
    if (paramObject == null) {
      writeNull();
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof String))
      {
        writeString((String)paramObject);
      }
      else if ((paramObject instanceof Number))
      {
        Number localNumber = (Number)paramObject;
        if ((localNumber instanceof Integer))
        {
          writeNumber(localNumber.intValue());
        }
        else if ((localNumber instanceof Long))
        {
          writeNumber(localNumber.longValue());
        }
        else if ((localNumber instanceof Double))
        {
          writeNumber(localNumber.doubleValue());
        }
        else if ((localNumber instanceof Float))
        {
          writeNumber(localNumber.floatValue());
        }
        else if ((localNumber instanceof Short))
        {
          writeNumber(localNumber.shortValue());
        }
        else if ((localNumber instanceof Byte))
        {
          writeNumber(localNumber.byteValue());
        }
        else if ((localNumber instanceof BigInteger))
        {
          writeNumber((BigInteger)localNumber);
        }
        else if ((localNumber instanceof BigDecimal))
        {
          writeNumber((BigDecimal)localNumber);
        }
        else if ((localNumber instanceof AtomicInteger))
        {
          writeNumber(((AtomicInteger)localNumber).get());
        }
        else
        {
          if (!(localNumber instanceof AtomicLong)) {
            break;
          }
          writeNumber(((AtomicLong)localNumber).get());
        }
      }
      else if ((paramObject instanceof byte[]))
      {
        writeBinary((byte[])paramObject);
      }
      else if ((paramObject instanceof Boolean))
      {
        writeBoolean(((Boolean)paramObject).booleanValue());
      }
      else
      {
        if (!(paramObject instanceof AtomicBoolean)) {
          break;
        }
        writeBoolean(((AtomicBoolean)paramObject).get());
      }
    }
    throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + paramObject.getClass().getName() + ")");
  }
  
  @Deprecated
  protected void _writeStartArray()
    throws IOException, JsonGenerationException
  {}
  
  @Deprecated
  protected void _writeStartObject()
    throws IOException, JsonGenerationException
  {}
  
  public void close()
    throws IOException
  {
    this._closed = true;
  }
  
  public final void copyCurrentEvent(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == null) {
      _reportError("No current event to copy");
    }
    switch (localJsonToken)
    {
    default: 
      _cantHappen();
    }
    for (;;)
    {
      return;
      writeStartObject();
      continue;
      writeEndObject();
      continue;
      writeStartArray();
      continue;
      writeEndArray();
      continue;
      writeFieldName(paramJsonParser.getCurrentName());
      continue;
      if (paramJsonParser.hasTextCharacters())
      {
        writeString(paramJsonParser.getTextCharacters(), paramJsonParser.getTextOffset(), paramJsonParser.getTextLength());
      }
      else
      {
        writeString(paramJsonParser.getText());
        continue;
        switch (1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
        {
        default: 
          writeNumber(paramJsonParser.getLongValue());
          break;
        case 1: 
          writeNumber(paramJsonParser.getIntValue());
          break;
        case 2: 
          writeNumber(paramJsonParser.getBigIntegerValue());
          continue;
          switch (1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
          {
          default: 
            writeNumber(paramJsonParser.getDoubleValue());
            break;
          case 3: 
            writeNumber(paramJsonParser.getDecimalValue());
            break;
          case 4: 
            writeNumber(paramJsonParser.getFloatValue());
            continue;
            writeBoolean(true);
            continue;
            writeBoolean(false);
            continue;
            writeNull();
            continue;
            writeObject(paramJsonParser.getEmbeddedObject());
          }
          break;
        }
      }
    }
  }
  
  public final void copyCurrentStructure(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken2 = paramJsonParser.getCurrentToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME)
    {
      writeFieldName(paramJsonParser.getCurrentName());
      localJsonToken1 = paramJsonParser.nextToken();
    }
    switch (localJsonToken1)
    {
    case ???: 
    default: 
      copyCurrentEvent(paramJsonParser);
    }
    for (;;)
    {
      return;
      writeStartArray();
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        copyCurrentStructure(paramJsonParser);
      }
      writeEndArray();
      continue;
      writeStartObject();
      while (paramJsonParser.nextToken() != JsonToken.END_OBJECT) {
        copyCurrentStructure(paramJsonParser);
      }
      writeEndObject();
    }
  }
  
  public JsonGenerator disable(JsonGenerator.Feature paramFeature)
  {
    this._features &= (paramFeature.getMask() ^ 0xFFFFFFFF);
    if (paramFeature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
      this._cfgNumbersAsStrings = false;
    }
    for (;;)
    {
      return this;
      if (paramFeature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
        setHighestNonEscapedChar(0);
      }
    }
  }
  
  public JsonGenerator enable(JsonGenerator.Feature paramFeature)
  {
    this._features |= paramFeature.getMask();
    if (paramFeature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
      this._cfgNumbersAsStrings = true;
    }
    for (;;)
    {
      return this;
      if (paramFeature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
        setHighestNonEscapedChar(127);
      }
    }
  }
  
  public abstract void flush()
    throws IOException;
  
  public final ObjectCodec getCodec()
  {
    return this._objectCodec;
  }
  
  public final JsonWriteContext getOutputContext()
  {
    return this._writeContext;
  }
  
  public boolean isClosed()
  {
    return this._closed;
  }
  
  public final boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    if ((this._features & paramFeature.getMask()) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public JsonGenerator setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
    return this;
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    return setPrettyPrinter(new DefaultPrettyPrinter());
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public void writeEndArray()
    throws IOException, JsonGenerationException
  {
    if (!this._writeContext.inArray()) {
      _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
    }
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
    }
    for (;;)
    {
      this._writeContext = this._writeContext.getParent();
      return;
      _writeEndArray();
    }
  }
  
  public void writeEndObject()
    throws IOException, JsonGenerationException
  {
    if (!this._writeContext.inObject()) {
      _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
    }
    this._writeContext = this._writeContext.getParent();
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
    }
    for (;;)
    {
      return;
      _writeEndObject();
    }
  }
  
  public void writeObject(Object paramObject)
    throws IOException, JsonProcessingException
  {
    if (paramObject == null) {
      writeNull();
    }
    for (;;)
    {
      return;
      if (this._objectCodec != null) {
        this._objectCodec.writeValue(this, paramObject);
      } else {
        _writeSimpleObject(paramObject);
      }
    }
  }
  
  public void writeRawValue(String paramString)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramString);
  }
  
  public void writeRawValue(String paramString, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramString, paramInt1, paramInt2);
  }
  
  public void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void writeStartArray()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("start an array");
    this._writeContext = this._writeContext.createChildArrayContext();
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeStartArray(this);
    }
    for (;;)
    {
      return;
      _writeStartArray();
    }
  }
  
  public void writeStartObject()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("start an object");
    this._writeContext = this._writeContext.createChildObjectContext();
    if (this._cfgPrettyPrinter != null) {
      this._cfgPrettyPrinter.writeStartObject(this);
    }
    for (;;)
    {
      return;
      _writeStartObject();
    }
  }
  
  public void writeTree(JsonNode paramJsonNode)
    throws IOException, JsonProcessingException
  {
    if (paramJsonNode == null) {
      writeNull();
    }
    for (;;)
    {
      return;
      if (this._objectCodec == null) {
        throw new IllegalStateException("No ObjectCodec defined for the generator, can not serialize JsonNode-based trees");
      }
      this._objectCodec.writeTree(this, paramJsonNode);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\JsonGeneratorBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */