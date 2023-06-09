/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package GraphFolder.GraphFramework;
import java.util.List;


/**
 *
 * superclass representing the general characteristics of an algorithm for
 * computing the minimum spanning tree
 */
public abstract class MSTAlgorithm {
    public Graph graph;
    public List<Edge> MSTResultList;
     
     public MSTAlgorithm() {
       this.graph = graph;
    }
    public MSTAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public List<Edge> getMSTResultList() {
        return MSTResultList;
    }

    
   public abstract void findMinimumSpanningTree(Graph graph) ;

    public abstract void displayResultingMST();
    

}
