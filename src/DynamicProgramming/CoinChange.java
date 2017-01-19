package DynamicProgramming;

/*
 * Very very helpful: http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/DynProg/money-change.html
 */
public class CoinChange {
	public static void main(String arg[]) {
//		int number = findM(7, new int[] { 1, 2, 5 });
		int number = minChange(new int[] {1,2,5}, 7);
		System.out.println("final: " + number);
	}
	
	// Easy way of writing the code
	static public int minChange(int[] denom, int targetAmount) {

		int actualAmount;
		int m = denom.length + 1;
		int n = targetAmount + 1;
		int inf = Integer.MAX_VALUE - 1;

		int[][] table = new int[m][n];
		for (int j = 1; j < n; j++)
			table[0][j] = inf;

		for (int i = 1; i < m; i++) // i denotes denominationIndex
		{
			for (int j = 1; j < n; j++) // j denotes current Amount
			{
				if (j - denom[i - 1] >= 0) // take this denomination value and
											// subtract this value from Current
											// amount

					table[i][j] = Math.min(table[i - 1][j], 1 + table[i][j - denom[i - 1]]);

				else
					table[i][j] = table[i - 1][j];

			}
		}

		// display array
		System.out.println("----------------Displaying the 2-D Matrix(denominations and amount)----------------");
		for (int i = 0; i < m; i++) {
			System.out.println("   ");
			for (int j = 0; j < n; j++) {
				System.out.print("  " + table[i][j]);

			}
			System.out.println("   ");
		}

		return table[m - 1][n - 1];

	}
	
	// Second way of writing the code
	static int findM(int N, int v[]) {
		int[] M;
		int[] sol, mySol;
		int j, k, min;

		M = new int[N + 1]; // Store results

		sol = new int[v.length];
		mySol = new int[v.length];

		/*
		 * --------------------------- Base case ---------------------------
		 */
		M[0] = 0; // 0 coins needed to make change for $0

		/*
		 * --------------------------------------------------- The other cases
		 * (starting from 1 to M.length - 1)
		 * 
		 * Follow direction of data flow !
		 * ---------------------------------------------------
		 */
		for (j = 1; j <= N; j++) {
			/*
			 * ============================================ Find min # coin to
			 * make change for $j ============================================
			 */

			for (k = 0; k < v.length; k++)
				mySol[k] = -1; // Initialize mySol[]

			/*
			 * -------------------------------------------------------- Try
			 * every denomination k = 1,2,..,C for the last coin
			 * --------------------------------------------------------
			 */
			for (k = 0; k < v.length; k++) {
				/*
				 * -------------------------------------------- Check if we can
				 * use the k-th denomination
				 * --------------------------------------------
				 */
				if (v[k] <= j) {
					/*
					 * ------------------------ Divide step
					 * ------------------------
					 */
					sol[k] = M[j - v[k]]; // Use coin v[k] as last coin
					mySol[k] = sol[k] + 1; // Solution to make change for $j
				}
			}

			/*
			 * -------------------------------------------------------- Find the
			 * minimum of all mySol[...]
			 * --------------------------------------------------------
			 */
			M[j] = -1;

			for (k = 0; k < v.length; k++) {
				if (mySol[k] > 0) {
					if (M[j] == -1 || mySol[k] < M[j])
						M[j] = mySol[k];
				}
			}
		}

		return (M[N]); // Min # coins to change $Am
	}
}