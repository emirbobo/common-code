package org.apache.cordova;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

class FileUtils$1
  implements Runnable
{
  FileUtils$1(FileUtils paramFileUtils, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, CallbackContext paramCallbackContext) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localObject1 = FileUtils.access$000(this.this$0, this.val$filename, this.val$start, this.val$end);
        switch (this.val$resultType)
        {
        default: 
          localObject2 = FileHelper.getMimeType(this.val$filename, this.this$0.cordova);
          localObject1 = Base64.encodeBase64((byte[])localObject1);
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localObject2 = ((StringBuilder)localObject3).append("data:").append((String)localObject2).append(";base64,");
          localObject3 = new java/lang/String;
          ((String)localObject3).<init>((byte[])localObject1, "US-ASCII");
          localObject2 = (String)localObject3;
          localObject1 = new org/apache/cordova/api/PluginResult;
          ((PluginResult)localObject1).<init>(PluginResult.Status.OK, (String)localObject2);
          this.val$callbackContext.sendPluginResult((PluginResult)localObject1);
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_FOUND_ERR));
        continue;
      }
      catch (IOException localIOException)
      {
        Log.d("FileUtils", localIOException.getLocalizedMessage());
        this.val$callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_READABLE_ERR));
        continue;
      }
      localObject2 = PluginResult.Status.OK;
      localObject3 = new java/lang/String;
      ((String)localObject3).<init>((byte[])localObject1, this.val$encoding);
      localObject1 = new PluginResult((PluginResult.Status)localObject2, (String)localObject3);
      continue;
      localObject1 = new PluginResult(PluginResult.Status.OK, (byte[])localObject1);
      continue;
      localObject1 = new PluginResult(PluginResult.Status.OK, (byte[])localObject1, true);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileUtils$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */