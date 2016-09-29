package com.ta.utdid2.core.persistent;

public abstract interface MySharedPreferences$MyEditor
{
  public abstract MyEditor clear();
  
  public abstract boolean commit();
  
  public abstract MyEditor putBoolean(String paramString, boolean paramBoolean);
  
  public abstract MyEditor putFloat(String paramString, float paramFloat);
  
  public abstract MyEditor putInt(String paramString, int paramInt);
  
  public abstract MyEditor putLong(String paramString, long paramLong);
  
  public abstract MyEditor putString(String paramString1, String paramString2);
  
  public abstract MyEditor remove(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\core\persistent\MySharedPreferences$MyEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */