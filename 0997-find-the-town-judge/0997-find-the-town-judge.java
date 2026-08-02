class Solution {
    public int findJudge(int n, int[][] trust) {
        // Quick optimization: If there aren't enough trust relationships 
        // to satisfy (n - 1) people trusting the judge, no judge can exist.
        if (trust.length < n - 1) {
            return -1;
        }

        int[] trustScore = new int[n + 1];

        // Calculate net trust scores
        for (int[] relation : trust) {
            int a = relation[0]; // Truster
            int b = relation[1]; // Trustee
            
            trustScore[a]--; // Outgoing trust reduces score
            trustScore[b]++; // Incoming trust increases score
        }

        // Find the person with score == n - 1
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}