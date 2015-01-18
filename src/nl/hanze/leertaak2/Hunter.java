package nl.hanze.leertaak2;

import java.util.Iterator;
import java.util.List;

public class Hunter implements Actor {
	
    // Whether the hunter is active or not.
    private boolean active;
    // The hunter his field.
    private Field field;
    // The hunter his position in the field.
    private Location location;
    // Number of bullets the hunter has
    private int bullets;
    
    
    /** Constructor
     * Set the Hunter active and place him on the field
     * @param field
     * @param location
     */
    public Hunter(Field field, Location location)
    {
        setActive(true);
        this.field = field;
        setLocation(location);
        bullets = 99;
    }
    
    /**
     * Implements the isActive method from interface Actor
     */
    @Override
    public boolean isActive()
    {
    	return active;
    }
    
    /** 
     * Can toggle the hunter to active (true)
     * or non-active (false)
     * @param active true or false whether the hunter is active or not
     */
    public void setActive(boolean active)
    {
    	this.active = active;
    }

    
    /** what does the hunter do? **/
	@Override
	public void act(List<Actor> newActors) {
		// TODO Auto-generated method stub
		if(isActive()) {
			Location newLocation = hunt();
	           
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setActive(false);
            }
		}
	}
	
    /**
     * Kills everything he sees
     * @return Where a animal was found, or null if it wasn't.
     */
    private Location hunt()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal != null && bullets > 0)
            {
	            if(animal instanceof Rabbit) {
	                Rabbit rabbit = (Rabbit) animal;
	                if(rabbit.isAlive()) { 
	                	// shoot
	    	            bullets--;
	                    rabbit.setDead();
	                    // Remove the dead rabbit from the field.

	                    return where;
	                }
	            }
	            if(animal instanceof Fox) {
	                Fox fox = (Fox) animal;
	                if(fox.isAlive()) { 
	                	// shoot
	    	            bullets--;
	                    fox.setDead();
	                    // Remove the dead fox from the field.
	                    return where;
	                }
	            }
            }
        }
        return null;
    }	

    /**
     * Return the hunter's location.
     * @return The hunter's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the hunter at the new location in the given field.
     * @param newLocation The hunter's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the hunter's field.
     * @return The hunter's field.
     */
    protected Field getField()
    {
        return field;
    }	
}
