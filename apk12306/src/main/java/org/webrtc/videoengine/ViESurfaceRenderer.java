package org.webrtc.videoengine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Process;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ViESurfaceRenderer
  implements SurfaceHolder.Callback
{
  private static final String TAG = "WEBRTC";
  private Bitmap bitmap = null;
  private ByteBuffer byteBuffer = null;
  private float dstBottomScale = 1.0F;
  private float dstLeftScale = 0.0F;
  private Rect dstRect = new Rect();
  private float dstRightScale = 1.0F;
  private float dstTopScale = 0.0F;
  private Rect srcRect = new Rect();
  private SurfaceHolder surfaceHolder;
  
  public ViESurfaceRenderer(SurfaceView paramSurfaceView)
  {
    this.surfaceHolder = paramSurfaceView.getHolder();
    if (this.surfaceHolder == null) {}
    for (;;)
    {
      return;
      this.surfaceHolder.addCallback(this);
    }
  }
  
  private void changeDestRect(int paramInt1, int paramInt2)
  {
    this.dstRect.right = ((int)(this.dstRect.left + this.dstRightScale * paramInt1));
    this.dstRect.bottom = ((int)(this.dstRect.top + this.dstBottomScale * paramInt2));
  }
  
  private void saveBitmapToJPEG(int paramInt1, int paramInt2)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    this.bitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    try
    {
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      localFileOutputStream.<init>(String.format("/sdcard/render_%d.jpg", new Object[] { Long.valueOf(System.currentTimeMillis()) }));
      localFileOutputStream.write(localByteArrayOutputStream.toByteArray());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public Bitmap CreateBitmap(int paramInt1, int paramInt2)
  {
    Log.d("WEBRTC", "CreateByteBitmap " + paramInt1 + ":" + paramInt2);
    if (this.bitmap == null) {}
    try
    {
      Process.setThreadPriority(-4);
      this.bitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      this.srcRect.left = 0;
      this.srcRect.top = 0;
      this.srcRect.bottom = paramInt2;
      this.srcRect.right = paramInt1;
      return this.bitmap;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public ByteBuffer CreateByteBuffer(int paramInt1, int paramInt2)
  {
    Log.d("WEBRTC", "CreateByteBuffer " + paramInt1 + ":" + paramInt2);
    if (this.bitmap == null)
    {
      this.bitmap = CreateBitmap(paramInt1, paramInt2);
      this.byteBuffer = ByteBuffer.allocateDirect(paramInt1 * paramInt2 << 1);
    }
    return this.byteBuffer;
  }
  
  public void DrawBitmap()
  {
    if (this.bitmap == null) {}
    for (;;)
    {
      return;
      Canvas localCanvas = this.surfaceHolder.lockCanvas();
      if (localCanvas != null)
      {
        localCanvas.drawBitmap(this.bitmap, this.srcRect, this.dstRect, null);
        this.surfaceHolder.unlockCanvasAndPost(localCanvas);
      }
    }
  }
  
  public void DrawByteBuffer()
  {
    if (this.byteBuffer == null) {}
    for (;;)
    {
      return;
      this.byteBuffer.rewind();
      this.bitmap.copyPixelsFromBuffer(this.byteBuffer);
      DrawBitmap();
    }
  }
  
  public void SetCoordinates(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Log.d("WEBRTC", "SetCoordinates " + paramFloat1 + "," + paramFloat2 + ":" + paramFloat3 + "," + paramFloat4);
    this.dstLeftScale = paramFloat1;
    this.dstTopScale = paramFloat2;
    this.dstRightScale = paramFloat3;
    this.dstBottomScale = paramFloat4;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("WEBRTC", "ViESurfaceRender::surfaceChanged");
    changeDestRect(paramInt2, paramInt3);
    Log.d("WEBRTC", "ViESurfaceRender::surfaceChanged in_width:" + paramInt2 + " in_height:" + paramInt3 + " srcRect.left:" + this.srcRect.left + " srcRect.top:" + this.srcRect.top + " srcRect.right:" + this.srcRect.right + " srcRect.bottom:" + this.srcRect.bottom + " dstRect.left:" + this.dstRect.left + " dstRect.top:" + this.dstRect.top + " dstRect.right:" + this.dstRect.right + " dstRect.bottom:" + this.dstRect.bottom);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Canvas localCanvas = this.surfaceHolder.lockCanvas();
    if (localCanvas != null)
    {
      paramSurfaceHolder = this.surfaceHolder.getSurfaceFrame();
      if (paramSurfaceHolder != null)
      {
        changeDestRect(paramSurfaceHolder.right - paramSurfaceHolder.left, paramSurfaceHolder.bottom - paramSurfaceHolder.top);
        Log.d("WEBRTC", "ViESurfaceRender::surfaceCreated dst.left:" + paramSurfaceHolder.left + " dst.top:" + paramSurfaceHolder.top + " dst.right:" + paramSurfaceHolder.right + " dst.bottom:" + paramSurfaceHolder.bottom + " srcRect.left:" + this.srcRect.left + " srcRect.top:" + this.srcRect.top + " srcRect.right:" + this.srcRect.right + " srcRect.bottom:" + this.srcRect.bottom + " dstRect.left:" + this.dstRect.left + " dstRect.top:" + this.dstRect.top + " dstRect.right:" + this.dstRect.right + " dstRect.bottom:" + this.dstRect.bottom);
      }
      this.surfaceHolder.unlockCanvasAndPost(localCanvas);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.d("WEBRTC", "ViESurfaceRenderer::surfaceDestroyed");
    this.bitmap = null;
    this.byteBuffer = null;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\videoengine\ViESurfaceRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */