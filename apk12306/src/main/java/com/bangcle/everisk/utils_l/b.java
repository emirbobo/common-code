package com.bangcle.everisk.utils_l;

import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;

public final class b
  extends RandomAccessFile
{
  private boolean V;
  
  public b(File paramFile, String paramString)
  {
    super(paramFile, paramString);
  }
  
  public final int A()
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = read();
    arrayOfInt[1] = read();
    arrayOfInt[2] = read();
    arrayOfInt[3] = read();
    if ((arrayOfInt[0] | arrayOfInt[1] | arrayOfInt[2] | arrayOfInt[3]) < 0) {
      throw new EOFException();
    }
    int k;
    int j;
    if (this.V)
    {
      i = arrayOfInt[3];
      k = arrayOfInt[2];
      j = arrayOfInt[1];
    }
    for (int i = arrayOfInt[0] + ((i << 24) + (k << 16) + (j << 8));; i = arrayOfInt[3] + ((k << 24) + (j << 16) + (i << 8)))
    {
      return i;
      k = arrayOfInt[0];
      j = arrayOfInt[1];
      i = arrayOfInt[2];
    }
  }
  
  public final long B()
  {
    byte[] arrayOfByte = new byte[8];
    super.readFully(arrayOfByte);
    long l2;
    int j;
    if (this.V)
    {
      l1 = 0L;
      i = 7;
      for (;;)
      {
        l2 = l1;
        if (i < 0) {
          break;
        }
        j = i << 3;
        l2 = arrayOfByte[i];
        i--;
        l1 = (l2 << j & 255L << j) + l1;
      }
    }
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i > 7) {
        break;
      }
      j = 7 - i << 3;
      l2 = arrayOfByte[i];
      i++;
      l1 = (255L << j & l2 << j) + l1;
    }
    return l2;
  }
  
  public final short C()
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = read();
    arrayOfInt[1] = read();
    if ((arrayOfInt[0] | arrayOfInt[1]) < 0) {
      throw new EOFException();
    }
    int j;
    if (this.V)
    {
      j = arrayOfInt[1];
      j = (short)(arrayOfInt[0] + (j << 8));
    }
    for (int i = j;; i = j)
    {
      return i;
      j = arrayOfInt[0];
      j = (short)(arrayOfInt[1] + (j << 8));
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    super.readFully(paramArrayOfByte);
    if (this.V) {
      for (int i = 0; i < paramArrayOfByte.length / 2; i++)
      {
        int j = paramArrayOfByte[i];
        paramArrayOfByte[i] = paramArrayOfByte[(paramArrayOfByte.length - i - 1)];
        paramArrayOfByte[(paramArrayOfByte.length - i - 1)] = ((byte)j);
      }
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\utils_l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */