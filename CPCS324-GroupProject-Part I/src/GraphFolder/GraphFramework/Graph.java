/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package GraphFolder.GraphFramework;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import NetworkFolder.PhoneNetworkApp.*;



    //*******class defines the structure of a graph************


public abstract class  Graph {
    
    //--------------Attributes------------------
    
    private int verticesNo; //number of vertices of the graph
    
    private int edgeNo; //number of edges of the graph.
    
    boolean isDigraph=false;; //if the graph is directed graph=True//if the graph is undirected graph=False 

   private Vertex vertices [] ;//is a list/vector representing the list of vertices of a graph.
    
   Random random = new Random();
   
    //--------------------Constructors---------------
    
    public Graph() {
    }
       
    public Graph(int verticesNo, int edgeNo) {
       this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph=false;
        vertices = new Vertex[verticesNo];
        
    }
    

    /*
    
    Getters For All Atributes 
    
     */

    public int getVerticesNo() {
        return verticesNo;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

    public boolean isIsDigraph() {
        return isDigraph;
    }

    public Vertex [] getVertices() {
        return vertices;
    }
    public Vertex getVertex(int i) {
        return vertices[i];
    }

    /**
     *
     * Setters
     */
    public void setVerticesNo(int verticesNo) {
        this.verticesNo = verticesNo;
    }

    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    public void setIsDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public void setVertices( Vertex vertices[]) {
        this.vertices = vertices;
    }


    

   
   

     //---------------Method And Function------------
    
   
    public void makeGraph(int Ver, int edge) { //Ver as number of vertx , edge as number of edge
        this.verticesNo=Ver;
        this.edgeNo=edge;
        //Creating the vertices
        
        
        vertices = new Office[verticesNo];
        
        
        // Iterate over the array, creating a new vertex for each index and adding it to the vertices array
        for (int i = 0; i < vertices.length; i++) {
            Vertex office1=createVertex("O"+1);
             vertices[i]=office1;
        }
        
       
        

        //----------create a connected graph with number of vertices----------
        
        // We assigen Vertex to next Vertex to mack sure connected
        for (int i = 0; i < vertices.length-1 ; i++) {
            int weight = random.nextInt(30) + 1; // random weight between 0 and 30
            addEdge(vertices[i], vertices[i+1], weight); //add to graph 
            
        }

        // generate edges randomly between vertex
        int remEdges = edge - (Ver - 1);
        for (int i = 0; i < remEdges; i++) {
            int sourceindex = (int) (Math.random() * (vertices.length-1));
            int targetindex = (int) (Math.random() * (vertices.length-1));
            // to avoid self loops and duplicate edges
            if (sourceindex == targetindex ) {//if the source is equal to the 
                continue; 
            }
            // if diffrent Find both Vertex in Array 
            Vertex sourceV = vertices[sourceindex];
            Vertex sourceT = vertices[targetindex];
            
            if (isConnected(sourceindex, targetindex)) { 
                continue;
            }
            if(isDigraph && isConnected(targetindex, sourceindex)){ //if the graph is directed i need to seach for both
                continue;                                            //taret and source becouse they have diffrent value 
            }
            // generate random weights in range 0 to 30
            int weight = random.nextInt(30) + 1;
            
            // add edge to the graph
           
            addEdge(sourceV, sourceT, weight);
            
            

        }
        
        
        
         
         
}
    
    
    //-------------isConnected Method---------- : To check the if connected or not 
    
     private boolean isConnected(int srcVert, int destVert) {
         for(int i=0;i<vertices[srcVert].getAdjList().size();i++){//for all edges of source vertex
             if ((vertices[srcVert].getAdjList().get(i).getDestination() == vertices[destVert])) {//if there is an edge with the taget id 
                return true;//return true 
            }
        
    }
         return false;
         }
     //-------------------Read From file Metho--------------------------
     
    public void readFromFile(String fileName) throws FileNotFoundException {
       File file = new File(fileName);
       Scanner input = new Scanner (file);
       
       if("digraph 1".equals(input.nextLine()))
            this.isDigraph=true; 
       // read number of vertices
       
       int r = input.nextInt();
       // read number of edges
       
       int s= input.nextInt();
       
       this.vertices = new Vertex[r];
        
        for (int i = 0; i < s; i++) {
            String s1=input.next();
            String s2=input.next();
            int w = input.nextInt();
            
            if(vertices[(s1.charAt(0))-'A']==null){
                this.verticesNo++;
                vertices[(s1.charAt(0))-'A']= createVertex(s1+i);
            }
          
            
            if(vertices[(s2.charAt(0))-'A']==null){ 
                this.verticesNo++; 
                vertices[(s2.charAt(0))-'A']= createVertex(s2+i);
            }
           
            
            Vertex vertex1 = vertices[s1.charAt(0) - 'A'];
            Vertex vertex2 = vertices[s2.charAt(0) - 'A'];
            addEdge(vertex1, vertex2, w);

            if (!isDigraph) {
                
                vertex1 = vertices[s1.charAt(0) - 'A'];
                vertex2 = vertices[s2.charAt(0) - 'A'];
                addEdge(vertex2, vertex1, w);
            }
        }
        
     }

  
    
     
 

     
 

     
    //-------------Method add Edge------------- 
    
    public void addEdge(Vertex Source, Vertex Target, int weight) {
       
         Edge edge = createEdge(Source,Target,weight); // creates an edge object
         Source.getAdjList().add(edge);
         if (isDigraph) {
            edgeNo++;
        }
          else{
             this.edgeNo=this.edgeNo+2;
          edge = createEdge(Target, Source,weight);  
          Target.getAdjList().add(edge);
          }
       
    }  
    
    
   
    
    // ------------ create Vertex abstract method ---------
     public  abstract Vertex createVertex(String label);
     public  abstract Edge createEdge(Vertex v, Vertex u, int w);
    }






