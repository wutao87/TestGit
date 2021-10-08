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
		public int compareTo(Edge edge) {//�Ƚ�����ָ��Arrays.sort(E)����w��С��������
			//if(this.weight==edge.weight) return 0;
			//else if(this.weight<edge.weight) return -1;
			//else return 1;
			return this.weight - edge.weight;//�������е��ܽᣬһ�䶥����
		}
	}
	
	public static void main(String []args) {
		Edge w[]= new Edge[5];//��
		/*w[0]=new Edge(0, 1, -4);//���ڸ���
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
		int d[]= new int [4];//�ڵ���
		int start=0;  
		Bellman_Fond (d, w, start);
	}
	
	public static void Bellman_Fond (int d[] ,Edge w[], int start) {
		Arrays.sort(w);//�ı�ߵ�˳��Խ�����޴��Ӱ��
		int max=w[w.length-1].weight;
		for(int i=0;i<d.length;i++)
			d[i]=Integer.MAX_VALUE-max;//��ʼ�����룬�˴�������d[i]=Integer.MAX_VALUE������start��=0ʱ��ʹd[w[j].start]+w[j].weight���ʹ��d[i]��ɸ������³���
		d[start]=0;
		for(int i=0;i<d.length-1;i++) {//����������d.length-1
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
			System.out.print("���ڸ�����û����̾���");
	}
}
