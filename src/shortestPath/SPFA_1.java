package shortestPath;

import java.util.*;

public class SPFA_1 {//节点用数字表示
	static class edge_1{
		int start;
		int end;
		int weight;
		edge_1(int start, int end, int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
	}
	
	public static void main(String[] args) {
		edge_1  e[]=new edge_1 [12];
		/*e[0]=new edge_1 (0, 1, -4);//存在负环
		e[1]=new edge_1(1, 2, 1);
		e[2]=new edge_1(2, 0, 1);
		e[3]=new edge_1(2, 3, 6);*/
		e[0]=new edge_1 (0, 1, 24);
		e[1]=new edge_1(0, 2, 8);
		e[2]=new edge_1(0, 3, 15);
		e[3]=new edge_1(1, 4, 6);
		e[4]=new edge_1(2, 4, 7);
		e[5]=new edge_1(3, 6, 4);
		e[6]=new edge_1(4, 6, 9);
		e[7]=new edge_1(5, 4, 2);
		e[8]=new edge_1(2, 5, 3);
		e[9]=new edge_1(5, 3, 5);
		e[10]=new edge_1(5, 6, 3);
		e[11]=new edge_1(6, 1, 3);
		int start=0;
		SPFA_1(e, start);
	}
	
	public static void SPFA_1(edge_1 e[], int start) {
		ArrayList<Integer> X = new ArrayList<Integer>();
		int r[]=new int [7];//计算每个节点进入队列的次数
		int d[]=new int [7];//节点间距
		for(int i=0;i<d.length;i++) 
			d[i]=Integer.MAX_VALUE-100;
		d[start]=0;
		X.add(start);
		int p=1;
		while(X.size()>0) {
			X.remove(0);
			for(int i=0;i<e.length;i++) 
				if(e[i].start==start) 
					if(d[e[i].end]>d[e[i].start]+e[i].weight) {
						d[e[i].end]=d[e[i].start]+e[i].weight;
						X.add(e[i].end);
						r[e[i].end]++;
						if(r[e[i].end]>d.length) //判断，如果节点进队的次数
							p=0;
					}
			if(p==0) {
				System.out.print("存在负环，没有最短距离");
				break;
			}
			if(X.size()==0)
				break;
			start=X.get(0);
		}
		if(p!=0)
			for(int i=0;i<d.length;i++) 
				System.out.print(d[i]+" ");
	}
}
