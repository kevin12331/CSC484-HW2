import java.util.LinkedList;
import java.util.Random;

import processing.core.*;
public class behavior extends PApplet {
	
	Character player1;
	Graph graph;
	float previousTime, newTime;
	float algTimeStart, algTimeEnd, generationTimeStart, generationTimeEnd;
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
		
		//Run an algorithm
		//this.smallDijkstra();
		this.smallGraphAstar();
		//this.largeDijkstra();
		//this.largeAstar();
		
		//Print the solution
		graph.printPath( path );
		//And the performance
		System.out.println("Algorithm took: " + (algTimeEnd - algTimeStart) + " ms");
		System.out.println("Node Generation took: " + (generationTimeEnd - generationTimeStart) + " ms");
		System.out.println("Nodes processed: " + graph.nodesProcessed);
		
		
		previousTime = millis();
	}
	
	public void smallDijkstra(){
		generationTimeStart = millis();
		graph.generateSimpleGraph();    // this graph represents the city of Sacramento and surrounding cities
		generationTimeEnd = millis();
		
		algTimeStart = millis();
		path = graph.dijkstra(graph.search("Markleeville"), graph.search("Yuba City"));
		algTimeEnd = millis();
	}
	
	public void largeDijkstra(){
		generationTimeStart = millis();
		graph.generateLargeGraph( NUMBEROFNODES, RANGE );
		generationTimeEnd = millis();
		
		algTimeStart = millis();
		path = graph.dijkstra(graph.search(Integer.toString(rand.nextInt(200))), graph.search(Integer.toString(rand.nextInt(200))) ) ;
		algTimeEnd = millis();
	}
	
	public void smallGraphAstar(){
		generationTimeStart = millis();
		graph.generateSimpleGraph();    // this graph represents the city of Sacramento and surrounding cities
		generationTimeEnd = millis();
		
		algTimeStart = millis();
		path = graph.Astar( graph.search("Markleeville"), graph.search("Sacramento") );
		algTimeEnd = millis();
	}
	
	public void largeAstar(){
		generationTimeStart = millis();
		graph.generateLargeGraph( NUMBEROFNODES, RANGE );
		generationTimeEnd = millis();
		
		algTimeStart = millis();
		path = graph.Astar(graph.search(Integer.toString(rand.nextInt(200))), graph.search(Integer.toString(rand.nextInt(200))) ) ;
		algTimeEnd = millis();
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
