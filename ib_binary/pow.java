public class Solution {
	public int pow(int x, int n, int d) {
	    long rem = powSub(x,n,d);
	    int rem2 = Math.toIntExact(rem);
	    if(rem2<0){
	        return d+rem2;
	    }else{
	        return rem2;
	    }
	}
	public long powSub(long x, long n, long d) {   
	    long temp = x;
	    boolean neg = false;
	    if(x==0) return 0;
	    if(n==0) return 1;
	    if(n==1) return x%d;
	    long start = 1;
	    
	    while(2*start<=n & x>0){
	        x = (x%d)*(x%d);
	        //System.out.println(x);
	        start = start + start;
	    }
	    if(n-start!=0){
	        long result = powSub(temp,n-start,d);
	        //System.out.println(start+","+n+","+x","+result);
	        return (x%d*result%d)%d;
	    }else{
	        return x%d;
	    }
	}
}
