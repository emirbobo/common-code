package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    if ((paramUri == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to loadBitmap");
    }
    localUri = null;
    try
    {
      paramUri = this.mContext.getContentResolver().openInputStream(paramUri);
      localUri = paramUri;
      paramOptions = BitmapFactory.decodeStream(paramUri, null, paramOptions);
      if (paramUri != null) {}
      try
      {
        paramUri.close();
        return paramOptions;
      }
      catch (IOException paramUri)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramUri);
        }
      }
      try
      {
        localUri.close();
        throw paramUri;
      }
      catch (IOException paramOptions)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramOptions);
        }
      }
    }
    finally
    {
      if (localUri == null) {}
    }
  }
  
  private Bitmap loadConstrainedBitmap(Uri paramUri, int paramInt)
    throws FileNotFoundException
  {
    Object localObject2 = null;
    if ((paramInt <= 0) || (paramUri == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    loadBitmap(paramUri, (BitmapFactory.Options)localObject1);
    int k = ((BitmapFactory.Options)localObject1).outWidth;
    int m = ((BitmapFactory.Options)localObject1).outHeight;
    localObject1 = localObject2;
    if (k > 0)
    {
      if (m > 0) {
        break label86;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (Bitmap)localObject1;
      label86:
      int j = Math.max(k, m);
      int i = 1;
      while (j > paramInt)
      {
        j >>>= 1;
        i <<= 1;
      }
      localObject1 = localObject2;
      if (i > 0)
      {
        localObject1 = localObject2;
        if (Math.min(k, m) / i > 0)
        {
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inMutable = true;
          ((BitmapFactory.Options)localObject1).inSampleSize = i;
          localObject1 = loadBitmap(paramUri, (BitmapFactory.Options)localObject1);
        }
      }
    }
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(final String paramString, final Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    for (;;)
    {
      return;
      final int i = this.mScaleMode;
      PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
      Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
      if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
        localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
      }
      localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintDocumentAdapter()
      {
        private PrintAttributes mAttributes;
        
        public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
        {
          boolean bool = true;
          this.mAttributes = paramAnonymousPrintAttributes2;
          paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
          if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
          for (;;)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
            return;
            bool = false;
          }
        }
        
        /* Error */
        public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
        {
          // Byte code:
          //   0: new 71	android/print/pdf/PrintedPdfDocument
          //   3: dup
          //   4: aload_0
          //   5: getfield 23	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
          //   8: getfield 75	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
          //   11: aload_0
          //   12: getfield 37	android/support/v4/print/PrintHelperKitkat$1:mAttributes	Landroid/print/PrintAttributes;
          //   15: invokespecial 78	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
          //   18: astore_1
          //   19: aload_1
          //   20: iconst_1
          //   21: invokevirtual 82	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
          //   24: astore_3
          //   25: new 84	android/graphics/RectF
          //   28: astore 7
          //   30: aload 7
          //   32: aload_3
          //   33: invokevirtual 90	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
          //   36: invokevirtual 96	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
          //   39: invokespecial 99	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
          //   42: new 101	android/graphics/Matrix
          //   45: astore 6
          //   47: aload 6
          //   49: invokespecial 102	android/graphics/Matrix:<init>	()V
          //   52: aload 7
          //   54: invokevirtual 106	android/graphics/RectF:width	()F
          //   57: aload_0
          //   58: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   61: invokevirtual 112	android/graphics/Bitmap:getWidth	()I
          //   64: i2f
          //   65: fdiv
          //   66: fstore 5
          //   68: aload_0
          //   69: getfield 29	android/support/v4/print/PrintHelperKitkat$1:val$fittingMode	I
          //   72: iconst_2
          //   73: if_icmpne +146 -> 219
          //   76: fload 5
          //   78: aload 7
          //   80: invokevirtual 115	android/graphics/RectF:height	()F
          //   83: aload_0
          //   84: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   87: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
          //   90: i2f
          //   91: fdiv
          //   92: invokestatic 124	java/lang/Math:max	(FF)F
          //   95: fstore 5
          //   97: aload 6
          //   99: fload 5
          //   101: fload 5
          //   103: invokevirtual 128	android/graphics/Matrix:postScale	(FF)Z
          //   106: pop
          //   107: aload 6
          //   109: aload 7
          //   111: invokevirtual 106	android/graphics/RectF:width	()F
          //   114: aload_0
          //   115: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   118: invokevirtual 112	android/graphics/Bitmap:getWidth	()I
          //   121: i2f
          //   122: fload 5
          //   124: fmul
          //   125: fsub
          //   126: fconst_2
          //   127: fdiv
          //   128: aload 7
          //   130: invokevirtual 115	android/graphics/RectF:height	()F
          //   133: aload_0
          //   134: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   137: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
          //   140: i2f
          //   141: fload 5
          //   143: fmul
          //   144: fsub
          //   145: fconst_2
          //   146: fdiv
          //   147: invokevirtual 131	android/graphics/Matrix:postTranslate	(FF)Z
          //   150: pop
          //   151: aload_3
          //   152: invokevirtual 135	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
          //   155: aload_0
          //   156: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   159: aload 6
          //   161: aconst_null
          //   162: invokevirtual 141	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
          //   165: aload_1
          //   166: aload_3
          //   167: invokevirtual 145	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
          //   170: new 147	java/io/FileOutputStream
          //   173: astore_3
          //   174: aload_3
          //   175: aload_2
          //   176: invokevirtual 153	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
          //   179: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
          //   182: aload_1
          //   183: aload_3
          //   184: invokevirtual 160	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
          //   187: aload 4
          //   189: iconst_1
          //   190: anewarray 162	android/print/PageRange
          //   193: dup
          //   194: iconst_0
          //   195: getstatic 166	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
          //   198: aastore
          //   199: invokevirtual 172	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
          //   202: aload_1
          //   203: ifnull +7 -> 210
          //   206: aload_1
          //   207: invokevirtual 175	android/print/pdf/PrintedPdfDocument:close	()V
          //   210: aload_2
          //   211: ifnull +7 -> 218
          //   214: aload_2
          //   215: invokevirtual 176	android/os/ParcelFileDescriptor:close	()V
          //   218: return
          //   219: fload 5
          //   221: aload 7
          //   223: invokevirtual 115	android/graphics/RectF:height	()F
          //   226: aload_0
          //   227: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   230: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
          //   233: i2f
          //   234: fdiv
          //   235: invokestatic 179	java/lang/Math:min	(FF)F
          //   238: fstore 5
          //   240: goto -143 -> 97
          //   243: astore_3
          //   244: ldc -75
          //   246: ldc -73
          //   248: aload_3
          //   249: invokestatic 189	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   252: pop
          //   253: aload 4
          //   255: aconst_null
          //   256: invokevirtual 193	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
          //   259: goto -57 -> 202
          //   262: astore_3
          //   263: aload_1
          //   264: ifnull +7 -> 271
          //   267: aload_1
          //   268: invokevirtual 175	android/print/pdf/PrintedPdfDocument:close	()V
          //   271: aload_2
          //   272: ifnull +7 -> 279
          //   275: aload_2
          //   276: invokevirtual 176	android/os/ParcelFileDescriptor:close	()V
          //   279: aload_3
          //   280: athrow
          //   281: astore_1
          //   282: goto -64 -> 218
          //   285: astore_1
          //   286: goto -7 -> 279
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	289	0	this	1
          //   0	289	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
          //   0	289	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
          //   0	289	3	paramAnonymousCancellationSignal	CancellationSignal
          //   0	289	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
          //   66	173	5	f	float
          //   45	115	6	localMatrix	android.graphics.Matrix
          //   28	194	7	localRectF	android.graphics.RectF
          // Exception table:
          //   from	to	target	type
          //   170	202	243	java/io/IOException
          //   19	97	262	finally
          //   97	170	262	finally
          //   170	202	262	finally
          //   219	240	262	finally
          //   244	259	262	finally
          //   214	218	281	java/io/IOException
          //   275	279	285	java/io/IOException
        }
      }, (PrintAttributes)localObject);
    }
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    printBitmap(paramString, loadConstrainedBitmap(paramUri, 3500));
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\print\PrintHelperKitkat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */