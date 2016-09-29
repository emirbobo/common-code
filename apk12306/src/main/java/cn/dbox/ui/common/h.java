package cn.dbox.ui.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import cn.dbox.core.bean.a;
import cn.dbox.core.bean.c;
import java.util.ArrayList;

public class h
  extends LinearLayout
{
  public ArrayList<cn.dbox.core.bean.d> a;
  public ArrayList<c> b;
  public ArrayList<a> c;
  public cn.dbox.core.b d;
  public i e;
  public ArrayList<cn.dbox.ui.card.e> f = new ArrayList();
  public cn.dbox.ui.d.b g;
  public View h;
  public View i;
  public View j;
  public Context k;
  public d l;
  public LinearLayout.LayoutParams m;
  
  public h(Context paramContext)
  {
    this(paramContext, null, null, null);
  }
  
  public h(Context paramContext, ArrayList<c> paramArrayList, ArrayList<a> paramArrayList1, cn.dbox.core.b paramb)
  {
    super(paramContext);
    this.k = paramContext;
    this.b = paramArrayList;
    this.a = k.a(paramArrayList);
    this.d = paramb;
    this.m = new LinearLayout.LayoutParams(-1, -1);
    setLayoutParams(this.m);
    setOrientation(1);
    this.e = new i(paramContext);
    this.h = LayoutInflater.from(this.k).inflate(cn.dbox.ui.e.d.a(this.k, "dbox_progressbar"), null);
    this.i = LayoutInflater.from(this.k).inflate(cn.dbox.ui.e.d.a(this.k, "dbox_loading"), null);
    this.j = LayoutInflater.from(this.k).inflate(cn.dbox.ui.e.d.a(this.k, "dbox_error"), null);
    this.l = new d(paramContext);
  }
  
  public void a(Context paramContext, ArrayList<c> paramArrayList, ArrayList<a> paramArrayList1, cn.dbox.core.b paramb)
  {
    this.k = paramContext;
    this.b = paramArrayList;
    this.a = k.a(paramArrayList);
    this.d = paramb;
  }
  
  public void a(cn.dbox.ui.d.b paramb)
  {
    this.g = paramb;
    for (int n = 0; n < this.f.size(); n++) {
      ((cn.dbox.ui.card.e)this.f.get(n)).a(paramb);
    }
  }
  
  public void a(cn.dbox.ui.d.e parame)
  {
    this.e.a(parame);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */