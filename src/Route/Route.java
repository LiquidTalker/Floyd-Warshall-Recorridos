package Route;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro
 */
public class Route {

    //Matriz de adyacencia 
    static int[][] adj = new int[][]{
        //0, 1, 2, 3, 4
        {0, 1, 1, 0, 1},//0
        {1, 0, 1, 1, 1},//1
        {1, 1, 0, 1, 1},//2
        {0, 1, 1, 0, 0},//3
        {1, 1, 1, 0, 0} //4
    };

    static boolean[] DFSRoad = new boolean[adj.length]; //Visitados por el metodo de DFS (Profundidad)
    static boolean[] BFSRoad = new boolean[adj.length]; //Visitados por el metodo de BFS (Anchura)

    /**
     * Inicio
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("DFS: ");
        DFS(0);
        System.out.println("\nBFS: ");
        BFS(0);
    }

    /**
     * Metodo DFS (profundidad), visita un vertice inicial vi y visita los adyacentes a vi hasta que encuentre
     * uno ya visitado. Termina cuando vuelva al vertice vi y no queden adyacentes por recorrer
     * @param u, será el vertice inicial que visitara el recorrido  
     */
    public static void DFS(int u) {
        System.out.print(u + " ");
        DFSRoad[u] = true;
        for (int v = 0; v < adj.length; v++) {
            if (adj[u][v] == 1) {
                if (!DFSRoad[v]) {
                    DFS(v);
                }
            }
        }
    }

    
    /**
     * Metodo BFS (Anchura), comienza en el vertice inicial vi, visita los adyacentes a vi y luego visita
     * los adyacentes de los adyacentes a vi hasta que no queden más vertices adyacentes
     * @param u, vertice inicial por el cual se inicie el recorrido
     */
    public static void BFS(int u) {
        Queue<Integer> booty = new LinkedList<>(); //FIFO
        BFSRoad[u] = true;
        booty.add(u);
        while (!booty.isEmpty()) {
            u = booty.remove();
            System.out.print(u + " ");
            for (int v = 0; v < adj.length; v++) {
                if (adj[u][v] == 1) {
                    if (!BFSRoad[v]) {
                        BFSRoad[v] = true;
                        booty.add(v);
                    }
                }
            }
        }
    }

}
