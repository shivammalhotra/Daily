public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    return searchRotate(a,b,0,a.size()-1);
	}
	public int searchRotate(final List<Integer> a, int b, int start, int end){
	    if(start>end) return -1;
	    int median = (start+end)/2;
	    int num = a.get(median);
	    if(b==num){
	        return median;
	    }else if(a.get(start) > a.get(end)){
	        if(a.get(start) > num){
	            if(b<num || b>=a.get(start)){
        	        return searchRotate(a,b,start,median - 1);
        	    }else {
        	        return searchRotate(a,b,median + 1, end);
        	    }
	        }else{
	             if(b<num && b>=a.get(start)){
        	        return searchRotate(a,b,start,median - 1);
        	    }else {
        	        return searchRotate(a,b,median + 1, end);
        	    }
	        }
	    }else{
	        if(b<num){
    	        return searchRotate(a,b,start,median - 1);
    	    }else {
    	        return searchRotate(a,b,median + 1, end);
    	    }
	    }
	}
}
