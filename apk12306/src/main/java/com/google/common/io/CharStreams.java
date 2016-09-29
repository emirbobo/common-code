package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Beta
public final class CharStreams
{
  private static final int BUF_SIZE = 2048;
  
  static
  {
    JniLib.a(CharStreams.class, 829);
  }
  
  public static native Writer asWriter(Appendable paramAppendable);
  
  public static native <R extends Readable,  extends Closeable, W extends Appendable,  extends Closeable> long copy(InputSupplier<R> paramInputSupplier, OutputSupplier<W> paramOutputSupplier)
    throws IOException;
  
  public static native <R extends Readable,  extends Closeable> long copy(InputSupplier<R> paramInputSupplier, Appendable paramAppendable)
    throws IOException;
  
  public static native long copy(Readable paramReadable, Appendable paramAppendable)
    throws IOException;
  
  public static native InputSupplier<Reader> join(Iterable<? extends InputSupplier<? extends Reader>> paramIterable);
  
  public static InputSupplier<Reader> join(InputSupplier<? extends Reader>... paramVarArgs)
  {
    return join(Arrays.asList(paramVarArgs));
  }
  
  public static native InputSupplier<InputStreamReader> newReaderSupplier(InputSupplier<? extends InputStream> paramInputSupplier, Charset paramCharset);
  
  public static native InputSupplier<StringReader> newReaderSupplier(String paramString);
  
  public static native OutputSupplier<OutputStreamWriter> newWriterSupplier(OutputSupplier<? extends OutputStream> paramOutputSupplier, Charset paramCharset);
  
  public static native <R extends Readable,  extends Closeable> String readFirstLine(InputSupplier<R> paramInputSupplier)
    throws IOException;
  
  public static native <R extends Readable,  extends Closeable, T> T readLines(InputSupplier<R> paramInputSupplier, LineProcessor<T> paramLineProcessor)
    throws IOException;
  
  public static native <R extends Readable,  extends Closeable> List<String> readLines(InputSupplier<R> paramInputSupplier)
    throws IOException;
  
  public static native List<String> readLines(Readable paramReadable)
    throws IOException;
  
  public static native void skipFully(Reader paramReader, long paramLong)
    throws IOException;
  
  public static native <R extends Readable,  extends Closeable> String toString(InputSupplier<R> paramInputSupplier)
    throws IOException;
  
  public static native String toString(Readable paramReadable)
    throws IOException;
  
  private static native <R extends Readable,  extends Closeable> StringBuilder toStringBuilder(InputSupplier<R> paramInputSupplier)
    throws IOException;
  
  private static native StringBuilder toStringBuilder(Readable paramReadable)
    throws IOException;
  
  public static native <W extends Appendable,  extends Closeable> void write(CharSequence paramCharSequence, OutputSupplier<W> paramOutputSupplier)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\CharStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */