package dynamicProgramming;

public class LeastCoins {
	public static void main(String args[]) {
		int coin[]= {1, 2, 5};
		int money=20;
		long startTime_1 = System.nanoTime();
		System.out.print(LeastCoins_1(coin, money));
		long endTime_1 = System.nanoTime();
		System.out.println("\n用时："+(endTime_1 - startTime_1)+"ns");
		
		long startTime_2 = System.nanoTime();
		System.out.print(LeastCoins_2(coin, money));
		long endTime_2 = System.nanoTime();
		System.out.println("\n用时："+(endTime_2 - startTime_2)+"ns");
	}

	public static int min(int a, int b, int c) {
		int min=a;
		if(a>b)
			min=b;
		if(c<min)
			min=c;
		return min;
	}
	
	public static int LeastCoins_1(int coin[], int amount){
		if(amount==1)
			return 1;
		if(amount==2)
			return 1;
		if(amount==5)
			return 1;
		if(amount<5&&amount>1)
			return 1+Math.min(LeastCoins_1(coin, amount-coin[0]), LeastCoins_1(coin, amount-coin[1]));
		return 1+min(LeastCoins_1(coin, amount-coin[0]), LeastCoins_1(coin, amount-coin[1]), LeastCoins_1(coin, amount-coin[2]));
	}
	
	public static int LeastCoins_2(int coin[], int money) {
		int amount[]=new int[money+1];
		for(int i=0;i<=money;i++)//初始化money由1块硬币组成
			amount[i]=i;
		for(int i=1;i<=money;i++) 
			for(int j=0;j<coin.length;j++) 
				if(i>=coin[j])
					amount[i]=Math.min(amount[i], amount[i-coin[j]]+1);
		return amount[money];
	}
}
