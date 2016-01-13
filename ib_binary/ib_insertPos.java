public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    return search(a,0,a.size()-1,b);
	}
	public int search(ArrayList<Integer> a, int start, int end, int b){
	    if(start>end){
	       return start;
	    } 
	    int median = (start + end)/2;
	    int num = a.get(median);
	    int ret = -1;
	    if(num == b){
	        return median;
	    }else if(b<num){
	        return search(a,start,median-1,b);
	    }else{
	        //System.out.print((median+1) +","+end);
	        return search(a,median+1,end,b);
	    }
	}
}