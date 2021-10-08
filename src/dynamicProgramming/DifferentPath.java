package dynamicProgramming;


 public class DifferentPath {
	public static void main(String args[]) {
		long startTime_1 = System.nanoTime();
		System.out.print(DifferentPath_1(4, 5));
		long endTime_1 = System.nanoTime();
		System.out.println("\n用时："+(endTime_1 - startTime_1)+"ns");
		
		long startTime_2 = System.nanoTime();
		System.out.print(DifferentPath_2(4, 5));
		long endTime_2 = System.nanoTime();
		System.out.println("\n用时："+(endTime_2 - startTime_2)+"ns");
	}
	
	public static int DifferentPath_1(int i, int j) {
		if(i==1&&j==1)
			return 1;
		if(i==1&&j>1)
			return DifferentPath_1(i, j-1);
		if(j==1&&i>1)
			return DifferentPath_1(i-1, j);
		return DifferentPath_1(i-1, j)+DifferentPath_1(i, j-1);
	}
	
	public static int DifferentPath_2(int h, int l) {
		int d[][]=new int[h][l];
		for(int i=0;i<h;i++)
			for(int j=0;j<l;j++)
				d[i][j]=1;
		for(int i=1;i<h;i++) 
			for(int j=1;j<l;j++) 
				d[i][j]=d[i-1][j]+d[i][j-1];
		return d[h-1][l-1];
	}
}