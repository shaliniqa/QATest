package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	 int capacity;
	 int count;
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		capacity=arraySize;
		numArray = new int[arraySize];
	}

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		for(int i=0;i<numArray.length;i++)
		{
			if(numArray[i]==searchingNum)
			{
				return i;
			}
		}
		return -1;
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
		if(search(numberToAdd)==-1)
		{
			if(numArray.length==capacity)
			{
				doubleCapacity();
			}
			numArray[count]=numberToAdd;
			count++;
			return true;
		}
		return false;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		capacity=capacity*2;
			int [] numArrayClone=new int[capacity];
			for(int i=0;i<=count;i++)
			{
				numArrayClone[i]=numArray[i];
			}
			numArray=numArrayClone;
			
		
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		if(search(numberToRemove)!=-1)
		{
			int index=search(numberToRemove);
			for(int i=index+1;i<numArray.length;i++)
			{
				numArray[i-1]=numArray[i];
			}
			int [] numArrayClone=new int[numArray.length-1];
			for(int i=0;i<numArray.length-1;i++)
			{
				numArrayClone[i]=numArray[i];
			}
			numArray=numArrayClone;
			count--;
			return true;
		}
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return count;
		
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		int []temp=new int[n];
		for(int i=0;i<n;i++)
		{
			temp[i]=numArray[i];
		}
		for(int i=n;i<numArray.length;i++)
		{
			numArray[i-n]=numArray[i];
		}
		int c=0;
		for(int i=numArray.length-n;i<numArray.length;i++)
		{
			numArray[i]=temp[c];
			c++;
		}
		
		return numArray;
	}
	public String toString()
	{
		StringBuilder builder=new StringBuilder();
		builder.append('{');
		for(int i=0;i<numArray.length;i++)
		{
			builder.append(numArray[i]);
			if(i!=numArray.length-1)
			{
				builder.append(',');
			}
			
		}
		builder.append('}');
		String str=builder.toString();
		return str;
	}
	

}
