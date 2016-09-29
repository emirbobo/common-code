import com.arrownock.exception.ArrownockException;
import com.arrownock.social.IAnSocialCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bn
{
  private static final bm jdField_a_of_type_Bm = new bm();
  private eq jdField_a_of_type_Eq = null;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = true;
  private String b = null;
  
  private ez a(JSONObject paramJSONObject)
    throws ArrownockException
  {
    if (paramJSONObject == null) {}
    Object localObject1;
    for (paramJSONObject = new ez();; paramJSONObject = new ez((Map)localObject1))
    {
      return paramJSONObject;
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        try
        {
          Object localObject2 = paramJSONObject.get((String)localObject1);
          if (localObject2 != null) {
            localHashMap.put(localObject1, localObject2);
          }
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          throw new ArrownockException("Invalid JSON format of " + (String)localObject1, paramJSONObject, -200010);
        }
      }
      localObject1 = new HashMap();
      localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        paramJSONObject = (String)localIterator.next();
        if (((localHashMap.get(paramJSONObject) instanceof JSONArray)) || ((localHashMap.get(paramJSONObject) instanceof JSONObject))) {
          try
          {
            a("", paramJSONObject, localHashMap.get(paramJSONObject), (Map)localObject1);
          }
          catch (Exception localException)
          {
            throw new ArrownockException("Invalid JSON format of " + paramJSONObject, localException, -200010);
          }
        } else {
          ((Map)localObject1).put(paramJSONObject, localException.get(paramJSONObject).toString());
        }
      }
    }
  }
  
  private String a()
  {
    if (this.b == null) {}
    for (String str = "10.1.215.152:3002";; str = this.b) {
      return str;
    }
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (paramString = "https://" + a() + "/v2/";; paramString = "http://" + a() + "/v2/") {
      try
      {
        KeyStore localKeyStore = cj.a("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUVWRENDQXp5Z0F3SUJBZ0lCQVRBTkJna3Foa2lHOXcwQkFRVUZBREJpTVFzd0NRWURWUVFHRXdKRFRqRVEKTUE0R0ExVUVDQXdIUW1WcGFtbHVaekVRTUE0R0ExVUVCd3dIUW1WcGFtbHVaekVTTUJBR0ExVUVDd3dKUVhKeQpiM2R1YjJOck1Sc3dHUVlEVlFRRERCSkJjbkp2ZDI1dlkyc2dRMjh1TEV4MFpDNHdIaGNOTVRZd05qQTFNVFUxCk5qTXdXaGNOTXpZd05UTXhNVFUxTmpNd1dqQmlNUXN3Q1FZRFZRUUdFd0pEVGpFUU1BNEdBMVVFQ0F3SFFtVnAKYW1sdVp6RVFNQTRHQTFVRUJ3d0hRbVZwYW1sdVp6RVNNQkFHQTFVRUN3d0pRWEp5YjNkdWIyTnJNUnN3R1FZRApWUVFEREJKQmNuSnZkMjV2WTJzZ1EyOHVMRXgwWkM0d2dnRWlNQTBHQ1NxR1NJYjNEUUVCQVFVQUE0SUJEd0F3CmdnRUtBb0lCQVFEVUhxemtra3VaeElQbFI4ZDdnZU4wQzlJQkpLZkJWY0ZNM1FsVzhCbC9sZW9BZHMreDBpbXUKb3VCY2p6czN4aWFUR1Z1dklKODRvbUxNbHMyeUlGNWt5NE5RM0R1citIU280eE1pMVNBRXpFcXJhZ2hXeGRFSQovZlVtUnFrWHFLUUhtQmVUVUdqaXZDVExEOUp4a0trR2lFVWFSNmhGdjJseWZuM3U4emFYeGRFOTRWMkg2VkhPCmg5Y1N3d2xIZHhjcXZ5Z2dTUVE1cERkS2UrNEcyckZZSWlqeVJ1elNrWkhjNndDZ1NwVVRpMUE3ckZGZkVPdUsKU1ZDZ3ZnSmtkbFZzUzlOWVp4WGx1RmJNd3Jtd3pqdUM0WEliamlQZExmd21ya25PQ2Y3VE9lYkNDbmo3WHVoZApiNnIxdWdqUC80Wmk2bTM2anEyeVFKZEVRcWVmMXpXZEFnTUJBQUdqZ2dFVE1JSUJEekFKQmdOVkhSTUVBakFBCk1Bc0dBMVVkRHdRRUF3SUY0REFSQmdsZ2hrZ0JodmhDQVFFRUJBTUNCa0F3SFFZRFZSME9CQllFRkVmTnAyZGIKS2JEbG5NTk5uWlZlckJHU09pVUNNSUdVQmdOVkhTTUVnWXd3Z1ltQUZOQ0JPcEw4TlcvYkhYc2tUc1FVdit0YworR3dYb1dha1pEQmlNUXN3Q1FZRFZRUUdFd0pEVGpFUU1BNEdBMVVFQ0F3SFFtVnBhbWx1WnpFUU1BNEdBMVVFCkJ3d0hRbVZwYW1sdVp6RVNNQkFHQTFVRUN3d0pRWEp5YjNkdWIyTnJNUnN3R1FZRFZRUUREQkpCY25KdmQyNXYKWTJzZ1EyOHVMRXgwWkM2Q0NRRFQzVTJldUp4dENqQXNCZ05WSFJFRUpUQWpnZ29xTGpFeU16QTJMbU51Z2c4cQpMbUZ5Y205M2JtOWpheTVqYjIySEJBb0M2MU13RFFZSktvWklodmNOQVFFRkJRQURnZ0VCQUVPaWFRekFleDZXCnUzVkIzTkw5Q2JpR2VqZVlxNStVVXpiMzFMaGlMSDdyeXU1M0F4dmtSS1VQRjNJdTRZcmhObk44MWxYL0w3dFoKLzJvQXZMV0V3Y0NVdVNnNENHYURnYlZycjVPd0ozK1pNNnhKb1NJQTZ3RzExQkNWa1l0NTJ0cnZuZ0VJU2FhMwppd3dZWmJPbldhL0ZVZHA3N093K1VCbExiZXRZSndqSXk2UlZrMGxJOHEyb24zMEd6VWZOSGF6blVpVU1sdWV4CkdjRGU5Q2srYTJqL1BGVjlkRWIyYkRvSW52NkdhSXd1V29KR094ZnJRUVRaUFdVTDZrM0JVMHdDVThKWTdQaXQKSGlIZ1dNLzVWRzhUdGU4Mm1XcjV4Rmk3NEkyUFZ3SDdUd3RUbEFOaGN0a0Z6VUROd0Iyem1nVWZxZklGWCtHMApETUQwT3h2bldicz0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=", "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSURYekNDQWtlZ0F3SUJBZ0lCQVRBTkJna3Foa2lHOXcwQkFRVUZBREJpTVFzd0NRWURWUVFHRXdKRFRqRVEKTUE0R0ExVUVDQXdIUW1WcGFtbHVaekVRTUE0R0ExVUVCd3dIUW1WcGFtbHVaekVTTUJBR0ExVUVDd3dKUVhKeQpiM2R1YjJOck1Sc3dHUVlEVlFRRERCSkJjbkp2ZDI1dlkyc2dRMjh1TEV4MFpDNHdIaGNOTVRZd05qQTFNVFUxCk5qTXdXaGNOTXpZd05UTXhNVFUxTmpNd1dqQmlNUXN3Q1FZRFZRUUdFd0pEVGpFUU1BNEdBMVVFQ0F3SFFtVnAKYW1sdVp6RVFNQTRHQTFVRUJ3d0hRbVZwYW1sdVp6RVNNQkFHQTFVRUN3d0pRWEp5YjNkdWIyTnJNUnN3R1FZRApWUVFEREJKQmNuSnZkMjV2WTJzZ1EyOHVMRXgwWkM0d2dnRWlNQTBHQ1NxR1NJYjNEUUVCQVFVQUE0SUJEd0F3CmdnRUtBb0lCQVFERTREa1dWT1BmVlY2TjVkRktxaUtsaUNodUNreEQ4SDdLUTNyUm1ZdnY0K3NKdzFDUXBpU3cKOUpDQlJ6dDk5anM3VWdZK3htUnl1S0dNMWIrN3UwUERtT0xhNithTktZVEpRREZVaUE1Qlp2SWNHZFdKWjZJNwpjMk0zc1lzSU5uV1Q3Q0EySnV3TDR2V094eXB5UlhvQm8rWUFtYm12ZVlTcnpyK1VzT2JybENwSjdaOEhhRkowCm15VmFLL3FqQllqVzVWTFFiUHhNSGxrWURmbHYxdytwQUJNRDhLREtwSGc4Y1RmOGVoR1FPSHZ4NUtxMFNDU3UKZTlnNzkyV3hNOGdKWTZPRHJ3OW53d1QxUHVZZmJUNm5XU0kwY0VYZUZhK2pNVXVzaWJwSWhYdVRiNzR5ZmVyUwpjeE55WlE3TzNydEJFbThPVk15NzBFcmpjemlVU1NIM0FnTUJBQUdqSURBZU1Ba0dBMVVkRXdRQ01BQXdFUVlKCllJWklBWWI0UWdFQkJBUURBZ2VBTUEwR0NTcUdTSWIzRFFFQkJRVUFBNElCQVFBemYwQnphUWhGcklHUnUzTjgKZU4ycEhQMzZEK1o4OXQzcTVDWG5TbW9ERTBObUY0Yjc2T1dKU2YyOERoZHoycjBPS3pUOThjR3RlY25ZMHE4VApvTW5pZHdiK21DUFloQ09qTkpnbitwUjNIWGh0YjdwaSt4RkVieituOWNHT3kxWW02bTZidUdHSitaUHZ6Z2JOClA5N1BPdi92aVl0SUkxZmFVdzZaMDBSdmxqUlBqNFZJQjN2ZTNWa3NrOUpRSXJxRTVhUFhGNEwxTFpyV21jRkwKWlJURVMyUnpQZ2ZQZktJOTlyWVlJYnE0MVRQRDlFemhmdkJORyt0WmdnSG9uY0ROdnhYcE1USmZlOEZzUVNmeQphaFFXQ0lrcnE0YXZIWGlETmtqNlFocXJQT0tZRTR6K1VBY0VLSHpUQnZ2Z2ZKUTZ0TVJjUjcvMmNZTHMxZTNKCmlXdkYKLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=", "LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQpNSUlFcEFJQkFBS0NBUUVBeE9BNUZsVGozMVZlamVYUlNxb2lwWWdvYmdwTVEvQit5a042MFptTDcrUHJDY05RCmtLWWtzUFNRZ1VjN2ZmWTdPMUlHUHNaa2NyaWhqTlcvdTd0RHc1amkydXZtalNtRXlVQXhWSWdPUVdieUhCblYKaVdlaU8zTmpON0dMQ0RaMWsrd2dOaWJzQytMMWpzY3Fja1Y2QWFQbUFKbTVyM21FcTg2L2xMRG02NVFxU2UyZgpCMmhTZEpzbFdpdjZvd1dJMXVWUzBHejhUQjVaR0EzNWI5Y1BxUUFUQS9DZ3lxUjRQSEUzL0hvUmtEaDc4ZVNxCnRFZ2tybnZZTy9kbHNUUElDV09qZzY4UFo4TUU5VDdtSDIwK3Axa2lOSEJGM2hXdm96RkxySW02U0lWN2syKysKTW4zcTBuTVRjbVVPenQ2N1FSSnZEbFRNdTlCSzQzTTRsRWtoOXdJREFRQUJBb0lCQVFDMTNWdGU0YlJPanBIMgpDcUkza3NyR2x1eWlHaWt4YVd2MmREZDBmNTdoVDIzRGF3VjFXY1R6SWppSzg3NWxNWnl0dzZ1NU9aTjQxazJGCng3NkNNUTc4RkxNYkFHZk5adGtlLzRtU1NNekNaZEtwV3NRRFZoUnJUc0FNcHBtRVVLcDBwdDlxcHJIT21TMjEKWXc0MjJTOUhiSnYvV2dKSnNydDM2bGpYaGtNS3dnY0I3Vk8yRnh5cWNyOUl5VW5uYkVCOWhEN3F2cm54VHNaTwpicWtMSW9ncnkyNjZOb3R0YmVhR3dMUW5XTG1NSFRjcFdIV0dibURaLzBjNUVkS1N3UmpHbllRN2c3TncrU2o3Cjd2NUpiYkc0UWNEK1BwUlh6bW9Hc29QUkVoMzlzNi8wQjVCUWQzNjdmM05oQ0hVa0QzNWFiMDJEVGdTdW13cW4KOXRTUUJPSmhBb0dCQVBqdmRNS1BibUZPV2hxdENVdlEwL1FSOStaS09XVGREZmdZZVdVZGVJUEg0bzVlelZoQwovOGVLVXp3d1FHdGduUk1reXNEbVRqR1ZnRTFjZUwxN1BxUU51VmxaeWZqbkVyK1MzVmFJVDE1M1VvRnJzTWtNCmJmbm45c1hVWlJQc0JqL3U2R3A4Q3dramRWMTBSMXEySDZjdjFWRnBobjFXTUVOM1JmL0E3VWtyQW9HQkFNcDIKakhWR3NWRVFpZFdJZXI2M3RxVzZHVjJrejBrNHFnT3RJcVZkS1p0dVNPMUZWRDVoblRLQzVUQ0ZGRkN5WlF5bwpUQWtaMnQwb2NSd01WSnY2cklNUGNnVXVwZXE1cTdaNE43MHdtUytDRUNtYTVROTlxY3l0OXlSWjYyR3NMSDlhCk5XaXZ2QW8yL2FYalYxYTF1Z0xCZHBkZHJzUElWc1JwYWM2b2w4eGxBb0dCQU0yN2dRRG03MittQkp1MVZGQi8KVnh5STJSdFBUcDNJZjZvQitCb1VRQ3lSUHZFdzhuNjJhSlB1QXhwa09tbEQ0SzBZcENUR2NldFN4a1dwWGZRagpia0xCUU9UU2F6UzFMRzU5bjBYTHcrU3JzdGxaT2pMK2ZjbWk1dlRhczJyQ2p1dTV0QVdGWE0yQnE1YS82ZFRUClhkZWJsYTRDQzI5OGtzaS9RMis2YjZFZkFvR0FXZ1FQT3UwdFZROTNXTnNQUjlCQ2dyaVZJbzl1SWUzeG1TVFgKTEpLWk55UDNoSmE0ZCt2S2luU3NGY0IxWWRPUEhldU5zdFl0K3ZwS0grQlRsZTREMlZsNnBsY3hLWVZYbFE4cQpLUkY4YWlUM3JxZlJnK3VwSFBtVDBqT3dkWUtwWGczcmhSbnREdFdZUExNeFY3b0FjODAwUHVSR0dZSHZJZkNFClBIKzB6Z2tDZ1lBSE5LS1RGTUxaZU9RTXBiNXYyYzNVdUNEaG1kQjczcGI4RTV1SnJidktIV09pc3kyVHcrRkEKL0E4WmJzMEp5UGFqZnhyODQ4ZFlFNU00OHlnSDVUc3gycFBsdXNOQjVnT054WlNLWkxRaGpKY3k5RUlQZEx6QwpGUWllblM4NXUwdTRDZ21DMG9JTnMrQnFFZE91eUhwUkdiRzV3Z285U3kya1pKaXJuZzZHOGc9PQotLS0tLUVORCBSU0EgUFJJVkFURSBLRVktLS0tLQo=", "", "BKS");
        cj localcj = new cj;
        localcj.<init>(localKeyStore);
        localcj.setHostnameVerifier(jdField_a_of_type_Bm);
        this.jdField_a_of_type_Eq.a(localcj);
        return paramString + str + "?key=" + this.jdField_a_of_type_JavaLangString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private String a(String paramString1, String paramString2, Object paramObject, Map<String, String> paramMap)
    throws Exception
  {
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramObject instanceof JSONArray))
    {
      localObject2 = (JSONArray)paramObject;
      localObject1 = paramString1.split(",");
      i = 0;
      paramObject = paramString2;
      if (i < ((JSONArray)localObject2).length())
      {
        if (!"".equals(paramString1))
        {
          int j = 0;
          paramObject = paramString2;
          while (j < localObject1.length)
          {
            paramObject = (String)paramObject + "[" + localObject1[j] + "]";
            j++;
          }
        }
        if ("".equals(paramString1)) {
          paramMap.put((String)paramObject + "[" + i + "]", a(i, paramString2, ((JSONArray)localObject2).get(i), paramMap));
        }
        for (;;)
        {
          i++;
          break;
          paramMap.put((String)paramObject + "[" + i + "]", a(paramString1 + "," + i, paramString2, ((JSONArray)localObject2).get(i), paramMap));
        }
      }
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      if ((paramObject instanceof JSONObject))
      {
        localObject2 = (JSONObject)paramObject;
        Iterator localIterator = ((JSONObject)localObject2).keys();
        String[] arrayOfString = paramString1.split(",");
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject3 = ((JSONObject)localObject2).get(str);
          if (!"".equals(paramString1))
          {
            i = 0;
            paramObject = paramString2;
            for (;;)
            {
              localObject1 = paramObject;
              if (i >= arrayOfString.length) {
                break;
              }
              paramObject = (String)paramObject + "[" + arrayOfString[i] + "]";
              i++;
            }
          }
          localObject1 = paramString2;
          if ("".equals(paramString1)) {
            paramMap.put((String)localObject1 + "[" + str + "]", a(str, paramString2, localObject3, paramMap));
          } else {
            paramMap.put((String)localObject1 + "[" + str + "]", a(paramString1 + "," + str, paramString2, localObject3, paramMap));
          }
        }
        paramString1 = null;
      }
      else
      {
        paramString1 = paramObject.toString();
      }
    }
  }
  
  private static void a(String paramString, IAnSocialCallback paramIAnSocialCallback)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("status", "fail");
      localJSONObject2.put("message", paramString);
      localJSONObject2.put("errorCode", -200004);
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
          new Thread(new cg(paramIAnSocialCallback, localJSONObject1)).run();
        }
      }
    }
    finally
    {
      if (paramIAnSocialCallback != null) {
        new Thread(new cg(paramIAnSocialCallback, localJSONObject1)).run();
      }
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Eq.a(paramInt);
  }
  
  public final void a(Boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean.booleanValue();
  }
  
  public final void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, IAnSocialCallback paramIAnSocialCallback)
    throws ArrownockException
  {
    paramJSONObject = a(paramJSONObject);
    this.jdField_a_of_type_Eq.a(a(paramString), paramJSONObject, new bo(paramIAnSocialCallback));
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, InputStream paramInputStream, IAnSocialCallback paramIAnSocialCallback)
    throws ArrownockException
  {
    boolean bool = paramString.contains("files");
    ez localez = a(paramJSONObject);
    if (bool) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getString("file");
        if (!"".equals(paramJSONObject)) {
          break;
        }
        a("FileName is invalid", paramIAnSocialCallback);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        a("FileName is invalid", paramIAnSocialCallback);
        continue;
      }
      paramJSONObject = paramJSONObject.getString("photo");
    }
    if (bool) {}
    for (String str = "file";; str = "photo")
    {
      localez.a(str, paramInputStream, paramJSONObject);
      new Thread(new cb(this, paramString, localez, paramIAnSocialCallback)).run();
      break;
    }
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, byte[] paramArrayOfByte, IAnSocialCallback paramIAnSocialCallback)
    throws ArrownockException
  {
    boolean bool = paramString.contains("files");
    ez localez = a(paramJSONObject);
    if (bool) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getString("file");
        if (!"".equals(paramJSONObject)) {
          break;
        }
        a("FileName is invalid", paramIAnSocialCallback);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        a("FileName is invalid", paramIAnSocialCallback);
        continue;
      }
      paramJSONObject = paramJSONObject.getString("photo");
    }
    if (bool) {}
    for (String str = "file";; str = "photo")
    {
      localez.a(str, new ByteArrayInputStream(paramArrayOfByte), paramJSONObject);
      new Thread(new bw(this, paramString, localez, paramIAnSocialCallback)).run();
      break;
    }
  }
  
  public final void b(String paramString)
  {
    this.b = paramString;
  }
  
  public final void b(String paramString, JSONObject paramJSONObject, IAnSocialCallback paramIAnSocialCallback)
    throws ArrownockException
  {
    paramJSONObject = a(paramJSONObject);
    this.jdField_a_of_type_Eq.b(a(paramString), paramJSONObject, new bs(paramIAnSocialCallback));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */