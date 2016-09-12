package com.arrownock.live;

import android.content.Context;
import bh;
import bi;
import bj;
import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;
import cy;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.Logging;
import org.webrtc.Logging.Severity;
import org.webrtc.Logging.TraceLevel;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoRenderer;
import org.webrtc.VideoRendererGui;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;

public class AnLive
  implements bj
{
  private static AnLive jdField_a_of_type_ComArrownockLiveAnLive = null;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private bh jdField_a_of_type_Bh = null;
  private bi jdField_a_of_type_Bi = new bi(this);
  private IAnLiveEventListener jdField_a_of_type_ComArrownockLiveIAnLiveEventListener = null;
  private IStartCallCallback jdField_a_of_type_ComArrownockLiveIStartCallCallback = null;
  private LocalVideoView jdField_a_of_type_ComArrownockLiveLocalVideoView = null;
  private String jdField_a_of_type_JavaLangString = null;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = null;
  private AudioSource jdField_a_of_type_OrgWebrtcAudioSource = null;
  private AudioTrack jdField_a_of_type_OrgWebrtcAudioTrack = null;
  private MediaStream jdField_a_of_type_OrgWebrtcMediaStream = null;
  private PeerConnectionFactory jdField_a_of_type_OrgWebrtcPeerConnectionFactory = null;
  private VideoCapturer jdField_a_of_type_OrgWebrtcVideoCapturer = null;
  private VideoRenderer jdField_a_of_type_OrgWebrtcVideoRenderer = null;
  private VideoSource jdField_a_of_type_OrgWebrtcVideoSource = null;
  private VideoTrack jdField_a_of_type_OrgWebrtcVideoTrack = null;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString = null;
  private Map<String, cy> jdField_b_of_type_JavaUtilMap = null;
  private String c = null;
  
  static
  {
    JniLib.a(AnLive.class, 169);
  }
  
  private AnLive(Context paramContext, bh parambh, IAnLiveEventListener paramIAnLiveEventListener)
    throws ArrownockException
  {
    if (parambh == null) {
      throw new ArrownockException("anIM instance cannot be null", 1301);
    }
    if (paramIAnLiveEventListener == null) {
      throw new ArrownockException("AnLiveEventListener cannot be null", 1302);
    }
    if (!PeerConnectionFactory.initializeAndroidGlobals(paramContext, true, true, false, VideoRendererGui.getEGLContext())) {
      throw new ArrownockException("Failed to initialize video media component.", 2306);
    }
    this.jdField_a_of_type_Bh = parambh;
    this.jdField_a_of_type_Bh.setCallbacks(this.jdField_a_of_type_Bi);
    this.jdField_a_of_type_ComArrownockLiveIAnLiveEventListener = paramIAnLiveEventListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    Logging.enableTracing("logcat:", EnumSet.of(Logging.TraceLevel.TRACE_ERROR), Logging.Severity.LS_ERROR);
  }
  
  private native LocalVideoView a(boolean paramBoolean)
    throws ArrownockException;
  
  private native void a();
  
  private native void a(String paramString, boolean paramBoolean, Map<String, String> paramMap, IStartCallCallback paramIStartCallCallback);
  
  private native void b();
  
  private native void c();
  
  public static native AnLive initialize(Context paramContext, bh parambh, IAnLiveEventListener paramIAnLiveEventListener)
    throws ArrownockException;
  
  public native void answer(boolean paramBoolean)
    throws ArrownockException;
  
  public native String getCurrentSessionType();
  
  public native void hangup();
  
  public native boolean isOnCall();
  
  public native void onVideoSizeChanged(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  
  public native void setAudioState(AudioState paramAudioState);
  
  public native void setVideoState(VideoState paramVideoState);
  
  public native void videoCall(String paramString, boolean paramBoolean, Map<String, String> paramMap, IStartCallCallback paramIStartCallCallback);
  
  public native void voiceCall(String paramString, Map<String, String> paramMap, IStartCallCallback paramIStartCallCallback);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\live\AnLive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */