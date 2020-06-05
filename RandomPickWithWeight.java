/*								Random Pick with Weight
 Given an array w of positive integers, where w[i] describes the weight of index i, 
 write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.


Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]


Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor 
has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with
a list, even if there aren't any.
 */
import java.util.*;
public class RandomPickWithWeight 
{
	int weight[];
    int sum;
    public RandomPickWithWeight(int[] w) 
    {
        this.weight=w;
        for(int i=0;i<w.length;i++)
        {
            sum=sum+w[i];
        }
    }
    int pickIndex()
    {
        
        Random rand=new Random();
        int randVal=rand.nextInt(sum)+1;
        int temp=0;
        for(int i=0;i<weight.length;i++)
        {
            if(temp+weight[i]>=randVal)
            {
                return i;
            }
            else
            {
                temp=temp+weight[i];
            }
        }
        return weight.length-1;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int w[]= {1,3};
		RandomPickWithWeight r=new RandomPickWithWeight(w);
		for(int i=0;i<10;i++)
		{
			System.out.println(r.pickIndex());
		}
	}

}
