package com.google.common.base;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Ascii
{
  public static final byte ACK = 6;
  public static final byte BEL = 7;
  public static final byte BS = 8;
  public static final byte CAN = 24;
  public static final byte CR = 13;
  public static final byte DC1 = 17;
  public static final byte DC2 = 18;
  public static final byte DC3 = 19;
  public static final byte DC4 = 20;
  public static final byte DEL = 127;
  public static final byte DLE = 16;
  public static final byte EM = 25;
  public static final byte ENQ = 5;
  public static final byte EOT = 4;
  public static final byte ESC = 27;
  public static final byte ETB = 23;
  public static final byte ETX = 3;
  public static final byte FF = 12;
  public static final byte FS = 28;
  public static final byte GS = 29;
  public static final byte HT = 9;
  public static final byte LF = 10;
  @Beta
  public static final int MAX = 127;
  @Beta
  public static final int MIN = 0;
  public static final byte NAK = 21;
  public static final byte NL = 10;
  public static final byte NUL = 0;
  public static final byte RS = 30;
  public static final byte SI = 15;
  public static final byte SO = 14;
  public static final byte SOH = 1;
  public static final byte SP = 32;
  public static final byte SPACE = 32;
  public static final byte STX = 2;
  public static final byte SUB = 26;
  public static final byte SYN = 22;
  public static final byte US = 31;
  public static final byte VT = 11;
  public static final byte XOFF = 19;
  public static final byte XON = 17;
  
  static
  {
    JniLib.a(Ascii.class, 256);
  }
  
  public static native boolean isLowerCase(char paramChar);
  
  public static native boolean isUpperCase(char paramChar);
  
  public static native char toLowerCase(char paramChar);
  
  public static native String toLowerCase(String paramString);
  
  public static native char toUpperCase(char paramChar);
  
  public static native String toUpperCase(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Ascii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */