import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.Log;
import com.arrownock.live.VideoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class ct
  implements GLSurfaceView.Renderer
{
  private static final int e = Build.VERSION.SDK_INT;
  private int jdField_a_of_type_Int;
  private VideoView jdField_a_of_type_ComArrownockLiveVideoView;
  private ArrayList<cx> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public ct(VideoView paramVideoView)
  {
    this.jdField_a_of_type_ComArrownockLiveVideoView = paramVideoView;
    paramVideoView.setPreserveEGLContextOnPause(true);
    paramVideoView.setEGLContextClientVersion(2);
    paramVideoView.setRenderer(this);
    paramVideoView.setRenderMode(0);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private static int a(int paramInt, String paramString)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    int i = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
    {
      Log.e("MediaStreamsRenderer", "Could not compile shader " + paramInt + ":" + GLES20.glGetShaderInfoLog(i));
      throw new RuntimeException(GLES20.glGetShaderInfoLog(i));
    }
    b();
    return i;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    int k = a(35633, paramString1);
    int i = a(35632, paramString2);
    int j = GLES20.glCreateProgram();
    if (j == 0) {
      throw new RuntimeException("Could not create program");
    }
    GLES20.glAttachShader(j, k);
    GLES20.glAttachShader(j, i);
    GLES20.glLinkProgram(j);
    paramString1 = new int[1];
    paramString1[0] = 0;
    GLES20.glGetProgramiv(j, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("MediaStreamsRenderer", "Could not link program: " + GLES20.glGetProgramInfoLog(j));
      throw new RuntimeException(GLES20.glGetProgramInfoLog(j));
    }
    b();
    return j;
  }
  
  private static void b()
  {
    int j = GLES20.glGetError();
    if (j == 0) {}
    for (int i = 1;; i = 0)
    {
      String str = "GLES20 error: " + j;
      if (i != 0) {
        break;
      }
      throw new RuntimeException(str);
    }
  }
  
  public final cx a(cw arg1, boolean paramBoolean)
  {
    cx localcx = new cx(this, this.jdField_a_of_type_ComArrownockLiveVideoView, this.jdField_a_of_type_JavaUtilArrayList.size(), ???, paramBoolean, (byte)0);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Object localObject2;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = new java/util/concurrent/CountDownLatch;
        ((CountDownLatch)localObject2).<init>(1);
        VideoView localVideoView = this.jdField_a_of_type_ComArrownockLiveVideoView;
        cu localcu = new cu;
        localcu.<init>(this, localcx, (CountDownLatch)localObject2);
        localVideoView.queueEvent(localcu);
      }
      try
      {
        ((CountDownLatch)localObject2).await();
        this.jdField_a_of_type_JavaUtilArrayList.add(localcx);
        return localcx;
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new java/lang/RuntimeException;
        ((RuntimeException)localObject2).<init>(localInterruptedException);
        throw ((Throwable)localObject2);
      }
    }
  }
  
  public final void onDrawFrame(GL10 arg1)
  {
    GLES20.glClear(16384);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        cx.a((cx)localIterator.next());
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 arg1, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((cx)localIterator.next()).a(this.jdField_a_of_type_Int, this.b);
      }
    }
  }
  
  public final void onSurfaceCreated(GL10 arg1, EGLConfig paramEGLConfig)
  {
    if (e >= 17) {
      EGL14.eglGetCurrentContext();
    }
    this.c = a("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec2 in_tc;\n\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n", "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n");
    this.d = a("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec2 in_tc;\n\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc = in_tc;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n");
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      paramEGLConfig = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (paramEGLConfig.hasNext()) {
        cx.a((cx)paramEGLConfig.next(), this.c, this.d);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    b();
    GLES20.glClearColor(0.15F, 0.15F, 0.15F, 1.0F);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */