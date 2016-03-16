import processing.core.*;
import java.util.LinkedList;

public class Map {
	PApplet parent;
	LinkedList<PShape> obstacles = new LinkedList<PShape>();
	
	Map(PApplet parent){
		this.parent = parent;
	}
	void drawMap(){
		parent.fill(0);

		//Top and bottom walls
		obstacles.add(parent.createShape(PConstants.RECT, -1, -1, parent.width+1, 20));
		obstacles.add(parent.createShape(PConstants.RECT, -1, parent.height - 20, parent.width+1, 20));
		
		//Left and Right walls
		obstacles.add(parent.createShape(PConstants.RECT, -1, -1 , 20, parent.height + 1));
		obstacles.add(parent.createShape(PConstants.RECT, parent.width-20, -1 , 20, parent.height + 1));
		
		//Middle top
		obstacles.add(parent.createShape(PConstants.RECT, parent.width/2, 0 , 10, parent.height/3 + 25));

		//Middle bottom
		obstacles.add(parent.createShape(PConstants.RECT, parent.width/2, parent.height , 10, -parent.height/3 - 25));
		
		for ( PShape shape : obstacles )
			parent.shape( shape );
		
	}
}
