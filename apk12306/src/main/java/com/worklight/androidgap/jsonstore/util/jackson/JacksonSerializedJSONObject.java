package com.worklight.androidgap.jsonstore.util.jackson;

import com.bangcle.andjni.JniLib;
import org.json.JSONException;
import org.json.JSONObject;

public class JacksonSerializedJSONObject
  extends JSONObject
{
  private JSONObject wrappedObject;
  
  static
  {
    JniLib.a(JacksonSerializedJSONObject.class, 1165);
  }
  
  public JacksonSerializedJSONObject() {}
  
  protected JacksonSerializedJSONObject(JSONObject paramJSONObject)
  {
    this.wrappedObject = paramJSONObject;
  }
  
  public native String toString();
  
  public native String toString(int paramInt)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\util\jackson\JacksonSerializedJSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */