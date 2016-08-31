package testannotation.target;

/**
 * Created by Administrator on 2016/8/31.
 */
@AnnoOnlyField
public class AnnoUse
{
	@AnnoOnlyField
	String name;

	@AnnoOnlyField(value = "printTime")
	public void printTime()
	{

	}
}
