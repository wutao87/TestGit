package shortestPath;


public class Floyd {
	public static void main(String[] args) {
		int MAX=Integer.MAX_VALUE-100;
		int e[][]= {
				{0, 2, 6, 4},
				{MAX, 0, 3, MAX},
				{7, MAX, 0, 1},
				{5, MAX, 12, 0}
		};
		Floyd(e);
		int d[][] = Floyd_1(e);
		for(int i=0;i<d.length;i++){
			for(int j=0;j<d.length;j++) 
				System.out.print(d[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void Floyd(int e[][]) {
		for(int k=0;k<e.length;k++) 
			for(int i=0;i<e.length;i++) 
				for(int j=0;j<e.length;j++) 
					if(e[i][j]>e[i][k]+e[k][j]&&i!=j&&i!=k&&j!=k)
						e[i][j]=e[i][k]+e[k][j];
		for(int i=0;i<e.length;i++){
			for(int j=0;j<e.length;j++) 
				System.out.print(e[i][j]+" ");
			System.out.println();
		}		
	}
	
	public static int [][] Floyd_1(int e[][]){
		for(int k=0;k<e.length;k++) 
			for(int i=0;i<e.length;i++) 
				for(int j=0;j<e.length;j++) 
					if(e[i][j]>e[i][k]+e[k][j]&&i!=j&&i!=k&&j!=k)
						e[i][j]=e[i][k]+e[k][j];
		return e;
	}
}
