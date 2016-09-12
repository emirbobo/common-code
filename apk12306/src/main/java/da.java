import android.os.Looper;
import com.arrownock.exception.ArrownockException;
import com.arrownock.live.IAnLiveEventListener;
import com.arrownock.live.VideoView;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.DataChannel;
import org.webrtc.IceCandidate;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection.IceConnectionState;
import org.webrtc.PeerConnection.IceGatheringState;
import org.webrtc.PeerConnection.Observer;
import org.webrtc.PeerConnection.SignalingState;
import org.webrtc.VideoRenderer;
import org.webrtc.VideoTrack;

final class da
  implements PeerConnection.Observer
{
  da(cy paramcy) {}
  
  public final void onAddStream(MediaStream paramMediaStream)
  {
    Looper.prepare();
    cy.a(this.a, new VideoView(cy.a(this.a)));
    cy.a(this.a).a(this.a);
    if (paramMediaStream.videoTracks.size() == 1)
    {
      cy.a(this.a, (VideoTrack)paramMediaStream.videoTracks.get(0));
      cy.a(this.a, new VideoRenderer(new ct(cy.a(this.a)).a(cw.c, false)));
      cy.a(this.a).addRenderer(cy.a(this.a));
    }
  }
  
  public final void onDataChannel(DataChannel paramDataChannel)
  {
    cy.a(this.a, paramDataChannel);
    cy.a(this.a).registerObserver(this.a);
    cy.a(this.a);
  }
  
  public final void onIceCandidate(IceCandidate paramIceCandidate)
  {
    JSONObject localJSONObject;
    if (!cy.a(this.a)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("type", "candidate");
      localJSONObject.put("label", paramIceCandidate.sdpMLineIndex);
      localJSONObject.put("id", paramIceCandidate.sdpMid);
      localJSONObject.put("candidate", paramIceCandidate.sdp);
      cy.a(this.a).sendICECandidate(cy.a(this.a), localJSONObject.toString());
      return;
    }
    catch (JSONException paramIceCandidate)
    {
      for (;;)
      {
        paramIceCandidate.printStackTrace();
      }
    }
  }
  
  public final void onIceConnectionChange(PeerConnection.IceConnectionState paramIceConnectionState)
  {
    switch (paramIceConnectionState.ordinal())
    {
    }
    for (;;)
    {
      return;
      cy.a(this.a, true);
      cy.a(this.a).onRemotePartyConnected(cy.a(this.a));
      if ((cy.a(this.a).getVideoWidth() > 0) && (cy.a(this.a).getVideoHeight() > 0))
      {
        cy.a(this.a).onRemotePartyVideoViewReady(cy.a(this.a), cy.a(this.a));
        continue;
        cy.a(this.a).onError(cy.a(this.a), new ArrownockException("Failed to establish connection", 2308));
        this.a.c();
        continue;
        if ((cy.a(this.a)) && (cy.a(this.a) != null))
        {
          this.a.c();
          cy.a(this.a).onRemotePartyDisconnected(cy.a(this.a));
        }
      }
    }
  }
  
  public final void onIceGatheringChange(PeerConnection.IceGatheringState paramIceGatheringState) {}
  
  public final void onRemoveStream(MediaStream paramMediaStream)
  {
    cy.a(this.a).onRemotePartyDisconnected(cy.a(this.a));
    cy.a(this.a, false);
  }
  
  public final void onRenegotiationNeeded()
  {
    cy.a(this.a, false);
  }
  
  public final void onSignalingChange(PeerConnection.SignalingState paramSignalingState) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */