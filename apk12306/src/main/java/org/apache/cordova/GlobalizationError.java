package org.apache.cordova;

import org.json.JSONException;
import org.json.JSONObject;

public class GlobalizationError
  extends Exception
{
  public static final String FORMATTING_ERROR = "FORMATTING_ERROR";
  public static final String PARSING_ERROR = "PARSING_ERROR";
  public static final String PATTERN_ERROR = "PATTERN_ERROR";
  public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
  private static final long serialVersionUID = 1L;
  int error = 0;
  
  public GlobalizationError() {}
  
  public GlobalizationError(String paramString)
  {
    if (paramString.equalsIgnoreCase("FORMATTING_ERROR")) {
      this.error = 1;
    }
    for (;;)
    {
      return;
      if (paramString.equalsIgnoreCase("PARSING_ERROR")) {
        this.error = 2;
      } else if (paramString.equalsIgnoreCase("PATTERN_ERROR")) {
        this.error = 3;
      }
    }
  }
  
  public int getErrorCode()
  {
    return this.error;
  }
  
  public String getErrorString()
  {
    String str = "";
    switch (this.error)
    {
    }
    for (;;)
    {
      return str;
      str = "UNKNOWN_ERROR";
      continue;
      str = "FORMATTING_ERROR";
      continue;
      str = "PARSING_ERROR";
      continue;
      str = "PATTERN_ERROR";
    }
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", getErrorCode());
      localJSONObject.put("message", getErrorString());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\GlobalizationError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */