package quickSort;


public class trackBack {
	int num=0;
	
	public static void main(String []args) {
		trackBack e=new trackBack();
		int arr[]= {1,2,2};
		int k=0;
		e.trackBack(arr, k);
		System.out.print("ÅÅĞòÊıÁ¿£º"+e.num);
	}

	public void trackBack(int arr[], int k) {
		if(k==arr.length-1) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
			num++;
		}
		for(int i=k;i<arr.length;i++) {
			int K=arr[i];
			arr[i]=arr[k];
			arr[k]=K;
			trackBack(arr, k+1);
			K=arr[i];
			arr[i]=arr[k];
			arr[k]=K;
		}		
	}
}
