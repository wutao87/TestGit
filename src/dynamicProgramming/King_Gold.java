package dynamicProgramming;


public class King_Gold {//��̬�滮��ʱ��ȷ�ȵݹ��㷨��
	public static void main(String[] args) {
		int[] gold = {400, 500, 200, 300, 350};
        int[] people = {5, 5, 3, 4, 3};
		
        long startTime_1 = System.nanoTime();
        System.out.println(getMostGold_1(5, 10, gold, people));
        long endTime_1 = System.nanoTime();
		System.out.println("�ݹ��㷨(��ʱ)��"+(endTime_1 - startTime_1)+"ns");
		
		long startTime_2 = System.nanoTime();
        System.out.println(getMostGold_2(5, 10, gold, people));
        long endTime_2 = System.nanoTime();
		System.out.println("��̬�滮(��ʱ)��"+(endTime_2 - startTime_2)+"ns");
    }
	
    public static int getMostGold_1(int n, int worker, int[] g, int[] p) {//�ݹ��㷨
        if(n==1&&worker<p[0])
            return 0;
        if(n==1&&worker>=p[0])
            return g[0];
        if(n>1&&worker<p[n - 1])
            return getMostGold_1(n - 1, worker, g, p);
        //if(n>1&&worker>=p[n-1])//����if����ϵͳ�ڲ��������ĸ�if����ʱ��û��returnֵ�ˣ���public static int������һ��returnֵ���ʻᱨ��
           // return Math.max(getMostGold(n - 1, worker, g, p), (getMostGold(n - 1, worker - p[n - 1], g, p) + g[n - 1]));
        return Math.max(getMostGold_1(n - 1, worker, g, p), (getMostGold_1(n - 1, worker - p[n - 1], g, p) + g[n - 1]));
    }
    
    public static int getMostGold_2(int n,int w,int []g,int[] p){//��̬�滮
        int[] F = new int[w + 1];
        for (int i=n;i>0;i--) 
            for (int j = w; j > 0; j--) 
                if (j>=p[i - 1]) 
                    F[j] = Math.max(F[j], F[j - p[i - 1]] + g[i - 1]);
        return F[w];
	}
}

