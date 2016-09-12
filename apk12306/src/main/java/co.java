import javax.security.auth.x500.X500Principal;

public final class co
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private char[] jdField_a_of_type_ArrayOfChar;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public co(X500Principal paramX500Principal)
  {
    this.jdField_a_of_type_JavaLangString = paramX500Principal.getName("RFC2253");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangString.length();
  }
  
  private char a()
  {
    this.b += 1;
    if (this.b == this.jdField_a_of_type_Int) {
      throw new IllegalStateException("Unexpected end of DN: " + this.jdField_a_of_type_JavaLangString);
    }
    char c2;
    switch (this.jdField_a_of_type_ArrayOfChar[this.b])
    {
    default: 
      c2 = b();
    }
    for (char c1 = c2;; c1 = c2)
    {
      return c1;
      c2 = this.jdField_a_of_type_ArrayOfChar[this.b];
    }
  }
  
  private int a(int paramInt)
  {
    if (paramInt + 1 >= this.jdField_a_of_type_Int) {
      throw new IllegalStateException("Malformed DN: " + this.jdField_a_of_type_JavaLangString);
    }
    int i = this.jdField_a_of_type_ArrayOfChar[paramInt];
    if ((i >= 48) && (i <= 57))
    {
      i -= 48;
      paramInt = this.jdField_a_of_type_ArrayOfChar[(paramInt + 1)];
      if ((paramInt < 48) || (paramInt > 57)) {
        break label152;
      }
      paramInt -= 48;
    }
    for (;;)
    {
      return (i << 4) + paramInt;
      if ((i >= 97) && (i <= 102))
      {
        i -= 87;
        break;
      }
      if ((i >= 65) && (i <= 70))
      {
        i -= 55;
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.jdField_a_of_type_JavaLangString);
      label152:
      if ((paramInt >= 97) && (paramInt <= 102))
      {
        paramInt -= 87;
      }
      else
      {
        if ((paramInt < 65) || (paramInt > 70)) {
          break label188;
        }
        paramInt -= 55;
      }
    }
    label188:
    throw new IllegalStateException("Malformed DN: " + this.jdField_a_of_type_JavaLangString);
  }
  
  private String a()
  {
    while ((this.b < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] == ' ')) {
      this.b += 1;
    }
    if (this.b == this.jdField_a_of_type_Int) {}
    for (String str = null;; str = new String(this.jdField_a_of_type_ArrayOfChar, this.c, this.d - this.c))
    {
      return str;
      this.c = this.b;
      for (this.b += 1; (this.b < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] != '=') && (this.jdField_a_of_type_ArrayOfChar[this.b] != ' '); this.b += 1) {}
      if (this.b >= this.jdField_a_of_type_Int) {
        throw new IllegalStateException("Unexpected end of DN: " + this.jdField_a_of_type_JavaLangString);
      }
      this.d = this.b;
      if (this.jdField_a_of_type_ArrayOfChar[this.b] == ' ')
      {
        while ((this.b < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] != '=') && (this.jdField_a_of_type_ArrayOfChar[this.b] == ' ')) {
          this.b += 1;
        }
        if ((this.jdField_a_of_type_ArrayOfChar[this.b] != '=') || (this.b == this.jdField_a_of_type_Int)) {
          throw new IllegalStateException("Unexpected end of DN: " + this.jdField_a_of_type_JavaLangString);
        }
      }
      do
      {
        this.b += 1;
      } while ((this.b < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] == ' '));
      if ((this.d - this.c > 4) && (this.jdField_a_of_type_ArrayOfChar[(this.c + 3)] == '.') && ((this.jdField_a_of_type_ArrayOfChar[this.c] == 'O') || (this.jdField_a_of_type_ArrayOfChar[this.c] == 'o')) && ((this.jdField_a_of_type_ArrayOfChar[(this.c + 1)] == 'I') || (this.jdField_a_of_type_ArrayOfChar[(this.c + 1)] == 'i')) && ((this.jdField_a_of_type_ArrayOfChar[(this.c + 2)] == 'D') || (this.jdField_a_of_type_ArrayOfChar[(this.c + 2)] == 'd'))) {
        this.c += 4;
      }
    }
  }
  
  private char b()
  {
    int j = a(this.b);
    this.b += 1;
    int i;
    if (j < 128)
    {
      j = (char)j;
      i = j;
    }
    for (;;)
    {
      return i;
      if ((j >= 192) && (j <= 247))
      {
        int k;
        if (j <= 223)
        {
          k = 1;
          j &= 0x1F;
        }
        label61:
        for (int m = 0;; m++)
        {
          if (m >= k) {
            break label207;
          }
          this.b += 1;
          if ((this.b == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ArrayOfChar[this.b] != '\\'))
          {
            j = 63;
            i = j;
            break;
            if (j <= 239)
            {
              k = 2;
              j &= 0xF;
              break label61;
            }
            k = 3;
            j &= 0x7;
            break label61;
          }
          this.b += 1;
          int n = a(this.b);
          this.b += 1;
          if ((n & 0xC0) != 128)
          {
            j = 63;
            i = j;
            break;
          }
          j = (j << 6) + (n & 0x3F);
        }
        label207:
        j = (char)j;
        i = j;
      }
      else
      {
        j = 63;
        i = j;
      }
    }
  }
  
  private String b()
  {
    if (this.b + 4 >= this.jdField_a_of_type_Int) {
      throw new IllegalStateException("Unexpected end of DN: " + this.jdField_a_of_type_JavaLangString);
    }
    this.c = this.b;
    int k;
    for (this.b += 1;; this.b += 1)
    {
      if ((this.b == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ArrayOfChar[this.b] == '+') || (this.jdField_a_of_type_ArrayOfChar[this.b] == ',') || (this.jdField_a_of_type_ArrayOfChar[this.b] == ';')) {
        this.d = this.b;
      }
      for (;;)
      {
        k = this.d - this.c;
        if ((k >= 5) && ((k & 0x1) != 0)) {
          break label302;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ArrayOfChar[this.b] != ' ') {
          break;
        }
        this.d = this.b;
        for (this.b += 1; (this.b < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] == ' '); this.b += 1) {}
      }
      if ((this.jdField_a_of_type_ArrayOfChar[this.b] >= 'A') && (this.jdField_a_of_type_ArrayOfChar[this.b] <= 'F'))
      {
        localObject = this.jdField_a_of_type_ArrayOfChar;
        i = this.b;
        localObject[i] = ((char)(char)(localObject[i] + ' '));
      }
    }
    label302:
    Object localObject = new byte[k / 2];
    int i = 0;
    int j = this.c + 1;
    while (i < localObject.length)
    {
      localObject[i] = ((byte)(byte)a(j));
      j += 2;
      i++;
    }
    return new String(this.jdField_a_of_type_ArrayOfChar, this.c, k);
  }
  
  private String c()
  {
    this.c = this.b;
    this.d = this.b;
    Object localObject;
    if (this.b >= this.jdField_a_of_type_Int) {
      localObject = new String(this.jdField_a_of_type_ArrayOfChar, this.c, this.d - this.c);
    }
    for (;;)
    {
      return (String)localObject;
      int i;
      switch (this.jdField_a_of_type_ArrayOfChar[this.b])
      {
      default: 
        localObject = this.jdField_a_of_type_ArrayOfChar;
        i = this.d;
        this.d = (i + 1);
        localObject[i] = ((char)this.jdField_a_of_type_ArrayOfChar[this.b]);
        this.b += 1;
        break;
      case '+': 
      case ',': 
      case ';': 
        localObject = new String(this.jdField_a_of_type_ArrayOfChar, this.c, this.d - this.c);
        break;
      case '\\': 
        localObject = this.jdField_a_of_type_ArrayOfChar;
        i = this.d;
        this.d = (i + 1);
        localObject[i] = a();
        this.b += 1;
        break;
      case ' ': 
        this.e = this.d;
        this.b += 1;
        localObject = this.jdField_a_of_type_ArrayOfChar;
        i = this.d;
        this.d = (i + 1);
        localObject[i] = ((char)32);
        while ((this.b < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] == ' '))
        {
          localObject = this.jdField_a_of_type_ArrayOfChar;
          i = this.d;
          this.d = (i + 1);
          localObject[i] = ((char)32);
          this.b += 1;
        }
        if ((this.b != this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] != ',') && (this.jdField_a_of_type_ArrayOfChar[this.b] != '+') && (this.jdField_a_of_type_ArrayOfChar[this.b] != ';')) {
          break;
        }
        localObject = new String(this.jdField_a_of_type_ArrayOfChar, this.c, this.e - this.c);
      }
    }
  }
  
  public final String a(String paramString)
  {
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.jdField_a_of_type_ArrayOfChar = this.jdField_a_of_type_JavaLangString.toCharArray();
    String str1 = a();
    String str2 = str1;
    if (str1 == null)
    {
      str1 = null;
      return str1;
    }
    label387:
    do
    {
      str1 = "";
      if (this.b == this.jdField_a_of_type_Int)
      {
        str1 = null;
        break;
      }
      switch (this.jdField_a_of_type_ArrayOfChar[this.b])
      {
      default: 
        str1 = c();
      }
      while (!paramString.equalsIgnoreCase(str2))
      {
        if (this.b < this.jdField_a_of_type_Int) {
          break label387;
        }
        str1 = null;
        break;
        this.b += 1;
        this.c = this.b;
        this.d = this.c;
        if (this.b == this.jdField_a_of_type_Int) {
          throw new IllegalStateException("Unexpected end of DN: " + this.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ArrayOfChar[this.b] == '"') {
          for (this.b += 1; (this.b < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfChar[this.b] == ' '); this.b += 1) {}
        }
        if (this.jdField_a_of_type_ArrayOfChar[this.b] == '\\') {
          this.jdField_a_of_type_ArrayOfChar[this.d] = a();
        }
        for (;;)
        {
          this.b += 1;
          this.d += 1;
          break;
          this.jdField_a_of_type_ArrayOfChar[this.d] = ((char)this.jdField_a_of_type_ArrayOfChar[this.b]);
        }
        str1 = new String(this.jdField_a_of_type_ArrayOfChar, this.c, this.d - this.c);
        continue;
        str1 = b();
      }
      if ((this.jdField_a_of_type_ArrayOfChar[this.b] != ',') && (this.jdField_a_of_type_ArrayOfChar[this.b] != ';') && (this.jdField_a_of_type_ArrayOfChar[this.b] != '+')) {
        throw new IllegalStateException("Malformed DN: " + this.jdField_a_of_type_JavaLangString);
      }
      this.b += 1;
      str1 = a();
      str2 = str1;
    } while (str1 != null);
    throw new IllegalStateException("Malformed DN: " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */