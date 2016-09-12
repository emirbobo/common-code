package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl$LoaderInfo
  implements Loader.OnLoadCompleteListener<Object>
{
  final Bundle mArgs;
  LoaderManager.LoaderCallbacks<Object> mCallbacks;
  Object mData;
  boolean mDeliveredData;
  boolean mDestroyed;
  boolean mHaveData;
  final int mId;
  boolean mListenerRegistered;
  Loader<Object> mLoader;
  LoaderInfo mPendingLoader;
  boolean mReportNextStart;
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  
  public LoaderManagerImpl$LoaderInfo(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    this.mId = paramBundle;
    this.mArgs = paramLoaderCallbacks;
    LoaderManager.LoaderCallbacks localLoaderCallbacks;
    this.mCallbacks = localLoaderCallbacks;
  }
  
  void callOnLoadFinished(Loader<Object> paramLoader, Object paramObject)
  {
    String str;
    if (this.mCallbacks != null)
    {
      str = null;
      if (this.this$0.mActivity != null)
      {
        str = this.this$0.mActivity.mFragments.mNoTransactionsBecause;
        this.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
      }
    }
    try
    {
      if (LoaderManagerImpl.DEBUG)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        Log.v("LoaderManager", "  onLoadFinished in " + paramLoader + ": " + paramLoader.dataToString(paramObject));
      }
      this.mCallbacks.onLoadFinished(paramLoader, paramObject);
      if (this.this$0.mActivity != null) {
        this.this$0.mActivity.mFragments.mNoTransactionsBecause = str;
      }
      this.mDeliveredData = true;
      return;
    }
    finally
    {
      if (this.this$0.mActivity != null) {
        this.this$0.mActivity.mFragments.mNoTransactionsBecause = str;
      }
    }
  }
  
  void destroy()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Destroying: " + this);
    }
    this.mDestroyed = true;
    boolean bool = this.mDeliveredData;
    this.mDeliveredData = false;
    String str;
    if ((this.mCallbacks != null) && (this.mLoader != null) && (this.mHaveData) && (bool))
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Reseting: " + this);
      }
      str = null;
      if (this.this$0.mActivity != null)
      {
        str = this.this$0.mActivity.mFragments.mNoTransactionsBecause;
        this.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
      }
    }
    try
    {
      this.mCallbacks.onLoaderReset(this.mLoader);
      if (this.this$0.mActivity != null) {
        this.this$0.mActivity.mFragments.mNoTransactionsBecause = str;
      }
      this.mCallbacks = null;
      this.mData = null;
      this.mHaveData = false;
      if (this.mLoader != null)
      {
        if (this.mListenerRegistered)
        {
          this.mListenerRegistered = false;
          this.mLoader.unregisterListener(this);
        }
        this.mLoader.reset();
      }
      if (this.mPendingLoader != null) {
        this.mPendingLoader.destroy();
      }
      return;
    }
    finally
    {
      if (this.this$0.mActivity != null) {
        this.this$0.mActivity.mFragments.mNoTransactionsBecause = str;
      }
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.mId);
    paramPrintWriter.print(" mArgs=");
    paramPrintWriter.println(this.mArgs);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCallbacks=");
    paramPrintWriter.println(this.mCallbacks);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoader=");
    paramPrintWriter.println(this.mLoader);
    if (this.mLoader != null) {
      this.mLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if ((this.mHaveData) || (this.mDeliveredData))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHaveData=");
      paramPrintWriter.print(this.mHaveData);
      paramPrintWriter.print("  mDeliveredData=");
      paramPrintWriter.println(this.mDeliveredData);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      paramPrintWriter.println(this.mData);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.print(this.mStarted);
    paramPrintWriter.print(" mReportNextStart=");
    paramPrintWriter.print(this.mReportNextStart);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.mDestroyed);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetaining=");
    paramPrintWriter.print(this.mRetaining);
    paramPrintWriter.print(" mRetainingStarted=");
    paramPrintWriter.print(this.mRetainingStarted);
    paramPrintWriter.print(" mListenerRegistered=");
    paramPrintWriter.println(this.mListenerRegistered);
    if (this.mPendingLoader != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Pending Loader ");
      paramPrintWriter.print(this.mPendingLoader);
      paramPrintWriter.println(":");
      this.mPendingLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  void finishRetain()
  {
    if (this.mRetaining)
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Finished Retaining: " + this);
      }
      this.mRetaining = false;
      if ((this.mStarted != this.mRetainingStarted) && (!this.mStarted)) {
        stop();
      }
    }
    if ((this.mStarted) && (this.mHaveData) && (!this.mReportNextStart)) {
      callOnLoadFinished(this.mLoader, this.mData);
    }
  }
  
  public void onLoadComplete(Loader<Object> paramLoader, Object paramObject)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "onLoadComplete: " + this);
    }
    if (this.mDestroyed) {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
      }
    }
    for (;;)
    {
      return;
      if (this.this$0.mLoaders.get(this.mId) != this)
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Ignoring load complete -- not active");
        }
      }
      else
      {
        LoaderInfo localLoaderInfo = this.mPendingLoader;
        if (localLoaderInfo != null)
        {
          if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Switching to pending loader: " + localLoaderInfo);
          }
          this.mPendingLoader = null;
          this.this$0.mLoaders.put(this.mId, null);
          destroy();
          this.this$0.installLoader(localLoaderInfo);
        }
        else
        {
          if ((this.mData != paramObject) || (!this.mHaveData))
          {
            this.mData = paramObject;
            this.mHaveData = true;
            if (this.mStarted) {
              callOnLoadFinished(paramLoader, paramObject);
            }
          }
          paramLoader = (LoaderInfo)this.this$0.mInactiveLoaders.get(this.mId);
          if ((paramLoader != null) && (paramLoader != this))
          {
            paramLoader.mDeliveredData = false;
            paramLoader.destroy();
            this.this$0.mInactiveLoaders.remove(this.mId);
          }
          if ((this.this$0.mActivity != null) && (!this.this$0.hasRunningLoaders())) {
            this.this$0.mActivity.mFragments.startPendingDeferredFragments();
          }
        }
      }
    }
  }
  
  void reportStart()
  {
    if ((this.mStarted) && (this.mReportNextStart))
    {
      this.mReportNextStart = false;
      if (this.mHaveData) {
        callOnLoadFinished(this.mLoader, this.mData);
      }
    }
  }
  
  void retain()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Retaining: " + this);
    }
    this.mRetaining = true;
    this.mRetainingStarted = this.mStarted;
    this.mStarted = false;
    this.mCallbacks = null;
  }
  
  void start()
  {
    if ((this.mRetaining) && (this.mRetainingStarted)) {
      this.mStarted = true;
    }
    for (;;)
    {
      return;
      if (!this.mStarted)
      {
        this.mStarted = true;
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Starting: " + this);
        }
        if ((this.mLoader == null) && (this.mCallbacks != null)) {
          this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
        }
        if (this.mLoader != null)
        {
          if ((this.mLoader.getClass().isMemberClass()) && (!Modifier.isStatic(this.mLoader.getClass().getModifiers()))) {
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
          }
          if (!this.mListenerRegistered)
          {
            this.mLoader.registerListener(this.mId, this);
            this.mListenerRegistered = true;
          }
          this.mLoader.startLoading();
        }
      }
    }
  }
  
  void stop()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Stopping: " + this);
    }
    this.mStarted = false;
    if ((!this.mRetaining) && (this.mLoader != null) && (this.mListenerRegistered))
    {
      this.mListenerRegistered = false;
      this.mLoader.unregisterListener(this);
      this.mLoader.stopLoading();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(this.mId);
    localStringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(this.mLoader, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\LoaderManagerImpl$LoaderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */