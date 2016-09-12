package org.apache.cordova;

import android.util.Log;
import android.webkit.WebView;
import java.util.HashMap;
import org.apache.cordova.api.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ContactAccessor
{
  protected final String LOG_TAG = "ContactsAccessor";
  protected CordovaInterface mApp;
  protected WebView mView;
  
  protected HashMap<String, Boolean> buildPopulationSet(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      if ((paramJSONArray.length() == 1) && (paramJSONArray.getString(0).equals("*")))
      {
        localHashMap.put("displayName", Boolean.valueOf(true));
        localHashMap.put("name", Boolean.valueOf(true));
        localHashMap.put("nickname", Boolean.valueOf(true));
        localHashMap.put("phoneNumbers", Boolean.valueOf(true));
        localHashMap.put("emails", Boolean.valueOf(true));
        localHashMap.put("addresses", Boolean.valueOf(true));
        localHashMap.put("ims", Boolean.valueOf(true));
        localHashMap.put("organizations", Boolean.valueOf(true));
        localHashMap.put("birthday", Boolean.valueOf(true));
        localHashMap.put("note", Boolean.valueOf(true));
        localHashMap.put("urls", Boolean.valueOf(true));
        localHashMap.put("photos", Boolean.valueOf(true));
        localHashMap.put("categories", Boolean.valueOf(true));
        return localHashMap;
      }
      int i = 0;
      label176:
      if (i < paramJSONArray.length())
      {
        str = paramJSONArray.getString(i);
        if (!str.startsWith("displayName")) {
          break label218;
        }
        localHashMap.put("displayName", Boolean.valueOf(true));
      }
      for (;;)
      {
        i++;
        break label176;
        break;
        label218:
        if (!str.startsWith("name")) {
          break label268;
        }
        localHashMap.put("displayName", Boolean.valueOf(true));
        localHashMap.put("name", Boolean.valueOf(true));
      }
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        String str;
        Log.e("ContactsAccessor", paramJSONArray.getMessage(), paramJSONArray);
        continue;
        label268:
        if (str.startsWith("nickname")) {
          localHashMap.put("nickname", Boolean.valueOf(true));
        } else if (str.startsWith("phoneNumbers")) {
          localHashMap.put("phoneNumbers", Boolean.valueOf(true));
        } else if (str.startsWith("emails")) {
          localHashMap.put("emails", Boolean.valueOf(true));
        } else if (str.startsWith("addresses")) {
          localHashMap.put("addresses", Boolean.valueOf(true));
        } else if (str.startsWith("ims")) {
          localHashMap.put("ims", Boolean.valueOf(true));
        } else if (str.startsWith("organizations")) {
          localHashMap.put("organizations", Boolean.valueOf(true));
        } else if (str.startsWith("birthday")) {
          localHashMap.put("birthday", Boolean.valueOf(true));
        } else if (str.startsWith("note")) {
          localHashMap.put("note", Boolean.valueOf(true));
        } else if (str.startsWith("urls")) {
          localHashMap.put("urls", Boolean.valueOf(true));
        } else if (str.startsWith("photos")) {
          localHashMap.put("photos", Boolean.valueOf(true));
        } else if (str.startsWith("categories")) {
          localHashMap.put("categories", Boolean.valueOf(true));
        }
      }
    }
  }
  
  public abstract JSONObject getContactById(String paramString)
    throws JSONException;
  
  protected String getJsonString(JSONObject paramJSONObject, String paramString)
  {
    localJSONObject = null;
    localObject = null;
    if (paramJSONObject != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      localObject = paramJSONObject;
      localJSONObject = paramJSONObject;
      if (paramJSONObject.equals("null"))
      {
        localJSONObject = paramJSONObject;
        localObject = new java/lang/StringBuilder;
        localJSONObject = paramJSONObject;
        ((StringBuilder)localObject).<init>();
        localJSONObject = paramJSONObject;
        Log.d("ContactsAccessor", paramString + " is string called 'null'");
        localObject = null;
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.d("ContactsAccessor", "Could not get = " + paramJSONObject.getMessage());
        localObject = localJSONObject;
      }
    }
    return (String)localObject;
  }
  
  protected boolean isRequired(String paramString, HashMap<String, Boolean> paramHashMap)
  {
    paramString = (Boolean)paramHashMap.get(paramString);
    if (paramString == null) {}
    for (boolean bool = false;; bool = paramString.booleanValue()) {
      return bool;
    }
  }
  
  public abstract boolean remove(String paramString);
  
  public abstract String save(JSONObject paramJSONObject);
  
  public abstract JSONArray search(JSONArray paramJSONArray, JSONObject paramJSONObject);
  
  class WhereOptions
  {
    private String where;
    private String[] whereArgs;
    
    WhereOptions() {}
    
    public String getWhere()
    {
      return this.where;
    }
    
    public String[] getWhereArgs()
    {
      return this.whereArgs;
    }
    
    public void setWhere(String paramString)
    {
      this.where = paramString;
    }
    
    public void setWhereArgs(String[] paramArrayOfString)
    {
      this.whereArgs = paramArrayOfString;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\ContactAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */