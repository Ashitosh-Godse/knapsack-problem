package leetcode;
import java.util.*;
class items{
	int weight,value;
	//float w;
	public items(int weight,int value) {
		this.value=value;
		//this.w=w;
		this.weight=weight;
	}
}
class itemsComparator implements Comparator<items>{

	@Override
	public int compare(items o1, items o2) {
		// TODO Auto-generated method stub
		double r1=(double)o1.value/(double)o1.weight;
		double r2=(double)o2.value/(double)o2.weight;
		if(r1<r2) return 1;
		else if(r1>r2) return -1;
		else return 0;
	}
	
}
public class KnapsackFractionalProblem {
    
	static double solve(int W,items[] items ) {
		Arrays.sort(items,new itemsComparator());
		int currwt=0;
		double finalvalue=0.0;
		
		for(int i=0;i<items.length;i++) {
			if(items[i].weight+currwt<=W) {
				currwt+=items[i].weight;
				finalvalue+=items[i].value;
			}
			else {
				int rW=W-currwt;
				finalvalue+=((double)items[i].value/(double)items[i].weight)*rW;
			}
			
		}
		return finalvalue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
       // int a[]= {60,100,120};
       // int b[]= {10,20,30};
        //int W=50;
        System.out.println("Enter the capacity of bag:");
        int W=sc.nextInt();
        System.out.println("Enter the size of an array:");
        int size=sc.nextInt();
        items Items[]=new items[size]; 
        
        for(int i=0;i<size;i++) {
        	items item=new items(0,0);	
        	System.out.println("Enter the no of weights of item "+i);
        	item.weight=sc.nextInt();
        	System.out.println("Enter the total value for "+item.weight+" items for item "+i);
        	item.value=sc.nextInt();
        	Items[i]=item;
        }
        double n=solve(W,Items);
        System.out.println("The maximum value is:  "+n);
	}

}
