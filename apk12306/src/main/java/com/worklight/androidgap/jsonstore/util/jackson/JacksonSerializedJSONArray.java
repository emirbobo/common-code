package com.worklight.androidgap.jsonstore.util.jackson;

import com.bangcle.andjni.JniLib;
import org.json.JSONArray;
import org.json.JSONException;

public class JacksonSerializedJSONArray
  extends JSONArray
{
  private JSONArray wrappedArray;
  
  static
  {
    JniLib.a(JacksonSerializedJSONArray.class, 1164);
  }
  
  public JacksonSerializedJSONArray() {}
  
  protected JacksonSerializedJSONArray(JSONArray paramJSONArray)
  {
    this.wrappedArray = paramJSONArray;
  }
  
  public native String toString();
  
  public native String toString(int paramInt)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\util\jackson\JacksonSerializedJSONArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */