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
        Matrix test = new Matrix(numColumns, numRows);
        Matrix test2 = new Matrix(numColumns, numRows);
        test.printMatrix();
        test2.printMatrix();

//        System.out.println(columns);
    }

    public static class Matrix {
        int columns;
        int rows;
        int[][] data;
        public Matrix(int columns, int rows) {
            this.columns = columns;
            this.rows = rows;
            this.data = new int[columns][rows];
            for(int i = 0; i < this.rows; i++){
                for(int j = 0; j < this.columns; j++ ){
                    data[i][j] = MyUtil.getRandomInt(0,100);
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
    }
}
