public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> newInterval = intervalMergeSort(intervals, 0, intervals.size() - 1);
        //System.out.println(newInterval.size());
        ArrayList<Interval> mergedInterval = new ArrayList<Interval>();
        int index = 0;
        for(int i = 0; i<newInterval.size();i++){
            if(index == mergedInterval.size()){
                mergedInterval.add(index,newInterval.get(i));
            }else{
                if(mergedInterval.get(index).end>=newInterval.get(i).start){
                    if(mergedInterval.get(index).end<newInterval.get(i).end){
                        mergedInterval.get(index).end  = newInterval.get(i).end;
                    }
                }else{
                     index++;
                     mergedInterval.add(index,newInterval.get(i));
                }
            }
        }
        return mergedInterval;
    }
    private ArrayList<Interval> intervalMergeSort(ArrayList<Interval> intervals, int begin, int stop){  
        if(begin == stop) {
            ArrayList<Interval> retrnInterval = new ArrayList<Interval>();
            retrnInterval.add(intervals.get(begin));
            return  retrnInterval; 
        }
        int pivot = (begin + stop)/2;
        ArrayList<Interval> leftInterval = intervalMergeSort(intervals,begin,pivot);
        ArrayList<Interval> rightInterval = intervalMergeSort(intervals,pivot+1,stop);
        ArrayList<Interval> newInterval = new ArrayList<Interval>();
         
        int left = 0;
        int right = 0;
        int leftMax = leftInterval.size();
        int rightMax = rightInterval.size();
        int index = 0;
         
    
        while(left<leftMax || right < rightMax){
           //System.out.println(newInterval.size());
            if(left<leftMax && right < rightMax){
                if(leftInterval.get(left).start < rightInterval.get(right).start){
                    newInterval.add(index,leftInterval.get(left));
                    left++;
                    index++;
                }else{
                    newInterval.add(index,rightInterval.get(right));
                    right++;
                    index++;
                }    
            }else if(left<leftMax){
                while(left<leftInterval.size()){
                    newInterval.add(index,leftInterval.get(left));
                    left++;
                    index++;
                }
                
            }else if(right<rightMax){
                while(right<rightInterval.size()){
                   newInterval.add(index,rightInterval.get(right));
                    right++;
                    index++;
                }
            }
        }
        return newInterval;
    }
}
