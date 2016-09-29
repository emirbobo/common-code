package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl
  extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
{
  public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
  {
    AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge()
    {
      public Object createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        Object localObject = paramAccessibilityNodeProviderCompat.createAccessibilityNodeInfo(paramAnonymousInt);
        if (localObject == null) {}
        for (localObject = null;; localObject = ((AccessibilityNodeInfoCompat)localObject).getInfo()) {
          return localObject;
        }
      }
      
      public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        List localList = paramAccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
        paramAnonymousString = new ArrayList();
        int i = localList.size();
        for (paramAnonymousInt = 0; paramAnonymousInt < i; paramAnonymousInt++) {
          paramAnonymousString.add(((AccessibilityNodeInfoCompat)localList.get(paramAnonymousInt)).getInfo());
        }
        return paramAnonymousString;
      }
      
      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return paramAccessibilityNodeProviderCompat.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\accessibility\AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */