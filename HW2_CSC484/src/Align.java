import processing.core.*;

public class Align {
	public static Steering align( Character agent, Character target ) {
		
		float maxAngularAcceleration = (float) .001;
		float maxRotation = (float) .001;
		
		float radiusOfSatisfaction = PConstants.PI / 50;
		float radiusOfDeceleration = PConstants.PI / 12;
		float angularAcceleration = 0;
		
		float targetRotation = 0;
		
		float timeToTarget = (float) 50;
		
		Steering steering  = new Steering();
		
		float rotation = target.orientation - agent.orientation;
		
		rotation = mapToRange( rotation );
		float rotationSize = Math.abs( rotation );
		
		if ( rotationSize < radiusOfSatisfaction ) {

	        rotation *= -1;
		}
		else if ( rotationSize > radiusOfDeceleration ) {
			targetRotation = maxRotation;
		}
		else
			targetRotation = maxRotation * ( rotationSize / radiusOfDeceleration );
		
		targetRotation *= rotation / rotationSize;
		
		steering.angularAcceleration = targetRotation - agent.rotation;
		steering.angularAcceleration /= timeToTarget;
		angularAcceleration = Math.abs( steering.angularAcceleration );
		
		if ( steering.angularAcceleration > maxAngularAcceleration ) {
			steering.angularAcceleration /= angularAcceleration;
			steering.angularAcceleration *= maxAngularAcceleration;
		}
		steering.linearAcceleration.mult(0);
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
