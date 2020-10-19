package midtermlyx;

import java.io.*;
import java.util.ArrayList;

public class Matrix {
	double[][] mtx = null;
	
	public Matrix(int m, int n) {
		this.mtx = new double[m][n];
		
	}
	
	public int numRows() {
		return mtx.length;
	}
	
	public double[] getRow(int i) {
		return mtx[i];
	}
	
	public double getElement(int i, int j) {
		return mtx[i][j];
	}
	
	public void setElement(int i, int j, double val) {
		mtx[i][j] = val;
	}
	
	public int numColumns() {
		return mtx[0].length;
	}
	
	public void save(String filename) {
		try {
			PrintWriter out = null;
			out = new PrintWriter(new FileWriter(filename));
			out.println(numRows() + "  " + numColumns());
			for (int i = 0; i < numRows(); i++) {
				for (int j = 0; j < numColumns(); j++) {
						out.print(String.valueOf(mtx[i][j]) + "  ");
				}
				out.flush();
				out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


	
	public static Matrix read(String filename) throws ExceptionWrongMatrixValues, ExceptionWrongMatrixDimension {
		ArrayList<String> readList = new ArrayList<>();
		Matrix matrix = null;
		try {
			FileReader f = new FileReader(filename);
			BufferedReader in = new BufferedReader(f);
			String ln = in.readLine();
			int row = Integer.parseInt(ln.split(" ")[0]);
			int column = Integer.parseInt(ln.split(" ")[1]);
			matrix = new Matrix(row, column);
			System.out.println("row,col:  "+ row+"  "+ column);
			int rowCnt = 0;
			System.out.println(ln);
			while ( (ln = in.readLine()) != null) {
				System.out.println(ln);
				for (int i = 0; i < row; i++) {
					String rowValue[] = ln.split(" ");
					for (int j = 0; j < column; j++) {
						try {
							matrix.setElement(i, j, Double.parseDouble(rowValue[j]));
						} catch (NumberFormatException e) {
							throw new ExceptionWrongMatrixValues();
						} catch (ArrayIndexOutOfBoundsException e){
							throw new ExceptionWrongMatrixValues();
						}
					}
				}
				if (ln.split(" ").length != column && rowCnt > 0) {
					throw new ExceptionWrongMatrixDimension();
				}
				rowCnt++;
			}
			if (rowCnt != row) {
				throw new ExceptionWrongMatrixDimension();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matrix;
	}
	
	public Matrix sum(Matrix m) {
		if(mtx[0].length == m.mtx[0].length && mtx.length == m.mtx.length) {
			Matrix sumResult = new Matrix(mtx.length, mtx[0].length);
			for (int i = 0; i < mtx.length; i++) {
				for (int j = 0; j < mtx[0].length; j++) {
					sumResult.setElement(i, j, getElement(i, j) + m.getElement(i, j));
				}
			}
			return sumResult;
		}
		return null;
	}
	
	// this will come in handy for the multiplication part
	public double[] getColumn(int j) {
		if (j >= this.numColumns()) {
			return null;
		}
		double[] col = new double[this.numRows()];
		for (int i=0; i<mtx.length; i++) {
			col[i] = mtx[i][j];
		}
		return col;
	}
	
	public Double dotproduct(double[] v1, double[] v2) {
		Double result = null;
		if (v1.length == v2.length) {
			result = 0.0;
			for (int i = 0; i < v1.length; i++) {
				result += v1[i] * v2[i];
			}
		}
		return result;
	}
	
	public Matrix product(Matrix m) {
		int m1Row = numRows();
		int m1Column = numColumns();
		int m2Row = m.numRows();
		int m2Column = m.numColumns();
		if (m1Column == m2Row) {
			Matrix productResult = new Matrix(m1Row, m2Column);
			for (int i = 0; i < m1Row; i++) {
				for (int j = 0; j < m2Column; j++) {
					productResult.setElement(i, j, dotproduct(getRow(i), m.getColumn(j)));
				}
			}
			return productResult;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Matrix m1 = new Matrix(2,3);
		m1.setElement(0, 0, 1.0);
		m1.setElement(0, 1, 1.0);
		m1.setElement(0, 2, 1.0);
		m1.setElement(1, 0, 1.0);
		m1.setElement(1, 1, 1.0);
		m1.setElement(1, 2, 1.0);
		
		Matrix m2 = new Matrix(3,2);
		m2.setElement(0, 0, 2.0);
		m2.setElement(0, 1, 2.0);
		m2.setElement(1, 0, 2.0);
		m2.setElement(1, 1, 3.0);
		m2.setElement(2, 0, 3.0);
		m2.setElement(2, 1, 3.0);

// sum testing
		Matrix m4 = new Matrix(3,2);
		m4.setElement(0, 0, 2.0);
		m4.setElement(0, 1, 2.0);
		m4.setElement(1, 0, 2.0);
		m4.setElement(1, 1, 3.0);
		m4.setElement(2, 0, 3.0);
		m4.setElement(2, 1, 3.0);

		Matrix m5 = m2.sum(m1);
// product testing
		Matrix result = m1.product(m2);
		m1.save("m1");
		m2.save("m2");
		result.save("result");
		System.out.println("-----------------try catch for m1, m2 and m3-------------------");
		try {
			m1 = Matrix.read("src\\midtermlyx\\dependency\\m1");
			m2 = Matrix.read("src\\midtermlyx\\dependency\\m2");
			Matrix m3 = Matrix.read("src\\midtermlyx\\dependency\\result");
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		//System.out.println("read && save complete");
		System.out.println("-----------------try catch for badMatrix-------------------");
		try {
			Matrix badMatrix = Matrix.read("src\\midtermlyx\\dependency\\wrongcolumns");
		} catch (ExceptionWrongMatrixDimension e1) {
			System.err.println("wrong dimensions: " + e1);
		} catch (ExceptionWrongMatrixValues e2) {
			System.err.println("wrong matrix values: " + e2);
		}

		System.out.println("-----------------try catch for badMatrix2-------------------");
		try {
			Matrix badMatrix2 = Matrix.read("src\\midtermlyx\\dependency\\wrongrows");
		} catch (ExceptionWrongMatrixValues e) {
			System.err.println("wrong dimensions: " + e);
		} catch (ExceptionWrongMatrixDimension e) {
			System.err.println("wrong matrix values: " + e);
		}
		
		return;
		
		
	}
	
}
