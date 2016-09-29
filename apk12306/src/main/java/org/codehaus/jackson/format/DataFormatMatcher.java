package org.codehaus.jackson.format;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.io.MergedStream;

public class DataFormatMatcher
{
  protected final byte[] _bufferedData;
  protected final int _bufferedLength;
  protected final JsonFactory _match;
  protected final MatchStrength _matchStrength;
  protected final InputStream _originalStream;
  
  protected DataFormatMatcher(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt, JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
  {
    this._originalStream = paramInputStream;
    this._bufferedData = paramArrayOfByte;
    this._bufferedLength = paramInt;
    this._match = paramJsonFactory;
    this._matchStrength = paramMatchStrength;
  }
  
  public JsonParser createParserWithMatch()
    throws IOException
  {
    JsonParser localJsonParser;
    if (this._match == null) {
      localJsonParser = null;
    }
    for (;;)
    {
      return localJsonParser;
      if (this._originalStream == null) {
        localJsonParser = this._match.createJsonParser(this._bufferedData, 0, this._bufferedLength);
      } else {
        localJsonParser = this._match.createJsonParser(getDataStream());
      }
    }
  }
  
  public InputStream getDataStream()
  {
    if (this._originalStream == null) {}
    for (Object localObject = new ByteArrayInputStream(this._bufferedData, 0, this._bufferedLength);; localObject = new MergedStream(null, this._originalStream, this._bufferedData, 0, this._bufferedLength)) {
      return (InputStream)localObject;
    }
  }
  
  public JsonFactory getMatch()
  {
    return this._match;
  }
  
  public MatchStrength getMatchStrength()
  {
    if (this._matchStrength == null) {}
    for (MatchStrength localMatchStrength = MatchStrength.INCONCLUSIVE;; localMatchStrength = this._matchStrength) {
      return localMatchStrength;
    }
  }
  
  public String getMatchedFormatName()
  {
    return this._match.getFormatName();
  }
  
  public boolean hasMatch()
  {
    if (this._match != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\format\DataFormatMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */