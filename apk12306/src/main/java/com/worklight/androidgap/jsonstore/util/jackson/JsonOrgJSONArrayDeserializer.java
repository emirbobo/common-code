package com.worklight.androidgap.jsonstore.util.jackson;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.json.JSONArray;

public class JsonOrgJSONArrayDeserializer
  extends StdDeserializer<JSONArray>
{
  protected static final JsonOrgJSONArrayDeserializer instance = new JsonOrgJSONArrayDeserializer();
  
  static
  {
    JniLib.a(JsonOrgJSONArrayDeserializer.class, 1166);
  }
  
  protected JsonOrgJSONArrayDeserializer()
  {
    super(JSONArray.class);
  }
  
  public native JSONArray deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\util\jackson\JsonOrgJSONArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */