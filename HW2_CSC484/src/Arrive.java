import processing.core.*;

public class Arrive {

	
	public static Steering arrive( Character agent, Character target ){
		
		Steering steering = new Steering();
		float radiusOfSatisfaction = 30;
		float radiusOfDeceleration = 200;
		float targetSpeed = 0;
		float timeToTarget = 40;
		float maxSpeed = agent.getMaxSpeed();
		float maxAcceleration = (float) 1;

		PVector direction = PVector.sub( target.position, agent.position );
		float distance = direction.mag();
		PVector targetVelocity = direction;
		
		if (distance < radiusOfSatisfaction ){
			targetVelocity.mult(-1);

		}
		
		else if (distance > radiusOfDeceleration)
			targetSpeed = maxSpeed;
		else
			targetSpeed = maxSpeed * distance / radiusOfDeceleration;
		
		
		targetVelocity.normalize();
		targetVelocity.mult( targetSpeed );
		steering.linearAcceleration = PVector.sub( targetVelocity, agent.velocity );
		steering.linearAcceleration.div( timeToTarget );
		
		if ( steering.linearAcceleration.mag() > maxAcceleration ) {
			steering.linearAcceleration.normalize();
			steering.linearAcceleration.mult( maxAcceleration );
		}
		
		steering.angularAcceleration = (float) 0.0;
		return steering;

	}
}
