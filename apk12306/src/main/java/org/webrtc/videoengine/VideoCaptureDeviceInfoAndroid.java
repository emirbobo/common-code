package org.webrtc.videoengine;

import android.hardware.Camera.CameraInfo;

public class VideoCaptureDeviceInfoAndroid
{
  private static final String TAG = "anLive";
  
  private static String deviceUniqueName(int paramInt, Camera.CameraInfo paramCameraInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder("Camera ").append(paramInt).append(", Facing ");
    if (isFrontFacing(paramCameraInfo)) {}
    for (String str = "front";; str = "back") {
      return str + ", Orientation " + paramCameraInfo.orientation;
    }
  }
  
  /* Error */
  private static String getDeviceInfo()
  {
    // Byte code:
    //   0: new 58	org/json/JSONArray
    //   3: astore 8
    //   5: aload 8
    //   7: invokespecial 59	org/json/JSONArray:<init>	()V
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: invokestatic 65	android/hardware/Camera:getNumberOfCameras	()I
    //   16: if_icmpge +616 -> 632
    //   19: new 41	android/hardware/Camera$CameraInfo
    //   22: astore 9
    //   24: aload 9
    //   26: invokespecial 66	android/hardware/Camera$CameraInfo:<init>	()V
    //   29: iload_1
    //   30: aload 9
    //   32: invokestatic 70	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   35: iload_1
    //   36: aload 9
    //   38: invokestatic 72	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceUniqueName	(ILandroid/hardware/Camera$CameraInfo;)Ljava/lang/String;
    //   41: astore 7
    //   43: new 74	org/json/JSONObject
    //   46: astore 10
    //   48: aload 10
    //   50: invokespecial 75	org/json/JSONObject:<init>	()V
    //   53: aload 8
    //   55: aload 10
    //   57: invokevirtual 79	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   60: pop
    //   61: aconst_null
    //   62: astore 4
    //   64: aconst_null
    //   65: astore 5
    //   67: iload_1
    //   68: invokestatic 83	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   71: astore 6
    //   73: aload 6
    //   75: astore 5
    //   77: aload 6
    //   79: astore 4
    //   81: aload 6
    //   83: invokevirtual 87	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   86: astore 11
    //   88: aload 6
    //   90: astore 5
    //   92: aload 6
    //   94: astore 4
    //   96: aload 11
    //   98: invokevirtual 93	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   101: astore 12
    //   103: aload 6
    //   105: astore 5
    //   107: aload 6
    //   109: astore 4
    //   111: aload 11
    //   113: invokevirtual 96	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   116: astore 11
    //   118: aload 6
    //   120: astore 5
    //   122: aload 6
    //   124: astore 4
    //   126: ldc 8
    //   128: aload 7
    //   130: invokestatic 102	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   133: pop
    //   134: aload 6
    //   136: ifnull +8 -> 144
    //   139: aload 6
    //   141: invokevirtual 105	android/hardware/Camera:release	()V
    //   144: new 58	org/json/JSONArray
    //   147: astore 4
    //   149: aload 4
    //   151: invokespecial 59	org/json/JSONArray:<init>	()V
    //   154: aload 12
    //   156: invokeinterface 111 1 0
    //   161: astore 12
    //   163: aload 12
    //   165: invokeinterface 117 1 0
    //   170: ifeq +154 -> 324
    //   173: aload 12
    //   175: invokeinterface 121 1 0
    //   180: checkcast 123	android/hardware/Camera$Size
    //   183: astore 6
    //   185: new 74	org/json/JSONObject
    //   188: astore 5
    //   190: aload 5
    //   192: invokespecial 75	org/json/JSONObject:<init>	()V
    //   195: aload 5
    //   197: ldc 125
    //   199: aload 6
    //   201: getfield 127	android/hardware/Camera$Size:width	I
    //   204: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 5
    //   210: ldc -124
    //   212: aload 6
    //   214: getfield 134	android/hardware/Camera$Size:height	I
    //   217: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   220: pop
    //   221: aload 4
    //   223: aload 5
    //   225: invokevirtual 79	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   228: pop
    //   229: goto -66 -> 163
    //   232: astore 4
    //   234: new 56	java/lang/RuntimeException
    //   237: dup
    //   238: aload 4
    //   240: invokespecial 137	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   243: athrow
    //   244: astore 9
    //   246: aload 5
    //   248: astore 4
    //   250: new 17	java/lang/StringBuilder
    //   253: astore 6
    //   255: aload 5
    //   257: astore 4
    //   259: aload 6
    //   261: ldc -117
    //   263: invokespecial 22	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload 5
    //   268: astore 4
    //   270: ldc 8
    //   272: aload 6
    //   274: aload 7
    //   276: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc -115
    //   281: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: aload 9
    //   289: invokestatic 145	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   292: pop
    //   293: aload 5
    //   295: ifnull +8 -> 303
    //   298: aload 5
    //   300: invokevirtual 105	android/hardware/Camera:release	()V
    //   303: iinc 1 1
    //   306: goto -294 -> 12
    //   309: astore 5
    //   311: aload 4
    //   313: ifnull +8 -> 321
    //   316: aload 4
    //   318: invokevirtual 105	android/hardware/Camera:release	()V
    //   321: aload 5
    //   323: athrow
    //   324: aload 11
    //   326: invokeinterface 111 1 0
    //   331: astore 5
    //   333: iconst_0
    //   334: istore_0
    //   335: iconst_0
    //   336: istore_3
    //   337: aload 5
    //   339: invokeinterface 117 1 0
    //   344: ifeq +68 -> 412
    //   347: aload 5
    //   349: invokeinterface 121 1 0
    //   354: checkcast 147	[I
    //   357: astore 6
    //   359: iload_3
    //   360: istore_2
    //   361: aload 6
    //   363: iconst_0
    //   364: iaload
    //   365: sipush 30000
    //   368: if_icmpne +17 -> 385
    //   371: iload_3
    //   372: istore_2
    //   373: aload 6
    //   375: iconst_1
    //   376: iaload
    //   377: sipush 30000
    //   380: if_icmpne +5 -> 385
    //   383: iconst_1
    //   384: istore_2
    //   385: aload 6
    //   387: iconst_0
    //   388: iaload
    //   389: sipush 15000
    //   392: if_icmpne +259 -> 651
    //   395: aload 6
    //   397: iconst_1
    //   398: iaload
    //   399: sipush 15000
    //   402: if_icmpne +249 -> 651
    //   405: iconst_1
    //   406: istore_0
    //   407: iload_2
    //   408: istore_3
    //   409: goto -72 -> 337
    //   412: iload_3
    //   413: ifeq +77 -> 490
    //   416: iload_0
    //   417: ifne +73 -> 490
    //   420: ldc 8
    //   422: ldc -107
    //   424: invokestatic 102	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   427: pop
    //   428: iconst_2
    //   429: newarray <illegal type>
    //   431: astore 5
    //   433: aload 5
    //   435: iconst_0
    //   436: sipush 15000
    //   439: iastore
    //   440: aload 5
    //   442: iconst_1
    //   443: sipush 15000
    //   446: iastore
    //   447: iconst_0
    //   448: istore_0
    //   449: iload_0
    //   450: aload 11
    //   452: invokeinterface 152 1 0
    //   457: if_icmpge +33 -> 490
    //   460: aload 11
    //   462: iload_0
    //   463: invokeinterface 156 2 0
    //   468: checkcast 147	[I
    //   471: iconst_1
    //   472: iaload
    //   473: aload 5
    //   475: iconst_1
    //   476: iaload
    //   477: if_icmple +99 -> 576
    //   480: aload 11
    //   482: iload_0
    //   483: aload 5
    //   485: invokeinterface 160 3 0
    //   490: new 58	org/json/JSONArray
    //   493: astore 5
    //   495: aload 5
    //   497: invokespecial 59	org/json/JSONArray:<init>	()V
    //   500: aload 11
    //   502: invokeinterface 111 1 0
    //   507: astore 6
    //   509: aload 6
    //   511: invokeinterface 117 1 0
    //   516: ifeq +66 -> 582
    //   519: aload 6
    //   521: invokeinterface 121 1 0
    //   526: checkcast 147	[I
    //   529: astore 12
    //   531: new 74	org/json/JSONObject
    //   534: astore 11
    //   536: aload 11
    //   538: invokespecial 75	org/json/JSONObject:<init>	()V
    //   541: aload 11
    //   543: ldc -94
    //   545: aload 12
    //   547: iconst_0
    //   548: iaload
    //   549: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   552: pop
    //   553: aload 11
    //   555: ldc -92
    //   557: aload 12
    //   559: iconst_1
    //   560: iaload
    //   561: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   564: pop
    //   565: aload 5
    //   567: aload 11
    //   569: invokevirtual 79	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   572: pop
    //   573: goto -64 -> 509
    //   576: iinc 0 1
    //   579: goto -130 -> 449
    //   582: aload 10
    //   584: ldc -90
    //   586: aload 7
    //   588: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   591: pop
    //   592: aload 10
    //   594: ldc -85
    //   596: aload 9
    //   598: invokestatic 35	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:isFrontFacing	(Landroid/hardware/Camera$CameraInfo;)Z
    //   601: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   604: ldc -81
    //   606: aload 9
    //   608: getfield 45	android/hardware/Camera$CameraInfo:orientation	I
    //   611: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   614: ldc -79
    //   616: aload 4
    //   618: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   621: ldc -77
    //   623: aload 5
    //   625: invokevirtual 169	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   628: pop
    //   629: goto -326 -> 303
    //   632: aload 8
    //   634: iconst_2
    //   635: invokevirtual 182	org/json/JSONArray:toString	(I)Ljava/lang/String;
    //   638: astore 4
    //   640: ldc 8
    //   642: aload 4
    //   644: invokestatic 102	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   647: pop
    //   648: aload 4
    //   650: areturn
    //   651: goto -244 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   334	243	0	i	int
    //   11	293	1	j	int
    //   360	48	2	k	int
    //   336	77	3	m	int
    //   62	160	4	localObject1	Object
    //   232	7	4	localJSONException	org.json.JSONException
    //   248	401	4	localObject2	Object
    //   65	234	5	localObject3	Object
    //   309	13	5	localObject4	Object
    //   331	293	5	localObject5	Object
    //   71	449	6	localObject6	Object
    //   41	546	7	str	String
    //   3	630	8	localJSONArray	org.json.JSONArray
    //   22	15	9	localCameraInfo	Camera.CameraInfo
    //   244	363	9	localRuntimeException	RuntimeException
    //   46	547	10	localJSONObject	org.json.JSONObject
    //   86	482	11	localObject7	Object
    //   101	457	12	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	232	org/json/JSONException
    //   12	61	232	org/json/JSONException
    //   139	144	232	org/json/JSONException
    //   144	163	232	org/json/JSONException
    //   163	229	232	org/json/JSONException
    //   298	303	232	org/json/JSONException
    //   316	321	232	org/json/JSONException
    //   321	324	232	org/json/JSONException
    //   324	333	232	org/json/JSONException
    //   337	359	232	org/json/JSONException
    //   420	433	232	org/json/JSONException
    //   449	490	232	org/json/JSONException
    //   490	509	232	org/json/JSONException
    //   509	573	232	org/json/JSONException
    //   582	629	232	org/json/JSONException
    //   632	648	232	org/json/JSONException
    //   67	73	244	java/lang/RuntimeException
    //   81	88	244	java/lang/RuntimeException
    //   96	103	244	java/lang/RuntimeException
    //   111	118	244	java/lang/RuntimeException
    //   126	134	244	java/lang/RuntimeException
    //   67	73	309	finally
    //   81	88	309	finally
    //   96	103	309	finally
    //   111	118	309	finally
    //   126	134	309	finally
    //   250	255	309	finally
    //   259	266	309	finally
    //   270	293	309	finally
  }
  
  private static boolean isFrontFacing(Camera.CameraInfo paramCameraInfo)
  {
    boolean bool = true;
    if (paramCameraInfo.facing == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\videoengine\VideoCaptureDeviceInfoAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */