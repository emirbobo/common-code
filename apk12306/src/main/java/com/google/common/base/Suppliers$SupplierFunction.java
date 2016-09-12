package com.google.common.base;

 enum Suppliers$SupplierFunction
  implements Function<Supplier<?>, Object>
{
  INSTANCE;
  
  private Suppliers$SupplierFunction() {}
  
  public Object apply(Supplier<?> paramSupplier)
  {
    return paramSupplier.get();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Suppliers$SupplierFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */