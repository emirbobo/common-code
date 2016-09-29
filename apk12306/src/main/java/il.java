import java.security.AccessController;
import java.security.Provider;
import java.util.HashMap;

public final class il
  extends Provider
{
  private static String jdField_a_of_type_JavaLangString = "BouncyCastle Security Provider v1.49b";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "PBEPBKDF2", "PBEPKCS12" };
  private static final String[] b = { "SipHash" };
  private static final String[] c = { "AES", "ARC4", "Blowfish", "Camellia", "CAST5", "CAST6", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Skipjack", "TEA", "Twofish", "VMPC", "VMPCKSA3", "XTEA" };
  private static final String[] d = { "X509", "IES" };
  private static final String[] e = { "DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145" };
  private static final String[] f = { "GOST3411", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Tiger", "Whirlpool" };
  private static final String[] g = { "BC", "PKCS12" };
  
  static
  {
    new in();
    new HashMap();
  }
  
  public il()
  {
    super("BC", 1.485D, jdField_a_of_type_JavaLangString);
    AccessController.doPrivileged(new im(this));
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if (i != paramArrayOfString.length) {
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        try
        {
          localObject2 = getClass().getClassLoader();
          if (localObject2 == null) {
            break label84;
          }
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localObject2 = ((ClassLoader)localObject2).loadClass(paramString + paramArrayOfString[i] + "$Mappings");
          localObject1 = localObject2;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Object localObject2;
          label84:
          for (;;) {}
        }
        if (localObject1 != null) {}
        try
        {
          ((Class)localObject1).newInstance();
          i++;
        }
        catch (Exception localException)
        {
          throw new InternalError("cannot create instance of " + paramString + paramArrayOfString[i] + "$Mappings : " + localException);
        }
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = Class.forName(paramString + paramArrayOfString[i] + "$Mappings");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */