package com.ta.utdid2.android.utils;

abstract class Base64$Coder
{
  public int op;
  public byte[] output;
  
  public abstract int maxOutputSize(int paramInt);
  
  public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\android\utils\Base64$Coder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */