package helpers;

public class MathHelper {

	public static int[][] matrixMax(int[][] matrix1, int[][] matrix2) throws Exception{
		
		if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length){
			for (int i=0; i<matrix1.length;i++) {
				for(int j=0; j<matrix2.length;j++){
					matrix1[i][j] = Math.max(matrix1[i][j],matrix2[i][j]);
				}
			}
			return matrix1;
		} else {	
			throw new Exception();
		}
		
		
		
	}
}
