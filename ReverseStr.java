/*						Reverse String
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

 */
public class ReverseStr 
{

	void reverseString(char[] s) 
    {
      
       int i=0;
       int j=s.length-1;
       while(i<j)
       {
               char temp=s[i];
               s[i]=s[j];
               s[j]=temp;
               i++;
               j--;
        }
        for(i=0;i<s.length;i++)
        {
            System.out.print(s[i]+" ");
        }
        
        //another way
        /*
	         StringBuilder str=new StringBuilder(String.valueOf(s));
	        str.reverse();
	        char revStr[]=str.toString().toCharArray();
	        for(int i=0;i<revStr.length;i++)
	        {
	        	System.out.print(revStr[i]+" ");
	        }
      
         */
		
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ReverseStr r=new ReverseStr();
		char arr[]= {'H','e','l','l','o'};
		r.reverseString(arr);

	}

}
