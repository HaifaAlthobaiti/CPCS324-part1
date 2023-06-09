/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/
package NetworkFolder.PhoneNetworkApp;
import GraphFolder.GraphFramework.Vertex;
public class Office extends Vertex {

    private String vertexName;

    public Office() {
        super();
    }

    public Office(String label) {
        super(label);
    }
    
 

    @Override
    public void displayInfo(int label) {
        vertexName = (char) (label + 65) + "";
        System.out.print("Office No. " + vertexName);
        
    }

    @Override
    public void setLabel(String label) {
       
        super.setLabel(label); //To change body of generated methods, choose Tools | Templates.
        
    }
    

    
    
    
}
