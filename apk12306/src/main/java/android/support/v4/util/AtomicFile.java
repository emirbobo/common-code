package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{
  private final File mBackupName;
  private final File mBaseName;
  
  public AtomicFile(File paramFile)
  {
    this.mBaseName = paramFile;
    this.mBackupName = new File(paramFile.getPath() + ".bak");
  }
  
  static boolean sync(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.getFD().sync();
      bool = true;
    }
    catch (IOException paramFileOutputStream)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public void delete()
  {
    this.mBaseName.delete();
    this.mBackupName.delete();
  }
  
  public void failWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
      return;
    }
    catch (IOException paramFileOutputStream)
    {
      for (;;)
      {
        Log.w("AtomicFile", "failWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  public void finishWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBackupName.delete();
      return;
    }
    catch (IOException paramFileOutputStream)
    {
      for (;;)
      {
        Log.w("AtomicFile", "finishWrite: Got exception:", paramFileOutputStream);
      }
    }
  }
  
  public File getBaseFile()
  {
    return this.mBaseName;
  }
  
  public FileInputStream openRead()
    throws FileNotFoundException
  {
    if (this.mBackupName.exists())
    {
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
    }
    return new FileInputStream(this.mBaseName);
  }
  
  /* Error */
  public byte[] readFully()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 98	android/support/v4/util/AtomicFile:openRead	()Ljava/io/FileInputStream;
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_1
    //   8: aload 6
    //   10: invokevirtual 102	java/io/FileInputStream:available	()I
    //   13: newarray <illegal type>
    //   15: astore 4
    //   17: aload 6
    //   19: aload 4
    //   21: iload_1
    //   22: aload 4
    //   24: arraylength
    //   25: iload_1
    //   26: isub
    //   27: invokevirtual 106	java/io/FileInputStream:read	([BII)I
    //   30: istore_2
    //   31: iload_2
    //   32: ifgt +11 -> 43
    //   35: aload 6
    //   37: invokevirtual 107	java/io/FileInputStream:close	()V
    //   40: aload 4
    //   42: areturn
    //   43: iload_1
    //   44: iload_2
    //   45: iadd
    //   46: istore_2
    //   47: aload 6
    //   49: invokevirtual 102	java/io/FileInputStream:available	()I
    //   52: istore_3
    //   53: iload_2
    //   54: istore_1
    //   55: iload_3
    //   56: aload 4
    //   58: arraylength
    //   59: iload_2
    //   60: isub
    //   61: if_icmple -44 -> 17
    //   64: iload_2
    //   65: iload_3
    //   66: iadd
    //   67: newarray <illegal type>
    //   69: astore 5
    //   71: aload 4
    //   73: iconst_0
    //   74: aload 5
    //   76: iconst_0
    //   77: iload_2
    //   78: invokestatic 113	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   81: aload 5
    //   83: astore 4
    //   85: iload_2
    //   86: istore_1
    //   87: goto -70 -> 17
    //   90: astore 4
    //   92: aload 6
    //   94: invokevirtual 107	java/io/FileInputStream:close	()V
    //   97: aload 4
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	AtomicFile
    //   7	80	1	i	int
    //   30	56	2	j	int
    //   52	15	3	k	int
    //   15	69	4	localObject1	Object
    //   90	8	4	localObject2	Object
    //   69	13	5	arrayOfByte	byte[]
    //   4	89	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   8	17	90	finally
    //   17	31	90	finally
    //   47	53	90	finally
    //   55	81	90	finally
  }
  
  public FileOutputStream startWrite()
    throws IOException
  {
    if (this.mBaseName.exists())
    {
      if (this.mBackupName.exists()) {
        break label88;
      }
      if (!this.mBaseName.renameTo(this.mBackupName)) {
        Log.w("AtomicFile", "Couldn't rename file " + this.mBaseName + " to backup file " + this.mBackupName);
      }
    }
    try
    {
      for (;;)
      {
        FileOutputStream localFileOutputStream1 = new java/io/FileOutputStream;
        localFileOutputStream1.<init>(this.mBaseName);
        return localFileOutputStream1;
        label88:
        this.mBaseName.delete();
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        if (!this.mBaseName.getParentFile().mkdir()) {
          throw new IOException("Couldn't create directory " + this.mBaseName);
        }
        try
        {
          FileOutputStream localFileOutputStream2 = new FileOutputStream(this.mBaseName);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          throw new IOException("Couldn't create " + this.mBaseName);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\util\AtomicFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */