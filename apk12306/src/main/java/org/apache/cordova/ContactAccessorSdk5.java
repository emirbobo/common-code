package org.apache.cordova;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.util.Log;
import android.webkit.WebView;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.cordova.api.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactAccessorSdk5
  extends ContactAccessor
{
  private static final String EMAIL_REGEXP = ".+@.+\\.+.+";
  private static final long MAX_PHOTO_SIZE = 1048576L;
  private static final Map<String, String> dbMap = new HashMap();
  
  static
  {
    dbMap.put("id", "contact_id");
    dbMap.put("displayName", "display_name");
    dbMap.put("name", "data1");
    dbMap.put("name.formatted", "data1");
    dbMap.put("name.familyName", "data3");
    dbMap.put("name.givenName", "data2");
    dbMap.put("name.middleName", "data5");
    dbMap.put("name.honorificPrefix", "data4");
    dbMap.put("name.honorificSuffix", "data6");
    dbMap.put("nickname", "data1");
    dbMap.put("phoneNumbers", "data1");
    dbMap.put("phoneNumbers.value", "data1");
    dbMap.put("emails", "data1");
    dbMap.put("emails.value", "data1");
    dbMap.put("addresses", "data1");
    dbMap.put("addresses.formatted", "data1");
    dbMap.put("addresses.streetAddress", "data4");
    dbMap.put("addresses.locality", "data7");
    dbMap.put("addresses.region", "data8");
    dbMap.put("addresses.postalCode", "data9");
    dbMap.put("addresses.country", "data10");
    dbMap.put("ims", "data1");
    dbMap.put("ims.value", "data1");
    dbMap.put("organizations", "data1");
    dbMap.put("organizations.name", "data1");
    dbMap.put("organizations.department", "data5");
    dbMap.put("organizations.title", "data4");
    dbMap.put("birthday", "vnd.android.cursor.item/contact_event");
    dbMap.put("note", "data1");
    dbMap.put("photos.value", "vnd.android.cursor.item/photo");
    dbMap.put("urls", "data1");
    dbMap.put("urls.value", "data1");
  }
  
  public ContactAccessorSdk5(WebView paramWebView, CordovaInterface paramCordovaInterface)
  {
    this.mApp = paramCordovaInterface;
    this.mView = paramWebView;
  }
  
  private JSONObject addressQuery(Cursor paramCursor)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCursor.getString(paramCursor.getColumnIndex("_id")));
      localJSONObject.put("pref", false);
      localJSONObject.put("type", getAddressType(paramCursor.getInt(paramCursor.getColumnIndex("data2"))));
      localJSONObject.put("formatted", paramCursor.getString(paramCursor.getColumnIndex("data1")));
      localJSONObject.put("streetAddress", paramCursor.getString(paramCursor.getColumnIndex("data4")));
      localJSONObject.put("locality", paramCursor.getString(paramCursor.getColumnIndex("data7")));
      localJSONObject.put("region", paramCursor.getString(paramCursor.getColumnIndex("data8")));
      localJSONObject.put("postalCode", paramCursor.getString(paramCursor.getColumnIndex("data9")));
      localJSONObject.put("country", paramCursor.getString(paramCursor.getColumnIndex("data10")));
      return localJSONObject;
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
  }
  
  private ContactAccessor.WhereOptions buildIdClause(Set<String> paramSet, String paramString)
  {
    ContactAccessor.WhereOptions localWhereOptions = new ContactAccessor.WhereOptions(this);
    if (paramString.equals("%"))
    {
      localWhereOptions.setWhere("(contact_id LIKE ? )");
      localWhereOptions.setWhereArgs(new String[] { paramString });
    }
    for (;;)
    {
      return localWhereOptions;
      paramString = paramSet.iterator();
      paramSet = new StringBuffer("(");
      while (paramString.hasNext())
      {
        paramSet.append("'" + (String)paramString.next() + "'");
        if (paramString.hasNext()) {
          paramSet.append(",");
        }
      }
      paramSet.append(")");
      localWhereOptions.setWhere("contact_id IN " + paramSet.toString());
      localWhereOptions.setWhereArgs(null);
    }
  }
  
  private ContactAccessor.WhereOptions buildWhereClause(JSONArray paramJSONArray, String paramString)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ContactAccessor.WhereOptions localWhereOptions = new ContactAccessor.WhereOptions(this);
    if (isWildCardSearch(paramJSONArray)) {
      if ("%".equals(paramString))
      {
        localWhereOptions.setWhere("(display_name LIKE ? )");
        localWhereOptions.setWhereArgs(new String[] { paramString });
      }
    }
    for (;;)
    {
      return localWhereOptions;
      localArrayList2.add("(" + (String)dbMap.get("displayName") + " LIKE ? )");
      localArrayList1.add(paramString);
      localArrayList2.add("(" + (String)dbMap.get("name") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/name");
      localArrayList2.add("(" + (String)dbMap.get("nickname") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/nickname");
      localArrayList2.add("(" + (String)dbMap.get("phoneNumbers") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/phone_v2");
      localArrayList2.add("(" + (String)dbMap.get("emails") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/email_v2");
      localArrayList2.add("(" + (String)dbMap.get("addresses") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/postal-address_v2");
      localArrayList2.add("(" + (String)dbMap.get("ims") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/im");
      localArrayList2.add("(" + (String)dbMap.get("organizations") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/organization");
      localArrayList2.add("(" + (String)dbMap.get("note") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/note");
      localArrayList2.add("(" + (String)dbMap.get("urls") + " LIKE ? AND " + "mimetype" + " = ? )");
      localArrayList1.add(paramString);
      localArrayList1.add("vnd.android.cursor.item/website");
      if ("%".equals(paramString))
      {
        localWhereOptions.setWhere("(display_name LIKE ? )");
        localWhereOptions.setWhereArgs(new String[] { paramString });
      }
      else
      {
        int i = 0;
        try
        {
          if (i < paramJSONArray.length())
          {
            str = paramJSONArray.getString(i);
            if (str.equals("id"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " = ? )");
              localArrayList1.add(paramString.substring(1, paramString.length() - 1));
            }
            for (;;)
            {
              i++;
              break;
              if (!str.startsWith("displayName")) {
                break label1027;
              }
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? )");
              localArrayList1.add(paramString);
            }
          }
        }
        catch (JSONException paramJSONArray)
        {
          for (;;)
          {
            String str;
            StringBuilder localStringBuilder;
            Log.e("ContactsAccessor", paramJSONArray.getMessage(), paramJSONArray);
            paramJSONArray = new StringBuffer();
            for (i = 0; i < localArrayList2.size(); i++)
            {
              paramJSONArray.append((String)localArrayList2.get(i));
              if (i != localArrayList2.size() - 1) {
                paramJSONArray.append(" OR ");
              }
            }
            label1027:
            if (str.startsWith("name"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/name");
            }
            else if (str.startsWith("nickname"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/nickname");
            }
            else if (str.startsWith("phoneNumbers"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/phone_v2");
            }
            else if (str.startsWith("emails"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/email_v2");
            }
            else if (str.startsWith("addresses"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/postal-address_v2");
            }
            else if (str.startsWith("ims"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/im");
            }
            else if (str.startsWith("organizations"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/organization");
            }
            else if (str.startsWith("note"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/note");
            }
            else if (str.startsWith("urls"))
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localArrayList2.add("(" + (String)dbMap.get(str) + " LIKE ? AND " + "mimetype" + " = ? )");
              localArrayList1.add(paramString);
              localArrayList1.add("vnd.android.cursor.item/website");
            }
          }
          localWhereOptions.setWhere(paramJSONArray.toString());
          paramJSONArray = new String[localArrayList1.size()];
          for (i = 0; i < localArrayList1.size(); i++) {
            paramJSONArray[i] = ((String)localArrayList1.get(i));
          }
          localWhereOptions.setWhereArgs(paramJSONArray);
        }
      }
    }
  }
  
  /* Error */
  private String createNewContact(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 268	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 269	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: getstatic 345	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   14: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   17: ldc_w 353
    //   20: aload_2
    //   21: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   24: ldc_w 361
    //   27: aload_3
    //   28: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   31: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   34: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload_1
    //   39: ldc 40
    //   41: invokevirtual 369	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   44: astore_3
    //   45: aload_1
    //   46: ldc 36
    //   48: invokevirtual 372	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnonnull +7 -> 60
    //   56: aload_3
    //   57: ifnull +105 -> 162
    //   60: aload 5
    //   62: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   65: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   68: ldc_w 377
    //   71: iconst_0
    //   72: invokevirtual 381	android/content/ContentProviderOperation$Builder:withValueBackReference	(Ljava/lang/String;I)Landroid/content/ContentProviderOperation$Builder;
    //   75: ldc_w 288
    //   78: ldc_w 292
    //   81: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   84: ldc 42
    //   86: aload_2
    //   87: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   90: ldc 48
    //   92: aload_0
    //   93: aload_3
    //   94: ldc_w 383
    //   97: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   103: ldc 56
    //   105: aload_0
    //   106: aload_3
    //   107: ldc_w 389
    //   110: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   113: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   116: ldc 52
    //   118: aload_0
    //   119: aload_3
    //   120: ldc_w 391
    //   123: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   126: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   129: ldc 60
    //   131: aload_0
    //   132: aload_3
    //   133: ldc_w 393
    //   136: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   139: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   142: ldc 64
    //   144: aload_0
    //   145: aload_3
    //   146: ldc_w 395
    //   149: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   152: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   155: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   158: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   161: pop
    //   162: aload_1
    //   163: ldc 68
    //   165: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +59 -> 229
    //   173: iconst_0
    //   174: istore 4
    //   176: iload 4
    //   178: aload_2
    //   179: invokevirtual 314	org/json/JSONArray:length	()I
    //   182: if_icmpge +47 -> 229
    //   185: aload_0
    //   186: aload 5
    //   188: aload_2
    //   189: iload 4
    //   191: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   194: checkcast 139	org/json/JSONObject
    //   197: invokespecial 404	org/apache/cordova/ContactAccessorSdk5:insertPhone	(Ljava/util/ArrayList;Lorg/json/JSONObject;)V
    //   200: iinc 4 1
    //   203: goto -27 -> 176
    //   206: astore_2
    //   207: ldc -73
    //   209: ldc_w 406
    //   212: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   215: pop
    //   216: goto -54 -> 162
    //   219: astore_2
    //   220: ldc -73
    //   222: ldc_w 412
    //   225: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   228: pop
    //   229: aload_1
    //   230: ldc 72
    //   232: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   235: astore_2
    //   236: aload_2
    //   237: ifnull +46 -> 283
    //   240: iconst_0
    //   241: istore 4
    //   243: iload 4
    //   245: aload_2
    //   246: invokevirtual 314	org/json/JSONArray:length	()I
    //   249: if_icmpge +34 -> 283
    //   252: aload_0
    //   253: aload 5
    //   255: aload_2
    //   256: iload 4
    //   258: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   261: checkcast 139	org/json/JSONObject
    //   264: invokespecial 415	org/apache/cordova/ContactAccessorSdk5:insertEmail	(Ljava/util/ArrayList;Lorg/json/JSONObject;)V
    //   267: iinc 4 1
    //   270: goto -27 -> 243
    //   273: astore_2
    //   274: ldc -73
    //   276: ldc_w 417
    //   279: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   282: pop
    //   283: aload_1
    //   284: ldc 76
    //   286: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   289: astore_2
    //   290: aload_2
    //   291: ifnull +46 -> 337
    //   294: iconst_0
    //   295: istore 4
    //   297: iload 4
    //   299: aload_2
    //   300: invokevirtual 314	org/json/JSONArray:length	()I
    //   303: if_icmpge +34 -> 337
    //   306: aload_0
    //   307: aload 5
    //   309: aload_2
    //   310: iload 4
    //   312: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   315: checkcast 139	org/json/JSONObject
    //   318: invokespecial 420	org/apache/cordova/ContactAccessorSdk5:insertAddress	(Ljava/util/ArrayList;Lorg/json/JSONObject;)V
    //   321: iinc 4 1
    //   324: goto -27 -> 297
    //   327: astore_2
    //   328: ldc -73
    //   330: ldc_w 422
    //   333: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: aload_1
    //   338: ldc 102
    //   340: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   343: astore_2
    //   344: aload_2
    //   345: ifnull +46 -> 391
    //   348: iconst_0
    //   349: istore 4
    //   351: iload 4
    //   353: aload_2
    //   354: invokevirtual 314	org/json/JSONArray:length	()I
    //   357: if_icmpge +34 -> 391
    //   360: aload_0
    //   361: aload 5
    //   363: aload_2
    //   364: iload 4
    //   366: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   369: checkcast 139	org/json/JSONObject
    //   372: invokespecial 425	org/apache/cordova/ContactAccessorSdk5:insertOrganization	(Ljava/util/ArrayList;Lorg/json/JSONObject;)V
    //   375: iinc 4 1
    //   378: goto -27 -> 351
    //   381: astore_2
    //   382: ldc -73
    //   384: ldc_w 427
    //   387: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   390: pop
    //   391: aload_1
    //   392: ldc 98
    //   394: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   397: astore_2
    //   398: aload_2
    //   399: ifnull +46 -> 445
    //   402: iconst_0
    //   403: istore 4
    //   405: iload 4
    //   407: aload_2
    //   408: invokevirtual 314	org/json/JSONArray:length	()I
    //   411: if_icmpge +34 -> 445
    //   414: aload_0
    //   415: aload 5
    //   417: aload_2
    //   418: iload 4
    //   420: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   423: checkcast 139	org/json/JSONObject
    //   426: invokespecial 430	org/apache/cordova/ContactAccessorSdk5:insertIm	(Ljava/util/ArrayList;Lorg/json/JSONObject;)V
    //   429: iinc 4 1
    //   432: goto -27 -> 405
    //   435: astore_2
    //   436: ldc -73
    //   438: ldc_w 417
    //   441: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   444: pop
    //   445: aload_0
    //   446: aload_1
    //   447: ldc 114
    //   449: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   452: astore_2
    //   453: aload_2
    //   454: ifnull +40 -> 494
    //   457: aload 5
    //   459: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   462: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   465: ldc_w 377
    //   468: iconst_0
    //   469: invokevirtual 381	android/content/ContentProviderOperation$Builder:withValueBackReference	(Ljava/lang/String;I)Landroid/content/ContentProviderOperation$Builder;
    //   472: ldc_w 288
    //   475: ldc_w 306
    //   478: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   481: ldc 42
    //   483: aload_2
    //   484: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   487: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   490: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   493: pop
    //   494: aload_0
    //   495: aload_1
    //   496: ldc 66
    //   498: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   501: astore_2
    //   502: aload_2
    //   503: ifnull +40 -> 543
    //   506: aload 5
    //   508: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   511: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   514: ldc_w 377
    //   517: iconst_0
    //   518: invokevirtual 381	android/content/ContentProviderOperation$Builder:withValueBackReference	(Ljava/lang/String;I)Landroid/content/ContentProviderOperation$Builder;
    //   521: ldc_w 288
    //   524: ldc_w 294
    //   527: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   530: ldc 42
    //   532: aload_2
    //   533: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   536: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   539: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   542: pop
    //   543: aload_1
    //   544: ldc 120
    //   546: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   549: astore_2
    //   550: aload_2
    //   551: ifnull +46 -> 597
    //   554: iconst_0
    //   555: istore 4
    //   557: iload 4
    //   559: aload_2
    //   560: invokevirtual 314	org/json/JSONArray:length	()I
    //   563: if_icmpge +34 -> 597
    //   566: aload_0
    //   567: aload 5
    //   569: aload_2
    //   570: iload 4
    //   572: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   575: checkcast 139	org/json/JSONObject
    //   578: invokespecial 433	org/apache/cordova/ContactAccessorSdk5:insertWebsite	(Ljava/util/ArrayList;Lorg/json/JSONObject;)V
    //   581: iinc 4 1
    //   584: goto -27 -> 557
    //   587: astore_2
    //   588: ldc -73
    //   590: ldc_w 435
    //   593: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   596: pop
    //   597: aload_0
    //   598: aload_1
    //   599: ldc 110
    //   601: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   604: astore_2
    //   605: aload_2
    //   606: ifnull +48 -> 654
    //   609: aload 5
    //   611: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   614: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   617: ldc_w 377
    //   620: iconst_0
    //   621: invokevirtual 381	android/content/ContentProviderOperation$Builder:withValueBackReference	(Ljava/lang/String;I)Landroid/content/ContentProviderOperation$Builder;
    //   624: ldc_w 288
    //   627: ldc 112
    //   629: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   632: ldc 52
    //   634: iconst_3
    //   635: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   638: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   641: ldc 42
    //   643: aload_2
    //   644: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   647: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   650: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   653: pop
    //   654: aload_1
    //   655: ldc_w 443
    //   658: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   661: astore_1
    //   662: aload_1
    //   663: ifnull +46 -> 709
    //   666: iconst_0
    //   667: istore 4
    //   669: iload 4
    //   671: aload_1
    //   672: invokevirtual 314	org/json/JSONArray:length	()I
    //   675: if_icmpge +34 -> 709
    //   678: aload_0
    //   679: aload 5
    //   681: aload_1
    //   682: iload 4
    //   684: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   687: checkcast 139	org/json/JSONObject
    //   690: invokespecial 446	org/apache/cordova/ContactAccessorSdk5:insertPhoto	(Ljava/util/ArrayList;Lorg/json/JSONObject;)V
    //   693: iinc 4 1
    //   696: goto -27 -> 669
    //   699: astore_1
    //   700: ldc -73
    //   702: ldc_w 448
    //   705: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   708: pop
    //   709: aconst_null
    //   710: astore_2
    //   711: aload_0
    //   712: getfield 129	org/apache/cordova/ContactAccessorSdk5:mApp	Lorg/apache/cordova/api/CordovaInterface;
    //   715: invokeinterface 454 1 0
    //   720: invokevirtual 460	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   723: ldc_w 462
    //   726: aload 5
    //   728: invokevirtual 468	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   731: astore_3
    //   732: aload_2
    //   733: astore_1
    //   734: aload_3
    //   735: arraylength
    //   736: iflt +13 -> 749
    //   739: aload_3
    //   740: iconst_0
    //   741: aaload
    //   742: getfield 473	android/content/ContentProviderResult:uri	Landroid/net/Uri;
    //   745: invokevirtual 478	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   748: astore_1
    //   749: aload_1
    //   750: areturn
    //   751: astore_1
    //   752: ldc -73
    //   754: aload_1
    //   755: invokevirtual 479	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   758: aload_1
    //   759: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   762: pop
    //   763: aload_2
    //   764: astore_1
    //   765: goto -16 -> 749
    //   768: astore_1
    //   769: ldc -73
    //   771: aload_1
    //   772: invokevirtual 480	android/content/OperationApplicationException:getMessage	()Ljava/lang/String;
    //   775: aload_1
    //   776: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   779: pop
    //   780: aload_2
    //   781: astore_1
    //   782: goto -33 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	785	0	this	ContactAccessorSdk5
    //   0	785	1	paramJSONObject	JSONObject
    //   0	785	2	paramString1	String
    //   0	785	3	paramString2	String
    //   174	520	4	i	int
    //   7	720	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   38	52	206	org/json/JSONException
    //   60	162	206	org/json/JSONException
    //   162	169	219	org/json/JSONException
    //   176	200	219	org/json/JSONException
    //   229	236	273	org/json/JSONException
    //   243	267	273	org/json/JSONException
    //   283	290	327	org/json/JSONException
    //   297	321	327	org/json/JSONException
    //   337	344	381	org/json/JSONException
    //   351	375	381	org/json/JSONException
    //   391	398	435	org/json/JSONException
    //   405	429	435	org/json/JSONException
    //   543	550	587	org/json/JSONException
    //   557	581	587	org/json/JSONException
    //   654	662	699	org/json/JSONException
    //   669	693	699	org/json/JSONException
    //   711	732	751	android/os/RemoteException
    //   734	749	751	android/os/RemoteException
    //   711	732	768	android/content/OperationApplicationException
    //   734	749	768	android/content/OperationApplicationException
  }
  
  private JSONObject emailQuery(Cursor paramCursor)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCursor.getString(paramCursor.getColumnIndex("_id")));
      localJSONObject.put("pref", false);
      localJSONObject.put("value", paramCursor.getString(paramCursor.getColumnIndex("data1")));
      localJSONObject.put("type", getContactType(paramCursor.getInt(paramCursor.getColumnIndex("data2"))));
      return localJSONObject;
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
  }
  
  private int getAddressType(String paramString)
  {
    int j = 3;
    int i = j;
    if (paramString != null)
    {
      if (!"work".equals(paramString.toLowerCase())) {
        break label25;
      }
      i = 2;
    }
    for (;;)
    {
      return i;
      label25:
      if ("other".equals(paramString.toLowerCase()))
      {
        i = 3;
      }
      else
      {
        i = j;
        if ("home".equals(paramString.toLowerCase())) {
          i = 1;
        }
      }
    }
  }
  
  private String getAddressType(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "other";
    }
    for (;;)
    {
      return str;
      str = "home";
      continue;
      str = "work";
    }
  }
  
  private int getContactType(String paramString)
  {
    int j = 3;
    int i = j;
    if (paramString != null)
    {
      if (!"home".equals(paramString.toLowerCase())) {
        break label25;
      }
      i = 1;
    }
    for (;;)
    {
      return i;
      label25:
      if ("work".equals(paramString.toLowerCase()))
      {
        i = 2;
      }
      else if ("other".equals(paramString.toLowerCase()))
      {
        i = 3;
      }
      else if ("mobile".equals(paramString.toLowerCase()))
      {
        i = 4;
      }
      else
      {
        i = j;
        if ("custom".equals(paramString.toLowerCase())) {
          i = 0;
        }
      }
    }
  }
  
  private String getContactType(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 3: 
    default: 
      str = "other";
    }
    for (;;)
    {
      return str;
      str = "custom";
      continue;
      str = "home";
      continue;
      str = "work";
      continue;
      str = "mobile";
    }
  }
  
  private int getImType(String paramString)
  {
    int j = -1;
    int i = j;
    if (paramString != null)
    {
      if (!"aim".equals(paramString.toLowerCase())) {
        break label25;
      }
      i = 0;
    }
    for (;;)
    {
      return i;
      label25:
      if ("google talk".equals(paramString.toLowerCase()))
      {
        i = 5;
      }
      else if ("icq".equals(paramString.toLowerCase()))
      {
        i = 6;
      }
      else if ("jabber".equals(paramString.toLowerCase()))
      {
        i = 7;
      }
      else if ("msn".equals(paramString.toLowerCase()))
      {
        i = 1;
      }
      else if ("netmeeting".equals(paramString.toLowerCase()))
      {
        i = 8;
      }
      else if ("qq".equals(paramString.toLowerCase()))
      {
        i = 4;
      }
      else if ("skype".equals(paramString.toLowerCase()))
      {
        i = 3;
      }
      else
      {
        i = j;
        if ("yahoo".equals(paramString.toLowerCase())) {
          i = 2;
        }
      }
    }
  }
  
  private String getImType(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "custom";
    }
    for (;;)
    {
      return str;
      str = "AIM";
      continue;
      str = "Google Talk";
      continue;
      str = "ICQ";
      continue;
      str = "Jabber";
      continue;
      str = "MSN";
      continue;
      str = "NetMeeting";
      continue;
      str = "QQ";
      continue;
      str = "Skype";
      continue;
      str = "Yahoo";
    }
  }
  
  private int getOrgType(String paramString)
  {
    int j = 2;
    int i = j;
    if (paramString != null)
    {
      if (!"work".equals(paramString.toLowerCase())) {
        break label25;
      }
      i = 1;
    }
    for (;;)
    {
      return i;
      label25:
      if ("other".equals(paramString.toLowerCase()))
      {
        i = 2;
      }
      else
      {
        i = j;
        if ("custom".equals(paramString.toLowerCase())) {
          i = 0;
        }
      }
    }
  }
  
  private String getOrgType(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "other";
    }
    for (;;)
    {
      return str;
      str = "custom";
      continue;
      str = "work";
    }
  }
  
  private InputStream getPathFromUri(String paramString)
    throws IOException
  {
    if (paramString.startsWith("content:"))
    {
      paramString = Uri.parse(paramString);
      paramString = this.mApp.getActivity().getContentResolver().openInputStream(paramString);
    }
    for (;;)
    {
      return paramString;
      if ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("file:"))) {
        paramString = new URL(paramString).openStream();
      } else {
        paramString = new FileInputStream(paramString);
      }
    }
  }
  
  private int getPhoneType(String paramString)
  {
    int j = 7;
    int i = j;
    if (paramString != null)
    {
      if (!"home".equals(paramString.toLowerCase())) {
        break label26;
      }
      i = 1;
    }
    for (;;)
    {
      return i;
      label26:
      if ("mobile".equals(paramString.toLowerCase()))
      {
        i = 2;
      }
      else if ("work".equals(paramString.toLowerCase()))
      {
        i = 3;
      }
      else if ("work fax".equals(paramString.toLowerCase()))
      {
        i = 4;
      }
      else if ("home fax".equals(paramString.toLowerCase()))
      {
        i = 5;
      }
      else if ("fax".equals(paramString.toLowerCase()))
      {
        i = 4;
      }
      else if ("pager".equals(paramString.toLowerCase()))
      {
        i = 6;
      }
      else if ("other".equals(paramString.toLowerCase()))
      {
        i = 7;
      }
      else if ("car".equals(paramString.toLowerCase()))
      {
        i = 9;
      }
      else if ("company main".equals(paramString.toLowerCase()))
      {
        i = 10;
      }
      else if ("isdn".equals(paramString.toLowerCase()))
      {
        i = 11;
      }
      else if ("main".equals(paramString.toLowerCase()))
      {
        i = 12;
      }
      else if ("other fax".equals(paramString.toLowerCase()))
      {
        i = 13;
      }
      else if ("radio".equals(paramString.toLowerCase()))
      {
        i = 14;
      }
      else if ("telex".equals(paramString.toLowerCase()))
      {
        i = 15;
      }
      else if ("work mobile".equals(paramString.toLowerCase()))
      {
        i = 17;
      }
      else if ("work pager".equals(paramString.toLowerCase()))
      {
        i = 18;
      }
      else if ("assistant".equals(paramString.toLowerCase()))
      {
        i = 19;
      }
      else if ("mms".equals(paramString.toLowerCase()))
      {
        i = 20;
      }
      else if ("callback".equals(paramString.toLowerCase()))
      {
        i = 8;
      }
      else if ("tty ttd".equals(paramString.toLowerCase()))
      {
        i = 16;
      }
      else
      {
        i = j;
        if ("custom".equals(paramString.toLowerCase())) {
          i = 0;
        }
      }
    }
  }
  
  private String getPhoneType(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 7: 
    case 12: 
    default: 
      str = "other";
    }
    for (;;)
    {
      return str;
      str = "custom";
      continue;
      str = "home fax";
      continue;
      str = "work fax";
      continue;
      str = "home";
      continue;
      str = "mobile";
      continue;
      str = "pager";
      continue;
      str = "work";
      continue;
      str = "callback";
      continue;
      str = "car";
      continue;
      str = "company main";
      continue;
      str = "other fax";
      continue;
      str = "radio";
      continue;
      str = "telex";
      continue;
      str = "tty tdd";
      continue;
      str = "work mobile";
      continue;
      str = "work pager";
      continue;
      str = "assistant";
      continue;
      str = "mms";
      continue;
      str = "isdn";
    }
  }
  
  private byte[] getPhotoBytes(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    long l = 0L;
    try
    {
      byte[] arrayOfByte = new byte[' '];
      paramString = getPathFromUri(paramString);
      for (;;)
      {
        int i = paramString.read(arrayOfByte, 0, arrayOfByte.length);
        if ((i == -1) || (l > 1048576L)) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
        l += i;
      }
      paramString.close();
      localByteArrayOutputStream.flush();
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramString.getMessage(), paramString);
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramString.getMessage(), paramString);
      }
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  private JSONObject imQuery(Cursor paramCursor)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCursor.getString(paramCursor.getColumnIndex("_id")));
      localJSONObject.put("pref", false);
      localJSONObject.put("value", paramCursor.getString(paramCursor.getColumnIndex("data1")));
      localJSONObject.put("type", getImType(paramCursor.getString(paramCursor.getColumnIndex("data5"))));
      return localJSONObject;
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
  }
  
  private void insertAddress(ArrayList<ContentProviderOperation> paramArrayList, JSONObject paramJSONObject)
  {
    paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(getAddressType(getJsonString(paramJSONObject, "type")))).withValue("data1", getJsonString(paramJSONObject, "formatted")).withValue("data4", getJsonString(paramJSONObject, "streetAddress")).withValue("data7", getJsonString(paramJSONObject, "locality")).withValue("data8", getJsonString(paramJSONObject, "region")).withValue("data9", getJsonString(paramJSONObject, "postalCode")).withValue("data10", getJsonString(paramJSONObject, "country")).build());
  }
  
  private void insertEmail(ArrayList<ContentProviderOperation> paramArrayList, JSONObject paramJSONObject)
  {
    paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", getJsonString(paramJSONObject, "value")).withValue("data2", Integer.valueOf(getContactType(getJsonString(paramJSONObject, "type")))).build());
  }
  
  private void insertIm(ArrayList<ContentProviderOperation> paramArrayList, JSONObject paramJSONObject)
  {
    paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", getJsonString(paramJSONObject, "value")).withValue("data2", Integer.valueOf(getImType(getJsonString(paramJSONObject, "type")))).build());
  }
  
  private void insertOrganization(ArrayList<ContentProviderOperation> paramArrayList, JSONObject paramJSONObject)
  {
    paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data2", Integer.valueOf(getOrgType(getJsonString(paramJSONObject, "type")))).withValue("data5", getJsonString(paramJSONObject, "department")).withValue("data1", getJsonString(paramJSONObject, "name")).withValue("data4", getJsonString(paramJSONObject, "title")).build());
  }
  
  private void insertPhone(ArrayList<ContentProviderOperation> paramArrayList, JSONObject paramJSONObject)
  {
    paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", getJsonString(paramJSONObject, "value")).withValue("data2", Integer.valueOf(getPhoneType(getJsonString(paramJSONObject, "type")))).build());
  }
  
  private void insertPhoto(ArrayList<ContentProviderOperation> paramArrayList, JSONObject paramJSONObject)
  {
    paramJSONObject = getPhotoBytes(getJsonString(paramJSONObject, "value"));
    paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("is_super_primary", Integer.valueOf(1)).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", paramJSONObject).build());
  }
  
  private void insertWebsite(ArrayList<ContentProviderOperation> paramArrayList, JSONObject paramJSONObject)
  {
    paramArrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", getJsonString(paramJSONObject, "value")).withValue("data2", Integer.valueOf(getContactType(getJsonString(paramJSONObject, "type")))).build());
  }
  
  private boolean isWildCardSearch(JSONArray paramJSONArray)
  {
    boolean bool1 = true;
    if (paramJSONArray.length() == 1) {}
    for (;;)
    {
      try
      {
        boolean bool2 = "*".equals(paramJSONArray.getString(0));
        if (!bool2) {
          break label34;
        }
      }
      catch (JSONException paramJSONArray)
      {
        bool1 = false;
        continue;
      }
      return bool1;
      label34:
      bool1 = false;
    }
  }
  
  /* Error */
  private String modifyContact(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 437	java/lang/Integer
    //   3: dup
    //   4: aload_0
    //   5: aload_2
    //   6: ldc_w 667
    //   9: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   12: invokespecial 668	java/lang/Integer:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 671	java/lang/Integer:intValue	()I
    //   18: istore 6
    //   20: new 268	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 269	java/util/ArrayList:<init>	()V
    //   27: astore 7
    //   29: aload 7
    //   31: getstatic 345	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   34: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   37: ldc_w 353
    //   40: aload_3
    //   41: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   44: ldc_w 361
    //   47: aload 4
    //   49: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   52: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   55: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: aload_0
    //   60: aload_2
    //   61: ldc 36
    //   63: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 8
    //   68: aload_2
    //   69: ldc 40
    //   71: invokevirtual 677	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   74: astore 4
    //   76: aload 8
    //   78: ifnonnull +8 -> 86
    //   81: aload 4
    //   83: ifnull +179 -> 262
    //   86: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   89: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   92: ldc_w 679
    //   95: iconst_2
    //   96: anewarray 204	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: ldc_w 292
    //   108: aastore
    //   109: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   112: astore_3
    //   113: aload 8
    //   115: ifnull +12 -> 127
    //   118: aload_3
    //   119: ldc 42
    //   121: aload 8
    //   123: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   126: pop
    //   127: aload_0
    //   128: aload 4
    //   130: ldc_w 383
    //   133: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 8
    //   138: aload 8
    //   140: ifnull +12 -> 152
    //   143: aload_3
    //   144: ldc 48
    //   146: aload 8
    //   148: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   151: pop
    //   152: aload_0
    //   153: aload 4
    //   155: ldc_w 389
    //   158: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 8
    //   163: aload 8
    //   165: ifnull +12 -> 177
    //   168: aload_3
    //   169: ldc 56
    //   171: aload 8
    //   173: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   176: pop
    //   177: aload_0
    //   178: aload 4
    //   180: ldc_w 391
    //   183: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 8
    //   188: aload 8
    //   190: ifnull +12 -> 202
    //   193: aload_3
    //   194: ldc 52
    //   196: aload 8
    //   198: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   201: pop
    //   202: aload_0
    //   203: aload 4
    //   205: ldc_w 393
    //   208: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   211: astore 8
    //   213: aload 8
    //   215: ifnull +12 -> 227
    //   218: aload_3
    //   219: ldc 60
    //   221: aload 8
    //   223: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   226: pop
    //   227: aload_0
    //   228: aload 4
    //   230: ldc_w 395
    //   233: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 4
    //   238: aload 4
    //   240: ifnull +12 -> 252
    //   243: aload_3
    //   244: ldc 64
    //   246: aload 4
    //   248: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   251: pop
    //   252: aload 7
    //   254: aload_3
    //   255: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   258: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   261: pop
    //   262: aload_2
    //   263: ldc 68
    //   265: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   268: astore 4
    //   270: aload 4
    //   272: ifnull +72 -> 344
    //   275: aload 4
    //   277: invokevirtual 314	org/json/JSONArray:length	()I
    //   280: ifne +774 -> 1054
    //   283: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   286: invokestatic 686	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   289: astore 4
    //   291: new 238	java/lang/StringBuilder
    //   294: astore_3
    //   295: aload_3
    //   296: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   299: aload 7
    //   301: aload 4
    //   303: ldc_w 688
    //   306: iconst_2
    //   307: anewarray 204	java/lang/String
    //   310: dup
    //   311: iconst_0
    //   312: aload_3
    //   313: ldc_w 690
    //   316: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload 6
    //   321: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: ldc_w 296
    //   333: aastore
    //   334: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   337: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   340: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   343: pop
    //   344: aload_2
    //   345: ldc 72
    //   347: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   350: astore_3
    //   351: aload_3
    //   352: ifnull +71 -> 423
    //   355: aload_3
    //   356: invokevirtual 314	org/json/JSONArray:length	()I
    //   359: ifne +913 -> 1272
    //   362: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   365: invokestatic 686	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   368: astore 4
    //   370: new 238	java/lang/StringBuilder
    //   373: astore_3
    //   374: aload_3
    //   375: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   378: aload 7
    //   380: aload 4
    //   382: ldc_w 688
    //   385: iconst_2
    //   386: anewarray 204	java/lang/String
    //   389: dup
    //   390: iconst_0
    //   391: aload_3
    //   392: ldc_w 690
    //   395: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: iload 6
    //   400: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: aastore
    //   407: dup
    //   408: iconst_1
    //   409: ldc_w 298
    //   412: aastore
    //   413: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   416: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   419: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   422: pop
    //   423: aload_2
    //   424: ldc 76
    //   426: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   429: astore 4
    //   431: aload 4
    //   433: ifnull +73 -> 506
    //   436: aload 4
    //   438: invokevirtual 314	org/json/JSONArray:length	()I
    //   441: ifne +1053 -> 1494
    //   444: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   447: invokestatic 686	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   450: astore_3
    //   451: new 238	java/lang/StringBuilder
    //   454: astore 4
    //   456: aload 4
    //   458: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   461: aload 7
    //   463: aload_3
    //   464: ldc_w 688
    //   467: iconst_2
    //   468: anewarray 204	java/lang/String
    //   471: dup
    //   472: iconst_0
    //   473: aload 4
    //   475: ldc_w 690
    //   478: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: iload 6
    //   483: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   486: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: aastore
    //   490: dup
    //   491: iconst_1
    //   492: ldc_w 300
    //   495: aastore
    //   496: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   499: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   502: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   505: pop
    //   506: aload_2
    //   507: ldc 102
    //   509: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   512: astore_3
    //   513: aload_3
    //   514: ifnull +72 -> 586
    //   517: aload_3
    //   518: invokevirtual 314	org/json/JSONArray:length	()I
    //   521: ifne +1319 -> 1840
    //   524: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   527: invokestatic 686	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   530: astore_3
    //   531: new 238	java/lang/StringBuilder
    //   534: astore 4
    //   536: aload 4
    //   538: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   541: aload 7
    //   543: aload_3
    //   544: ldc_w 688
    //   547: iconst_2
    //   548: anewarray 204	java/lang/String
    //   551: dup
    //   552: iconst_0
    //   553: aload 4
    //   555: ldc_w 690
    //   558: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload 6
    //   563: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: ldc_w 304
    //   575: aastore
    //   576: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   579: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   582: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   585: pop
    //   586: aload_2
    //   587: ldc 98
    //   589: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   592: astore 4
    //   594: aload 4
    //   596: ifnull +73 -> 669
    //   599: aload 4
    //   601: invokevirtual 314	org/json/JSONArray:length	()I
    //   604: ifne +1516 -> 2120
    //   607: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   610: invokestatic 686	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   613: astore_3
    //   614: new 238	java/lang/StringBuilder
    //   617: astore 4
    //   619: aload 4
    //   621: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   624: aload 7
    //   626: aload_3
    //   627: ldc_w 688
    //   630: iconst_2
    //   631: anewarray 204	java/lang/String
    //   634: dup
    //   635: iconst_0
    //   636: aload 4
    //   638: ldc_w 690
    //   641: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: iload 6
    //   646: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   649: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: aastore
    //   653: dup
    //   654: iconst_1
    //   655: ldc_w 302
    //   658: aastore
    //   659: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   662: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   665: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   668: pop
    //   669: aload_0
    //   670: aload_2
    //   671: ldc 114
    //   673: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   676: astore_3
    //   677: aload 7
    //   679: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   682: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   685: ldc_w 679
    //   688: iconst_2
    //   689: anewarray 204	java/lang/String
    //   692: dup
    //   693: iconst_0
    //   694: aload_1
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: ldc_w 306
    //   701: aastore
    //   702: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   705: ldc 42
    //   707: aload_3
    //   708: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   711: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   714: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   717: pop
    //   718: aload_0
    //   719: aload_2
    //   720: ldc 66
    //   722: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   725: astore_3
    //   726: aload_3
    //   727: ifnull +44 -> 771
    //   730: aload 7
    //   732: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   735: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   738: ldc_w 679
    //   741: iconst_2
    //   742: anewarray 204	java/lang/String
    //   745: dup
    //   746: iconst_0
    //   747: aload_1
    //   748: aastore
    //   749: dup
    //   750: iconst_1
    //   751: ldc_w 294
    //   754: aastore
    //   755: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   758: ldc 42
    //   760: aload_3
    //   761: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   764: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   767: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   770: pop
    //   771: aload_2
    //   772: ldc 120
    //   774: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   777: astore_3
    //   778: aload_3
    //   779: ifnull +80 -> 859
    //   782: aload_3
    //   783: invokevirtual 314	org/json/JSONArray:length	()I
    //   786: ifne +1552 -> 2338
    //   789: ldc -73
    //   791: ldc_w 695
    //   794: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   797: pop
    //   798: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   801: invokestatic 686	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   804: astore 4
    //   806: new 238	java/lang/StringBuilder
    //   809: astore_3
    //   810: aload_3
    //   811: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   814: aload 7
    //   816: aload 4
    //   818: ldc_w 688
    //   821: iconst_2
    //   822: anewarray 204	java/lang/String
    //   825: dup
    //   826: iconst_0
    //   827: aload_3
    //   828: ldc_w 690
    //   831: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: iload 6
    //   836: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   839: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: aastore
    //   843: dup
    //   844: iconst_1
    //   845: ldc_w 308
    //   848: aastore
    //   849: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   852: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   855: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   858: pop
    //   859: aload_0
    //   860: aload_2
    //   861: ldc 110
    //   863: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   866: astore_3
    //   867: aload_3
    //   868: ifnull +65 -> 933
    //   871: aload 7
    //   873: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   876: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   879: ldc_w 697
    //   882: iconst_3
    //   883: anewarray 204	java/lang/String
    //   886: dup
    //   887: iconst_0
    //   888: aload_1
    //   889: aastore
    //   890: dup
    //   891: iconst_1
    //   892: ldc 112
    //   894: aastore
    //   895: dup
    //   896: iconst_2
    //   897: new 204	java/lang/String
    //   900: dup
    //   901: ldc_w 699
    //   904: invokespecial 700	java/lang/String:<init>	(Ljava/lang/String;)V
    //   907: aastore
    //   908: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   911: ldc 52
    //   913: iconst_3
    //   914: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   917: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   920: ldc 42
    //   922: aload_3
    //   923: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   926: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   929: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   932: pop
    //   933: aload_2
    //   934: ldc_w 443
    //   937: invokevirtual 399	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   940: astore_2
    //   941: aload_2
    //   942: ifnull +68 -> 1010
    //   945: aload_2
    //   946: invokevirtual 314	org/json/JSONArray:length	()I
    //   949: ifne +1611 -> 2560
    //   952: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   955: invokestatic 686	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   958: astore_3
    //   959: new 238	java/lang/StringBuilder
    //   962: astore_2
    //   963: aload_2
    //   964: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   967: aload 7
    //   969: aload_3
    //   970: ldc_w 688
    //   973: iconst_2
    //   974: anewarray 204	java/lang/String
    //   977: dup
    //   978: iconst_0
    //   979: aload_2
    //   980: ldc_w 690
    //   983: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: iload 6
    //   988: invokevirtual 693	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   991: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: aastore
    //   995: dup
    //   996: iconst_1
    //   997: ldc 118
    //   999: aastore
    //   1000: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   1003: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1006: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1009: pop
    //   1010: iconst_1
    //   1011: istore 5
    //   1013: aload_0
    //   1014: getfield 129	org/apache/cordova/ContactAccessorSdk5:mApp	Lorg/apache/cordova/api/CordovaInterface;
    //   1017: invokeinterface 454 1 0
    //   1022: invokevirtual 460	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   1025: ldc_w 462
    //   1028: aload 7
    //   1030: invokevirtual 468	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   1033: pop
    //   1034: iload 5
    //   1036: ifeq +1775 -> 2811
    //   1039: aload_1
    //   1040: areturn
    //   1041: astore_3
    //   1042: ldc -73
    //   1044: ldc_w 702
    //   1047: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1050: pop
    //   1051: goto -789 -> 262
    //   1054: iconst_0
    //   1055: istore 5
    //   1057: iload 5
    //   1059: aload 4
    //   1061: invokevirtual 314	org/json/JSONArray:length	()I
    //   1064: if_icmpge -720 -> 344
    //   1067: aload 4
    //   1069: iload 5
    //   1071: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1074: checkcast 139	org/json/JSONObject
    //   1077: astore_3
    //   1078: aload_0
    //   1079: aload_3
    //   1080: ldc 26
    //   1082: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1085: astore 8
    //   1087: aload 8
    //   1089: ifnonnull +99 -> 1188
    //   1092: new 704	android/content/ContentValues
    //   1095: astore 8
    //   1097: aload 8
    //   1099: invokespecial 705	android/content/ContentValues:<init>	()V
    //   1102: aload 8
    //   1104: ldc_w 377
    //   1107: iload 6
    //   1109: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1112: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1115: aload 8
    //   1117: ldc_w 288
    //   1120: ldc_w 296
    //   1123: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload 8
    //   1128: ldc 42
    //   1130: aload_0
    //   1131: aload_3
    //   1132: ldc_w 483
    //   1135: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1138: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1141: aload 8
    //   1143: ldc 52
    //   1145: aload_0
    //   1146: aload_0
    //   1147: aload_3
    //   1148: ldc -94
    //   1150: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1153: invokespecial 655	org/apache/cordova/ContactAccessorSdk5:getPhoneType	(Ljava/lang/String;)I
    //   1156: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1159: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1162: aload 7
    //   1164: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1167: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   1170: aload 8
    //   1172: invokevirtual 715	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   1175: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1178: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1181: pop
    //   1182: iinc 5 1
    //   1185: goto -128 -> 1057
    //   1188: aload 7
    //   1190: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1193: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   1196: ldc_w 717
    //   1199: iconst_2
    //   1200: anewarray 204	java/lang/String
    //   1203: dup
    //   1204: iconst_0
    //   1205: aload 8
    //   1207: aastore
    //   1208: dup
    //   1209: iconst_1
    //   1210: ldc_w 296
    //   1213: aastore
    //   1214: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   1217: ldc 42
    //   1219: aload_0
    //   1220: aload_3
    //   1221: ldc_w 483
    //   1224: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1227: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1230: ldc 52
    //   1232: aload_0
    //   1233: aload_0
    //   1234: aload_3
    //   1235: ldc -94
    //   1237: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1240: invokespecial 655	org/apache/cordova/ContactAccessorSdk5:getPhoneType	(Ljava/lang/String;)I
    //   1243: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1246: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1249: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1252: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1255: pop
    //   1256: goto -74 -> 1182
    //   1259: astore_3
    //   1260: ldc -73
    //   1262: ldc_w 412
    //   1265: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1268: pop
    //   1269: goto -925 -> 344
    //   1272: iconst_0
    //   1273: istore 5
    //   1275: iload 5
    //   1277: aload_3
    //   1278: invokevirtual 314	org/json/JSONArray:length	()I
    //   1281: if_icmpge -858 -> 423
    //   1284: aload_3
    //   1285: iload 5
    //   1287: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1290: checkcast 139	org/json/JSONObject
    //   1293: astore 4
    //   1295: aload_0
    //   1296: aload 4
    //   1298: ldc 26
    //   1300: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1303: astore 8
    //   1305: aload 8
    //   1307: ifnonnull +101 -> 1408
    //   1310: new 704	android/content/ContentValues
    //   1313: astore 8
    //   1315: aload 8
    //   1317: invokespecial 705	android/content/ContentValues:<init>	()V
    //   1320: aload 8
    //   1322: ldc_w 377
    //   1325: iload 6
    //   1327: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1330: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1333: aload 8
    //   1335: ldc_w 288
    //   1338: ldc_w 298
    //   1341: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1344: aload 8
    //   1346: ldc 42
    //   1348: aload_0
    //   1349: aload 4
    //   1351: ldc_w 483
    //   1354: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1357: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1360: aload 8
    //   1362: ldc 52
    //   1364: aload_0
    //   1365: aload_0
    //   1366: aload 4
    //   1368: ldc -94
    //   1370: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1373: invokespecial 647	org/apache/cordova/ContactAccessorSdk5:getContactType	(Ljava/lang/String;)I
    //   1376: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1379: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1382: aload 7
    //   1384: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1387: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   1390: aload 8
    //   1392: invokevirtual 715	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   1395: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1398: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1401: pop
    //   1402: iinc 5 1
    //   1405: goto -130 -> 1275
    //   1408: aload 7
    //   1410: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1413: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   1416: ldc_w 717
    //   1419: iconst_2
    //   1420: anewarray 204	java/lang/String
    //   1423: dup
    //   1424: iconst_0
    //   1425: aload 8
    //   1427: aastore
    //   1428: dup
    //   1429: iconst_1
    //   1430: ldc_w 298
    //   1433: aastore
    //   1434: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   1437: ldc 42
    //   1439: aload_0
    //   1440: aload 4
    //   1442: ldc_w 483
    //   1445: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1448: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1451: ldc 52
    //   1453: aload_0
    //   1454: aload_0
    //   1455: aload 4
    //   1457: ldc -94
    //   1459: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1462: invokespecial 647	org/apache/cordova/ContactAccessorSdk5:getContactType	(Ljava/lang/String;)I
    //   1465: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1468: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1471: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1474: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1477: pop
    //   1478: goto -76 -> 1402
    //   1481: astore_3
    //   1482: ldc -73
    //   1484: ldc_w 417
    //   1487: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1490: pop
    //   1491: goto -1068 -> 423
    //   1494: iconst_0
    //   1495: istore 5
    //   1497: iload 5
    //   1499: aload 4
    //   1501: invokevirtual 314	org/json/JSONArray:length	()I
    //   1504: if_icmpge -998 -> 506
    //   1507: aload 4
    //   1509: iload 5
    //   1511: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1514: checkcast 139	org/json/JSONObject
    //   1517: astore_3
    //   1518: aload_0
    //   1519: aload_3
    //   1520: ldc 26
    //   1522: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1525: astore 8
    //   1527: aload 8
    //   1529: ifnonnull +168 -> 1697
    //   1532: new 704	android/content/ContentValues
    //   1535: astore 8
    //   1537: aload 8
    //   1539: invokespecial 705	android/content/ContentValues:<init>	()V
    //   1542: aload 8
    //   1544: ldc_w 377
    //   1547: iload 6
    //   1549: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1552: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1555: aload 8
    //   1557: ldc_w 288
    //   1560: ldc_w 300
    //   1563: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1566: aload 8
    //   1568: ldc 52
    //   1570: aload_0
    //   1571: aload_0
    //   1572: aload_3
    //   1573: ldc -94
    //   1575: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1578: invokespecial 644	org/apache/cordova/ContactAccessorSdk5:getAddressType	(Ljava/lang/String;)I
    //   1581: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1584: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1587: aload 8
    //   1589: ldc 42
    //   1591: aload_0
    //   1592: aload_3
    //   1593: ldc -85
    //   1595: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1598: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1601: aload 8
    //   1603: ldc 60
    //   1605: aload_0
    //   1606: aload_3
    //   1607: ldc -83
    //   1609: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1612: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1615: aload 8
    //   1617: ldc 84
    //   1619: aload_0
    //   1620: aload_3
    //   1621: ldc -81
    //   1623: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1626: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1629: aload 8
    //   1631: ldc 88
    //   1633: aload_0
    //   1634: aload_3
    //   1635: ldc -79
    //   1637: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1640: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1643: aload 8
    //   1645: ldc 92
    //   1647: aload_0
    //   1648: aload_3
    //   1649: ldc -77
    //   1651: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1654: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1657: aload 8
    //   1659: ldc 96
    //   1661: aload_0
    //   1662: aload_3
    //   1663: ldc -75
    //   1665: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1668: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1671: aload 7
    //   1673: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1676: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   1679: aload 8
    //   1681: invokevirtual 715	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   1684: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1687: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1690: pop
    //   1691: iinc 5 1
    //   1694: goto -197 -> 1497
    //   1697: aload 7
    //   1699: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1702: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   1705: ldc_w 717
    //   1708: iconst_2
    //   1709: anewarray 204	java/lang/String
    //   1712: dup
    //   1713: iconst_0
    //   1714: aload 8
    //   1716: aastore
    //   1717: dup
    //   1718: iconst_1
    //   1719: ldc_w 300
    //   1722: aastore
    //   1723: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   1726: ldc 52
    //   1728: aload_0
    //   1729: aload_0
    //   1730: aload_3
    //   1731: ldc -94
    //   1733: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1736: invokespecial 644	org/apache/cordova/ContactAccessorSdk5:getAddressType	(Ljava/lang/String;)I
    //   1739: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1742: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1745: ldc 42
    //   1747: aload_0
    //   1748: aload_3
    //   1749: ldc -85
    //   1751: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1754: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1757: ldc 60
    //   1759: aload_0
    //   1760: aload_3
    //   1761: ldc -83
    //   1763: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1766: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1769: ldc 84
    //   1771: aload_0
    //   1772: aload_3
    //   1773: ldc -81
    //   1775: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1778: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1781: ldc 88
    //   1783: aload_0
    //   1784: aload_3
    //   1785: ldc -79
    //   1787: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1790: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1793: ldc 92
    //   1795: aload_0
    //   1796: aload_3
    //   1797: ldc -77
    //   1799: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1802: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1805: ldc 96
    //   1807: aload_0
    //   1808: aload_3
    //   1809: ldc -75
    //   1811: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1814: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   1817: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1820: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1823: pop
    //   1824: goto -133 -> 1691
    //   1827: astore_3
    //   1828: ldc -73
    //   1830: ldc_w 422
    //   1833: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1836: pop
    //   1837: goto -1331 -> 506
    //   1840: iconst_0
    //   1841: istore 5
    //   1843: iload 5
    //   1845: aload_3
    //   1846: invokevirtual 314	org/json/JSONArray:length	()I
    //   1849: if_icmpge -1263 -> 586
    //   1852: aload_3
    //   1853: iload 5
    //   1855: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   1858: checkcast 139	org/json/JSONObject
    //   1861: astore 4
    //   1863: aload_0
    //   1864: aload 4
    //   1866: ldc 26
    //   1868: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1871: astore 8
    //   1873: aload 8
    //   1875: ifnonnull +132 -> 2007
    //   1878: new 704	android/content/ContentValues
    //   1881: astore 8
    //   1883: aload 8
    //   1885: invokespecial 705	android/content/ContentValues:<init>	()V
    //   1888: aload 8
    //   1890: ldc_w 377
    //   1893: iload 6
    //   1895: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1898: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1901: aload 8
    //   1903: ldc_w 288
    //   1906: ldc_w 304
    //   1909: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1912: aload 8
    //   1914: ldc 52
    //   1916: aload_0
    //   1917: aload_0
    //   1918: aload 4
    //   1920: ldc -94
    //   1922: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1925: invokespecial 649	org/apache/cordova/ContactAccessorSdk5:getOrgType	(Ljava/lang/String;)I
    //   1928: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1931: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1934: aload 8
    //   1936: ldc 56
    //   1938: aload_0
    //   1939: aload 4
    //   1941: ldc_w 651
    //   1944: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1947: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1950: aload 8
    //   1952: ldc 42
    //   1954: aload_0
    //   1955: aload 4
    //   1957: ldc 40
    //   1959: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1962: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1965: aload 8
    //   1967: ldc 60
    //   1969: aload_0
    //   1970: aload 4
    //   1972: ldc_w 653
    //   1975: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1978: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1981: aload 7
    //   1983: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1986: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   1989: aload 8
    //   1991: invokevirtual 715	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   1994: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   1997: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2000: pop
    //   2001: iinc 5 1
    //   2004: goto -161 -> 1843
    //   2007: aload 7
    //   2009: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2012: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   2015: ldc_w 717
    //   2018: iconst_2
    //   2019: anewarray 204	java/lang/String
    //   2022: dup
    //   2023: iconst_0
    //   2024: aload 8
    //   2026: aastore
    //   2027: dup
    //   2028: iconst_1
    //   2029: ldc_w 304
    //   2032: aastore
    //   2033: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   2036: ldc 52
    //   2038: aload_0
    //   2039: aload_0
    //   2040: aload 4
    //   2042: ldc -94
    //   2044: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2047: invokespecial 649	org/apache/cordova/ContactAccessorSdk5:getOrgType	(Ljava/lang/String;)I
    //   2050: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2053: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2056: ldc 56
    //   2058: aload_0
    //   2059: aload 4
    //   2061: ldc_w 651
    //   2064: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2067: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2070: ldc 42
    //   2072: aload_0
    //   2073: aload 4
    //   2075: ldc 40
    //   2077: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2080: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2083: ldc 60
    //   2085: aload_0
    //   2086: aload 4
    //   2088: ldc_w 653
    //   2091: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2094: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2097: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   2100: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2103: pop
    //   2104: goto -103 -> 2001
    //   2107: astore_3
    //   2108: ldc -73
    //   2110: ldc_w 427
    //   2113: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2116: pop
    //   2117: goto -1531 -> 586
    //   2120: iconst_0
    //   2121: istore 5
    //   2123: iload 5
    //   2125: aload 4
    //   2127: invokevirtual 314	org/json/JSONArray:length	()I
    //   2130: if_icmpge -1461 -> 669
    //   2133: aload 4
    //   2135: iload 5
    //   2137: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   2140: checkcast 139	org/json/JSONObject
    //   2143: astore_3
    //   2144: aload_0
    //   2145: aload_3
    //   2146: ldc 26
    //   2148: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2151: astore 8
    //   2153: aload 8
    //   2155: ifnonnull +99 -> 2254
    //   2158: new 704	android/content/ContentValues
    //   2161: astore 8
    //   2163: aload 8
    //   2165: invokespecial 705	android/content/ContentValues:<init>	()V
    //   2168: aload 8
    //   2170: ldc_w 377
    //   2173: iload 6
    //   2175: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2178: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2181: aload 8
    //   2183: ldc_w 288
    //   2186: ldc_w 302
    //   2189: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2192: aload 8
    //   2194: ldc 42
    //   2196: aload_0
    //   2197: aload_3
    //   2198: ldc_w 483
    //   2201: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2204: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2207: aload 8
    //   2209: ldc 52
    //   2211: aload_0
    //   2212: aload_0
    //   2213: aload_3
    //   2214: ldc -94
    //   2216: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2219: invokespecial 639	org/apache/cordova/ContactAccessorSdk5:getImType	(Ljava/lang/String;)I
    //   2222: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2225: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2228: aload 7
    //   2230: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2233: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   2236: aload 8
    //   2238: invokevirtual 715	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   2241: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   2244: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2247: pop
    //   2248: iinc 5 1
    //   2251: goto -128 -> 2123
    //   2254: aload 7
    //   2256: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2259: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   2262: ldc_w 717
    //   2265: iconst_2
    //   2266: anewarray 204	java/lang/String
    //   2269: dup
    //   2270: iconst_0
    //   2271: aload 8
    //   2273: aastore
    //   2274: dup
    //   2275: iconst_1
    //   2276: ldc_w 302
    //   2279: aastore
    //   2280: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   2283: ldc 42
    //   2285: aload_0
    //   2286: aload_3
    //   2287: ldc_w 483
    //   2290: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2293: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2296: ldc 52
    //   2298: aload_0
    //   2299: aload_0
    //   2300: aload_3
    //   2301: ldc -94
    //   2303: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2306: invokespecial 647	org/apache/cordova/ContactAccessorSdk5:getContactType	(Ljava/lang/String;)I
    //   2309: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2312: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2315: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   2318: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2321: pop
    //   2322: goto -74 -> 2248
    //   2325: astore_3
    //   2326: ldc -73
    //   2328: ldc_w 417
    //   2331: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2334: pop
    //   2335: goto -1666 -> 669
    //   2338: iconst_0
    //   2339: istore 5
    //   2341: iload 5
    //   2343: aload_3
    //   2344: invokevirtual 314	org/json/JSONArray:length	()I
    //   2347: if_icmpge -1488 -> 859
    //   2350: aload_3
    //   2351: iload 5
    //   2353: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   2356: checkcast 139	org/json/JSONObject
    //   2359: astore 4
    //   2361: aload_0
    //   2362: aload 4
    //   2364: ldc 26
    //   2366: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2369: astore 8
    //   2371: aload 8
    //   2373: ifnonnull +101 -> 2474
    //   2376: new 704	android/content/ContentValues
    //   2379: astore 8
    //   2381: aload 8
    //   2383: invokespecial 705	android/content/ContentValues:<init>	()V
    //   2386: aload 8
    //   2388: ldc_w 377
    //   2391: iload 6
    //   2393: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2396: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2399: aload 8
    //   2401: ldc_w 288
    //   2404: ldc_w 308
    //   2407: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2410: aload 8
    //   2412: ldc 42
    //   2414: aload_0
    //   2415: aload 4
    //   2417: ldc_w 483
    //   2420: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2423: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2426: aload 8
    //   2428: ldc 52
    //   2430: aload_0
    //   2431: aload_0
    //   2432: aload 4
    //   2434: ldc -94
    //   2436: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2439: invokespecial 647	org/apache/cordova/ContactAccessorSdk5:getContactType	(Ljava/lang/String;)I
    //   2442: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2445: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2448: aload 7
    //   2450: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2453: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   2456: aload 8
    //   2458: invokevirtual 715	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   2461: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   2464: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2467: pop
    //   2468: iinc 5 1
    //   2471: goto -130 -> 2341
    //   2474: aload 7
    //   2476: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2479: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   2482: ldc_w 717
    //   2485: iconst_2
    //   2486: anewarray 204	java/lang/String
    //   2489: dup
    //   2490: iconst_0
    //   2491: aload 8
    //   2493: aastore
    //   2494: dup
    //   2495: iconst_1
    //   2496: ldc_w 308
    //   2499: aastore
    //   2500: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   2503: ldc 42
    //   2505: aload_0
    //   2506: aload 4
    //   2508: ldc_w 483
    //   2511: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2514: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2517: ldc 52
    //   2519: aload_0
    //   2520: aload_0
    //   2521: aload 4
    //   2523: ldc -94
    //   2525: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2528: invokespecial 647	org/apache/cordova/ContactAccessorSdk5:getContactType	(Ljava/lang/String;)I
    //   2531: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2534: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2537: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   2540: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2543: pop
    //   2544: goto -76 -> 2468
    //   2547: astore_3
    //   2548: ldc -73
    //   2550: ldc_w 435
    //   2553: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2556: pop
    //   2557: goto -1698 -> 859
    //   2560: iconst_0
    //   2561: istore 5
    //   2563: iload 5
    //   2565: aload_2
    //   2566: invokevirtual 314	org/json/JSONArray:length	()I
    //   2569: if_icmpge -1559 -> 1010
    //   2572: aload_2
    //   2573: iload 5
    //   2575: invokevirtual 400	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   2578: checkcast 139	org/json/JSONObject
    //   2581: astore 4
    //   2583: aload_0
    //   2584: aload 4
    //   2586: ldc 26
    //   2588: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2591: astore_3
    //   2592: aload_0
    //   2593: aload_0
    //   2594: aload 4
    //   2596: ldc_w 483
    //   2599: invokevirtual 387	org/apache/cordova/ContactAccessorSdk5:getJsonString	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   2602: invokespecial 657	org/apache/cordova/ContactAccessorSdk5:getPhotoBytes	(Ljava/lang/String;)[B
    //   2605: astore 4
    //   2607: aload_3
    //   2608: ifnonnull +77 -> 2685
    //   2611: new 704	android/content/ContentValues
    //   2614: astore_3
    //   2615: aload_3
    //   2616: invokespecial 705	android/content/ContentValues:<init>	()V
    //   2619: aload_3
    //   2620: ldc_w 377
    //   2623: iload 6
    //   2625: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2628: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2631: aload_3
    //   2632: ldc_w 288
    //   2635: ldc 118
    //   2637: invokevirtual 711	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2640: aload_3
    //   2641: ldc_w 659
    //   2644: iconst_1
    //   2645: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2648: invokevirtual 708	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2651: aload_3
    //   2652: ldc_w 661
    //   2655: aload 4
    //   2657: invokevirtual 720	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   2660: aload 7
    //   2662: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2665: invokestatic 351	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   2668: aload_3
    //   2669: invokevirtual 715	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   2672: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   2675: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2678: pop
    //   2679: iinc 5 1
    //   2682: goto -119 -> 2563
    //   2685: aload 7
    //   2687: getstatic 375	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2690: invokestatic 674	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   2693: ldc_w 717
    //   2696: iconst_2
    //   2697: anewarray 204	java/lang/String
    //   2700: dup
    //   2701: iconst_0
    //   2702: aload_3
    //   2703: aastore
    //   2704: dup
    //   2705: iconst_1
    //   2706: ldc 118
    //   2708: aastore
    //   2709: invokevirtual 683	android/content/ContentProviderOperation$Builder:withSelection	(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/ContentProviderOperation$Builder;
    //   2712: ldc_w 659
    //   2715: iconst_1
    //   2716: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2719: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2722: ldc_w 661
    //   2725: aload 4
    //   2727: invokevirtual 359	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   2730: invokevirtual 365	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   2733: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2736: pop
    //   2737: goto -58 -> 2679
    //   2740: astore_2
    //   2741: ldc -73
    //   2743: ldc_w 448
    //   2746: invokestatic 410	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2749: pop
    //   2750: goto -1740 -> 1010
    //   2753: astore_2
    //   2754: ldc -73
    //   2756: aload_2
    //   2757: invokevirtual 479	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   2760: aload_2
    //   2761: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   2764: pop
    //   2765: ldc -73
    //   2767: aload_2
    //   2768: invokestatic 724	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2771: aload_2
    //   2772: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   2775: pop
    //   2776: iconst_0
    //   2777: istore 5
    //   2779: goto -1745 -> 1034
    //   2782: astore_2
    //   2783: ldc -73
    //   2785: aload_2
    //   2786: invokevirtual 480	android/content/OperationApplicationException:getMessage	()Ljava/lang/String;
    //   2789: aload_2
    //   2790: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   2793: pop
    //   2794: ldc -73
    //   2796: aload_2
    //   2797: invokestatic 724	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2800: aload_2
    //   2801: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   2804: pop
    //   2805: iconst_0
    //   2806: istore 5
    //   2808: goto -1774 -> 1034
    //   2811: aconst_null
    //   2812: astore_1
    //   2813: goto -1774 -> 1039
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2816	0	this	ContactAccessorSdk5
    //   0	2816	1	paramString1	String
    //   0	2816	2	paramJSONObject	JSONObject
    //   0	2816	3	paramString2	String
    //   0	2816	4	paramString3	String
    //   1011	1796	5	i	int
    //   18	2606	6	j	int
    //   27	2659	7	localArrayList	ArrayList
    //   66	2426	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	76	1041	org/json/JSONException
    //   86	113	1041	org/json/JSONException
    //   118	127	1041	org/json/JSONException
    //   127	138	1041	org/json/JSONException
    //   143	152	1041	org/json/JSONException
    //   152	163	1041	org/json/JSONException
    //   168	177	1041	org/json/JSONException
    //   177	188	1041	org/json/JSONException
    //   193	202	1041	org/json/JSONException
    //   202	213	1041	org/json/JSONException
    //   218	227	1041	org/json/JSONException
    //   227	238	1041	org/json/JSONException
    //   243	252	1041	org/json/JSONException
    //   252	262	1041	org/json/JSONException
    //   262	270	1259	org/json/JSONException
    //   275	344	1259	org/json/JSONException
    //   1057	1087	1259	org/json/JSONException
    //   1092	1182	1259	org/json/JSONException
    //   1188	1256	1259	org/json/JSONException
    //   344	351	1481	org/json/JSONException
    //   355	423	1481	org/json/JSONException
    //   1275	1305	1481	org/json/JSONException
    //   1310	1402	1481	org/json/JSONException
    //   1408	1478	1481	org/json/JSONException
    //   423	431	1827	org/json/JSONException
    //   436	506	1827	org/json/JSONException
    //   1497	1527	1827	org/json/JSONException
    //   1532	1691	1827	org/json/JSONException
    //   1697	1824	1827	org/json/JSONException
    //   506	513	2107	org/json/JSONException
    //   517	586	2107	org/json/JSONException
    //   1843	1873	2107	org/json/JSONException
    //   1878	2001	2107	org/json/JSONException
    //   2007	2104	2107	org/json/JSONException
    //   586	594	2325	org/json/JSONException
    //   599	669	2325	org/json/JSONException
    //   2123	2153	2325	org/json/JSONException
    //   2158	2248	2325	org/json/JSONException
    //   2254	2322	2325	org/json/JSONException
    //   771	778	2547	org/json/JSONException
    //   782	859	2547	org/json/JSONException
    //   2341	2371	2547	org/json/JSONException
    //   2376	2468	2547	org/json/JSONException
    //   2474	2544	2547	org/json/JSONException
    //   933	941	2740	org/json/JSONException
    //   945	1010	2740	org/json/JSONException
    //   2563	2607	2740	org/json/JSONException
    //   2611	2679	2740	org/json/JSONException
    //   2685	2737	2740	org/json/JSONException
    //   1013	1034	2753	android/os/RemoteException
    //   1013	1034	2782	android/content/OperationApplicationException
  }
  
  private JSONObject nameQuery(Cursor paramCursor)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str3 = paramCursor.getString(paramCursor.getColumnIndex("data3"));
      String str1 = paramCursor.getString(paramCursor.getColumnIndex("data2"));
      String str2 = paramCursor.getString(paramCursor.getColumnIndex("data5"));
      String str4 = paramCursor.getString(paramCursor.getColumnIndex("data4"));
      String str5 = paramCursor.getString(paramCursor.getColumnIndex("data6"));
      paramCursor = new java/lang/StringBuffer;
      paramCursor.<init>("");
      StringBuilder localStringBuilder;
      if (str4 != null)
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        paramCursor.append(str4 + " ");
      }
      if (str1 != null)
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        paramCursor.append(str1 + " ");
      }
      if (str2 != null)
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        paramCursor.append(str2 + " ");
      }
      if (str3 != null) {
        paramCursor.append(str3);
      }
      if (str5 != null)
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        paramCursor.append(" " + str5);
      }
      localJSONObject.put("familyName", str3);
      localJSONObject.put("givenName", str1);
      localJSONObject.put("middleName", str2);
      localJSONObject.put("honorificPrefix", str4);
      localJSONObject.put("honorificSuffix", str5);
      localJSONObject.put("formatted", paramCursor);
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
    return localJSONObject;
  }
  
  private JSONObject organizationQuery(Cursor paramCursor)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCursor.getString(paramCursor.getColumnIndex("_id")));
      localJSONObject.put("pref", false);
      localJSONObject.put("type", getOrgType(paramCursor.getInt(paramCursor.getColumnIndex("data2"))));
      localJSONObject.put("department", paramCursor.getString(paramCursor.getColumnIndex("data5")));
      localJSONObject.put("name", paramCursor.getString(paramCursor.getColumnIndex("data1")));
      localJSONObject.put("title", paramCursor.getString(paramCursor.getColumnIndex("data4")));
      return localJSONObject;
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
  }
  
  private JSONObject phoneQuery(Cursor paramCursor)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCursor.getString(paramCursor.getColumnIndex("_id")));
      localJSONObject.put("pref", false);
      localJSONObject.put("value", paramCursor.getString(paramCursor.getColumnIndex("data1")));
      localJSONObject.put("type", getPhoneType(paramCursor.getInt(paramCursor.getColumnIndex("data2"))));
      return localJSONObject;
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
    catch (Exception paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
  }
  
  private JSONObject photoQuery(Cursor paramCursor, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCursor.getString(paramCursor.getColumnIndex("_id")));
      localJSONObject.put("pref", false);
      localJSONObject.put("type", "url");
      paramCursor = ContactsContract.Contacts.CONTENT_URI;
      Long localLong = new java/lang/Long;
      localLong.<init>(paramString);
      localJSONObject.put("value", Uri.withAppendedPath(ContentUris.withAppendedId(paramCursor, localLong.longValue()), "photo").toString());
      return localJSONObject;
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
  }
  
  private JSONObject populateContact(JSONObject paramJSONObject, JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONArray paramJSONArray3, JSONArray paramJSONArray4, JSONArray paramJSONArray5, JSONArray paramJSONArray6, JSONArray paramJSONArray7)
  {
    try
    {
      if (paramJSONArray1.length() > 0) {
        paramJSONObject.put("organizations", paramJSONArray1);
      }
      if (paramJSONArray2.length() > 0) {
        paramJSONObject.put("addresses", paramJSONArray2);
      }
      if (paramJSONArray3.length() > 0) {
        paramJSONObject.put("phoneNumbers", paramJSONArray3);
      }
      if (paramJSONArray4.length() > 0) {
        paramJSONObject.put("emails", paramJSONArray4);
      }
      if (paramJSONArray5.length() > 0) {
        paramJSONObject.put("ims", paramJSONArray5);
      }
      if (paramJSONArray6.length() > 0) {
        paramJSONObject.put("urls", paramJSONArray6);
      }
      if (paramJSONArray7.length() > 0) {
        paramJSONObject.put("photos", paramJSONArray7);
      }
    }
    catch (JSONException paramJSONArray1)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramJSONArray1.getMessage(), paramJSONArray1);
      }
    }
    return paramJSONObject;
  }
  
  /* Error */
  private JSONArray populateContactArray(int paramInt, HashMap<String, Boolean> paramHashMap, Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc_w 690
    //   3: astore 32
    //   5: ldc_w 690
    //   8: astore 15
    //   10: iconst_1
    //   11: istore 4
    //   13: new 310	org/json/JSONArray
    //   16: dup
    //   17: invokespecial 768	org/json/JSONArray:<init>	()V
    //   20: astore 43
    //   22: new 139	org/json/JSONObject
    //   25: dup
    //   26: invokespecial 140	org/json/JSONObject:<init>	()V
    //   29: astore 27
    //   31: new 310	org/json/JSONArray
    //   34: dup
    //   35: invokespecial 768	org/json/JSONArray:<init>	()V
    //   38: astore 17
    //   40: new 310	org/json/JSONArray
    //   43: dup
    //   44: invokespecial 768	org/json/JSONArray:<init>	()V
    //   47: astore 23
    //   49: new 310	org/json/JSONArray
    //   52: dup
    //   53: invokespecial 768	org/json/JSONArray:<init>	()V
    //   56: astore 19
    //   58: new 310	org/json/JSONArray
    //   61: dup
    //   62: invokespecial 768	org/json/JSONArray:<init>	()V
    //   65: astore 20
    //   67: new 310	org/json/JSONArray
    //   70: dup
    //   71: invokespecial 768	org/json/JSONArray:<init>	()V
    //   74: astore 22
    //   76: new 310	org/json/JSONArray
    //   79: dup
    //   80: invokespecial 768	org/json/JSONArray:<init>	()V
    //   83: astore 21
    //   85: new 310	org/json/JSONArray
    //   88: dup
    //   89: invokespecial 768	org/json/JSONArray:<init>	()V
    //   92: astore 18
    //   94: aload_3
    //   95: ldc 28
    //   97: invokeinterface 148 2 0
    //   102: istore 11
    //   104: aload_3
    //   105: ldc_w 377
    //   108: invokeinterface 148 2 0
    //   113: istore 13
    //   115: aload_3
    //   116: ldc_w 288
    //   119: invokeinterface 148 2 0
    //   124: istore 12
    //   126: aload_3
    //   127: ldc 42
    //   129: invokeinterface 148 2 0
    //   134: istore 10
    //   136: aload_3
    //   137: ldc 42
    //   139: invokeinterface 148 2 0
    //   144: istore 9
    //   146: aload_3
    //   147: ldc 42
    //   149: invokeinterface 148 2 0
    //   154: istore 14
    //   156: aload_3
    //   157: ldc 42
    //   159: invokeinterface 148 2 0
    //   164: istore 8
    //   166: aload_3
    //   167: ldc 52
    //   169: invokeinterface 148 2 0
    //   174: istore 7
    //   176: aload_3
    //   177: invokeinterface 771 1 0
    //   182: ifle +3312 -> 3494
    //   185: aload_3
    //   186: invokeinterface 774 1 0
    //   191: ifeq +3268 -> 3459
    //   194: aload 43
    //   196: invokevirtual 314	org/json/JSONArray:length	()I
    //   199: iload_1
    //   200: iconst_1
    //   201: isub
    //   202: if_icmpgt +3257 -> 3459
    //   205: aload 27
    //   207: astore 33
    //   209: aload 17
    //   211: astore 34
    //   213: aload 23
    //   215: astore 35
    //   217: aload 19
    //   219: astore 36
    //   221: aload 20
    //   223: astore 37
    //   225: aload 22
    //   227: astore 38
    //   229: aload 21
    //   231: astore 39
    //   233: aload 18
    //   235: astore 40
    //   237: aload 32
    //   239: astore 41
    //   241: iload 4
    //   243: istore 5
    //   245: aload_3
    //   246: iload 11
    //   248: invokeinterface 152 2 0
    //   253: astore 24
    //   255: aload 27
    //   257: astore 33
    //   259: aload 17
    //   261: astore 34
    //   263: aload 23
    //   265: astore 35
    //   267: aload 19
    //   269: astore 36
    //   271: aload 20
    //   273: astore 37
    //   275: aload 22
    //   277: astore 38
    //   279: aload 21
    //   281: astore 39
    //   283: aload 18
    //   285: astore 40
    //   287: aload 24
    //   289: astore 41
    //   291: iload 4
    //   293: istore 5
    //   295: aload_3
    //   296: iload 13
    //   298: invokeinterface 152 2 0
    //   303: astore 42
    //   305: aload 15
    //   307: astore 32
    //   309: aload 27
    //   311: astore 33
    //   313: aload 17
    //   315: astore 34
    //   317: aload 23
    //   319: astore 35
    //   321: aload 19
    //   323: astore 36
    //   325: aload 20
    //   327: astore 37
    //   329: aload 22
    //   331: astore 38
    //   333: aload 21
    //   335: astore 39
    //   337: aload 18
    //   339: astore 40
    //   341: aload 24
    //   343: astore 41
    //   345: iload 4
    //   347: istore 5
    //   349: aload_3
    //   350: invokeinterface 777 1 0
    //   355: ifne +7 -> 362
    //   358: aload 24
    //   360: astore 32
    //   362: aload 27
    //   364: astore 31
    //   366: aload 17
    //   368: astore 30
    //   370: aload 23
    //   372: astore 29
    //   374: aload 19
    //   376: astore 28
    //   378: aload 20
    //   380: astore 26
    //   382: aload 22
    //   384: astore 25
    //   386: aload 21
    //   388: astore 16
    //   390: aload 18
    //   392: astore 15
    //   394: iload 4
    //   396: istore 6
    //   398: aload 27
    //   400: astore 33
    //   402: aload 17
    //   404: astore 34
    //   406: aload 23
    //   408: astore 35
    //   410: aload 19
    //   412: astore 36
    //   414: aload 20
    //   416: astore 37
    //   418: aload 22
    //   420: astore 38
    //   422: aload 21
    //   424: astore 39
    //   426: aload 18
    //   428: astore 40
    //   430: aload 24
    //   432: astore 41
    //   434: iload 4
    //   436: istore 5
    //   438: aload 32
    //   440: aload 24
    //   442: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   445: ifne +272 -> 717
    //   448: aload 27
    //   450: astore 33
    //   452: aload 17
    //   454: astore 34
    //   456: aload 23
    //   458: astore 35
    //   460: aload 19
    //   462: astore 36
    //   464: aload 20
    //   466: astore 37
    //   468: aload 22
    //   470: astore 38
    //   472: aload 21
    //   474: astore 39
    //   476: aload 18
    //   478: astore 40
    //   480: aload 24
    //   482: astore 41
    //   484: iload 4
    //   486: istore 5
    //   488: aload 43
    //   490: aload_0
    //   491: aload 27
    //   493: aload 17
    //   495: aload 23
    //   497: aload 19
    //   499: aload 20
    //   501: aload 22
    //   503: aload 21
    //   505: aload 18
    //   507: invokespecial 779	org/apache/cordova/ContactAccessorSdk5:populateContact	(Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)Lorg/json/JSONObject;
    //   510: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   513: pop
    //   514: aload 27
    //   516: astore 33
    //   518: aload 17
    //   520: astore 34
    //   522: aload 23
    //   524: astore 35
    //   526: aload 19
    //   528: astore 36
    //   530: aload 20
    //   532: astore 37
    //   534: aload 22
    //   536: astore 38
    //   538: aload 21
    //   540: astore 39
    //   542: aload 18
    //   544: astore 40
    //   546: aload 24
    //   548: astore 41
    //   550: iload 4
    //   552: istore 5
    //   554: new 139	org/json/JSONObject
    //   557: astore 15
    //   559: aload 27
    //   561: astore 33
    //   563: aload 17
    //   565: astore 34
    //   567: aload 23
    //   569: astore 35
    //   571: aload 19
    //   573: astore 36
    //   575: aload 20
    //   577: astore 37
    //   579: aload 22
    //   581: astore 38
    //   583: aload 21
    //   585: astore 39
    //   587: aload 18
    //   589: astore 40
    //   591: aload 24
    //   593: astore 41
    //   595: iload 4
    //   597: istore 5
    //   599: aload 15
    //   601: invokespecial 140	org/json/JSONObject:<init>	()V
    //   604: new 310	org/json/JSONArray
    //   607: astore 16
    //   609: aload 16
    //   611: invokespecial 768	org/json/JSONArray:<init>	()V
    //   614: new 310	org/json/JSONArray
    //   617: astore 17
    //   619: aload 17
    //   621: invokespecial 768	org/json/JSONArray:<init>	()V
    //   624: new 310	org/json/JSONArray
    //   627: astore 23
    //   629: aload 23
    //   631: invokespecial 768	org/json/JSONArray:<init>	()V
    //   634: new 310	org/json/JSONArray
    //   637: astore 19
    //   639: aload 19
    //   641: invokespecial 768	org/json/JSONArray:<init>	()V
    //   644: new 310	org/json/JSONArray
    //   647: astore 20
    //   649: aload 20
    //   651: invokespecial 768	org/json/JSONArray:<init>	()V
    //   654: new 310	org/json/JSONArray
    //   657: astore 22
    //   659: aload 22
    //   661: invokespecial 768	org/json/JSONArray:<init>	()V
    //   664: new 310	org/json/JSONArray
    //   667: astore 21
    //   669: aload 21
    //   671: invokespecial 768	org/json/JSONArray:<init>	()V
    //   674: iconst_1
    //   675: istore 6
    //   677: aload 21
    //   679: astore 18
    //   681: aload 22
    //   683: astore 21
    //   685: aload 16
    //   687: astore 30
    //   689: aload 15
    //   691: astore 31
    //   693: aload 18
    //   695: astore 15
    //   697: aload 21
    //   699: astore 16
    //   701: aload 20
    //   703: astore 25
    //   705: aload 19
    //   707: astore 26
    //   709: aload 23
    //   711: astore 28
    //   713: aload 17
    //   715: astore 29
    //   717: iload 6
    //   719: istore 4
    //   721: iload 6
    //   723: ifeq +110 -> 833
    //   726: iconst_0
    //   727: istore 6
    //   729: iconst_0
    //   730: istore 4
    //   732: aload 31
    //   734: astore 33
    //   736: aload 30
    //   738: astore 34
    //   740: aload 29
    //   742: astore 35
    //   744: aload 28
    //   746: astore 36
    //   748: aload 26
    //   750: astore 37
    //   752: aload 25
    //   754: astore 38
    //   756: aload 16
    //   758: astore 39
    //   760: aload 15
    //   762: astore 40
    //   764: aload 24
    //   766: astore 41
    //   768: iload 6
    //   770: istore 5
    //   772: aload 31
    //   774: ldc 26
    //   776: aload 24
    //   778: invokevirtual 155	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   781: pop
    //   782: aload 31
    //   784: astore 33
    //   786: aload 30
    //   788: astore 34
    //   790: aload 29
    //   792: astore 35
    //   794: aload 28
    //   796: astore 36
    //   798: aload 26
    //   800: astore 37
    //   802: aload 25
    //   804: astore 38
    //   806: aload 16
    //   808: astore 39
    //   810: aload 15
    //   812: astore 40
    //   814: aload 24
    //   816: astore 41
    //   818: iload 6
    //   820: istore 5
    //   822: aload 31
    //   824: ldc_w 667
    //   827: aload 42
    //   829: invokevirtual 155	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   832: pop
    //   833: aload 31
    //   835: astore 33
    //   837: aload 30
    //   839: astore 34
    //   841: aload 29
    //   843: astore 35
    //   845: aload 28
    //   847: astore 36
    //   849: aload 26
    //   851: astore 37
    //   853: aload 25
    //   855: astore 38
    //   857: aload 16
    //   859: astore 39
    //   861: aload 15
    //   863: astore 40
    //   865: aload 24
    //   867: astore 41
    //   869: iload 4
    //   871: istore 5
    //   873: aload_3
    //   874: iload 12
    //   876: invokeinterface 152 2 0
    //   881: astore 17
    //   883: aload 31
    //   885: astore 33
    //   887: aload 30
    //   889: astore 34
    //   891: aload 29
    //   893: astore 35
    //   895: aload 28
    //   897: astore 36
    //   899: aload 26
    //   901: astore 37
    //   903: aload 25
    //   905: astore 38
    //   907: aload 16
    //   909: astore 39
    //   911: aload 15
    //   913: astore 40
    //   915: aload 24
    //   917: astore 41
    //   919: iload 4
    //   921: istore 5
    //   923: aload 17
    //   925: ldc_w 292
    //   928: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   931: ifeq +59 -> 990
    //   934: aload 31
    //   936: astore 33
    //   938: aload 30
    //   940: astore 34
    //   942: aload 29
    //   944: astore 35
    //   946: aload 28
    //   948: astore 36
    //   950: aload 26
    //   952: astore 37
    //   954: aload 25
    //   956: astore 38
    //   958: aload 16
    //   960: astore 39
    //   962: aload 15
    //   964: astore 40
    //   966: aload 24
    //   968: astore 41
    //   970: iload 4
    //   972: istore 5
    //   974: aload 31
    //   976: ldc 36
    //   978: aload_3
    //   979: iload 10
    //   981: invokeinterface 152 2 0
    //   986: invokevirtual 155	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   989: pop
    //   990: aload 31
    //   992: astore 33
    //   994: aload 30
    //   996: astore 34
    //   998: aload 29
    //   1000: astore 35
    //   1002: aload 28
    //   1004: astore 36
    //   1006: aload 26
    //   1008: astore 37
    //   1010: aload 25
    //   1012: astore 38
    //   1014: aload 16
    //   1016: astore 39
    //   1018: aload 15
    //   1020: astore 40
    //   1022: aload 24
    //   1024: astore 41
    //   1026: iload 4
    //   1028: istore 5
    //   1030: aload 17
    //   1032: ldc_w 292
    //   1035: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1038: ifeq +165 -> 1203
    //   1041: aload 31
    //   1043: astore 33
    //   1045: aload 30
    //   1047: astore 34
    //   1049: aload 29
    //   1051: astore 35
    //   1053: aload 28
    //   1055: astore 36
    //   1057: aload 26
    //   1059: astore 37
    //   1061: aload 25
    //   1063: astore 38
    //   1065: aload 16
    //   1067: astore 39
    //   1069: aload 15
    //   1071: astore 40
    //   1073: aload 24
    //   1075: astore 41
    //   1077: iload 4
    //   1079: istore 5
    //   1081: aload_0
    //   1082: ldc 40
    //   1084: aload_2
    //   1085: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   1088: ifeq +115 -> 1203
    //   1091: aload 31
    //   1093: astore 33
    //   1095: aload 30
    //   1097: astore 34
    //   1099: aload 29
    //   1101: astore 35
    //   1103: aload 28
    //   1105: astore 36
    //   1107: aload 26
    //   1109: astore 37
    //   1111: aload 25
    //   1113: astore 38
    //   1115: aload 16
    //   1117: astore 39
    //   1119: aload 15
    //   1121: astore 40
    //   1123: aload 24
    //   1125: astore 41
    //   1127: iload 4
    //   1129: istore 5
    //   1131: aload 31
    //   1133: ldc 40
    //   1135: aload_0
    //   1136: aload_3
    //   1137: invokespecial 788	org/apache/cordova/ContactAccessorSdk5:nameQuery	(Landroid/database/Cursor;)Lorg/json/JSONObject;
    //   1140: invokevirtual 155	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1143: pop
    //   1144: iload 4
    //   1146: istore 6
    //   1148: aload 24
    //   1150: astore 32
    //   1152: aload 15
    //   1154: astore 42
    //   1156: aload 16
    //   1158: astore 21
    //   1160: aload 25
    //   1162: astore 22
    //   1164: aload 26
    //   1166: astore 20
    //   1168: aload 28
    //   1170: astore 19
    //   1172: aload 29
    //   1174: astore 23
    //   1176: aload 30
    //   1178: astore 18
    //   1180: aload 31
    //   1182: astore 27
    //   1184: aload 32
    //   1186: astore 15
    //   1188: aload 18
    //   1190: astore 17
    //   1192: aload 42
    //   1194: astore 18
    //   1196: iload 6
    //   1198: istore 4
    //   1200: goto -1015 -> 185
    //   1203: aload 31
    //   1205: astore 33
    //   1207: aload 30
    //   1209: astore 34
    //   1211: aload 29
    //   1213: astore 35
    //   1215: aload 28
    //   1217: astore 36
    //   1219: aload 26
    //   1221: astore 37
    //   1223: aload 25
    //   1225: astore 38
    //   1227: aload 16
    //   1229: astore 39
    //   1231: aload 15
    //   1233: astore 40
    //   1235: aload 24
    //   1237: astore 41
    //   1239: iload 4
    //   1241: istore 5
    //   1243: aload 17
    //   1245: ldc_w 296
    //   1248: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1251: ifeq +225 -> 1476
    //   1254: aload 31
    //   1256: astore 33
    //   1258: aload 30
    //   1260: astore 34
    //   1262: aload 29
    //   1264: astore 35
    //   1266: aload 28
    //   1268: astore 36
    //   1270: aload 26
    //   1272: astore 37
    //   1274: aload 25
    //   1276: astore 38
    //   1278: aload 16
    //   1280: astore 39
    //   1282: aload 15
    //   1284: astore 40
    //   1286: aload 24
    //   1288: astore 41
    //   1290: iload 4
    //   1292: istore 5
    //   1294: aload_0
    //   1295: ldc 68
    //   1297: aload_2
    //   1298: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   1301: ifeq +175 -> 1476
    //   1304: aload 31
    //   1306: astore 33
    //   1308: aload 30
    //   1310: astore 34
    //   1312: aload 29
    //   1314: astore 35
    //   1316: aload 28
    //   1318: astore 36
    //   1320: aload 26
    //   1322: astore 37
    //   1324: aload 25
    //   1326: astore 38
    //   1328: aload 16
    //   1330: astore 39
    //   1332: aload 15
    //   1334: astore 40
    //   1336: aload 24
    //   1338: astore 41
    //   1340: iload 4
    //   1342: istore 5
    //   1344: aload 28
    //   1346: aload_0
    //   1347: aload_3
    //   1348: invokespecial 790	org/apache/cordova/ContactAccessorSdk5:phoneQuery	(Landroid/database/Cursor;)Lorg/json/JSONObject;
    //   1351: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1354: pop
    //   1355: aload 31
    //   1357: astore 27
    //   1359: aload 30
    //   1361: astore 18
    //   1363: aload 29
    //   1365: astore 23
    //   1367: aload 28
    //   1369: astore 19
    //   1371: aload 26
    //   1373: astore 20
    //   1375: aload 25
    //   1377: astore 22
    //   1379: aload 16
    //   1381: astore 21
    //   1383: aload 15
    //   1385: astore 42
    //   1387: aload 24
    //   1389: astore 32
    //   1391: iload 4
    //   1393: istore 6
    //   1395: goto -211 -> 1184
    //   1398: astore 18
    //   1400: iload 5
    //   1402: istore 4
    //   1404: aload 41
    //   1406: astore 24
    //   1408: aload 39
    //   1410: astore 21
    //   1412: aload 38
    //   1414: astore 22
    //   1416: aload 37
    //   1418: astore 20
    //   1420: aload 36
    //   1422: astore 19
    //   1424: aload 35
    //   1426: astore 17
    //   1428: aload 34
    //   1430: astore 16
    //   1432: aload 33
    //   1434: astore 15
    //   1436: ldc -73
    //   1438: aload 18
    //   1440: invokevirtual 187	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1443: aload 18
    //   1445: invokestatic 193	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1448: pop
    //   1449: aload 15
    //   1451: astore 27
    //   1453: aload 16
    //   1455: astore 18
    //   1457: aload 17
    //   1459: astore 23
    //   1461: aload 40
    //   1463: astore 42
    //   1465: aload 24
    //   1467: astore 32
    //   1469: iload 4
    //   1471: istore 6
    //   1473: goto -289 -> 1184
    //   1476: aload 31
    //   1478: astore 33
    //   1480: aload 30
    //   1482: astore 34
    //   1484: aload 29
    //   1486: astore 35
    //   1488: aload 28
    //   1490: astore 36
    //   1492: aload 26
    //   1494: astore 37
    //   1496: aload 25
    //   1498: astore 38
    //   1500: aload 16
    //   1502: astore 39
    //   1504: aload 15
    //   1506: astore 40
    //   1508: aload 24
    //   1510: astore 41
    //   1512: iload 4
    //   1514: istore 5
    //   1516: aload 17
    //   1518: ldc_w 298
    //   1521: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1524: ifeq +147 -> 1671
    //   1527: aload 31
    //   1529: astore 33
    //   1531: aload 30
    //   1533: astore 34
    //   1535: aload 29
    //   1537: astore 35
    //   1539: aload 28
    //   1541: astore 36
    //   1543: aload 26
    //   1545: astore 37
    //   1547: aload 25
    //   1549: astore 38
    //   1551: aload 16
    //   1553: astore 39
    //   1555: aload 15
    //   1557: astore 40
    //   1559: aload 24
    //   1561: astore 41
    //   1563: iload 4
    //   1565: istore 5
    //   1567: aload_0
    //   1568: ldc 72
    //   1570: aload_2
    //   1571: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   1574: ifeq +97 -> 1671
    //   1577: aload 31
    //   1579: astore 33
    //   1581: aload 30
    //   1583: astore 34
    //   1585: aload 29
    //   1587: astore 35
    //   1589: aload 28
    //   1591: astore 36
    //   1593: aload 26
    //   1595: astore 37
    //   1597: aload 25
    //   1599: astore 38
    //   1601: aload 16
    //   1603: astore 39
    //   1605: aload 15
    //   1607: astore 40
    //   1609: aload 24
    //   1611: astore 41
    //   1613: iload 4
    //   1615: istore 5
    //   1617: aload 26
    //   1619: aload_0
    //   1620: aload_3
    //   1621: invokespecial 792	org/apache/cordova/ContactAccessorSdk5:emailQuery	(Landroid/database/Cursor;)Lorg/json/JSONObject;
    //   1624: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1627: pop
    //   1628: aload 31
    //   1630: astore 27
    //   1632: aload 30
    //   1634: astore 18
    //   1636: aload 29
    //   1638: astore 23
    //   1640: aload 28
    //   1642: astore 19
    //   1644: aload 26
    //   1646: astore 20
    //   1648: aload 25
    //   1650: astore 22
    //   1652: aload 16
    //   1654: astore 21
    //   1656: aload 15
    //   1658: astore 42
    //   1660: aload 24
    //   1662: astore 32
    //   1664: iload 4
    //   1666: istore 6
    //   1668: goto -484 -> 1184
    //   1671: aload 31
    //   1673: astore 33
    //   1675: aload 30
    //   1677: astore 34
    //   1679: aload 29
    //   1681: astore 35
    //   1683: aload 28
    //   1685: astore 36
    //   1687: aload 26
    //   1689: astore 37
    //   1691: aload 25
    //   1693: astore 38
    //   1695: aload 16
    //   1697: astore 39
    //   1699: aload 15
    //   1701: astore 40
    //   1703: aload 24
    //   1705: astore 41
    //   1707: iload 4
    //   1709: istore 5
    //   1711: aload 17
    //   1713: ldc_w 300
    //   1716: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1719: ifeq +147 -> 1866
    //   1722: aload 31
    //   1724: astore 33
    //   1726: aload 30
    //   1728: astore 34
    //   1730: aload 29
    //   1732: astore 35
    //   1734: aload 28
    //   1736: astore 36
    //   1738: aload 26
    //   1740: astore 37
    //   1742: aload 25
    //   1744: astore 38
    //   1746: aload 16
    //   1748: astore 39
    //   1750: aload 15
    //   1752: astore 40
    //   1754: aload 24
    //   1756: astore 41
    //   1758: iload 4
    //   1760: istore 5
    //   1762: aload_0
    //   1763: ldc 76
    //   1765: aload_2
    //   1766: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   1769: ifeq +97 -> 1866
    //   1772: aload 31
    //   1774: astore 33
    //   1776: aload 30
    //   1778: astore 34
    //   1780: aload 29
    //   1782: astore 35
    //   1784: aload 28
    //   1786: astore 36
    //   1788: aload 26
    //   1790: astore 37
    //   1792: aload 25
    //   1794: astore 38
    //   1796: aload 16
    //   1798: astore 39
    //   1800: aload 15
    //   1802: astore 40
    //   1804: aload 24
    //   1806: astore 41
    //   1808: iload 4
    //   1810: istore 5
    //   1812: aload 29
    //   1814: aload_0
    //   1815: aload_3
    //   1816: invokespecial 794	org/apache/cordova/ContactAccessorSdk5:addressQuery	(Landroid/database/Cursor;)Lorg/json/JSONObject;
    //   1819: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1822: pop
    //   1823: aload 31
    //   1825: astore 27
    //   1827: aload 30
    //   1829: astore 18
    //   1831: aload 29
    //   1833: astore 23
    //   1835: aload 28
    //   1837: astore 19
    //   1839: aload 26
    //   1841: astore 20
    //   1843: aload 25
    //   1845: astore 22
    //   1847: aload 16
    //   1849: astore 21
    //   1851: aload 15
    //   1853: astore 42
    //   1855: aload 24
    //   1857: astore 32
    //   1859: iload 4
    //   1861: istore 6
    //   1863: goto -679 -> 1184
    //   1866: aload 31
    //   1868: astore 33
    //   1870: aload 30
    //   1872: astore 34
    //   1874: aload 29
    //   1876: astore 35
    //   1878: aload 28
    //   1880: astore 36
    //   1882: aload 26
    //   1884: astore 37
    //   1886: aload 25
    //   1888: astore 38
    //   1890: aload 16
    //   1892: astore 39
    //   1894: aload 15
    //   1896: astore 40
    //   1898: aload 24
    //   1900: astore 41
    //   1902: iload 4
    //   1904: istore 5
    //   1906: aload 17
    //   1908: ldc_w 304
    //   1911: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1914: ifeq +147 -> 2061
    //   1917: aload 31
    //   1919: astore 33
    //   1921: aload 30
    //   1923: astore 34
    //   1925: aload 29
    //   1927: astore 35
    //   1929: aload 28
    //   1931: astore 36
    //   1933: aload 26
    //   1935: astore 37
    //   1937: aload 25
    //   1939: astore 38
    //   1941: aload 16
    //   1943: astore 39
    //   1945: aload 15
    //   1947: astore 40
    //   1949: aload 24
    //   1951: astore 41
    //   1953: iload 4
    //   1955: istore 5
    //   1957: aload_0
    //   1958: ldc 102
    //   1960: aload_2
    //   1961: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   1964: ifeq +97 -> 2061
    //   1967: aload 31
    //   1969: astore 33
    //   1971: aload 30
    //   1973: astore 34
    //   1975: aload 29
    //   1977: astore 35
    //   1979: aload 28
    //   1981: astore 36
    //   1983: aload 26
    //   1985: astore 37
    //   1987: aload 25
    //   1989: astore 38
    //   1991: aload 16
    //   1993: astore 39
    //   1995: aload 15
    //   1997: astore 40
    //   1999: aload 24
    //   2001: astore 41
    //   2003: iload 4
    //   2005: istore 5
    //   2007: aload 30
    //   2009: aload_0
    //   2010: aload_3
    //   2011: invokespecial 796	org/apache/cordova/ContactAccessorSdk5:organizationQuery	(Landroid/database/Cursor;)Lorg/json/JSONObject;
    //   2014: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2017: pop
    //   2018: aload 31
    //   2020: astore 27
    //   2022: aload 30
    //   2024: astore 18
    //   2026: aload 29
    //   2028: astore 23
    //   2030: aload 28
    //   2032: astore 19
    //   2034: aload 26
    //   2036: astore 20
    //   2038: aload 25
    //   2040: astore 22
    //   2042: aload 16
    //   2044: astore 21
    //   2046: aload 15
    //   2048: astore 42
    //   2050: aload 24
    //   2052: astore 32
    //   2054: iload 4
    //   2056: istore 6
    //   2058: goto -874 -> 1184
    //   2061: aload 31
    //   2063: astore 33
    //   2065: aload 30
    //   2067: astore 34
    //   2069: aload 29
    //   2071: astore 35
    //   2073: aload 28
    //   2075: astore 36
    //   2077: aload 26
    //   2079: astore 37
    //   2081: aload 25
    //   2083: astore 38
    //   2085: aload 16
    //   2087: astore 39
    //   2089: aload 15
    //   2091: astore 40
    //   2093: aload 24
    //   2095: astore 41
    //   2097: iload 4
    //   2099: istore 5
    //   2101: aload 17
    //   2103: ldc_w 302
    //   2106: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2109: ifeq +147 -> 2256
    //   2112: aload 31
    //   2114: astore 33
    //   2116: aload 30
    //   2118: astore 34
    //   2120: aload 29
    //   2122: astore 35
    //   2124: aload 28
    //   2126: astore 36
    //   2128: aload 26
    //   2130: astore 37
    //   2132: aload 25
    //   2134: astore 38
    //   2136: aload 16
    //   2138: astore 39
    //   2140: aload 15
    //   2142: astore 40
    //   2144: aload 24
    //   2146: astore 41
    //   2148: iload 4
    //   2150: istore 5
    //   2152: aload_0
    //   2153: ldc 98
    //   2155: aload_2
    //   2156: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2159: ifeq +97 -> 2256
    //   2162: aload 31
    //   2164: astore 33
    //   2166: aload 30
    //   2168: astore 34
    //   2170: aload 29
    //   2172: astore 35
    //   2174: aload 28
    //   2176: astore 36
    //   2178: aload 26
    //   2180: astore 37
    //   2182: aload 25
    //   2184: astore 38
    //   2186: aload 16
    //   2188: astore 39
    //   2190: aload 15
    //   2192: astore 40
    //   2194: aload 24
    //   2196: astore 41
    //   2198: iload 4
    //   2200: istore 5
    //   2202: aload 25
    //   2204: aload_0
    //   2205: aload_3
    //   2206: invokespecial 798	org/apache/cordova/ContactAccessorSdk5:imQuery	(Landroid/database/Cursor;)Lorg/json/JSONObject;
    //   2209: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2212: pop
    //   2213: aload 31
    //   2215: astore 27
    //   2217: aload 30
    //   2219: astore 18
    //   2221: aload 29
    //   2223: astore 23
    //   2225: aload 28
    //   2227: astore 19
    //   2229: aload 26
    //   2231: astore 20
    //   2233: aload 25
    //   2235: astore 22
    //   2237: aload 16
    //   2239: astore 21
    //   2241: aload 15
    //   2243: astore 42
    //   2245: aload 24
    //   2247: astore 32
    //   2249: iload 4
    //   2251: istore 6
    //   2253: goto -1069 -> 1184
    //   2256: aload 31
    //   2258: astore 33
    //   2260: aload 30
    //   2262: astore 34
    //   2264: aload 29
    //   2266: astore 35
    //   2268: aload 28
    //   2270: astore 36
    //   2272: aload 26
    //   2274: astore 37
    //   2276: aload 25
    //   2278: astore 38
    //   2280: aload 16
    //   2282: astore 39
    //   2284: aload 15
    //   2286: astore 40
    //   2288: aload 24
    //   2290: astore 41
    //   2292: iload 4
    //   2294: istore 5
    //   2296: aload 17
    //   2298: ldc_w 306
    //   2301: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2304: ifeq +152 -> 2456
    //   2307: aload 31
    //   2309: astore 33
    //   2311: aload 30
    //   2313: astore 34
    //   2315: aload 29
    //   2317: astore 35
    //   2319: aload 28
    //   2321: astore 36
    //   2323: aload 26
    //   2325: astore 37
    //   2327: aload 25
    //   2329: astore 38
    //   2331: aload 16
    //   2333: astore 39
    //   2335: aload 15
    //   2337: astore 40
    //   2339: aload 24
    //   2341: astore 41
    //   2343: iload 4
    //   2345: istore 5
    //   2347: aload_0
    //   2348: ldc 114
    //   2350: aload_2
    //   2351: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2354: ifeq +102 -> 2456
    //   2357: aload 31
    //   2359: astore 33
    //   2361: aload 30
    //   2363: astore 34
    //   2365: aload 29
    //   2367: astore 35
    //   2369: aload 28
    //   2371: astore 36
    //   2373: aload 26
    //   2375: astore 37
    //   2377: aload 25
    //   2379: astore 38
    //   2381: aload 16
    //   2383: astore 39
    //   2385: aload 15
    //   2387: astore 40
    //   2389: aload 24
    //   2391: astore 41
    //   2393: iload 4
    //   2395: istore 5
    //   2397: aload 31
    //   2399: ldc 114
    //   2401: aload_3
    //   2402: iload 9
    //   2404: invokeinterface 152 2 0
    //   2409: invokevirtual 155	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2412: pop
    //   2413: aload 31
    //   2415: astore 27
    //   2417: aload 30
    //   2419: astore 18
    //   2421: aload 29
    //   2423: astore 23
    //   2425: aload 28
    //   2427: astore 19
    //   2429: aload 26
    //   2431: astore 20
    //   2433: aload 25
    //   2435: astore 22
    //   2437: aload 16
    //   2439: astore 21
    //   2441: aload 15
    //   2443: astore 42
    //   2445: aload 24
    //   2447: astore 32
    //   2449: iload 4
    //   2451: istore 6
    //   2453: goto -1269 -> 1184
    //   2456: aload 31
    //   2458: astore 33
    //   2460: aload 30
    //   2462: astore 34
    //   2464: aload 29
    //   2466: astore 35
    //   2468: aload 28
    //   2470: astore 36
    //   2472: aload 26
    //   2474: astore 37
    //   2476: aload 25
    //   2478: astore 38
    //   2480: aload 16
    //   2482: astore 39
    //   2484: aload 15
    //   2486: astore 40
    //   2488: aload 24
    //   2490: astore 41
    //   2492: iload 4
    //   2494: istore 5
    //   2496: aload 17
    //   2498: ldc_w 294
    //   2501: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2504: ifeq +152 -> 2656
    //   2507: aload 31
    //   2509: astore 33
    //   2511: aload 30
    //   2513: astore 34
    //   2515: aload 29
    //   2517: astore 35
    //   2519: aload 28
    //   2521: astore 36
    //   2523: aload 26
    //   2525: astore 37
    //   2527: aload 25
    //   2529: astore 38
    //   2531: aload 16
    //   2533: astore 39
    //   2535: aload 15
    //   2537: astore 40
    //   2539: aload 24
    //   2541: astore 41
    //   2543: iload 4
    //   2545: istore 5
    //   2547: aload_0
    //   2548: ldc 66
    //   2550: aload_2
    //   2551: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2554: ifeq +102 -> 2656
    //   2557: aload 31
    //   2559: astore 33
    //   2561: aload 30
    //   2563: astore 34
    //   2565: aload 29
    //   2567: astore 35
    //   2569: aload 28
    //   2571: astore 36
    //   2573: aload 26
    //   2575: astore 37
    //   2577: aload 25
    //   2579: astore 38
    //   2581: aload 16
    //   2583: astore 39
    //   2585: aload 15
    //   2587: astore 40
    //   2589: aload 24
    //   2591: astore 41
    //   2593: iload 4
    //   2595: istore 5
    //   2597: aload 31
    //   2599: ldc 66
    //   2601: aload_3
    //   2602: iload 14
    //   2604: invokeinterface 152 2 0
    //   2609: invokevirtual 155	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2612: pop
    //   2613: aload 31
    //   2615: astore 27
    //   2617: aload 30
    //   2619: astore 18
    //   2621: aload 29
    //   2623: astore 23
    //   2625: aload 28
    //   2627: astore 19
    //   2629: aload 26
    //   2631: astore 20
    //   2633: aload 25
    //   2635: astore 22
    //   2637: aload 16
    //   2639: astore 21
    //   2641: aload 15
    //   2643: astore 42
    //   2645: aload 24
    //   2647: astore 32
    //   2649: iload 4
    //   2651: istore 6
    //   2653: goto -1469 -> 1184
    //   2656: aload 31
    //   2658: astore 33
    //   2660: aload 30
    //   2662: astore 34
    //   2664: aload 29
    //   2666: astore 35
    //   2668: aload 28
    //   2670: astore 36
    //   2672: aload 26
    //   2674: astore 37
    //   2676: aload 25
    //   2678: astore 38
    //   2680: aload 16
    //   2682: astore 39
    //   2684: aload 15
    //   2686: astore 40
    //   2688: aload 24
    //   2690: astore 41
    //   2692: iload 4
    //   2694: istore 5
    //   2696: aload 17
    //   2698: ldc_w 308
    //   2701: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2704: ifeq +147 -> 2851
    //   2707: aload 31
    //   2709: astore 33
    //   2711: aload 30
    //   2713: astore 34
    //   2715: aload 29
    //   2717: astore 35
    //   2719: aload 28
    //   2721: astore 36
    //   2723: aload 26
    //   2725: astore 37
    //   2727: aload 25
    //   2729: astore 38
    //   2731: aload 16
    //   2733: astore 39
    //   2735: aload 15
    //   2737: astore 40
    //   2739: aload 24
    //   2741: astore 41
    //   2743: iload 4
    //   2745: istore 5
    //   2747: aload_0
    //   2748: ldc 120
    //   2750: aload_2
    //   2751: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2754: ifeq +97 -> 2851
    //   2757: aload 31
    //   2759: astore 33
    //   2761: aload 30
    //   2763: astore 34
    //   2765: aload 29
    //   2767: astore 35
    //   2769: aload 28
    //   2771: astore 36
    //   2773: aload 26
    //   2775: astore 37
    //   2777: aload 25
    //   2779: astore 38
    //   2781: aload 16
    //   2783: astore 39
    //   2785: aload 15
    //   2787: astore 40
    //   2789: aload 24
    //   2791: astore 41
    //   2793: iload 4
    //   2795: istore 5
    //   2797: aload 16
    //   2799: aload_0
    //   2800: aload_3
    //   2801: invokespecial 801	org/apache/cordova/ContactAccessorSdk5:websiteQuery	(Landroid/database/Cursor;)Lorg/json/JSONObject;
    //   2804: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   2807: pop
    //   2808: aload 31
    //   2810: astore 27
    //   2812: aload 30
    //   2814: astore 18
    //   2816: aload 29
    //   2818: astore 23
    //   2820: aload 28
    //   2822: astore 19
    //   2824: aload 26
    //   2826: astore 20
    //   2828: aload 25
    //   2830: astore 22
    //   2832: aload 16
    //   2834: astore 21
    //   2836: aload 15
    //   2838: astore 42
    //   2840: aload 24
    //   2842: astore 32
    //   2844: iload 4
    //   2846: istore 6
    //   2848: goto -1664 -> 1184
    //   2851: aload 31
    //   2853: astore 33
    //   2855: aload 30
    //   2857: astore 34
    //   2859: aload 29
    //   2861: astore 35
    //   2863: aload 28
    //   2865: astore 36
    //   2867: aload 26
    //   2869: astore 37
    //   2871: aload 25
    //   2873: astore 38
    //   2875: aload 16
    //   2877: astore 39
    //   2879: aload 15
    //   2881: astore 40
    //   2883: aload 24
    //   2885: astore 41
    //   2887: iload 4
    //   2889: istore 5
    //   2891: aload 17
    //   2893: ldc 112
    //   2895: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2898: ifeq +284 -> 3182
    //   2901: aload 31
    //   2903: astore 27
    //   2905: aload 30
    //   2907: astore 18
    //   2909: aload 29
    //   2911: astore 23
    //   2913: aload 28
    //   2915: astore 19
    //   2917: aload 26
    //   2919: astore 20
    //   2921: aload 25
    //   2923: astore 22
    //   2925: aload 16
    //   2927: astore 21
    //   2929: aload 15
    //   2931: astore 42
    //   2933: aload 24
    //   2935: astore 32
    //   2937: iload 4
    //   2939: istore 6
    //   2941: aload 31
    //   2943: astore 33
    //   2945: aload 30
    //   2947: astore 34
    //   2949: aload 29
    //   2951: astore 35
    //   2953: aload 28
    //   2955: astore 36
    //   2957: aload 26
    //   2959: astore 37
    //   2961: aload 25
    //   2963: astore 38
    //   2965: aload 16
    //   2967: astore 39
    //   2969: aload 15
    //   2971: astore 40
    //   2973: aload 24
    //   2975: astore 41
    //   2977: iload 4
    //   2979: istore 5
    //   2981: aload_0
    //   2982: ldc 110
    //   2984: aload_2
    //   2985: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2988: ifeq -1804 -> 1184
    //   2991: aload 31
    //   2993: astore 27
    //   2995: aload 30
    //   2997: astore 18
    //   2999: aload 29
    //   3001: astore 23
    //   3003: aload 28
    //   3005: astore 19
    //   3007: aload 26
    //   3009: astore 20
    //   3011: aload 25
    //   3013: astore 22
    //   3015: aload 16
    //   3017: astore 21
    //   3019: aload 15
    //   3021: astore 42
    //   3023: aload 24
    //   3025: astore 32
    //   3027: iload 4
    //   3029: istore 6
    //   3031: aload 31
    //   3033: astore 33
    //   3035: aload 30
    //   3037: astore 34
    //   3039: aload 29
    //   3041: astore 35
    //   3043: aload 28
    //   3045: astore 36
    //   3047: aload 26
    //   3049: astore 37
    //   3051: aload 25
    //   3053: astore 38
    //   3055: aload 16
    //   3057: astore 39
    //   3059: aload 15
    //   3061: astore 40
    //   3063: aload 24
    //   3065: astore 41
    //   3067: iload 4
    //   3069: istore 5
    //   3071: iconst_3
    //   3072: aload_3
    //   3073: iload 7
    //   3075: invokeinterface 166 2 0
    //   3080: if_icmpne -1896 -> 1184
    //   3083: aload 31
    //   3085: astore 33
    //   3087: aload 30
    //   3089: astore 34
    //   3091: aload 29
    //   3093: astore 35
    //   3095: aload 28
    //   3097: astore 36
    //   3099: aload 26
    //   3101: astore 37
    //   3103: aload 25
    //   3105: astore 38
    //   3107: aload 16
    //   3109: astore 39
    //   3111: aload 15
    //   3113: astore 40
    //   3115: aload 24
    //   3117: astore 41
    //   3119: iload 4
    //   3121: istore 5
    //   3123: aload 31
    //   3125: ldc 110
    //   3127: aload_3
    //   3128: iload 8
    //   3130: invokeinterface 152 2 0
    //   3135: invokevirtual 155	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3138: pop
    //   3139: aload 31
    //   3141: astore 27
    //   3143: aload 30
    //   3145: astore 18
    //   3147: aload 29
    //   3149: astore 23
    //   3151: aload 28
    //   3153: astore 19
    //   3155: aload 26
    //   3157: astore 20
    //   3159: aload 25
    //   3161: astore 22
    //   3163: aload 16
    //   3165: astore 21
    //   3167: aload 15
    //   3169: astore 42
    //   3171: aload 24
    //   3173: astore 32
    //   3175: iload 4
    //   3177: istore 6
    //   3179: goto -1995 -> 1184
    //   3182: aload 31
    //   3184: astore 27
    //   3186: aload 30
    //   3188: astore 18
    //   3190: aload 29
    //   3192: astore 23
    //   3194: aload 28
    //   3196: astore 19
    //   3198: aload 26
    //   3200: astore 20
    //   3202: aload 25
    //   3204: astore 22
    //   3206: aload 16
    //   3208: astore 21
    //   3210: aload 15
    //   3212: astore 42
    //   3214: aload 24
    //   3216: astore 32
    //   3218: iload 4
    //   3220: istore 6
    //   3222: aload 31
    //   3224: astore 33
    //   3226: aload 30
    //   3228: astore 34
    //   3230: aload 29
    //   3232: astore 35
    //   3234: aload 28
    //   3236: astore 36
    //   3238: aload 26
    //   3240: astore 37
    //   3242: aload 25
    //   3244: astore 38
    //   3246: aload 16
    //   3248: astore 39
    //   3250: aload 15
    //   3252: astore 40
    //   3254: aload 24
    //   3256: astore 41
    //   3258: iload 4
    //   3260: istore 5
    //   3262: aload 17
    //   3264: ldc 118
    //   3266: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3269: ifeq -2085 -> 1184
    //   3272: aload 31
    //   3274: astore 27
    //   3276: aload 30
    //   3278: astore 18
    //   3280: aload 29
    //   3282: astore 23
    //   3284: aload 28
    //   3286: astore 19
    //   3288: aload 26
    //   3290: astore 20
    //   3292: aload 25
    //   3294: astore 22
    //   3296: aload 16
    //   3298: astore 21
    //   3300: aload 15
    //   3302: astore 42
    //   3304: aload 24
    //   3306: astore 32
    //   3308: iload 4
    //   3310: istore 6
    //   3312: aload 31
    //   3314: astore 33
    //   3316: aload 30
    //   3318: astore 34
    //   3320: aload 29
    //   3322: astore 35
    //   3324: aload 28
    //   3326: astore 36
    //   3328: aload 26
    //   3330: astore 37
    //   3332: aload 25
    //   3334: astore 38
    //   3336: aload 16
    //   3338: astore 39
    //   3340: aload 15
    //   3342: astore 40
    //   3344: aload 24
    //   3346: astore 41
    //   3348: iload 4
    //   3350: istore 5
    //   3352: aload_0
    //   3353: ldc_w 443
    //   3356: aload_2
    //   3357: invokevirtual 786	org/apache/cordova/ContactAccessorSdk5:isRequired	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   3360: ifeq -2176 -> 1184
    //   3363: aload 31
    //   3365: astore 33
    //   3367: aload 30
    //   3369: astore 34
    //   3371: aload 29
    //   3373: astore 35
    //   3375: aload 28
    //   3377: astore 36
    //   3379: aload 26
    //   3381: astore 37
    //   3383: aload 25
    //   3385: astore 38
    //   3387: aload 16
    //   3389: astore 39
    //   3391: aload 15
    //   3393: astore 40
    //   3395: aload 24
    //   3397: astore 41
    //   3399: iload 4
    //   3401: istore 5
    //   3403: aload 15
    //   3405: aload_0
    //   3406: aload_3
    //   3407: aload 24
    //   3409: invokespecial 803	org/apache/cordova/ContactAccessorSdk5:photoQuery	(Landroid/database/Cursor;Ljava/lang/String;)Lorg/json/JSONObject;
    //   3412: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   3415: pop
    //   3416: aload 31
    //   3418: astore 27
    //   3420: aload 30
    //   3422: astore 18
    //   3424: aload 29
    //   3426: astore 23
    //   3428: aload 28
    //   3430: astore 19
    //   3432: aload 26
    //   3434: astore 20
    //   3436: aload 25
    //   3438: astore 22
    //   3440: aload 16
    //   3442: astore 21
    //   3444: aload 15
    //   3446: astore 42
    //   3448: aload 24
    //   3450: astore 32
    //   3452: iload 4
    //   3454: istore 6
    //   3456: goto -2272 -> 1184
    //   3459: aload 43
    //   3461: invokevirtual 314	org/json/JSONArray:length	()I
    //   3464: iload_1
    //   3465: if_icmpge +29 -> 3494
    //   3468: aload 43
    //   3470: aload_0
    //   3471: aload 27
    //   3473: aload 17
    //   3475: aload 23
    //   3477: aload 19
    //   3479: aload 20
    //   3481: aload 22
    //   3483: aload 21
    //   3485: aload 18
    //   3487: invokespecial 779	org/apache/cordova/ContactAccessorSdk5:populateContact	(Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)Lorg/json/JSONObject;
    //   3490: invokevirtual 782	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   3493: pop
    //   3494: aload_3
    //   3495: invokeinterface 804 1 0
    //   3500: aload 43
    //   3502: areturn
    //   3503: astore 25
    //   3505: aload 17
    //   3507: astore 16
    //   3509: aload 23
    //   3511: astore 17
    //   3513: aload 18
    //   3515: astore 40
    //   3517: aload 25
    //   3519: astore 18
    //   3521: goto -2085 -> 1436
    //   3524: astore 25
    //   3526: aload 23
    //   3528: astore 17
    //   3530: aload 18
    //   3532: astore 40
    //   3534: aload 25
    //   3536: astore 18
    //   3538: goto -2102 -> 1436
    //   3541: astore 23
    //   3543: aload 18
    //   3545: astore 40
    //   3547: aload 23
    //   3549: astore 18
    //   3551: goto -2115 -> 1436
    //   3554: astore 25
    //   3556: aload 23
    //   3558: astore 19
    //   3560: aload 18
    //   3562: astore 40
    //   3564: aload 25
    //   3566: astore 18
    //   3568: goto -2132 -> 1436
    //   3571: astore 25
    //   3573: aload 19
    //   3575: astore 20
    //   3577: aload 23
    //   3579: astore 19
    //   3581: aload 18
    //   3583: astore 40
    //   3585: aload 25
    //   3587: astore 18
    //   3589: goto -2153 -> 1436
    //   3592: astore 25
    //   3594: aload 20
    //   3596: astore 22
    //   3598: aload 19
    //   3600: astore 20
    //   3602: aload 23
    //   3604: astore 19
    //   3606: aload 18
    //   3608: astore 40
    //   3610: aload 25
    //   3612: astore 18
    //   3614: goto -2178 -> 1436
    //   3617: astore 25
    //   3619: aload 22
    //   3621: astore 21
    //   3623: aload 20
    //   3625: astore 22
    //   3627: aload 19
    //   3629: astore 20
    //   3631: aload 23
    //   3633: astore 19
    //   3635: aload 18
    //   3637: astore 40
    //   3639: aload 25
    //   3641: astore 18
    //   3643: goto -2207 -> 1436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3646	0	this	ContactAccessorSdk5
    //   0	3646	1	paramInt	int
    //   0	3646	2	paramHashMap	HashMap<String, Boolean>
    //   0	3646	3	paramCursor	Cursor
    //   11	3442	4	i	int
    //   243	3159	5	j	int
    //   396	3059	6	k	int
    //   174	2900	7	m	int
    //   164	2965	8	n	int
    //   144	2259	9	i1	int
    //   134	846	10	i2	int
    //   102	145	11	i3	int
    //   124	751	12	i4	int
    //   113	184	13	i5	int
    //   154	2449	14	i6	int
    //   8	3437	15	localObject1	Object
    //   388	3120	16	localObject2	Object
    //   38	3491	17	localObject3	Object
    //   92	1270	18	localObject4	Object
    //   1398	46	18	localJSONException1	JSONException
    //   1455	2187	18	localObject5	Object
    //   56	3578	19	localObject6	Object
    //   65	3565	20	localObject7	Object
    //   83	3539	21	localObject8	Object
    //   74	3552	22	localObject9	Object
    //   47	3480	23	localObject10	Object
    //   3541	91	23	localJSONException2	JSONException
    //   253	3196	24	localObject11	Object
    //   384	3053	25	localObject12	Object
    //   3503	15	25	localJSONException3	JSONException
    //   3524	11	25	localJSONException4	JSONException
    //   3554	11	25	localJSONException5	JSONException
    //   3571	15	25	localJSONException6	JSONException
    //   3592	19	25	localJSONException7	JSONException
    //   3617	23	25	localJSONException8	JSONException
    //   380	3053	26	localObject13	Object
    //   29	3443	27	localObject14	Object
    //   376	3053	28	localObject15	Object
    //   372	3053	29	localObject16	Object
    //   368	3053	30	localObject17	Object
    //   364	3053	31	localObject18	Object
    //   3	3448	32	localObject19	Object
    //   207	3159	33	localObject20	Object
    //   211	3159	34	localObject21	Object
    //   215	3159	35	localObject22	Object
    //   219	3159	36	localObject23	Object
    //   223	3159	37	localObject24	Object
    //   227	3159	38	localObject25	Object
    //   231	3159	39	localObject26	Object
    //   235	3403	40	localObject27	Object
    //   239	3159	41	localObject28	Object
    //   303	3144	42	localObject29	Object
    //   20	3481	43	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   245	255	1398	org/json/JSONException
    //   295	305	1398	org/json/JSONException
    //   349	358	1398	org/json/JSONException
    //   438	448	1398	org/json/JSONException
    //   488	514	1398	org/json/JSONException
    //   554	559	1398	org/json/JSONException
    //   599	604	1398	org/json/JSONException
    //   772	782	1398	org/json/JSONException
    //   822	833	1398	org/json/JSONException
    //   873	883	1398	org/json/JSONException
    //   923	934	1398	org/json/JSONException
    //   974	990	1398	org/json/JSONException
    //   1030	1041	1398	org/json/JSONException
    //   1081	1091	1398	org/json/JSONException
    //   1131	1144	1398	org/json/JSONException
    //   1243	1254	1398	org/json/JSONException
    //   1294	1304	1398	org/json/JSONException
    //   1344	1355	1398	org/json/JSONException
    //   1516	1527	1398	org/json/JSONException
    //   1567	1577	1398	org/json/JSONException
    //   1617	1628	1398	org/json/JSONException
    //   1711	1722	1398	org/json/JSONException
    //   1762	1772	1398	org/json/JSONException
    //   1812	1823	1398	org/json/JSONException
    //   1906	1917	1398	org/json/JSONException
    //   1957	1967	1398	org/json/JSONException
    //   2007	2018	1398	org/json/JSONException
    //   2101	2112	1398	org/json/JSONException
    //   2152	2162	1398	org/json/JSONException
    //   2202	2213	1398	org/json/JSONException
    //   2296	2307	1398	org/json/JSONException
    //   2347	2357	1398	org/json/JSONException
    //   2397	2413	1398	org/json/JSONException
    //   2496	2507	1398	org/json/JSONException
    //   2547	2557	1398	org/json/JSONException
    //   2597	2613	1398	org/json/JSONException
    //   2696	2707	1398	org/json/JSONException
    //   2747	2757	1398	org/json/JSONException
    //   2797	2808	1398	org/json/JSONException
    //   2891	2901	1398	org/json/JSONException
    //   2981	2991	1398	org/json/JSONException
    //   3071	3083	1398	org/json/JSONException
    //   3123	3139	1398	org/json/JSONException
    //   3262	3272	1398	org/json/JSONException
    //   3352	3363	1398	org/json/JSONException
    //   3403	3416	1398	org/json/JSONException
    //   604	614	3503	org/json/JSONException
    //   614	624	3524	org/json/JSONException
    //   624	634	3541	org/json/JSONException
    //   634	644	3554	org/json/JSONException
    //   644	654	3571	org/json/JSONException
    //   654	664	3592	org/json/JSONException
    //   664	674	3617	org/json/JSONException
  }
  
  private JSONObject websiteQuery(Cursor paramCursor)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", paramCursor.getString(paramCursor.getColumnIndex("_id")));
      localJSONObject.put("pref", false);
      localJSONObject.put("value", paramCursor.getString(paramCursor.getColumnIndex("data1")));
      localJSONObject.put("type", getContactType(paramCursor.getInt(paramCursor.getColumnIndex("data2"))));
      return localJSONObject;
    }
    catch (JSONException paramCursor)
    {
      for (;;)
      {
        Log.e("ContactsAccessor", paramCursor.getMessage(), paramCursor);
      }
    }
  }
  
  public JSONObject getContactById(String paramString)
    throws JSONException
  {
    Object localObject1 = null;
    Object localObject2 = this.mApp.getActivity().getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, "contact_id = ? ", new String[] { paramString }, "contact_id ASC");
    paramString = new JSONArray();
    paramString.put("*");
    localObject2 = populateContactArray(1, buildPopulationSet(paramString), (Cursor)localObject2);
    paramString = (String)localObject1;
    if (((JSONArray)localObject2).length() == 1) {
      paramString = ((JSONArray)localObject2).getJSONObject(0);
    }
    return paramString;
  }
  
  public boolean remove(String paramString)
  {
    int i = 0;
    paramString = this.mApp.getActivity().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, "_id = ?", new String[] { paramString }, null);
    if (paramString.getCount() == 1)
    {
      paramString.moveToFirst();
      paramString = paramString.getString(paramString.getColumnIndex("lookup"));
      paramString = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, paramString);
      i = this.mApp.getActivity().getContentResolver().delete(paramString, null, null);
      if (i <= 0) {
        break label114;
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      Log.d("ContactsAccessor", "Could not find contact with ID");
      break;
    }
  }
  
  public String save(JSONObject paramJSONObject)
  {
    Account[] arrayOfAccount = AccountManager.get(this.mApp.getActivity()).getAccounts();
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    if (arrayOfAccount.length == 1)
    {
      localObject1 = arrayOfAccount[0].name;
      localObject2 = arrayOfAccount[0].type;
      localObject3 = getJsonString(paramJSONObject, "id");
      if (localObject3 != null) {
        break label318;
      }
    }
    label93:
    label172:
    label306:
    label318:
    for (paramJSONObject = createNewContact(paramJSONObject, (String)localObject2, (String)localObject1);; paramJSONObject = modifyContact((String)localObject3, paramJSONObject, (String)localObject2, (String)localObject1))
    {
      return paramJSONObject;
      if (arrayOfAccount.length <= 1) {
        break;
      }
      int j = arrayOfAccount.length;
      int i = 0;
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (i < j)
      {
        localObject1 = arrayOfAccount[i];
        if ((((Account)localObject1).type.contains("eas")) && (((Account)localObject1).name.matches(".+@.+\\.+.+")))
        {
          localObject2 = ((Account)localObject1).name;
          localObject1 = ((Account)localObject1).type;
        }
      }
      else
      {
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (localObject2 == null)
        {
          j = arrayOfAccount.length;
          i = 0;
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (i < j)
          {
            localObject3 = arrayOfAccount[i];
            if ((!((Account)localObject3).type.contains("com.google")) || (!((Account)localObject3).name.matches(".+@.+\\.+.+"))) {
              break label306;
            }
            localObject4 = ((Account)localObject3).name;
            localObject3 = ((Account)localObject3).type;
          }
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (localObject4 != null) {
          break;
        }
        j = arrayOfAccount.length;
      }
      for (i = 0;; i++)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (i >= j) {
          break;
        }
        localObject2 = arrayOfAccount[i];
        if (((Account)localObject2).name.matches(".+@.+\\.+.+"))
        {
          localObject1 = ((Account)localObject2).name;
          localObject2 = ((Account)localObject2).type;
          break;
          i++;
          break label93;
          i++;
          break label172;
        }
      }
    }
  }
  
  public JSONArray search(JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    int i = Integer.MAX_VALUE;
    if (paramJSONObject != null)
    {
      localObject1 = paramJSONObject.optString("filter");
      if (((String)localObject1).length() == 0) {
        localObject1 = "%";
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = paramJSONObject.getBoolean("multiple");
        paramJSONObject = (JSONObject)localObject1;
        if (!bool)
        {
          i = 1;
          paramJSONObject = (JSONObject)localObject1;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Object localObject3;
        ContentResolver localContentResolver;
        Object localObject2;
        int j;
        int k;
        paramJSONObject = (JSONObject)localObject1;
        continue;
      }
      localObject1 = buildPopulationSet(paramJSONArray);
      localObject3 = buildWhereClause(paramJSONArray, paramJSONObject);
      localContentResolver = this.mApp.getActivity().getContentResolver();
      localObject2 = ContactsContract.Data.CONTENT_URI;
      paramJSONArray = ((ContactAccessor.WhereOptions)localObject3).getWhere();
      localObject3 = ((ContactAccessor.WhereOptions)localObject3).getWhereArgs();
      localObject2 = localContentResolver.query((Uri)localObject2, new String[] { "contact_id" }, paramJSONArray, (String[])localObject3, "contact_id ASC");
      paramJSONArray = new HashSet();
      j = -1;
      if (!((Cursor)localObject2).moveToNext()) {
        continue;
      }
      k = j;
      if (j < 0) {
        k = ((Cursor)localObject2).getColumnIndex("contact_id");
      }
      paramJSONArray.add(((Cursor)localObject2).getString(k));
      j = k;
      continue;
      localObject1 = "%" + (String)localObject1 + "%";
      continue;
      paramJSONObject = "%";
    }
    ((Cursor)localObject2).close();
    paramJSONArray = buildIdClause(paramJSONArray, paramJSONObject);
    paramJSONObject = new HashSet();
    paramJSONObject.add("contact_id");
    paramJSONObject.add("raw_contact_id");
    paramJSONObject.add("mimetype");
    if (isRequired("displayName", (HashMap)localObject1)) {
      paramJSONObject.add("data1");
    }
    if (isRequired("name", (HashMap)localObject1))
    {
      paramJSONObject.add("data3");
      paramJSONObject.add("data2");
      paramJSONObject.add("data5");
      paramJSONObject.add("data4");
      paramJSONObject.add("data6");
    }
    if (isRequired("phoneNumbers", (HashMap)localObject1))
    {
      paramJSONObject.add("_id");
      paramJSONObject.add("data1");
      paramJSONObject.add("data2");
    }
    if (isRequired("emails", (HashMap)localObject1))
    {
      paramJSONObject.add("_id");
      paramJSONObject.add("data1");
      paramJSONObject.add("data2");
    }
    if (isRequired("addresses", (HashMap)localObject1))
    {
      paramJSONObject.add("_id");
      paramJSONObject.add("data2");
      paramJSONObject.add("data1");
      paramJSONObject.add("data4");
      paramJSONObject.add("data7");
      paramJSONObject.add("data8");
      paramJSONObject.add("data9");
      paramJSONObject.add("data10");
    }
    if (isRequired("organizations", (HashMap)localObject1))
    {
      paramJSONObject.add("_id");
      paramJSONObject.add("data2");
      paramJSONObject.add("data5");
      paramJSONObject.add("data1");
      paramJSONObject.add("data4");
    }
    if (isRequired("ims", (HashMap)localObject1))
    {
      paramJSONObject.add("_id");
      paramJSONObject.add("data1");
      paramJSONObject.add("data2");
    }
    if (isRequired("note", (HashMap)localObject1)) {
      paramJSONObject.add("data1");
    }
    if (isRequired("nickname", (HashMap)localObject1)) {
      paramJSONObject.add("data1");
    }
    if (isRequired("urls", (HashMap)localObject1))
    {
      paramJSONObject.add("_id");
      paramJSONObject.add("data1");
      paramJSONObject.add("data2");
    }
    if (isRequired("birthday", (HashMap)localObject1))
    {
      paramJSONObject.add("data1");
      paramJSONObject.add("data2");
    }
    if (isRequired("photos", (HashMap)localObject1)) {
      paramJSONObject.add("_id");
    }
    return populateContactArray(i, (HashMap)localObject1, this.mApp.getActivity().getContentResolver().query(ContactsContract.Data.CONTENT_URI, (String[])paramJSONObject.toArray(new String[0]), paramJSONArray.getWhere(), paramJSONArray.getWhereArgs(), "contact_id ASC"));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\ContactAccessorSdk5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */