import java.util.LinkedList;
import java.util.Random;

import processing.core.*;
public class behavior extends PApplet {
	
	Character player1, target;
	Graph graph;
	Map map;
	float previousTime, newTime;
	float algTimeStart, algTimeEnd, generationTimeStart, generationTimeEnd;
	Random rand = new Random();
	int RANGE = 200;
	int NUMBEROFNODES = 1000;
	
	LinkedList<Graph.Edge> path = new LinkedList<Graph.Edge>();
	LinkedList<breadCrumb> crumbs = new LinkedList<breadCrumb>();
	
	class breadCrumb{
		float x,y;
		breadCrumb(float x, float y){
			this.x = x;
			this.y = y;
		}
	}
	public void settings() {
		size( 800,800 );
	}
	
	
	public void setup() {
		
		background( 255 );
		
		graph = new Graph();
		map = new Map( this );
		
		//Create small/large graphs
		//this.smallDijkstra();
		//this.smallGraphAstar();
		//this.largeDijkstra();
		//this.largeAstar();
		
		//Part 4
		//this.part4dijkstra("a", "u");
		//this.part4astar("a", "u");
		
		graph.generatePart4Graph();
		Graph.Edge first = new Graph.Edge();
		first.fromNode = graph.search("a");
		first.toNode = graph.search("a");
		path.add(first);
		player1 = new Character( 40, 40, radians( 0 ), (float) .1, this );
		target = new Character( 40, 40, radians(0), (float) .15, this );
		
		//Print the solution
		//graph.printPath( path );
		//And the performance
		//System.out.println("Algorithm took: " + (algTimeEnd - algTimeStart) + " ms");
		//System.out.println("Node Generation took: " + (generationTimeEnd - generationTimeStart) + " ms");
		//System.out.println("Nodes processed: " + graph.nodesProcessed);
		
		
		previousTime = millis();
	}
	
	public void part4astar(String start, String goal){
		generationTimeStart = millis();
		graph.generatePart4Graph();
		generationTimeEnd = millis();
		
		algTimeStart = millis();
		path = graph.Astar(graph.search(start), graph.search(goal));
		algTimeEnd = millis();
	}
	
	public void part4dijkstra(String start, String goal){
		generationTimeStart = millis();
		graph.generatePart4Graph();
		generationTimeEnd = millis();
		
		algTimeStart = millis();
		path = graph.dijkstra(graph.search(start), graph.search(goal));
		algTimeEnd = millis();
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
		map.drawMap();
		//graph.drawGraph( this );
		//graph.drawPath(this, path);
        if( (newTime) % 4 == 1 ) {
        	crumbs.add(new breadCrumb(player1.position.x, player1.position.y));
        }
		player1.drawCharacter();
		drawCrumbs();
		PathFollow.pathFollow(player1, path, previousTime - newTime);
		
		previousTime = newTime;
	}
	public void mouseClicked( ){
		//find the closest point to character - node and click - node
		int smallestDistanceToStart = Integer.MAX_VALUE;
		int smallestDistanceToClick = Integer.MAX_VALUE;
		
		Graph.Node closestNodeToPlayer = null;
		Graph.Node closestNodeToClick = null;
		
		//Calculate euclidian distance from click and player
		for ( Graph.Node node : graph.nodeList ) {
			int distanceToPlayer =  (int)Math.sqrt( Math.pow(player1.position.x - node.x, 2) + Math.pow(player1.position.y - node.y, 2) );
			int distanceToClick =  (int)Math.sqrt( Math.pow(mouseX - node.x, 2) + Math.pow(mouseY - node.y, 2) );
			
			//update
			if ( distanceToPlayer < smallestDistanceToStart ) {
				smallestDistanceToStart = distanceToPlayer;
				closestNodeToPlayer = node;
			}
			if ( distanceToClick < smallestDistanceToClick ) {
				smallestDistanceToClick = distanceToClick;
				closestNodeToClick = node;
			}
		}
		
		
		//Update the path
		path = graph.Astar(closestNodeToPlayer, closestNodeToClick);
		
	}
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "behavior" });
	  }
	
	public void drawCrumbs(){
		for ( breadCrumb crumb : crumbs ) {
			this.ellipse(crumb.x, crumb.y, 2, 2);
		}
	}
}
