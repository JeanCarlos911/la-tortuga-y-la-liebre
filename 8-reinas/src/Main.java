public class Main {
    public static int contador=0;

    public static void main(String[] args) {
        int[][] tablero = new int[8][8];

        for(int j=0; j<tablero.length; j++){
            tablero[0][j] = 1;
        }

        nextPosition(tablero, 0);

        System.out.println("\nContador = "+ contador);
    }

    public static void nextPosition(int[][] tablero, int columna) {
        for(int i=0; i<tablero.length; i++) {

            tablero[i][columna] = 0;

            if(i< tablero.length - 1) {
                tablero[i + 1][columna] = 1;
                evaluar(tablero);
            }else
                tablero[0][columna] = 1;

            if(columna < tablero.length - 1)
                nextPosition(tablero, columna+1);
        }
    }

    public static void evaluar(int[][] tablero) {
        int fila, diagonal1, j, diagonal2, h, diagonal3, diagonal4;

        //mirar por filas
        for(int c=0; c<tablero.length; c++) {
            diagonal1 = 0;
            diagonal2 = 0;
            diagonal3 = 0;
            diagonal4 = 0;
            h = tablero.length - 1 - c;

            for (int i = 0; i < tablero.length; i++) {
                fila = 0;

                for (j = 0; j < tablero.length; j++)
                    fila += tablero[i][j];

                if (fila > 1)
                    return;

                j=i+c;
                if(j < tablero.length) {
                    diagonal1 += tablero[i][j];
                    diagonal2 += tablero[j][i];
                }

                j=c-i;
                if(j >= 0) {
                    diagonal3 += tablero[i][j];
                    diagonal4 += tablero[i+h][j+h];
                }
            }
            if(diagonal1 > 1 || diagonal2 > 1 || diagonal3 > 1 || diagonal4 > 1 )
                return;
        }

        //imprimir tablero
        for(int[] i : tablero) {
            for(int k : i)
                System.out.printf("%2d", k);
            System.out.println();
        }
        System.out.println();
        contador++;
    }

}
