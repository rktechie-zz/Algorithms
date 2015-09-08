/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Arrays;

/**
 *
 * @author rishabh
 */
public class heapsort {

    public static void main(String[] args) {
        int[] data = {5, 2, 3, 4, 6, 1, 8};
        heapsort(data);
    }

    public static void heapsort(int[] data) {
        for (int i = (data.length - 1) / 2; i >= 0; i--) {
            heapify(data, i, data.length);
            System.out.println(Arrays.toString(data));
        }
        System.out.println("Now Reconstruction starts");
        for (int i = data.length - 1; i > 0; i--) {
            int t = data[0];
            data[0] = data[i];
            data[i] = t;
            heapify(data, 0, i);
            System.out.println(Arrays.toString(data));
        }
    }

    private static void heapify(int[] data, int p, int n) {
        int t = data[p];
        int i = 0;
        for (i = 2 * p + 1; i < n; i = 2 * i + 1) {
            if ((i + 1) < n && data[i] < data[i + 1]) {
                i++;
            }
            if (data[i] > t) {
                data[(i - 1) / 2] = data[i];
            } else {
                break;
            }
        }
        data[(i - 1) / 2] = t;
    }
}
