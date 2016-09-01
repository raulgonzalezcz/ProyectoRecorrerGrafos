/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;


/**
 *
 * @author Raúl
 */
public class Vertex {
    String name;
    String color;
    Vertex papa;
    int dis; //Distancia usada para BFS
    //Tiempos utilizados en DFS:
    int inicio; //Tiempo cuando es descubierto
    int fin; //Tiempo cuando es procesado
    
    public Vertex(String name, Vertex papa, String c, int d) { //Vértices para BFS
            this.name = name;
            this.papa = papa;
            this.color = c;
            this.dis = d;
    }
    
    public Vertex(String name, Vertex papa, String c, int a, int b) { //Vértices para DFS
            this.name = name;
            this.papa = papa;
            this.color = c;
            this.inicio = a;
            this.fin = b;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String n){
        color = n;
    }
    
    public int getFin(){
        return fin;
    }
    
    public void setFin(int n){
        fin = n;
    }
    
    public int getDis(){
        return dis;
    }
    
    public void setDis(int n){
        dis = n;
    }
}
