package org.apache.cordova;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.format.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Globalization
  extends CordovaPlugin
{
  public static final String CURRENCY = "currency";
  public static final String CURRENCYCODE = "currencyCode";
  public static final String DATE = "date";
  public static final String DATESTRING = "dateString";
  public static final String DATETOSTRING = "dateToString";
  public static final String DAYS = "days";
  public static final String FORMATLENGTH = "formatLength";
  public static final String FULL = "full";
  public static final String GETCURRENCYPATTERN = "getCurrencyPattern";
  public static final String GETDATENAMES = "getDateNames";
  public static final String GETDATEPATTERN = "getDatePattern";
  public static final String GETFIRSTDAYOFWEEK = "getFirstDayOfWeek";
  public static final String GETLOCALENAME = "getLocaleName";
  public static final String GETNUMBERPATTERN = "getNumberPattern";
  public static final String GETPREFERREDLANGUAGE = "getPreferredLanguage";
  public static final String ISDAYLIGHTSAVINGSTIME = "isDayLightSavingsTime";
  public static final String ITEM = "item";
  public static final String LONG = "long";
  public static final String MEDIUM = "medium";
  public static final String MONTHS = "months";
  public static final String NARROW = "narrow";
  public static final String NUMBER = "number";
  public static final String NUMBERSTRING = "numberString";
  public static final String NUMBERTOSTRING = "numberToString";
  public static final String OPTIONS = "options";
  public static final String PERCENT = "percent";
  public static final String SELECTOR = "selector";
  public static final String STRINGTODATE = "stringToDate";
  public static final String STRINGTONUMBER = "stringToNumber";
  public static final String TIME = "time";
  public static final String TYPE = "type";
  public static final String WIDE = "wide";
  
  private JSONObject getCurrencyPattern(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = paramJSONArray.getJSONObject(0).getString("currencyCode");
      paramJSONArray = (DecimalFormat)DecimalFormat.getCurrencyInstance(Locale.getDefault());
      localObject = Currency.getInstance((String)localObject);
      paramJSONArray.setCurrency((Currency)localObject);
      localJSONObject.put("pattern", paramJSONArray.toPattern());
      localJSONObject.put("code", ((Currency)localObject).getCurrencyCode());
      localJSONObject.put("fraction", paramJSONArray.getMinimumFractionDigits());
      localObject = new java/lang/Integer;
      ((Integer)localObject).<init>(0);
      localJSONObject.put("rounding", localObject);
      localJSONObject.put("decimal", String.valueOf(paramJSONArray.getDecimalFormatSymbols().getDecimalSeparator()));
      localJSONObject.put("grouping", String.valueOf(paramJSONArray.getDecimalFormatSymbols().getGroupingSeparator()));
      return localJSONObject;
    }
    catch (Exception paramJSONArray)
    {
      throw new GlobalizationError("FORMATTING_ERROR");
    }
  }
  
  @TargetApi(9)
  private JSONObject getDateNames(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int n = 0;
    int m = 0;
    int k = m;
    for (;;)
    {
      try
      {
        if (paramJSONArray.getJSONObject(0).length() > 0)
        {
          i = n;
          if (!((JSONObject)paramJSONArray.getJSONObject(0).get("options")).isNull("type"))
          {
            i = n;
            if (((String)((JSONObject)paramJSONArray.getJSONObject(0).get("options")).get("type")).equalsIgnoreCase("narrow")) {
              i = 0 + 1;
            }
          }
          k = m;
          j = i;
          if (!((JSONObject)paramJSONArray.getJSONObject(0).get("options")).isNull("item"))
          {
            k = m;
            j = i;
            if (((String)((JSONObject)paramJSONArray.getJSONObject(0).get("options")).get("item")).equalsIgnoreCase("days"))
            {
              k = 0 + 10;
              j = i;
            }
          }
        }
        i = k + j;
        if (i == 1)
        {
          paramJSONArray = Calendar.getInstance().getDisplayNames(2, 1, Locale.getDefault());
          localObject = paramJSONArray.keySet().iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localArrayList.add((String)((Iterator)localObject).next());
          continue;
        }
        if (i != 10) {
          break label280;
        }
      }
      catch (Exception paramJSONArray)
      {
        throw new GlobalizationError("UNKNOWN_ERROR");
      }
      paramJSONArray = Calendar.getInstance().getDisplayNames(7, 2, Locale.getDefault());
      continue;
      label280:
      if (i == 11) {
        paramJSONArray = Calendar.getInstance().getDisplayNames(7, 1, Locale.getDefault());
      } else {
        paramJSONArray = Calendar.getInstance().getDisplayNames(2, 2, Locale.getDefault());
      }
    }
    Object localObject = new org/apache/cordova/Globalization$1;
    ((1)localObject).<init>(this, paramJSONArray);
    Collections.sort(localArrayList, (Comparator)localObject);
    for (int i = 0; i < localArrayList.size(); i++) {
      localJSONArray.put(localArrayList.get(i));
    }
    paramJSONArray = localJSONObject.put("value", localJSONArray);
    return paramJSONArray;
  }
  
  /* Error */
  private JSONObject getDatePattern(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    // Byte code:
    //   0: new 115	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 116	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 292	org/apache/cordova/Globalization:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   13: invokeinterface 298 1 0
    //   18: invokestatic 304	android/text/format/DateFormat:getDateFormat	(Landroid/content/Context;)Ljava/text/DateFormat;
    //   21: checkcast 306	java/text/SimpleDateFormat
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 292	org/apache/cordova/Globalization:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   30: invokeinterface 298 1 0
    //   35: invokestatic 309	android/text/format/DateFormat:getTimeFormat	(Landroid/content/Context;)Ljava/text/DateFormat;
    //   38: checkcast 306	java/text/SimpleDateFormat
    //   41: astore 6
    //   43: new 311	java/lang/StringBuilder
    //   46: astore_2
    //   47: aload_2
    //   48: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: aload 4
    //   54: invokevirtual 315	java/text/SimpleDateFormat:toLocalizedPattern	()Ljava/lang/String;
    //   57: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 321
    //   63: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 6
    //   68: invokevirtual 315	java/text/SimpleDateFormat:toLocalizedPattern	()Ljava/lang/String;
    //   71: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_1
    //   79: iconst_0
    //   80: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   83: invokevirtual 218	org/json/JSONObject:length	()I
    //   86: iconst_1
    //   87: if_icmple +169 -> 256
    //   90: aload 4
    //   92: astore_3
    //   93: aload_1
    //   94: iconst_0
    //   95: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   98: ldc 82
    //   100: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   103: checkcast 115	org/json/JSONObject
    //   106: ldc 28
    //   108: invokevirtual 226	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   111: ifne +50 -> 161
    //   114: aload_1
    //   115: iconst_0
    //   116: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   119: ldc 82
    //   121: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   124: checkcast 115	org/json/JSONObject
    //   127: ldc 28
    //   129: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   132: checkcast 193	java/lang/String
    //   135: astore_2
    //   136: aload_2
    //   137: ldc 64
    //   139: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   142: ifeq +191 -> 333
    //   145: aload_0
    //   146: getfield 292	org/apache/cordova/Globalization:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   149: invokeinterface 298 1 0
    //   154: invokestatic 327	android/text/format/DateFormat:getMediumDateFormat	(Landroid/content/Context;)Ljava/text/DateFormat;
    //   157: checkcast 306	java/text/SimpleDateFormat
    //   160: astore_3
    //   161: new 311	java/lang/StringBuilder
    //   164: astore_2
    //   165: aload_2
    //   166: invokespecial 312	java/lang/StringBuilder:<init>	()V
    //   169: aload_2
    //   170: aload_3
    //   171: invokevirtual 315	java/text/SimpleDateFormat:toLocalizedPattern	()Ljava/lang/String;
    //   174: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 321
    //   180: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 6
    //   185: invokevirtual 315	java/text/SimpleDateFormat:toLocalizedPattern	()Ljava/lang/String;
    //   188: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore 4
    //   196: aload 4
    //   198: astore_2
    //   199: aload_1
    //   200: iconst_0
    //   201: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   204: ldc 82
    //   206: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   209: checkcast 115	org/json/JSONObject
    //   212: ldc 88
    //   214: invokevirtual 226	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   217: ifne +39 -> 256
    //   220: aload_1
    //   221: iconst_0
    //   222: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   225: ldc 82
    //   227: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   230: checkcast 115	org/json/JSONObject
    //   233: ldc 88
    //   235: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   238: checkcast 193	java/lang/String
    //   241: astore_1
    //   242: aload_1
    //   243: ldc 16
    //   245: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   248: ifeq +125 -> 373
    //   251: aload_3
    //   252: invokevirtual 315	java/text/SimpleDateFormat:toLocalizedPattern	()Ljava/lang/String;
    //   255: astore_2
    //   256: invokestatic 332	android/text/format/Time:getCurrentTimezone	()Ljava/lang/String;
    //   259: invokestatic 338	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   262: astore_1
    //   263: aload 5
    //   265: ldc -106
    //   267: aload_2
    //   268: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   271: pop
    //   272: aload 5
    //   274: ldc_w 340
    //   277: aload_1
    //   278: aload_1
    //   279: invokestatic 234	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   282: invokevirtual 344	java/util/Calendar:getTime	()Ljava/util/Date;
    //   285: invokevirtual 348	java/util/TimeZone:inDaylightTime	(Ljava/util/Date;)Z
    //   288: iconst_0
    //   289: invokevirtual 352	java/util/TimeZone:getDisplayName	(ZI)Ljava/lang/String;
    //   292: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   295: pop
    //   296: aload 5
    //   298: ldc_w 354
    //   301: aload_1
    //   302: invokevirtual 357	java/util/TimeZone:getRawOffset	()I
    //   305: sipush 1000
    //   308: idiv
    //   309: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload 5
    //   315: ldc_w 359
    //   318: aload_1
    //   319: invokevirtual 362	java/util/TimeZone:getDSTSavings	()I
    //   322: sipush 1000
    //   325: idiv
    //   326: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload 5
    //   332: areturn
    //   333: aload_2
    //   334: ldc 61
    //   336: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   339: ifne +15 -> 354
    //   342: aload 4
    //   344: astore_3
    //   345: aload_2
    //   346: ldc 31
    //   348: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   351: ifeq -190 -> 161
    //   354: aload_0
    //   355: getfield 292	org/apache/cordova/Globalization:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   358: invokeinterface 298 1 0
    //   363: invokestatic 365	android/text/format/DateFormat:getLongDateFormat	(Landroid/content/Context;)Ljava/text/DateFormat;
    //   366: checkcast 306	java/text/SimpleDateFormat
    //   369: astore_3
    //   370: goto -209 -> 161
    //   373: aload 4
    //   375: astore_2
    //   376: aload_1
    //   377: ldc 97
    //   379: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   382: ifeq -126 -> 256
    //   385: aload 6
    //   387: invokevirtual 315	java/text/SimpleDateFormat:toLocalizedPattern	()Ljava/lang/String;
    //   390: astore_2
    //   391: goto -135 -> 256
    //   394: astore_1
    //   395: new 111	org/apache/cordova/GlobalizationError
    //   398: dup
    //   399: ldc_w 367
    //   402: invokespecial 207	org/apache/cordova/GlobalizationError:<init>	(Ljava/lang/String;)V
    //   405: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	Globalization
    //   0	406	1	paramJSONArray	JSONArray
    //   46	345	2	localObject1	Object
    //   92	278	3	localObject2	Object
    //   24	350	4	localObject3	Object
    //   7	324	5	localJSONObject	JSONObject
    //   41	345	6	localSimpleDateFormat	SimpleDateFormat
    // Exception table:
    //   from	to	target	type
    //   9	78	394	java/lang/Exception
    //   78	90	394	java/lang/Exception
    //   93	161	394	java/lang/Exception
    //   161	196	394	java/lang/Exception
    //   199	256	394	java/lang/Exception
    //   256	330	394	java/lang/Exception
    //   333	342	394	java/lang/Exception
    //   345	354	394	java/lang/Exception
    //   354	370	394	java/lang/Exception
    //   376	391	394	java/lang/Exception
  }
  
  private JSONObject getDateToString(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Date localDate = new java/util/Date;
      localDate.<init>(((Long)paramJSONArray.getJSONObject(0).get("date")).longValue());
      paramJSONArray = getDatePattern(paramJSONArray);
      SimpleDateFormat localSimpleDateFormat = new java/text/SimpleDateFormat;
      localSimpleDateFormat.<init>(paramJSONArray.getString("pattern"));
      paramJSONArray = localJSONObject.put("value", localSimpleDateFormat.format(localDate));
      return paramJSONArray;
    }
    catch (Exception paramJSONArray)
    {
      throw new GlobalizationError("FORMATTING_ERROR");
    }
  }
  
  private JSONObject getFirstDayOfWeek(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    paramJSONArray = new JSONObject();
    try
    {
      paramJSONArray = paramJSONArray.put("value", Calendar.getInstance(Locale.getDefault()).getFirstDayOfWeek());
      return paramJSONArray;
    }
    catch (Exception paramJSONArray)
    {
      throw new GlobalizationError("UNKNOWN_ERROR");
    }
  }
  
  private JSONObject getIsDayLightSavingsTime(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Date localDate = new java/util/Date;
      localDate.<init>(((Long)paramJSONArray.getJSONObject(0).get("date")).longValue());
      paramJSONArray = localJSONObject.put("dst", TimeZone.getTimeZone(Time.getCurrentTimezone()).inDaylightTime(localDate));
      return paramJSONArray;
    }
    catch (Exception paramJSONArray)
    {
      throw new GlobalizationError("UNKNOWN_ERROR");
    }
  }
  
  private JSONObject getLocaleName()
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", Locale.getDefault().toString());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      throw new GlobalizationError("UNKNOWN_ERROR");
    }
  }
  
  private DecimalFormat getNumberFormatInstance(JSONArray paramJSONArray)
    throws JSONException
  {
    localDecimalFormat2 = (DecimalFormat)DecimalFormat.getInstance(Locale.getDefault());
    localDecimalFormat1 = localDecimalFormat2;
    for (;;)
    {
      try
      {
        if (paramJSONArray.getJSONObject(0).length() > 1)
        {
          localDecimalFormat1 = localDecimalFormat2;
          if (!((JSONObject)paramJSONArray.getJSONObject(0).get("options")).isNull("type"))
          {
            paramJSONArray = (String)((JSONObject)paramJSONArray.getJSONObject(0).get("options")).get("type");
            if (!paramJSONArray.equalsIgnoreCase("currency")) {
              continue;
            }
            localDecimalFormat1 = (DecimalFormat)DecimalFormat.getCurrencyInstance(Locale.getDefault());
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        localDecimalFormat1 = localDecimalFormat2;
        continue;
      }
      return localDecimalFormat1;
      localDecimalFormat1 = localDecimalFormat2;
      if (paramJSONArray.equalsIgnoreCase("percent")) {
        localDecimalFormat1 = (DecimalFormat)DecimalFormat.getPercentInstance(Locale.getDefault());
      }
    }
  }
  
  /* Error */
  private JSONObject getNumberPattern(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    // Byte code:
    //   0: new 115	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 116	org/json/JSONObject:<init>	()V
    //   7: astore 7
    //   9: invokestatic 132	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   12: invokestatic 405	java/text/DecimalFormat:getInstance	(Ljava/util/Locale;)Ljava/text/NumberFormat;
    //   15: checkcast 134	java/text/DecimalFormat
    //   18: astore 5
    //   20: aload 5
    //   22: invokevirtual 185	java/text/DecimalFormat:getDecimalFormatSymbols	()Ljava/text/DecimalFormatSymbols;
    //   25: invokevirtual 191	java/text/DecimalFormatSymbols:getDecimalSeparator	()C
    //   28: invokestatic 197	java/lang/String:valueOf	(C)Ljava/lang/String;
    //   31: astore 6
    //   33: aload 5
    //   35: astore_3
    //   36: aload 6
    //   38: astore 4
    //   40: aload_1
    //   41: iconst_0
    //   42: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   45: invokevirtual 218	org/json/JSONObject:length	()I
    //   48: ifle +81 -> 129
    //   51: aload 5
    //   53: astore_3
    //   54: aload 6
    //   56: astore 4
    //   58: aload_1
    //   59: iconst_0
    //   60: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   63: ldc 82
    //   65: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   68: checkcast 115	org/json/JSONObject
    //   71: ldc 100
    //   73: invokevirtual 226	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   76: ifne +53 -> 129
    //   79: aload_1
    //   80: iconst_0
    //   81: invokevirtual 122	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   84: ldc 82
    //   86: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   89: checkcast 115	org/json/JSONObject
    //   92: ldc 100
    //   94: invokevirtual 222	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   97: checkcast 193	java/lang/String
    //   100: astore_1
    //   101: aload_1
    //   102: ldc 10
    //   104: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   107: ifeq +140 -> 247
    //   110: invokestatic 132	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   113: invokestatic 138	java/text/DecimalFormat:getCurrencyInstance	(Ljava/util/Locale;)Ljava/text/NumberFormat;
    //   116: checkcast 134	java/text/DecimalFormat
    //   119: astore_3
    //   120: aload_3
    //   121: invokevirtual 185	java/text/DecimalFormat:getDecimalFormatSymbols	()Ljava/text/DecimalFormatSymbols;
    //   124: invokevirtual 411	java/text/DecimalFormatSymbols:getCurrencySymbol	()Ljava/lang/String;
    //   127: astore 4
    //   129: aload 7
    //   131: ldc -106
    //   133: aload_3
    //   134: invokevirtual 154	java/text/DecimalFormat:toPattern	()Ljava/lang/String;
    //   137: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   140: pop
    //   141: aload 7
    //   143: ldc_w 413
    //   146: aload 4
    //   148: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 7
    //   154: ldc -91
    //   156: aload_3
    //   157: invokevirtual 169	java/text/DecimalFormat:getMinimumFractionDigits	()I
    //   160: invokevirtual 172	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   163: pop
    //   164: new 174	java/lang/Integer
    //   167: astore_1
    //   168: aload_1
    //   169: iconst_0
    //   170: invokespecial 177	java/lang/Integer:<init>	(I)V
    //   173: aload 7
    //   175: ldc -77
    //   177: aload_1
    //   178: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload 7
    //   184: ldc_w 415
    //   187: aload_3
    //   188: invokevirtual 418	java/text/DecimalFormat:getPositivePrefix	()Ljava/lang/String;
    //   191: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   194: pop
    //   195: aload 7
    //   197: ldc_w 420
    //   200: aload_3
    //   201: invokevirtual 423	java/text/DecimalFormat:getNegativePrefix	()Ljava/lang/String;
    //   204: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 7
    //   210: ldc -75
    //   212: aload_3
    //   213: invokevirtual 185	java/text/DecimalFormat:getDecimalFormatSymbols	()Ljava/text/DecimalFormatSymbols;
    //   216: invokevirtual 191	java/text/DecimalFormatSymbols:getDecimalSeparator	()C
    //   219: invokestatic 197	java/lang/String:valueOf	(C)Ljava/lang/String;
    //   222: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload 7
    //   228: ldc -57
    //   230: aload_3
    //   231: invokevirtual 185	java/text/DecimalFormat:getDecimalFormatSymbols	()Ljava/text/DecimalFormatSymbols;
    //   234: invokevirtual 202	java/text/DecimalFormatSymbols:getGroupingSeparator	()C
    //   237: invokestatic 197	java/lang/String:valueOf	(C)Ljava/lang/String;
    //   240: invokevirtual 158	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 7
    //   246: areturn
    //   247: aload 5
    //   249: astore_3
    //   250: aload 6
    //   252: astore 4
    //   254: aload_1
    //   255: ldc 85
    //   257: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   260: ifeq -131 -> 129
    //   263: invokestatic 132	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   266: invokestatic 408	java/text/DecimalFormat:getPercentInstance	(Ljava/util/Locale;)Ljava/text/NumberFormat;
    //   269: checkcast 134	java/text/DecimalFormat
    //   272: astore_3
    //   273: aload_3
    //   274: invokevirtual 185	java/text/DecimalFormat:getDecimalFormatSymbols	()Ljava/text/DecimalFormatSymbols;
    //   277: invokevirtual 426	java/text/DecimalFormatSymbols:getPercent	()C
    //   280: istore_2
    //   281: iload_2
    //   282: invokestatic 197	java/lang/String:valueOf	(C)Ljava/lang/String;
    //   285: astore 4
    //   287: goto -158 -> 129
    //   290: astore_1
    //   291: new 111	org/apache/cordova/GlobalizationError
    //   294: dup
    //   295: ldc_w 367
    //   298: invokespecial 207	org/apache/cordova/GlobalizationError:<init>	(Ljava/lang/String;)V
    //   301: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	Globalization
    //   0	302	1	paramJSONArray	JSONArray
    //   280	2	2	c	char
    //   35	239	3	localDecimalFormat1	DecimalFormat
    //   38	248	4	str1	String
    //   18	230	5	localDecimalFormat2	DecimalFormat
    //   31	220	6	str2	String
    //   7	238	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	33	290	java/lang/Exception
    //   40	51	290	java/lang/Exception
    //   58	129	290	java/lang/Exception
    //   129	244	290	java/lang/Exception
    //   254	281	290	java/lang/Exception
  }
  
  private JSONObject getNumberToString(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramJSONArray = localJSONObject.put("value", getNumberFormatInstance(paramJSONArray).format(paramJSONArray.getJSONObject(0).get("number")));
      return paramJSONArray;
    }
    catch (Exception paramJSONArray)
    {
      throw new GlobalizationError("FORMATTING_ERROR");
    }
  }
  
  private JSONObject getPreferredLanguage()
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", Locale.getDefault().getDisplayLanguage().toString());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      throw new GlobalizationError("UNKNOWN_ERROR");
    }
  }
  
  private JSONObject getStringToNumber(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramJSONArray = localJSONObject.put("value", getNumberFormatInstance(paramJSONArray).parse((String)paramJSONArray.getJSONObject(0).get("numberString")));
      return paramJSONArray;
    }
    catch (Exception paramJSONArray)
    {
      throw new GlobalizationError("PARSING_ERROR");
    }
  }
  
  private JSONObject getStringtoDate(JSONArray paramJSONArray)
    throws GlobalizationError
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = new java/text/SimpleDateFormat;
      ((SimpleDateFormat)localObject).<init>(getDatePattern(paramJSONArray).getString("pattern"));
      paramJSONArray = ((DateFormat)localObject).parse(paramJSONArray.getJSONObject(0).get("dateString").toString());
      localObject = new android/text/format/Time;
      ((Time)localObject).<init>();
      ((Time)localObject).set(paramJSONArray.getTime());
      localJSONObject.put("year", ((Time)localObject).year);
      localJSONObject.put("month", ((Time)localObject).month);
      localJSONObject.put("day", ((Time)localObject).monthDay);
      localJSONObject.put("hour", ((Time)localObject).hour);
      localJSONObject.put("minute", ((Time)localObject).minute);
      localJSONObject.put("second", ((Time)localObject).second);
      paramJSONArray = new java/lang/Long;
      paramJSONArray.<init>(0L);
      localJSONObject.put("millisecond", paramJSONArray);
      return localJSONObject;
    }
    catch (Exception paramJSONArray)
    {
      throw new GlobalizationError("PARSING_ERROR");
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    new JSONObject();
    try
    {
      if (paramString.equals("getLocaleName")) {
        paramString = getLocaleName();
      }
      for (;;)
      {
        paramCallbackContext.success(paramString);
        bool = true;
        return bool;
        if (paramString.equals("getPreferredLanguage"))
        {
          paramString = getPreferredLanguage();
        }
        else if (paramString.equalsIgnoreCase("dateToString"))
        {
          paramString = getDateToString(paramJSONArray);
        }
        else if (paramString.equalsIgnoreCase("stringToDate"))
        {
          paramString = getStringtoDate(paramJSONArray);
        }
        else
        {
          if (!paramString.equalsIgnoreCase("getDatePattern")) {
            break;
          }
          paramString = getDatePattern(paramJSONArray);
        }
      }
      if (paramString.equalsIgnoreCase("getDateNames")) {
        if (Build.VERSION.SDK_INT < 9)
        {
          paramString = new org/apache/cordova/GlobalizationError;
          paramString.<init>("UNKNOWN_ERROR");
          throw paramString;
        }
      }
    }
    catch (GlobalizationError paramString)
    {
      for (;;)
      {
        boolean bool;
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, paramString.toJson()));
        continue;
        paramString = getDateNames(paramJSONArray);
        continue;
        if (paramString.equalsIgnoreCase("isDayLightSavingsTime")) {
          paramString = getIsDayLightSavingsTime(paramJSONArray);
        } else if (paramString.equalsIgnoreCase("getFirstDayOfWeek")) {
          paramString = getFirstDayOfWeek(paramJSONArray);
        } else if (paramString.equalsIgnoreCase("numberToString")) {
          paramString = getNumberToString(paramJSONArray);
        } else if (paramString.equalsIgnoreCase("stringToNumber")) {
          paramString = getStringToNumber(paramJSONArray);
        } else if (paramString.equalsIgnoreCase("getNumberPattern")) {
          paramString = getNumberPattern(paramJSONArray);
        } else if (paramString.equalsIgnoreCase("getCurrencyPattern")) {
          paramString = getCurrencyPattern(paramJSONArray);
        } else {
          bool = false;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Globalization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */