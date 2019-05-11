/**
 * Created by arjun on 23/03/19.
 */
public class Matrix {

    //Rotate a matrix by 90 degree in anticlockwise direction
    void rotateby90Degree(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            for (int j=i+1;j<matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i=0;i<matrix.length/2;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
    }

    void display(int[][] matrix){
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] ar){
        Matrix obj = new Matrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("original matrix: \n");
        obj.display(matrix);

        System.out.println("matrix rotated by 90 degree anti-clockwise: \n");
        obj.rotateby90Degree(matrix);
        obj.display(matrix);

    }
}
