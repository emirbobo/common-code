package com.ta.utdid2.core.persistent;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class TransactionXMLFile
{
  private static final Object GLOBAL_COMMIT_LOCK = new Object();
  public static final int MODE_PRIVATE = 0;
  public static final int MODE_WORLD_READABLE = 1;
  public static final int MODE_WORLD_WRITEABLE = 2;
  private File mPreferencesDir;
  private final Object mSync = new Object();
  private HashMap<File, MySharedPreferencesImpl> sSharedPrefs = new HashMap();
  
  static
  {
    JniLib.a(TransactionXMLFile.class, 1071);
  }
  
  public TransactionXMLFile(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.mPreferencesDir = new File(paramString);
      return;
    }
    throw new RuntimeException("Directory can not be empty");
  }
  
  private native File getPreferencesDir();
  
  private native File getSharedPrefsFile(String paramString);
  
  private static native File makeBackupFile(File paramFile);
  
  private native File makeFilename(File paramFile, String paramString);
  
  public native MySharedPreferences getMySharedPreferences(String paramString, int paramInt);
  
  private static final class MySharedPreferencesImpl
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
    
    MySharedPreferencesImpl(File paramFile, int paramInt, Map paramMap)
    {
      this.mFile = paramFile;
      this.mBackupFile = TransactionXMLFile.makeBackupFile(paramFile);
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\core\persistent\TransactionXMLFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */