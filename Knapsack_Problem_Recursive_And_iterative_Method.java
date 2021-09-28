import java.util.*;
public class Knapsack_Recursive {
	static int knapsack(int[] wt,int[] pf,int w,int N) {
		if(w==0 || N==0 ) {
			return 0;
		}
		else if(wt[N]>w) {
			return knapsack(wt,pf,w,N-1);
		}
		else {
			return Math.max(pf[N]+knapsack(wt,pf,w-wt[N],N-1), knapsack(wt,pf,w,N-1));
		}
	}
    static int knapsack_iterative(int[] wt,int[] pf,int w,int N) {
    	int[][] mat=new int[N+1][w+1];
    	
    	for(int c=0;c<N+1;c++) {
    		mat[c][0]=0;
    	}
    	for(int r=0;r<w+1;r++) {
    		mat[0][r]=0;
    	}
    	
    	for(int item=1;item<=N;item++) {
    		for(int capacity=1;capacity<=w;capacity++) {
    			int maxPfwithoutCurrwt=mat[item-1][capacity];
    			int maxPfwithcurrwt=0;
    	        int wtofcurr=wt[item-1];
    			if(capacity>=wtofcurr) {
    				maxPfwithcurrwt=pf[item-1];
    				
    				int remainingwt=capacity-wtofcurr;
    				maxPfwithcurrwt += mat[item-1][remainingwt];
    				
    			}
    			 
    			mat[item][capacity]=Math.max(maxPfwithcurrwt, maxPfwithoutCurrwt);
    			
    		} 
    		
    		
    	}
    	 System.out.println(Arrays.deepToString(mat));
         
         return mat[N][w];
 		
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the capacity of bag :");
		int w=sc.nextInt();
		System.out.println("Enter the number of items: ");
		int n=sc.nextInt();
		int wt[]=new int[n];
		int pf[]=new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("Enter the weight for item "+i+":");
			wt[i]=sc.nextInt();
			System.out.println("Enter the profit for the given weights :");
			pf[i]=sc.nextInt();
			
		}
		
		int max=knapsack(wt,pf,w,n-1);
		int Max=knapsack_iterative(wt, pf, w, n);
		System.out.println("maximum profit is :"+Max);
        System.out.println("maximum profit is :"+max);
	}

}
