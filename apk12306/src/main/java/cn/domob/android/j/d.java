package cn.domob.android.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.domob.android.b.a;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class d
{
  private static final int A = 16;
  private static final int B = 16;
  private static final int C = 35;
  private static final int D = -1627389952;
  private static final int E = 5;
  private static final int F = 8;
  private static final int G = -3026479;
  private static final String H = "广告剩余";
  private static final String I = "秒";
  private static final int J = 35;
  private static final int K = 40;
  private static final int L = 6;
  private static f a = new f(d.class.getSimpleName());
  private static final String b = "domob_video_close_not_selected.png";
  private static final String c = "domob_video_muted_selected.png";
  private static final String d = "domob_video_muted_not_selected.png";
  private static final String e = "domob_video_not_mute_selected.png";
  private static final String f = "domob_video_not_mute_not_selected.png";
  private static final String g = "domob_video_full_not_selected.png";
  private static final String h = "domob_video_full_selected.png";
  private static final String i = "domob_video_not_full_not_selected.png";
  private static final String j = "domob_video_not_full_selected.png";
  private static final String k = "domob_video_goto_selected.png";
  private static final String l = "domob_video_goto_not_selected.png";
  private static final String m = "domob_video_download_selected.png";
  private static final String n = "domob_video_download_not_selected.png";
  private static final String o = "domob_video_custom_selected.png";
  private static final String p = "domob_video_custom_not_selected.png";
  private static final String q = "domob_video_replay_selected.png";
  private static final String r = "domob_video_replay_not_selected.png";
  private static final String s = "domob_video_logo.png";
  private static final int t = -1;
  private static ExecutorService u;
  private static final int v = 30;
  private static final int w = 30;
  private static final int x = 12;
  private static final int y = 30;
  private static final int z = 16;
  private Context M;
  private b N;
  private Handler O;
  private HashMap<String, BitmapDrawable> P = new HashMap();
  private ImageButton Q;
  private String R;
  private b S;
  private int T = 0;
  private RelativeLayout U;
  private RelativeLayout V;
  private TextView W;
  private int X;
  private int Y = 0;
  private boolean Z = false;
  private boolean aa = true;
  
  protected d(Context paramContext, b paramb, int paramInt, Handler paramHandler, b paramb1)
  {
    this.M = paramContext;
    this.N = paramb;
    this.S = paramb1;
    this.O = paramHandler;
    this.X = paramInt;
    if (u == null) {
      u = Executors.newFixedThreadPool(5);
    }
  }
  
  private BitmapDrawable a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = (byte[])localObject;
    }
    for (;;)
    {
      return paramArrayOfByte;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
        paramArrayOfByte = (byte[])localObject;
        if (localBitmap != null)
        {
          paramArrayOfByte = new android/graphics/drawable/BitmapDrawable;
          paramArrayOfByte.<init>(localBitmap);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        a.a(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  private Drawable a(Context paramContext, String paramString)
  {
    if (!h.e(paramString)) {}
    for (;;)
    {
      try
      {
        paramContext = new android/graphics/drawable/BitmapDrawable;
        ClassLoader localClassLoader = d.class.getClassLoader();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        paramContext.<init>(BitmapFactory.decodeStream(localClassLoader.getResourceAsStream("assets/" + paramString)));
        return paramContext;
      }
      catch (Exception paramContext)
      {
        a.a(paramContext);
      }
      paramContext = null;
    }
  }
  
  private RelativeLayout a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 0;
    Object localObject = this.N.g();
    int i6 = ((b.a.a)localObject).f();
    localObject = ((b.a.a)localObject).h();
    this.V = new RelativeLayout(this.M);
    b.a.a.a[] arrayOfa = a((ArrayList)localObject);
    int i5 = 0;
    int i2;
    for (int i1 = 0; i3 < arrayOfa.length; i1 = i2)
    {
      int i4;
      if (!paramBoolean2)
      {
        i4 = i5;
        i2 = i1;
        if (arrayOfa[i3].b().equals("replay")) {}
      }
      else
      {
        localObject = a(arrayOfa[i3], i5, i6);
        i4 = i5;
        i2 = i1;
        if (localObject != null)
        {
          i4 = i5 + 1;
          this.V.addView((View)localObject);
          i2 = 1;
        }
      }
      i3++;
      i5 = i4;
    }
    localObject = new RelativeLayout.LayoutParams(-2, f(30));
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.V.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!paramBoolean1)
    {
      this.V.setVisibility(4);
      this.O.postDelayed(new Runnable()
      {
        public void run()
        {
          d.h(d.this).setVisibility(0);
        }
      }, this.X);
    }
    if (i1 != 0) {}
    for (localObject = this.V;; localObject = null) {
      return (RelativeLayout)localObject;
    }
  }
  
  private a a(final b.a.a.a parama, int paramInt1, int paramInt2)
  {
    if (!h.e(parama.b()))
    {
      parama = new a(this.M, parama);
      RelativeLayout.LayoutParams localLayoutParams = a(this.M, 30, 30);
      localLayoutParams.leftMargin = (f(paramInt2 + 30) * paramInt1);
      localLayoutParams.addRule(15);
      parama.setLayoutParams(localLayoutParams);
      parama.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 0) {
            d.a(d.this, parama, true, true);
          }
          for (;;)
          {
            return false;
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              d.a(d.this, parama, false, true);
              if (d.a(d.this) != null) {
                d.a(d.this).a(d.a.a(parama));
              }
            }
          }
        }
      });
      a(parama, false, false);
    }
    for (;;)
    {
      return parama;
      parama = null;
    }
  }
  
  private void a(final ImageButton paramImageButton, final Drawable paramDrawable)
  {
    this.O.post(new Runnable()
    {
      public void run()
      {
        if ((paramImageButton != null) && (paramDrawable != null)) {
          paramImageButton.setBackgroundDrawable(paramDrawable);
        }
      }
    });
  }
  
  private void a(ImageButton paramImageButton, String paramString)
  {
    a(paramImageButton, a(this.M, paramString));
  }
  
  private void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView != null) && (paramRelativeLayout != null)) {
      paramRelativeLayout.addView(paramView);
    }
  }
  
  private void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a.a(parama);
    String str = ((b.a.a.a)localObject).b();
    localObject = ((b.a.a.a)localObject).e();
    if ((this.T != -1) && (localObject != null) && (localObject.length == 2) && (this.P.containsKey(localObject[0])) && (this.P.containsKey(localObject[1]))) {
      if (paramBoolean1)
      {
        localObject = localObject[1];
        a(parama, (Drawable)this.P.get(localObject));
      }
    }
    for (;;)
    {
      return;
      localObject = localObject[0];
      break;
      if (str != null)
      {
        localObject = null;
        if (str.equals("replay")) {
          if (paramBoolean1) {
            localObject = "domob_video_replay_selected.png";
          }
        }
        for (;;)
        {
          if (localObject == null) {
            break label243;
          }
          if (!paramBoolean2) {
            break label245;
          }
          a(parama, (String)localObject);
          break;
          localObject = "domob_video_replay_not_selected.png";
          continue;
          if (str.equals("download"))
          {
            if (paramBoolean1) {
              localObject = "domob_video_download_selected.png";
            } else {
              localObject = "domob_video_download_not_selected.png";
            }
          }
          else if (str.equals("goto"))
          {
            if (paramBoolean1) {
              localObject = "domob_video_goto_selected.png";
            } else {
              localObject = "domob_video_goto_not_selected.png";
            }
          }
          else if (str.equals("custom")) {
            if (paramBoolean1) {
              localObject = "domob_video_custom_selected.png";
            } else {
              localObject = "domob_video_custom_not_selected.png";
            }
          }
        }
        label243:
        continue;
        label245:
        b(parama, (String)localObject);
      }
    }
  }
  
  /* Error */
  private byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 400	java/io/ByteArrayOutputStream
    //   6: astore 4
    //   8: aload 4
    //   10: invokespecial 401	java/io/ByteArrayOutputStream:<init>	()V
    //   13: aload 4
    //   15: astore_3
    //   16: sipush 1024
    //   19: newarray <illegal type>
    //   21: astore 6
    //   23: aload 4
    //   25: astore_3
    //   26: aload_1
    //   27: aload 6
    //   29: invokevirtual 407	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_m1
    //   35: if_icmpeq +51 -> 86
    //   38: aload 4
    //   40: astore_3
    //   41: aload 4
    //   43: aload 6
    //   45: iconst_0
    //   46: iload_2
    //   47: invokevirtual 411	java/io/ByteArrayOutputStream:write	([BII)V
    //   50: goto -27 -> 23
    //   53: astore_3
    //   54: aload 4
    //   56: astore_1
    //   57: aload_3
    //   58: astore 4
    //   60: aload_1
    //   61: astore_3
    //   62: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   65: aload 4
    //   67: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   70: aload 5
    //   72: astore_3
    //   73: aload_1
    //   74: ifnull +10 -> 84
    //   77: aload_1
    //   78: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   81: aload 5
    //   83: astore_3
    //   84: aload_3
    //   85: areturn
    //   86: aload 4
    //   88: astore_3
    //   89: aload 4
    //   91: invokevirtual 418	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore_1
    //   95: aload_1
    //   96: astore_3
    //   97: aload 4
    //   99: ifnull -15 -> 84
    //   102: aload 4
    //   104: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   107: aload_1
    //   108: astore_3
    //   109: goto -25 -> 84
    //   112: astore_3
    //   113: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   116: aload_3
    //   117: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   120: aload_1
    //   121: astore_3
    //   122: goto -38 -> 84
    //   125: astore_1
    //   126: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   129: aload_1
    //   130: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   133: aload 5
    //   135: astore_3
    //   136: goto -52 -> 84
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 414	java/io/ByteArrayOutputStream:close	()V
    //   150: aload_1
    //   151: athrow
    //   152: astore_3
    //   153: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   156: aload_3
    //   157: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   160: goto -10 -> 150
    //   163: astore_1
    //   164: goto -22 -> 142
    //   167: astore 4
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -111 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	d
    //   0	174	1	paramInputStream	java.io.InputStream
    //   32	15	2	i1	int
    //   15	26	3	localObject1	Object
    //   53	5	3	localException1	Exception
    //   61	48	3	localObject2	Object
    //   112	5	3	localIOException1	java.io.IOException
    //   121	26	3	localObject3	Object
    //   152	5	3	localIOException2	java.io.IOException
    //   6	97	4	localObject4	Object
    //   167	1	4	localException2	Exception
    //   1	133	5	localObject5	Object
    //   21	23	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	23	53	java/lang/Exception
    //   26	33	53	java/lang/Exception
    //   41	50	53	java/lang/Exception
    //   89	95	53	java/lang/Exception
    //   102	107	112	java/io/IOException
    //   77	81	125	java/io/IOException
    //   3	13	139	finally
    //   146	150	152	java/io/IOException
    //   16	23	163	finally
    //   26	33	163	finally
    //   41	50	163	finally
    //   62	70	163	finally
    //   89	95	163	finally
    //   3	13	167	java/lang/Exception
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 420	java/net/URL
    //   5: astore_3
    //   6: aload_3
    //   7: aload_1
    //   8: invokespecial 421	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: aload_3
    //   12: invokevirtual 425	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   15: checkcast 427	java/net/HttpURLConnection
    //   18: astore_3
    //   19: aload_3
    //   20: ldc_w 429
    //   23: invokevirtual 432	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   26: aload_3
    //   27: sipush 5000
    //   30: invokevirtual 435	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   33: aload_3
    //   34: invokevirtual 439	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   37: astore_1
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 441	cn/domob/android/j/d:a	(Ljava/io/InputStream;)[B
    //   43: astore_2
    //   44: aload_3
    //   45: invokevirtual 444	java/net/HttpURLConnection:disconnect	()V
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 445	java/io/InputStream:close	()V
    //   56: aload_2
    //   57: astore_1
    //   58: aload_1
    //   59: areturn
    //   60: astore_1
    //   61: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   64: aload_1
    //   65: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   68: goto -12 -> 56
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   77: aload_2
    //   78: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 445	java/io/InputStream:close	()V
    //   89: aconst_null
    //   90: astore_1
    //   91: goto -33 -> 58
    //   94: astore_1
    //   95: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   98: aload_1
    //   99: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   102: goto -13 -> 89
    //   105: astore_1
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 445	java/io/InputStream:close	()V
    //   114: aload_1
    //   115: athrow
    //   116: astore_2
    //   117: getstatic 164	cn/domob/android/j/d:a	Lcn/domob/android/i/f;
    //   120: aload_2
    //   121: invokevirtual 220	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   124: goto -10 -> 114
    //   127: astore_3
    //   128: aload_1
    //   129: astore_2
    //   130: aload_3
    //   131: astore_1
    //   132: goto -26 -> 106
    //   135: astore_3
    //   136: aload_1
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: goto -34 -> 106
    //   143: astore_2
    //   144: goto -70 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	d
    //   0	147	1	paramString	String
    //   1	56	2	arrayOfByte	byte[]
    //   71	40	2	localException1	Exception
    //   116	5	2	localIOException	java.io.IOException
    //   129	9	2	str	String
    //   143	1	2	localException2	Exception
    //   5	40	3	localObject1	Object
    //   127	4	3	localObject2	Object
    //   135	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	60	java/io/IOException
    //   2	38	71	java/lang/Exception
    //   85	89	94	java/io/IOException
    //   2	38	105	finally
    //   110	114	116	java/io/IOException
    //   38	48	127	finally
    //   74	81	135	finally
    //   38	48	143	java/lang/Exception
  }
  
  private b.a.a.a[] a(ArrayList<b.a.a.a> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    b.a.a.a[] arrayOfa = new b.a.a.a[paramArrayList.size()];
    int i1 = 0;
    if (i1 < paramArrayList.size())
    {
      b.a.a.a locala = (b.a.a.a)paramArrayList.get(i1);
      int i2 = locala.c();
      if ((i2 >= 0) && (i2 < arrayOfa.length) && (arrayOfa[i2] == null)) {
        arrayOfa[i2] = locala;
      }
      for (;;)
      {
        i1++;
        break;
        localArrayList.add(locala);
      }
    }
    for (i1 = 0; i1 < arrayOfa.length; i1++) {
      if ((arrayOfa[i1] == null) && (localArrayList.size() > 0)) {
        arrayOfa[i1] = ((b.a.a.a)localArrayList.remove(0));
      }
    }
    return arrayOfa;
  }
  
  private void b(ImageButton paramImageButton, String paramString)
  {
    if ((paramImageButton != null) && (!h.e(paramString))) {
      paramImageButton.setBackgroundDrawable(a(this.M, paramString));
    }
  }
  
  private RelativeLayout d(int paramInt)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.M);
    localRelativeLayout.setBackgroundColor(-1627389952);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, f(paramInt)));
    localRelativeLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    return localRelativeLayout;
  }
  
  private void e(int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)this.M.getSystemService("audio");
    int i1;
    if (localAudioManager != null)
    {
      i1 = m();
      if (i1 <= 0) {
        break label40;
      }
    }
    for (;;)
    {
      this.Y = i1;
      localAudioManager.setStreamVolume(3, paramInt, 0);
      return;
      label40:
      i1 = this.Y;
    }
  }
  
  private int f(int paramInt)
  {
    return (int)(a.t(this.M) * paramInt);
  }
  
  private ImageButton i()
  {
    if (!this.Z) {
      n();
    }
    final ImageButton localImageButton;
    if (this.N.g().d())
    {
      localImageButton = new ImageButton(this.M);
      if (k())
      {
        b(localImageButton, "domob_video_muted_not_selected.png");
        RelativeLayout.LayoutParams localLayoutParams = a(this.M, 30, 30);
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(15);
        localLayoutParams.leftMargin = f(12);
        localImageButton.setLayoutParams(localLayoutParams);
        localImageButton.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              if (d.c(d.this)) {
                d.a(d.this, localImageButton, "domob_video_muted_selected.png");
              }
            }
            for (;;)
            {
              return false;
              d.a(d.this, localImageButton, "domob_video_not_mute_selected.png");
              continue;
              if (paramAnonymousMotionEvent.getAction() == 1)
              {
                d.d(d.this);
                if (d.c(d.this)) {
                  d.a(d.this, localImageButton, "domob_video_muted_not_selected.png");
                } else {
                  d.a(d.this, localImageButton, "domob_video_not_mute_not_selected.png");
                }
              }
            }
          }
        });
      }
    }
    for (;;)
    {
      return localImageButton;
      b(localImageButton, "domob_video_not_mute_not_selected.png");
      break;
      localImageButton = null;
    }
  }
  
  private ImageButton j()
  {
    if (this.N.g().b())
    {
      this.Q = new ImageButton(this.M);
      b(this.N.g().c());
      localObject = a(this.M, 30, 30);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = f(12);
      this.Q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Q.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (d.e(d.this))
          {
            if (paramAnonymousMotionEvent.getAction() != 0) {
              break label79;
            }
            if (d.f(d.this) != null)
            {
              if (!d.f(d.this).equals("domob_video_not_full_not_selected.png")) {
                break label60;
              }
              d.a(d.this, d.g(d.this), "domob_video_not_full_selected.png");
            }
          }
          for (;;)
          {
            return false;
            label60:
            d.a(d.this, d.g(d.this), "domob_video_full_selected.png");
            continue;
            label79:
            if ((paramAnonymousMotionEvent.getAction() == 1) && (d.a(d.this) != null)) {
              d.a(d.this).i();
            }
          }
        }
      });
    }
    for (Object localObject = this.Q;; localObject = null) {
      return (ImageButton)localObject;
    }
  }
  
  private boolean k()
  {
    if (m() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void l()
  {
    int i1;
    if (k()) {
      if (this.Y > 0)
      {
        i1 = this.Y;
        e(i1);
      }
    }
    for (;;)
    {
      return;
      i1 = 6;
      break;
      e(0);
    }
  }
  
  private int m()
  {
    AudioManager localAudioManager = (AudioManager)this.M.getSystemService("audio");
    if (localAudioManager != null) {}
    for (int i1 = localAudioManager.getStreamVolume(3);; i1 = 0) {
      return i1;
    }
  }
  
  private void n()
  {
    int i1 = this.N.g().e();
    if (i1 == 1) {
      e(0);
    }
    for (;;)
    {
      this.Z = true;
      return;
      if ((i1 == 2) && (k())) {
        e(6);
      }
    }
  }
  
  private ArrayList<String> o()
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = this.N.g().h();
    for (int i1 = 0; i1 < localArrayList1.size(); i1++)
    {
      String[] arrayOfString = ((b.a.a.a)localArrayList1.get(i1)).e();
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        for (int i2 = 0; i2 < arrayOfString.length; i2++) {
          if (!h.e(arrayOfString[i2])) {
            localArrayList2.add(arrayOfString[i2]);
          }
        }
      }
    }
    return localArrayList2;
  }
  
  protected ImageButton a(boolean paramBoolean)
  {
    int i1 = 0;
    final ImageButton localImageButton;
    if (this.N.e().h())
    {
      localImageButton = new ImageButton(this.M);
      b(localImageButton, "domob_video_close_not_selected.png");
      localImageButton.setVisibility(4);
      RelativeLayout.LayoutParams localLayoutParams = a(this.M, 16, 16);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = f(-this.N.e().i()[0]);
      localImageButton.setLayoutParams(localLayoutParams);
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          d.a(d.this, localImageButton, "domob_video_close_not_selected.png");
          if (d.a(d.this) != null) {
            d.a(d.this).h();
          }
        }
      });
      if (paramBoolean) {
        i1 = this.X;
      }
      this.O.postDelayed(new Runnable()
      {
        public void run()
        {
          localImageButton.setVisibility(0);
        }
      }, i1);
    }
    for (;;)
    {
      return localImageButton;
      localImageButton = null;
    }
  }
  
  protected RelativeLayout.LayoutParams a(Context paramContext, int paramInt1, int paramInt2)
  {
    return b(paramContext, f(paramInt1), f(paramInt2));
  }
  
  protected TextView a()
  {
    TextView localTextView;
    if (this.N.e().c())
    {
      localTextView = new TextView(this.M);
      localTextView.setTextSize(8.0F);
      localTextView.setTextColor(-3026479);
      b.a locala = this.N.e();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(9);
      localTextView.setText(locala.e());
      localLayoutParams.leftMargin = f(locala.d()[0] + 35);
      localTextView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return localTextView;
      localTextView = null;
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.W != null)
    {
      if (paramInt > 0) {
        break label38;
      }
      if (this.W.getVisibility() == 0) {
        this.O.post(new Runnable()
        {
          public void run()
          {
            d.b(d.this).setVisibility(8);
          }
        });
      }
    }
    for (;;)
    {
      return;
      label38:
      if (paramInt > 0)
      {
        String str = "广告剩余" + paramInt + "秒";
        final SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
        int i1 = str.length();
        int i2 = "广告剩余秒".length();
        paramInt = "广告剩余".length();
        int i3 = "广告剩余".length();
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), paramInt, i1 - i2 + i3, 34);
        this.O.post(new Runnable()
        {
          public void run()
          {
            d.b(d.this).setText(localSpannableStringBuilder);
            if (d.b(d.this).getVisibility() != 0) {
              d.b(d.this).setVisibility(0);
            }
          }
        });
      }
    }
  }
  
  protected ImageView b()
  {
    ImageView localImageView;
    if (this.N.e().f())
    {
      localImageView = new ImageView(this.M);
      localImageView.setBackgroundDrawable(a(this.M, "domob_video_logo.png"));
      RelativeLayout.LayoutParams localLayoutParams = a(this.M, 35, 16);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = f(this.N.e().g()[0]);
      localImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return localImageView;
      localImageView = null;
    }
  }
  
  protected RelativeLayout.LayoutParams b(Context paramContext, int paramInt1, int paramInt2)
  {
    return new RelativeLayout.LayoutParams(paramInt1, paramInt2);
  }
  
  protected TextView b(int paramInt)
  {
    if (this.N.e().a())
    {
      this.W = new TextView(this.M);
      this.W.setTextSize(8.0F);
      b.a locala = this.N.e();
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = f(40 - locala.b()[0]);
      this.W.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (Object localObject = this.W;; localObject = null) {
      return (TextView)localObject;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.Q != null) {
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (this.R = "domob_video_full_not_selected.png";; this.R = "domob_video_not_full_not_selected.png")
    {
      a(this.Q, this.R);
      return;
    }
  }
  
  protected RelativeLayout c(int paramInt)
  {
    RelativeLayout localRelativeLayout = d(16);
    ((RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams()).addRule(10);
    a(localRelativeLayout, b());
    a(localRelativeLayout, a());
    a(localRelativeLayout, b(paramInt));
    a(localRelativeLayout, a(true));
    return localRelativeLayout;
  }
  
  protected void c()
  {
    b.a.a locala = this.N.e().j();
    if ((this.U != null) && (locala.a() != 2)) {
      if (this.U.getVisibility() != 0) {
        break label48;
      }
    }
    label48:
    for (int i1 = 8;; i1 = 0)
    {
      this.U.setVisibility(i1);
      return;
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    this.aa = paramBoolean;
  }
  
  protected void d()
  {
    if (this.U != null) {
      this.U.setVisibility(0);
    }
  }
  
  protected RelativeLayout e()
  {
    this.U = d(30);
    ((RelativeLayout.LayoutParams)this.U.getLayoutParams()).addRule(12);
    a(this.U, i());
    a(this.U, j());
    a(this.U, a(this.N.g().g(), false));
    if (this.N.e().j().a() == 0) {
      this.U.setVisibility(8);
    }
    return this.U;
  }
  
  protected void f()
  {
    if ((this.U != null) && (this.V != null)) {
      this.O.post(new Runnable()
      {
        public void run()
        {
          d.i(d.this).removeView(d.h(d.this));
          d.a(d.this, d.i(d.this), d.a(d.this, true, true));
        }
      });
    }
  }
  
  protected void g()
  {
    ArrayList localArrayList = o();
    final int i2 = localArrayList.size();
    if ((i2 == 0) && (this.S != null)) {
      this.S.k();
    }
    for (;;)
    {
      return;
      for (int i1 = 0; i1 < localArrayList.size(); i1++)
      {
        final String str = (String)localArrayList.get(i1);
        u.execute(new Thread(new Runnable()
        {
          public void run()
          {
            for (;;)
            {
              try
              {
                localObject1 = d.a(d.this, d.a(d.this, str));
                if (localObject1 != null)
                {
                  d.j(d.this).put(str, localObject1);
                  localObject2 = d.h();
                  localObject1 = new java/lang/StringBuilder;
                  ((StringBuilder)localObject1).<init>();
                  ((f)localObject2).b("button img download successfully, download url: " + str);
                  if (d.k(d.this) != -1)
                  {
                    d.l(d.this);
                    if ((d.k(d.this) == i2) && (d.a(d.this) != null)) {
                      d.a(d.this).j();
                    }
                  }
                  return;
                }
              }
              catch (Exception localException)
              {
                Object localObject1;
                Object localObject2;
                d.h().a(localException);
                continue;
              }
              localObject1 = d.h();
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              ((f)localObject1).d("button img download failed, download url: " + str);
              if ((d.a(d.this) != null) && (d.k(d.this) != -1)) {
                d.a(d.this).j();
              }
              d.a(d.this, -1);
            }
          }
        }));
      }
    }
  }
  
  private class a
    extends ImageButton
  {
    b.a.a.a a;
    
    public a(Context paramContext, b.a.a.a parama)
    {
      super();
      this.a = parama;
    }
    
    private b.a.a.a a()
    {
      return this.a;
    }
  }
  
  protected static abstract interface b
  {
    public abstract void a(b.a.a.a parama);
    
    public abstract void h();
    
    public abstract void i();
    
    public abstract void j();
    
    public abstract void k();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */