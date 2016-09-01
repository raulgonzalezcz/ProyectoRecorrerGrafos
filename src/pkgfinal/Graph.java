/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Raúl
 */
public class Graph {

    int[][] adjMatriz;
    Vertex[] AVertices; //Arreglo de vértices
    String white = "white";
    String black = "black";
    String gray = "gray";
    int time = 0;
    static boolean RBFS=true; 
     
    public Graph() throws FileNotFoundException {
        int inf = Integer.MAX_VALUE;
        //Tenemos que dar la dirección de dónde va a leer el archivo de texto
        Scanner sc = new Scanner(new File("C:\\Users\\Raúl\\Desktop\\Test.txt"));
               
        String metodo =sc.next();
        if (metodo.equals("dfs")) {
            RBFS = false;
        }
        //Leo mi archivo de texto
        String graphType = sc.next();
        //¿Es dirigido el Grafo?
        boolean undirected=true;
        
        if (graphType.equals("directed")) {
            undirected=false;
        }
         
        AVertices = new Vertex[sc.nextInt()]; //Número de vertices de mi arreglo
        int size = AVertices.length;
        adjMatriz=new int[size][size];
        
        if (RBFS==true){ //Escogió BFS
            //Leo vertices y agrego al arreglo
            for (int v = 0; v < AVertices.length; v++) {
                AVertices[v] = new Vertex(sc.next(),null,white,inf);
            }

            //¿Cuales son las conexiones?
            while (sc.hasNext()) {
                //Leo nombre de mis vértices y obtengo el número de vértice
                int v1 = indexForName(sc.next());
                int v2 = indexForName(sc.next());
                /*
                Hago una relación entre nodos dirigidos A->B
                */
                adjMatriz[v1][v2]=1;
                if (undirected) {//Relación B->A
                    adjMatriz[v2][v1]=1;
                }
            }
        }
        else{ //Escogió DFS
            //Leo vertices y agrego al arreglo
            for (int v = 0; v < AVertices.length; v++) {
                AVertices[v] = new Vertex(sc.next(),null,white,0,0);
            }

            //¿Cuales son las conexiones?
            while (sc.hasNext()) {
                //Leo nombre de mis vértices y obtengo el número de vértice
                int v1 = indexForName(sc.next());
                int v2 = indexForName(sc.next());
                /*
                Hago una relación entre nodos dirigidos A->B
                */
                adjMatriz[v1][v2]=1;
                if (undirected) {// Relación B->A
                    adjMatriz[v2][v1]=1;
                }
            }
        }
    }
    
    int indexForName(String name) {//Busca un elemento y devuelve la posición en el arreglo
        for (int v=0; v < AVertices.length; v++) {
            if (AVertices[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        Graph grafo = new Graph();
        Methods alfa = new Methods();
        if(RBFS==true){
            Vertex s = grafo.AVertices[0];
            alfa.bfs(grafo,s);
        }
        else{
            alfa.dfs(grafo);
        }
    }
}
