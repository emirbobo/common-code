import org.json.JSONException;
import org.json.JSONObject;

final class cc
  extends ey
{
  cc(cb paramcb) {}
  
  public final void a(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("status", "fail");
      localJSONObject2.put("message", paramString);
      localJSONObject1.put("meta", localJSONObject2);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        if (this.a.a != null) {
          new Thread(new cf(this, localJSONObject1)).run();
        }
      }
    }
    finally
    {
      if (this.a.a != null) {
        new Thread(new cf(this, localJSONObject1)).run();
      }
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    if (this.a.a != null) {
      new Thread(new cd(this, paramJSONObject)).run();
    }
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    if (this.a.a != null) {
      new Thread(new ce(this, paramJSONObject)).run();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */