public class Solution {
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
	    int[][] square = generateArray(a);
	    //System.out.print(square[][0]);
	    //return null;
	   ArrayList<ArrayList<Integer>> full = new ArrayList<ArrayList<Integer>>();
	    for(int i = 0; i< a; i++){
	        ArrayList<Integer> sub = new ArrayList<Integer>();
	        for(int j=0; j< a; j++){
	            sub.add(square[i][j]);
	        }
	        full.add(sub);
	    }
	    return full;
	}
	public int[][] generateArray(int a){
	    int[][] square = new int[a][a];
	    int index = 1;
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    int n = a;
	    double kMax = Math.ceil((double)a/2);
	    //System.out.println(kMax);
	    while(kMax>0){
	        square[i][j] = index;
	        index++;
	        while(i!=n-1 || j!=n-1){
	            //System.out.println(i+","+j);
	            if(j<n-1){
	                j=j+1;
	                square[i][j] = index;
	                index++;
	            }else if(i<n-1){
	                i=i+1;
	                square[i][j] = index;
	                index++;
	            }
	        }
	        if(i==n-1 && j == n-1){
	            while(i!=k || j!=k){
	                //System.out.println(i+","+j);
	                if(j>k){
	                    j=j-1;
	                    square[i][j] = index;
	                    index++;
	                }else if(i-1>k){
	                    i=i-1;
	                    square[i][j] = index;
	                    index++;
	                }else{
	                    i=k;
	                }
	            }
	        }
	        i = i+1;
	        j= j+1;
	        k++;
	        kMax--;
	        n--;
	    }
	    return square;
	}
	
}
