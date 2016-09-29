package org.apache.cordova;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

public class NativeToJsMessageQueue
{
  private static final int DEFAULT_BRIDGE_MODE = 2;
  static final boolean DISABLE_EXEC_CHAINING = false;
  static final boolean ENABLE_LOCATION_CHANGE_EXEC_MODE = false;
  private static final boolean FORCE_ENCODE_USING_EVAL = false;
  private static final String LOG_TAG = "JsMessageQueue";
  private static int MAX_PAYLOAD_SIZE = -1;
  private int activeListenerIndex;
  private final CordovaInterface cordova;
  private boolean paused;
  private final LinkedList<JsMessage> queue = new LinkedList();
  private final BridgeMode[] registeredListeners;
  private final CordovaWebView webView;
  
  public NativeToJsMessageQueue(CordovaWebView paramCordovaWebView, CordovaInterface paramCordovaInterface)
  {
    this.cordova = paramCordovaInterface;
    this.webView = paramCordovaWebView;
    this.registeredListeners = new BridgeMode[4];
    this.registeredListeners[0] = null;
    this.registeredListeners[1] = new LoadUrlBridgeMode(null);
    this.registeredListeners[2] = new OnlineEventsBridgeMode();
    this.registeredListeners[3] = new PrivateApiBridgeMode(null);
    reset();
  }
  
  private int calculatePackedMessageLength(JsMessage paramJsMessage)
  {
    int i = paramJsMessage.calculateEncodedLength();
    return String.valueOf(i).length() + i + 1;
  }
  
  private void enqueueMessage(JsMessage paramJsMessage)
  {
    try
    {
      this.queue.add(paramJsMessage);
      if ((!this.paused) && (this.registeredListeners[this.activeListenerIndex] != null)) {
        this.registeredListeners[this.activeListenerIndex].onNativeToJsMessageAvailable();
      }
      return;
    }
    finally {}
  }
  
  private void packMessage(JsMessage paramJsMessage, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramJsMessage.calculateEncodedLength()).append(' ');
    paramJsMessage.encodeAsMessage(paramStringBuilder);
  }
  
  private String popAndEncodeAsJs()
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        if (this.queue.size() == 0)
        {
          localObject1 = null;
          return (String)localObject1;
        }
        i = 0;
        j = 0;
        Object localObject1 = this.queue.iterator();
        JsMessage localJsMessage;
        if (((Iterator)localObject1).hasNext())
        {
          k = ((JsMessage)((Iterator)localObject1).next()).calculateEncodedLength() + 50;
          if ((j <= 0) || (i + k <= MAX_PAYLOAD_SIZE) || (MAX_PAYLOAD_SIZE <= 0)) {}
        }
        else
        {
          if (j != this.queue.size()) {
            continue;
          }
          k = 1;
          localObject1 = new java/lang/StringBuilder;
          if (k == 0) {
            continue;
          }
          m = 0;
          ((StringBuilder)localObject1).<init>(m + i);
          i = 0;
          if (i >= j) {
            break label211;
          }
          localJsMessage = (JsMessage)this.queue.removeFirst();
          if ((k == 0) || (i + 1 != j)) {
            continue;
          }
          localJsMessage.encodeAsJsMessage((StringBuilder)localObject1);
          i++;
          continue;
        }
        i += k;
        j++;
        continue;
        k = 0;
        continue;
        int m = 100;
        continue;
        ((StringBuilder)localObject1).append("try{");
        localJsMessage.encodeAsJsMessage((StringBuilder)localObject1);
        ((StringBuilder)localObject1).append("}finally{");
        continue;
        if (k != 0) {
          break label223;
        }
      }
      finally {}
      label211:
      ((StringBuilder)localObject2).append("window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);");
      label223:
      if (k != 0) {
        i = 1;
      }
      while (i < j)
      {
        ((StringBuilder)localObject2).append('}');
        i++;
        continue;
        i = 0;
      }
      String str = ((StringBuilder)localObject2).toString();
    }
  }
  
  public void addJavaScript(String paramString)
  {
    enqueueMessage(new JsMessage(paramString));
  }
  
  public void addPluginResult(PluginResult paramPluginResult, String paramString)
  {
    if (paramString == null)
    {
      Log.e("JsMessageQueue", "Got plugin result with no callbackId", new Throwable());
      return;
    }
    if (paramPluginResult.getStatus() == PluginResult.Status.NO_RESULT.ordinal()) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = paramPluginResult.getKeepCallback();
      if ((i != 0) && (bool)) {
        break;
      }
      enqueueMessage(new JsMessage(paramPluginResult, paramString));
      break;
    }
  }
  
  public boolean getPaused()
  {
    return this.paused;
  }
  
  /* Error */
  public String popAndEncode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	org/apache/cordova/NativeToJsMessageQueue:queue	Ljava/util/LinkedList;
    //   6: invokevirtual 215	java/util/LinkedList:isEmpty	()Z
    //   9: ifeq +11 -> 20
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 4
    //   19: areturn
    //   20: iconst_0
    //   21: istore_2
    //   22: iconst_0
    //   23: istore_1
    //   24: aload_0
    //   25: getfield 63	org/apache/cordova/NativeToJsMessageQueue:queue	Ljava/util/LinkedList;
    //   28: invokevirtual 141	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   31: astore 4
    //   33: aload 4
    //   35: invokeinterface 147 1 0
    //   40: ifeq +37 -> 77
    //   43: aload_0
    //   44: aload 4
    //   46: invokeinterface 151 1 0
    //   51: checkcast 11	org/apache/cordova/NativeToJsMessageQueue$JsMessage
    //   54: invokespecial 217	org/apache/cordova/NativeToJsMessageQueue:calculatePackedMessageLength	(Lorg/apache/cordova/NativeToJsMessageQueue$JsMessage;)I
    //   57: istore_3
    //   58: iload_1
    //   59: ifle +58 -> 117
    //   62: iload_2
    //   63: iload_3
    //   64: iadd
    //   65: getstatic 53	org/apache/cordova/NativeToJsMessageQueue:MAX_PAYLOAD_SIZE	I
    //   68: if_icmple +49 -> 117
    //   71: getstatic 53	org/apache/cordova/NativeToJsMessageQueue:MAX_PAYLOAD_SIZE	I
    //   74: ifle +43 -> 117
    //   77: new 123	java/lang/StringBuilder
    //   80: astore 4
    //   82: aload 4
    //   84: iload_2
    //   85: invokespecial 154	java/lang/StringBuilder:<init>	(I)V
    //   88: iconst_0
    //   89: istore_2
    //   90: iload_2
    //   91: iload_1
    //   92: if_icmpge +35 -> 127
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 63	org/apache/cordova/NativeToJsMessageQueue:queue	Ljava/util/LinkedList;
    //   100: invokevirtual 157	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   103: checkcast 11	org/apache/cordova/NativeToJsMessageQueue$JsMessage
    //   106: aload 4
    //   108: invokespecial 219	org/apache/cordova/NativeToJsMessageQueue:packMessage	(Lorg/apache/cordova/NativeToJsMessageQueue$JsMessage;Ljava/lang/StringBuilder;)V
    //   111: iinc 2 1
    //   114: goto -24 -> 90
    //   117: iload_2
    //   118: iload_3
    //   119: iadd
    //   120: istore_2
    //   121: iinc 1 1
    //   124: goto -91 -> 33
    //   127: aload_0
    //   128: getfield 63	org/apache/cordova/NativeToJsMessageQueue:queue	Ljava/util/LinkedList;
    //   131: invokevirtual 215	java/util/LinkedList:isEmpty	()Z
    //   134: ifne +11 -> 145
    //   137: aload 4
    //   139: bipush 42
    //   141: invokevirtual 130	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore 4
    //   152: aload_0
    //   153: monitorexit
    //   154: goto -137 -> 17
    //   157: astore 4
    //   159: aload_0
    //   160: monitorexit
    //   161: aload 4
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	NativeToJsMessageQueue
    //   23	99	1	i	int
    //   21	100	2	j	int
    //   57	63	3	k	int
    //   13	138	4	localObject1	Object
    //   157	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	157	finally
    //   15	17	157	finally
    //   24	33	157	finally
    //   33	58	157	finally
    //   62	77	157	finally
    //   77	88	157	finally
    //   95	111	157	finally
    //   127	145	157	finally
    //   145	154	157	finally
    //   159	161	157	finally
  }
  
  public void reset()
  {
    try
    {
      this.queue.clear();
      setBridgeMode(2);
      return;
    }
    finally {}
  }
  
  public void setBridgeMode(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.registeredListeners.length)) {
      Log.d("JsMessageQueue", "Invalid NativeToJsBridgeMode: " + paramInt);
    }
    for (;;)
    {
      return;
      if (paramInt == this.activeListenerIndex) {
        continue;
      }
      Log.d("JsMessageQueue", "Set native->JS mode to " + paramInt);
      try
      {
        this.activeListenerIndex = paramInt;
        BridgeMode localBridgeMode = this.registeredListeners[paramInt];
        if ((!this.paused) && (!this.queue.isEmpty()) && (localBridgeMode != null)) {
          localBridgeMode.onNativeToJsMessageAvailable();
        }
      }
      finally {}
    }
  }
  
  public void setPaused(boolean paramBoolean)
  {
    if ((this.paused) && (paramBoolean)) {
      Log.e("JsMessageQueue", "nested call to setPaused detected.", new Throwable());
    }
    this.paused = paramBoolean;
    if (!paramBoolean) {}
    try
    {
      if ((!this.queue.isEmpty()) && (this.registeredListeners[this.activeListenerIndex] != null)) {
        this.registeredListeners[this.activeListenerIndex].onNativeToJsMessageAvailable();
      }
      return;
    }
    finally {}
  }
  
  private static abstract interface BridgeMode
  {
    public abstract void onNativeToJsMessageAvailable();
  }
  
  private static class JsMessage
  {
    final String jsPayloadOrCallbackId;
    final PluginResult pluginResult;
    
    JsMessage(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.jsPayloadOrCallbackId = paramString;
      this.pluginResult = null;
    }
    
    JsMessage(PluginResult paramPluginResult, String paramString)
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
  
  private class LoadUrlBridgeMode
    implements NativeToJsMessageQueue.BridgeMode
  {
    final Runnable runnable = new Runnable()
    {
      public void run()
      {
        String str = NativeToJsMessageQueue.this.popAndEncodeAsJs();
        if (str != null) {
          NativeToJsMessageQueue.this.webView.loadUrlNow("javascript:" + str);
        }
      }
    };
    
    private LoadUrlBridgeMode() {}
    
    public void onNativeToJsMessageAvailable()
    {
      NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.runnable);
    }
  }
  
  private class OnlineEventsBridgeMode
    implements NativeToJsMessageQueue.BridgeMode
  {
    boolean online = true;
    final Runnable runnable = new Runnable()
    {
      public void run()
      {
        NativeToJsMessageQueue.OnlineEventsBridgeMode localOnlineEventsBridgeMode;
        if (!NativeToJsMessageQueue.this.queue.isEmpty())
        {
          localOnlineEventsBridgeMode = NativeToJsMessageQueue.OnlineEventsBridgeMode.this;
          if (NativeToJsMessageQueue.OnlineEventsBridgeMode.this.online) {
            break label59;
          }
        }
        label59:
        for (boolean bool = true;; bool = false)
        {
          localOnlineEventsBridgeMode.online = bool;
          NativeToJsMessageQueue.this.webView.setNetworkAvailable(NativeToJsMessageQueue.OnlineEventsBridgeMode.this.online);
          return;
        }
      }
    };
    
    OnlineEventsBridgeMode()
    {
      NativeToJsMessageQueue.this.webView.setNetworkAvailable(true);
    }
    
    public void onNativeToJsMessageAvailable()
    {
      NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.runnable);
    }
  }
  
  private class PrivateApiBridgeMode
    implements NativeToJsMessageQueue.BridgeMode
  {
    private static final int EXECUTE_JS = 194;
    boolean initFailed;
    Method sendMessageMethod;
    Object webViewCore;
    
    private PrivateApiBridgeMode() {}
    
    private void initReflection()
    {
      Object localObject2 = NativeToJsMessageQueue.this.webView;
      localObject4 = WebView.class;
      Object localObject1 = localObject2;
      for (;;)
      {
        try
        {
          Object localObject5 = WebView.class.getDeclaredField("mProvider");
          localObject1 = localObject2;
          ((Field)localObject5).setAccessible(true);
          localObject1 = localObject2;
          localObject2 = ((Field)localObject5).get(NativeToJsMessageQueue.this.webView);
          localObject1 = localObject2;
          localObject5 = localObject2.getClass();
          localObject4 = localObject5;
          localObject1 = localObject2;
          localObject2 = localObject4;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject3 = localObject4;
          continue;
        }
        try
        {
          localObject2 = ((Class)localObject2).getDeclaredField("mWebViewCore");
          ((Field)localObject2).setAccessible(true);
          this.webViewCore = ((Field)localObject2).get(localObject1);
          if (this.webViewCore != null)
          {
            this.sendMessageMethod = this.webViewCore.getClass().getDeclaredMethod("sendMessage", new Class[] { Message.class });
            this.sendMessageMethod.setAccessible(true);
          }
          return;
        }
        catch (Throwable localThrowable1)
        {
          this.initFailed = true;
          Log.e("JsMessageQueue", "PrivateApiBridgeMode failed to find the expected APIs.", localThrowable1);
        }
      }
    }
    
    public void onNativeToJsMessageAvailable()
    {
      if ((this.sendMessageMethod == null) && (!this.initFailed)) {
        initReflection();
      }
      Message localMessage;
      if (this.sendMessageMethod != null) {
        localMessage = Message.obtain(null, 194, NativeToJsMessageQueue.this.popAndEncodeAsJs());
      }
      try
      {
        this.sendMessageMethod.invoke(this.webViewCore, new Object[] { localMessage });
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("JsMessageQueue", "Reflection message bridge failed.", localThrowable);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\NativeToJsMessageQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */