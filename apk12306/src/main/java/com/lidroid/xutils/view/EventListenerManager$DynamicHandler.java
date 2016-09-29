package com.lidroid.xutils.view;

import com.bangcle.andjni.JniLib;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class EventListenerManager$DynamicHandler
  implements InvocationHandler
{
  private WeakReference<Object> handlerRef;
  private final HashMap<String, Method> methodMap = new HashMap(1);
  
  static
  {
    JniLib.a(DynamicHandler.class, 1029);
  }
  
  public EventListenerManager$DynamicHandler(Object paramObject)
  {
    this.handlerRef = new WeakReference(paramObject);
  }
  
  public native void addMethod(String paramString, Method paramMethod);
  
  public native Object getHandler();
  
  public native Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable;
  
  public native void setHandler(Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\EventListenerManager$DynamicHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */