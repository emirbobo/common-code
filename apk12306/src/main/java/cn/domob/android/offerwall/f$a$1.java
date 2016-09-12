package cn.domob.android.offerwall;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

class f$a$1
  implements Runnable
{
  f$a$1(f.a parama, Context paramContext) {}
  
  public void run()
  {
    f.f().a(f.class.getSimpleName(), "getLocationBasedService");
    for (;;)
    {
      try
      {
        localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
        if (localTelephonyManager != null)
        {
          f.f().a(f.class.getSimpleName(), "tManager is not null");
          m localm = f.f();
          localObject = f.class.getSimpleName();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localm.a(localObject, "Network Operator: " + localTelephonyManager.getNetworkOperator());
          if ((localTelephonyManager.getNetworkOperator() == null) || (localTelephonyManager.getNetworkOperator().length() < 5)) {}
        }
        switch (localTelephonyManager.getPhoneType())
        {
        default: 
          return;
        }
      }
      catch (Exception localException)
      {
        TelephonyManager localTelephonyManager;
        Object localObject;
        int j;
        int i;
        int k;
        int m;
        f.f().a(localException);
        continue;
      }
      localObject = (GsmCellLocation)localTelephonyManager.getCellLocation();
      if (localObject != null)
      {
        j = ((GsmCellLocation)localObject).getCid();
        i = ((GsmCellLocation)localObject).getLac();
        k = Integer.valueOf(localTelephonyManager.getNetworkOperator().substring(0, 3)).intValue();
        m = Integer.valueOf(localTelephonyManager.getNetworkOperator().substring(3, 5)).intValue();
        f.a.a(this.b, j, i, m, k);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\f$a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */