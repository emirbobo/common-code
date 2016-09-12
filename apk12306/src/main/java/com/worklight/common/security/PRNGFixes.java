package com.worklight.common.security;

import com.bangcle.andjni.JniLib;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Provider;
import java.security.SecureRandomSpi;

public final class PRNGFixes
{
  private static final byte[] BUILD_FINGERPRINT_AND_DEVICE_SERIAL = getBuildFingerprintAndDeviceSerial();
  private static final int VERSION_CODE_JELLY_BEAN = 16;
  private static final int VERSION_CODE_JELLY_BEAN_MR2 = 18;
  
  static
  {
    JniLib.a(PRNGFixes.class, 1271);
  }
  
  public static native void apply();
  
  private static native void applyOpenSSLFix()
    throws SecurityException;
  
  private static native byte[] generateSeed();
  
  private static native byte[] getBuildFingerprintAndDeviceSerial();
  
  private static native String getDeviceSerialNumber();
  
  private static native void installLinuxPRNGSecureRandom()
    throws SecurityException;
  
  public static class LinuxPRNGSecureRandom
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
  
  private static class LinuxPRNGSecureRandomProvider
    extends Provider
  {
    public LinuxPRNGSecureRandomProvider()
    {
      super(1.0D, "A Linux-specific random number provider that uses /dev/urandom");
      put("SecureRandom.SHA1PRNG", PRNGFixes.LinuxPRNGSecureRandom.class.getName());
      put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\security\PRNGFixes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */