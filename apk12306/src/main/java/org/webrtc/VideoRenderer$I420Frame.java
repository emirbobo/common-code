package org.webrtc;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class VideoRenderer$I420Frame
{
  public final int height;
  public int textureId;
  public Object textureObject;
  public final int width;
  public final boolean yuvFrame;
  public final ByteBuffer[] yuvPlanes;
  public final int[] yuvStrides;
  
  public VideoRenderer$I420Frame(int paramInt1, int paramInt2, Object paramObject, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.yuvStrides = null;
    this.yuvPlanes = null;
    this.textureObject = paramObject;
    this.textureId = paramInt3;
    this.yuvFrame = false;
  }
  
  public VideoRenderer$I420Frame(int paramInt1, int paramInt2, int[] paramArrayOfInt, ByteBuffer[] paramArrayOfByteBuffer)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.yuvStrides = paramArrayOfInt;
    ByteBuffer[] arrayOfByteBuffer = paramArrayOfByteBuffer;
    if (paramArrayOfByteBuffer == null)
    {
      arrayOfByteBuffer = new ByteBuffer[3];
      arrayOfByteBuffer[0] = ByteBuffer.allocateDirect(paramArrayOfInt[0] * paramInt2);
      arrayOfByteBuffer[1] = ByteBuffer.allocateDirect(paramArrayOfInt[1] * paramInt2);
      arrayOfByteBuffer[2] = ByteBuffer.allocateDirect(paramArrayOfInt[2] * paramInt2);
    }
    this.yuvPlanes = arrayOfByteBuffer;
    this.yuvFrame = true;
  }
  
  private void copyPlane(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    paramByteBuffer1.position(0).limit(paramByteBuffer1.capacity());
    paramByteBuffer2.put(paramByteBuffer1);
    paramByteBuffer2.position(0).limit(paramByteBuffer2.capacity());
  }
  
  public I420Frame copyFrom(I420Frame paramI420Frame)
  {
    if ((paramI420Frame.yuvFrame) && (this.yuvFrame))
    {
      if ((!Arrays.equals(this.yuvStrides, paramI420Frame.yuvStrides)) || (this.width != paramI420Frame.width) || (this.height != paramI420Frame.height)) {
        throw new RuntimeException("Mismatched dimensions!  Source: " + paramI420Frame.toString() + ", destination: " + toString());
      }
      copyPlane(paramI420Frame.yuvPlanes[0], this.yuvPlanes[0]);
      copyPlane(paramI420Frame.yuvPlanes[1], this.yuvPlanes[1]);
      copyPlane(paramI420Frame.yuvPlanes[2], this.yuvPlanes[2]);
    }
    for (;;)
    {
      return this;
      if ((paramI420Frame.yuvFrame) || (this.yuvFrame)) {
        break;
      }
      this.textureObject = paramI420Frame.textureObject;
      this.textureId = paramI420Frame.textureId;
    }
    throw new RuntimeException("Mismatched frame types!  Source: " + paramI420Frame.toString() + ", destination: " + toString());
  }
  
  public I420Frame copyFrom(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < this.width * this.height * 3 / 2) {
      throw new RuntimeException("Wrong arrays size: " + paramArrayOfByte.length);
    }
    if (!this.yuvFrame) {
      throw new RuntimeException("Can not feed yuv data to texture frame");
    }
    int i = this.width * this.height;
    ByteBuffer localByteBuffer1 = ByteBuffer.wrap(paramArrayOfByte, 0, i);
    ByteBuffer localByteBuffer2 = ByteBuffer.wrap(paramArrayOfByte, i, i / 4);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, i / 4 + i, i / 4);
    for (i = 0; i < 3; i++)
    {
      this.yuvPlanes[i].position(0);
      this.yuvPlanes[i].put(new ByteBuffer[] { localByteBuffer1, localByteBuffer2, paramArrayOfByte }[i]);
      this.yuvPlanes[i].position(0);
      this.yuvPlanes[i].limit(this.yuvPlanes[i].capacity());
    }
    return this;
  }
  
  public String toString()
  {
    return this.width + "x" + this.height + ":" + this.yuvStrides[0] + ":" + this.yuvStrides[1] + ":" + this.yuvStrides[2];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\VideoRenderer$I420Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */