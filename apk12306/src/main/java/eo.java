import com.arrownock.push.PushService;

public final class eo
{
  public eo(PushService paramPushService) {}
  
  public final void a(Throwable paramThrowable)
  {
    bk.a().a(PushService.LOGGER_TAG, "Failed to find push server. Will retry later.", paramThrowable);
    this.a.scheduleReconnect(PushService.a(this.a));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */