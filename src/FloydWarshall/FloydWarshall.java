package FloydWarshall;


import java.util.Scanner;

/**
 *
 * @author Alejandro Manotas, Jose Padilla
 */
public class FloydWarshall {

    final static int INFINITE = 99999;

    /**
     * Punto de partida
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.println("Bienvenido!!!");
        System.out.println("Desea una matriz de prueba o ingresar los datos manualmente?");
        String r;
        do {
            System.out.print("Respuesta(si/no): ");
            r = t.next();
            if (r.equalsIgnoreCase("si")) {
                System.out.println("Matriz de prueba:");
                System.out.println("*******************");
                int[][] adj = testMatrix();
                print(adj);
                System.out.println("*******************");
                floyd(adj);
            } else if (r.equalsIgnoreCase("no")) {
                int[][] adj = readMatrix();
                floyd(adj);
            }
        } while (!r.equalsIgnoreCase("si") && !r.equalsIgnoreCase("no"));
    }

    /**
     * Retorna una matriz de prueba vista desarrollada ya en clases, solo para
     * comprobar que funciona correctamnte
     *
     * @return Matriz de prueba
     */
    static int[][] testMatrix() {
        return new int[][]{
            {0, 9, 3, 4, INFINITE, INFINITE},
            {INFINITE, 0, INFINITE, 7, INFINITE, INFINITE},
            {INFINITE, INFINITE, 0, INFINITE, 2, INFINITE},
            {INFINITE, INFINITE, 4, 0, INFINITE, INFINITE},
            {5, INFINITE, INFINITE, 1, 0, INFINITE},
            {3, 8, INFINITE, 2, INFINITE, 0}
        };
    }

    /**
     * Lee por consola una matriz de adyacencia
     *
     * @return Matriz leida
     */
    static int[][] readMatrix() {
        int n;
        Scanner t = new Scanner(System.in);
        System.out.print("Ingrese el número de vértices: ");
        n = t.nextInt();
        System.out.println("Digite la los valores para la adyacencia de un vertice A a un vertice B");
        System.out.println("Si el valor es infinito digite \"INFINITO\" sin comillas");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Adyacencia entre (" + i + ", " + j + "): ");
                String temp = t.next();
                if (temp.equalsIgnoreCase("infinito")) {
                    matrix[i][j] = INFINITE;
                } else {
                    matrix[i][j] = Integer.parseInt(temp);
                }
            }
        }
        return matrix;
    }

    /**
     * Aplica el algoritmo de Floyd-Warshall e imprime el resultado
     *
     * @param adj Matriz de adyacencia ponderada
     */
    static void floyd(int[][] adj) {
        for (int k = 0; k < adj.length; k++) {
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    if (adj[i][k] + adj[k][j] < adj[i][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
        System.out.println("Resultado");
        System.out.println("*******************");
        print(adj);
        System.out.println("*******************");
    }

    /**
     * Imprime una matriz cuaquiera
     *
     * @param matrix Matriz a imprimir
     */
    static void print(int[][] matrix) {
        for (int[] vector : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(vector[j] + "\t");
            }
            System.out.println("");
        }
    }

}
