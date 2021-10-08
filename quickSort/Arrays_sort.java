package quickSort;

import java.util.Arrays;

public class Arrays_sort {
	public static void main(String args[]) {
		long startTime = System.nanoTime();
		int  arr[]= {6, 9, 1, 4, 5, 8, 7, 0, 2, 3, 100};
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		long endTime = System.nanoTime();
		System.out.println("\nÓÃÊ±£º"+(endTime - startTime)+"ns");
	}
}
