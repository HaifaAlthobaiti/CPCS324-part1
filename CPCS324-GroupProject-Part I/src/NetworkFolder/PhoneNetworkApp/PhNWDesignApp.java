
package NetworkFolder.PhoneNetworkApp;
import GraphFolder.GraphFramework.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
CPCS324 Group Project | Phase1 
Alaa Algamdi ------2007156 | Section B0B 
Raghed alharbi -----2006518 | Section B0B 
Haifa Althobait-----2010445 | Section B8
Sara Alshaikh-------2005499 | Section B0B 

*/


public class PhNWDesignApp {

   //It is the starting point of the program
    public static void main(String[] args) throws FileNotFoundException {
        
        
        Scanner input = new Scanner(System.in);//scanner to read user choices
        int verticesNo = 0; //number of vertices 
        int edgesNo = 0;    //number of edges 
        //choice of algorithms 
        int caseNumber =0;  //choice of casses 
        //----------------------
        // print menu and ask user to choice 
        System.out.println("-----------------Test and compare diffrent Minimum Spanning Tree Algorithms---------------");
        
        System.out.println("\t1-Kruskal's Algorithm & Prim's Algorithm (Based on MinHeap)");
        
        System.out.println();
        System.out.println(" --------------- (1) Requirement 1 Read Graph From File --------------- ");
        System.out.println(" --------------- (2) Requirement 2 Make Graph  ------------------------ ");
        
        // ------- Read User Input for the Selected Requirement -------- 
        System.out.print("Select Requirement option (1 or 2)  :");

        int userInput = input.nextInt(); // Option of the Requirement

        // make sure user enter within option
        while (userInput != 1 && userInput != 2) {
            System.out.println("Wrong Selection. ");
            System.out.print("Select Requirement option (1 or 2) -> ");
            userInput = input.nextInt();
        }
        
        
        //------------------------Requirement 1-------------------------
        if(userInput==1){
            
            
            System.out.print("is the graph directed(yes/no): ");
            boolean digraphBoolean = false;//intiate the varible with false 
            String digraph = input.next();//take user input 
            if(digraph.equalsIgnoreCase("yes"))//if user enter yes   
            digraphBoolean=true;//change the value of digraph to ture < otherwise it will remain false
            System.out.println();
            
            BluePrGraph Mygraph=new BluePrGraph();
            Mygraph.readFromFile("graph.txt");// Read the graph data from a file called "graph.txt"
            
            
            
            
            //*********************Kruskal Algorithm**********************
             MSTAlgorithm kruskalObj=new KruskalAlgorithm(Mygraph);
             kruskalObj.findMinimumSpanningTree(Mygraph);
             kruskalObj.displayResultingMST();
             System.out.println("_______________________________________________________");
             System.out.println();
             MHPrimAlgorithm PrimObj=new MHPrimAlgorithm(Mygraph);
             PrimObj.findMinimumSpanningTree(Mygraph);
             PrimObj.displayResultingMST();
             
             
             
            
            
        }
        
        //------------------------Requirement 2-------------------------
        
        else if(userInput==2){
        
        // ensure that user enter 1 or 2 
       //end of while loop 
        //printthe menue of casses
            
        System.out.println("----------------- Requirement (2) ------------------");
        System.out.println();
        System.out.println("\tCases (where n represnt # of vertices and m represent # of edges):");
        System.out.println("1-  n =  1,000  , m =   10,000");
        System.out.println("2-  n =  1,000  , m =   15,000");
        System.out.println("3-  n =  1,000  , m =   25,000");
        System.out.println("4-  n =  5,000  , m =   15,000");
        System.out.println("5-  n =  5,000  , m =   25,000");
        System.out.println("6-  n = 10,000  , m =   15,000");
        System.out.println("7-  n = 10,000  , m =   25,000");
        System.out.println();
        while(caseNumber<=0 || caseNumber>7){
            System.out.print(">Enter your choice: ");//aske user to enter a number 
            caseNumber=input.nextInt();//read user input 
        }//end of while loop
        
        
         switch(caseNumber){
            case 1:
                verticesNo = 1000;
                edgesNo = 10000;
                break;
            case 2:
                verticesNo = 1000;
                edgesNo = 15000;
                break;
            case 3:
                verticesNo = 1000;
                edgesNo = 25000;
                break;
            case 4:
                verticesNo = 5000;
                edgesNo = 15000;
                break;
            case 5:
                verticesNo = 5000;
                edgesNo = 25000;
                break;
            case 6:
                verticesNo = 10000;
                edgesNo = 15000;
                break;
            case 7:
                verticesNo = 10000;
                edgesNo = 25000;
                break;
            
            
        }//end of switvh 
         System.out.println();
         System.out.print("is the graph directed(yes/no): ");
        boolean digraphBoolean = false;//intiate the varible with false 
        String digraph = input.next();//take user input 
        if(digraph.equalsIgnoreCase("yes"))//if user enter yes   
            digraphBoolean=true;//change the value of digraph to ture < otherwise it will remain false 
        
        //------------------------------------------------------------
        BluePrGraph MyGraph= new BluePrGraph(verticesNo,edgesNo);
        MyGraph.makeGraph(verticesNo,edgesNo);
        
        
        
        
        
       
        
           
            //********************* KruskalAlgorithm ***************************
            
           KruskalAlgorithm kruskalObj = new KruskalAlgorithm(MyGraph);//create new object 
            double KruskalStartTime = System.currentTimeMillis();//start time of kruskal 
            kruskalObj.findMinimumSpanningTree(MyGraph);//send graph to that kruskal method to start finding the MST
            double KruskalFinishTime = System.currentTimeMillis();//start time of kruskal 
            double totalTimeKruskal = KruskalFinishTime - KruskalStartTime;//find the time taken by kruskal algorithm 
           
            System.out.println("___________________________KruskalAlgorithm__________________________________");
            System.out.println();
            
            System.out.println("Minimum Spanning Tree cost: "+kruskalObj.getTotalWeight());
            System.out.println("Total runtime of kruskal Algorithm: "+ totalTimeKruskal);
            System.out.println();
            
            System.out.println();
            
            
            //*********************PrimAlgorithm***************************
            
            
            MHPrimAlgorithm PrimObj=new MHPrimAlgorithm(MyGraph);
            double StartTimePrim = System.currentTimeMillis();
            PrimObj.findMinimumSpanningTree(MyGraph);
            double PrimFinishTime = System.currentTimeMillis();
            double totalTimePrim =  PrimFinishTime - StartTimePrim;
            
            System.out.println("__________________________MHPrimAlgorithm___________________________________");
            System.out.println();
           
            System.out.println("Minimum Spanning Tree cost: "+PrimObj.getTotalWeight());
            System.out.println("Total runtime of Prim Algorithm: "+ totalTimePrim);
            System.out.println();
            
        
        
            }
        }
     
    }
    

