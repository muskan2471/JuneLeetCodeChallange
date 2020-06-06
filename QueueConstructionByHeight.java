/*							Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers
 (h, k), where h is the height of the person and k is the number of people in front of this person who have a
  height greater than or equal to h. Write an algorithm to reconstruct the queue.
  
 Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */


/*
					SOLUTION
1. Arrange all the person based on the heights sorted in decreasing order and if two or more person has same hen compare their K values in assending order.
2. heights then compare their K values in assending order i.e. then add people[i] to its k value


Insert one by one based on K value in the queue
Example 1
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Step1:
Sort based on height and K value.
[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]

Step2:
Now we construct the queue using the sorted person list .
1. Add [7, 0] at 0 --> [[7,0]]
2. Add [7, 1] at 1 --> [[7,0], [7,1]]
3. Add [6, 1] at 1 --> [[7,0], [6, 1, [7,1]]
4. Add  [5,0] at 0 --> [[5,0], [7,0], [6, 1], [7,1]]
5. Add [5, 2] at 2 --> [[5,0], [7,0], [5, 2], [6, 1], [7,1]]
*/
import java.util.*;
public class QueueConstructionByHeight 
{
	int[][] reconstructQueue(int[][] people) 
    {
        //Step1:
        Arrays.sort(people,new Comparator<int[]>()
        {
            public int compare(int a1[],int a2[])
            {
                if(a1[0]!=a2[0])   //for decending order 
                {
                  return a2[0]-a1[0]; //alaways minus first from second
                }
                else
                {
                   return a1[1]-a2[1];// for ascending minus second from first
                }
            }
            
        });
        
        //Step 2:
        ArrayList<int[]> arr=new ArrayList<>();
        for(int i=0;i<people.length;i++)
        {
            arr.add(people[i][1],people[i]);
        }
        for(int i=0;i<arr.size();i++)
        {
            people[i]=arr.get(i);
        }
       return people;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		QueueConstructionByHeight q=new QueueConstructionByHeight();
		int people[][]= {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		people=q.reconstructQueue(people);
		for(int i=0;i<people.length;i++)
		{
			for(int j=0;j<people[i].length;j++)
			{
				System.out.print(people[i][j]+" ");
			}
			System.out.println();
		}

	}

}
