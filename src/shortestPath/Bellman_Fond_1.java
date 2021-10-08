package shortestPath;

import java.util.Arrays;

import shortestPath.Bellman_Fond.Edge;

public class Bellman_Fond_1 {
	/*static class Edge_1{
		public int start, end, weight;
		Edge_1(int start, int end, int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
	}*/
	
	public static void main(String []args) {
		Edge w[]= new Edge[5];//边
		w[0]=new Edge(0, 1, 1);
		w[1]=new Edge(0, 2, 3);
		w[2]=new Edge(0, 3, -4);
		w[3]=new Edge(1, 2, -2);
		w[4]=new Edge(2, 3, 5);
		int d[]= new int [4];//节点间距
		int start=3;  
		Bellman_Fond (d, w, start);
	}
	
	public static void Bellman_Fond (int d[] ,Edge w[], int start) {
		Arrays.sort(w);
		int max=w[w.length-1].weight;
		for(int i=0;i<d.length;i++)
			d[i]=Integer.MAX_VALUE-max;
		d[start]=0;
		for(int i=0;i<d.length-1;i++) {//迭代次数：d.length-1
			for(int j=0;j<w.length;j++)
				if(d[w[j].end]>d[w[j].start]+w[j].weight) 
					d[w[j].end]=d[w[j].start]+w[j].weight;

		}
		for(int i=0;i<d.length;i++) {
			if(d[w[i].end]>d[w[i].start]+w[i].weight) {
				System.out.print("存在负环，没有最短距离");
				break;
			}
			else
				System.out.print(d[i]+" ");
		}
	}

}
