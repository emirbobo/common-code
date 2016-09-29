package com.arrownock.live;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import bj;
import com.bangcle.andjni.JniLib;
import ct;

public class VideoView
  extends GLSurfaceView
{
  private int jdField_a_of_type_Int = 0;
  private bj jdField_a_of_type_Bj = null;
  private ct jdField_a_of_type_Ct = null;
  private int b = 0;
  
  static
  {
    JniLib.a(VideoView.class, 170);
  }
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public final native void a(int paramInt1, int paramInt2);
  
  public final native void a(bj parambj);
  
  public native int getVideoHeight();
  
  public native int getVideoWidth();
  
  protected native void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void setRenderer(GLSurfaceView.Renderer paramRenderer);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\live\VideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */