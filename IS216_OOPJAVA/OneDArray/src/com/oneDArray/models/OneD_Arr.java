package com.oneDArray.models;
public class OneD_Arr {
    private int A[];
    private int N; 
  
    public OneD_Arr(int size) {
        A = new int[size];
        N = size;
    }


    public void input(int[] inputArray) {
        if (inputArray.length != N) {
            System.out.println("Input array size does not match the size of the initialized array.");
            return;
        }
        System.arraycopy(inputArray, 0, A, 0, N);
    }


	public int getN() {
		return N;
	}
    public void output() {
        System.out.print("Array elements: ");
        for (int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public int binarySearchMin() {
        int low = 0;
        int high = N - 1;
        int min = A[0]; 

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < min) {
                min = A[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }

    public int binarySearchMax() {
        int low = 0;
        int high = N - 1;
        int max = A[N - 1]; // Default maximum

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] > max) {
                max = A[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return max;
    }


    public boolean binarySearch(int x) {
        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == x) {
                return true; // Element found
            } else if (A[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false; // Element not found
    }

    public void deleteNumber(int x) {
        for (int i = 0; i < N; i++) {
            if (A[i] == x) {
                for (int j = i; j < N - 1; j++) {
                    A[j] = A[j + 1];
                }
                A[N - 1] = 0; 
                N--; 
                break; 
            }
        }
    }

    public void orderArray(String order) {
        if (order.equalsIgnoreCase("asc")) {
            // Using bubble sort for ascending order
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - i - 1; j++) {
                    if (A[j] > A[j + 1]) {
                        // Swap A[j] and A[j+1]
                        int temp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = temp;
                    }
                }
            }
        } else if (order.equalsIgnoreCase("dsc")) {
            // Using bubble sort for descending order
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - i - 1; j++) {
                    if (A[j] < A[j + 1]) {
                        // Swap A[j] and A[j+1]
                        int temp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = temp;
                    }
                }
            }
        } else {
            System.out.println("Invalid order specified. Please use 'asc' or 'dsc'.");
        }
    }


}
