public class Solution {
	public int sqrt(int a) {
	    long start = 0;
	    long stop = a;
	    return findSqr(a,start,stop);
	    
	}
	public int findSqr(int a, long start, long stop){
	    if(start > stop){
	        return Math.toIntExact(start-1);
	    }
	    long median = (start + stop)/2;
	    long sqrt = median * median;
	    if(sqrt == a){
	        return Math.toIntExact(median);
	    }else if(sqrt > a){
	        return findSqr(a,start,median-1);
	    }else{
	         return findSqr(a,median+1,stop);
	    }
	}
}
