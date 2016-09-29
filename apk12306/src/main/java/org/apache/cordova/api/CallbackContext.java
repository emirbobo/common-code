package org.apache.cordova.api;

import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONObject;

public class CallbackContext
{
  private static final String LOG_TAG = "CordovaPlugin";
  private String callbackId;
  private int changingThreads;
  private boolean finished;
  private CordovaWebView webView;
  
  public CallbackContext(String paramString, CordovaWebView paramCordovaWebView)
  {
    this.callbackId = paramString;
    this.webView = paramCordovaWebView;
  }
  
  public void error(int paramInt)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.ERROR, paramInt));
  }
  
  public void error(String paramString)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.ERROR, paramString));
  }
  
  public void error(JSONObject paramJSONObject)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.ERROR, paramJSONObject));
  }
  
  public String getCallbackId()
  {
    return this.callbackId;
  }
  
  public boolean isChangingThreads()
  {
    if (this.changingThreads > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isFinished()
  {
    return this.finished;
  }
  
  /* Error */
  public void sendPluginResult(PluginResult paramPluginResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	org/apache/cordova/api/CallbackContext:finished	Z
    //   6: ifeq +48 -> 54
    //   9: new 61	java/lang/StringBuilder
    //   12: astore_3
    //   13: aload_3
    //   14: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   17: ldc 8
    //   19: aload_3
    //   20: ldc 64
    //   22: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 22	org/apache/cordova/api/CallbackContext:callbackId	Ljava/lang/String;
    //   29: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 70
    //   34: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 73	org/apache/cordova/api/PluginResult:getMessage	()Ljava/lang/String;
    //   41: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 82	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_1
    //   55: invokevirtual 85	org/apache/cordova/api/PluginResult:getKeepCallback	()Z
    //   58: ifne +27 -> 85
    //   61: iconst_1
    //   62: istore_2
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 59	org/apache/cordova/api/CallbackContext:finished	Z
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 24	org/apache/cordova/api/CallbackContext:webView	Lorg/apache/cordova/CordovaWebView;
    //   74: aload_1
    //   75: aload_0
    //   76: getfield 22	org/apache/cordova/api/CallbackContext:callbackId	Ljava/lang/String;
    //   79: invokevirtual 90	org/apache/cordova/CordovaWebView:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;Ljava/lang/String;)V
    //   82: goto -29 -> 53
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -24 -> 63
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	CallbackContext
    //   0	95	1	paramPluginResult	PluginResult
    //   62	25	2	bool	boolean
    //   12	8	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	53	90	finally
    //   54	61	90	finally
    //   63	70	90	finally
    //   91	93	90	finally
  }
  
  public void success()
  {
    sendPluginResult(new PluginResult(PluginResult.Status.OK));
  }
  
  public void success(int paramInt)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.OK, paramInt));
  }
  
  public void success(String paramString)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.OK, paramString));
  }
  
  public void success(JSONArray paramJSONArray)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.OK, paramJSONArray));
  }
  
  public void success(JSONObject paramJSONObject)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.OK, paramJSONObject));
  }
  
  public void success(byte[] paramArrayOfByte)
  {
    sendPluginResult(new PluginResult(PluginResult.Status.OK, paramArrayOfByte));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\api\CallbackContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */