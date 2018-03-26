import java.util.List;

public class RandomMatrix {
    public static void main (String[] args) {
        System.out.println("Hello World");
        List<String> lines = MyUtil.getLines("src/input1.txt");
        for(String line : lines){
            System.out.println(line);
        }
        getMatrixFromLines("src/input1.txt");
    }

    public static void getMatrixFromLines(String src){
        List<String> lines = MyUtil.getLines(src);          //  Get the row and column text lines
        int columnNumIndex = lines.get(0).indexOf("=")+1;   //  Index where column number begins
        int rowNumIndex = lines.get(1).indexOf("=")+1;      //  Index where row number begins
        int numColumns = Integer.parseInt(lines.get(0).substring(columnNumIndex));
        int numRows = Integer.parseInt(lines.get(1).substring(rowNumIndex));
        Matrix test = new Matrix(numRows, numColumns);
        Matrix test2 = new Matrix(numRows, numColumns);
        test.printMatrix();
        System.out.println("\n");
        test2.printMatrix();
        System.out.println("\n");
        Matrix sum = Matrix.addMatrices(test,test2);
        sum.printMatrix();

//        System.out.println(columns);
    }

    public static class Matrix {
        int columns;
        int rows;
        int[][] data;
        public Matrix(int rows, int columns) {
            this.columns = columns;
            this.rows = rows;
            this.data = new int[rows][columns];
            for(int i = 0; i < this.rows; i++){
                for(int j = 0; j < this.columns; j++ ){
                    data[i][j] = MyUtil.getRandomInt(0,10);
                }
            }
        }
        public void printMatrix(){
            for(int[] row : this.data){
                System.out.print("[ ");
                for(int entry : row){
                    System.out.print(entry + " ");
                }
                System.out.print("]");
                System.out.print("\n");
            }
        }

        public int getColumns(){
            return this.columns;
        }

        public int getRows(){
            return this.rows;
        }
        public int getEntry(int row, int col){
            return this.data[row - 1][col - 1];
        }
        public void setEntry (int entry, int row, int col){
            this.data[row - 1][col - 1] = entry;
        }

        public static Matrix addMatrices(Matrix a, Matrix b) {
            if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
                // Invalid mix of matrices
                return new Matrix(0,0);
            }
            Matrix sumMatrix = new Matrix(a.getRows(),a.getColumns());
            for(int i = 1; i <= a.getRows(); i++){
                for(int j= 1; j <= a.getColumns(); j++){
                    int entry = a.getEntry(i,j) + b.getEntry(i,j);
                    sumMatrix.setEntry(entry, i, j);
                }
            }
            return sumMatrix;
        }


    }
}
