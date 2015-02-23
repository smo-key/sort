package sort;

import java.util.Arrays;

public class quickSort {
	public static void main(String[] argv)
	{
		int[] tester = { 7, 4, 6, 1, 9, 0, 12 };
		System.out.println(Arrays.toString(sort(tester)));
		return;
	}
	public static int[] sort(int[] arr)
	{
		return sort(arr, 0, arr.length - 1);
	}
	
	public static int[] sort(int[] arr, int min, int max)
	{
		while (min < max)
		{
			int p = partition(arr, min, max);
			arr = sort(arr, min, p - 1);
			arr = sort(arr, p + 1, max);
		}
			
		return arr;
	}
	
	private static int partition(int[] arr, int min, int max)
	{
		int pivotIndex = choosePivot(min, max);
		int pivotValue = arr[pivotIndex];
		// put chosen point at arr[max]
		int k = arr[pivotIndex];
		arr[pivotIndex] = arr[max];
		arr[max] = k;
		int storeIndex = min;
		
		for(int i=min; i<max; i++)
		{
			if (arr[i] < pivotValue)
			{
				k = arr[i];
				arr[i] = arr[storeIndex];
				arr[storeIndex] = k;
				storeIndex++;
			}
		}
		k = arr[storeIndex];
		arr[storeIndex] = arr[max];
		arr[max] = k;
		
		return storeIndex; //return store index
	}
	private static int choosePivot(int min, int max)
	{
		return (int)Math.round(((double)min + (double)max) / 2) + 1;
	}
}