/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package NetworkFolder.PhoneNetworkApp;
import GraphFolder.GraphFramework.*;

public class BluePrGraph extends Graph{

    public BluePrGraph() {
    }
    
   

    public BluePrGraph(int verticesNo, int edgeNo) {
        super(verticesNo, edgeNo);
    }
    
    @Override
    public  Vertex createVertex(String Label){
        return new Office(Label);
    }
   
    @Override
    public Edge createEdge(Vertex source, Vertex target, int weight) {
        return new Line(source, target, weight);
    }
    
    
    
    
    
}
