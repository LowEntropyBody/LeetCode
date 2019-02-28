class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int N = nums1.length + nums2.length;
		if (N % 2 == 1)
			return findKth(nums1, 0, nums2, 0, N / 2 + 1);
		else
			return (findKth(nums1, 0, nums2, 0, N / 2 + 1) + findKth(nums1, 0, nums2, 0, N / 2)) / 2.0;
	}
 
	// 返回第k大的元素，从1开始。
	private int findKth(int[] a, int alo, int[] b, int blo, int k) {
		// a数组为空时，返回b数组第k个元素
		// k从1开始
		// alo,blo是第一个元素
		if (alo >= a.length)
			return b[blo + k - 1];
		// b数组为空时，返回a数组第k个元素
		if (blo >= b.length)
			return a[alo + k - 1];
		// 当k==1时，返回a[alo]、b[alo]中小的那个
		if (k == 1)
			return Math.min(a[alo], b[blo]);
		// i表示mid到lo之间的差值
		int i = k / 2 - 1;
		int aMid = Integer.MAX_VALUE;
		int bMid = Integer.MAX_VALUE;
		// lo+i正好为中位数下标位置
		if (alo + i < a.length)
			aMid = a[alo + i];
		if (blo + i < b.length)
			bMid = b[blo + i];
		if (aMid < bMid)
			// 在amid之前，包括amid，不可能存在中位数，跳过查找（删除），
			// alo到amid（包括）之间有i+1个数字
			// 去掉i+1个数字，原来第k大，变成第k-（i+1）大
			return findKth(a, alo + i + 1, b, blo, k - i - 1);
		else
			return findKth(a, alo, b, blo + i + 1, k - i - 1);
	}
    
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,9};
        int[] nums2 = {1,3,4,9};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}