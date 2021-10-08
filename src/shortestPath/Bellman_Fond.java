package shortestPath;

import java.util.Arrays;

public class Bellman_Fond {
	static class Edge implements Comparable<Edge>{
		public int start, end, weight;
		Edge(int start, int end, int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
		@Override
		public int compareTo(Edge edge) {//比较器，指定Arrays.sort(E)按照w大小进行排序
			//if(this.weight==edge.weight) return 0;
			//else if(this.weight<edge.weight) return -1;
			//else return 1;
			return this.weight - edge.weight;//以上三行的总结，一句顶三句
		}
	}
	
	public static void main(String []args) {
		Edge w[]= new Edge[5];//边
		/*w[0]=new Edge(0, 1, -4);//存在负环
		w[1]=new Edge(1, 2, 1);
		w[2]=new Edge(2, 0, 1);
		w[3]=new Edge(2, 3, 1);
		w[4]=new Edge(1, 3, 1);
		*/
		w[0]=new Edge(0, 1, 1);
		w[1]=new Edge(0, 2, 3);
		w[2]=new Edge(0, 3, -4);
		w[3]=new Edge(1, 2, -2);
		w[4]=new Edge(2, 3, 5);
		int d[]= new int [4];//节点间距
		int start=0;  
		Bellman_Fond (d, w, start);
	}
	
	public static void Bellman_Fond (int d[] ,Edge w[], int start) {
		Arrays.sort(w);//改变边的顺序对结果并无大的影响
		int max=w[w.length-1].weight;
		for(int i=0;i<d.length;i++)
			d[i]=Integer.MAX_VALUE-max;//初始化距离，此处不能用d[i]=Integer.MAX_VALUE，否则当start！=0时会使d[w[j].start]+w[j].weight溢出使得d[i]变成负数导致出错
		d[start]=0;
		for(int i=0;i<d.length-1;i++) {//迭代次数：d.length-1
			for(int j=0;j<w.length;j++)
				if(d[w[j].end]>d[w[j].start]+w[j].weight) 
					d[w[j].end]=d[w[j].start]+w[j].weight;
		}
		int p=1;
		for(int i=0;i<d.length;i++) 
			if(d[w[i].end]>d[w[i].start]+w[i].weight) {
				p=0;
				break;
			}		
		if(p!=0)
			for(int i=0;i<d.length;i++)
				System.out.print(d[i]+" ");
		else 
			System.out.print("存在负环，没有最短距离");
	}
}
