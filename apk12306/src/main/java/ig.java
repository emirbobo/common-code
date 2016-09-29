public abstract class ig
{
  public int a;
  public long a;
  private byte[] a;
  
  public ig()
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[4];
    this.jdField_a_of_type_Int = 0;
  }
  
  public abstract int a(byte[] paramArrayOfByte);
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    for (int i = 0; i < this.jdField_a_of_type_ArrayOfByte.length; i++) {
      this.jdField_a_of_type_ArrayOfByte[i] = ((byte)0);
    }
  }
  
  public final void a(byte paramByte)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    arrayOfByte[i] = ((byte)paramByte);
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfByte.length)
    {
      a(this.jdField_a_of_type_ArrayOfByte, 0);
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Long += 1L;
  }
  
  public abstract void a(long paramLong);
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt);
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    int j = paramInt1;
    for (;;)
    {
      paramInt1 = j;
      paramInt2 = i;
      if (this.jdField_a_of_type_Int == 0) {
        break;
      }
      paramInt1 = j;
      paramInt2 = i;
      if (i <= 0) {
        break;
      }
      a(paramArrayOfByte[j]);
      j++;
      i--;
    }
    for (;;)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramInt2 <= this.jdField_a_of_type_ArrayOfByte.length) {
        break;
      }
      a(paramArrayOfByte, paramInt1);
      paramInt1 += this.jdField_a_of_type_ArrayOfByte.length;
      paramInt2 -= this.jdField_a_of_type_ArrayOfByte.length;
      this.jdField_a_of_type_Long += this.jdField_a_of_type_ArrayOfByte.length;
    }
    while (i > 0)
    {
      a(paramArrayOfByte[j]);
      j++;
      i--;
    }
  }
  
  public abstract void b();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */