package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.Reader;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.util.TextBuffer;

public abstract class ReaderBasedNumericParser
  extends ReaderBasedParserBase
{
  public ReaderBasedNumericParser(IOContext paramIOContext, int paramInt, Reader paramReader)
  {
    super(paramIOContext, paramInt, paramReader);
  }
  
  private final char _verifyNoLeadingZeroes()
    throws IOException, JsonParseException
  {
    char c2;
    char c1;
    if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
    {
      c2 = '0';
      c1 = c2;
    }
    for (;;)
    {
      return c1;
      c2 = this._inputBuffer[this._inputPtr];
      if ((c2 < '0') || (c2 > '9'))
      {
        c2 = '0';
        c1 = c2;
      }
      else
      {
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
          reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr += 1;
        c1 = c2;
        if (c2 == '0')
        {
          char c3;
          do
          {
            if (this._inputPtr >= this._inputEnd)
            {
              c1 = c2;
              if (!loadMore()) {
                break;
              }
            }
            c3 = this._inputBuffer[this._inputPtr];
            if ((c3 < '0') || (c3 > '9'))
            {
              c2 = '0';
              c1 = c2;
              break;
            }
            this._inputPtr += 1;
            c2 = c3;
          } while (c3 == '0');
          c1 = c3;
        }
      }
    }
  }
  
  private final JsonToken parseNumberText2(boolean paramBoolean)
    throws IOException, JsonParseException
  {
    Object localObject2 = this._textBuffer.emptyAndGetCurrentSegment();
    int i = 0;
    if (paramBoolean)
    {
      localObject2[0] = ((char)45);
      i = 0 + 1;
    }
    int m = 0;
    Object localObject1;
    int j;
    int k;
    int n;
    label81:
    int i3;
    if (this._inputPtr < this._inputEnd)
    {
      localObject1 = this._inputBuffer;
      j = this._inputPtr;
      this._inputPtr = (j + 1);
      j = localObject1[j];
      k = j;
      if (j == 48) {
        k = _verifyNoLeadingZeroes();
      }
      n = 0;
      if ((k < 48) || (k > 57)) {
        break label897;
      }
      m++;
      localObject1 = localObject2;
      j = i;
      if (i >= localObject2.length)
      {
        localObject1 = this._textBuffer.finishCurrentSegment();
        j = 0;
      }
      i = j + 1;
      localObject1[j] = ((char)k);
      if ((this._inputPtr < this._inputEnd) || (loadMore())) {
        break label671;
      }
      k = 0;
      j = 1;
      i3 = m;
    }
    for (;;)
    {
      if (i3 == 0) {
        reportInvalidNumber("Missing integer part (next char " + _getCharDesc(k) + ")");
      }
      int i4 = 0;
      m = 0;
      label225:
      int i1;
      label250:
      int i2;
      if (k == 46)
      {
        n = i + 1;
        localObject1[i] = ((char)k);
        i = n;
        if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
        {
          n = 1;
          i1 = k;
          i2 = i1;
          j = n;
          i4 = m;
          localObject2 = localObject1;
          k = i;
          if (m == 0)
          {
            reportUnexpectedNumberChar(i1, "Decimal point not followed by a digit");
            k = i;
            localObject2 = localObject1;
            i4 = m;
            j = n;
            i2 = i1;
          }
        }
      }
      for (;;)
      {
        i1 = 0;
        n = 0;
        int i5;
        if (i2 != 101)
        {
          i = j;
          i5 = k;
          if (i2 != 69) {}
        }
        else
        {
          localObject1 = localObject2;
          m = k;
          if (k >= localObject2.length)
          {
            localObject1 = this._textBuffer.finishCurrentSegment();
            m = 0;
          }
          i = m + 1;
          localObject1[m] = ((char)i2);
          if (this._inputPtr >= this._inputEnd) {
            break label813;
          }
          localObject2 = this._inputBuffer;
          k = this._inputPtr;
          this._inputPtr = (k + 1);
          k = localObject2[k];
          label404:
          if ((k != 45) && (k != 43)) {
            break label876;
          }
          if (i < localObject1.length) {
            break label873;
          }
          localObject1 = this._textBuffer.finishCurrentSegment();
          i = 0;
          label436:
          localObject1[i] = ((char)k);
          if (this._inputPtr >= this._inputEnd) {
            break label824;
          }
          localObject2 = this._inputBuffer;
          k = this._inputPtr;
          this._inputPtr = (k + 1);
          k = localObject2[k];
          label481:
          i++;
          i1 = n;
        }
        for (;;)
        {
          i2 = j;
          n = i1;
          m = i;
          if (k <= 57)
          {
            i2 = j;
            n = i1;
            m = i;
            if (k >= 48)
            {
              n = i1 + 1;
              localObject2 = localObject1;
              m = i;
              if (i >= localObject1.length)
              {
                localObject2 = this._textBuffer.finishCurrentSegment();
                m = 0;
              }
              i = m + 1;
              localObject2[m] = ((char)k);
              if ((this._inputPtr < this._inputEnd) || (loadMore())) {
                break label835;
              }
              i2 = 1;
              m = i;
            }
          }
          i = i2;
          i1 = n;
          i5 = m;
          if (n == 0)
          {
            reportUnexpectedNumberChar(k, "Exponent indicator not followed by a digit");
            i5 = m;
            i1 = n;
            i = i2;
          }
          if (i == 0) {
            this._inputPtr -= 1;
          }
          this._textBuffer.setCurrentLength(i5);
          return reset(paramBoolean, i3, i4, i1);
          j = getNextChar("No digit following minus sign");
          break;
          label671:
          localObject2 = this._inputBuffer;
          j = this._inputPtr;
          this._inputPtr = (j + 1);
          k = localObject2[j];
          localObject2 = localObject1;
          break label81;
          localObject2 = this._inputBuffer;
          k = this._inputPtr;
          this._inputPtr = (k + 1);
          k = localObject2[k];
          i1 = k;
          n = j;
          if (k < 48) {
            break label250;
          }
          i1 = k;
          n = j;
          if (k > 57) {
            break label250;
          }
          n = m + 1;
          localObject2 = localObject1;
          m = i;
          if (i >= localObject1.length)
          {
            localObject2 = this._textBuffer.finishCurrentSegment();
            m = 0;
          }
          localObject2[m] = ((char)k);
          i = m + 1;
          m = n;
          localObject1 = localObject2;
          break label225;
          label813:
          k = getNextChar("expected a digit for number exponent");
          break label404;
          label824:
          k = getNextChar("expected a digit for number exponent");
          break label481;
          label835:
          localObject1 = this._inputBuffer;
          k = this._inputPtr;
          this._inputPtr = (k + 1);
          k = localObject1[k];
          i1 = n;
          localObject1 = localObject2;
          continue;
          label873:
          break label436;
          label876:
          i1 = n;
        }
        i2 = k;
        localObject2 = localObject1;
        k = i;
      }
      label897:
      j = n;
      i3 = m;
      localObject1 = localObject2;
    }
  }
  
  protected JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
    throws IOException, JsonParseException
  {
    double d = Double.NEGATIVE_INFINITY;
    int i = paramInt;
    Object localObject;
    if (paramInt == 73)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      localObject = this._inputBuffer;
      paramInt = this._inputPtr;
      this._inputPtr = (paramInt + 1);
      paramInt = localObject[paramInt];
      if (paramInt != 78) {
        break label171;
      }
      if (paramBoolean)
      {
        localObject = "-INF";
        i = paramInt;
        if (!_matchToken((String)localObject, 3)) {
          break label157;
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
          break label125;
        }
        if (!paramBoolean) {
          break label118;
        }
      }
      for (;;)
      {
        localObject = resetAsNaN((String)localObject, d);
        return (JsonToken)localObject;
        localObject = "+INF";
        break;
        label118:
        d = Double.POSITIVE_INFINITY;
      }
      label125:
      _reportError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      i = paramInt;
    }
    for (;;)
    {
      label157:
      reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
      localObject = null;
      break;
      label171:
      i = paramInt;
      if (paramInt == 110)
      {
        if (paramBoolean)
        {
          localObject = "-Infinity";
          label188:
          i = paramInt;
          if (!_matchToken((String)localObject, 3)) {
            continue;
          }
          if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            break label241;
          }
          if (!paramBoolean) {
            break label234;
          }
        }
        for (;;)
        {
          localObject = resetAsNaN((String)localObject, d);
          break;
          localObject = "+Infinity";
          break label188;
          label234:
          d = Double.POSITIVE_INFINITY;
        }
        label241:
        _reportError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        i = paramInt;
      }
    }
  }
  
  protected final JsonToken parseNumberText(int paramInt)
    throws IOException, JsonParseException
  {
    boolean bool;
    int i2;
    int i3;
    int i;
    if (paramInt == 45)
    {
      bool = true;
      j = this._inputPtr;
      i2 = j - 1;
      i3 = this._inputEnd;
      i = j;
      if (!bool) {
        break label118;
      }
      if (j < this._inputEnd) {
        break label75;
      }
    }
    label66:
    label75:
    label118:
    int k;
    label129:
    int i1;
    int m;
    int n;
    label248:
    label285:
    do
    {
      do
      {
        paramInt = i2;
        if (bool) {
          paramInt = i2 + 1;
        }
        this._inputPtr = paramInt;
        for (localObject = parseNumberText2(bool);; localObject = _handleInvalidNumberStart(paramInt, true))
        {
          return (JsonToken)localObject;
          bool = false;
          break;
          localObject = this._inputBuffer;
          i = j + 1;
          paramInt = localObject[j];
          if ((paramInt <= 57) && (paramInt >= 48)) {
            break label118;
          }
          this._inputPtr = i;
        }
      } while (paramInt == 48);
      k = 1;
      paramInt = i;
      if (paramInt < this._inputEnd)
      {
        localObject = this._inputBuffer;
        i = paramInt + 1;
        i1 = localObject[paramInt];
        if ((i1 < 48) || (i1 > 57))
        {
          m = 0;
          n = 0;
          paramInt = i;
          j = i1;
          if (i1 != 46) {
            break label248;
          }
          j = i;
          i = n;
        }
      }
      for (;;)
      {
        if (j >= i3)
        {
          break;
          k++;
          paramInt = i;
          break label129;
          break;
        }
        localObject = this._inputBuffer;
        paramInt = j + 1;
        j = localObject[j];
        if ((j < 48) || (j > 57))
        {
          if (i == 0) {
            reportUnexpectedNumberChar(j, "Decimal point not followed by a digit");
          }
          m = i;
          n = 0;
          i = 0;
          if (j != 101)
          {
            i1 = paramInt;
            if (j != 69) {
              break label397;
            }
          }
          if (paramInt < i3) {
            break label285;
          }
          break;
        }
        i++;
        j = paramInt;
      }
      localObject = this._inputBuffer;
      n = paramInt + 1;
      j = localObject[paramInt];
      if ((j != 45) && (j != 43)) {
        break label441;
      }
    } while (n >= i3);
    Object localObject = this._inputBuffer;
    paramInt = n + 1;
    int j = localObject[n];
    for (;;)
    {
      if ((j <= 57) && (j >= 48))
      {
        i++;
        if (paramInt >= i3) {
          break;
        }
        j = this._inputBuffer[paramInt];
        paramInt++;
        continue;
      }
      n = i;
      i1 = paramInt;
      if (i == 0)
      {
        reportUnexpectedNumberChar(j, "Exponent indicator not followed by a digit");
        i1 = paramInt;
        n = i;
      }
      label397:
      paramInt = i1 - 1;
      this._inputPtr = paramInt;
      this._textBuffer.resetWithShared(this._inputBuffer, i2, paramInt - i2);
      localObject = reset(bool, k, m, n);
      break label66;
      label441:
      paramInt = n;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\ReaderBasedNumericParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */