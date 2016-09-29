package cn.domob.ui.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.dm.download.DownLoadManager;
import cn.dm.download.bean.DownloadAppInfo;
import cn.domob.ui.adapter.SearchResultListAdapter;
import cn.domob.ui.item.AppListItem;
import cn.domob.ui.item.AppListItem.AppItemStatusChangeListener;
import cn.domob.ui.item.SearchListItem;
import cn.domob.ui.item.SearchListItem.SearchItemStatusChangeListener;
import cn.domob.ui.main.Constants.DownloadStatus;
import cn.domob.ui.main.Logger;
import cn.domob.ui.utility.DDrawable;
import cn.domob.ui.utility.DId;
import cn.domob.ui.utility.DLayout;
import cn.domob.ui.utility.DRes;
import cn.domob.wall.core.DService;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.DService.ReceiveDetailsDataListener;
import cn.domob.wall.core.DService.ReceiveHotSearchDataListener;
import cn.domob.wall.core.DService.ReceiveSearchDataListener;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.ControlInfo;
import java.util.ArrayList;
import java.util.List;

public class SearchView
  implements AppListItem.AppItemStatusChangeListener, SearchListItem.SearchItemStatusChangeListener
{
  protected static final int DETAILPAGETYPE = 1;
  protected static final int REFRESH_LIST = 0;
  private static final int SHOW_HOT_SEARCH = 2;
  private static final int SHOW_NET_ERROR = 5;
  protected static final int SHOW_NO_RECOMMAND_RESULT = 6;
  private static final int SHOW_NO_SEARCH_RESULT = 4;
  private static final int SHOW_PROGRESS = 1;
  private static final int SHOW_SEARCH_RESULT = 3;
  private static Logger mLogger = new Logger(SearchView.class.getSimpleName());
  private DownLoadManager dlm;
  private List<String> hotString;
  private List<SearchListItem> listItems;
  private String listenerName = "SearchItem";
  private Context mContext;
  private ControlInfo mControlInfo;
  private DService mDService;
  private ClearEditText mEtSearch;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        SearchView.this.changeSurface(1);
        continue;
        SearchView.this.changeSurface(2);
        continue;
        SearchView.this.changeSurface(3);
        continue;
        SearchView.this.changeSurface(4);
        continue;
        SearchView.this.changeSurface(5);
        continue;
        SearchView.this.changeSurface(6);
        continue;
        SearchView.this.resultListAdapter.notifyDataSetChanged();
      }
    }
  };
  private RelativeLayout mIvBack;
  private String mKeyWord;
  private LinearLayout mLLResult;
  private LinearLayout mLlHotSearch;
  private ListView mLvResult;
  private ListView mLvSearch;
  private LinearLayout mNoSearchResult;
  private TextView mNoSearchResultInfo;
  private RelativeLayout mRlNetError;
  private RelativeLayout mRlProgress;
  private Dialog mSearchDialog;
  private TextView mTvRecommend;
  private ProgressDialog pb;
  private SearchResultListAdapter resultListAdapter;
  Handler showHotStringHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      SearchView.this.mLvSearch.setAdapter(new SearchView.a(SearchView.this, SearchView.this.hotString));
    }
  };
  EditextChangeZeroListener textChangeZeroListener = new EditextChangeZeroListener()
  {
    public void textChange()
    {
      SearchView.this.changeSurface(2);
    }
  };
  
  public SearchView(Context paramContext, DService paramDService, Dialog paramDialog, ControlInfo paramControlInfo, DownLoadManager paramDownLoadManager)
  {
    this.mContext = paramContext;
    this.mDService = paramDService;
    this.mSearchDialog = paramDialog;
    this.listItems = new ArrayList();
    this.dlm = paramDownLoadManager;
    this.mControlInfo = paramControlInfo;
  }
  
  private void changeSurface(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      this.mRlProgress.setVisibility(0);
      this.mRlNetError.setVisibility(8);
      this.mLlHotSearch.setVisibility(8);
      this.mNoSearchResult.setVisibility(8);
      this.mLvResult.setVisibility(8);
      continue;
      this.mRlProgress.setVisibility(8);
      this.mRlNetError.setVisibility(8);
      this.mLlHotSearch.setVisibility(0);
      this.mNoSearchResult.setVisibility(8);
      this.mLvResult.setVisibility(8);
      continue;
      this.mRlProgress.setVisibility(8);
      this.mRlNetError.setVisibility(8);
      this.mLlHotSearch.setVisibility(8);
      this.mNoSearchResult.setVisibility(8);
      this.mLLResult.setVisibility(0);
      this.mLvResult.setVisibility(0);
      continue;
      this.mRlProgress.setVisibility(8);
      this.mRlNetError.setVisibility(8);
      this.mLlHotSearch.setVisibility(8);
      this.mLLResult.setVisibility(0);
      this.mNoSearchResult.setVisibility(0);
      this.mNoSearchResultInfo.setText("呃，没有找到和" + this.mKeyWord + "相关的应用");
      this.mLvResult.setVisibility(0);
      this.mTvRecommend.setVisibility(0);
      continue;
      this.mRlProgress.setVisibility(8);
      this.mRlNetError.setVisibility(8);
      this.mLlHotSearch.setVisibility(8);
      this.mLLResult.setVisibility(0);
      this.mNoSearchResult.setVisibility(0);
      this.mNoSearchResultInfo.setText("呃，没有找到和" + this.mKeyWord + "相关的应用");
      this.mTvRecommend.setVisibility(8);
      this.mLvResult.setVisibility(8);
      continue;
      this.mRlProgress.setVisibility(8);
      this.mRlNetError.setVisibility(0);
      this.mLlHotSearch.setVisibility(8);
      this.mNoSearchResult.setVisibility(8);
      this.mLvResult.setVisibility(8);
    }
  }
  
  private int checkNetStatus(Context paramContext)
  {
    int i = 0;
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        if (paramContext.getActiveNetworkInfo() == null) {
          return i;
        }
        int j = paramContext.getActiveNetworkInfo().getType();
        if (1 == j)
        {
          i = 1;
          continue;
        }
        if (j == 0)
        {
          i = 2;
          continue;
        }
      }
      catch (Exception paramContext)
      {
        continue;
      }
      i = 0;
    }
  }
  
  private void executeSearch()
  {
    this.mKeyWord = this.mEtSearch.getText().toString().trim();
    this.mDService.setReceiveSearchDataListener(new DService.ReceiveSearchDataListener()
    {
      public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
      {
        SearchView.this.mHandler.sendEmptyMessage(5);
      }
      
      public void onSuccessReceiveData(List<AdInfo> paramAnonymousList1, List<AdInfo> paramAnonymousList2)
      {
        
        if (SearchView.this.listItems != null) {
          SearchView.this.listItems.clear();
        }
        int i;
        if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() != 0))
        {
          for (i = 0; i < paramAnonymousList1.size(); i++)
          {
            paramAnonymousList2 = (AdInfo)paramAnonymousList1.get(i);
            paramAnonymousList2 = new SearchListItem(SearchView.this.mContext, SearchView.this, paramAnonymousList2, SearchView.this.mDService, SearchView.this.dlm, SearchView.this.mControlInfo);
            SearchView.this.listItems.add(paramAnonymousList2);
          }
          if (SearchView.this.resultListAdapter == null)
          {
            SearchView.access$102(SearchView.this, new SearchResultListAdapter(SearchView.this.mContext, SearchView.this.mDService, SearchView.this.listItems));
            SearchView.this.mLvResult.setAdapter(SearchView.this.resultListAdapter);
          }
          SearchView.this.mHandler.sendEmptyMessage(3);
        }
        for (;;)
        {
          Looper.loop();
          return;
          if ((paramAnonymousList2 != null) && (paramAnonymousList2.size() != 0))
          {
            for (i = 0; i < paramAnonymousList2.size(); i++)
            {
              paramAnonymousList1 = (AdInfo)paramAnonymousList2.get(i);
              paramAnonymousList1 = new SearchListItem(SearchView.this.mContext, SearchView.this, paramAnonymousList1, SearchView.this.mDService, SearchView.this.dlm, SearchView.this.mControlInfo);
              SearchView.this.listItems.add(paramAnonymousList1);
            }
            if (SearchView.this.resultListAdapter == null)
            {
              SearchView.access$102(SearchView.this, new SearchResultListAdapter(SearchView.this.mContext, SearchView.this.mDService, SearchView.this.listItems));
              SearchView.this.mLvResult.setAdapter(SearchView.this.resultListAdapter);
            }
            SearchView.this.mHandler.sendEmptyMessage(4);
          }
          else
          {
            SearchView.this.mHandler.sendEmptyMessage(6);
          }
        }
      }
    });
    if (!"".equals(this.mKeyWord))
    {
      hideSoftInput();
      changeSurface(1);
      this.listItems.clear();
      this.mDService.requestSearchDataAsyn(this.mKeyWord);
    }
    for (;;)
    {
      return;
      Toast.makeText(this.mContext, "输入的关键字不能为空！", 0).show();
    }
  }
  
  private void hideSoftInput()
  {
    ((InputMethodManager)this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(this.mEtSearch.getWindowToken(), 0);
  }
  
  private void initData()
  {
    this.mDService.setReceiveHotSearchDataListener(new DService.ReceiveHotSearchDataListener()
    {
      public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
      {
        SearchView.this.mHandler.sendEmptyMessage(5);
      }
      
      public void onSuccessReceiveData(List<String> paramAnonymousList)
      {
        SearchView.access$802(SearchView.this, paramAnonymousList);
        SearchView.this.showHotStringHandler.sendEmptyMessage(0);
        SearchView.this.mHandler.sendEmptyMessage(2);
      }
    });
    this.mDService.requestHotSearchDataAsyn();
    this.mHandler.sendEmptyMessage(1);
  }
  
  public View getSearchView()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.mContext).inflate(DLayout.getLayoutInt(this.mContext, "l_search_main"), null);
    this.mEtSearch = ((ClearEditText)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "et_search")));
    Drawable localDrawable = this.mContext.getResources().getDrawable(DDrawable.getDrawableInt(this.mContext, "u_search_icon_left"));
    localDrawable.setBounds(-7, 3, localDrawable.getMinimumWidth() - 7, localDrawable.getMinimumHeight() + 3);
    this.mEtSearch.setCompoundDrawables(localDrawable, null, null, null);
    this.mEtSearch.setOnEditextChangeZeroListener(this.textChangeZeroListener);
    this.mLlHotSearch = ((LinearLayout)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "ll_hotsearch_list")));
    this.mLvSearch = ((ListView)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "lv_hotsearch_list")));
    this.mTvRecommend = ((TextView)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "tv_recomend")));
    this.mRlProgress = ((RelativeLayout)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "rl_progress")));
    this.mRlNetError = ((RelativeLayout)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "rl_net_error")));
    this.mRlNetError.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (SearchView.this.checkNetStatus(SearchView.this.mContext) == 0) {
          Toast.makeText(SearchView.this.mContext, "网络异常，请检查网络设置！", 0).show();
        }
        for (;;)
        {
          return;
          SearchView.this.executeSearch();
        }
      }
    });
    this.mLLResult = ((LinearLayout)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "ll_search_result")));
    this.mLvResult = ((ListView)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "lv_search_result_list")));
    this.mLvResult.setOnItemClickListener(new b(null));
    this.mNoSearchResult = ((LinearLayout)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "ll_nosearch_result")));
    this.mNoSearchResultInfo = ((TextView)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "tv_noresult_info")));
    this.mIvBack = ((RelativeLayout)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "rl_back")));
    this.mIvBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SearchView.this.mSearchDialog.dismiss();
      }
    });
    ((Button)localRelativeLayout.findViewById(DId.getIdInt(this.mContext, "btn_search"))).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SearchView.this.executeSearch();
      }
    });
    this.mLvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        SearchView.this.hideSoftInput();
        SearchView.this.mEtSearch.setText((CharSequence)SearchView.this.hotString.get(paramAnonymousInt));
        SearchView.this.changeSurface(1);
        SearchView.this.executeSearch();
      }
    });
    initData();
    return localRelativeLayout;
  }
  
  public void onAppItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus)
  {
    mLogger.debugLog("onAppItemDownloadStatusChanged, do nothing");
  }
  
  public void onSearchItemDownloadStatusChanged(Constants.DownloadStatus paramDownloadStatus)
  {
    paramDownloadStatus = new Message();
    paramDownloadStatus.obj = Boolean.valueOf(true);
    paramDownloadStatus.what = 0;
    this.mHandler.sendMessage(paramDownloadStatus);
  }
  
  public static abstract interface EditextChangeZeroListener
  {
    public abstract void textChange();
  }
  
  private class a
    extends BaseAdapter
  {
    private List<String> b;
    
    public a()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(SearchView.this.mContext).inflate(DLayout.getLayoutInt(SearchView.this.mContext, "l_hotsearch_item"), null);
      paramViewGroup = (TextView)localLinearLayout.findViewById(DId.getIdInt(SearchView.this.mContext, "tv_arrow_position"));
      paramView = (TextView)localLinearLayout.findViewById(DId.getIdInt(SearchView.this.mContext, "tv_hotsearch_item_name"));
      paramViewGroup.setText(paramInt + 1 + "");
      if (paramInt > 2) {
        paramViewGroup.setBackgroundResource(DRes.initGetRes(SearchView.this.mContext).getDrawable("u_arrow_gray"));
      }
      paramView.setText((CharSequence)this.b.get(paramInt));
      return localLinearLayout;
    }
  }
  
  private class b
    implements AdapterView.OnItemClickListener
  {
    private b() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = (SearchListItem)SearchView.this.resultListAdapter.getItem(paramInt);
      paramView = paramAdapterView.getDownloadAppInfo();
      paramAdapterView.getmAdInfo().setAdActualPosition(paramInt);
      SearchView.this.mDService.doClickWallItemReport(paramAdapterView.getmAdInfo());
      SearchView.access$1102(SearchView.this, new ProgressDialog(SearchView.this.mContext));
      SearchView.this.pb.setMessage("数据加载中...");
      SearchView.this.pb.show();
      SearchView.this.mDService.setReceiveDetailsDataListener(new DService.ReceiveDetailsDataListener()
      {
        private Dialog b;
        
        public void onFailReceiveData(DService.ErrorCode paramAnonymousErrorCode, String paramAnonymousString)
        {
          SearchView.this.pb.dismiss();
          SearchView.mLogger.debugLog("onFailReceiveData-->", "errorContent" + paramAnonymousString);
          Looper.prepare();
          Toast.makeText(SearchView.this.mContext, "网络不是太给力哦...", 0).show();
          Looper.loop();
        }
        
        public void onSuccessReceiveData(List<AdInfo> paramAnonymousList)
        {
          SearchView.this.pb.dismiss();
          Looper.prepare();
          if ((paramAnonymousList.size() > 0) && (paramAnonymousList != null))
          {
            paramAnonymousList = (AdInfo)paramAnonymousList.get(0);
            paramAnonymousList = new AppListItem(SearchView.this.mContext, SearchView.this, paramAnonymousList, SearchView.this.mDService, SearchView.this.dlm, SearchView.this.mControlInfo, SearchView.this.listenerName);
            this.b = new Dialog(SearchView.this.mContext);
            paramAnonymousList = paramAnonymousList.bindDetailsView(this.b);
            this.b.requestWindowFeature(1);
            this.b.setContentView(paramAnonymousList);
            this.b.show();
          }
          Looper.loop();
        }
      });
      paramAdapterView = Long.toString(paramView.getAppId());
      SearchView.this.mDService.requestDetailsDataAsyn(paramAdapterView);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\ui\view\SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */