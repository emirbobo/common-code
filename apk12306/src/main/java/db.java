import android.util.Log;
import org.webrtc.PeerConnection;
import org.webrtc.SdpObserver;
import org.webrtc.SessionDescription;
import org.webrtc.SessionDescription.Type;

final class db
  implements SdpObserver
{
  db(cy paramcy) {}
  
  public final void onCreateFailure(String paramString)
  {
    Log.e("anLive", "create SDP failure: " + paramString);
  }
  
  public final void onCreateSuccess(SessionDescription paramSessionDescription)
  {
    paramSessionDescription = new SessionDescription(paramSessionDescription.type, cy.a(this.a, paramSessionDescription.description));
    cy.a(this.a).setLocalDescription(cy.a(this.a), paramSessionDescription);
    if (paramSessionDescription.type == SessionDescription.Type.ANSWER) {
      cy.a(this.a).sendAnswer(cy.a(this.a), paramSessionDescription.description, cy.a(this.a));
    }
    for (;;)
    {
      return;
      if (paramSessionDescription.type == SessionDescription.Type.OFFER) {
        cy.a(this.a).sendOffer(cy.a(this.a), paramSessionDescription.description, cy.a(this.a));
      }
    }
  }
  
  public final void onSetFailure(String paramString)
  {
    Log.e("anLive", "set SDP failure: " + paramString);
  }
  
  public final void onSetSuccess() {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */