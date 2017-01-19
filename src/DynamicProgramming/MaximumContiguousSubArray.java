package DynamicProgramming;

public class MaximumContiguousSubArray {

	static private int seqStart = 0;
	static private int seqEnd = -1;

	public static void main(String[] args) {
		int a[] = { 4, -3, 5, -2, -1, 2};
		int maxSum = maxSubSum(a);
		System.out.println("Max sum is " + maxSum + "; it goes" + " from " + seqStart + " to " + seqEnd);
	}

	public static int maxSubSum(int[] a) {
		int maxSum = 0;
		int currentSum = 0;

		for (int i = 0, j = 0; j < a.length; j++) {
			currentSum += a[j];
			if (currentSum > maxSum) {
				maxSum = currentSum;
				seqStart = i;
				seqEnd = j;
			} else if (currentSum < 0) {
				i = j + 1;
				currentSum = 0;
			}
		}

		return maxSum;
	}
	
	public static void dpmaxSubSum(int[] a) {
		
	}
}
