package hw06;

public class AList2 implements EList 
{
	private int[] ar={};
	private final int FULL=30;
	private int start, end, length, d;


	public AList2()
	{
	}

	public AList2(int[] ini)
	{
		init(ini);
	}

	@Override
	public void init(int[] ini)
	{	
		if (ini==null)
			ini = new int[0];

		int[] tmp = new int[FULL];
		length = ini.length;

		if (length%2==0) d=1; else d=0;

		start = FULL/2-length/2;
		end = FULL/2+length/2-d;

		for (int i=start; i<=end; i++)
		{
			tmp[i]=ini[i-start];
		}
		ar=tmp;
	}

	public void print()
	{
		if (length<0)
			throw new IllegalArgumentException();

		if (length==0) System.out.println("{}");
		for (int i=start; i<=end; i++) 
		{
			if (i<start+length-1) System.out.print(ar[i]+", ");
			else System.out.print(ar[i]);
		}
		System.out.println();
	}
	@Override
	public int size()
	{
		if (length<0)
			throw new IllegalArgumentException();

		return length;
	}

	@Override
	public void clear()
	{
		ar = new int[0];
		length=0;
	}

	@Override
	public int[] toArray()
	{	
		int[] tmp;
		if (length==0) 
		{
			tmp = new int[0];
		} 
		else
		{
			tmp = new int[length];
			for (int i=start; i<=end; i++)
			{
				tmp[i-start]=ar[i]; 
			}
		}
		return tmp;
	}

	@Override
	public String toString()
	{	
		if (length>FULL || length<0) 
			throw new IllegalArgumentException();

		String str="{";
		for (int i=start; i<=end; i++)
		{
			str+=i<start+length-1? ar[i]+ ", ": ar[i];
		}
		str+="}";
		if (length==0)
			str="{}";
		return str;
	}

	@Override
	public void addStart(int val)
	{ 
		if (length>=FULL || length<0) 
			throw new IllegalArgumentException();

		length++;
		start--;
		ar[start]=val; 
	}

	@Override
	public void addEnd(int val)
	{
		if (length>=FULL || length<0) 
			throw new IllegalArgumentException();

		length++;
		end++;
		ar[end]=val;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (length>=FULL || length<0 || pos>length || pos<0) 
			throw new IllegalArgumentException();

		//if (length%2==0) end++; else start--;
		length++;
		end++;
		for (int i=end+1; i>=start; i--)
		{
			ar[i]=i<start+pos? ar[i]: ar[i-1];
		}
		ar[start+pos]=val;

		if (length==0) ar[start+pos]=val; 
	}

	@Override
	public int delStart()
	{ 
		if (length==0 )
			throw new IllegalArgumentException();

		length--;
		start++;
		return ar[start-1];
	}

	@Override
	public int delEnd()
	{ 
		if (length==0)
			throw new IllegalArgumentException();

		length--;
		end--;
		return ar[end+1];
	}

	@Override
	public int delPos(int pos)
	{
		if (length==0 || pos>length || pos<0)
			throw new IllegalArgumentException();

		length--;
		end--;
		int val=ar[start+pos];
		for (int i=start; i<=end; i++)
		{
			ar[i]=i<start+pos? ar[i]: ar[i+1];
		}
		return val;
	}

	@Override
	public void set(int pos, int val)
	{
		if (length==0 || pos>length || pos<0)
			throw new IllegalArgumentException();

		ar[start+pos]=val;
	}

	@Override
	public int get(int pos)
	{
		if (length==0 || pos>length || pos<0)
			throw new IllegalArgumentException();

		return ar[start+pos];
	}

	@Override
	public int minElem()
	{
		if (length==0)
			throw new NegativeArraySizeException();

		int min=ar[start];
		for (int i=start+1; i<=end; i++)
		{
			min=min>ar[i]? ar[i]: min;
		}	
		return min;
	}

	@Override
	public int maxElem()
	{
		if (length==0)
			throw new NegativeArraySizeException();

		int max=ar[start];
		for (int i=start+1; i<=end; i++)
		{
			max=max<ar[i]? ar[i]: max;
		}	
		return max;
	}

	@Override
	public int minInd()
	{
		if (length==0)
			throw new NegativeArraySizeException();

		int indexMin=start;
		for (int i=start+1; i<=end; i++)
		{
			indexMin=ar[indexMin]>ar[i]? i: indexMin;
		}
		return indexMin-start;
	}

	@Override
	public int maxInd()
	{
		if (length==0)
			throw new NegativeArraySizeException();

		int indexMax=start;
		for (int i=start+1; i<=end; i++)
		{
			indexMax=ar[indexMax]<ar[i]? i: indexMax;
		}
		return indexMax-start;
	}

	@Override
	public void reverse()
	{
		if (length>0)
		{
			int tmp=0;
			for (int i=start; i<=end-length/2; i++) 
			{
				tmp=ar[i];
				ar[i]=ar[end+start-i];
				ar[end+start-i]=tmp;
			}
		}
		else return;
	}		

	@Override
	public void reverseHalf()
	{
		if (length>0)
		{
			int d = (length%2==0) ? 0 : 1;
			for (int i=start; i<=end-length/2-d; i++) 
			{
				int tmp=ar[i];
				ar[i]=ar[length/2+i+d];
				ar[length/2+i+d]=tmp;
			}
		}
		else return;
	}

	@Override
	public void sort()
	{
		for(int i=start; i<end; i++)					
		{
			for(int j=start; j<end; j++)
			{
				if(ar[j]>ar[j+1])  
				{
					int tmp=ar[j+1];	 
					ar[j+1]=ar[j];
					ar[j]=tmp;
				}
			}
		}
	}
}
