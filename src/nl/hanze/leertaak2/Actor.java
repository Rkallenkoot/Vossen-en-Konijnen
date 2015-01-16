package nl.hanze.leertaak2;
import java.util.List;
/**
 * Interface Actor
 * @author Iris
 *
 */

public interface Actor {
	
	/**
	 * This is what the actor does most of the time 
	 * @param newActors A list of newly spawned Actors
	 */
	void act(List<Actor> newActors);
	
	/**
	 * Returns if the Actor is active or not
	 * @return true or false
	 */
	boolean isActive();
	
	
}
