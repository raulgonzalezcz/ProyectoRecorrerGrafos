/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 
/**
 *
 * @author Raúl
 */
public class Methods {
    int time = 0;
    String result="";
    public Vertex rootNode;
    public ArrayList nodes = new ArrayList();
    int size;
    int[][]a;
    public static String newLine = System.getProperty("line.separator"); 
     
    public void dfs(Graph grafo){
        try{
            //Decidimos el lugar donde se van a guardar nuestros resultados
            PrintStream myConsole = new PrintStream(new File("C:\\Users\\Raúl\\Desktop\\Result_dfs.txt")); 
               System.setOut(myConsole);
            //For each...
            for (Vertex u : grafo.AVertices){
                if (u.color.equals("white")){
                   DFSVisit(grafo, u);
                   result = result + "end" + newLine;
                }
            }
            myConsole.print(result);
        }
        catch(FileNotFoundException fx){
            System.out.println(fx);   
        }
    }
    
    public void DFSVisit(Graph grafo, Vertex u){
        a = grafo.adjMatriz;
        time++;
        u.inicio = time;
        u.color = "gray";
        int v1 = indexForName(u.name, grafo.AVertices); //Fila del vértice u dentro de nuestra matriz adyacencias        
        //For each...
        for(int i=0; i<grafo.AVertices.length;i++){
            if(a[v1][i]==1){
               Vertex v = grafo.AVertices[i]; 
               if (v.color.equals("white")){
                   v.papa = u;
                   DFSVisit(grafo, v);
               }
            }
        }
        u.color= "black";
        result = result + u.name + "->";
        time++;
        u.fin = time;
    }
    
    public void setRootNode(Vertex n){
            this.rootNode=n;
            this.rootNode.papa = n;
    }
	
    public Vertex getRootNode(){
            return this.rootNode;
    }
    
    public void bfs(Graph grafo, Vertex u){
        try{
            //Decidimos el lugar donde se van a guardar nuestros resultados
            PrintStream myConsole = new PrintStream(new File("C:\\Users\\Raúl\\Desktop\\result_bfs.txt")); 
            System.setOut(myConsole); 
            bfsVisit(grafo, u);
            for(Vertex z :grafo.AVertices){  
                if(z.color.equals("black")){
                    if(z.equals(getRootNode())){
                        result = z.name + "->" +  "Root" + newLine;
                    }
                    else{
                        result= z.name + "->" +  z.papa.name + newLine;   
                    }
                myConsole.print(result);
                }
            }
        }
        catch(FileNotFoundException fx){
            System.out.println(fx);
        }
    }
    
    public void bfsVisit(Graph grafo, Vertex s){
        //BFS utiliza una estructra de datos conocida como "Cola"
	Queue q = new LinkedList();
        a = grafo.adjMatriz;
	setRootNode(s);
        s.color = "gray";
        s.dis = 0;
        q.add(s);
	while(!q.isEmpty()){
            Vertex u =(Vertex)q.remove();
            int v1 = indexForName(u.name, grafo.AVertices);
            //For each...
            for(int i=0; i<grafo.AVertices.length;i++){
                if(a[v1][i]==1){
                    Vertex v = grafo.AVertices[i]; 
                    if (v.color.equals("white")){
                        v.color="gray";
                        v.dis++;
                        v.papa=u;
                        q.add(v);
                    }            
                }
            u.color="black";                
            }     
        }  
    }
   
    int indexForName(String name, Vertex[] AV) {//Busca un elemento y devuelve la posición en el arreglo
        for (int v=0; v < AV.length; v++) {
            if (AV[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    } 
}
