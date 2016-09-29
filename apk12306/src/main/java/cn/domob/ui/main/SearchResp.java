package cn.domob.ui.main;

import cn.domob.wall.core.bean.AdInfo;
import java.util.List;

public class SearchResp
{
  private List<AdInfo> recommendAdInfos;
  private List<AdInfo> searchAdInfos;
  
  public SearchResp(List<AdInfo> paramList1, List<AdInfo> paramList2)
  {
    this.searchAdInfos = paramList1;
    this.recommendAdInfos = paramList2;
  }
  
  public List<AdInfo> getRecommendAdInfos()
  {
    return this.recommendAdInfos;
  }
  
  public List<AdInfo> getSearchAdInfos()
  {
    return this.searchAdInfos;
  }
  
  public void setRecommendAdInfos(List<AdInfo> paramList)
  {
    this.recommendAdInfos = paramList;
  }
  
  public void setSearchAdInfos(List<AdInfo> paramList)
  {
    this.searchAdInfos = paramList;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\main\SearchResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */