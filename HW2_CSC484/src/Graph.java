

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import processing.core.PApplet;

class Graph {
	
	Hashtable<String, Node> nodes = new Hashtable<String, Node>();
	LinkedList<Edge> edges = new LinkedList<Edge>();
	LinkedList<Node> nodeList = new LinkedList<Node>();
	
	
	
	
	
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
	
	
	void generateLargeGraph( int numberOfEdges ) {
		Random rand = new Random();
		
		for ( int i = 0; i < numberOfEdges; i++ ) {
			this.createDoubleEdge(Integer.toString(i), Integer.toString(i+1), rand.nextInt(800), rand.nextInt(800), rand.nextInt(800), rand.nextInt(800), rand.nextInt(30));
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
		
		for( Edge edge : path )
			System.out.println( "From: " + edge.fromNode.name + "  To: " +  edge.toNode.name );
		
		return path;
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
		int costSoFar = Integer.MAX_VALUE;
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
	
	class Edge {
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
			parent.fill(0);
			parent.line( edge.toNode.x, edge.toNode.y, edge.fromNode.x, edge.fromNode.y );
		}
		for ( Node node : nodeList ){
			parent.fill(150);
			parent.ellipse(node.x, node.y, 10, 10);
		}
	}
}