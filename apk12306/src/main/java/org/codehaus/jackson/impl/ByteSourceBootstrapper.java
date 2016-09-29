package org.codehaus.jackson.impl;

import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.format.InputAccessor;
import org.codehaus.jackson.format.MatchStrength;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.MergedStream;
import org.codehaus.jackson.io.UTF32Reader;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.CharsToNameCanonicalizer;

public final class ByteSourceBootstrapper
{
  static final byte UTF8_BOM_1 = -17;
  static final byte UTF8_BOM_2 = -69;
  static final byte UTF8_BOM_3 = -65;
  protected boolean _bigEndian = true;
  private final boolean _bufferRecyclable;
  protected int _bytesPerChar = 0;
  final IOContext _context;
  final InputStream _in;
  final byte[] _inputBuffer;
  private int _inputEnd;
  protected int _inputProcessed;
  private int _inputPtr;
  
  public ByteSourceBootstrapper(IOContext paramIOContext, InputStream paramInputStream)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._inputBuffer = paramIOContext.allocReadIOBuffer();
    this._inputPtr = 0;
    this._inputEnd = 0;
    this._inputProcessed = 0;
    this._bufferRecyclable = true;
  }
  
  public ByteSourceBootstrapper(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this._context = paramIOContext;
    this._in = null;
    this._inputBuffer = paramArrayOfByte;
    this._inputPtr = paramInt1;
    this._inputEnd = (paramInt1 + paramInt2);
    this._inputProcessed = (-paramInt1);
    this._bufferRecyclable = false;
  }
  
  private boolean checkUTF16(int paramInt)
  {
    boolean bool = false;
    if ((0xFF00 & paramInt) == 0) {}
    for (this._bigEndian = true;; this._bigEndian = false)
    {
      this._bytesPerChar = 2;
      bool = true;
      do
      {
        return bool;
      } while ((paramInt & 0xFF) != 0);
    }
  }
  
  private boolean checkUTF32(int paramInt)
    throws IOException
  {
    boolean bool = false;
    if (paramInt >> 8 == 0) {
      this._bigEndian = true;
    }
    for (;;)
    {
      this._bytesPerChar = 4;
      bool = true;
      do
      {
        return bool;
        if ((0xFFFFFF & paramInt) == 0)
        {
          this._bigEndian = false;
          break;
        }
        if ((0xFF00FFFF & paramInt) == 0)
        {
          reportWeirdUCS4("3412");
          break;
        }
      } while ((0xFFFF00FF & paramInt) != 0);
      reportWeirdUCS4("2143");
    }
  }
  
  private boolean handleBOM(int paramInt)
    throws IOException
  {
    boolean bool = true;
    int i;
    switch (paramInt)
    {
    default: 
      i = paramInt >>> 16;
      if (i == 65279)
      {
        this._inputPtr += 2;
        this._bytesPerChar = 2;
        this._bigEndian = true;
      }
      break;
    }
    for (;;)
    {
      return bool;
      this._bigEndian = true;
      this._inputPtr += 4;
      this._bytesPerChar = 4;
      continue;
      this._inputPtr += 4;
      this._bytesPerChar = 4;
      this._bigEndian = false;
      continue;
      reportWeirdUCS4("2143");
      reportWeirdUCS4("3412");
      break;
      if (i == 65534)
      {
        this._inputPtr += 2;
        this._bytesPerChar = 2;
        this._bigEndian = false;
      }
      else if (paramInt >>> 8 == 15711167)
      {
        this._inputPtr += 3;
        this._bytesPerChar = 1;
        this._bigEndian = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static MatchStrength hasJSONFormat(InputAccessor paramInputAccessor)
    throws IOException
  {
    Object localObject;
    if (!paramInputAccessor.hasMoreBytes()) {
      localObject = MatchStrength.INCONCLUSIVE;
    }
    for (;;)
    {
      return (MatchStrength)localObject;
      int j = paramInputAccessor.nextByte();
      int i = j;
      if (j == -17)
      {
        if (!paramInputAccessor.hasMoreBytes())
        {
          localObject = MatchStrength.INCONCLUSIVE;
        }
        else if (paramInputAccessor.nextByte() != -69)
        {
          localObject = MatchStrength.NO_MATCH;
        }
        else if (!paramInputAccessor.hasMoreBytes())
        {
          localObject = MatchStrength.INCONCLUSIVE;
        }
        else if (paramInputAccessor.nextByte() != -65)
        {
          localObject = MatchStrength.NO_MATCH;
        }
        else if (!paramInputAccessor.hasMoreBytes())
        {
          localObject = MatchStrength.INCONCLUSIVE;
        }
        else
        {
          j = paramInputAccessor.nextByte();
          i = j;
        }
      }
      else
      {
        j = skipSpace(paramInputAccessor, i);
        if (j < 0)
        {
          localObject = MatchStrength.INCONCLUSIVE;
        }
        else if (j == 123)
        {
          j = skipSpace(paramInputAccessor);
          if (j < 0) {
            localObject = MatchStrength.INCONCLUSIVE;
          } else if ((j == 34) || (j == 125)) {
            localObject = MatchStrength.SOLID_MATCH;
          } else {
            localObject = MatchStrength.NO_MATCH;
          }
        }
        else if (j == 91)
        {
          j = skipSpace(paramInputAccessor);
          if (j < 0) {
            localObject = MatchStrength.INCONCLUSIVE;
          } else if ((j == 93) || (j == 91)) {
            localObject = MatchStrength.SOLID_MATCH;
          } else {
            localObject = MatchStrength.SOLID_MATCH;
          }
        }
        else
        {
          MatchStrength localMatchStrength = MatchStrength.WEAK_MATCH;
          localObject = localMatchStrength;
          if (j != 34) {
            if (j <= 57)
            {
              localObject = localMatchStrength;
              if (j >= 48) {}
            }
            else if (j == 45)
            {
              j = skipSpace(paramInputAccessor);
              if (j < 0)
              {
                localObject = MatchStrength.INCONCLUSIVE;
              }
              else if (j <= 57)
              {
                localObject = localMatchStrength;
                if (j >= 48) {}
              }
              else
              {
                localObject = MatchStrength.NO_MATCH;
              }
            }
            else if (j == 110)
            {
              localObject = tryMatch(paramInputAccessor, "ull", localMatchStrength);
            }
            else if (j == 116)
            {
              localObject = tryMatch(paramInputAccessor, "rue", localMatchStrength);
            }
            else if (j == 102)
            {
              localObject = tryMatch(paramInputAccessor, "alse", localMatchStrength);
            }
            else
            {
              localObject = MatchStrength.NO_MATCH;
            }
          }
        }
      }
    }
  }
  
  private void reportWeirdUCS4(String paramString)
    throws IOException
  {
    throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
  }
  
  private static final int skipSpace(InputAccessor paramInputAccessor)
    throws IOException
  {
    if (!paramInputAccessor.hasMoreBytes()) {}
    for (int i = -1;; i = skipSpace(paramInputAccessor, paramInputAccessor.nextByte())) {
      return i;
    }
  }
  
  private static final int skipSpace(InputAccessor paramInputAccessor, byte paramByte)
    throws IOException
  {
    for (;;)
    {
      paramByte &= 0xFF;
      if ((paramByte != 32) && (paramByte != 13) && (paramByte != 10) && (paramByte != 9)) {}
      for (;;)
      {
        return paramByte;
        if (paramInputAccessor.hasMoreBytes()) {
          break;
        }
        paramByte = -1;
      }
      paramByte = paramInputAccessor.nextByte();
    }
  }
  
  private static final MatchStrength tryMatch(InputAccessor paramInputAccessor, String paramString, MatchStrength paramMatchStrength)
    throws IOException
  {
    int i = 0;
    int j = paramString.length();
    for (;;)
    {
      MatchStrength localMatchStrength = paramMatchStrength;
      if (i < j) {
        if (paramInputAccessor.hasMoreBytes()) {
          break label34;
        }
      }
      for (localMatchStrength = MatchStrength.INCONCLUSIVE;; localMatchStrength = MatchStrength.NO_MATCH)
      {
        return localMatchStrength;
        label34:
        if (paramInputAccessor.nextByte() == paramString.charAt(i)) {
          break;
        }
      }
      i++;
    }
  }
  
  public JsonParser constructParser(int paramInt, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
    throws IOException, JsonParseException
  {
    JsonEncoding localJsonEncoding = detectEncoding();
    boolean bool1 = JsonParser.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt);
    boolean bool2 = JsonParser.Feature.INTERN_FIELD_NAMES.enabledIn(paramInt);
    if ((localJsonEncoding == JsonEncoding.UTF8) && (bool1)) {
      paramBytesToNameCanonicalizer = paramBytesToNameCanonicalizer.makeChild(bool1, bool2);
    }
    for (paramObjectCodec = new Utf8StreamParser(this._context, paramInt, this._in, paramObjectCodec, paramBytesToNameCanonicalizer, this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);; paramObjectCodec = new ReaderBasedParser(this._context, paramInt, constructReader(), paramObjectCodec, paramCharsToNameCanonicalizer.makeChild(bool1, bool2))) {
      return paramObjectCodec;
    }
  }
  
  public Reader constructReader()
    throws IOException
  {
    JsonEncoding localJsonEncoding = this._context.getEncoding();
    switch (localJsonEncoding)
    {
    default: 
      throw new RuntimeException("Internal error");
    case ???: 
    case ???: 
      localObject = new UTF32Reader(this._context, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, this._context.getEncoding().isBigEndian());
      return (Reader)localObject;
    }
    Object localObject = this._in;
    if (localObject == null) {
      localObject = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
    }
    for (;;)
    {
      localObject = new InputStreamReader((InputStream)localObject, localJsonEncoding.getJavaName());
      break;
      if (this._inputPtr < this._inputEnd) {
        localObject = new MergedStream(this._context, (InputStream)localObject, this._inputBuffer, this._inputPtr, this._inputEnd);
      }
    }
  }
  
  public JsonEncoding detectEncoding()
    throws IOException, JsonParseException
  {
    int j = 0;
    int k;
    int i;
    if (ensureLoaded(4))
    {
      k = this._inputBuffer[this._inputPtr] << 24 | (this._inputBuffer[(this._inputPtr + 1)] & 0xFF) << 16 | (this._inputBuffer[(this._inputPtr + 2)] & 0xFF) << 8 | this._inputBuffer[(this._inputPtr + 3)] & 0xFF;
      if (handleBOM(k)) {
        i = 1;
      }
    }
    JsonEncoding localJsonEncoding;
    while (i == 0)
    {
      localJsonEncoding = JsonEncoding.UTF8;
      this._context.setEncoding(localJsonEncoding);
      return localJsonEncoding;
      if (checkUTF32(k))
      {
        i = 1;
      }
      else
      {
        i = j;
        if (checkUTF16(k >>> 16))
        {
          i = 1;
          continue;
          i = j;
          if (ensureLoaded(2))
          {
            i = j;
            if (checkUTF16((this._inputBuffer[this._inputPtr] & 0xFF) << 8 | this._inputBuffer[(this._inputPtr + 1)] & 0xFF)) {
              i = 1;
            }
          }
        }
      }
    }
    if (this._bytesPerChar == 2)
    {
      if (this._bigEndian) {}
      for (localJsonEncoding = JsonEncoding.UTF16_BE;; localJsonEncoding = JsonEncoding.UTF16_LE) {
        break;
      }
    }
    if (this._bytesPerChar == 4)
    {
      if (this._bigEndian) {}
      for (localJsonEncoding = JsonEncoding.UTF32_BE;; localJsonEncoding = JsonEncoding.UTF32_LE) {
        break;
      }
    }
    throw new RuntimeException("Internal error");
  }
  
  protected boolean ensureLoaded(int paramInt)
    throws IOException
  {
    boolean bool2 = true;
    int i = this._inputEnd - this._inputPtr;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramInt) {
        if (this._in != null) {
          break label42;
        }
      }
      label42:
      for (int j = -1; j < 1; j = this._in.read(this._inputBuffer, this._inputEnd, this._inputBuffer.length - this._inputEnd))
      {
        bool1 = false;
        return bool1;
      }
      this._inputEnd += j;
      i += j;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\ByteSourceBootstrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */