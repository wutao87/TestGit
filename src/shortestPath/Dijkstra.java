package shortestPath;

import java.util.Arrays;

public class Dijkstra {//这个代码有问题
	public static void main(String[] args)
	{
		int MAX=Integer.MAX_VALUE;//记录int所能表示的最大值
		int[][] weight={
				{0,1,12,MAX,MAX,MAX},
                {MAX,0,9,3,MAX,MAX},
                {MAX,MAX,0,MAX,5,MAX},
                {MAX,MAX,4,0,13,15},
                {MAX,MAX,MAX,MAX,0,4},
                {MAX,MAX,MAX,MAX,MAX,0}				
		};		
		int[][] w={
				{0,1,2},
                {4,0,3},
                {4,6,0}			
		};	
		int start=0;  //选择出发点
		Dijkstra(w,start,MAX);
	}                                                                                                                                                                                                                                                                       

	public static void Dijkstra(int [][]heights, int start, int MAX){
		int path[]=new int [heights.length];
		for(int i=0;i<heights.length;i++) {
			path[i]=MAX;
		}
		path[start]=0;
		for(int i=0;i<heights.length;i++) {
			int w[]=new int [heights.length];
			for(int j=0;j<heights.length;j++)
				w[j]=heights[start][j];
			Arrays.sort(w);
			int min;
			for(int j=0;j<heights.length;j++) {
				if(w[j]>0&&w[j]!=MAX) {
					min=w[j];
					for(int k=0;k<heights.length;k++) {
						if(heights[start][k]==min) {					
							path[k]=path[start]+min;
							start=k;
							break;
						}
					}
					break;
				}
			}
			for(int i1=0;i1<heights.length;i1++) {
				System.out.print(path[i1]+" ");
			}
			System.out.println();
		}
	}
}
