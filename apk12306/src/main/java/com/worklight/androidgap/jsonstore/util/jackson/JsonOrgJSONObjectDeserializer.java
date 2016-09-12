package com.worklight.androidgap.jsonstore.util.jackson;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.json.JSONObject;

public class JsonOrgJSONObjectDeserializer
  extends StdDeserializer<JSONObject>
{
  protected static final JsonOrgJSONObjectDeserializer instance = new JsonOrgJSONObjectDeserializer();
  
  static
  {
    JniLib.a(JsonOrgJSONObjectDeserializer.class, 1168);
  }
  
  protected JsonOrgJSONObjectDeserializer()
  {
    super(JSONObject.class);
  }
  
  public native JSONObject deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\util\jackson\JsonOrgJSONObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */