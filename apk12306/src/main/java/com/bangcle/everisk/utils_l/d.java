package com.bangcle.everisk.utils_l;

import java.io.IOException;
import java.math.BigInteger;

public final class d
{
  private final byte[] Y = new byte[16];
  private final int Z;
  
  protected d(b paramb)
  {
    paramb.seek(0L);
    paramb.readFully(this.Y);
    byte[] arrayOfByte = this.Y;
    if ((arrayOfByte.length < 4) || (arrayOfByte[0] != Byte.MAX_VALUE) || (arrayOfByte[1] != 69) || (arrayOfByte[2] != 76) || (arrayOfByte[3] != 70)) {}
    for (int i = 0; i == 0; i = 1) {
      throw new IOException("Not an ELF file!");
    }
    if (this.Y[5] == 1) {
      bool = true;
    }
    paramb.d(bool);
    paramb.C();
    this.Z = paramb.C();
    paramb.A();
    switch (this.Y[4])
    {
    default: 
      throw new IOException("Unknown ELF class " + this.Y[4]);
    case 1: 
      arrayOfByte = new byte[4];
      paramb.a(arrayOfByte);
      new BigInteger(1, arrayOfByte).longValue();
      paramb.A();
      paramb.A();
    }
    for (;;)
    {
      paramb.A();
      paramb.C();
      paramb.C();
      paramb.C();
      paramb.C();
      paramb.C();
      paramb.C();
      return;
      arrayOfByte = new byte[8];
      paramb.a(arrayOfByte);
      new BigInteger(1, arrayOfByte).longValue();
      c.a(paramb);
      c.a(paramb);
    }
  }
  
  public final int F()
  {
    return this.Z & 0xFFFF;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\utils_l\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */