package nl.hanze.leertaak2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class PopulationGenerator {
	
	private static final double FOX_CREATION_PROBABILITY = 0.02;
	private static final double RABBIT_CREATION_PROBABILITY = 0.08;
	
	private List<Actor> animals;
	
	private Map<Class, Color> colors;
	
	public PopulationGenerator(){
		animals = new ArrayList<>();
		colors = new HashMap<>();
		setColors();
	}
	
	private void setColors(){
		colors.put(Rabbit.class, Color.ORANGE);
		colors.put(Fox.class, Color.BLUE);
	}
	
	/**
	 * This method returns a Map with Classes as a Key
	 * Their value is a color that will be used in a Field
	 * @return a Map with Class as key and Color as value
	 */
	public Map<Class, Color> getColors(){
		return colors;
	}
	
	/**
	 * 
	 * @param field 
	 * @return List of animals that can be used 
	 */
	public List<Actor> populate(Field field){
		// clear the field
		field.clear();
		
		Random random = Randomizer.getRandom();
		for(int row = 0; row < field.getDepth(); row++){
			for(int col = 0; col < field.getWidth(); col++){
				if(random.nextDouble() <= FOX_CREATION_PROBABILITY){
					Location location = new Location(row, col);
					Fox fox = new Fox(true, field, location);
					animals.add(fox);
				}
				else if(random.nextDouble() <= RABBIT_CREATION_PROBABILITY){
					Location location = new Location(row, col);
					Rabbit rabbit = new Rabbit(true, field, location);
					animals.add(rabbit);
				}
				
			}
		}
		return animals;
					
	}
	
}
