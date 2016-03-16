import processing.core.*;
public class behavior extends PApplet {
	
	Character player1;
	Graph graph;
	float previousTime, newTime;
	
	public void settings() {
		size( 800,800 );
	}
	
	
	public void setup() {
		
		background( 255 );
		
		player1 = new Character( 100, height/2, radians( 0 ), (float) .15, this );
		graph = new Graph();
		
		 // make the graphs... small or large
		graph.generateSimpleGraph();    // this graph represents the city of Sacramento and surrounding cities
		//graph.generateLargeGraph( 1000 );
		
		
		graph.dijkstra(graph.search("Sacramento"), graph.search("Orland"));
		
		previousTime = millis();
	}
	
	public void draw() {
		newTime = millis();
		
		background(160);
		graph.drawGraph( this );

		//player1.drawCharacter();
		
		previousTime = newTime;
	}
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "behavior" });
	  }
}
