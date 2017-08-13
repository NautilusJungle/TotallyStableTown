package stabletable.town.entities.statics;

import stabletable.town.Main.Handler;
import stabletable.town.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
	
}
