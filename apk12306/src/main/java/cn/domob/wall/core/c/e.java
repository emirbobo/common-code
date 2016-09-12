package cn.domob.wall.core.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import cn.domob.wall.core.bean.AdExtend;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.ClickActionType;
import cn.domob.wall.core.bean.ControlInfo;
import cn.domob.wall.core.bean.ControlInfo.a;
import cn.domob.wall.core.bean.a;
import cn.domob.wall.core.e.b;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class e
{
  private static d a = new d(e.class.getSimpleName());
  private String b;
  private String c;
  private a d;
  private ControlInfo e;
  private List<AdInfo> f;
  private List<AdInfo> g;
  private List<AdInfo> h;
  private List<AdExtend> i;
  
  private int a(List<AdInfo> paramList)
  {
    int k;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int j = 0;
      k = j;
      if (!paramList.hasNext()) {
        break label47;
      }
      if (!((AdInfo)paramList.next()).isNew()) {
        break label49;
      }
      j++;
    }
    label47:
    label49:
    for (;;)
    {
      break;
      k = 0;
      return k;
    }
  }
  
  private ArrayList<AdInfo> a(List<AdInfo> paramList1, List<AdInfo> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList2 = b(paramList2);
    int k = 0;
    int m = -1;
    int j = 0;
    int n;
    for (;;)
    {
      n = j;
      if (k >= paramList2.size()) {
        break;
      }
      for (n = 0; n < ((AdInfo)paramList2.get(k)).getAdPosition() - 1 - m - 1; n++)
      {
        if (j < paramList1.size()) {
          localArrayList.add(paramList1.get(j));
        }
        j++;
      }
      localArrayList.add(paramList2.get(k));
      m = ((AdInfo)paramList2.get(k)).getAdPosition() - 1;
      k++;
    }
    while (n < paramList1.size())
    {
      localArrayList.add(paramList1.get(n));
      n++;
    }
    return localArrayList;
  }
  
  private List<AdInfo> a(long paramLong, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString1);
    paramJSONObject = new ArrayList();
    if (localJSONArray != null)
    {
      int j = 0;
      for (;;)
      {
        if (j < localJSONArray.length()) {
          try
          {
            AdInfo localAdInfo = new cn/domob/wall/core/bean/AdInfo;
            localAdInfo.<init>(paramLong, localJSONArray.getJSONObject(j), paramString2, paramString1, this.e);
            paramJSONObject.add(localAdInfo);
            j++;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              a.a(localJSONException);
            }
          }
        }
      }
    }
    for (paramString1 = c(paramJSONObject);; paramString1 = paramJSONObject) {
      return paramString1;
    }
  }
  
  private List<AdInfo> a(Context paramContext, List<AdInfo> paramList)
  {
    List localList = cn.domob.wall.core.h.e.g(paramContext);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AdInfo localAdInfo = (AdInfo)localIterator.next();
      if (localList.contains(localAdInfo.getAdPackageName()))
      {
        Object localObject;
        try
        {
          localObject = paramContext.getPackageManager().getPackageInfo(localAdInfo.getAdPackageName(), 0);
          d locald = a;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          locald.b(localAdInfo.getAdPackageName() + "vc:" + localAdInfo.getAdVersionCode() + "vn:" + localAdInfo.getAdVersionName() + "vc:" + ((PackageInfo)localObject).versionCode + "vn:" + ((PackageInfo)localObject).versionName);
          if (localAdInfo.getAdVersionCode() <= ((PackageInfo)localObject).versionCode) {
            break label332;
          }
          locald = a;
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          locald.b(localAdInfo.getAdPackageName() + "vc:" + localAdInfo.getAdVersionCode() + "vn:" + localAdInfo.getAdVersionName() + "vc:" + ((PackageInfo)localObject).versionCode + "vn:" + ((PackageInfo)localObject).versionName);
          if ((localAdInfo.getAdActionType() == AdInfo.ClickActionType.LAUNCH) || (this.e == null)) {
            continue;
          }
          if (!this.e.isShowUpdate()) {
            break label299;
          }
          localAdInfo.setClickActionType(AdInfo.ClickActionType.UPDATE.ordinal());
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
        continue;
        label299:
        localIterator.remove();
        a.d(String.format("This application %s has been installed and ClickActionType is not launch and controlInfo showUpdate is flase, so removed, and is no longer displayed", new Object[] { localNameNotFoundException.getAdPackageName() }));
        continue;
        label332:
        if ((localNameNotFoundException.getAdActionType() != AdInfo.ClickActionType.LAUNCH) && (this.e != null)) {
          if (this.e.isShowOpen())
          {
            localObject = String.format("domob://launch/?pkg=%s&failsafe=%s", new Object[] { localNameNotFoundException.getAdPackageName(), localNameNotFoundException.getAdActionURL() });
            localNameNotFoundException.setClickActionType(AdInfo.ClickActionType.LAUNCH.ordinal());
            localNameNotFoundException.setAdActionURL((String)localObject);
          }
          else
          {
            localIterator.remove();
            a.d(String.format("This application %s has been installed and ClickActionType is not launch and controlInfo showOpen is flase, so removed, and is no longer displayed", new Object[] { localNameNotFoundException.getAdPackageName() }));
          }
        }
      }
    }
    return paramList;
  }
  
  private List<AdInfo> a(ControlInfo paramControlInfo, List<AdInfo> paramList1, List<AdInfo> paramList2)
  {
    paramControlInfo = paramControlInfo.getAdOrder();
    if (paramControlInfo.equals(ControlInfo.a.a)) {
      paramList2.addAll(paramList1);
    }
    for (;;)
    {
      return paramList2;
      if (paramControlInfo.equals(ControlInfo.a.b))
      {
        paramList1.addAll(paramList2);
        paramList2 = paramList1;
      }
      else if (paramControlInfo.equals(ControlInfo.a.c))
      {
        paramList2 = a(paramList1, paramList2);
      }
      else
      {
        paramList2 = null;
      }
    }
  }
  
  private List<AdExtend> a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("extend");
    paramJSONObject = new ArrayList();
    if (localJSONArray != null)
    {
      int j = 0;
      while (j < localJSONArray.length()) {
        try
        {
          AdExtend localAdExtend = new cn/domob/wall/core/bean/AdExtend;
          localAdExtend.<init>(localJSONArray.getJSONObject(j));
          if (localAdExtend != null) {
            paramJSONObject.add(localAdExtend);
          }
          j++;
        }
        catch (b localb)
        {
          for (;;)
          {
            a.a(localb);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            a.a(localJSONException);
          }
        }
      }
    }
    a.b("AdExtendList: " + paramJSONObject.toString());
    return paramJSONObject;
  }
  
  private List<AdInfo> b(List<AdInfo> paramList)
  {
    for (int j = 0; j < paramList.size() - 1; j++) {
      for (int k = j + 1; k < paramList.size(); k++) {
        if (((AdInfo)paramList.get(j)).getAdPosition() > ((AdInfo)paramList.get(k)).getAdPosition())
        {
          AdInfo localAdInfo = (AdInfo)paramList.get(j);
          paramList.set(j, (AdInfo)paramList.get(k));
          paramList.set(k, localAdInfo);
        }
      }
    }
    return paramList;
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = new org/json/JSONObject;
        localObject2 = new org/json/JSONTokener;
        ((JSONTokener)localObject2).<init>(paramString);
        ((JSONObject)localObject1).<init>((JSONTokener)localObject2);
        this.b = ((JSONObject)localObject1).optString("sid", "");
        this.c = ((JSONObject)localObject1).optString("cid", "");
        if ((this.c != null) && (!this.c.equals(""))) {
          h.a().a(paramContext, this.c);
        }
        paramString = new java/util/ArrayList;
        paramString.<init>();
        this.h = paramString;
        paramString = ((JSONObject)localObject1).optJSONObject("ad");
        localObject2 = ((JSONObject)localObject1).optJSONObject("error");
        localObject1 = ((JSONObject)localObject1).optJSONObject("control");
        if (localObject2 == null) {
          continue;
        }
        paramContext = new cn/domob/wall/core/bean/a;
        paramContext.<init>((JSONObject)localObject2);
        this.d = paramContext;
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        Object localObject2;
        long l;
        a.a(paramContext);
        boolean bool = false;
        continue;
        a.e("There is no ad response or error response.");
        continue;
      }
      bool = true;
      return bool;
      if (localObject1 != null)
      {
        localObject2 = new cn/domob/wall/core/bean/ControlInfo;
        ((ControlInfo)localObject2).<init>((JSONObject)localObject1);
        this.e = ((ControlInfo)localObject2);
      }
      if (paramString == null) {
        continue;
      }
      l = h.a().a(paramContext);
      localObject2 = a;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((d)localObject2).b("lasttime request：" + l);
      this.g = a(l, "wheel", paramString, this.b);
      this.i = a(paramString);
      localObject1 = a(paramContext, a(l, f.a(), paramString, this.b));
      paramString = a(paramContext, a(l, "own", paramString, this.b));
      this.f = a(this.e, (List)localObject1, paramString);
      this.e.setNumberOfNewAd(a(this.f));
      h.a().b(paramContext);
    }
  }
  
  private List<AdInfo> c(List<AdInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AdInfo localAdInfo = (AdInfo)localIterator.next();
      if (localAdInfo.isNew())
      {
        localArrayList.add(localAdInfo);
        localIterator.remove();
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public e a(Context paramContext, String paramString)
  {
    e locale = new e();
    if (locale.b(paramContext, paramString)) {
      a.a("Ad/Error response is ok.");
    }
    for (paramContext = locale;; paramContext = null) {
      return paramContext;
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public a b()
  {
    return this.d;
  }
  
  public ControlInfo c()
  {
    return this.e;
  }
  
  public List<AdInfo> d()
  {
    return this.f;
  }
  
  public List<AdInfo> e()
  {
    if (this.h != null)
    {
      Iterator localIterator = this.f.iterator();
      AdInfo localAdInfo;
      while (localIterator.hasNext())
      {
        localAdInfo = (AdInfo)localIterator.next();
        this.h.add(localAdInfo);
      }
      localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        localAdInfo = (AdInfo)localIterator.next();
        this.h.add(localAdInfo);
      }
    }
    return this.h;
  }
  
  public List<AdInfo> f()
  {
    return this.g;
  }
  
  public List<AdExtend> g()
  {
    return this.i;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */