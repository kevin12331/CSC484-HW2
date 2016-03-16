import processing.core.PVector;


public class Seek {
	
	static float maxAcceleration = (float) .1;
	
	public static Steering seek ( Character agent, Character target ) {
		
		Steering steering = new Steering();
		steering.linearAcceleration = PVector.sub( target.position, agent.position );
		steering.linearAcceleration.normalize();
		steering.linearAcceleration.mult( maxAcceleration );
		steering.angularAcceleration = 0;
		return steering;
	}
}
