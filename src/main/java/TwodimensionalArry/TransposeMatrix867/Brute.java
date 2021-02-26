package TwodimensionalArry.TransposeMatrix867;


public class Brute {
    public static void main(String[] args) {
        int[][] matrix = initMatrix();
        transpose(matrix);
    }

    private static int[][] transpose(int[][] matrix) {
        int row=matrix.length;
        int column= matrix[0].length;
        int [][] result=new int[column][row];
        for (int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                result[j][i]=matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] initMatrix() {
        int[][] matrix = new int[3][4];
        int row_length=matrix.length,column_length=matrix[0].length;
        int i=1;
        for (int row=0;row<row_length;row++){
            for (int column=0;column<column_length;column++){
                matrix[row][column]=i++;
            }
        }
        return matrix;
    }
}
