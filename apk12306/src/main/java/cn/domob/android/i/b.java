package cn.domob.android.i;

import java.io.UnsupportedEncodingException;

public class b
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 4;
  public static final int e = 8;
  public static final int f = 16;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(b(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localb.e)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localb.f)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localb.g) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localb.a = new byte[i];
      localb.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((g) || (localb.b == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localb.a;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
    
    public abstract int a(int paramInt);
    
    public abstract boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  static class b
    extends b.a
  {
    public static final int c = 19;
    private static final byte[] i;
    private static final byte[] j;
    int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final byte[] k;
    private int l;
    private final byte[] m;
    
    static
    {
      if (!b.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        h = bool;
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        j = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.e = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.f = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.g = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = i;
        label63:
        this.m = paramArrayOfByte;
        this.k = new byte[2];
        this.d = 0;
        if (!this.f) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.l = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = j;
        break label63;
      }
    }
    
    public int a(int paramInt)
    {
      return paramInt * 8 / 5 + 10;
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte1 = this.m;
      byte[] arrayOfByte2 = this.a;
      int n = 0;
      int i3 = this.l;
      int i5 = paramInt2 + paramInt1;
      int i2 = -1;
      label62:
      int i1;
      switch (this.d)
      {
      default: 
        paramInt2 = paramInt1;
        paramInt1 = i3;
        i1 = paramInt2;
        if (i2 != -1)
        {
          arrayOfByte2[0] = ((byte)arrayOfByte1[(i2 >> 18 & 0x3F)]);
          arrayOfByte2[1] = ((byte)arrayOfByte1[(i2 >> 12 & 0x3F)]);
          arrayOfByte2[2] = ((byte)arrayOfByte1[(i2 >> 6 & 0x3F)]);
          n = 4;
          arrayOfByte2[3] = ((byte)arrayOfByte1[(i2 & 0x3F)]);
          i2 = i3 - 1;
          paramInt1 = i2;
          i1 = paramInt2;
          if (i2 == 0)
          {
            if (!this.g) {
              break label1244;
            }
            paramInt1 = 5;
            arrayOfByte2[4] = ((byte)13);
          }
        }
        break;
      }
      for (;;)
      {
        arrayOfByte2[paramInt1] = ((byte)10);
        i1 = 19;
        paramInt1++;
        for (;;)
        {
          label185:
          if (paramInt2 + 3 <= i5)
          {
            n = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
            arrayOfByte2[paramInt1] = ((byte)arrayOfByte1[(n >> 18 & 0x3F)]);
            arrayOfByte2[(paramInt1 + 1)] = ((byte)arrayOfByte1[(n >> 12 & 0x3F)]);
            arrayOfByte2[(paramInt1 + 2)] = ((byte)arrayOfByte1[(n >> 6 & 0x3F)]);
            arrayOfByte2[(paramInt1 + 3)] = ((byte)arrayOfByte1[(n & 0x3F)]);
            paramInt2 += 3;
            i2 = paramInt1 + 4;
            i3 = i1 - 1;
            paramInt1 = i3;
            n = i2;
            i1 = paramInt2;
            if (i3 != 0) {
              break label1228;
            }
            if (!this.g) {
              break label1222;
            }
            paramInt1 = i2 + 1;
            arrayOfByte2[i2] = ((byte)13);
          }
          for (;;)
          {
            arrayOfByte2[paramInt1] = ((byte)10);
            i1 = 19;
            paramInt1++;
            break label185;
            paramInt2 = paramInt1;
            break label62;
            if (paramInt1 + 2 > i5) {
              break;
            }
            i1 = this.k[0];
            paramInt2 = paramInt1 + 1;
            i2 = (i1 & 0xFF) << 16 | (paramArrayOfByte[paramInt1] & 0xFF) << 8 | paramArrayOfByte[paramInt2] & 0xFF;
            this.d = 0;
            paramInt2++;
            break label62;
            if (paramInt1 + 1 > i5) {
              break;
            }
            i2 = this.k[0];
            i1 = this.k[1];
            paramInt2 = paramInt1 + 1;
            i2 = (i2 & 0xFF) << 16 | (i1 & 0xFF) << 8 | paramArrayOfByte[paramInt1] & 0xFF;
            this.d = 0;
            break label62;
            label752:
            int i4;
            if (paramBoolean)
            {
              if (paramInt2 - this.d == i5 - 1)
              {
                if (this.d > 0)
                {
                  paramArrayOfByte = this.k;
                  n = 1;
                  i2 = paramArrayOfByte[0];
                }
                for (;;)
                {
                  i2 = (i2 & 0xFF) << 4;
                  this.d -= n;
                  i3 = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = ((byte)arrayOfByte1[(i2 >> 6 & 0x3F)]);
                  n = i3 + 1;
                  arrayOfByte2[i3] = ((byte)arrayOfByte1[(i2 & 0x3F)]);
                  paramInt1 = n;
                  if (this.e)
                  {
                    i2 = n + 1;
                    arrayOfByte2[n] = ((byte)61);
                    paramInt1 = i2 + 1;
                    arrayOfByte2[i2] = ((byte)61);
                  }
                  n = paramInt1;
                  if (this.f)
                  {
                    n = paramInt1;
                    if (this.g)
                    {
                      arrayOfByte2[paramInt1] = ((byte)13);
                      n = paramInt1 + 1;
                    }
                    arrayOfByte2[n] = ((byte)10);
                    n++;
                  }
                  i2 = paramInt2;
                  if ((h) || (this.d == 0)) {
                    break;
                  }
                  throw new AssertionError();
                  i2 = paramArrayOfByte[paramInt2];
                  paramInt2++;
                  n = 0;
                }
              }
              if (paramInt2 - this.d == i5 - 2) {
                if (this.d > 1)
                {
                  byte[] arrayOfByte3 = this.k;
                  i3 = 1;
                  i2 = arrayOfByte3[0];
                  n = paramInt2;
                  paramInt2 = i3;
                  if (this.d <= 0) {
                    break label959;
                  }
                  i3 = this.k[paramInt2];
                  i4 = paramInt2 + 1;
                  paramInt2 = n;
                  n = i4;
                  label779:
                  i2 = (i3 & 0xFF) << 2 | (i2 & 0xFF) << 10;
                  this.d -= n;
                  i3 = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = ((byte)arrayOfByte1[(i2 >> 12 & 0x3F)]);
                  n = i3 + 1;
                  arrayOfByte2[i3] = ((byte)arrayOfByte1[(i2 >> 6 & 0x3F)]);
                  paramInt1 = n + 1;
                  arrayOfByte2[n] = ((byte)arrayOfByte1[(i2 & 0x3F)]);
                  if (!this.e) {
                    break label1219;
                  }
                  n = paramInt1 + 1;
                  arrayOfByte2[paramInt1] = ((byte)61);
                  paramInt1 = n;
                }
              }
            }
            label959:
            label1139:
            label1219:
            for (;;)
            {
              n = paramInt1;
              if (this.f)
              {
                n = paramInt1;
                if (this.g)
                {
                  arrayOfByte2[paramInt1] = ((byte)13);
                  n = paramInt1 + 1;
                }
                arrayOfByte2[n] = ((byte)10);
                n++;
              }
              i2 = paramInt2;
              break;
              i2 = paramArrayOfByte[paramInt2];
              n = paramInt2 + 1;
              paramInt2 = 0;
              break label752;
              i3 = paramArrayOfByte[n];
              i4 = n + 1;
              n = paramInt2;
              paramInt2 = i4;
              break label779;
              i2 = paramInt2;
              n = paramInt1;
              if (!this.f) {
                break;
              }
              i2 = paramInt2;
              n = paramInt1;
              if (paramInt1 <= 0) {
                break;
              }
              i2 = paramInt2;
              n = paramInt1;
              if (i1 == 19) {
                break;
              }
              if (this.g)
              {
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = ((byte)13);
                paramInt1 = n;
              }
              for (;;)
              {
                n = paramInt1 + 1;
                arrayOfByte2[paramInt1] = ((byte)10);
                i2 = paramInt2;
                break;
                i3 = n;
                if (!h)
                {
                  i3 = n;
                  if (i2 != i5)
                  {
                    throw new AssertionError();
                    if (paramInt2 != i5 - 1) {
                      break label1139;
                    }
                    arrayOfByte1 = this.k;
                    n = this.d;
                    this.d = (n + 1);
                    arrayOfByte1[n] = ((byte)paramArrayOfByte[paramInt2]);
                    i3 = paramInt1;
                  }
                }
                for (;;)
                {
                  this.b = i3;
                  this.l = i1;
                  return true;
                  i3 = paramInt1;
                  if (paramInt2 == i5 - 2)
                  {
                    arrayOfByte1 = this.k;
                    n = this.d;
                    this.d = (n + 1);
                    arrayOfByte1[n] = ((byte)paramArrayOfByte[paramInt2]);
                    arrayOfByte1 = this.k;
                    n = this.d;
                    this.d = (n + 1);
                    arrayOfByte1[n] = ((byte)paramArrayOfByte[(paramInt2 + 1)]);
                    i3 = paramInt1;
                  }
                }
              }
            }
            label1222:
            paramInt1 = i2;
          }
          label1228:
          i2 = paramInt1;
          paramInt1 = n;
          paramInt2 = i1;
          i1 = i2;
        }
        label1244:
        paramInt1 = 4;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */