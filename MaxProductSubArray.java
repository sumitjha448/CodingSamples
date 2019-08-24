public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> A) {
        int l = A.size();
        int maxVal = A.get(0);
        int minVal = A.get(0);
        int res = A.get(0);
        for(int i = 1;i < l;i++){
            int num = A.get(i);
            if(num < 0){
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(maxVal * num,num);
            minVal = Math.min(minVal * num,  num);
            res = Math.max(maxVal, res);
        }
    return res;        
    }
}
