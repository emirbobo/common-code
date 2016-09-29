import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMMessageSentCallbackData;
import com.arrownock.im.callback.IAnIMCallback;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ap
  implements Runnable
{
  ap(f paramf, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(this.jdField_a_of_type_JavaLangString);
        localObject1 = new java/util/HashSet;
        ((HashSet)localObject1).<init>();
        Object localObject3 = localJSONObject.optJSONArray("recipients");
        if (localObject3 != null)
        {
          localObject2 = new java/util/HashSet;
          ((HashSet)localObject2).<init>();
          int i = 0;
          localObject1 = localObject2;
          if (i < ((JSONArray)localObject3).length())
          {
            ((Set)localObject2).add(((JSONArray)localObject3).getString(i));
            i++;
            continue;
          }
        }
        ((Set)localObject1).add(f.c(this.jdField_a_of_type_F));
        localObject2 = this.jdField_a_of_type_F.a((Set)localObject1);
        if (localObject2 == null) {
          continue;
        }
        if (!"".equals(this.jdField_a_of_type_F.a(f.a(this.jdField_a_of_type_F), (String)localObject2))) {
          continue;
        }
        localObject3 = this.jdField_a_of_type_F;
        localObject1 = f.a((Set)localObject1, ",");
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject;
        Object localObject1;
        Object localObject2;
        AnIMMessageSentCallbackData localAnIMMessageSentCallbackData = new AnIMMessageSentCallbackData(true, new ArrownockException("Failed to send message.", localJSONException, 3104), this.c, -1L);
        f.a(this.jdField_a_of_type_F).messageSent(localAnIMMessageSentCallbackData);
        continue;
        localJSONObject.remove("recipients");
        localJSONObject.put("session_key", localArrownockException1);
        this.jdField_a_of_type_F.a(this.c, this.d, localJSONObject.toString());
        continue;
        localAnIMMessageSentCallbackData = new com/arrownock/im/callback/AnIMMessageSentCallbackData;
        ArrownockException localArrownockException2 = new com/arrownock/exception/ArrownockException;
        localArrownockException2.<init>("Failed to send message, error when calculating session info.", 3104);
        localAnIMMessageSentCallbackData.<init>(true, localArrownockException2, this.c, -1L);
        f.a(this.jdField_a_of_type_F).messageSent(localAnIMMessageSentCallbackData);
        continue;
      }
      try
      {
        f.a(this.jdField_a_of_type_F, this.b, (String)localObject2, (String)localObject1);
        this.jdField_a_of_type_F.b(f.a(this.jdField_a_of_type_F), (String)localObject2, (String)localObject1);
        localJSONObject.remove("recipients");
        localJSONObject.put("session_key", localObject2);
        this.jdField_a_of_type_F.a(this.c, this.d, localJSONObject.toString());
        return;
      }
      catch (ArrownockException localArrownockException1)
      {
        localObject1 = new com/arrownock/im/callback/AnIMMessageSentCallbackData;
        ((AnIMMessageSentCallbackData)localObject1).<init>(true, localArrownockException1, this.c, -1L);
        f.a(this.jdField_a_of_type_F).messageSent((AnIMMessageSentCallbackData)localObject1);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */