package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.view.View;

class SearchViewCompat$SearchViewCompatHoneycombImpl
  extends SearchViewCompat.SearchViewCompatStubImpl
{
  public CharSequence getQuery(View paramView)
  {
    return SearchViewCompatHoneycomb.getQuery(paramView);
  }
  
  public boolean isIconified(View paramView)
  {
    return SearchViewCompatHoneycomb.isIconified(paramView);
  }
  
  public boolean isQueryRefinementEnabled(View paramView)
  {
    return SearchViewCompatHoneycomb.isQueryRefinementEnabled(paramView);
  }
  
  public boolean isSubmitButtonEnabled(View paramView)
  {
    return SearchViewCompatHoneycomb.isSubmitButtonEnabled(paramView);
  }
  
  public Object newOnCloseListener(final SearchViewCompat.OnCloseListenerCompat paramOnCloseListenerCompat)
  {
    SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge()
    {
      public boolean onClose()
      {
        return paramOnCloseListenerCompat.onClose();
      }
    });
  }
  
  public Object newOnQueryTextListener(final SearchViewCompat.OnQueryTextListenerCompat paramOnQueryTextListenerCompat)
  {
    SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge()
    {
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        return paramOnQueryTextListenerCompat.onQueryTextChange(paramAnonymousString);
      }
      
      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        return paramOnQueryTextListenerCompat.onQueryTextSubmit(paramAnonymousString);
      }
    });
  }
  
  public View newSearchView(Context paramContext)
  {
    return SearchViewCompatHoneycomb.newSearchView(paramContext);
  }
  
  public void setIconified(View paramView, boolean paramBoolean)
  {
    SearchViewCompatHoneycomb.setIconified(paramView, paramBoolean);
  }
  
  public void setMaxWidth(View paramView, int paramInt)
  {
    SearchViewCompatHoneycomb.setMaxWidth(paramView, paramInt);
  }
  
  public void setOnCloseListener(Object paramObject1, Object paramObject2)
  {
    SearchViewCompatHoneycomb.setOnCloseListener(paramObject1, paramObject2);
  }
  
  public void setOnQueryTextListener(Object paramObject1, Object paramObject2)
  {
    SearchViewCompatHoneycomb.setOnQueryTextListener(paramObject1, paramObject2);
  }
  
  public void setQuery(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    SearchViewCompatHoneycomb.setQuery(paramView, paramCharSequence, paramBoolean);
  }
  
  public void setQueryHint(View paramView, CharSequence paramCharSequence)
  {
    SearchViewCompatHoneycomb.setQueryHint(paramView, paramCharSequence);
  }
  
  public void setQueryRefinementEnabled(View paramView, boolean paramBoolean)
  {
    SearchViewCompatHoneycomb.setQueryRefinementEnabled(paramView, paramBoolean);
  }
  
  public void setSearchableInfo(View paramView, ComponentName paramComponentName)
  {
    SearchViewCompatHoneycomb.setSearchableInfo(paramView, paramComponentName);
  }
  
  public void setSubmitButtonEnabled(View paramView, boolean paramBoolean)
  {
    SearchViewCompatHoneycomb.setSubmitButtonEnabled(paramView, paramBoolean);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\SearchViewCompat$SearchViewCompatHoneycombImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */