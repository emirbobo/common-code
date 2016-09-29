package org.webrtc.videoengine;

import android.content.Context;
import android.view.SurfaceView;

public class ViERenderer
{
  public static SurfaceView CreateRenderer(Context paramContext)
  {
    return CreateRenderer(paramContext, false);
  }
  
  public static SurfaceView CreateRenderer(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean == true) && (ViEAndroidGLES20.IsSupported(paramContext))) {}
    for (paramContext = new ViEAndroidGLES20(paramContext);; paramContext = new SurfaceView(paramContext)) {
      return paramContext;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\videoengine\ViERenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */