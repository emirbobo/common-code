package com.worklight.androidgap.jsonstore.util.jackson;

import com.bangcle.andjni.JniLib;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonOrgModule
  extends SimpleModule
{
  private static final ObjectMapper mapper;
  
  static
  {
    JniLib.a(JsonOrgModule.class, 1170);
    mapper = new ObjectMapper();
    mapper.registerModule(new JsonOrgModule());
  }
  
  private JsonOrgModule()
  {
    super("JsonOrgModule", new Version(1, 0, 0, null));
    addDeserializer(JSONArray.class, JsonOrgJSONArrayDeserializer.instance);
    addDeserializer(JSONObject.class, JsonOrgJSONObjectDeserializer.instance);
    addSerializer(JSONArray.class, JsonOrgJSONArraySerializer.instance);
    addSerializer(JSONObject.class, JsonOrgJSONObjectSerializer.instance);
  }
  
  public static native JSONArray deserializeJSONArray(String paramString)
    throws Throwable;
  
  public static native JSONObject deserializeJSONObject(String paramString)
    throws Throwable;
  
  public static native String serialize(JSONArray paramJSONArray);
  
  public static native String serialize(JSONObject paramJSONObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\util\jackson\JsonOrgModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */