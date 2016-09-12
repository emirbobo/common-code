package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import org.json.JSONException;
import org.json.JSONObject;

public class WLProcedureInvocationResult
  extends WLResponse
{
  private static final String JSON_KEY_IS_SUCCESSFUL = "isSuccessful";
  private JSONObject jsonResult;
  
  static
  {
    JniLib.a(WLProcedureInvocationResult.class, 1297);
  }
  
  WLProcedureInvocationResult(WLResponse paramWLResponse)
  {
    super(paramWLResponse);
  }
  
  public native JSONObject getResult()
    throws JSONException;
  
  public native boolean isSuccessful();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLProcedureInvocationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */