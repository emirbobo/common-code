package com.ta.utdid2.core.persistent;

import com.bangcle.andjni.JniLib;
import java.util.HashMap;
import java.util.Map;

public final class TransactionXMLFile$MySharedPreferencesImpl$EditorImpl
  implements MySharedPreferences.MyEditor
{
  private boolean mClear = false;
  private final Map<String, Object> mModified = new HashMap();
  
  static
  {
    JniLib.a(EditorImpl.class, 1069);
  }
  
  public TransactionXMLFile$MySharedPreferencesImpl$EditorImpl(TransactionXMLFile.MySharedPreferencesImpl paramMySharedPreferencesImpl) {}
  
  public native MySharedPreferences.MyEditor clear();
  
  public native boolean commit();
  
  public native MySharedPreferences.MyEditor putBoolean(String paramString, boolean paramBoolean);
  
  public native MySharedPreferences.MyEditor putFloat(String paramString, float paramFloat);
  
  public native MySharedPreferences.MyEditor putInt(String paramString, int paramInt);
  
  public native MySharedPreferences.MyEditor putLong(String paramString, long paramLong);
  
  public native MySharedPreferences.MyEditor putString(String paramString1, String paramString2);
  
  public native MySharedPreferences.MyEditor remove(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\core\persistent\TransactionXMLFile$MySharedPreferencesImpl$EditorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */