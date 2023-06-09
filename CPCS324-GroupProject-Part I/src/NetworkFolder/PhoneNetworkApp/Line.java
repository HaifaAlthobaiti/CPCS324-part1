/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package NetworkFolder.PhoneNetworkApp;
import GraphFolder.GraphFramework.*;
 

 /**
 * A custom class that represents a line in a graph, which extends the Edge class.
 * The Line class has a length field that is calculated as 5 times the weight of the edge.
 */
public class Line extends Edge {
    
    //--------------Attributes------------------
    
    private int Llength;
 
    //--------------------Constructors---------------
    public Line() {
        super();
    }
    
    public Line(Vertex source, Vertex destination, int weight) {
        super(source, destination, weight);
        this.Llength = weight *5;  // Calculate the length as 5 times the weight
    }

    
    public void setLlength(int Llength) {
        this.Llength = Llength *5; // Calculate the length as 5 times the weight
    }
    
    // Override the displayInfo method of the Edge class to print the line information
    @Override
    public void displayInfo() {
       
        System.out.println("Office No. "+ getSource().getLabel().replaceAll("\\d+", "")+"___ " +
                getDestination().getLabel().replaceAll("\\d+", "")+ " : line length: " + Llength);
    }
    

    
    
}
