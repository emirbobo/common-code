import android.content.Context;
import com.arrownock.exception.ArrownockException;
import com.arrownock.social.AnSocialFile;
import com.arrownock.social.AnSocialMethod;
import com.arrownock.social.IAnSocialCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class ch
{
  public Context a;
  public bn a;
  public String a;
  
  public ch()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Bn = null;
    this.jdField_a_of_type_Bn = new bn();
  }
  
  public ch(String paramString, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Bn = null;
    this.jdField_a_of_type_Bn = new bn();
    this.jdField_a_of_type_Bn.a(paramString);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static JSONObject a(AnSocialMethod paramAnSocialMethod, Map<String, Object> paramMap, String paramString, IAnSocialCallback paramIAnSocialCallback)
    throws ArrownockException
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      a("Invalid path", -200002, paramIAnSocialCallback);
      paramAnSocialMethod = null;
    }
    label336:
    label619:
    for (;;)
    {
      return paramAnSocialMethod;
      if ((paramAnSocialMethod != AnSocialMethod.GET) && (paramAnSocialMethod != AnSocialMethod.POST))
      {
        a("Invalid methodType", -200006, paramIAnSocialCallback);
        paramAnSocialMethod = null;
      }
      else
      {
        paramAnSocialMethod = new JSONObject();
        paramMap = paramMap.entrySet().iterator();
        for (;;)
        {
          if (!paramMap.hasNext()) {
            break label619;
          }
          paramString = (Map.Entry)paramMap.next();
          Object localObject1;
          if (("photo".equals(paramString.getKey())) || ("file".equals(paramString.getKey())))
          {
            if (!(paramString.getValue() instanceof AnSocialFile))
            {
              a("Invalid AnSocialFile", -200005, paramIAnSocialCallback);
              paramAnSocialMethod = null;
              break;
            }
            localObject1 = (AnSocialFile)paramString.getValue();
            if ((localObject1 == null) || ((((AnSocialFile)localObject1).getData() == null) && (((AnSocialFile)localObject1).getInputStream() == null)))
            {
              a("Invalid AnSocialFile", -200005, paramIAnSocialCallback);
              paramAnSocialMethod = null;
              break;
            }
          }
          Object localObject2;
          try
          {
            if (!"custom_fields".equals(paramString.getKey())) {
              break label336;
            }
            if (!(paramString.getValue() instanceof Map))
            {
              a("Invalid custom_fields", -200005, paramIAnSocialCallback);
              paramAnSocialMethod = null;
              break;
            }
            localObject1 = (Map)paramString.getValue();
            paramString = new org/json/JSONObject;
            paramString.<init>();
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              paramString.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
            }
          }
          catch (JSONException paramAnSocialMethod)
          {
            a("Invalid params", -200005, paramIAnSocialCallback);
            paramAnSocialMethod = null;
          }
          paramAnSocialMethod.put("custom_fields", paramString);
          continue;
          if ("choices".equals(paramString.getKey()))
          {
            if (!(paramString.getValue() instanceof Map))
            {
              a("Invalid choices", -200005, paramIAnSocialCallback);
              paramAnSocialMethod = null;
              break;
            }
            localObject1 = (Map)paramString.getValue();
            paramString = new org/json/JSONObject;
            paramString.<init>();
            localObject1 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              paramString.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
            }
            paramAnSocialMethod.put("choices", paramString);
            continue;
          }
          if ("resolutions".equals(paramString.getKey()))
          {
            if (!(paramString.getValue() instanceof Map))
            {
              a("Invalid resolutions", -200005, paramIAnSocialCallback);
              paramAnSocialMethod = null;
              break;
            }
            localObject1 = (Map)paramString.getValue();
            paramString = new org/json/JSONObject;
            paramString.<init>();
            localObject2 = ((Map)localObject1).entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject1 = (Map.Entry)((Iterator)localObject2).next();
              paramString.put((String)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
            }
            paramAnSocialMethod.put("resolutions", paramString);
            continue;
          }
          paramAnSocialMethod.put((String)paramString.getKey(), paramString.getValue());
        }
      }
    }
  }
  
  public static void a(String paramString, int paramInt, IAnSocialCallback paramIAnSocialCallback)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("status", "fail");
      localJSONObject2.put("message", paramString);
      localJSONObject2.put("errorCode", paramInt);
      localJSONObject2.put("code", -1);
      localJSONObject1.put("meta", localJSONObject2);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        if (paramIAnSocialCallback != null) {
          new Thread(new ci(paramIAnSocialCallback, localJSONObject1)).run();
        }
      }
    }
    finally
    {
      if (paramIAnSocialCallback != null) {
        new Thread(new ci(paramIAnSocialCallback, localJSONObject1)).run();
      }
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Bn.a(paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */