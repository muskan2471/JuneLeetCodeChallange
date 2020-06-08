
public class IsPower2
{
	boolean isPowerOfTwo(int n) 
    {
        if(n==0)
        {
            return false;
        }
        while(n%2==0)
        {
            n=n/2;
        }
        if(n==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
	public static void main(String args[])
	{
		IsPower2 i=new IsPower2();
		System.out.print(i.isPowerOfTwo(512));
		
	}

}
