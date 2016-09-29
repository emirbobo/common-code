package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.List;
import java.util.zip.Checksum;

@Beta
public final class Files
{
  private static final int TEMP_DIR_ATTEMPTS = 10000;
  
  static
  {
    JniLib.a(Files.class, 839);
  }
  
  public static native void append(CharSequence paramCharSequence, File paramFile, Charset paramCharset)
    throws IOException;
  
  public static native void copy(InputSupplier<? extends InputStream> paramInputSupplier, File paramFile)
    throws IOException;
  
  public static native <R extends Readable,  extends Closeable> void copy(InputSupplier<R> paramInputSupplier, File paramFile, Charset paramCharset)
    throws IOException;
  
  public static native void copy(File paramFile, OutputSupplier<? extends OutputStream> paramOutputSupplier)
    throws IOException;
  
  public static native void copy(File paramFile1, File paramFile2)
    throws IOException;
  
  public static native void copy(File paramFile, OutputStream paramOutputStream)
    throws IOException;
  
  public static native <W extends Appendable,  extends Closeable> void copy(File paramFile, Charset paramCharset, OutputSupplier<W> paramOutputSupplier)
    throws IOException;
  
  public static native void copy(File paramFile, Charset paramCharset, Appendable paramAppendable)
    throws IOException;
  
  public static native void createParentDirs(File paramFile)
    throws IOException;
  
  public static native File createTempDir();
  
  public static native void deleteDirectoryContents(File paramFile)
    throws IOException;
  
  public static native void deleteRecursively(File paramFile)
    throws IOException;
  
  public static native boolean equal(File paramFile1, File paramFile2)
    throws IOException;
  
  public static native long getChecksum(File paramFile, Checksum paramChecksum)
    throws IOException;
  
  public static native byte[] getDigest(File paramFile, MessageDigest paramMessageDigest)
    throws IOException;
  
  public static native MappedByteBuffer map(File paramFile)
    throws IOException;
  
  public static native MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode)
    throws IOException;
  
  public static native MappedByteBuffer map(File paramFile, FileChannel.MapMode paramMapMode, long paramLong)
    throws FileNotFoundException, IOException;
  
  private static native MappedByteBuffer map(RandomAccessFile paramRandomAccessFile, FileChannel.MapMode paramMapMode, long paramLong)
    throws IOException;
  
  public static native void move(File paramFile1, File paramFile2)
    throws IOException;
  
  public static native InputSupplier<FileInputStream> newInputStreamSupplier(File paramFile);
  
  public static native OutputSupplier<FileOutputStream> newOutputStreamSupplier(File paramFile);
  
  public static native OutputSupplier<FileOutputStream> newOutputStreamSupplier(File paramFile, boolean paramBoolean);
  
  public static native BufferedReader newReader(File paramFile, Charset paramCharset)
    throws FileNotFoundException;
  
  public static native InputSupplier<InputStreamReader> newReaderSupplier(File paramFile, Charset paramCharset);
  
  public static native BufferedWriter newWriter(File paramFile, Charset paramCharset)
    throws FileNotFoundException;
  
  public static native OutputSupplier<OutputStreamWriter> newWriterSupplier(File paramFile, Charset paramCharset);
  
  public static native OutputSupplier<OutputStreamWriter> newWriterSupplier(File paramFile, Charset paramCharset, boolean paramBoolean);
  
  public static native <T> T readBytes(File paramFile, ByteProcessor<T> paramByteProcessor)
    throws IOException;
  
  public static native String readFirstLine(File paramFile, Charset paramCharset)
    throws IOException;
  
  public static native <T> T readLines(File paramFile, Charset paramCharset, LineProcessor<T> paramLineProcessor)
    throws IOException;
  
  public static native List<String> readLines(File paramFile, Charset paramCharset)
    throws IOException;
  
  public static native byte[] toByteArray(File paramFile)
    throws IOException;
  
  public static native String toString(File paramFile, Charset paramCharset)
    throws IOException;
  
  public static native void touch(File paramFile)
    throws IOException;
  
  public static native void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset)
    throws IOException;
  
  private static native void write(CharSequence paramCharSequence, File paramFile, Charset paramCharset, boolean paramBoolean)
    throws IOException;
  
  public static native void write(byte[] paramArrayOfByte, File paramFile)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */