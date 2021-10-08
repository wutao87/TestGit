package dynamicProgramming;

public class UpStep {
	public static void main(String[] args) {
		long startTime_1 = System.nanoTime();
		System.out.print(UpStep_1(10));//n=10时，有89种走法
		long endTime_1 = System.nanoTime();
		System.out.println("\n用时："+(endTime_1 - startTime_1)+"ns");
		
		long startTime_2 = System.nanoTime();
		System.out.print(UpStep_1(10));
		long endTime_2 = System.nanoTime();
		System.out.println("\n用时："+(endTime_2 - startTime_2)+"ns");
	}
	
	public static int UpStep_1(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		return UpStep_1(n-1)+UpStep_1(n-2);
	}
	
	public static int UpStep_2(int n) {
		int d[]=new int [n+1];
		d[1]=1;
		for(int i=2;i<=n;i++) {
			d[i]=d[i-1]+d[i-2];
		}
		return d[n];
	}
}
