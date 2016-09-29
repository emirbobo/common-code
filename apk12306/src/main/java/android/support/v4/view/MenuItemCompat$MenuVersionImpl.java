package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

abstract interface MenuItemCompat$MenuVersionImpl
{
  public abstract boolean collapseActionView(MenuItem paramMenuItem);
  
  public abstract boolean expandActionView(MenuItem paramMenuItem);
  
  public abstract View getActionView(MenuItem paramMenuItem);
  
  public abstract boolean isActionViewExpanded(MenuItem paramMenuItem);
  
  public abstract MenuItem setActionView(MenuItem paramMenuItem, int paramInt);
  
  public abstract MenuItem setActionView(MenuItem paramMenuItem, View paramView);
  
  public abstract MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener);
  
  public abstract void setShowAsAction(MenuItem paramMenuItem, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\view\MenuItemCompat$MenuVersionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */