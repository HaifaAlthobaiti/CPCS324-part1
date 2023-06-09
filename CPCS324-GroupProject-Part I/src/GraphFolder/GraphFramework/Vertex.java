/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package GraphFolder.GraphFramework;
import java.util.LinkedList;

public abstract class  Vertex {
    /*
    
    ****is a class that represents a graph vertex****
    
    */
    
    
    //represent vertex Lable 
     private String label;
    
    //Set to true if the current vertex is visited within a certain operation like graph traversal.
     boolean isVisited;
    
    //Represents the adjacency list of a vertex
    private LinkedList<Edge> adjList;
    
    //--------------------Constructor---------------
    
    public Vertex() {
      this.label = label;
      this.isVisited = true;
      adjList = new LinkedList<Edge>() ;
      
    }
    public Vertex(String label) {
        this.label = label;
        this.isVisited = true;
        adjList = new LinkedList<Edge>() ;
        
        
    }
    
    //***********Getter And Settor **************
    public String getLabel() {
        return label;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public LinkedList<Edge> getAdjList() {
        return adjList;
    }

    public void setLabel(String label) { 
      
      this.label=label;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setAdjList(LinkedList<Edge> adjList) {
        this.adjList = adjList;
    }
    //--------------------Method And Function------------
    
    //1- method is responsible for displaying the information of the class attributes
    
       public abstract void displayInfo(int Label) ;
        
    
     
      
}
