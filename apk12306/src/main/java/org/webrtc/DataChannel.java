package org.webrtc;

import java.nio.ByteBuffer;

public class DataChannel
{
  private final long nativeDataChannel;
  private long nativeObserver;
  
  public DataChannel(long paramLong)
  {
    this.nativeDataChannel = paramLong;
  }
  
  private native long registerObserverNative(DataChannel.Observer paramObserver);
  
  private native boolean sendNative(byte[] paramArrayOfByte, boolean paramBoolean);
  
  private native void unregisterObserverNative(long paramLong);
  
  public native long bufferedAmount();
  
  public native void close();
  
  public native void dispose();
  
  public native String label();
  
  public void registerObserver(DataChannel.Observer paramObserver)
  {
    if (this.nativeObserver != 0L) {
      unregisterObserverNative(this.nativeObserver);
    }
    this.nativeObserver = registerObserverNative(paramObserver);
  }
  
  public boolean send(DataChannel.Buffer paramBuffer)
  {
    byte[] arrayOfByte = new byte[paramBuffer.data.remaining()];
    paramBuffer.data.get(arrayOfByte);
    return sendNative(arrayOfByte, paramBuffer.binary);
  }
  
  public native DataChannel.State state();
  
  public void unregisterObserver()
  {
    unregisterObserverNative(this.nativeObserver);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\DataChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */