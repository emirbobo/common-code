package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl
  extends MenuItemCompat.HoneycombMenuVersionImpl
{
  public boolean collapseActionView(MenuItem paramMenuItem)
  {
    return MenuItemCompatIcs.collapseActionView(paramMenuItem);
  }
  
  public boolean expandActionView(MenuItem paramMenuItem)
  {
    return MenuItemCompatIcs.expandActionView(paramMenuItem);
  }
  
  public boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    return MenuItemCompatIcs.isActionViewExpanded(paramMenuItem);
  }
  
  public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, final MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    if (paramOnActionExpandListener == null) {}
    for (paramMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, null);; paramMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, new MenuItemCompatIcs.SupportActionExpandProxy()
        {
          public boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
          {
            return paramOnActionExpandListener.onMenuItemActionCollapse(paramAnonymousMenuItem);
          }
          
          public boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
          {
            return paramOnActionExpandListener.onMenuItemActionExpand(paramAnonymousMenuItem);
          }
        })) {
      return paramMenuItem;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\MenuItemCompat$IcsMenuVersionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */