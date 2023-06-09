package GraphFolder.GraphFramework;

import NetworkFolder.PhoneNetworkApp.BluePrGraph;
import NetworkFolder.PhoneNetworkApp.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class KruskalAlg extends MSTAlgorithm {

    int cost;
    Graph graph;

    public void Kurskal(Graph graph) {
        int verticesNo = graph.verticesNo;
        MSTResultList = new Line[verticesNo - 1];
        List<Edge> edges = new ArrayList<>();

        //Edge[] edges = new Line[graph.edgeNo];
        for (int i = 0; i < verticesNo; i++) {
            Vertex V = graph.vertices[i];
            for (int j = 0; j < V.adjList.size(); j++) {
                edges.add(V.adjList.get(j));
             
            }
        }
        Collections.sort(edges);
        

        Edge[] subsets = new Line[verticesNo];
        makeSet(subsets);
        int MSTedges = 0;
        for (int i = 0; i < graph.edgeNo && MSTedges < verticesNo - 1; i++) {
            Edge edge = edges.get(i);
            String source_subset = find(subsets, edge.source.label,i);
            String target_subset = find(subsets, edge.destination.label,i);

            if (source_subset != target_subset) {
                MSTResultList[MSTedges] = edge;
                cost += edge.weight;
                MSTedges++;
                union(subsets, source_subset, target_subset,i);
            }
        }
    }

    public void makeSet(Edge[] edges) {
        for (int i = 0; i < edges.length; i++) {
            edges[i] = graph.createEdge();
            edges[i].source.label = "";
            edges[i].parent.label = "";
        }
    }

    public String find(Edge[] edges, String vertex, int indexO) {

        if (edges[indexO].parent.label != vertex) {
            return find(edges, edges[indexO].parent.label,indexO);
        }
        return vertex;
    }

    public void union(Edge[] edges, String source_vertex, String target_vertex,int indexOf) {
        String x_set_parent = find(edges, source_vertex,indexOf);
        String y_set_parent = find(edges, target_vertex,indexOf+1);
        edges[indexOf+1].parent.label = x_set_parent;
    }

    public void displayResultingMST(BluePrGraph graph) {
        for (int i = 0; i < MSTResultList.length; i++) {
            System.out.println(MSTResultList[i].source.label + "  " + MSTResultList[i].destination.label + " w: " + MSTResultList[i].weight);
        }
    }

    public int getCost() {
        return cost;
    }
}
