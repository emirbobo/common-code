package com.ta.utdid2.core.persistent;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

final class TransactionXMLFile$MySharedPreferencesImpl
  implements MySharedPreferences
{
  private static final Object mContent = new Object();
  private boolean hasChange = false;
  private final File mBackupFile;
  private final File mFile;
  private WeakHashMap<MySharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners;
  private Map mMap;
  private final int mMode;
  
  static
  {
    JniLib.a(MySharedPreferencesImpl.class, 1070);
  }
  
  TransactionXMLFile$MySharedPreferencesImpl(File paramFile, int paramInt, Map paramMap)
  {
    this.mFile = paramFile;
    this.mBackupFile = TransactionXMLFile.access$000(paramFile);
    this.mMode = paramInt;
    if (paramMap != null) {}
    for (;;)
    {
      this.mMap = paramMap;
      this.mListeners = new WeakHashMap();
      return;
      paramMap = new HashMap();
    }
  }
  
  private native FileOutputStream createFileOutputStream(File paramFile);
  
  private native boolean writeFileLocked();
  
  public native boolean checkFile();
  
  public native boolean contains(String paramString);
  
  public native MySharedPreferences.MyEditor edit();
  
  public native Map<String, ?> getAll();
  
  public native boolean getBoolean(String paramString, boolean paramBoolean);
  
  public native float getFloat(String paramString, float paramFloat);
  
  public native int getInt(String paramString, int paramInt);
  
  public native long getLong(String paramString, long paramLong);
  
  public native String getString(String paramString1, String paramString2);
  
  public native boolean hasFileChanged();
  
  public native void registerOnSharedPreferenceChangeListener(MySharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener);
  
  public native void replace(Map paramMap);
  
  public native void setHasChange(boolean paramBoolean);
  
  public native void unregisterOnSharedPreferenceChangeListener(MySharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener);
  
  public final class EditorImpl
    implements MySharedPreferences.MyEditor
  {
    private boolean mClear = false;
    private final Map<String, Object> mModified = new HashMap();
    
    static
    {
      JniLib.a(EditorImpl.class, 1069);
    }
    
    public EditorImpl() {}
    
    public native MySharedPreferences.MyEditor clear();
    
    public native boolean commit();
    
    public native MySharedPreferences.MyEditor putBoolean(String paramString, boolean paramBoolean);
    
    public native MySharedPreferences.MyEditor putFloat(String paramString, float paramFloat);
    
    public native MySharedPreferences.MyEditor putInt(String paramString, int paramInt);
    
    public native MySharedPreferences.MyEditor putLong(String paramString, long paramLong);
    
    public native MySharedPreferences.MyEditor putString(String paramString1, String paramString2);
    
    public native MySharedPreferences.MyEditor remove(String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\core\persistent\TransactionXMLFile$MySharedPreferencesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */