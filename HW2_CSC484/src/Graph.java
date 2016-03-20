

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import processing.core.PApplet;

class Graph {
	
	Hashtable<String, Node> nodes = new Hashtable<String, Node>();
	LinkedList<Edge> edges = new LinkedList<Edge>();
	LinkedList<Node> nodeList = new LinkedList<Node>();
	Random rand = new Random();

	int nodesProcessed = 0;
	int part4RANGE = 5;
	
	
	//Generate whatever you want here
	void generateSimpleGraph(){
		this.createDoubleEdge("Sacramento", "Yuba City", 400, 400, 400, 200, 10);
		this.createDoubleEdge("Sacramento", "Roseville", 400, 400, 500 , 300, 5);
		this.createDoubleEdge("Sacramento", "Placerville", 400, 400, 600 , 400, 10);
		this.createDoubleEdge("Sacramento", "Woodland", 400, 400, 350 , 400, 7);
		this.createDoubleEdge("Sacramento", "Davis", 400, 400, 350, 420, 9);
		this.createDoubleEdge("Sacramento", "Lodi", 400, 400, 400, 600, 10);
		this.createDoubleEdge("Sacramento", "Sutter Creek", 400, 400, 500, 550, 7);
		this.createDoubleEdge("Yuba City", "Oroville", 400, 200, 400, 100, 3);
		this.createDoubleEdge("Yuba City", "Grass City", 400, 200, 550, 150, 5);
		this.createDoubleEdge("Yuba City", "Williams", 400, 200, 375, 275, 4);
		this.createDoubleEdge("Woodland", "Williams", 350, 400, 375, 275, 5);
		this.createDoubleEdge("Woodland", "Wilbur Springs", 350, 400, 300 , 300, 9);
		this.createDoubleEdge("Woodland", "Davis", 350, 400, 350 , 420, 3);
		this.createDoubleEdge("Roseville", "Auburn", 500, 300, 600 , 300, 2);
		this.createDoubleEdge("Auburn", "Colfax", 600, 300, 630 , 180, 2);
		this.createDoubleEdge("Auburn", "Grass City", 600, 300, 550 , 150, 5);
		this.createDoubleEdge("Grass City", "Nevada City", 550, 150, 600 , 130, 3);
		this.createDoubleEdge("Colfax", "Nevada City", 630, 180, 600 , 130, 1);
		this.createDoubleEdge("Sutter Creek", "Kirkwood", 500, 550, 700, 550, 1);
		this.createDoubleEdge("Sutter Creek", "Angels Camp", 500, 550, 590, 700, 5);
		this.createDoubleEdge("Sutter Creek", "Stockton", 500, 550, 400, 700, 10);
		this.createDoubleEdge("Lodi", "Stockton", 400, 600, 400, 700, 3);
		this.createDoubleEdge("Angels Camp", "Stockton", 590, 700, 400, 700, 7);
		this.createDoubleEdge("Angels Camp", "Markleeville", 590, 700, 680, 625, 2);
		this.createDoubleEdge("Markleeville", "Kirkwood", 680, 625, 700, 550, 3);
		this.createDoubleEdge("Placerville", "Kirkwood", 600, 400, 700, 550, 4);
		this.createDoubleEdge("Stockton", "Anitoch", 400, 700, 350, 680, 3);
		this.createDoubleEdge("Rio Vista", "Anitoch", 350, 640, 350, 680, 1);
		this.createDoubleEdge("Lodi", "Rio Vista", 400, 600, 350, 640, 4);
		this.createDoubleEdge("Anitoch", "Concord", 350, 640, 300, 640, 1);
		this.createDoubleEdge("Fairfield", "Concord", 280, 550, 300, 640, 2);
		this.createDoubleEdge("Fairfield", "Lodi", 310, 590, 400, 600, 6);
		this.createDoubleEdge("Fairfield", "Napa", 310, 590, 200, 460, 4);
		this.createDoubleEdge("Wilbur Springs", "Slepton", 350, 400, 60, 240, 5);
		this.createDoubleEdge("Yuba City", "Chico", 200, 400, 200, 100, 7);
		this.createDoubleEdge("Oroville", "Chico", 200, 400, 200, 100, 3);
		this.createDoubleEdge("Orland", "Chico", 100, 110, 200, 100, 2);
		this.createDoubleEdge("Orland", "Willows", 100, 110, 110, 150, 1);
		this.createDoubleEdge("Willows", "Williams", 100, 110, 200, 100, 2);
		this.createDoubleEdge("Woodland", "Napa", 100, 110, 200, 100, 3);
	}
	
	
	void generateLargeGraph( int numberOfEdges, int RANGE ) {
		Random rand = new Random();
		
		for ( int i = 0; i < numberOfEdges; i++ ) {
			this.createDoubleEdge(Integer.toString(rand.nextInt(RANGE)), Integer.toString(rand.nextInt(RANGE)), rand.nextInt(800), rand.nextInt(800), rand.nextInt(800), rand.nextInt(800), rand.nextInt(30));
		}

	}
	
	void generatePart4Graph() {
		this.createDoubleEdge("a", "b", 40, 40, 112, 40, 5);
		this.createDoubleEdge("b", "c", 40, 40, 45, 174, 5);
		this.createDoubleEdge("c", "d", 40, 40, 183, 179, 5);
		this.createDoubleEdge("b", "d", 40, 40, 112, 40, 5);
		this.createDoubleEdge("a", "c", 40, 40, 112, 40, 5);
		this.createDoubleEdge("a", "d", 40, 40, 112, 40, 5);
		this.createDoubleEdge("b", "f", 40, 40, 406, 46, 5);
		this.createDoubleEdge("b", "e", 40, 40, 270, 108, 5);
		this.createDoubleEdge("d", "e", 40, 40, 270, 108, 5);
		this.createDoubleEdge("d", "g", 40, 40, 400, 170, 5);
		this.createDoubleEdge("f", "g", 40, 40, 400, 170, 5);
		this.createDoubleEdge("e", "f", 40, 40, 400, 170, 5);
		this.createDoubleEdge("e", "g", 40, 40, 400, 170, 5);
		this.createDoubleEdge("g", "h", 40, 40, 552, 108, 5);
		this.createDoubleEdge("f", "h", 40, 40, 552, 108, 5);
		this.createDoubleEdge("h", "i", 40, 40, 625, 50, 5);
		this.createDoubleEdge("h", "k", 40, 40, 625, 157, 5);
		this.createDoubleEdge("i", "k", 40, 40, 625, 157, 5);
		this.createDoubleEdge("i", "j", 40, 40, 735, 50, 5);
		this.createDoubleEdge("j", "l", 40, 40, 735, 157, 5);
		this.createDoubleEdge("k", "l", 40, 40, 735,7, 5);
		this.createDoubleEdge("k", "j", 40, 40, 735, 7, 5);
		this.createDoubleEdge("f", "i", 40, 40, 735, 7, 5);
		this.createDoubleEdge("g", "k", 40, 40, 735, 7, 5);
		
		this.createDoubleEdge("g", "m", 40, 40, 451, 219, 5);
		this.createDoubleEdge("h", "m", 40, 40, 451, 219, 5);
		this.createDoubleEdge("f", "m", 40, 40, 451, 219, 5);
		this.createDoubleEdge("f", "n", 40, 40, 596, 229, 5);
		this.createDoubleEdge("m", "n", 40, 40, 596, 229, 5);
		this.createDoubleEdge("k", "n", 40, 40, 596, 229, 5);
		this.createDoubleEdge("l", "n", 40, 40, 596, 229, 5);
		this.createDoubleEdge("g", "n", 40, 40, 596, 229, 5);
		this.createDoubleEdge("o", "n", 730, 241, 596, 229, 5);
		this.createDoubleEdge("o", "l", 730, 241, 596, 229, 5);
		this.createDoubleEdge("o", "i", 730, 241, 596, 229, 5);;
		this.createDoubleEdge("o", "k", 730, 241, 596, 229, 5);
		this.createDoubleEdge("c", "e", 730, 241, 596, 229, 5);
		this.createDoubleEdge("e", "h", 730, 241, 596, 229, 5);
		this.createDoubleEdge("h", "n", 730, 241, 596, 229, 5);
		
		this.createDoubleEdge("p", "m", 452, 364, 596, 229, 5);
		this.createDoubleEdge("n", "p", 452, 364, 596, 229, 5);
		this.createDoubleEdge("p", "o", 452, 364, 596, 229, 5);
		this.createDoubleEdge("p", "q", 452, 364, 598, 381, 5);
		this.createDoubleEdge("m", "q", 452, 364, 598, 381, 5);
		this.createDoubleEdge("n", "q", 452, 364, 598, 381, 5);
		this.createDoubleEdge("o", "q", 452, 364, 598, 381, 5);
		this.createDoubleEdge("q", "r", 452, 364, 735, 385, 5);
		this.createDoubleEdge("r", "n", 452, 364, 735, 385, 5);
		this.createDoubleEdge("o", "r", 452, 364, 735, 385, 5);
		
		this.createDoubleEdge("r", "s", 452, 364, 448, 538, 5);
		this.createDoubleEdge("p", "s", 452, 364, 448, 538, 5);
		this.createDoubleEdge("q", "s", 452, 364, 448, 538, 5);
		this.createDoubleEdge("j", "s", 452, 364, 448, 538, 5);
		this.createDoubleEdge("n", "s", 452, 364, 448, 538, 5);
		this.createDoubleEdge("s", "t", 452, 364, 592, 550, 5);
		this.createDoubleEdge("r", "t", 452, 364, 448, 592, 5);
		this.createDoubleEdge("q", "t", 452, 364, 448, 592, 5);
		this.createDoubleEdge("p", "t", 452, 364, 448, 592, 5);
		this.createDoubleEdge("u", "t", 730, 578, 448, 592, 5);
		this.createDoubleEdge("u", "r", 730, 578, 448, 592, 5);
		this.createDoubleEdge("u", "p", 730, 578, 448, 592, 5);
		this.createDoubleEdge("u", "n", 730, 578, 448, 592, 5);
		this.createDoubleEdge("u", "q", 730, 578, 448, 592, 5);
		
		this.createDoubleEdge("s", "z", 730, 578, 564, 649, 5);
		this.createDoubleEdge("t", "z", 730, 578, 564, 649, 5);
		this.createDoubleEdge("p", "z", 730, 578, 564, 649, 5);
		this.createDoubleEdge("q", "z", 730, 578, 564, 649, 5);

		this.createDoubleEdge("a1", "z", 452, 662, 564, 649, 5);
		this.createDoubleEdge("a1", "s", 452, 662, 564, 649, 5);
		this.createDoubleEdge("a1", "t", 452, 662, 564, 649, 5);
		this.createDoubleEdge("a1", "q", 452, 662, 564, 649, 5);
		
		this.createDoubleEdge("v", "t", 701, 620, 564, 649, 5);
		this.createDoubleEdge("v", "u", 701, 620, 564, 649, 5);
		this.createDoubleEdge("v", "q", 701, 620, 564, 649, 5);
		this.createDoubleEdge("v", "r", 701, 620, 564, 649, 5);
		this.createDoubleEdge("v", "w", 701, 640, 671, 710, 5);
		this.createDoubleEdge("w", "u", 701, 630, 671, 694, 5);
		
		this.createDoubleEdge("x", "u", 701, 620, 709, 707, 5);
		this.createDoubleEdge("x", "v", 701, 620, 709, 707, 5);
		this.createDoubleEdge("x", "w", 701, 620, 709, 707, 5);
		this.createDoubleEdge("x", "y", 701, 620, 751, 758, 5);
		this.createDoubleEdge("u", "y", 701, 620, 751, 758, 5);
		this.createDoubleEdge("w", "y", 701, 620, 751, 758, 5);
		
		this.createDoubleEdge("b1", "y", 591, 740, 751, 758, 5);
		this.createDoubleEdge("b1", "c1", 701, 620, 591, 706, 5);
		this.createDoubleEdge("c1", "z", 701, 620, 591, 706, 5);
		this.createDoubleEdge("c1", "w", 701, 620, 591, 706, 5);
		this.createDoubleEdge("b1", "w", 701, 620, 591, 706, 5);
		this.createDoubleEdge("b1", "z", 701, 620, 591, 706, 5);
		this.createDoubleEdge("d1", "z", 509, 702, 591, 706, 5);
		this.createDoubleEdge("d1", "a1", 701, 620, 591, 706, 5);
		this.createDoubleEdge("d1", "c1", 701, 620, 591, 706, 5);
		this.createDoubleEdge("d1", "b1", 701, 620, 591, 706, 5);
		this.createDoubleEdge("d1", "i1", 701, 620, 519, 740, 5);
		this.createDoubleEdge("c1", "i1", 701, 620, 519, 740, 5);
		this.createDoubleEdge("b1", "i1", 701, 620, 519, 740, 5);
		this.createDoubleEdge("a1", "i1", 701, 620, 519, 740, 5);

		this.createDoubleEdge("h1", "t", 372, 632, 519, 740, 5);
		this.createDoubleEdge("h1", "a1", 372, 632, 519, 740, 5);
		this.createDoubleEdge("h1", "z", 372, 632, 519, 740, 5);
		this.createDoubleEdge("h1", "j1", 372, 632, 377, 713, 5);
		this.createDoubleEdge("j1", "a1", 372, 632, 377, 713, 5);
		this.createDoubleEdge("j1", "s", 372, 632, 377, 713, 5);
		this.createDoubleEdge("j1", "z", 372, 632, 377, 713, 5);
		this.createDoubleEdge("j1", "d1", 372, 632, 377, 713, 5);
		this.createDoubleEdge("j1", "i1", 372, 632, 377, 713, 5);

		this.createDoubleEdge("k1", "i1", 244, 730, 377, 713, 5);
		this.createDoubleEdge("k1", "j1", 244, 730, 377, 713,5);
		this.createDoubleEdge("k1", "h1", 244, 730, 377, 713, 5);
		this.createDoubleEdge("k1", "n1", 244, 730, 218, 674, 5);
		this.createDoubleEdge("n1", "h1", 244, 730, 218, 674, 5);
		this.createDoubleEdge("n1", "j1", 244, 730, 218, 674, 5);
		this.createDoubleEdge("n1", "o1", 244, 730, 77, 640, 5);
		this.createDoubleEdge("n1", "m1", 244, 730, 56, 742, 5);
		this.createDoubleEdge("o1", "m1", 244, 730, 56, 742, 5);
		this.createDoubleEdge("k1", "m1", 244, 730, 56, 742, 5);

		
		this.createDoubleEdge("p1", "m1", 226, 586, 56, 742, 5);
		this.createDoubleEdge("p1", "n1", 226, 586, 56, 742,5);
		this.createDoubleEdge("p1", "o1", 226, 586, 56, 742, 5);
		this.createDoubleEdge("p1", "h1", 226, 586, 56, 742, 5);

		this.createDoubleEdge("q1", "p1", 326, 476, 56, 742, 5);
		this.createDoubleEdge("q1", "h1", 326, 476, 56, 742, 5);
		this.createDoubleEdge("q1", "n1", 326, 476, 56, 742, 5);
		this.createDoubleEdge("q1", "o1", 326, 476, 56, 742, 5);

		this.createDoubleEdge("r1", "q1", 74, 464, 56, 742, 5);
		this.createDoubleEdge("r1", "p1", 326, 476, 56, 742, 5);
		this.createDoubleEdge("r1", "o1", 326, 476, 56, 742, 5);
		this.createDoubleEdge("r1", "n1", 326, 476, 56, 742, 5);

		this.createDoubleEdge("s1", "r1", 252, 372, 56, 742, 5);
		this.createDoubleEdge("s1", "q1", 326, 476, 56, 742, 5);
		this.createDoubleEdge("s1", "u1", 326, 476, 90, 313, 5);
		this.createDoubleEdge("s1", "t1", 326, 476, 342, 337, 5);
		this.createDoubleEdge("q1", "t1", 326, 476, 342, 337, 5);
		this.createDoubleEdge("h1", "t1", 326, 476, 342, 337, 5);
		this.createDoubleEdge("u1", "r1", 326, 476, 342, 337, 5);
		this.createDoubleEdge("u1", "t1", 326, 476, 342, 337, 5);

		
		this.createDoubleEdge("z1", "t1", 244, 281, 342, 337, 5);
		this.createDoubleEdge("z1", "s1", 244, 281, 342, 337, 5);
		this.createDoubleEdge("z1", "u1", 244, 281, 342, 337, 5);
		
		this.createDoubleEdge("v1", "t1", 345, 261, 342, 337, 5);
		this.createDoubleEdge("v1", "z1", 244, 281, 342, 337, 5);
		this.createDoubleEdge("v1", "s1", 244, 281, 342, 337, 5);

		this.createDoubleEdge("v1", "w1", 244, 281, 324, 174, 5);
		this.createDoubleEdge("w1", "d", 244, 281, 324, 174, 5);
		this.createDoubleEdge("w1", "g", 244, 281, 324, 174, 5);
		this.createDoubleEdge("w1", "b", 244, 281, 324, 174, 5);

		this.createDoubleEdge("x1", "z1", 171, 265, 324, 174, 5);
		this.createDoubleEdge("x1", "d", 171, 237, 324, 174, 5);
		this.createDoubleEdge("x1", "c", 171, 237, 324, 174, 5);
		this.createDoubleEdge("u1", "c", 171, 237, 324, 174, 5);
		this.createDoubleEdge("u1", "x1", 171, 237, 324, 174, 5);
		
		this.createDoubleEdge("c", "p1", 171, 237, 324, 174, 5);
		this.createDoubleEdge("c", "h1", 171, 237, 324, 174, 5);
		this.createDoubleEdge("a", "n", 171, 237, 324, 174, 5);



		
	}
	
	void drawPath( PApplet parent, LinkedList<Edge> path ){
		for ( Edge edge : path ) {
			parent.stroke(255, 0, 0);
			parent.fill(100,0,0);
			parent.ellipse(edge.fromNode.x, edge.fromNode.y, 10, 10);
			parent.ellipse(edge.toNode.x, edge.toNode.y, 10, 10);
			parent.line( edge.fromNode.x, edge.fromNode.y, edge.toNode.x, edge.toNode.y);
		}
	}
	
	
	LinkedList<Edge> dijkstra( Node start, Node goal ) {
		
		NodeRecord startRecord = new NodeRecord();
		NodeRecord endNodeRecord;
		NodeRecord current = new NodeRecord();
		LinkedList<Edge> path = new LinkedList<Edge>();
		startRecord.node = start;
		startRecord.connection = null;
		startRecord.costSoFar = 0;
		
		PathfindingList openList = new PathfindingList();
		openList.add( startRecord );
		PathfindingList closedList = new PathfindingList();
		
		while ( openList.list.size() > 0 ) {
			current = openList.smallestElement();
			
			if ( current.node.equals( goal ) )
				break;
			
			LinkedList<Edge> connections = getNeighbors( current.node );
			
			for ( Edge connection : connections) {
				nodesProcessed++;
				Node endNode = connection.toNode;
				int endNodeCost = current.costSoFar + connection.weight;
				
				if ( closedList.contains( endNode ) ){
					continue;
				}else if ( openList.contains( endNode ) ){
					endNodeRecord = openList.find( endNode );
					if ( endNodeRecord.costSoFar <= endNodeCost )
						continue;
				}else{
					endNodeRecord = new NodeRecord();
					endNodeRecord.node = endNode;
				}
				
				endNodeRecord.costSoFar = endNodeCost;
				endNodeRecord.connection = connection;
				
				if ( !openList.contains( endNode ) )
					openList.add( endNodeRecord );
			}
			openList.remove( current );
			closedList.add( current );
		}
		
		if ( !current.node.equals( goal ) )
			System.out.println("No sol'n :( sorry ");
		else{
			while ( !current.node.equals( start ) ){
				path.add(current.connection);

				current = closedList.find( current.connection.fromNode );
			}
		}
		path = reverse(path);
		
		return path;
	}
	
	class Heuristic {
		Node goal;

		Heuristic( Node goal ) {
			this.goal = goal;
		}
		int constantEstimate( Node node ) {
			return 5;
		}
		int euclidianDistance( Node node ) {
			//Euclidian
			return (int)Math.sqrt( Math.pow(goal.x - node.x, 2) + Math.pow(goal.y - node.y, 2) );
			//Constant
			//return 1;
		}
	}
	
	LinkedList<Edge> Astar( Node start, Node goal ) {
		NodeRecord startRecord = new NodeRecord();
		NodeRecord endNodeRecord;
		NodeRecord current = new NodeRecord();
		LinkedList<Edge> path = new LinkedList<Edge>();
		Heuristic heuristic = new Heuristic( goal );
		int endNodeHeuristic = 0;
		startRecord.node = start;
		startRecord.connection = null;
		startRecord.costSoFar = 0;
		startRecord.estimatedTotalCost = heuristic.euclidianDistance(start);
		
		PathfindingList openList = new PathfindingList();
		openList.add( startRecord );
		PathfindingList closedList = new PathfindingList();
		
		while ( openList.list.size() > 0 ) {
			current = openList.smallestElement();
			
			if ( current.node.equals( goal ) )
				break;
			
			LinkedList<Edge> connections = getNeighbors( current.node );
			
			for ( Edge connection : connections) {
				nodesProcessed++;
				Node endNode = connection.toNode;
				int endNodeCost = current.costSoFar + connection.weight;
				
				if ( closedList.contains( endNode ) ){
					endNodeRecord = closedList.find(endNode);
					if(endNodeRecord.costSoFar <= endNodeCost)
						continue;
					closedList.remove(endNodeRecord);
					endNodeHeuristic = endNodeRecord.cost - endNodeRecord.costSoFar;
				}else if ( openList.contains( endNode ) ){
					endNodeRecord = openList.find( endNode );
					if ( endNodeRecord.costSoFar <= endNodeCost )
						continue;
					endNodeHeuristic = endNodeRecord.cost - endNodeRecord.costSoFar;
				}else{
					endNodeRecord = new NodeRecord();
					endNodeRecord.node = endNode;
					endNodeHeuristic = heuristic.euclidianDistance(endNode);
				}
				
				endNodeRecord.costSoFar = endNodeCost;
				endNodeRecord.connection = connection;
				endNodeRecord.estimatedTotalCost = endNodeCost + endNodeHeuristic;
				
				if ( !openList.contains( endNode ) )
					openList.add( endNodeRecord );
			}
			openList.remove( current );
			closedList.add( current );
		}
		
		if ( !current.node.equals( goal ) )
			System.out.println("No sol'n :( sorry ");
		else{
			while ( !current.node.equals( start ) ){
				path.add(current.connection);

				current = closedList.find( current.connection.fromNode );
			}
		}
		path = reverse(path);
		
		return path;
	}
	
	
	
	void printPath( LinkedList<Edge> path ) {
		for( Edge edge : path )
			System.out.println( "From: " + edge.fromNode.name + "  To: " +  edge.toNode.name );
	}
	
	LinkedList<Edge> reverse( LinkedList<Edge> path) {
		Stack<Edge> stack = new Stack<Edge>();
		LinkedList<Edge> soln = new LinkedList<Edge>();
		for( Edge edge : path ) {
			stack.push(edge);
		}
		while ( stack.size() > 0 )
			soln.add(stack.pop());
		return soln;
	}
	
	Node search( String name ){
		return nodes.get(name);
	}
	
	
	void createDoubleEdge( String node1name, String node2name, int x1, int y1, int x2, int y2, int weight ){
		Node node1, node2;
		if( !nodes.containsKey(node1name)){
			node1 = new Node( x1, y1, node1name );
			nodes.put(node1name, node1);
			nodeList.add(node1);
		}else{
			node1 = nodes.get(node1name);
		}
		if( !nodes.containsKey(node2name)){
			node2 = new Node( x2, y2, node2name );
			nodes.put(node2name, node2);
			nodeList.add(node2);
		}else{
			node2 = nodes.get(node2name);
		}
		
		//Create the edge with your 2 nodes
		Edge edge = new Edge();
		edge.fromNode = node1;
		edge.toNode = node2;
		edge.weight = weight;
		
		node1.neighbors.add(edge);
		edges.add(edge);
		
		
		//Create a double in the reverse
		Edge edge2 = new Edge();
		edge2.fromNode = node2;
		edge2.toNode = node1;
		edge2.weight = weight;
		
		node2.neighbors.add(edge2);
		edges.add(edge2);
	}
	
	class NodeRecord{
		Node node;
		Edge connection;
		int cost = 0;
		int costSoFar = Integer.MAX_VALUE;
		int estimatedTotalCost = 0;		
	}	


	
	LinkedList<Edge> getNeighbors( Node node ){
		return node.neighbors;
	}
	
	class Node{
		int x,y;
		String name;
		LinkedList<Edge> neighbors = new LinkedList<Edge>();
		
		public Node( int x, int y, String name ){
			this.name = name;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge {
		Node toNode, fromNode;
		int weight;
	}
	
	class PathfindingList {
		//Implementation of open and closed data structures here will result in different performance
		LinkedList<NodeRecord> list = new LinkedList<NodeRecord>();
		
		void add( NodeRecord nodeRecord ) {
			list.add( nodeRecord );
		}
		
		void remove( NodeRecord nodeRecord ) {
			list.remove( nodeRecord );
		}
		
		NodeRecord smallestElement() {
			NodeRecord smallest = new NodeRecord();
			smallest.costSoFar = Integer.MAX_VALUE;
			for ( NodeRecord node : list ) {
				if ( node.costSoFar < smallest.costSoFar )
					smallest = node;
			}
			return smallest;
		}

		
		boolean contains( Node node ) {
			for( NodeRecord nodeRecord : list ) {
				if(nodeRecord.node.equals(node))
					return true;
			}
			return false;
		}
		
		NodeRecord find( Node node) {
			for( NodeRecord nodeRecord : list ) {
				if(nodeRecord.node.equals( node ) )
					return nodeRecord;
			}
			return null;
		}
	}

	public void drawGraph(PApplet parent) {
		for ( Edge edge : edges ) {
			parent.stroke(0);
			parent.line( edge.toNode.x, edge.toNode.y, edge.fromNode.x, edge.fromNode.y );
		}
		for ( Node node : nodeList ){
			parent.fill(0);
			parent.ellipse(node.x, node.y, 10, 10);
		}
	}
}