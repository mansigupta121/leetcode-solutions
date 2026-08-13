class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int answer[]=new int[n];
        int prefix_product[]=new int[n];
        prefix_product[0]=1;
        int suffix_product[]= new int[n];
        suffix_product[n-1]=1;
        int i;
        for(i=1; i<n; i++){
            prefix_product[i]=prefix_product[i-1]*nums[i-1];
        }
        for(i=n-2;i>=0;i--){
            suffix_product[i]=suffix_product[i+1]*nums[i+1];
        }
        for(i=0; i<n; i++){
            answer[i]=prefix_product[i]*suffix_product[i];
        }
        return answer;
    }
}