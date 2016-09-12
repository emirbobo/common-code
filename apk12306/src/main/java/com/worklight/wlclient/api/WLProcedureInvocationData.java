package com.worklight.wlclient.api;

import com.bangcle.andjni.JniLib;
import java.util.Map;

public class WLProcedureInvocationData
{
  private String adapter;
  private boolean compressResponse = false;
  private Object[] parameters;
  private String procedure;
  
  static
  {
    JniLib.a(WLProcedureInvocationData.class, 1295);
  }
  
  public WLProcedureInvocationData(String paramString1, String paramString2)
  {
    this.adapter = paramString1;
    this.procedure = paramString2;
  }
  
  public WLProcedureInvocationData(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.adapter = paramString1;
    this.procedure = paramString2;
    this.compressResponse = paramBoolean;
  }
  
  native Map<String, String> getInvocationDataMap();
  
  public native void setCompressResponse(boolean paramBoolean);
  
  public native void setParameters(Object[] paramArrayOfObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\api\WLProcedureInvocationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */