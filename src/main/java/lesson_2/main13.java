package lesson_2;

public class main13 {
    public static void main(String[] args) {
        System.out.println("13. fillDiagonals():");
        int[][] matrix = fillDiagonals(5);
        System.out.println("Матрица 5x5 с диагоналями:");
        printMatrix(matrix);
        System.out.println();
    }
    public static int[][] fillDiagonals(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i == size - 1 - j) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

