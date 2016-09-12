package org.webrtc;

import java.nio.ByteBuffer;

class MediaCodecVideoEncoder$OutputBufferInfo
{
  private final ByteBuffer buffer;
  private final int index;
  private final boolean isKeyFrame;
  private final long presentationTimestampUs;
  
  public MediaCodecVideoEncoder$OutputBufferInfo(int paramInt, ByteBuffer paramByteBuffer, boolean paramBoolean, long paramLong)
  {
    this.index = paramInt;
    this.buffer = paramByteBuffer;
    this.isKeyFrame = paramBoolean;
    this.presentationTimestampUs = paramLong;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\MediaCodecVideoEncoder$OutputBufferInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */