package quickSort;

public class mergeSork {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int []arr= {6, 9, 1, 4, 5, 8, 7, 0, 2, 3, 100};
		int right=arr.length-1;
		mergeSork(arr, 0, right);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		long endTime = System.nanoTime();
		System.out.println("\nÓÃÊ±£º"+(endTime - startTime)+"ns");
	}
	
	public static void mergeSork(int []arr, int left, int right){
		if(right==left) {
			return;
		}
		int mid=(left+right)/2;
		mergeSork(arr, left, mid);
		mergeSork(arr, mid+1, right);
			
		int []a=new int[arr.length];
		int k=left;
		int p1=left;
		int p2=mid+1;
		while(p1<=mid&&p2<=right) {
			if(arr[p1]<arr[p2])
				a[k++]=arr[p1++];
			else 
				a[k++]=arr[p2++];
		}
		while(p1<=mid) 
			a[k++]=arr[p1++];
		while(p2<=right) 
			a[k++]=arr[p2++];
		for (int i = left; i <= right; i++) {
			arr[i]=a[i];
		}
	}
}
