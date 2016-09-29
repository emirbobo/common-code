package com.lidroid.xutils.bitmap;

public abstract interface BitmapCacheListener
{
  public abstract void onClearCacheFinished();
  
  public abstract void onClearCacheFinished(String paramString);
  
  public abstract void onClearDiskCacheFinished();
  
  public abstract void onClearDiskCacheFinished(String paramString);
  
  public abstract void onClearMemoryCacheFinished();
  
  public abstract void onClearMemoryCacheFinished(String paramString);
  
  public abstract void onCloseCacheFinished();
  
  public abstract void onFlushCacheFinished();
  
  public abstract void onInitDiskFinished();
  
  public abstract void onInitMemoryCacheFinished();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\BitmapCacheListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */