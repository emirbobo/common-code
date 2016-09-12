package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FragmentActivity
  extends Activity
{
  static final String FRAGMENTS_TAG = "android:support:fragments";
  private static final int HONEYCOMB = 11;
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  private static final String TAG = "FragmentActivity";
  SimpleArrayMap<String, LoaderManagerImpl> mAllLoaderManagers;
  boolean mCheckedForLoaderManager;
  final FragmentContainer mContainer = new FragmentContainer()
  {
    public View findViewById(int paramAnonymousInt)
    {
      return FragmentActivity.this.findViewById(paramAnonymousInt);
    }
  };
  boolean mCreated;
  final FragmentManagerImpl mFragments = new FragmentManagerImpl();
  final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
      }
      for (;;)
      {
        return;
        if (FragmentActivity.this.mStopped)
        {
          FragmentActivity.this.doReallyStop(false);
          continue;
          FragmentActivity.this.onResumeFragments();
          FragmentActivity.this.mFragments.execPendingActions();
        }
      }
    }
  };
  LoaderManagerImpl mLoaderManager;
  boolean mLoadersStarted;
  boolean mOptionsMenuInvalidated;
  boolean mReallyStopped;
  boolean mResumed;
  boolean mRetaining;
  boolean mStopped;
  
  private void dumpViewHierarchy(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null) {
      paramPrintWriter.println("null");
    }
    for (;;)
    {
      return;
      paramPrintWriter.println(viewToString(paramView));
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        if (j > 0)
        {
          paramString = paramString + "  ";
          for (int i = 0; i < j; i++) {
            dumpViewHierarchy(paramString, paramPrintWriter, paramView.getChildAt(i));
          }
        }
      }
    }
  }
  
  private static String viewToString(View paramView)
  {
    char c2 = 'F';
    int i = 46;
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    char c3;
    char c1;
    label122:
    label143:
    label164:
    label185:
    label206:
    label227:
    label248:
    label272:
    label291:
    Object localObject;
    switch (paramView.getVisibility())
    {
    default: 
      localStringBuilder.append('.');
      if (paramView.isFocusable())
      {
        c3 = 'F';
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isEnabled()) {
          break label591;
        }
        c3 = 'E';
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.willNotDraw()) {
          break label601;
        }
        c3 = '.';
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isHorizontalScrollBarEnabled()) {
          break label611;
        }
        c3 = 'H';
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isVerticalScrollBarEnabled()) {
          break label621;
        }
        c3 = 'V';
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isClickable()) {
          break label631;
        }
        c3 = 'C';
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isLongClickable()) {
          break label641;
        }
        c3 = 'L';
        c1 = c3;
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        if (!paramView.isFocused()) {
          break label651;
        }
        c1 = c2;
        localStringBuilder.append(c1);
        if (!paramView.isSelected()) {
          break label659;
        }
        c2 = 'S';
        c1 = c2;
        localStringBuilder.append(c1);
        c1 = i;
        if (paramView.isPressed())
        {
          i = 80;
          c1 = i;
        }
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        i = paramView.getId();
        if (i != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(i));
          localObject = paramView.getResources();
          if ((i != 0) && (localObject != null)) {
            switch (0xFF000000 & i)
            {
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramView = ((Resources)localObject).getResourcePackageName(i);
        String str = ((Resources)localObject).getResourceTypeName(i);
        localObject = ((Resources)localObject).getResourceEntryName(i);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramView);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
      }
      catch (Resources.NotFoundException paramView)
      {
        label591:
        label601:
        label611:
        label621:
        label631:
        label641:
        label651:
        label659:
        continue;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append('V');
      break;
      localStringBuilder.append('I');
      break;
      localStringBuilder.append('G');
      break;
      c3 = '.';
      c1 = c3;
      break label122;
      c3 = '.';
      c1 = c3;
      break label143;
      c3 = 'D';
      c1 = c3;
      break label164;
      c3 = '.';
      c1 = c3;
      break label185;
      c3 = '.';
      c1 = c3;
      break label206;
      c3 = '.';
      c1 = c3;
      break label227;
      c3 = '.';
      c1 = c3;
      break label248;
      c2 = '.';
      c1 = c2;
      break label272;
      c2 = '.';
      c1 = c2;
      break label291;
      paramView = "app";
      continue;
      paramView = "android";
    }
  }
  
  void doReallyStop(boolean paramBoolean)
  {
    if (!this.mReallyStopped)
    {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.mLoadersStarted);
    if (this.mLoaderManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
      paramPrintWriter.println(":");
      this.mLoaderManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    dumpViewHierarchy(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    Object localObject = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localObject != null) {}
    for (localObject = ((NonConfigurationInstances)localObject).custom;; localObject = null) {
      return localObject;
    }
  }
  
  LoaderManagerImpl getLoaderManager(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAllLoaderManagers == null) {
      this.mAllLoaderManagers = new SimpleArrayMap();
    }
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
    if (localLoaderManagerImpl == null) {
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(paramString, this, paramBoolean1);
        this.mAllLoaderManagers.put(paramString, localLoaderManagerImpl);
      }
    }
    for (;;)
    {
      return localLoaderManagerImpl;
      localLoaderManagerImpl.updateActivity(this);
    }
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments;
  }
  
  public LoaderManager getSupportLoaderManager()
  {
    if (this.mLoaderManager != null) {}
    for (LoaderManagerImpl localLoaderManagerImpl = this.mLoaderManager;; localLoaderManagerImpl = this.mLoaderManager)
    {
      return localLoaderManagerImpl;
      this.mCheckedForLoaderManager = true;
      this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
    }
  }
  
  void invalidateSupportFragment(String paramString)
  {
    if (this.mAllLoaderManagers != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
      if ((localLoaderManagerImpl != null) && (!localLoaderManagerImpl.mRetaining))
      {
        localLoaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(paramString);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i--;
      if ((this.mFragments.mActive == null) || (i < 0) || (i >= this.mFragments.mActive.size())) {
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
      }
    }
    for (;;)
    {
      return;
      Fragment localFragment = (Fragment)this.mFragments.mActive.get(i);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
      }
      else
      {
        localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
        continue;
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    if (!this.mFragments.popBackStackImmediate()) {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.dispatchConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    this.mFragments.attachActivity(this, this.mContainer, null);
    if (getLayoutInflater().getFactory() == null) {
      getLayoutInflater().setFactory(this);
    }
    super.onCreate(paramBundle);
    NonConfigurationInstances localNonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null) {
      this.mAllLoaderManagers = localNonConfigurationInstances.loaders;
    }
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      FragmentManagerImpl localFragmentManagerImpl = this.mFragments;
      paramBundle = (Bundle)localObject;
      if (localNonConfigurationInstances != null) {
        paramBundle = localNonConfigurationInstances.fragments;
      }
      localFragmentManagerImpl.restoreAllState(localParcelable, paramBundle);
    }
    this.mFragments.dispatchCreate();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool;
    if (paramInt == 0)
    {
      bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.mFragments.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT < 11) {}
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = super.onCreatePanelMenu(paramInt, paramMenu);
    }
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = null;
    if (!"fragment".equals(paramString)) {
      paramString = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    for (;;)
    {
      return paramString;
      String str2 = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
      String str1 = str2;
      if (str2 == null) {
        str1 = localTypedArray.getString(0);
      }
      int j = localTypedArray.getResourceId(1, -1);
      str2 = localTypedArray.getString(2);
      localTypedArray.recycle();
      if (!Fragment.isSupportFragmentClass(this, str1))
      {
        paramString = super.onCreateView(paramString, paramContext, paramAttributeSet);
      }
      else
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
        if ((-1 == 0) && (j == -1) && (str2 == null)) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
        }
        paramContext = (Context)localObject;
        if (j != -1) {
          paramContext = this.mFragments.findFragmentById(j);
        }
        paramString = paramContext;
        if (paramContext == null)
        {
          paramString = paramContext;
          if (str2 != null) {
            paramString = this.mFragments.findFragmentByTag(str2);
          }
        }
        paramContext = paramString;
        if (paramString == null)
        {
          paramContext = paramString;
          if (-1 != 0) {
            paramContext = this.mFragments.findFragmentById(0);
          }
        }
        if (FragmentManagerImpl.DEBUG) {
          Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(j) + " fname=" + str1 + " existing=" + paramContext);
        }
        int i;
        if (paramContext == null)
        {
          paramContext = Fragment.instantiate(this, str1);
          paramContext.mFromLayout = true;
          if (j != 0)
          {
            i = j;
            paramContext.mFragmentId = i;
            paramContext.mContainerId = 0;
            paramContext.mTag = str2;
            paramContext.mInLayout = true;
            paramContext.mFragmentManager = this.mFragments;
            paramContext.onInflate(this, paramAttributeSet, paramContext.mSavedFragmentState);
            this.mFragments.addFragment(paramContext, true);
          }
        }
        for (;;)
        {
          if (paramContext.mView != null) {
            break label527;
          }
          throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
          i = 0;
          break;
          if (paramContext.mInLayout) {
            throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(j) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(0) + " with another fragment for " + str1);
          }
          paramContext.mInLayout = true;
          if (!paramContext.mRetaining) {
            paramContext.onInflate(this, paramAttributeSet, paramContext.mSavedFragmentState);
          }
          this.mFragments.moveToState(paramContext);
        }
        label527:
        if (j != 0) {
          paramContext.mView.setId(j);
        }
        if (paramContext.mView.getTag() == null) {
          paramContext.mView.setTag(str2);
        }
        paramString = paramContext.mView;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    doReallyStop(false);
    this.mFragments.dispatchDestroy();
    if (this.mLoaderManager != null) {
      this.mLoaderManager.doDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0)) {
      onBackPressed();
    }
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool;
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      switch (paramInt)
      {
      default: 
        bool = false;
        break;
      case 0: 
        bool = this.mFragments.dispatchOptionsItemSelected(paramMenuItem);
        break;
      case 6: 
        bool = this.mFragments.dispatchContextItemSelected(paramMenuItem);
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.mFragments.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    }
    this.mFragments.dispatchPause();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
  }
  
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      if (this.mOptionsMenuInvalidated)
      {
        this.mOptionsMenuInvalidated = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
    }
    for (boolean bool = onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.dispatchPrepareOptionsMenu(paramMenu);; bool = super.onPreparePanel(paramInt, paramView, paramMenu)) {
      return bool;
    }
  }
  
  void onReallyStop()
  {
    if (this.mLoadersStarted)
    {
      this.mLoadersStarted = false;
      if (this.mLoaderManager != null)
      {
        if (this.mRetaining) {
          break label41;
        }
        this.mLoaderManager.doStop();
      }
    }
    for (;;)
    {
      this.mFragments.dispatchReallyStop();
      return;
      label41:
      this.mLoaderManager.doRetain();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
  }
  
  protected void onResumeFragments()
  {
    this.mFragments.dispatchResume();
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (this.mStopped) {
      doReallyStop(true);
    }
    Object localObject2 = onRetainCustomNonConfigurationInstance();
    ArrayList localArrayList = this.mFragments.retainNonConfig();
    int k = 0;
    int j = 0;
    Object localObject1;
    if (this.mAllLoaderManagers != null)
    {
      int m = this.mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[m];
      for (int i = m - 1; i >= 0; i--) {
        arrayOfLoaderManagerImpl[i] = ((LoaderManagerImpl)this.mAllLoaderManagers.valueAt(i));
      }
      k = 0;
      i = j;
      j = k;
      k = i;
      if (j < m)
      {
        localObject1 = arrayOfLoaderManagerImpl[j];
        if (((LoaderManagerImpl)localObject1).mRetaining) {
          i = 1;
        }
        for (;;)
        {
          j++;
          break;
          ((LoaderManagerImpl)localObject1).doDestroy();
          this.mAllLoaderManagers.remove(((LoaderManagerImpl)localObject1).mWho);
        }
      }
    }
    if ((localArrayList == null) && (k == 0) && (localObject2 == null)) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      localObject1 = new NonConfigurationInstances();
      ((NonConfigurationInstances)localObject1).activity = null;
      ((NonConfigurationInstances)localObject1).custom = localObject2;
      ((NonConfigurationInstances)localObject1).children = null;
      ((NonConfigurationInstances)localObject1).fragments = localArrayList;
      ((NonConfigurationInstances)localObject1).loaders = this.mAllLoaderManagers;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.mFragments.saveAllState();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.dispatchActivityCreated();
    }
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    if (!this.mLoadersStarted)
    {
      this.mLoadersStarted = true;
      if (this.mLoaderManager == null) {
        break label142;
      }
      this.mLoaderManager.doStart();
    }
    int j;
    LoaderManagerImpl[] arrayOfLoaderManagerImpl;
    for (;;)
    {
      this.mCheckedForLoaderManager = true;
      this.mFragments.dispatchStart();
      if (this.mAllLoaderManagers == null) {
        return;
      }
      j = this.mAllLoaderManagers.size();
      arrayOfLoaderManagerImpl = new LoaderManagerImpl[j];
      for (i = j - 1; i >= 0; i--) {
        arrayOfLoaderManagerImpl[i] = ((LoaderManagerImpl)this.mAllLoaderManagers.valueAt(i));
      }
      label142:
      if (!this.mCheckedForLoaderManager)
      {
        this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
        if ((this.mLoaderManager != null) && (!this.mLoaderManager.mStarted)) {
          this.mLoaderManager.doStart();
        }
      }
    }
    for (int i = 0; i < j; i++)
    {
      LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[i];
      localLoaderManagerImpl.finishRetain();
      localLoaderManagerImpl.doReportStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mStopped = true;
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.dispatchStop();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1) {
      super.startActivityForResult(paramIntent, -1);
    }
    for (;;)
    {
      return;
      if ((0xFFFF0000 & paramInt) != 0) {
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      }
      super.startActivityForResult(paramIntent, (paramFragment.mIndex + 1 << 16) + (0xFFFF & paramInt));
    }
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      ActivityCompatHoneycomb.invalidateOptionsMenu(this);
    }
    for (;;)
    {
      return;
      this.mOptionsMenuInvalidated = true;
    }
  }
  
  static class FragmentTag
  {
    public static final int[] Fragment = { 16842755, 16842960, 16842961 };
    public static final int Fragment_id = 1;
    public static final int Fragment_name = 0;
    public static final int Fragment_tag = 2;
  }
  
  static final class NonConfigurationInstances
  {
    Object activity;
    SimpleArrayMap<String, Object> children;
    Object custom;
    ArrayList<Fragment> fragments;
    SimpleArrayMap<String, LoaderManagerImpl> loaders;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\app\FragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */