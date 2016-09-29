import java.io.IOException;
import java.io.Reader;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class iq
  extends jh
{
  private iv jdField_a_of_type_Iv;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public iq(Reader paramReader)
  {
    this(paramReader, null, "BC");
  }
  
  public iq(Reader paramReader, iv paramiv)
  {
    this(paramReader, paramiv, "BC");
  }
  
  private iq(Reader paramReader, iv paramiv, String paramString)
  {
    this(paramReader, paramiv, paramString, paramString);
  }
  
  private iq(Reader paramReader, iv paramiv, String paramString1, String paramString2)
  {
    super(paramReader);
    this.jdField_a_of_type_Iv = paramiv;
    this.jdField_a_of_type_JavaUtilMap.put("CERTIFICATE", new it(paramString2));
    this.jdField_a_of_type_JavaUtilMap.put("RSA PRIVATE KEY", new is(this, paramString1, paramString2));
  }
  
  private static SecretKey a(char[] paramArrayOfChar, String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    return a(paramArrayOfChar, paramString, paramInt, paramArrayOfByte, false);
  }
  
  private static SecretKey a(char[] paramArrayOfChar, String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    ij localij = new ij();
    byte[] arrayOfByte;
    if (paramArrayOfChar != null)
    {
      arrayOfByte = new byte[paramArrayOfChar.length];
      for (int i = 0; i != arrayOfByte.length; i++) {
        arrayOfByte[i] = ((byte)(byte)paramArrayOfChar[i]);
      }
    }
    for (paramArrayOfChar = arrayOfByte;; paramArrayOfChar = new byte[0])
    {
      localij.b(paramArrayOfChar, paramArrayOfByte);
      paramArrayOfChar = ((if)localij.a(paramInt << 3)).a;
      if ((paramBoolean) && (paramArrayOfChar.length >= 24)) {
        System.arraycopy(paramArrayOfChar, 0, paramArrayOfChar, 16, 8);
      }
      return new SecretKeySpec(paramArrayOfChar, paramString);
    }
  }
  
  static byte[] a(String paramString1, byte[] paramArrayOfByte1, char[] paramArrayOfChar, String paramString2, byte[] paramArrayOfByte2)
    throws IOException
  {
    Object localObject = null;
    if (paramString1 != null)
    {
      Provider localProvider = Security.getProvider(paramString1);
      localObject = localProvider;
      if (localProvider == null) {
        throw new io("cannot find provider: " + paramString1);
      }
    }
    return a((Provider)localObject, paramArrayOfByte1, paramArrayOfChar, paramString2, paramArrayOfByte2);
  }
  
  private static byte[] a(Provider paramProvider, byte[] paramArrayOfByte1, char[] paramArrayOfChar, String paramString, byte[] paramArrayOfByte2)
    throws IOException
  {
    int i = 128;
    boolean bool = false;
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramArrayOfByte2);
    String str2 = "CBC";
    String str1 = "PKCS5Padding";
    if (paramString.endsWith("-CFB"))
    {
      str2 = "CFB";
      str1 = "NoPadding";
    }
    if ((paramString.endsWith("-ECB")) || ("DES-EDE".equals(paramString)) || ("DES-EDE3".equals(paramString)))
    {
      str2 = "ECB";
      localIvParameterSpec = null;
    }
    if (paramString.endsWith("-OFB"))
    {
      str2 = "OFB";
      str1 = "NoPadding";
    }
    if (paramString.startsWith("DES-EDE"))
    {
      if (!paramString.startsWith("DES-EDE3")) {
        bool = true;
      }
      paramArrayOfByte2 = a(paramArrayOfChar, "DESede", 24, paramArrayOfByte2, bool);
      paramString = localIvParameterSpec;
      paramArrayOfChar = "DESede";
      paramArrayOfChar = paramArrayOfChar + "/" + str2 + "/" + str1;
    }
    label504:
    for (;;)
    {
      try
      {
        paramProvider = Cipher.getInstance(paramArrayOfChar, paramProvider);
        if (paramString == null)
        {
          paramProvider.init(2, paramArrayOfByte2);
          paramProvider = paramProvider.doFinal(paramArrayOfByte1);
          return paramProvider;
          if (paramString.startsWith("DES-"))
          {
            paramArrayOfByte2 = a(paramArrayOfChar, "DES", 8, paramArrayOfByte2);
            paramString = localIvParameterSpec;
            paramArrayOfChar = "DES";
            break;
          }
          if (paramString.startsWith("BF-"))
          {
            paramArrayOfByte2 = a(paramArrayOfChar, "Blowfish", 16, paramArrayOfByte2);
            paramString = localIvParameterSpec;
            paramArrayOfChar = "Blowfish";
            break;
          }
          Object localObject;
          if (paramString.startsWith("RC2-"))
          {
            if (paramString.startsWith("RC2-40-"))
            {
              i = 40;
              localObject = a(paramArrayOfChar, "RC2", i / 8, paramArrayOfByte2);
              if (localIvParameterSpec != null) {
                continue;
              }
              paramString = new RC2ParameterSpec(i);
              paramArrayOfChar = "RC2";
              paramArrayOfByte2 = (byte[])localObject;
              break;
            }
            if (!paramString.startsWith("RC2-64-")) {
              break label504;
            }
            i = 64;
            continue;
            paramString = new RC2ParameterSpec(i, paramArrayOfByte2);
            paramArrayOfChar = "RC2";
            paramArrayOfByte2 = (byte[])localObject;
            break;
          }
          if (paramString.startsWith("AES-"))
          {
            localObject = paramArrayOfByte2;
            if (paramArrayOfByte2.length > 8)
            {
              localObject = new byte[8];
              System.arraycopy(paramArrayOfByte2, 0, localObject, 0, 8);
            }
            if (paramString.startsWith("AES-128-"))
            {
              paramArrayOfByte2 = a(paramArrayOfChar, "AES", i / 8, (byte[])localObject);
              paramString = localIvParameterSpec;
              paramArrayOfChar = "AES";
              break;
            }
            if (paramString.startsWith("AES-192-"))
            {
              i = 192;
              continue;
            }
            if (paramString.startsWith("AES-256-"))
            {
              i = 256;
              continue;
            }
            throw new io("unknown AES encryption with private key");
          }
          throw new io("unknown encryption with private key");
        }
        paramProvider.init(2, paramArrayOfByte2, paramString);
        continue;
        i = 128;
      }
      catch (Exception paramProvider)
      {
        throw new io("exception using cipher - please check password and data.", paramProvider);
      }
    }
  }
  
  public final Object a()
    throws IOException
  {
    Object localObject2 = null;
    for (Object localObject1 = readLine(); (localObject1 != null) && (!((String)localObject1).startsWith("-----BEGIN ")); localObject1 = readLine()) {}
    String str1;
    StringBuffer localStringBuffer;
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).substring(11);
      int i = ((String)localObject1).indexOf('-');
      str1 = ((String)localObject1).substring(0, i);
      if (i > 0)
      {
        String str3 = "-----END " + str1;
        localStringBuffer = new StringBuffer();
        localObject1 = new ArrayList();
        String str2;
        for (;;)
        {
          str2 = readLine();
          if (str2 == null) {
            break;
          }
          if (str2.indexOf(":") >= 0)
          {
            i = str2.indexOf(':');
            ((List)localObject1).add(new je(str2.substring(0, i), str2.substring(i + 1).trim()));
          }
          else
          {
            if (str2.indexOf(str3) != -1) {
              break;
            }
            localStringBuffer.append(str2.trim());
          }
        }
        if (str2 == null) {
          throw new IOException(str3 + " not found");
        }
      }
    }
    for (localObject1 = new jf(str1, (List)localObject1, iw.a(localStringBuffer.toString()));; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = ((jf)localObject1).a();
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject2)) {
          break;
        }
        localObject2 = ((jg)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).a((jf)localObject1);
      }
      return localObject2;
    }
    throw new IOException("unrecognised object: " + (String)localObject2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */