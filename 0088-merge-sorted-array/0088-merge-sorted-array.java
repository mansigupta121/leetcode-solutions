class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. Initialize three pointers at the back of the arrays
        int p1 = m - 1;      // Points to the last actual element in nums1
        int p2 = n - 1;      // Points to the last element in nums2
        int pMerged = m + n - 1; // Points to the very last index of nums1

        // 2. Compare and place the larger elements from the back
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[pMerged] = nums1[p1];
                p1--;
            } else {
                nums1[pMerged] = nums2[p2];
                p2--;
            }
            pMerged--;
        }

        // 3. If there are any leftover elements in nums2, copy them over
        while (p2 >= 0) {
            nums1[pMerged] = nums2[p2];
            p2--;
            pMerged--;
        }
    }
}
