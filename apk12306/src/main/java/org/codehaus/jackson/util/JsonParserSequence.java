package org.codehaus.jackson.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class JsonParserSequence
  extends JsonParserDelegate
{
  protected int _nextParser;
  protected final JsonParser[] _parsers;
  
  protected JsonParserSequence(JsonParser[] paramArrayOfJsonParser)
  {
    super(paramArrayOfJsonParser[0]);
    this._parsers = paramArrayOfJsonParser;
    this._nextParser = 1;
  }
  
  public static JsonParserSequence createFlattened(JsonParser paramJsonParser1, JsonParser paramJsonParser2)
  {
    if ((!(paramJsonParser1 instanceof JsonParserSequence)) && (!(paramJsonParser2 instanceof JsonParserSequence)))
    {
      paramJsonParser1 = new JsonParserSequence(new JsonParser[] { paramJsonParser1, paramJsonParser2 });
      return paramJsonParser1;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramJsonParser1 instanceof JsonParserSequence))
    {
      ((JsonParserSequence)paramJsonParser1).addFlattenedActiveParsers(localArrayList);
      label59:
      if (!(paramJsonParser2 instanceof JsonParserSequence)) {
        break label108;
      }
      ((JsonParserSequence)paramJsonParser2).addFlattenedActiveParsers(localArrayList);
    }
    for (;;)
    {
      paramJsonParser1 = new JsonParserSequence((JsonParser[])localArrayList.toArray(new JsonParser[localArrayList.size()]));
      break;
      localArrayList.add(paramJsonParser1);
      break label59;
      label108:
      localArrayList.add(paramJsonParser2);
    }
  }
  
  protected void addFlattenedActiveParsers(List<JsonParser> paramList)
  {
    int i = this._nextParser - 1;
    int j = this._parsers.length;
    if (i < j)
    {
      JsonParser localJsonParser = this._parsers[i];
      if ((localJsonParser instanceof JsonParserSequence)) {
        ((JsonParserSequence)localJsonParser).addFlattenedActiveParsers(paramList);
      }
      for (;;)
      {
        i++;
        break;
        paramList.add(localJsonParser);
      }
    }
  }
  
  public void close()
    throws IOException
  {
    do
    {
      this.delegate.close();
    } while (switchToNext());
  }
  
  public int containedParsersCount()
  {
    return this._parsers.length;
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = this.delegate.nextToken();
    if (localJsonToken != null) {}
    for (;;)
    {
      return localJsonToken;
      for (;;)
      {
        if (switchToNext())
        {
          localJsonToken = this.delegate.nextToken();
          if (localJsonToken != null) {
            break;
          }
        }
      }
      localJsonToken = null;
    }
  }
  
  protected boolean switchToNext()
  {
    if (this._nextParser >= this._parsers.length) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      JsonParser[] arrayOfJsonParser = this._parsers;
      int i = this._nextParser;
      this._nextParser = (i + 1);
      this.delegate = arrayOfJsonParser[i];
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\util\JsonParserSequence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */