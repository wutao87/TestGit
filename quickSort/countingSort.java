package quickSort;

public class countingSort {
	public static void main(String[] args) {
		long startTime=System.nanoTime();
		int []arr= {6, 9, 1, 4, 5, 8, 7, 0, 2, 3, 100};
		countingSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		long endTime=System.nanoTime();
		System.out.println("\nÓÃÊ±£º"+(endTime - startTime)+"ns");
	}
	
	public static void countingSort(int []arr){
		int min=arr[0],max=arr[0];
		for(int i:arr){
			if(i<min)
				min=i;
			if(i>max)
				max=i;
		}
		int a[]=new int[max-min+1];
		int k[]=new int[max-min+1];
		for(int i=0;i<arr.length;i++) {
			a[i]=min+i;
			k[i]=0;
			for(int j=0;j<arr.length;j++) {
				if(arr[j]==a[i])
					k[i]++;
			}
		}
		int K=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<k[i];j++) {
				arr[K]=a[i];
				K++;
			}
		}
	}
}
