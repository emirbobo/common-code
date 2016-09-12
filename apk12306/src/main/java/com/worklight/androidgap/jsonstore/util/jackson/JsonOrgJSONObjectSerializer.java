package com.worklight.androidgap.jsonstore.util.jackson;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.json.JSONObject;

public class JsonOrgJSONObjectSerializer
  extends SerializerBase<JSONObject>
{
  public static final JsonOrgJSONObjectSerializer instance = new JsonOrgJSONObjectSerializer();
  
  static
  {
    JniLib.a(JsonOrgJSONObjectSerializer.class, 1169);
  }
  
  public JsonOrgJSONObjectSerializer()
  {
    super(JSONObject.class);
  }
  
  public native JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException;
  
  public native void serialize(JSONObject paramJSONObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException;
  
  protected native void serializeContents(JSONObject paramJSONObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException;
  
  public native void serializeWithType(JSONObject paramJSONObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonGenerationException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\util\jackson\JsonOrgJSONObjectSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */