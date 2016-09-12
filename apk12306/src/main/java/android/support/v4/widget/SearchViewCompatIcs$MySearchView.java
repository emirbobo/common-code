package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

public class SearchViewCompatIcs$MySearchView
  extends SearchView
{
  public SearchViewCompatIcs$MySearchView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onActionViewCollapsed()
  {
    setQuery("", false);
    super.onActionViewCollapsed();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\widget\SearchViewCompatIcs$MySearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */