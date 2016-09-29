package org.webrtc.videoengine;

import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class ViEAndroidGLES20$ContextFactory
  implements GLSurfaceView.EGLContextFactory
{
  private static int EGL_CONTEXT_CLIENT_VERSION = 12440;
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    Log.w(ViEAndroidGLES20.access$100(), "creating OpenGL ES 2.0 context");
    ViEAndroidGLES20.access$200("Before eglCreateContext", paramEGL10);
    int i = EGL_CONTEXT_CLIENT_VERSION;
    paramEGLDisplay = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    ViEAndroidGLES20.access$200("After eglCreateContext", paramEGL10);
    return paramEGLDisplay;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\videoengine\ViEAndroidGLES20$ContextFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */