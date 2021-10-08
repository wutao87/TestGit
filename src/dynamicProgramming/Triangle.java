package dynamicProgramming;


public class Triangle {
	public static void main(String args[]) {
		int D[][]= {{7}, {4, 5}, {1, 4, 9}, {2, 3, 4, 5}, {1,2,3,4,5}};
		long startTime_1 = System.nanoTime();
		System.out.print(Triangle_1(D,0,0));
		long endTime_1 = System.nanoTime();
		System.out.println("\n用时："+(endTime_1 - startTime_1)+"ns");
		
		long startTime_2 = System.nanoTime();
		System.out.print(Triangle_2(D));
		long endTime_2 = System.nanoTime();
		System.out.println("\n用时："+(endTime_2 - startTime_2)+"ns");
	}
	
	public static int Triangle_1(int D[][], int i, int j) {
		if(i==D.length-1)
			return D[i][j];
		return Math.max(Triangle_1(D, i+1, j), Triangle_1(D, i+1, j+1))+D[i][j];
	}
	
	public static int Triangle_2(int D[][]) {
		int n=D[D.length-1].length;
		int sum[][]=new int [n+1][n+1];
		for(int i=n-1;i>=0;i--) 
			for(int j=D[i].length-1;j>=0;j--)
				sum[i][j]=Math.max(sum[i+1][j], sum[i+1][j+1])+D[i][j];
		return sum[0][0];
	}
}
