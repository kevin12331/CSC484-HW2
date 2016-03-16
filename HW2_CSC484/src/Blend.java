
public class Blend {

	public static Steering blend( Character agent, Character target ) {
		
		Steering arriveSteering = Arrive.arrive(agent, target);
		Steering alignSteering = Align.align(agent, target);
		
		Steering blend = new Steering();

		if(alignSteering == null){
			alignSteering =  new Steering();
		}
		if( arriveSteering == null ){
			arriveSteering = new Steering(); 
		}
		
		blend.linearAcceleration = arriveSteering.linearAcceleration;
		blend.angularAcceleration = alignSteering.angularAcceleration;
		
		return blend;
	}
}
