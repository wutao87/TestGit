package shortestPath;

import java.util.*;


public class SPFA {//节点用字符串表示（未完成）
	static class edge{
		char start, end;
		int weight;
		edge(char start, char end, int weight){
			this.start=start;
			this.end=end;
			this.weight=weight;
		}
	}
	public static void main(String[] args) {
		/*
		
		list.add(1);
		list.add(3);
		list.add(2);
		list.remove(1);
		System.out.print(list.get(0));*/
		char edge[]= {'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		edge e[]=new edge [12];
		e[0]=new edge('a', 'b', 24);
		e[1]=new edge('a', 'c', 8);
		e[2]=new edge('a', 'd', 15);
		e[3]=new edge('b', 'e', 6);
		e[4]=new edge('c', 'e', 7);
		e[5]=new edge('d', 'g', 4);
		e[6]=new edge('e', 'g', 9);
		e[7]=new edge('f', 'e', 2);
		e[8]=new edge('c', 'f', 3);
		e[9]=new edge('f', 'd', 5);
		e[10]=new edge('f', 'g', 3);
		e[11]=new edge('g', 'b', 3);
		int start=0;
		SPFA(e, edge, start);
	}
	
	public static void SPFA(edge e[], char edge[], int start) {
		ArrayList<Character> list = new ArrayList<Character>();
		int d[]=new int [edge.length];
		for(int i=0;i<d.length;i++) 
			d[i]=Integer.MAX_VALUE-100;
		d[start]=0;
		list.add(edge[start]);
		while(list.size()>0) {
			list.remove(edge[start]);
			for(int i=0;i<e.length;i++) {
				if(e[i].start==edge[start]) {
					//if(d[e[i].]>)
				}
			}
		}
	}

}
