package cn.domob.android.offerwall;

import java.net.URI;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

class DomobOfferWallView$2
  implements a.a
{
  DomobOfferWallView$2(DomobOfferWallView paramDomobOfferWallView) {}
  
  public void a(a parama, String paramString)
  {
    DomobOfferWallView.b().b("Intercepted URL: " + paramString);
    if (!l.e(paramString))
    {
      parama = URI.create(paramString);
      if ("domob".equals(parama.getScheme()))
      {
        if (!"click".equals(parama.getHost())) {
          break label179;
        }
        parama = URLEncodedUtils.parse(parama, "UTF-8");
        if ((parama == null) || (parama.get(0) == null) || (!"id".equals(((NameValuePair)parama.get(0)).getName()))) {}
      }
    }
    for (;;)
    {
      int i;
      try
      {
        i = Integer.valueOf(((NameValuePair)parama.get(0)).getValue()).intValue();
        paramString = DomobOfferWallView.b();
        parama = new java/lang/StringBuilder;
        parama.<init>();
        paramString.b("Item was clicked with app id: " + i);
        DomobOfferWallView.a(this.a).b(i);
        return;
      }
      catch (Exception parama)
      {
        DomobOfferWallView.b().a(parama);
        continue;
      }
      label179:
      if ("download".equals(parama.getHost()))
      {
        parama = URLEncodedUtils.parse(parama, "UTF-8");
        if ((parama != null) && (parama.get(0) != null) && ("id".equals(((NameValuePair)parama.get(0)).getName()))) {
          try
          {
            i = Integer.valueOf(((NameValuePair)parama.get(0)).getValue()).intValue();
            DomobOfferWallView.b().b(String.format("Item with ID = %d is about to be downloaded.", new Object[] { Integer.valueOf(i) }));
            DomobOfferWallView.a(this.a).a(i);
          }
          catch (Exception parama)
          {
            DomobOfferWallView.b().a(parama);
          }
        } else {
          DomobOfferWallView.b().e("Cannot search download info without id.");
        }
      }
      else if ("refresh".equals(parama.getHost()))
      {
        DomobOfferWallView.b().b("Called refresh from web page. Load offer wall again.");
        this.a.loadOfferWall();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\DomobOfferWallView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */