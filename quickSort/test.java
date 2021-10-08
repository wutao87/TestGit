package quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//import com.sun.security.auth.NTDomainPrincipal;

import quickSort.kruskal.Edge;

public class test {
	static class Edge implements Comparable<Edge>
	{
        public int i,j,w;
        Edge(int i,int j,int w)
        {
        	this.i=i;
        	this.j=j;
        	this.w=w;
        }
		@Override
		public int compareTo(Edge edge) {//ָ��Arrays.sort(E)����w��С��������
			if(this.w==edge.w) return 0;
			else if(this.w<edge.w) return -1;
			else return 1;
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
	    }  
	  
	  public static void kruskal(int [] V,Edge [] E)
	  {
		  Arrays.sort(E);//����������implements Comparable<Edge>
		  int m=V.length;
		  int n=E.length;
		  //ÿ��set��ʾһ����,list��ʾɭ��
		  ArrayList<HashSet<Integer>> list=new ArrayList<HashSet<Integer>>();
		  ArrayList<Edge> edges=new ArrayList<Edge>();
		  //��ʼ��ÿ���㹹��һ����
		  for(int i=0;i<m;i++)
		  {
			  HashSet<Integer> set= new HashSet<Integer>();
			  set.add(V[i]);
			  list.add(set);
		  }
		  //ÿ�������γ���
		  for(int i=0;i<n;i++)
		  {
			  Edge edge=E[i];
			  int a=edge.i;
			  int b=edge.j;
			  int counta=-1;
			  int countb=-1;
			  //����Ҫ�ҵ������������ڵ���
			  for(int j=0;j<list.size();j++){
				  HashSet<Integer> set=list.get(j);
				  if(set.contains(a))
				  {
					  counta=j;
				  }
				  if(set.contains(b))
				  {
					  countb=j;
				  }
			  }
			  //û�ҵ���
			  if(counta==-1||countb==-1)
			  {
				  return;
			  }
			  else
			  {
				  //�����ڲ�ͬ����
				  if(counta!=countb)
				  {
					  HashSet<Integer> set1=list.get(counta);
					  HashSet<Integer> set2=list.get(countb);
					  set1.addAll(set2);
					  //ɾ�����ϵ�ʱ��Ҫע�⡣����ɾ����������
					  if(counta<countb){
					    list.remove(counta);
					    list.remove(countb-1);
					  }
					  else
					  {
						  list.remove(countb);
						  list.remove(counta-1);
					  }
					  list.add(set1);
					  edges.add(edge);
					  System.out.println("����"+edge.i+"--->"+edge.j+"���룬��ȨֵΪ"+edge.w);
				  }
				  else
				  {
					  System.out.println("���ܼ���"+edge.i+"--->"+edge.j+"������ͬһ������");
				  }
			  }
		  }
	  }
}
