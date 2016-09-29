package org.apache.cordova;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;

final class FileTransfer$RequestContext
{
  boolean aborted;
  CallbackContext callbackContext;
  InputStream currentInputStream;
  OutputStream currentOutputStream;
  String source;
  String target;
  File targetFile;
  
  FileTransfer$RequestContext(String paramString1, String paramString2, CallbackContext paramCallbackContext)
  {
    this.source = paramString1;
    this.target = paramString2;
    this.callbackContext = paramCallbackContext;
  }
  
  void sendPluginResult(PluginResult paramPluginResult)
  {
    try
    {
      if (!this.aborted) {
        this.callbackContext.sendPluginResult(paramPluginResult);
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileTransfer$RequestContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */