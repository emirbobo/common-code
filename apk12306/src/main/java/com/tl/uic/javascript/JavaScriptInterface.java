package com.tl.uic.javascript;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class JavaScriptInterface
{
  static
  {
    JniLib.a(JavaScriptInterface.class, 1092);
  }
  
  public JavaScriptInterface(Context paramContext) {}
  
  public final native void addMessage(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\javascript\JavaScriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */