public class MobilePhone
{
	public int num;
	public boolean s;
	public Exchange bs;
	public MobilePhone (int  a)
	{
		num=a;
		s = true;
	}
	public int number()
	{
		return num;	
	}
	public boolean status ()
	{
		return s;	
	}
	public void switchOn ()
	{
		s=true;
	}
	public void switchOff ()
	{
		s =false;
	}

	public Exchange location() throws Exception
	{
		if(s)
		{return bs;}
		else
		{throw new Exception("phone is switchOff");}
	}
}