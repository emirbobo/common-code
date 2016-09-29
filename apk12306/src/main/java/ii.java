public final class ii
  extends ig
{
  private int[] a = new int[16];
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public ii()
  {
    a();
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << paramInt2 | paramInt1 >>> 32 - paramInt2;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt2 | (paramInt1 ^ 0xFFFFFFFF) & paramInt3;
  }
  
  private static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >> 24));
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | (paramInt3 ^ 0xFFFFFFFF) & paramInt2;
  }
  
  public final int a(byte[] paramArrayOfByte)
  {
    long l = this.jdField_a_of_type_Long;
    a((byte)Byte.MIN_VALUE);
    while (this.jdField_a_of_type_Int != 0) {
      a((byte)0);
    }
    a(l << 3);
    b();
    a(this.b, paramArrayOfByte, 0);
    a(this.c, paramArrayOfByte, 4);
    a(this.d, paramArrayOfByte, 8);
    a(this.e, paramArrayOfByte, 12);
    a();
    return 16;
  }
  
  public final void a()
  {
    super.a();
    this.b = 1732584193;
    this.c = -271733879;
    this.d = -1732584194;
    this.e = 271733878;
    this.f = 0;
    for (int i = 0; i != this.a.length; i++) {
      this.a[i] = 0;
    }
  }
  
  protected final void a(long paramLong)
  {
    if (this.f > 14) {
      b();
    }
    this.a[14] = ((int)paramLong);
    this.a[15] = ((int)(paramLong >>> 32));
  }
  
  protected final void a(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = this.f;
    this.f = (i + 1);
    arrayOfInt[i] = (paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24);
    if (this.f == 16) {
      b();
    }
  }
  
  protected final void b()
  {
    int i = this.b;
    int m = this.c;
    int k = this.d;
    int j = this.e;
    i = a(i + a(m, k, j) + this.a[0] - 680876936, 7) + m;
    j = a(j + a(i, m, k) + this.a[1] - 389564586, 12) + i;
    k = a(k + a(j, i, m) + this.a[2] + 606105819, 17) + j;
    m = a(m + a(k, j, i) + this.a[3] - 1044525330, 22) + k;
    int n = a(i + a(m, k, j) + this.a[4] - 176418897, 7) + m;
    j = a(j + a(n, m, k) + this.a[5] + 1200080426, 12) + n;
    k = a(k + a(j, n, m) + this.a[6] - 1473231341, 17) + j;
    i = a(m + a(k, j, n) + this.a[7] - 45705983, 22) + k;
    m = a(n + a(i, k, j) + this.a[8] + 1770035416, 7) + i;
    j = a(j + a(m, i, k) + this.a[9] - 1958414417, 12) + m;
    k = a(k + a(j, m, i) + this.a[10] - 42063, 17) + j;
    i = a(i + a(k, j, m) + this.a[11] - 1990404162, 22) + k;
    n = a(m + a(i, k, j) + this.a[12] + 1804603682, 7) + i;
    m = a(j + a(n, i, k) + this.a[13] - 40341101, 12) + n;
    int i1 = a(k + a(m, n, i) + this.a[14] - 1502002290, 17) + m;
    k = a(i + a(i1, m, n) + this.a[15] + 1236535329, 22) + i1;
    j = a(n + b(k, i1, m) + this.a[1] - 165796510, 5) + k;
    i = a(m + b(j, k, i1) + this.a[6] - 1069501632, 9) + j;
    n = a(i1 + b(i, j, k) + this.a[11] + 643717713, 14) + i;
    k = a(k + b(n, i, j) + this.a[0] - 373897302, 20) + n;
    m = a(j + b(k, n, i) + this.a[5] - 701558691, 5) + k;
    j = a(i + b(m, k, n) + this.a[10] + 38016083, 9) + m;
    i = a(n + b(j, m, k) + this.a[15] - 660478335, 14) + j;
    k = a(k + b(i, j, m) + this.a[4] - 405537848, 20) + i;
    i1 = a(m + b(k, i, j) + this.a[9] + 568446438, 5) + k;
    n = a(j + b(i1, k, i) + this.a[14] - 1019803690, 9) + i1;
    m = a(i + b(n, i1, k) + this.a[3] - 187363961, 14) + n;
    j = a(k + b(m, n, i1) + this.a[8] + 1163531501, 20) + m;
    i = a(i1 + b(j, m, n) + this.a[13] - 1444681467, 5) + j;
    n = a(n + b(i, j, m) + this.a[2] - 51403784, 9) + i;
    k = a(m + b(n, i, j) + this.a[7] + 1735328473, 14) + n;
    m = a(j + b(k, n, i) + this.a[12] - 1926607734, 20) + k;
    i = a(i + (m ^ k ^ n) + this.a[5] - 378558, 4) + m;
    n = a(n + (i ^ m ^ k) + this.a[8] - 2022574463, 11) + i;
    j = a(k + (n ^ i ^ m) + this.a[11] + 1839030562, 16) + n;
    k = a(m + (j ^ n ^ i) + this.a[14] - 35309556, 23) + j;
    i = a(i + (k ^ j ^ n) + this.a[1] - 1530992060, 4) + k;
    m = a(n + (i ^ k ^ j) + this.a[4] + 1272893353, 11) + i;
    j = a(j + (m ^ i ^ k) + this.a[7] - 155497632, 16) + m;
    k = a(k + (j ^ m ^ i) + this.a[10] - 1094730640, 23) + j;
    n = a(i + (k ^ j ^ m) + this.a[13] + 681279174, 4) + k;
    m = a(m + (n ^ k ^ j) + this.a[0] - 358537222, 11) + n;
    i = a(j + (m ^ n ^ k) + this.a[3] - 722521979, 16) + m;
    k = a(k + (i ^ m ^ n) + this.a[6] + 76029189, 23) + i;
    j = a(n + (k ^ i ^ m) + this.a[9] - 640364487, 4) + k;
    m = a(m + (j ^ k ^ i) + this.a[12] - 421815835, 11) + j;
    i = a(i + (m ^ j ^ k) + this.a[15] + 530742520, 16) + m;
    k = a(k + (i ^ m ^ j) + this.a[2] - 995338651, 23) + i;
    n = a(j + ((m ^ 0xFFFFFFFF | k) ^ i) + this.a[0] - 198630844, 6) + k;
    m = a(m + ((i ^ 0xFFFFFFFF | n) ^ k) + this.a[7] + 1126891415, 10) + n;
    j = a(i + ((k ^ 0xFFFFFFFF | m) ^ n) + this.a[14] - 1416354905, 15) + m;
    k = a(k + ((n ^ 0xFFFFFFFF | j) ^ m) + this.a[5] - 57434055, 21) + j;
    i = a(n + ((m ^ 0xFFFFFFFF | k) ^ j) + this.a[12] + 1700485571, 6) + k;
    n = a(m + ((j ^ 0xFFFFFFFF | i) ^ k) + this.a[3] - 1894986606, 10) + i;
    j = a(j + ((k ^ 0xFFFFFFFF | n) ^ i) + this.a[10] - 1051523, 15) + n;
    k = a(k + ((i ^ 0xFFFFFFFF | j) ^ n) + this.a[1] - 2054922799, 21) + j;
    m = a(i + ((n ^ 0xFFFFFFFF | k) ^ j) + this.a[8] + 1873313359, 6) + k;
    i = a(n + ((j ^ 0xFFFFFFFF | m) ^ k) + this.a[15] - 30611744, 10) + m;
    n = a(j + ((k ^ 0xFFFFFFFF | i) ^ m) + this.a[6] - 1560198380, 15) + i;
    j = a(k + ((m ^ 0xFFFFFFFF | n) ^ i) + this.a[13] + 1309151649, 21) + n;
    k = a(m + ((i ^ 0xFFFFFFFF | j) ^ n) + this.a[4] - 145523070, 6) + j;
    i = a(i + ((n ^ 0xFFFFFFFF | k) ^ j) + this.a[11] - 1120210379, 10) + k;
    m = a(n + ((j ^ 0xFFFFFFFF | i) ^ k) + this.a[2] + 718787259, 15) + i;
    j = a(j + ((k ^ 0xFFFFFFFF | m) ^ i) + this.a[9] - 343485551, 21);
    this.b = (k + this.b);
    this.c += j + m;
    this.d += m;
    this.e += i;
    this.f = 0;
    for (i = 0; i != this.a.length; i++) {
      this.a[i] = 0;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */