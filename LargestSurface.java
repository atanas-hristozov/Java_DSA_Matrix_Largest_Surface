import java.util.Scanner;

public class LargestSurface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int [][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        /*
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        */
        int sum = largestSize(matrix, row, column);
        System.out.println(sum);
    }

    private static int largestSize(int[][] matrix, int row, int column) {
        boolean[][] visited = new boolean[row][column];
        int maxSurfaceSize = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(!visited[i][j]){
                    int surfaceSize = proverka(matrix, visited, row, column, i, j, matrix[i][j]);
                    if(maxSurfaceSize<surfaceSize){
                        maxSurfaceSize = surfaceSize;
                    }
                }
            }
        }
        return maxSurfaceSize;
    }

    private static int proverka(int[][] matrix, boolean[][] visited, int row, int column, int a, int b, int matrix1) {
        if (a<0 || a>=row || b<0 || b>=column || visited[a][b] || matrix[a][b] != matrix1){
            return 0;
        }
        visited[a][b] = true;
        int size = 1;
        size += proverka(matrix,visited,row,column, a+1, b, matrix1);
        size += proverka(matrix,visited,row,column, a-1, b, matrix1);
        size += proverka(matrix,visited,row,column, a, b+1, matrix1);
        size += proverka(matrix,visited,row,column, a, b-1, matrix1);
        return size;
    }
}