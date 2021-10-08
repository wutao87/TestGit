package quickSort;

public class quickSort {
	public static void main(String[] args) {
		long startTime = System.nanoTime();//测时间：currentTimeMillis表示毫秒，nanoTime表示纳秒
		int[] arr= {6, 9, 1, 4, 5, 8, 7, 0, 2, 3, 100};
		int right=arr.length-1;
		quickSort(arr, 0, right);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		long endTime = System.nanoTime();//测时间
		System.out.println("\n用时："+(endTime - startTime)+"ns");
	}
	public static void quickSort(int[] arr, int left, int right) {
		if(right==left)
			return;
		int key=arr[left];
		int high=right;
		int low=left;
		while(left<right) {
			while(arr[right]>key&&left<right) {
				right--;
			}
			arr[left]=arr[right];
			left++;
			while(arr[left]<key&&left<right) {
				left++;
			}
			arr[right]=arr[left];
			right--;
		}
		arr[left]=key;
		quickSort(arr, low, left-1);
		quickSort(arr, right+1, high);
	}
}
