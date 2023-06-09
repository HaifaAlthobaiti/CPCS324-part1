/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package GraphFolder.GraphFramework;


/*
 *****is a class that represents a graph edges*****
 */
public abstract class  Edge implements Comparable<Edge>{

    /*
        Source vertex, destination vertex and
        parent vertex;
     */
   private Vertex source, destination, parent;

    //holds the weight assigned to the edge connecting the source and target vertices.
    private int weight;

    //--------------------Constructors---------------

    public Edge() {
    }
    

    public Edge(Vertex source, Vertex destination, int weight, Vertex parent) {
        this.source = source;
        this.destination = destination;
        this.parent = parent;
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    

    //***********Getter And Settor **************
    public  Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getparent() {
       return parent;

    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //--------------------Method And Function------------
    //1- method is responsible for displaying the information of the class attributes
    public abstract void displayInfo() ;

    @Override
    public int compareTo(Edge edge) {
       Edge e=edge;
       return (this.weight<e.weight)    ?   -1
               : (this.weight> e.weight)    ?    1:0;
    }
    

}
