package org.apache.commons.codec.binary;

public class Base32
  extends BaseNCodec
{
  private static final int BITS_PER_ENCODED_BYTE = 5;
  private static final int BYTES_PER_ENCODED_BLOCK = 8;
  private static final int BYTES_PER_UNENCODED_BLOCK = 5;
  private static final byte[] CHUNK_SEPARATOR = { 13, 10 };
  private static final byte[] DECODE_TABLE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
  private static final byte[] ENCODE_TABLE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55 };
  private static final byte[] HEX_DECODE_TABLE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 };
  private static final byte[] HEX_ENCODE_TABLE = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86 };
  private static final int MASK_5BITS = 31;
  private long bitWorkArea;
  private final int decodeSize;
  private final byte[] decodeTable;
  private final int encodeSize;
  private final byte[] encodeTable;
  private final byte[] lineSeparator;
  
  public Base32()
  {
    this(false);
  }
  
  public Base32(int paramInt)
  {
    this(paramInt, CHUNK_SEPARATOR);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public Base32(boolean paramBoolean)
  {
    this(0, null, paramBoolean);
  }
  
  void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {}
    label906:
    for (;;)
    {
      return;
      if (paramInt2 < 0) {
        this.eof = true;
      }
      int i = 0;
      int j;
      if (i < paramInt2)
      {
        j = paramArrayOfByte[paramInt1];
        if (j == 61) {
          this.eof = true;
        }
      }
      for (;;)
      {
        if ((!this.eof) || (this.modulus < 2)) {
          break label906;
        }
        ensureBufferSize(this.decodeSize);
        switch (this.modulus)
        {
        default: 
          break;
        case 2: 
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 2 & 0xFF));
          break;
          ensureBufferSize(this.decodeSize);
          if ((j >= 0) && (j < this.decodeTable.length))
          {
            j = this.decodeTable[j];
            if (j >= 0)
            {
              this.modulus = ((this.modulus + 1) % 8);
              this.bitWorkArea = ((this.bitWorkArea << 5) + j);
              if (this.modulus == 0)
              {
                byte[] arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(int)(this.bitWorkArea >> 32 & 0xFF));
                arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(int)(this.bitWorkArea >> 24 & 0xFF));
                arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(int)(this.bitWorkArea >> 16 & 0xFF));
                arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(int)(this.bitWorkArea >> 8 & 0xFF));
                arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(int)(this.bitWorkArea & 0xFF));
              }
            }
          }
          i++;
          paramInt1++;
          break;
        case 3: 
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 7 & 0xFF));
          break;
        case 4: 
          this.bitWorkArea >>= 4;
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 8 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea & 0xFF));
          break;
        case 5: 
          this.bitWorkArea >>= 1;
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 16 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 8 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea & 0xFF));
          break;
        case 6: 
          this.bitWorkArea >>= 6;
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 16 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 8 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea & 0xFF));
          break;
        case 7: 
          this.bitWorkArea >>= 3;
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 24 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 16 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea >> 8 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(int)(this.bitWorkArea & 0xFF));
          break;
        }
      }
    }
  }
  
  void encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {}
    for (;;)
    {
      return;
      if (paramInt2 < 0)
      {
        this.eof = true;
        if ((this.modulus != 0) || (this.lineLength != 0))
        {
          ensureBufferSize(this.encodeSize);
          paramInt1 = this.pos;
          switch (this.modulus)
          {
          }
          for (;;)
          {
            this.currentLinePos += this.pos - paramInt1;
            if ((this.lineLength <= 0) || (this.currentLinePos <= 0)) {
              break;
            }
            System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
            this.pos += this.lineSeparator.length;
            break;
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 3) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea << 2) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            continue;
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 11) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 6) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 1) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea << 4) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            continue;
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 19) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 14) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 9) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 4) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea << 1) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
            continue;
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 27) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 22) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 17) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 12) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 7) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 2) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[((int)(this.bitWorkArea << 3) & 0x1F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)61);
          }
        }
      }
      else
      {
        int i = 0;
        while (i < paramInt2)
        {
          ensureBufferSize(this.encodeSize);
          this.modulus = ((this.modulus + 1) % 5);
          int k = paramArrayOfByte[paramInt1];
          int j = k;
          if (k < 0) {
            j = k + 256;
          }
          this.bitWorkArea = ((this.bitWorkArea << 8) + j);
          if (this.modulus == 0)
          {
            byte[] arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 35) & 0x1F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 30) & 0x1F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 25) & 0x1F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 20) & 0x1F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 15) & 0x1F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 10) & 0x1F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)(this.bitWorkArea >> 5) & 0x1F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[((int)this.bitWorkArea & 0x1F)]);
            this.currentLinePos += 8;
            if ((this.lineLength > 0) && (this.lineLength <= this.currentLinePos))
            {
              System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
              this.pos += this.lineSeparator.length;
              this.currentLinePos = 0;
            }
          }
          i++;
          paramInt1++;
        }
      }
    }
  }
  
  public boolean isInAlphabet(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte < this.decodeTable.length) && (this.decodeTable[paramByte] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\binary\Base32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */