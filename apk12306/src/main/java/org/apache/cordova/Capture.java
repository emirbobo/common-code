package org.apache.cordova;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Capture
  extends CordovaPlugin
{
  private static final String AUDIO_3GPP = "audio/3gpp";
  private static final int CAPTURE_AUDIO = 0;
  private static final int CAPTURE_IMAGE = 1;
  private static final int CAPTURE_INTERNAL_ERR = 0;
  private static final int CAPTURE_NO_MEDIA_FILES = 3;
  private static final int CAPTURE_VIDEO = 2;
  private static final String IMAGE_JPEG = "image/jpeg";
  private static final String LOG_TAG = "Capture";
  private static final String VIDEO_3GPP = "video/3gpp";
  private static final String VIDEO_MP4 = "video/mp4";
  private CallbackContext callbackContext;
  private double duration;
  private long limit;
  private int numPics;
  private JSONArray results;
  
  private void captureAudio()
  {
    Intent localIntent = new Intent("android.provider.MediaStore.RECORD_SOUND");
    this.cordova.startActivityForResult(this, localIntent, 0);
  }
  
  private void captureImage()
  {
    this.numPics = queryImgDB(whichContentStore()).getCount();
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", Uri.fromFile(new File(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()), "Capture.jpg")));
    this.cordova.startActivityForResult(this, localIntent, 1);
  }
  
  private void captureVideo(double paramDouble)
  {
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    if (Build.VERSION.SDK_INT > 8) {
      localIntent.putExtra("android.intent.extra.durationLimit", paramDouble);
    }
    this.cordova.startActivityForResult(this, localIntent, 2);
  }
  
  private void checkForDuplicateImage()
  {
    Uri localUri = whichContentStore();
    Object localObject = queryImgDB(localUri);
    if (((Cursor)localObject).getCount() - this.numPics == 2)
    {
      ((Cursor)localObject).moveToLast();
      int i = Integer.valueOf(((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("_id"))).intValue();
      localObject = Uri.parse(localUri + "/" + (i - 1));
      this.cordova.getActivity().getContentResolver().delete((Uri)localObject, null, null);
    }
  }
  
  private JSONObject createErrorObject(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  private JSONObject createMediaFile(Uri paramUri)
  {
    localFile = new File(FileHelper.getRealPath(paramUri, this.cordova));
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("name", localFile.getName());
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localJSONObject.put("fullPath", "file://" + localFile.getAbsolutePath());
        if ((!localFile.getAbsoluteFile().toString().endsWith(".3gp")) && (!localFile.getAbsoluteFile().toString().endsWith(".3gpp"))) {
          continue;
        }
        if (!paramUri.toString().contains("/audio/")) {
          continue;
        }
        localJSONObject.put("type", "audio/3gpp");
      }
      catch (JSONException paramUri)
      {
        paramUri.printStackTrace();
        continue;
        localJSONObject.put("type", FileHelper.getMimeType(localFile.getAbsolutePath(), this.cordova));
        continue;
      }
      localJSONObject.put("lastModifiedDate", localFile.lastModified());
      localJSONObject.put("size", localFile.length());
      return localJSONObject;
      localJSONObject.put("type", "video/3gpp");
    }
  }
  
  private JSONObject getAudioVideoData(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
    throws JSONException
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      paramJSONObject.put("duration", localMediaPlayer.getDuration() / 1000);
      if (paramBoolean)
      {
        paramJSONObject.put("height", localMediaPlayer.getVideoHeight());
        paramJSONObject.put("width", localMediaPlayer.getVideoWidth());
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.d("Capture", "Error: loading video file");
      }
    }
    return paramJSONObject;
  }
  
  private JSONObject getFormatData(String paramString1, String paramString2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("height", 0);
    localJSONObject.put("width", 0);
    localJSONObject.put("bitrate", 0);
    localJSONObject.put("duration", 0);
    localJSONObject.put("codecs", "");
    String str;
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      str = paramString2;
      if (!"null".equals(paramString2)) {}
    }
    else
    {
      str = FileHelper.getMimeType(paramString1, this.cordova);
    }
    Log.d("Capture", "Mime type = " + str);
    if ((str.equals("image/jpeg")) || (paramString1.endsWith(".jpg"))) {
      paramString2 = getImageData(paramString1, localJSONObject);
    }
    for (;;)
    {
      return paramString2;
      if (str.endsWith("audio/3gpp"))
      {
        paramString2 = getAudioVideoData(paramString1, localJSONObject, false);
      }
      else if (!str.equals("video/3gpp"))
      {
        paramString2 = localJSONObject;
        if (!str.equals("video/mp4")) {}
      }
      else
      {
        paramString2 = getAudioVideoData(paramString1, localJSONObject, true);
      }
    }
  }
  
  private JSONObject getImageData(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(FileHelper.stripFileProtocol(paramString), localOptions);
    paramJSONObject.put("height", localOptions.outHeight);
    paramJSONObject.put("width", localOptions.outWidth);
    return paramJSONObject;
  }
  
  private String getTempDirectoryPath()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache/");; localFile = this.cordova.getActivity().getCacheDir())
    {
      localFile.mkdirs();
      return localFile.getAbsolutePath();
    }
  }
  
  private Cursor queryImgDB(Uri paramUri)
  {
    return this.cordova.getActivity().getContentResolver().query(paramUri, new String[] { "_id" }, null, null, null);
  }
  
  private Uri whichContentStore()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;; localUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI) {
      return localUri;
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    this.callbackContext = paramCallbackContext;
    this.limit = 1L;
    this.duration = 0.0D;
    this.results = new JSONArray();
    JSONObject localJSONObject = paramJSONArray.optJSONObject(0);
    if (localJSONObject != null)
    {
      this.limit = localJSONObject.optLong("limit", 1L);
      this.duration = localJSONObject.optDouble("duration", 0.0D);
    }
    if (paramString.equals("getFormatData")) {
      paramCallbackContext.success(getFormatData(paramJSONArray.getString(0), paramJSONArray.getString(1)));
    }
    for (;;)
    {
      return bool;
      if (paramString.equals("captureAudio")) {
        captureAudio();
      } else if (paramString.equals("captureImage")) {
        captureImage();
      } else if (paramString.equals("captureVideo")) {
        captureVideo(this.duration);
      } else {
        bool = false;
      }
    }
  }
  
  public void fail(JSONObject paramJSONObject)
  {
    this.callbackContext.error(paramJSONObject);
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_m1
    //   2: if_icmpne +483 -> 485
    //   5: iload_1
    //   6: ifne +66 -> 72
    //   9: aload_3
    //   10: invokevirtual 442	android/content/Intent:getData	()Landroid/net/Uri;
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   18: aload_0
    //   19: aload_3
    //   20: invokespecial 444	org/apache/cordova/Capture:createMediaFile	(Landroid/net/Uri;)Lorg/json/JSONObject;
    //   23: invokevirtual 447	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   26: pop
    //   27: aload_0
    //   28: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   31: invokevirtual 449	org/json/JSONArray:length	()I
    //   34: i2l
    //   35: aload_0
    //   36: getfield 392	org/apache/cordova/Capture:limit	J
    //   39: lcmp
    //   40: iflt +25 -> 65
    //   43: aload_0
    //   44: getfield 390	org/apache/cordova/Capture:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   47: new 451	org/apache/cordova/api/PluginResult
    //   50: dup
    //   51: getstatic 457	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   54: aload_0
    //   55: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   58: invokespecial 460	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONArray;)V
    //   61: invokevirtual 464	org/apache/cordova/api/CallbackContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   64: return
    //   65: aload_0
    //   66: invokespecial 425	org/apache/cordova/Capture:captureAudio	()V
    //   69: goto -5 -> 64
    //   72: iload_1
    //   73: iconst_1
    //   74: if_icmpne +303 -> 377
    //   77: new 466	android/content/ContentValues
    //   80: astore 4
    //   82: aload 4
    //   84: invokespecial 467	android/content/ContentValues:<init>	()V
    //   87: aload 4
    //   89: ldc_w 469
    //   92: ldc 21
    //   94: invokevirtual 471	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 56	org/apache/cordova/Capture:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   101: invokeinterface 89 1 0
    //   106: invokevirtual 177	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   109: getstatic 383	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   112: aload 4
    //   114: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   117: astore_3
    //   118: new 477	java/io/FileInputStream
    //   121: astore 4
    //   123: new 150	java/lang/StringBuilder
    //   126: astore 5
    //   128: aload 5
    //   130: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   133: aload 4
    //   135: aload 5
    //   137: aload_0
    //   138: getfield 56	org/apache/cordova/Capture:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   141: invokeinterface 89 1 0
    //   146: invokestatic 95	org/apache/cordova/DirectoryManager:getTempDirectoryPath	(Landroid/content/Context;)Ljava/lang/String;
    //   149: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc_w 479
    //   155: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 480	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   164: aload_0
    //   165: getfield 56	org/apache/cordova/Capture:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   168: invokeinterface 89 1 0
    //   173: invokevirtual 177	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   176: aload_3
    //   177: invokevirtual 484	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   180: astore 6
    //   182: sipush 4096
    //   185: newarray <illegal type>
    //   187: astore 5
    //   189: aload 4
    //   191: aload 5
    //   193: invokevirtual 488	java/io/FileInputStream:read	([B)I
    //   196: istore_1
    //   197: iload_1
    //   198: iconst_m1
    //   199: if_icmpeq +92 -> 291
    //   202: aload 6
    //   204: aload 5
    //   206: iconst_0
    //   207: iload_1
    //   208: invokevirtual 494	java/io/OutputStream:write	([BII)V
    //   211: goto -22 -> 189
    //   214: astore_3
    //   215: aload_3
    //   216: invokevirtual 495	java/io/IOException:printStackTrace	()V
    //   219: aload_0
    //   220: aload_0
    //   221: iconst_0
    //   222: ldc_w 497
    //   225: invokespecial 499	org/apache/cordova/Capture:createErrorObject	(ILjava/lang/String;)Lorg/json/JSONObject;
    //   228: invokevirtual 501	org/apache/cordova/Capture:fail	(Lorg/json/JSONObject;)V
    //   231: goto -167 -> 64
    //   234: astore_3
    //   235: ldc 24
    //   237: ldc_w 503
    //   240: invokestatic 507	org/apache/cordova/api/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_0
    //   244: getfield 56	org/apache/cordova/Capture:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   247: invokeinterface 89 1 0
    //   252: invokevirtual 177	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   255: getstatic 386	android/provider/MediaStore$Images$Media:INTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   258: aload 4
    //   260: invokevirtual 475	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   263: astore_3
    //   264: goto -146 -> 118
    //   267: astore_3
    //   268: ldc 24
    //   270: ldc_w 509
    //   273: invokestatic 507	org/apache/cordova/api/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: aload_0
    //   278: iconst_0
    //   279: ldc_w 511
    //   282: invokespecial 499	org/apache/cordova/Capture:createErrorObject	(ILjava/lang/String;)Lorg/json/JSONObject;
    //   285: invokevirtual 501	org/apache/cordova/Capture:fail	(Lorg/json/JSONObject;)V
    //   288: goto -224 -> 64
    //   291: aload 6
    //   293: invokevirtual 514	java/io/OutputStream:flush	()V
    //   296: aload 6
    //   298: invokevirtual 517	java/io/OutputStream:close	()V
    //   301: aload 4
    //   303: invokevirtual 518	java/io/FileInputStream:close	()V
    //   306: aload_0
    //   307: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   310: aload_0
    //   311: aload_3
    //   312: invokespecial 444	org/apache/cordova/Capture:createMediaFile	(Landroid/net/Uri;)Lorg/json/JSONObject;
    //   315: invokevirtual 447	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   318: pop
    //   319: aload_0
    //   320: invokespecial 520	org/apache/cordova/Capture:checkForDuplicateImage	()V
    //   323: aload_0
    //   324: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   327: invokevirtual 449	org/json/JSONArray:length	()I
    //   330: i2l
    //   331: aload_0
    //   332: getfield 392	org/apache/cordova/Capture:limit	J
    //   335: lcmp
    //   336: iflt +34 -> 370
    //   339: aload_0
    //   340: getfield 390	org/apache/cordova/Capture:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   343: astore_3
    //   344: new 451	org/apache/cordova/api/PluginResult
    //   347: astore 4
    //   349: aload 4
    //   351: getstatic 457	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   354: aload_0
    //   355: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   358: invokespecial 460	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONArray;)V
    //   361: aload_3
    //   362: aload 4
    //   364: invokevirtual 464	org/apache/cordova/api/CallbackContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   367: goto -303 -> 64
    //   370: aload_0
    //   371: invokespecial 428	org/apache/cordova/Capture:captureImage	()V
    //   374: goto -310 -> 64
    //   377: iload_1
    //   378: iconst_2
    //   379: if_icmpne -315 -> 64
    //   382: aconst_null
    //   383: astore 4
    //   385: aload_3
    //   386: ifnull +9 -> 395
    //   389: aload_3
    //   390: invokevirtual 442	android/content/Intent:getData	()Landroid/net/Uri;
    //   393: astore 4
    //   395: aload 4
    //   397: astore_3
    //   398: aload 4
    //   400: ifnonnull +21 -> 421
    //   403: new 85	java/io/File
    //   406: dup
    //   407: aload_0
    //   408: invokespecial 522	org/apache/cordova/Capture:getTempDirectoryPath	()Ljava/lang/String;
    //   411: ldc_w 524
    //   414: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: invokestatic 106	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   420: astore_3
    //   421: aload_0
    //   422: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   425: aload_0
    //   426: aload_3
    //   427: invokespecial 444	org/apache/cordova/Capture:createMediaFile	(Landroid/net/Uri;)Lorg/json/JSONObject;
    //   430: invokevirtual 447	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   433: pop
    //   434: aload_0
    //   435: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   438: invokevirtual 449	org/json/JSONArray:length	()I
    //   441: i2l
    //   442: aload_0
    //   443: getfield 392	org/apache/cordova/Capture:limit	J
    //   446: lcmp
    //   447: iflt +27 -> 474
    //   450: aload_0
    //   451: getfield 390	org/apache/cordova/Capture:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   454: new 451	org/apache/cordova/api/PluginResult
    //   457: dup
    //   458: getstatic 457	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   461: aload_0
    //   462: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   465: invokespecial 460	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONArray;)V
    //   468: invokevirtual 464	org/apache/cordova/api/CallbackContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   471: goto -407 -> 64
    //   474: aload_0
    //   475: aload_0
    //   476: getfield 394	org/apache/cordova/Capture:duration	D
    //   479: invokespecial 431	org/apache/cordova/Capture:captureVideo	(D)V
    //   482: goto -418 -> 64
    //   485: iload_2
    //   486: ifne +52 -> 538
    //   489: aload_0
    //   490: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   493: invokevirtual 449	org/json/JSONArray:length	()I
    //   496: ifle +27 -> 523
    //   499: aload_0
    //   500: getfield 390	org/apache/cordova/Capture:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   503: new 451	org/apache/cordova/api/PluginResult
    //   506: dup
    //   507: getstatic 457	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   510: aload_0
    //   511: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   514: invokespecial 460	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONArray;)V
    //   517: invokevirtual 464	org/apache/cordova/api/CallbackContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   520: goto -456 -> 64
    //   523: aload_0
    //   524: aload_0
    //   525: iconst_3
    //   526: ldc_w 526
    //   529: invokespecial 499	org/apache/cordova/Capture:createErrorObject	(ILjava/lang/String;)Lorg/json/JSONObject;
    //   532: invokevirtual 501	org/apache/cordova/Capture:fail	(Lorg/json/JSONObject;)V
    //   535: goto -471 -> 64
    //   538: aload_0
    //   539: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   542: invokevirtual 449	org/json/JSONArray:length	()I
    //   545: ifle +27 -> 572
    //   548: aload_0
    //   549: getfield 390	org/apache/cordova/Capture:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   552: new 451	org/apache/cordova/api/PluginResult
    //   555: dup
    //   556: getstatic 457	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   559: aload_0
    //   560: getfield 399	org/apache/cordova/Capture:results	Lorg/json/JSONArray;
    //   563: invokespecial 460	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONArray;)V
    //   566: invokevirtual 464	org/apache/cordova/api/CallbackContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   569: goto -505 -> 64
    //   572: aload_0
    //   573: aload_0
    //   574: iconst_3
    //   575: ldc_w 528
    //   578: invokespecial 499	org/apache/cordova/Capture:createErrorObject	(ILjava/lang/String;)Lorg/json/JSONObject;
    //   581: invokevirtual 501	org/apache/cordova/Capture:fail	(Lorg/json/JSONObject;)V
    //   584: goto -520 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	587	0	this	Capture
    //   0	587	1	paramInt1	int
    //   0	587	2	paramInt2	int
    //   0	587	3	paramIntent	Intent
    //   80	319	4	localObject1	Object
    //   126	79	5	localObject2	Object
    //   180	117	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   77	97	214	java/io/IOException
    //   97	118	214	java/io/IOException
    //   118	189	214	java/io/IOException
    //   189	197	214	java/io/IOException
    //   202	211	214	java/io/IOException
    //   235	243	214	java/io/IOException
    //   243	264	214	java/io/IOException
    //   268	288	214	java/io/IOException
    //   291	367	214	java/io/IOException
    //   370	374	214	java/io/IOException
    //   97	118	234	java/lang/UnsupportedOperationException
    //   243	264	267	java/lang/UnsupportedOperationException
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\Capture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */