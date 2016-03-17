import java.util.LinkedList;
import java.util.Random;

import processing.core.*;
public class behavior extends PApplet {
	
	Character player1;
	Graph graph;
	float previousTime, newTime;
	float dijkstraTimeStart, dijkstraTimeEnd, generationTimeStart, generationTimeEnd;
	Random rand = new Random();
	int RANGE = 200;
	int NUMBEROFNODES = 1000;
	
	LinkedList<Graph.Edge> path = new LinkedList<Graph.Edge>();
	
	public void settings() {
		size( 800,800 );
	}
	
	
	public void setup() {
		
		background( 255 );
		
		player1 = new Character( 100, height/2, radians( 0 ), (float) .15, this );
		graph = new Graph();
		
		
		//Time dijkstras algorithm
		
		 // SMALL GRAPH + dijkstra example
		generationTimeStart = millis();
		graph.generateSimpleGraph();    // this graph represents the city of Sacramento and surrounding cities
		generationTimeEnd = millis();
		
		dijkstraTimeStart = millis();
		path = graph.dijkstra(graph.search("Markleeville"), graph.search("Yuba City"));
		dijkstraTimeEnd = millis();
		
		
		// LARGE GRAPH + dijkstra example
		//generationTimeStart = millis();
		//graph.generateLargeGraph( NUMBEROFNODES, RANGE );
		//generationTimeEnd = millis();
		
		//dijkstraTimeStart = millis();
		//path = graph.dijkstra(graph.search(Integer.toString(rand.nextInt(200))), graph.search(Integer.toString(rand.nextInt(200))) ) ;
		//dijkstraTimeEnd = millis();
		
		
		//Print out the nodes of the solution path
		graph.printPath( path );
		//And the time it took
		System.out.println("Algorithm took: " + (dijkstraTimeEnd - dijkstraTimeStart) + " ms");
		System.out.println("Node Generation took: " + (generationTimeEnd - generationTimeStart) + " ms");
		System.out.println("Nodes processed: " + graph.nodesProcessedDijkstra);
		
		previousTime = millis();
	}
	
	public void draw() {
		newTime = millis();
		
		background(160);
		graph.drawGraph( this );
		
		graph.drawPath(this, path);

		//player1.drawCharacter();
		
		previousTime = newTime;
	}
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "behavior" });
	  }
}
