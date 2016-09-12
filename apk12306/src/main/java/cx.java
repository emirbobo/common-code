import android.util.Log;
import com.arrownock.live.VideoView;
import java.nio.FloatBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import org.webrtc.VideoRenderer.Callbacks;
import org.webrtc.VideoRenderer.I420Frame;

public final class cx
  implements VideoRenderer.Callbacks
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private VideoView jdField_a_of_type_ComArrownockLiveVideoView;
  private cv jdField_a_of_type_Cv;
  private cw jdField_a_of_type_Cw;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private LinkedBlockingQueue<VideoRenderer.I420Frame> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue;
  private VideoRenderer.I420Frame jdField_a_of_type_OrgWebrtcVideoRenderer$I420Frame;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = { -1, -1, -1 };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private VideoRenderer.I420Frame jdField_b_of_type_OrgWebrtcVideoRenderer$I420Frame;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = -1;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  private cx(ct paramct, VideoView paramVideoView, int paramInt, cw paramcw, boolean paramBoolean)
  {
    Log.d("MediaStreamsRenderer", "YuvImageRenderer.Create id: " + paramInt);
    this.jdField_a_of_type_ComArrownockLiveVideoView = paramVideoView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Cw = paramcw;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(1);
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = Math.min(1.0F, 1.0F);
    this.jdField_d_of_type_Float = Math.max(-1.0F, -1.0F);
    this.jdField_a_of_type_JavaNioFloatBuffer = ct.a(new float[] { this.jdField_a_of_type_Float, this.jdField_c_of_type_Float, this.jdField_a_of_type_Float, this.jdField_d_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_b_of_type_Float, this.jdField_d_of_type_Float });
    this.jdField_b_of_type_JavaNioFloatBuffer = ct.a(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    this.jdField_c_of_type_Boolean = false;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.h = paramInt1;
      this.i = paramInt2;
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  public final void renderFrame(VideoRenderer.I420Frame paramI420Frame)
  {
    long l2;
    for (;;)
    {
      Object localObject;
      try
      {
        l2 = System.nanoTime();
        this.e += 1;
        if ((this.jdField_a_of_type_OrgWebrtcVideoRenderer$I420Frame == null) || (this.jdField_b_of_type_OrgWebrtcVideoRenderer$I420Frame == null))
        {
          this.f += 1;
          return;
        }
        if (!paramI420Frame.yuvFrame) {
          break label241;
        }
        if ((paramI420Frame.yuvStrides[0] != paramI420Frame.width) || (paramI420Frame.yuvStrides[1] != paramI420Frame.width / 2) || (paramI420Frame.yuvStrides[2] != paramI420Frame.width / 2))
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>("Incorrect strides ");
          Log.e("MediaStreamsRenderer", paramI420Frame.yuvStrides[0] + ", " + paramI420Frame.yuvStrides[1] + ", " + paramI420Frame.yuvStrides[2]);
          continue;
        }
        if (paramI420Frame.width != this.jdField_a_of_type_OrgWebrtcVideoRenderer$I420Frame.width) {
          break label191;
        }
      }
      finally {}
      if (paramI420Frame.height != this.jdField_a_of_type_OrgWebrtcVideoRenderer$I420Frame.height)
      {
        label191:
        localObject = new java/lang/RuntimeException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Wrong frame size ");
        ((RuntimeException)localObject).<init>(paramI420Frame.width + " x " + paramI420Frame.height);
        throw ((Throwable)localObject);
      }
      label241:
      if (this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.size() <= 0) {
        break;
      }
      this.f += 1;
    }
    if (paramI420Frame.yuvFrame)
    {
      this.jdField_a_of_type_OrgWebrtcVideoRenderer$I420Frame.copyFrom(paramI420Frame);
      this.jdField_a_of_type_Cv = cv.jdField_a_of_type_Cv;
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(this.jdField_a_of_type_OrgWebrtcVideoRenderer$I420Frame);
    }
    for (;;)
    {
      long l1 = this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = (System.nanoTime() - l2 + l1);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComArrownockLiveVideoView.requestRender();
      break;
      this.jdField_b_of_type_OrgWebrtcVideoRenderer$I420Frame.copyFrom(paramI420Frame);
      this.jdField_a_of_type_Cv = cv.b;
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.offer(this.jdField_b_of_type_OrgWebrtcVideoRenderer$I420Frame);
    }
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    Log.d("MediaStreamsRenderer", "ID: " + this.jdField_a_of_type_Int + ". YuvImageRenderer.setSize: " + paramInt1 + " x " + paramInt2);
    this.jdField_a_of_type_ComArrownockLiveVideoView.a(paramInt1, paramInt2);
    this.j = paramInt1;
    this.k = paramInt2;
    int m = paramInt1 / 2;
    int n = paramInt1 / 2;
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.poll();
      VideoRenderer.I420Frame localI420Frame = new org/webrtc/VideoRenderer$I420Frame;
      localI420Frame.<init>(paramInt1, paramInt2, new int[] { paramInt1, m, n }, null);
      this.jdField_a_of_type_OrgWebrtcVideoRenderer$I420Frame = localI420Frame;
      localI420Frame = new org/webrtc/VideoRenderer$I420Frame;
      localI420Frame.<init>(paramInt1, paramInt2, null, -1);
      this.jdField_b_of_type_OrgWebrtcVideoRenderer$I420Frame = localI420Frame;
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */