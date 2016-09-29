public final class ij
  extends ih
{
  private ig a;
  
  public ij()
  {
    this.jdField_a_of_type_Ig = new ii();
  }
  
  public final if a(int paramInt)
  {
    int k = paramInt / 8;
    Object localObject = this.jdField_a_of_type_Ig;
    localObject = new byte[16];
    byte[] arrayOfByte = new byte[k];
    int i = 0;
    paramInt = k;
    this.jdField_a_of_type_Ig.a(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
    this.jdField_a_of_type_Ig.a(this.b, 0, this.b.length);
    this.jdField_a_of_type_Ig.a((byte[])localObject);
    if (paramInt > localObject.length) {}
    for (int j = localObject.length;; j = paramInt)
    {
      System.arraycopy(localObject, 0, arrayOfByte, i, j);
      i += j;
      paramInt -= j;
      if (paramInt == 0) {
        break label134;
      }
      this.jdField_a_of_type_Ig.a();
      this.jdField_a_of_type_Ig.a((byte[])localObject, 0, localObject.length);
      break;
    }
    label134:
    return new if(arrayOfByte, k);
  }
  
  public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super.a(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */