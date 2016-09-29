import android.os.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ey
  extends ev
{
  private static Object a(String paramString)
    throws JSONException
  {
    Object localObject = null;
    String str = paramString.trim();
    if (!str.startsWith("{"))
    {
      paramString = (String)localObject;
      if (!str.startsWith("[")) {}
    }
    else
    {
      paramString = new JSONTokener(str).nextValue();
    }
    if (paramString == null) {
      paramString = str;
    }
    for (;;)
    {
      return paramString;
    }
  }
  
  protected final void a(int paramInt, String paramString)
  {
    if (paramInt != 204) {}
    for (;;)
    {
      try
      {
        b(a(100, new Object[] { Integer.valueOf(paramInt), a(paramString) }));
        return;
      }
      catch (JSONException localJSONException)
      {
        a(localJSONException, paramString);
        continue;
      }
      b(a(100, new Object[] { Integer.valueOf(paramInt), new JSONObject() }));
    }
  }
  
  protected final void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.a(paramMessage);
    }
    for (;;)
    {
      return;
      paramMessage = (Object[])paramMessage.obj;
      ((Integer)paramMessage[0]).intValue();
      paramMessage = paramMessage[1];
      if ((paramMessage instanceof JSONObject))
      {
        b((JSONObject)paramMessage);
      }
      else if (!(paramMessage instanceof JSONArray))
      {
        new JSONException("Unexpected type " + paramMessage.getClass().getName());
        a(null);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  protected final void b(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        Object localObject = a(paramString);
        if ((localObject instanceof JSONObject))
        {
          a((JSONObject)localObject);
          return;
        }
        if (!(localObject instanceof JSONArray))
        {
          a(paramString);
          continue;
        }
        continue;
      }
      catch (JSONException localJSONException)
      {
        a(paramString);
        continue;
      }
      a("");
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */