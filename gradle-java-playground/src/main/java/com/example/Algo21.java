package com.example;

public class Algo21 {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 4, 5, 5};
        boolean solution = solution(a, 6);

        System.out.println("solution = " + solution);
    }

    private static boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1]) // 그 현재보다 1이상 크면
                return false;

            if ((A[i] != A[i+1]) && (A[i] + 1 != A[i + 1])) {
                return false;
            }
        }
        if (A[0] != 1 && A[n - 1] != K) // 두번쨰부터 &&
            return false;
        else
            return true;
    }
}
