package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class WLProcedureInvocationResponse
  extends WLProcedureInvocationResult
{
  static
  {
    JniLib.a(WLProcedureInvocationResponse.class, 1298);
  }
  
  @Deprecated
  public WLProcedureInvocationResponse(WLResponse paramWLResponse)
  {
    super(paramWLResponse);
  }
  
  @Deprecated
  public native JSONObject getJSONResult()
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLProcedureInvocationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */