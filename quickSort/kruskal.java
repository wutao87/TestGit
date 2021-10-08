package quickSort;

import java.util.*;

public class kruskal {
	static class Edge implements Comparable<Edge>
	{
        public int start, end, weight;
        Edge(int start,int end,int weight)
        {
        	this.start=start;
        	this.end=end;
        	this.weight=weight;
        }
		@Override
		public int compareTo(Edge edge) {//比较器，指定Arrays.sort(E)按照w大小进行排序
			//if(this.weight==edge.weight) return 0;
			//else if(this.weight<edge.weight) return -1;
			//else return 1;
			return this.weight - edge.weight;//这一句相当于上面三句
		}
	}
	 public static void main(String [] args){ 
	        int [] V={1,2,3,4,5,6};  
	        Edge [] E=new Edge[10];  
	        E[0]=new Edge(1,2,6);  
	        E[1]=new Edge(1,3,1);  
	        E[2]=new Edge(1,4,5);  
	        E[3]=new Edge(2,3,5);  
	        E[4]=new Edge(2,5,3);  
	        E[5]=new Edge(3,4,5);  
	        E[6]=new Edge(3,5,6);  
	        E[7]=new Edge(3,6,4);  
	        E[8]=new Edge(4,6,2);  
	        E[9]=new Edge(5,6,6);  
	        kruskal(V, E);  
	        LinkedList<Edge> edge = k(V, E);
	        while(!edge.isEmpty()) {
	        	Edge nEdge = edge.poll();
	        	System.out.println(nEdge.start+"—>"+nEdge.end+" "+nEdge.weight);
	        }
	        	
	        //System.out.print(k(V, E));
	   }  
	  public static LinkedList<Edge> k(int []V, Edge E[]){
		  Arrays.sort(E);
		  LinkedList<Edge> res = new LinkedList<>();
		  int []flag = new int[V.length+1];
		  for(int i=1; i<=V.length; i++) flag[i] = i;
		  for(int i=0; i<E.length; i++) {
			  if(!res.contains(E[i]) && flag[E[i].start] != flag[E[i].end]) {
				  res.add(E[i]);
				  int p = flag[E[i].start];
				  for(int j=1; j<=V.length; j++) {
					  if(flag[j]==p)//如果用flag[i]==flag[E[i].start]进行判断，在循环过程中后者的值会发生改变，之后的判断就会变成flag[i]==flag[E[i].end]
						  flag[j] = flag[E[i].end];
				  }
			  }
		  }
		  return res;
	  }
	  public static void  kruskal(int [] V,Edge [] E) {
		  Arrays.sort(E);//排序条件：implements Comparable<Edge>
		  ArrayList<HashSet<Integer>> list=new ArrayList<HashSet<Integer>>();
		  for(int i=0;i<V.length;i++) {//将所有节点以哈希表的形式装进链表
			  HashSet<Integer> set0= new HashSet<Integer>();
			  set0.add(V[i]);
			  list.add(set0);
		  }
		  
		  HashSet<Integer> set= new HashSet<Integer>();
		  int p1=-1,p2=-1;
		  for(int i=0;i<E.length;i++) {
			  for(int j=0;j<list.size();j++) {
				  set=list.get(j);
				  if(set.contains(E[i].start))
					  p1=j;
				  if(set.contains(E[i].end)) 
					  p2=j; 
			  }
			  if(p1 != p2) {
				  HashSet<Integer> set1= list.get(p1);
				  HashSet<Integer> set2= list.get(p2);
				  set1.addAll(set2);
				  if(p1<=p2) {
					  list.remove(p1);
					  list.remove(p2-1);
				  }
				  if(p1>p2) {
					  list.remove(p2);
					  list.remove(p1-1);
				  }
				  list.add(set1);
				  System.out.println(E[i].start+" —> "+E[i].end+" "+E[i].weight);
			  }
		  }
	  }
}