package org.apache.cordova;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.LOG;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

public class CameraLauncher
  extends CordovaPlugin
  implements MediaScannerConnection.MediaScannerConnectionClient
{
  private static final int ALLMEDIA = 2;
  private static final int CAMERA = 1;
  private static final int DATA_URL = 0;
  private static final int FILE_URI = 1;
  private static final String GET_All = "Get All";
  private static final String GET_PICTURE = "Get Picture";
  private static final String GET_VIDEO = "Get Video";
  private static final int JPEG = 0;
  private static final String LOG_TAG = "CameraLauncher";
  private static final int NATIVE_URI = 2;
  private static final int PHOTOLIBRARY = 0;
  private static final int PICTURE = 0;
  private static final int PNG = 1;
  private static final int SAVEDPHOTOALBUM = 2;
  private static final int VIDEO = 1;
  public CallbackContext callbackContext;
  private MediaScannerConnection conn;
  private boolean correctOrientation;
  private int encodingType;
  private Uri imageUri;
  private int mQuality;
  private int mediaType;
  private int numPics;
  private boolean saveToPhotoAlbum;
  private Uri scanMe;
  private int targetHeight;
  private int targetWidth;
  
  public static int calculateSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 / paramInt2 > paramInt3 / paramInt4) {
      paramInt1 /= paramInt3;
    }
    for (;;)
    {
      return paramInt1;
      paramInt1 = paramInt2 / paramInt4;
    }
  }
  
  private void checkForDuplicateImage(int paramInt)
  {
    int j = 1;
    Uri localUri = whichContentStore();
    Object localObject = queryImgDB(localUri);
    int k = ((Cursor)localObject).getCount();
    int i = j;
    if (paramInt == 1)
    {
      i = j;
      if (this.saveToPhotoAlbum) {
        i = 2;
      }
    }
    if (k - this.numPics == i)
    {
      ((Cursor)localObject).moveToLast();
      j = Integer.valueOf(((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("_id"))).intValue();
      paramInt = j;
      if (i == 2) {
        paramInt = j - 1;
      }
      localObject = Uri.parse(localUri + "/" + paramInt);
      this.cordova.getActivity().getContentResolver().delete((Uri)localObject, null, null);
    }
  }
  
  private void cleanup(int paramInt, Uri paramUri1, Uri paramUri2, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      paramBitmap.recycle();
    }
    new File(FileHelper.stripFileProtocol(paramUri1.toString())).delete();
    checkForDuplicateImage(paramInt);
    if ((this.saveToPhotoAlbum) && (paramUri2 != null)) {
      scanForGallery(paramUri2);
    }
    System.gc();
  }
  
  private File createCaptureFile(int paramInt)
  {
    if (paramInt == 0) {}
    for (File localFile = new File(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()), ".Pic.jpg");; localFile = new File(DirectoryManager.getTempDirectoryPath(this.cordova.getActivity()), ".Pic.png"))
    {
      return localFile;
      if (paramInt != 1) {
        break;
      }
    }
    throw new IllegalArgumentException("Invalid Encoding Type: " + paramInt);
  }
  
  private Bitmap getRotatedBitmap(int paramInt, Bitmap paramBitmap, ExifHelper paramExifHelper)
  {
    Matrix localMatrix = new Matrix();
    if (paramInt == 180) {
      localMatrix.setRotate(paramInt);
    }
    for (;;)
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      paramExifHelper.resetOrientation();
      return paramBitmap;
      localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
  }
  
  private Bitmap getScaledBitmap(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.targetWidth <= 0) && (this.targetHeight <= 0)) {
      localObject1 = BitmapFactory.decodeFile(paramString);
    }
    for (;;)
    {
      return (Bitmap)localObject1;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      localObject1 = localObject2;
      if (localOptions.outWidth != 0)
      {
        localObject1 = localObject2;
        if (localOptions.outHeight != 0)
        {
          int[] arrayOfInt = calculateAspectRatio(localOptions.outWidth, localOptions.outHeight);
          localOptions.inJustDecodeBounds = false;
          localOptions.inSampleSize = calculateSampleSize(localOptions.outWidth, localOptions.outHeight, this.targetWidth, this.targetHeight);
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          localObject1 = localObject2;
          if (paramString != null) {
            localObject1 = Bitmap.createScaledBitmap(paramString, arrayOfInt[0], arrayOfInt[1], true);
          }
        }
      }
    }
  }
  
  private Uri getUriFromMediaStore()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("mime_type", "image/jpeg");
    try
    {
      Uri localUri1 = this.cordova.getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);
      return localUri1;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException1)
    {
      for (;;)
      {
        LOG.d("CameraLauncher", "Can't write to external media storage.");
        try
        {
          Uri localUri2 = this.cordova.getActivity().getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, localContentValues);
        }
        catch (UnsupportedOperationException localUnsupportedOperationException2)
        {
          LOG.d("CameraLauncher", "Can't write to internal media storage.");
          Object localObject = null;
        }
      }
    }
  }
  
  private Cursor queryImgDB(Uri paramUri)
  {
    return this.cordova.getActivity().getContentResolver().query(paramUri, new String[] { "_id" }, null, null, null);
  }
  
  private void scanForGallery(Uri paramUri)
  {
    this.scanMe = paramUri;
    if (this.conn != null) {
      this.conn.disconnect();
    }
    this.conn = new MediaScannerConnection(this.cordova.getActivity().getApplicationContext(), this);
    this.conn.connect();
  }
  
  private Uri whichContentStore()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;; localUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI) {
      return localUri;
    }
  }
  
  private void writeUncompressedImage(Uri paramUri)
    throws FileNotFoundException, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(FileHelper.stripFileProtocol(this.imageUri.toString()));
    paramUri = this.cordova.getActivity().getContentResolver().openOutputStream(paramUri);
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = localFileInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramUri.write(arrayOfByte, 0, i);
    }
    paramUri.flush();
    paramUri.close();
    localFileInputStream.close();
  }
  
  public int[] calculateAspectRatio(int paramInt1, int paramInt2)
  {
    int j = this.targetWidth;
    int k = this.targetHeight;
    int i;
    if ((j <= 0) && (k <= 0))
    {
      j = paramInt1;
      i = paramInt2;
    }
    for (;;)
    {
      return new int[] { j, i };
      if ((j > 0) && (k <= 0))
      {
        i = j * paramInt2 / paramInt1;
      }
      else if ((j <= 0) && (k > 0))
      {
        j = k * paramInt1 / paramInt2;
        i = k;
      }
      else
      {
        double d1 = j / k;
        double d2 = paramInt1 / paramInt2;
        if (d2 > d1)
        {
          i = j * paramInt2 / paramInt1;
        }
        else
        {
          i = k;
          if (d2 < d1)
          {
            j = k * paramInt1 / paramInt2;
            i = k;
          }
        }
      }
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    this.callbackContext = paramCallbackContext;
    int j;
    int i;
    if (paramString.equals("takePicture"))
    {
      this.saveToPhotoAlbum = false;
      this.targetHeight = 0;
      this.targetWidth = 0;
      this.encodingType = 0;
      this.mediaType = 0;
      this.mQuality = 80;
      this.mQuality = paramJSONArray.getInt(0);
      j = paramJSONArray.getInt(1);
      i = paramJSONArray.getInt(2);
      this.targetWidth = paramJSONArray.getInt(3);
      this.targetHeight = paramJSONArray.getInt(4);
      this.encodingType = paramJSONArray.getInt(5);
      this.mediaType = paramJSONArray.getInt(6);
      this.correctOrientation = paramJSONArray.getBoolean(8);
      this.saveToPhotoAlbum = paramJSONArray.getBoolean(9);
      if (this.targetWidth < 1) {
        this.targetWidth = -1;
      }
      if (this.targetHeight < 1) {
        this.targetHeight = -1;
      }
      if (i == 1)
      {
        takePicture(j, this.encodingType);
        paramString = new PluginResult(PluginResult.Status.NO_RESULT);
        paramString.setKeepCallback(true);
        paramCallbackContext.sendPluginResult(paramString);
      }
    }
    for (;;)
    {
      return bool;
      if ((i != 0) && (i != 2)) {
        break;
      }
      getImage(i, j);
      break;
      bool = false;
    }
  }
  
  public void failPicture(String paramString)
  {
    this.callbackContext.error(paramString);
  }
  
  public void getImage(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    String str = "Get Picture";
    if (this.mediaType == 0)
    {
      localIntent.setType("image/*");
      if (Build.VERSION.SDK_INT >= 19) {
        break label141;
      }
      localIntent.setAction("android.intent.action.GET_CONTENT");
      localIntent.addCategory("android.intent.category.OPENABLE");
      if (this.cordova != null) {
        this.cordova.startActivityForResult(this, Intent.createChooser(localIntent, new String(str)), (paramInt1 + 1) * 16 + paramInt2 + 1);
      }
    }
    for (;;)
    {
      return;
      if (this.mediaType == 1)
      {
        localIntent.setType("video/*");
        str = "Get Video";
        break;
      }
      if (this.mediaType != 2) {
        break;
      }
      localIntent.setType("*/*");
      str = "Get All";
      break;
      label141:
      localIntent.setAction("android.intent.action.PICK");
      localIntent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      if (this.cordova != null) {
        this.cordova.startActivityForResult(this, localIntent, (paramInt1 + 1) * 16 + paramInt2 + 1);
      }
    }
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: bipush 16
    //   3: idiv
    //   4: iconst_1
    //   5: isub
    //   6: istore 6
    //   8: iload_1
    //   9: bipush 16
    //   11: irem
    //   12: iconst_1
    //   13: isub
    //   14: istore 5
    //   16: iconst_0
    //   17: istore_1
    //   18: iconst_0
    //   19: istore 4
    //   21: iload 6
    //   23: iconst_1
    //   24: if_icmpne +594 -> 618
    //   27: iload_2
    //   28: iconst_m1
    //   29: if_icmpne +565 -> 594
    //   32: new 220	org/apache/cordova/ExifHelper
    //   35: astore 10
    //   37: aload 10
    //   39: invokespecial 472	org/apache/cordova/ExifHelper:<init>	()V
    //   42: iload 4
    //   44: istore_1
    //   45: aload_0
    //   46: getfield 377	org/apache/cordova/CameraLauncher:encodingType	I
    //   49: ifne +55 -> 104
    //   52: new 102	java/lang/StringBuilder
    //   55: astore 7
    //   57: aload 7
    //   59: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   62: aload 10
    //   64: aload 7
    //   66: aload_0
    //   67: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   70: invokeinterface 135 1 0
    //   75: invokestatic 187	org/apache/cordova/DirectoryManager:getTempDirectoryPath	(Landroid/content/Context;)Ljava/lang/String;
    //   78: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 474
    //   84: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokevirtual 477	org/apache/cordova/ExifHelper:createInFile	(Ljava/lang/String;)V
    //   93: aload 10
    //   95: invokevirtual 480	org/apache/cordova/ExifHelper:readExifData	()V
    //   98: aload 10
    //   100: invokevirtual 483	org/apache/cordova/ExifHelper:getOrientation	()I
    //   103: istore_1
    //   104: aconst_null
    //   105: astore 9
    //   107: aconst_null
    //   108: astore 7
    //   110: aconst_null
    //   111: astore 8
    //   113: iload 5
    //   115: ifne +149 -> 264
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 344	org/apache/cordova/CameraLauncher:imageUri	Landroid/net/Uri;
    //   123: invokevirtual 157	android/net/Uri:toString	()Ljava/lang/String;
    //   126: invokestatic 163	org/apache/cordova/FileHelper:stripFileProtocol	(Ljava/lang/String;)Ljava/lang/String;
    //   129: invokespecial 485	org/apache/cordova/CameraLauncher:getScaledBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   132: astore 9
    //   134: aload 9
    //   136: astore 7
    //   138: aload 9
    //   140: ifnonnull +18 -> 158
    //   143: aload_3
    //   144: invokevirtual 489	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   147: ldc_w 491
    //   150: invokevirtual 497	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   153: checkcast 151	android/graphics/Bitmap
    //   156: astore 7
    //   158: aload 7
    //   160: ifnonnull +48 -> 208
    //   163: ldc 28
    //   165: ldc_w 499
    //   168: invokestatic 504	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload_0
    //   173: ldc_w 506
    //   176: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   179: return
    //   180: astore 7
    //   182: aload 7
    //   184: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   187: iload 4
    //   189: istore_1
    //   190: goto -86 -> 104
    //   193: astore_3
    //   194: aload_3
    //   195: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   198: aload_0
    //   199: ldc_w 513
    //   202: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   205: goto -26 -> 179
    //   208: aload 7
    //   210: astore_3
    //   211: iload_1
    //   212: ifeq +23 -> 235
    //   215: aload 7
    //   217: astore_3
    //   218: aload_0
    //   219: getfield 393	org/apache/cordova/CameraLauncher:correctOrientation	Z
    //   222: ifeq +13 -> 235
    //   225: aload_0
    //   226: iload_1
    //   227: aload 7
    //   229: aload 10
    //   231: invokespecial 515	org/apache/cordova/CameraLauncher:getRotatedBitmap	(ILandroid/graphics/Bitmap;Lorg/apache/cordova/ExifHelper;)Landroid/graphics/Bitmap;
    //   234: astore_3
    //   235: aload_0
    //   236: aload_3
    //   237: invokevirtual 519	org/apache/cordova/CameraLauncher:processPicture	(Landroid/graphics/Bitmap;)V
    //   240: aload_0
    //   241: iconst_0
    //   242: invokespecial 170	org/apache/cordova/CameraLauncher:checkForDuplicateImage	(I)V
    //   245: aload_3
    //   246: astore 7
    //   248: aload_0
    //   249: iconst_1
    //   250: aload_0
    //   251: getfield 344	org/apache/cordova/CameraLauncher:imageUri	Landroid/net/Uri;
    //   254: aload 8
    //   256: aload 7
    //   258: invokespecial 521	org/apache/cordova/CameraLauncher:cleanup	(ILandroid/net/Uri;Landroid/net/Uri;Landroid/graphics/Bitmap;)V
    //   261: goto -82 -> 179
    //   264: iload 5
    //   266: iconst_1
    //   267: if_icmpeq +9 -> 276
    //   270: iload 5
    //   272: iconst_2
    //   273: if_icmpne -25 -> 248
    //   276: aload_0
    //   277: getfield 75	org/apache/cordova/CameraLauncher:saveToPhotoAlbum	Z
    //   280: ifeq +115 -> 395
    //   283: aload_0
    //   284: invokespecial 523	org/apache/cordova/CameraLauncher:getUriFromMediaStore	()Landroid/net/Uri;
    //   287: astore 7
    //   289: new 156	java/io/File
    //   292: astore_3
    //   293: aload_3
    //   294: aload 7
    //   296: aload_0
    //   297: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   300: invokestatic 527	org/apache/cordova/FileHelper:getRealPath	(Landroid/net/Uri;Lorg/apache/cordova/api/CordovaInterface;)Ljava/lang/String;
    //   303: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: aload_3
    //   307: invokestatic 531	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   310: astore_3
    //   311: aload_3
    //   312: ifnonnull +10 -> 322
    //   315: aload_0
    //   316: ldc_w 533
    //   319: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   322: aload_0
    //   323: getfield 232	org/apache/cordova/CameraLauncher:targetHeight	I
    //   326: iconst_m1
    //   327: if_icmpne +127 -> 454
    //   330: aload_0
    //   331: getfield 230	org/apache/cordova/CameraLauncher:targetWidth	I
    //   334: iconst_m1
    //   335: if_icmpne +119 -> 454
    //   338: aload_0
    //   339: getfield 381	org/apache/cordova/CameraLauncher:mQuality	I
    //   342: bipush 100
    //   344: if_icmpne +110 -> 454
    //   347: aload_0
    //   348: getfield 393	org/apache/cordova/CameraLauncher:correctOrientation	Z
    //   351: ifne +103 -> 454
    //   354: aload_0
    //   355: aload_3
    //   356: invokespecial 535	org/apache/cordova/CameraLauncher:writeUncompressedImage	(Landroid/net/Uri;)V
    //   359: aload_0
    //   360: getfield 373	org/apache/cordova/CameraLauncher:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   363: aload_3
    //   364: invokevirtual 157	android/net/Uri:toString	()Ljava/lang/String;
    //   367: invokevirtual 538	org/apache/cordova/api/CallbackContext:success	(Ljava/lang/String;)V
    //   370: aload 9
    //   372: astore 8
    //   374: aload_0
    //   375: getfield 373	org/apache/cordova/CameraLauncher:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   378: aload_3
    //   379: invokevirtual 157	android/net/Uri:toString	()Ljava/lang/String;
    //   382: invokevirtual 538	org/apache/cordova/api/CallbackContext:success	(Ljava/lang/String;)V
    //   385: aload 8
    //   387: astore 7
    //   389: aload_3
    //   390: astore 8
    //   392: goto -144 -> 248
    //   395: new 156	java/io/File
    //   398: astore_3
    //   399: aload_0
    //   400: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   403: invokeinterface 135 1 0
    //   408: invokestatic 187	org/apache/cordova/DirectoryManager:getTempDirectoryPath	(Landroid/content/Context;)Ljava/lang/String;
    //   411: astore 7
    //   413: new 102	java/lang/StringBuilder
    //   416: astore 8
    //   418: aload 8
    //   420: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   423: aload_3
    //   424: aload 7
    //   426: aload 8
    //   428: invokestatic 542	java/lang/System:currentTimeMillis	()J
    //   431: invokevirtual 545	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   434: ldc_w 547
    //   437: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_3
    //   447: invokestatic 531	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   450: astore_3
    //   451: goto -140 -> 311
    //   454: aload_0
    //   455: aload_0
    //   456: getfield 344	org/apache/cordova/CameraLauncher:imageUri	Landroid/net/Uri;
    //   459: invokevirtual 157	android/net/Uri:toString	()Ljava/lang/String;
    //   462: invokestatic 163	org/apache/cordova/FileHelper:stripFileProtocol	(Ljava/lang/String;)Ljava/lang/String;
    //   465: invokespecial 485	org/apache/cordova/CameraLauncher:getScaledBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   468: astore 8
    //   470: aload 8
    //   472: astore 7
    //   474: iload_1
    //   475: ifeq +25 -> 500
    //   478: aload 8
    //   480: astore 7
    //   482: aload_0
    //   483: getfield 393	org/apache/cordova/CameraLauncher:correctOrientation	Z
    //   486: ifeq +14 -> 500
    //   489: aload_0
    //   490: iload_1
    //   491: aload 8
    //   493: aload 10
    //   495: invokespecial 515	org/apache/cordova/CameraLauncher:getRotatedBitmap	(ILandroid/graphics/Bitmap;Lorg/apache/cordova/ExifHelper;)Landroid/graphics/Bitmap;
    //   498: astore 7
    //   500: aload_0
    //   501: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   504: invokeinterface 135 1 0
    //   509: invokevirtual 141	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   512: aload_3
    //   513: invokevirtual 349	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   516: astore 8
    //   518: aload 7
    //   520: getstatic 552	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   523: aload_0
    //   524: getfield 381	org/apache/cordova/CameraLauncher:mQuality	I
    //   527: aload 8
    //   529: invokevirtual 556	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   532: pop
    //   533: aload 8
    //   535: invokevirtual 365	java/io/OutputStream:close	()V
    //   538: aload 7
    //   540: astore 8
    //   542: aload_0
    //   543: getfield 377	org/apache/cordova/CameraLauncher:encodingType	I
    //   546: ifne -172 -> 374
    //   549: aload_0
    //   550: getfield 75	org/apache/cordova/CameraLauncher:saveToPhotoAlbum	Z
    //   553: ifeq +32 -> 585
    //   556: aload_3
    //   557: aload_0
    //   558: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   561: invokestatic 527	org/apache/cordova/FileHelper:getRealPath	(Landroid/net/Uri;Lorg/apache/cordova/api/CordovaInterface;)Ljava/lang/String;
    //   564: astore 8
    //   566: aload 10
    //   568: aload 8
    //   570: invokevirtual 559	org/apache/cordova/ExifHelper:createOutFile	(Ljava/lang/String;)V
    //   573: aload 10
    //   575: invokevirtual 562	org/apache/cordova/ExifHelper:writeExifData	()V
    //   578: aload 7
    //   580: astore 8
    //   582: goto -208 -> 374
    //   585: aload_3
    //   586: invokevirtual 565	android/net/Uri:getPath	()Ljava/lang/String;
    //   589: astore 8
    //   591: goto -25 -> 566
    //   594: iload_2
    //   595: ifne +13 -> 608
    //   598: aload_0
    //   599: ldc_w 567
    //   602: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   605: goto -426 -> 179
    //   608: aload_0
    //   609: ldc_w 569
    //   612: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   615: goto -436 -> 179
    //   618: iload 6
    //   620: ifeq +9 -> 629
    //   623: iload 6
    //   625: iconst_2
    //   626: if_icmpne -447 -> 179
    //   629: iload_2
    //   630: iconst_m1
    //   631: if_icmpne +568 -> 1199
    //   634: aload_3
    //   635: invokevirtual 572	android/content/Intent:getData	()Landroid/net/Uri;
    //   638: astore 9
    //   640: aload_0
    //   641: getfield 379	org/apache/cordova/CameraLauncher:mediaType	I
    //   644: ifeq +18 -> 662
    //   647: aload_0
    //   648: getfield 373	org/apache/cordova/CameraLauncher:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   651: aload 9
    //   653: invokevirtual 157	android/net/Uri:toString	()Ljava/lang/String;
    //   656: invokevirtual 538	org/apache/cordova/api/CallbackContext:success	(Ljava/lang/String;)V
    //   659: goto -480 -> 179
    //   662: aload_0
    //   663: getfield 232	org/apache/cordova/CameraLauncher:targetHeight	I
    //   666: iconst_m1
    //   667: if_icmpne +45 -> 712
    //   670: aload_0
    //   671: getfield 230	org/apache/cordova/CameraLauncher:targetWidth	I
    //   674: iconst_m1
    //   675: if_icmpne +37 -> 712
    //   678: iload 5
    //   680: iconst_1
    //   681: if_icmpeq +9 -> 690
    //   684: iload 5
    //   686: iconst_2
    //   687: if_icmpne +25 -> 712
    //   690: aload_0
    //   691: getfield 393	org/apache/cordova/CameraLauncher:correctOrientation	Z
    //   694: ifne +18 -> 712
    //   697: aload_0
    //   698: getfield 373	org/apache/cordova/CameraLauncher:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   701: aload 9
    //   703: invokevirtual 157	android/net/Uri:toString	()Ljava/lang/String;
    //   706: invokevirtual 538	org/apache/cordova/api/CallbackContext:success	(Ljava/lang/String;)V
    //   709: goto -530 -> 179
    //   712: aload 9
    //   714: aload_0
    //   715: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   718: invokestatic 527	org/apache/cordova/FileHelper:getRealPath	(Landroid/net/Uri;Lorg/apache/cordova/api/CordovaInterface;)Ljava/lang/String;
    //   721: astore 7
    //   723: aload 7
    //   725: aload_0
    //   726: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   729: invokestatic 576	org/apache/cordova/FileHelper:getMimeType	(Ljava/lang/String;Lorg/apache/cordova/api/CordovaInterface;)Ljava/lang/String;
    //   732: astore 8
    //   734: aload 7
    //   736: ifnull +30 -> 766
    //   739: aload 8
    //   741: ifnull +25 -> 766
    //   744: aload 8
    //   746: ldc_w 275
    //   749: invokevirtual 580	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   752: ifne +33 -> 785
    //   755: aload 8
    //   757: ldc_w 582
    //   760: invokevirtual 580	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   763: ifne +22 -> 785
    //   766: ldc 28
    //   768: ldc_w 499
    //   771: invokestatic 504	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   774: pop
    //   775: aload_0
    //   776: ldc_w 584
    //   779: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   782: goto -603 -> 179
    //   785: aload_0
    //   786: aload 7
    //   788: invokespecial 485	org/apache/cordova/CameraLauncher:getScaledBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   791: astore 8
    //   793: aload 8
    //   795: ifnonnull +22 -> 817
    //   798: ldc 28
    //   800: ldc_w 499
    //   803: invokestatic 504	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   806: pop
    //   807: aload_0
    //   808: ldc_w 506
    //   811: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   814: goto -635 -> 179
    //   817: aload 8
    //   819: astore 7
    //   821: aload_0
    //   822: getfield 393	org/apache/cordova/CameraLauncher:correctOrientation	Z
    //   825: ifeq +105 -> 930
    //   828: aload_0
    //   829: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   832: invokeinterface 135 1 0
    //   837: invokevirtual 141	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   840: aload_3
    //   841: invokevirtual 572	android/content/Intent:getData	()Landroid/net/Uri;
    //   844: iconst_1
    //   845: anewarray 301	java/lang/String
    //   848: dup
    //   849: iconst_0
    //   850: ldc_w 586
    //   853: aastore
    //   854: aconst_null
    //   855: aconst_null
    //   856: aconst_null
    //   857: invokevirtual 305	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   860: astore_3
    //   861: aload_3
    //   862: ifnull +25 -> 887
    //   865: aload_3
    //   866: iconst_0
    //   867: invokeinterface 589 2 0
    //   872: pop
    //   873: aload_3
    //   874: iconst_0
    //   875: invokeinterface 590 2 0
    //   880: istore_1
    //   881: aload_3
    //   882: invokeinterface 591 1 0
    //   887: aload 8
    //   889: astore 7
    //   891: iload_1
    //   892: ifeq +38 -> 930
    //   895: new 203	android/graphics/Matrix
    //   898: dup
    //   899: invokespecial 204	android/graphics/Matrix:<init>	()V
    //   902: astore_3
    //   903: aload_3
    //   904: iload_1
    //   905: i2f
    //   906: invokevirtual 208	android/graphics/Matrix:setRotate	(F)V
    //   909: aload 8
    //   911: iconst_0
    //   912: iconst_0
    //   913: aload 8
    //   915: invokevirtual 211	android/graphics/Bitmap:getWidth	()I
    //   918: aload 8
    //   920: invokevirtual 214	android/graphics/Bitmap:getHeight	()I
    //   923: aload_3
    //   924: iconst_1
    //   925: invokestatic 218	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   928: astore 7
    //   930: iload 5
    //   932: ifne +25 -> 957
    //   935: aload_0
    //   936: aload 7
    //   938: invokevirtual 519	org/apache/cordova/CameraLauncher:processPicture	(Landroid/graphics/Bitmap;)V
    //   941: aload 7
    //   943: ifnull +8 -> 951
    //   946: aload 7
    //   948: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   951: invokestatic 179	java/lang/System:gc	()V
    //   954: goto -775 -> 179
    //   957: iload 5
    //   959: iconst_1
    //   960: if_icmpeq +9 -> 969
    //   963: iload 5
    //   965: iconst_2
    //   966: if_icmpne -25 -> 941
    //   969: aload_0
    //   970: getfield 232	org/apache/cordova/CameraLauncher:targetHeight	I
    //   973: ifle +211 -> 1184
    //   976: aload_0
    //   977: getfield 230	org/apache/cordova/CameraLauncher:targetWidth	I
    //   980: ifle +204 -> 1184
    //   983: new 102	java/lang/StringBuilder
    //   986: astore_3
    //   987: aload_3
    //   988: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   991: aload_3
    //   992: aload_0
    //   993: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   996: invokeinterface 135 1 0
    //   1001: invokestatic 187	org/apache/cordova/DirectoryManager:getTempDirectoryPath	(Landroid/content/Context;)Ljava/lang/String;
    //   1004: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: ldc_w 593
    //   1010: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: astore_3
    //   1017: new 220	org/apache/cordova/ExifHelper
    //   1020: astore 8
    //   1022: aload 8
    //   1024: invokespecial 472	org/apache/cordova/ExifHelper:<init>	()V
    //   1027: aload_0
    //   1028: getfield 377	org/apache/cordova/CameraLauncher:encodingType	I
    //   1031: ifne +28 -> 1059
    //   1034: aload 8
    //   1036: aload 9
    //   1038: aload_0
    //   1039: getfield 129	org/apache/cordova/CameraLauncher:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   1042: invokestatic 527	org/apache/cordova/FileHelper:getRealPath	(Landroid/net/Uri;Lorg/apache/cordova/api/CordovaInterface;)Ljava/lang/String;
    //   1045: invokevirtual 477	org/apache/cordova/ExifHelper:createInFile	(Ljava/lang/String;)V
    //   1048: aload 8
    //   1050: invokevirtual 480	org/apache/cordova/ExifHelper:readExifData	()V
    //   1053: aload 8
    //   1055: invokevirtual 483	org/apache/cordova/ExifHelper:getOrientation	()I
    //   1058: pop
    //   1059: new 595	java/io/FileOutputStream
    //   1062: astore 9
    //   1064: aload 9
    //   1066: aload_3
    //   1067: invokespecial 596	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1070: aload 7
    //   1072: getstatic 552	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1075: aload_0
    //   1076: getfield 381	org/apache/cordova/CameraLauncher:mQuality	I
    //   1079: aload 9
    //   1081: invokevirtual 556	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1084: pop
    //   1085: aload 9
    //   1087: invokevirtual 365	java/io/OutputStream:close	()V
    //   1090: aload_0
    //   1091: getfield 377	org/apache/cordova/CameraLauncher:encodingType	I
    //   1094: ifne +14 -> 1108
    //   1097: aload 8
    //   1099: aload_3
    //   1100: invokevirtual 559	org/apache/cordova/ExifHelper:createOutFile	(Ljava/lang/String;)V
    //   1103: aload 8
    //   1105: invokevirtual 562	org/apache/cordova/ExifHelper:writeExifData	()V
    //   1108: aload_0
    //   1109: getfield 373	org/apache/cordova/CameraLauncher:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   1112: astore 8
    //   1114: new 102	java/lang/StringBuilder
    //   1117: astore 9
    //   1119: aload 9
    //   1121: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1124: aload 8
    //   1126: aload 9
    //   1128: ldc_w 598
    //   1131: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: aload_3
    //   1135: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: ldc_w 600
    //   1141: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: invokestatic 542	java/lang/System:currentTimeMillis	()J
    //   1147: invokevirtual 545	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokevirtual 538	org/apache/cordova/api/CallbackContext:success	(Ljava/lang/String;)V
    //   1156: goto -215 -> 941
    //   1159: astore_3
    //   1160: aload_3
    //   1161: invokevirtual 601	java/lang/Exception:printStackTrace	()V
    //   1164: aload_0
    //   1165: ldc_w 603
    //   1168: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   1171: goto -230 -> 941
    //   1174: astore 9
    //   1176: aload 9
    //   1178: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   1181: goto -122 -> 1059
    //   1184: aload_0
    //   1185: getfield 373	org/apache/cordova/CameraLauncher:callbackContext	Lorg/apache/cordova/api/CallbackContext;
    //   1188: aload 9
    //   1190: invokevirtual 157	android/net/Uri:toString	()Ljava/lang/String;
    //   1193: invokevirtual 538	org/apache/cordova/api/CallbackContext:success	(Ljava/lang/String;)V
    //   1196: goto -255 -> 941
    //   1199: iload_2
    //   1200: ifne +13 -> 1213
    //   1203: aload_0
    //   1204: ldc_w 605
    //   1207: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   1210: goto -1031 -> 179
    //   1213: aload_0
    //   1214: ldc_w 607
    //   1217: invokevirtual 508	org/apache/cordova/CameraLauncher:failPicture	(Ljava/lang/String;)V
    //   1220: goto -1041 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1223	0	this	CameraLauncher
    //   0	1223	1	paramInt1	int
    //   0	1223	2	paramInt2	int
    //   0	1223	3	paramIntent	Intent
    //   19	169	4	i	int
    //   14	953	5	j	int
    //   6	621	6	k	int
    //   55	104	7	localObject1	Object
    //   180	48	7	localIOException1	IOException
    //   246	825	7	localObject2	Object
    //   111	1014	8	localObject3	Object
    //   105	1022	9	localObject4	Object
    //   1174	15	9	localIOException2	IOException
    //   35	539	10	localExifHelper	ExifHelper
    // Exception table:
    //   from	to	target	type
    //   45	104	180	java/io/IOException
    //   32	42	193	java/io/IOException
    //   118	134	193	java/io/IOException
    //   143	158	193	java/io/IOException
    //   163	179	193	java/io/IOException
    //   182	187	193	java/io/IOException
    //   218	235	193	java/io/IOException
    //   235	245	193	java/io/IOException
    //   248	261	193	java/io/IOException
    //   276	311	193	java/io/IOException
    //   315	322	193	java/io/IOException
    //   322	370	193	java/io/IOException
    //   374	385	193	java/io/IOException
    //   395	451	193	java/io/IOException
    //   454	470	193	java/io/IOException
    //   482	500	193	java/io/IOException
    //   500	538	193	java/io/IOException
    //   542	566	193	java/io/IOException
    //   566	578	193	java/io/IOException
    //   585	591	193	java/io/IOException
    //   983	1027	1159	java/lang/Exception
    //   1027	1059	1159	java/lang/Exception
    //   1059	1108	1159	java/lang/Exception
    //   1108	1156	1159	java/lang/Exception
    //   1176	1181	1159	java/lang/Exception
    //   1027	1059	1174	java/io/IOException
  }
  
  public void onMediaScannerConnected()
  {
    try
    {
      this.conn.scanFile(this.scanMe.toString(), "image/*");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        LOG.e("CameraLauncher", "Can't scan file in MediaScanner after taking picture");
      }
    }
  }
  
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    this.conn.disconnect();
  }
  
  public void processPicture(Bitmap paramBitmap)
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      if (paramBitmap.compress(Bitmap.CompressFormat.JPEG, this.mQuality, (OutputStream)localObject))
      {
        paramBitmap = Base64.encodeBase64(((ByteArrayOutputStream)localObject).toByteArray());
        localObject = new java/lang/String;
        ((String)localObject).<init>(paramBitmap);
        this.callbackContext.success((String)localObject);
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        failPicture("Error compressing image.");
      }
    }
  }
  
  public void takePicture(int paramInt1, int paramInt2)
  {
    this.numPics = queryImgDB(whichContentStore()).getCount();
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = createCaptureFile(paramInt2);
    localIntent.putExtra("output", Uri.fromFile(localFile));
    this.imageUri = Uri.fromFile(localFile);
    if (this.cordova != null) {
      this.cordova.startActivityForResult(this, localIntent, paramInt1 + 32 + 1);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\CameraLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */