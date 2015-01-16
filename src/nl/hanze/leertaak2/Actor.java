package nl.hanze.leertaak2;

import java.util.List;

public interface Actor {
	void act(List<Actor> newActors);
	boolean isActive();
}
