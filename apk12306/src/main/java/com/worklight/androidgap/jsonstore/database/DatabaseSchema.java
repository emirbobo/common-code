package com.worklight.androidgap.jsonstore.database;

import com.bangcle.andjni.JniLib;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatabaseSchema
{
  private static final String[] specialChars = { "@", "$", "^", "&", "|", ">", "<", "?", "-" };
  private TreeMap<String, DatabaseSchemaType> internalNodes;
  private String name;
  private TreeMap<String, DatabaseSchemaType> nodes;
  private TreeMap<String, DatabaseSchemaType> safeNodes;
  
  static
  {
    JniLib.a(DatabaseSchema.class, 1154);
  }
  
  public DatabaseSchema(String paramString)
  {
    this.name = paramString;
    this.nodes = new TreeMap();
    this.internalNodes = new TreeMap();
    this.safeNodes = new TreeMap();
    try
    {
      this.internalNodes.put("_deleted", DatabaseSchemaType.BOOLEAN);
      this.internalNodes.put("_dirty", DatabaseSchemaType.NUMBER);
      this.internalNodes.put("_id", DatabaseSchemaType.INTEGER);
      this.internalNodes.put("json", DatabaseSchemaType.STRING);
      this.internalNodes.put("_operation", DatabaseSchemaType.STRING);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
  }
  
  public DatabaseSchema(String paramString, JSONObject paramJSONObject)
    throws Throwable
  {
    this(paramString);
    addNodesFromSchema(paramJSONObject);
  }
  
  private native void addNode(String paramString, DatabaseSchemaType paramDatabaseSchemaType)
    throws Throwable;
  
  private native void addNodesFromSchema(JSONObject paramJSONObject)
    throws Throwable;
  
  private native String encodeJSONArrayAsString(JSONArray paramJSONArray, String paramString)
    throws JSONException;
  
  public static native String getDatabaseSafeNodeName(String paramString);
  
  private native Object getValueFromObjectCaseInsensitive(JSONObject paramJSONObject, String paramString);
  
  private native Object locateChildInObject(JSONObject paramJSONObject, String paramString);
  
  private native void mergeIntoObject(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws Throwable;
  
  private native void mergeValues(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws Throwable;
  
  private native JSONObject normalizeObject(JSONObject paramJSONObject)
    throws Throwable;
  
  private native Object normalizeOrCopyObject(Object paramObject)
    throws Throwable;
  
  public native boolean equals(Object paramObject);
  
  public native boolean equals(TreeMap<String, String> paramTreeMap);
  
  public native String getName();
  
  public native Iterator<String> getNodeNames();
  
  public native DatabaseSchemaType getNodeType(String paramString);
  
  public native Map<String, Object> mapObject(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\database\DatabaseSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */