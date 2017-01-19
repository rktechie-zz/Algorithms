package DynamicProgramming;

import java.util.Arrays;

public class GraphColoring {
	static int connected[][];
	static int[] colors;
	static int nColors;
	static int nNodes;

	static int getNodeColor(int k) {
		do {
			int j;
			// Assign the next color
			colors[k] = colors[k] + 1;

			// If all colors have been tested on this node,
			// return because there are no more new colors left
			// to be considered for this node
			if (colors[k] == nColors + 1)
				return 0;

			// Check to see if some connected node already has this color
			for (j = 1; j <= nNodes; ++j) {
				if (connected[k][j] == 1 && colors[k] == colors[j] && k != j) {
					break;
				}
			}
			if (j == nNodes + 1)
				return colors[k];
		} while (true);
	}

	static void mColoring(int k) {
		do {
			// get a color for this node
			colors[k] = getNodeColor(k);
			
			// if no more colors can be applied to this node, return
			if (colors[k] == 0)
				return;
//			System.out.println("Color Assignment: " + Arrays.toString(colors));
			// if all the nodes have been assigned colors successfully, print
			// the color assignments
			if (k == nNodes) {
				System.out.println("Color Assignment: " + Arrays.toString(colors));
				// return /*don't quit until all possible assignments have been
				// found*/
			}
			// consider the next node
			else
				mColoring(k + 1);
		} while (true);
	}

	public static void main(String[] args) throws Exception {
		nColors = 3;
		connected = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 1, 1 }, };
		nNodes = connected.length - 1;
		colors = new int[nNodes + 1];

		mColoring(1);
	}
}