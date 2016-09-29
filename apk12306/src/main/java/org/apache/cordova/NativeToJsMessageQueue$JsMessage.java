package org.apache.cordova;

import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

class NativeToJsMessageQueue$JsMessage
{
  final String jsPayloadOrCallbackId;
  final PluginResult pluginResult;
  
  NativeToJsMessageQueue$JsMessage(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.jsPayloadOrCallbackId = paramString;
    this.pluginResult = null;
  }
  
  NativeToJsMessageQueue$JsMessage(PluginResult paramPluginResult, String paramString)
  {
    if ((paramString == null) || (paramPluginResult == null)) {
      throw new NullPointerException();
    }
    this.jsPayloadOrCallbackId = paramString;
    this.pluginResult = paramPluginResult;
  }
  
  int calculateEncodedLength()
  {
    int i;
    if (this.pluginResult == null) {
      i = this.jsPayloadOrCallbackId.length() + 1;
    }
    for (;;)
    {
      return i;
      i = String.valueOf(this.pluginResult.getStatus()).length() + 2 + 1 + this.jsPayloadOrCallbackId.length() + 1;
      switch (this.pluginResult.getMessageType())
      {
      case 2: 
      default: 
        i += this.pluginResult.getMessage().length();
        break;
      case 4: 
      case 5: 
        i++;
        break;
      case 3: 
        i += this.pluginResult.getMessage().length() + 1;
        break;
      case 1: 
        i += this.pluginResult.getStrMessage().length() + 1;
        break;
      case 7: 
        i += this.pluginResult.getMessage().length() + 1;
        break;
      case 6: 
        i += this.pluginResult.getMessage().length() + 1;
      }
    }
  }
  
  void encodeAsJsMessage(StringBuilder paramStringBuilder)
  {
    if (this.pluginResult == null)
    {
      paramStringBuilder.append(this.jsPayloadOrCallbackId);
      return;
    }
    int i = this.pluginResult.getStatus();
    if ((i == PluginResult.Status.OK.ordinal()) || (i == PluginResult.Status.NO_RESULT.ordinal())) {}
    for (boolean bool = true;; bool = false)
    {
      paramStringBuilder.append("cordova.callbackFromNative('").append(this.jsPayloadOrCallbackId).append("',").append(bool).append(",").append(i).append(",[").append(this.pluginResult.getMessage()).append("],").append(this.pluginResult.getKeepCallback()).append(");");
      break;
    }
  }
  
  void encodeAsMessage(StringBuilder paramStringBuilder)
  {
    if (this.pluginResult == null) {
      paramStringBuilder.append('J').append(this.jsPayloadOrCallbackId);
    }
    for (;;)
    {
      label21:
      return;
      int j = this.pluginResult.getStatus();
      char c2;
      label44:
      int i;
      label58:
      label81:
      StringBuilder localStringBuilder;
      if (j == PluginResult.Status.NO_RESULT.ordinal())
      {
        c2 = '\001';
        if (j != PluginResult.Status.OK.ordinal()) {
          break label196;
        }
        i = 1;
        boolean bool = this.pluginResult.getKeepCallback();
        if ((c2 == 0) && (i == 0)) {
          break label202;
        }
        c2 = 'S';
        c1 = c2;
        localStringBuilder = paramStringBuilder.append(c1);
        if (!bool) {
          break label210;
        }
        c2 = '1';
      }
      for (char c1 = c2;; c1 = c2)
      {
        localStringBuilder.append(c1).append(j).append(' ').append(this.jsPayloadOrCallbackId).append(' ');
        switch (this.pluginResult.getMessageType())
        {
        case 2: 
        default: 
          paramStringBuilder.append(this.pluginResult.getMessage());
          break label21;
          c2 = '\000';
          break label44;
          label196:
          i = 0;
          break label58;
          label202:
          c2 = 'F';
          c1 = c2;
          break label81;
          label210:
          c2 = '0';
        }
      }
      paramStringBuilder.append(this.pluginResult.getMessage().charAt(0));
      continue;
      paramStringBuilder.append('N');
      continue;
      paramStringBuilder.append('n').append(this.pluginResult.getMessage());
      continue;
      paramStringBuilder.append('s');
      paramStringBuilder.append(this.pluginResult.getStrMessage());
      continue;
      paramStringBuilder.append('S');
      paramStringBuilder.append(this.pluginResult.getMessage());
      continue;
      paramStringBuilder.append('A');
      paramStringBuilder.append(this.pluginResult.getMessage());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NativeToJsMessageQueue$JsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */