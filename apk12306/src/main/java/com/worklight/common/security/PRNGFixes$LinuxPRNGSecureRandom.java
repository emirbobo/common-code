package com.worklight.common.security;

import com.bangcle.andjni.JniLib;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

public class PRNGFixes$LinuxPRNGSecureRandom
  extends SecureRandomSpi
{
  private static final File URANDOM_FILE = new File("/dev/urandom");
  private static final Object sLock = new Object();
  private static DataInputStream sUrandomIn;
  private static OutputStream sUrandomOut;
  private boolean mSeeded;
  
  static
  {
    JniLib.a(LinuxPRNGSecureRandom.class, 1270);
  }
  
  private native DataInputStream getUrandomInputStream();
  
  private native OutputStream getUrandomOutputStream()
    throws IOException;
  
  protected native byte[] engineGenerateSeed(int paramInt);
  
  protected native void engineNextBytes(byte[] paramArrayOfByte);
  
  protected native void engineSetSeed(byte[] paramArrayOfByte);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\security\PRNGFixes$LinuxPRNGSecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */