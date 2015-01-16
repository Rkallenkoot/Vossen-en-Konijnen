package nl.hanze.leertaak2;

import java.util.List;

public interface Actor {

    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    void act(List<Actor> newActors);
    
    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    boolean isAlive();
    
    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    public void setDead();
	
}
