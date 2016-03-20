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
		
		//obstacles
		obstacles.add(parent.createShape(PConstants.RECT, parent.width/2, 200 , 10, 400));
		obstacles.add(parent.createShape(PConstants.RECT, 200, 200 , 90, 50));
		obstacles.add(parent.createShape(PConstants.RECT, 600, 600 , 50, 90));


		
		for ( PShape shape : obstacles )
			parent.shape( shape );
		
	}
}
