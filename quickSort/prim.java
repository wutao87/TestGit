package quickSort;

import java.util.*;

public class prim {
	static class Edge1 implements Comparable<Edge1>
	{
        public int start, end, weight;
        Edge1(int start,int end,int weight)
        {
        	this.start=start;
        	this.end=end;
        	this.weight=weight;
        }
		@Override
		public int compareTo(Edge1 edge) {//指定Arrays.sort(E)按照w大小进行排序
			if(this.weight==edge.weight) return 0;
			else if(this.weight<edge.weight) return -1;
			else return 1;
		}
	}
	
	public static void main(String [] args){ 
        int [] V={1,2,3,4,5,6};  
        Edge1 [] E=new Edge1[10];  
        E[0]=new Edge1(1,2,6);  
        E[1]=new Edge1(1,3,1);  
        E[2]=new Edge1(1,4,5);  
        E[3]=new Edge1(2,3,5);  
        E[4]=new Edge1(2,5,3);  
        E[5]=new Edge1(3,4,5);  
        E[6]=new Edge1(3,5,6);  
        E[7]=new Edge1(3,6,4);  
        E[8]=new Edge1(4,6,2);  
        E[9]=new Edge1(5,6,6);  
        prim(V, E);  
    }  
	
	public static void prim(int [] V,Edge1 [] E) {
		Arrays.sort(E);
		int k=0;//记录已找到的路径数
		HashSet<Integer> set= new HashSet<Integer>();//树：用ArrayList<Integer> set也可以
		set.add(E[0].start);
		set.add(E[0].end);
		System.out.println(E[0].start+" —> "+E[0].end+" "+E[0].weight);
		
		while(k<V.length) {//最小生成树的路径数为V.length-1
			for(int i=1;i<E.length;i++) {
				if(set.contains(E[i].start)==true&&set.contains(E[i].end)==false) {
					set.add(E[i].end);
					System.out.println(E[i].start+" —> "+E[i].end+" "+E[i].weight);
					break;
				}		
				if(set.contains(E[i].start)==false&&set.contains(E[i].end)==true) {
					set.add(E[i].start);
					System.out.println(E[i].end+" —> "+E[i].start+" "+E[i].weight);
					break;
				}
			}
			k++;
		}
	}
}
