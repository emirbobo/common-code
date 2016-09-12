package com.lidroid.xutils.view;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.util.DoubleKeyValueMap;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class EventListenerManager
{
  private static final DoubleKeyValueMap<ViewInjectInfo, Class<?>, Object> listenerCache = new DoubleKeyValueMap();
  
  static
  {
    JniLib.a(EventListenerManager.class, 1030);
  }
  
  public static native void addEventMethod(ViewFinder paramViewFinder, ViewInjectInfo paramViewInjectInfo, Annotation paramAnnotation, Object paramObject, Method paramMethod);
  
  public static class DynamicHandler
    implements InvocationHandler
  {
    private WeakReference<Object> handlerRef;
    private final HashMap<String, Method> methodMap = new HashMap(1);
    
    static
    {
      JniLib.a(DynamicHandler.class, 1029);
    }
    
    public DynamicHandler(Object paramObject)
    {
      this.handlerRef = new WeakReference(paramObject);
    }
    
    public native void addMethod(String paramString, Method paramMethod);
    
    public native Object getHandler();
    
    public native Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable;
    
    public native void setHandler(Object paramObject);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\view\EventListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */