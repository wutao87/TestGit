package quickSort;

public class trackBack_Cut {//	ȫ���У�����+��֦
    int num=0;
	
	public static void main(String []args) {
		trackBack_Cut e=new trackBack_Cut();
		int arr[]= {1,2,2};
		int k=0;
		e.trackBack_Cut(arr, k);
		System.out.print("����������"+e.num);
	}

	public void trackBack_Cut(int arr[], int k) {
		if(k==arr.length-1) {
			for(int j=0;j<arr.length;j++) 
				System.out.print(arr[j]+" ");
			System.out.println();
			num++;
		}
		for(int i=k;i<arr.length;i++) {
		    boolean p=true;
			for(int j=i+1;j<arr.length;j++) {//��֦�����ͬһ��ȣ�iԪ�غ�������i��ͬ��ֵ�����֦�������ôεݹ�
		    	if(arr[j]==arr[i]) {
		    		p=false;
		    		break;
		    	}
		    }
			if(p) {
				int K=arr[i];
				arr[i]=arr[k];
				arr[k]=K;
				trackBack_Cut(arr, k+1);
				K=arr[i];
				arr[i]=arr[k];
				arr[k]=K;
			}
		}		
	}
}
