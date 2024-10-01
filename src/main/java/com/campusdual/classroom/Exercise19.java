package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        // Array tridimensional
        int depth = intArrayTri.length; // Profundidad del array
        int rows = intArrayTri[0].length; // filas en el array
        int cols = intArrayTri[0][0].length; // columnas en el array

        // Array bidimensional;
        int[][] array2D = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < depth; k++) {
                    sum += intArrayTri[k][i][j];
                }
                array2D[i][j] = sum;
            }
        }
        return array2D;
    }

    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sTr = new StringBuilder();
        for (int i = 0; i < intArrayBi.length; i++) {
            sTr.append(stringFlatMatrixRow(intArrayBi, i));
            for (int j = 0; j < intArrayBi[i].length; j++) {
                if (j == intArrayBi[i].length - 1 && i != intArrayBi.length -1 ){
                    sTr.append("\n");
                }
            }
        }
        return sTr.toString();
    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sTr = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            if (i == uniArray.length - 1){
                sTr.append(uniArray[i]);
            }else{
                sTr.append(uniArray[i]);
                sTr.append(" ");
            }
        }
        return sTr.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int arrVal[] = new int[columns];
        for (int i = 0; i < arrVal.length; i++){
            arrVal[i] = i+1;
        }
        return arrVal;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int arrVal[][] = new int[rows][columns];
        int v = 1;
        for (int i = 0; i < arrVal.length; i++) {
            for (int x = 0; x < arrVal[i].length; x++){
                arrVal[i][x] = v;
                v++;
            }
        }
        return arrVal;
    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int arrVal[][][] = new int[depth][rows][columns];
        int v = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    arrVal[i][j][k] = v;
                    v++;
                }
            }
        }
        return arrVal;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}