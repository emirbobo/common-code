package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class LruDiskCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final char CLEAN = 'C';
  private static final char DELETE = 'D';
  private static final char EXPIRY_PREFIX = 't';
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream()
  {
    static
    {
      JniLib.a(2.class, 938);
    }
    
    public native void write(int paramAnonymousInt)
      throws IOException;
  };
  private static final char READ = 'R';
  private static final char UPDATE = 'U';
  static final String VERSION = "1";
  private final int appVersion;
  private final Callable<Void> cleanupCallable = new Callable()
  {
    static
    {
      JniLib.a(1.class, 937);
    }
    
    public native Void call()
      throws Exception;
  };
  private final File directory;
  final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private FileNameGenerator fileNameGenerator = new MD5FileNameGenerator();
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private Writer journalWriter;
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;
  
  static
  {
    JniLib.a(LruDiskCache.class, 945);
  }
  
  private LruDiskCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
  }
  
  private native void checkNotClosed();
  
  private native void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException;
  
  private static native void deleteContents(File paramFile)
    throws IOException;
  
  private static native void deleteIfExists(File paramFile)
    throws IOException;
  
  private native Editor editByDiskKey(String paramString, long paramLong)
    throws IOException;
  
  private native Snapshot getByDiskKey(String paramString)
    throws IOException;
  
  private static native String inputStreamToString(InputStream paramInputStream)
    throws IOException;
  
  private native boolean journalRebuildRequired();
  
  public static native LruDiskCache open(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException;
  
  private native void processJournal()
    throws IOException;
  
  private static native String readFully(Reader paramReader)
    throws IOException;
  
  private native void readJournal()
    throws IOException;
  
  private native void readJournalLine(String paramString)
    throws IOException;
  
  private native void rebuildJournal()
    throws IOException;
  
  private native boolean removeByDiskKey(String paramString)
    throws IOException;
  
  private static native void renameTo(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException;
  
  private native void trimToSize()
    throws IOException;
  
  public native void close()
    throws IOException;
  
  public native void delete()
    throws IOException;
  
  public native Editor edit(String paramString)
    throws IOException;
  
  public native void flush()
    throws IOException;
  
  public native Snapshot get(String paramString)
    throws IOException;
  
  public native File getCacheFile(String paramString, int paramInt);
  
  public native File getDirectory();
  
  public native long getExpiryTimestamp(String paramString)
    throws IOException;
  
  public native FileNameGenerator getFileNameGenerator();
  
  public native long getMaxSize();
  
  public native boolean isClosed();
  
  public native boolean remove(String paramString)
    throws IOException;
  
  public native void setFileNameGenerator(FileNameGenerator paramFileNameGenerator);
  
  public native void setMaxSize(long paramLong);
  
  public native long size();
  
  public final class Editor
  {
    private boolean committed;
    private final LruDiskCache.Entry entry;
    private boolean hasErrors;
    private final boolean[] written;
    
    static
    {
      JniLib.a(Editor.class, 940);
    }
    
    private Editor(LruDiskCache.Entry paramEntry)
    {
      this.entry = paramEntry;
      if (LruDiskCache.Entry.access$0(paramEntry)) {}
      for (this$1 = null;; this$1 = new boolean[LruDiskCache.this.valueCount])
      {
        this.written = LruDiskCache.this;
        return;
      }
    }
    
    public native void abort()
      throws IOException;
    
    public native void abortUnlessCommitted();
    
    public native void commit()
      throws IOException;
    
    public native String getString(int paramInt)
      throws IOException;
    
    public native InputStream newInputStream(int paramInt)
      throws IOException;
    
    public native OutputStream newOutputStream(int paramInt)
      throws IOException;
    
    public native void set(int paramInt, String paramString)
      throws IOException;
    
    public native void setEntryExpiryTimestamp(long paramLong);
    
    private class FaultHidingOutputStream
      extends FilterOutputStream
    {
      static
      {
        JniLib.a(FaultHidingOutputStream.class, 939);
      }
      
      private FaultHidingOutputStream(OutputStream paramOutputStream)
      {
        super();
      }
      
      public native void close();
      
      public native void flush();
      
      public native void write(int paramInt);
      
      public native void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    }
  }
  
  private final class Entry
  {
    private LruDiskCache.Editor currentEditor;
    private final String diskKey;
    private long expiryTimestamp = Long.MAX_VALUE;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;
    
    static
    {
      JniLib.a(Entry.class, 941);
    }
    
    private Entry(String paramString)
    {
      this.diskKey = paramString;
      this.lengths = new long[LruDiskCache.this.valueCount];
    }
    
    private native IOException invalidLengths(String[] paramArrayOfString)
      throws IOException;
    
    private native void setLengths(String[] paramArrayOfString, int paramInt)
      throws IOException;
    
    public native File getCleanFile(int paramInt);
    
    public native File getDirtyFile(int paramInt);
    
    public native String getLengths()
      throws IOException;
  }
  
  public final class Snapshot
    implements Closeable
  {
    private final String diskKey;
    private final FileInputStream[] ins;
    private final long[] lengths;
    private final long sequenceNumber;
    
    static
    {
      JniLib.a(Snapshot.class, 942);
    }
    
    private Snapshot(String paramString, long paramLong, FileInputStream[] paramArrayOfFileInputStream, long[] paramArrayOfLong)
    {
      this.diskKey = paramString;
      this.sequenceNumber = paramLong;
      this.ins = paramArrayOfFileInputStream;
      this.lengths = paramArrayOfLong;
    }
    
    public native void close();
    
    public native LruDiskCache.Editor edit()
      throws IOException;
    
    public native FileInputStream getInputStream(int paramInt);
    
    public native long getLength(int paramInt);
    
    public native String getString(int paramInt)
      throws IOException;
  }
  
  private class StrictLineReader
    implements Closeable
  {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset = Charset.forName("US-ASCII");
    private int end;
    private final InputStream in;
    private int pos;
    
    static
    {
      JniLib.a(StrictLineReader.class, 944);
    }
    
    public StrictLineReader(InputStream paramInputStream)
    {
      this(paramInputStream, 8192);
    }
    
    public StrictLineReader(InputStream paramInputStream, int paramInt)
    {
      if (paramInputStream == null) {
        throw new NullPointerException();
      }
      if (paramInt < 0) {
        throw new IllegalArgumentException("capacity <= 0");
      }
      this.in = paramInputStream;
      this.buf = new byte[paramInt];
    }
    
    private native void fillBuf()
      throws IOException;
    
    public native void close()
      throws IOException;
    
    public native String readLine()
      throws IOException;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */