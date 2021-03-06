import processing.core.*;

public class Align {
	public static Steering align( Character agent, Character target ) {
		
		//Rotation values
		  float rotationRadiusOfSatisfaction = PConstants.PI/20;
		  float rotationRadiusOfDeceleration = PConstants.PI/4;
		  double maxAngularAcceleration = .005;
		  double maxRotation = .005;
		  float timeToTargetRotation = 100;
		  float goalRotation = 0;
	      float rotation = 0;
	      float rotationSize = 0;
	      Steering steering = new Steering();
	      
	      rotation = target.orientation - agent.orientation;
	      rotation = mapToRange( rotation );
	      
	      rotationSize = Math.abs( rotation );
	        
	      if ( rotationSize < rotationRadiusOfSatisfaction ) {
	    	agent.rotation = 0;
	        return steering;
	      } if ( rotationSize > rotationRadiusOfDeceleration ) {
	        goalRotation = (float) maxRotation;
	      }else{
	        goalRotation = (float) (maxRotation * ( rotationSize / rotationRadiusOfDeceleration ));
	      }
	        
	      goalRotation *= (rotation / Math.abs(rotation)); 
	      
	      steering.angularAcceleration = goalRotation - agent.rotation;
	      steering.angularAcceleration /= timeToTargetRotation;
	      
	      //Clip to max accel
	      float angularAcceleration = Math.abs(steering.angularAcceleration);
	      if( steering.angularAcceleration > maxAngularAcceleration ) {
	        steering.angularAcceleration /= angularAcceleration; 
	        steering.angularAcceleration *= maxAngularAcceleration;
	      }
		return steering;
	}
	
	private static float mapToRange( float rotation ) {
		
		if (rotation >  PConstants.PI)
			return rotation - ( 2 *  PConstants.PI );
		if (rotation < - PConstants.PI)
			return rotation + ( 2 *  PConstants.PI );
			
		return rotation;
	}
}
