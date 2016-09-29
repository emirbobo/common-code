import android.content.Context;
import android.util.Log;
import com.arrownock.live.AudioState;
import com.arrownock.live.IAnLiveEventListener;
import com.arrownock.live.VideoState;
import com.arrownock.live.VideoView;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.AudioTrack;
import org.webrtc.DataChannel;
import org.webrtc.DataChannel.Buffer;
import org.webrtc.DataChannel.Init;
import org.webrtc.DataChannel.Observer;
import org.webrtc.DataChannel.State;
import org.webrtc.IceCandidate;
import org.webrtc.MediaConstraints;
import org.webrtc.MediaConstraints.KeyValuePair;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnection.IceServer;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;
import org.webrtc.VideoRenderer;
import org.webrtc.VideoTrack;

public final class cy
  implements bj, DataChannel.Observer
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private bh jdField_a_of_type_Bh = null;
  private IAnLiveEventListener jdField_a_of_type_ComArrownockLiveIAnLiveEventListener = null;
  private VideoView jdField_a_of_type_ComArrownockLiveVideoView = null;
  private da jdField_a_of_type_Da = new da(this);
  private db jdField_a_of_type_Db = new db(this);
  private String jdField_a_of_type_JavaLangString = "PeerConnectionManager";
  private DataChannel jdField_a_of_type_OrgWebrtcDataChannel = null;
  private MediaConstraints jdField_a_of_type_OrgWebrtcMediaConstraints = null;
  private MediaStream jdField_a_of_type_OrgWebrtcMediaStream = null;
  private PeerConnection jdField_a_of_type_OrgWebrtcPeerConnection = null;
  private VideoRenderer jdField_a_of_type_OrgWebrtcVideoRenderer = null;
  private VideoTrack jdField_a_of_type_OrgWebrtcVideoTrack = null;
  private boolean jdField_a_of_type_Boolean = false;
  private String b = null;
  
  public cy(bh parambh, String paramString, Context paramContext, IAnLiveEventListener paramIAnLiveEventListener)
  {
    this.jdField_a_of_type_OrgWebrtcMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
    this.jdField_a_of_type_OrgWebrtcMediaConstraints.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
    this.b = paramString;
    this.jdField_a_of_type_Bh = parambh;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener = paramIAnLiveEventListener;
  }
  
  private String a(String paramString)
  {
    int m = 0;
    String[] arrayOfString = paramString.split("\n");
    String str = null;
    Object localObject = Pattern.compile("^a=rtpmap:(\\d+) ISAC/16000[\r]?$");
    int i = 0;
    int j = -1;
    if ((i < arrayOfString.length) && ((j == -1) || (str == null)))
    {
      int k;
      if (arrayOfString[i].startsWith("m=audio ")) {
        k = i;
      }
      for (;;)
      {
        i++;
        j = k;
        break;
        Matcher localMatcher = ((Pattern)localObject).matcher(arrayOfString[i]);
        k = j;
        if (localMatcher.matches())
        {
          str = localMatcher.group(1);
          k = j;
        }
      }
    }
    if (j == -1) {
      Log.d(this.jdField_a_of_type_JavaLangString, "No m=audio line, so can't prefer iSAC");
    }
    for (;;)
    {
      return paramString;
      if (str == null)
      {
        Log.d(this.jdField_a_of_type_JavaLangString, "No ISAC/16000 line, so can't prefer iSAC");
      }
      else
      {
        localObject = arrayOfString[j].split(" ");
        paramString = new StringBuilder();
        paramString.append(localObject[0]).append(" ");
        paramString.append(localObject[1]).append(" ");
        i = 3;
        paramString.append(localObject[2]).append(" ");
        paramString.append(str).append(" ");
        while (i < localObject.length)
        {
          if (!localObject[i].equals(str)) {
            paramString.append(localObject[i]).append(" ");
          }
          i++;
        }
        arrayOfString[j] = paramString.toString();
        paramString = new StringBuilder();
        j = arrayOfString.length;
        for (i = m; i < j; i++) {
          paramString.append(arrayOfString[i]).append("\n");
        }
        paramString = paramString.toString();
      }
    }
  }
  
  /* Error */
  private static MediaConstraints a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aconst_null
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: new 74	org/webrtc/MediaConstraints
    //   13: astore_3
    //   14: aload_3
    //   15: invokespecial 75	org/webrtc/MediaConstraints:<init>	()V
    //   18: new 178	org/json/JSONObject
    //   21: astore 4
    //   23: aload 4
    //   25: aload_0
    //   26: invokespecial 181	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: aload 4
    //   31: ldc -74
    //   33: invokevirtual 186	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +77 -> 115
    //   41: aload_0
    //   42: invokevirtual 190	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   45: astore 8
    //   47: aload 8
    //   49: ifnull +66 -> 115
    //   52: iconst_0
    //   53: istore_1
    //   54: iload_1
    //   55: aload 8
    //   57: invokevirtual 196	org/json/JSONArray:length	()I
    //   60: if_icmpge +55 -> 115
    //   63: aload 8
    //   65: iload_1
    //   66: invokevirtual 199	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   69: astore 7
    //   71: aload_0
    //   72: aload 7
    //   74: invokevirtual 201	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 5
    //   79: aload_3
    //   80: getfield 79	org/webrtc/MediaConstraints:mandatory	Ljava/util/List;
    //   83: astore 9
    //   85: new 81	org/webrtc/MediaConstraints$KeyValuePair
    //   88: astore 6
    //   90: aload 6
    //   92: aload 7
    //   94: aload 5
    //   96: invokespecial 88	org/webrtc/MediaConstraints$KeyValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 9
    //   101: aload 6
    //   103: invokeinterface 94 2 0
    //   108: pop
    //   109: iinc 1 1
    //   112: goto -58 -> 54
    //   115: aload 4
    //   117: ldc -53
    //   119: invokevirtual 207	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   122: astore 4
    //   124: aload_3
    //   125: astore_0
    //   126: aload 4
    //   128: ifnull -120 -> 8
    //   131: iload_2
    //   132: istore_1
    //   133: aload_3
    //   134: astore_0
    //   135: iload_1
    //   136: aload 4
    //   138: invokevirtual 196	org/json/JSONArray:length	()I
    //   141: if_icmpge -133 -> 8
    //   144: aload 4
    //   146: iload_1
    //   147: invokevirtual 211	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   150: astore 5
    //   152: aload 5
    //   154: invokevirtual 190	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   157: iconst_0
    //   158: invokevirtual 199	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   161: astore_0
    //   162: aload 5
    //   164: aload_0
    //   165: invokevirtual 201	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 7
    //   170: aload_3
    //   171: getfield 213	org/webrtc/MediaConstraints:optional	Ljava/util/List;
    //   174: astore 6
    //   176: new 81	org/webrtc/MediaConstraints$KeyValuePair
    //   179: astore 5
    //   181: aload 5
    //   183: aload_0
    //   184: aload 7
    //   186: invokespecial 88	org/webrtc/MediaConstraints$KeyValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload 6
    //   191: aload 5
    //   193: invokeinterface 94 2 0
    //   198: pop
    //   199: iinc 1 1
    //   202: goto -69 -> 133
    //   205: astore_0
    //   206: new 215	java/lang/RuntimeException
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 218	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   53	147	1	i	int
    //   1	131	2	j	int
    //   13	158	3	localMediaConstraints	MediaConstraints
    //   21	124	4	localObject1	Object
    //   77	115	5	localObject2	Object
    //   88	102	6	localObject3	Object
    //   69	116	7	str	String
    //   45	19	8	localJSONArray	org.json.JSONArray
    //   83	17	9	localList	List
    // Exception table:
    //   from	to	target	type
    //   10	37	205	org/json/JSONException
    //   41	47	205	org/json/JSONException
    //   54	109	205	org/json/JSONException
    //   115	124	205	org/json/JSONException
    //   135	199	205	org/json/JSONException
  }
  
  private void d()
  {
    HashMap localHashMap;
    if (this.jdField_a_of_type_OrgWebrtcMediaStream != null)
    {
      if ((this.jdField_a_of_type_OrgWebrtcMediaStream.videoTracks != null) && (this.jdField_a_of_type_OrgWebrtcMediaStream.videoTracks.size() > 0) && (this.jdField_a_of_type_OrgWebrtcMediaStream.videoTracks.get(0) != null))
      {
        if (!((VideoTrack)this.jdField_a_of_type_OrgWebrtcMediaStream.videoTracks.get(0)).enabled()) {
          break label200;
        }
        str = "on";
        localHashMap = new HashMap();
        localHashMap.put("type", "video");
        localHashMap.put("data", str);
        a(localHashMap);
      }
      if ((this.jdField_a_of_type_OrgWebrtcMediaStream.audioTracks != null) && (this.jdField_a_of_type_OrgWebrtcMediaStream.audioTracks.size() > 0) && (this.jdField_a_of_type_OrgWebrtcMediaStream.audioTracks.get(0) != null)) {
        if (!((AudioTrack)this.jdField_a_of_type_OrgWebrtcMediaStream.audioTracks.get(0)).enabled()) {
          break label207;
        }
      }
    }
    label200:
    label207:
    for (String str = "on";; str = "off")
    {
      localHashMap = new HashMap();
      localHashMap.put("type", "audio");
      localHashMap.put("data", str);
      a(localHashMap);
      return;
      str = "off";
      break;
    }
  }
  
  public final PeerConnection a(PeerConnectionFactory paramPeerConnectionFactory, MediaStream paramMediaStream)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new PeerConnection.IceServer("stun:10.1.215.152:3478", "", ""));
    this.jdField_a_of_type_OrgWebrtcPeerConnection = paramPeerConnectionFactory.createPeerConnection(localLinkedList, a("{\"mandatory\": {\"DtlsSrtpKeyAgreement\": true}, \"optional\": [{\"RtpDataChannels\":true}]}"), this.jdField_a_of_type_Da);
    this.jdField_a_of_type_OrgWebrtcPeerConnection.addStream(paramMediaStream);
    this.jdField_a_of_type_OrgWebrtcMediaStream = paramMediaStream;
    return this.jdField_a_of_type_OrgWebrtcPeerConnection;
  }
  
  public final void a()
  {
    if ((this.jdField_a_of_type_OrgWebrtcPeerConnection != null) && (!this.jdField_a_of_type_Boolean))
    {
      DataChannel.Init localInit = new DataChannel.Init();
      localInit.negotiated = false;
      localInit.ordered = false;
      this.jdField_a_of_type_OrgWebrtcDataChannel = this.jdField_a_of_type_OrgWebrtcPeerConnection.createDataChannel("anLiveDataChannel", localInit);
      this.jdField_a_of_type_OrgWebrtcDataChannel.registerObserver(this);
      this.jdField_a_of_type_OrgWebrtcPeerConnection.createOffer(this.jdField_a_of_type_Db, this.jdField_a_of_type_OrgWebrtcMediaConstraints);
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if ((this.jdField_a_of_type_OrgWebrtcDataChannel != null) && (this.jdField_a_of_type_OrgWebrtcDataChannel.state() == DataChannel.State.OPEN) && (paramMap != null) && (paramMap.size() > 0)) {}
    try
    {
      Object localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(paramMap);
      localObject = ByteBuffer.wrap(((JSONObject)localObject).toString().getBytes("UTF-8"));
      paramMap = new org/webrtc/DataChannel$Buffer;
      paramMap.<init>((ByteBuffer)localObject, false);
      this.jdField_a_of_type_OrgWebrtcDataChannel.send(paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      for (;;) {}
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_OrgWebrtcPeerConnection != null) && (!this.jdField_a_of_type_Boolean)) {}
    try
    {
      IceCandidate localIceCandidate = new org/webrtc/IceCandidate;
      localIceCandidate.<init>((String)paramJSONObject.get("id"), paramJSONObject.getInt("label"), (String)paramJSONObject.get("candidate"));
      this.jdField_a_of_type_OrgWebrtcPeerConnection.addIceCandidate(localIceCandidate);
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public final void a(SessionDescription.Type paramType, String paramString)
  {
    if ((this.jdField_a_of_type_OrgWebrtcPeerConnection != null) && (!this.jdField_a_of_type_Boolean)) {}
    try
    {
      SessionDescription localSessionDescription = new org/webrtc/SessionDescription;
      localSessionDescription.<init>(paramType, a(paramString));
      this.jdField_a_of_type_OrgWebrtcPeerConnection.setRemoteDescription(this.jdField_a_of_type_Db, localSessionDescription);
      return;
    }
    catch (Exception paramType)
    {
      for (;;)
      {
        paramType.printStackTrace();
      }
    }
  }
  
  public final void b()
  {
    if ((this.jdField_a_of_type_OrgWebrtcPeerConnection != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_OrgWebrtcPeerConnection.createAnswer(this.jdField_a_of_type_Db, this.jdField_a_of_type_OrgWebrtcMediaConstraints);
    }
  }
  
  public final void c()
  {
    try
    {
      if (this.jdField_a_of_type_OrgWebrtcPeerConnection != null)
      {
        this.jdField_a_of_type_OrgWebrtcPeerConnection.dispose();
        this.jdField_a_of_type_OrgWebrtcPeerConnection = null;
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_OrgWebrtcMediaStream = null;
      return;
    }
    finally {}
  }
  
  public final void onMessage(DataChannel.Buffer paramBuffer)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener != null) && (paramBuffer != null) && (paramBuffer.data != null))
    {
      localObject = new byte[paramBuffer.data.remaining()];
      paramBuffer.data.get((byte[])localObject);
      paramBuffer = new String((byte[])localObject, Charset.forName("UTF-8"));
    }
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(paramBuffer);
      paramBuffer = ((JSONObject)localObject).getString("type");
      localObject = ((JSONObject)localObject).getString("data");
      if ("video".equals(paramBuffer))
      {
        if ("on".equals(localObject)) {
          this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener.onRemotePartyVideoStateChanged(this.b, VideoState.ON);
        }
        for (;;)
        {
          return;
          if ("off".equals(localObject)) {
            this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener.onRemotePartyVideoStateChanged(this.b, VideoState.OFF);
          }
        }
      }
    }
    catch (JSONException paramBuffer)
    {
      for (;;)
      {
        continue;
        if ("audio".equals(paramBuffer)) {
          if ("on".equals(localObject)) {
            this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener.onRemotePartyAudioStateChanged(this.b, AudioState.ON);
          } else if ("off".equals(localObject)) {
            this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener.onRemotePartyAudioStateChanged(this.b, AudioState.OFF);
          }
        }
      }
    }
  }
  
  public final void onStateChange()
  {
    switch (cz.a[this.jdField_a_of_type_OrgWebrtcDataChannel.state().ordinal()])
    {
    }
    for (;;)
    {
      return;
      d();
      continue;
      this.jdField_a_of_type_OrgWebrtcDataChannel = null;
    }
  }
  
  public final void onVideoSizeChanged(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener != null) && (this.b != null) && (this.jdField_a_of_type_ComArrownockLiveVideoView != null))
    {
      if (!paramBoolean2) {
        break label48;
      }
      this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener.onRemotePartyVideoViewReady(this.b, this.jdField_a_of_type_ComArrownockLiveVideoView);
    }
    for (;;)
    {
      return;
      label48:
      this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener.onRemotePartyVideoSizeChanged(this.b, paramInt1, paramInt2);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */