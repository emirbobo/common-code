import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

abstract class ir
  implements jg
{
  private String jdField_a_of_type_JavaLangString;
  
  public ir(iq paramiq, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected final fw a(jf paramjf)
    throws IOException
  {
    String str = null;
    Object localObject1 = paramjf.a().iterator();
    int i = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (je)((Iterator)localObject1).next();
      if ((((je)localObject2).jdField_a_of_type_JavaLangString.equals("Proc-Type")) && (((je)localObject2).b.equals("4,ENCRYPTED")))
      {
        i = 1;
      }
      else
      {
        if (!((je)localObject2).jdField_a_of_type_JavaLangString.equals("DEK-Info")) {
          break label260;
        }
        str = ((je)localObject2).b;
      }
    }
    label260:
    for (;;)
    {
      break;
      localObject1 = paramjf.a();
      paramjf = (jf)localObject1;
      if (i != 0)
      {
        if (iq.a(this.jdField_a_of_type_Iq) == null) {
          throw new iu("No password finder specified, but a password is required");
        }
        paramjf = iq.a(this.jdField_a_of_type_Iq).a();
        if (paramjf == null) {
          throw new iu("Password is null, but a password is required");
        }
        localObject2 = new StringTokenizer(str, ",");
        str = ((StringTokenizer)localObject2).nextToken();
        localObject2 = jb.a(((StringTokenizer)localObject2).nextToken());
        paramjf = iq.a(this.jdField_a_of_type_JavaLangString, (byte[])localObject1, paramjf, str, (byte[])localObject2);
      }
      try
      {
        paramjf = fw.a(fv.a(paramjf));
        return paramjf;
      }
      catch (IOException paramjf)
      {
        if (i != 0) {
          throw new ip("exception decoding - please check password and data.", paramjf);
        }
        throw new ip(paramjf.getMessage(), paramjf);
      }
      catch (IllegalArgumentException paramjf)
      {
        if (i != 0) {
          throw new ip("exception decoding - please check password and data.", paramjf);
        }
        throw new ip(paramjf.getMessage(), paramjf);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */