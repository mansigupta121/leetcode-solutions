class Solution {
    public int product(int x){
        int product=1;
        while(x!=0){
            product=product*(x%10);
            x=x/10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        int i;
        int ans=0;
        for(i=n; i<=n+10; i++){
            int product=product(i);
            if(product==0){
                return i;
            }

            int remainder= product%t;
            if(remainder==0){
                ans=i;
                break;
            }       
        }

        return ans;
    }
}