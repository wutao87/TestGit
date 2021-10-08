package quickSort;

public class trackBack_queen {//N皇后
	int num=0;
	int N=8;
	int x[]=new int [N];
	
	public void trackBack(int n) {
		if(n==N) {
			for(int i=0;i<N;i++) {
				System.out.print(x[i]+" ");
			}
			System.out.println();
			num++;
			return;
		}
		for(int i=0;i<N;i++) {
			x[n]=i;//n行i列
			boolean p=true;
			for(int j=0;j<n;j++) 
				if(x[j]==x[n]||Math.abs(j-n)==Math.abs(x[j]-x[n]))
					p=false;
			if(p)
				trackBack(n+1);
		}
	}
	
	public static void main(String[] args) {
		trackBack_queen e = new trackBack_queen();
		e.trackBack(0);
		System.out.println("解法种数： " + e.num);
	   }
}

//参考博客：https://blog.csdn.net/key_768/article/details/106355686?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param